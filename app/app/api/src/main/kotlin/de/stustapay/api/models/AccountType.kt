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


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 
 *
 * Values: `private`,saleExit,cashEntry,cashExit,cashTopupSource,cashImbalance,cashVault,sumupEntry,sumupOnlineEntry,transport,cashier,voucherCreate
 */
@Serializable
enum class AccountType(val value: kotlin.String) {

    @SerialName(value = "private")
    `private`("private"),

    @SerialName(value = "sale_exit")
    saleExit("sale_exit"),

    @SerialName(value = "cash_entry")
    cashEntry("cash_entry"),

    @SerialName(value = "cash_exit")
    cashExit("cash_exit"),

    @SerialName(value = "cash_topup_source")
    cashTopupSource("cash_topup_source"),

    @SerialName(value = "cash_imbalance")
    cashImbalance("cash_imbalance"),

    @SerialName(value = "cash_vault")
    cashVault("cash_vault"),

    @SerialName(value = "sumup_entry")
    sumupEntry("sumup_entry"),

    @SerialName(value = "sumup_online_entry")
    sumupOnlineEntry("sumup_online_entry"),

    @SerialName(value = "transport")
    transport("transport"),

    @SerialName(value = "cashier")
    cashier("cashier"),

    @SerialName(value = "voucher_create")
    voucherCreate("voucher_create");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is AccountType) "$data" else null

        /**
         * Returns a valid [AccountType] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): AccountType? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

