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
 * @param cashierTagUid 
 * @param amount 
 */
@Serializable

data class CashierAccountChangePayload (

    @SerialName(value = "cashier_tag_uid")
    val cashierTagUid: kotlin.Int,

    @Contextual @SerialName(value = "amount")
    val amount: java.math.BigDecimal

)

