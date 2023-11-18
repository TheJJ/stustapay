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
 * @param bookedAt 
 * @param cashierId 
 * @param tillId 
 */
@Serializable

data class CompletedPayOut (

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
    val newBalance: java.math.BigDecimal,

    @Contextual @SerialName(value = "booked_at")
    val bookedAt: java.time.OffsetDateTime,

    @SerialName(value = "cashier_id")
    val cashierId: kotlin.Int,

    @SerialName(value = "till_id")
    val tillId: kotlin.Int

)

