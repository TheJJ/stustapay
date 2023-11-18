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
 * @param uuid 
 * @param customerTagUid 
 * @param amount 
 * @param customerAccountId 
 * @param oldBalance 
 * @param newBalance 
 */
@Serializable

data class PendingPayOut (

    @Contextual @SerialName(value = "uuid")
    val uuid: java.util.UUID,

    @SerialName(value = "customer_tag_uid")
    val customerTagUid: kotlin.Int,

    @Contextual @SerialName(value = "amount")
    val amount: java.math.BigDecimal,

    @SerialName(value = "customer_account_id")
    val customerAccountId: kotlin.Int,

    @Contextual @SerialName(value = "old_balance")
    val oldBalance: java.math.BigDecimal,

    @Contextual @SerialName(value = "new_balance")
    val newBalance: java.math.BigDecimal

)

