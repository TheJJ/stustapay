/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package de.stustapay.api.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * 
 *
 * @param userTagUid 
 * @param accountId 
 * @param mappingWasValidUntil 
 * @param userTagUidHex 
 * @param comment 
 */
@Serializable

data class UserTagHistoryEntry (

    @SerialName(value = "user_tag_uid")
    val userTagUid: kotlin.Int,

    @SerialName(value = "account_id")
    val accountId: kotlin.Int,

    @Contextual @SerialName(value = "mapping_was_valid_until")
    val mappingWasValidUntil: java.time.OffsetDateTime,

    @SerialName(value = "user_tag_uid_hex")
    val userTagUidHex: kotlin.String?,

    @SerialName(value = "comment")
    val comment: kotlin.String? = null

)

