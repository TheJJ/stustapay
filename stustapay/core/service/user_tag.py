import re
from typing import Optional

import asyncpg

from stustapay.core.config import Config
from stustapay.core.schema.account import UserTagDetail
from stustapay.core.schema.user import CurrentUser, Privilege, format_user_tag_uid
from stustapay.core.service.auth import AuthService
from stustapay.core.service.common.dbservice import DBService
from stustapay.core.service.common.decorators import (
    requires_node,
    requires_user,
    with_db_transaction,
)
from stustapay.core.service.common.error import InvalidArgument
from stustapay.framework.database import Connection


class UserTagService(DBService):
    def __init__(self, db_pool: asyncpg.Pool, config: Config, auth_service: AuthService):
        super().__init__(db_pool, config)
        self.auth_service = auth_service

    @with_db_transaction
    @requires_user([Privilege.account_management])
    @requires_node()
    async def get_user_tag_detail(self, *, conn: Connection, user_tag_uid: int) -> Optional[UserTagDetail]:
        return await conn.fetch_maybe_one(
            UserTagDetail, "select * from user_tag_with_history utwh where user_tag_uid = $1", user_tag_uid
        )

    @with_db_transaction
    @requires_user([Privilege.account_management])
    @requires_node()
    async def update_user_tag_comment(
        self, *, conn: Connection, current_user: CurrentUser, user_tag_uid: int, comment: str
    ) -> UserTagDetail:
        ret = await conn.fetchval(
            "update user_tag set comment = $1 where uid = $2 returning uid", comment, user_tag_uid
        )
        if ret is None:
            raise InvalidArgument(f"User tag {format_user_tag_uid(user_tag_uid)} does not exist")

        detail = await self.get_user_tag_detail(  # pylint: disable=unexpected-keyword-arg
            conn=conn, current_user=current_user, user_tag_uid=user_tag_uid
        )
        assert detail is not None
        return detail

    @with_db_transaction
    @requires_user([Privilege.account_management])
    @requires_node()
    async def find_user_tags(self, *, conn: Connection, search_term: str) -> list[UserTagDetail]:
        value_as_int = None
        if re.match("^[A-Fa-f0-9]+$", search_term):
            value_as_int = int(search_term, base=16)

        # the following query won't be able to find full uint64 tag uids as we need cast the numeric(20) to bigint in
        # order to do hex conversion in postgres, therefore loosing one bit of information as bigint is in64 not uint64
        return await conn.fetch_many(
            UserTagDetail,
            "select * from user_tag_with_history where to_hex(user_tag_uid::bigint) like $1 or user_tag_uid = $2",
            f"%{search_term.lower()}%",
            value_as_int,
        )
