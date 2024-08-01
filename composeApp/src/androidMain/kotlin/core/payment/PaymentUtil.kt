package core.payment

import android.content.Context
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.Wallet
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

private val baseRequest = JSONObject()
    .put("apiVersion", 2)
    .put("apiVersionMinor", 0)

val allowedPaymentMethods = """
            [
              {
                "type": "CARD",
                "parameters": {
                  "allowedAuthMethods": ["PAN_ONLY", "CRYPTOGRAM_3DS"],
                  "allowedCardNetworks": ["MASTERCARD", "VISA"]
                },
                "tokenizationSpecification": {
                  "type": "PAYMENT_GATEWAY",
                  "parameters": {
                    "gateway": "stripe"
                    "stripe:version": "2018-10-31"
                    "stripe:publishableKey": "pk_live_51PfVMsBEMqA5H9TGOjktoLcKPXQFUT9RMWn1I10MO0Ecja01EkLL54KAhOJQwex4dXPAAqI0fPDAN1NGyTUfgbgi00LhDmzBpj"
                  }
                }
              }
            ]
        """.trimIndent()



fun createPaymentsClient(context: Context): PaymentsClient {
    val walletOptions = Wallet.WalletOptions.Builder()
        .setEnvironment(2)
        .build()

    return Wallet.getPaymentsClient(context, walletOptions)
}

private fun getTransactionInfo(price: String): JSONObject =
    JSONObject()
        .put("totalPrice", price)
        .put("totalPriceStatus", "FINAL")
        .put("countryCode", "MXN")
        .put("currencyCode", "MXN")

private val merchantInfo: JSONObject =
    JSONObject().put("merchantName", "FifthEssence")

fun getPaymentDataRequest(priceCents: Long): JSONObject =
    baseRequest
        .put("allowedPaymentMethods", allowedPaymentMethods)
        .put("transactionInfo", getTransactionInfo(priceCents.toString()))
        .put("merchantInfo", merchantInfo)
        .put("shippingAddressRequired", true)
        .put(
            "shippingAddressParameters", JSONObject()
                .put("phoneNumberRequired", false)
                .put("allowedCountryCodes", JSONArray(listOf("US", "GB")))
        )


//fun getLoadPaymentDataTask(priceCents: Long): Task<PaymentData> {
//    val paymentDataRequestJson = getPaymentDataRequest(priceCents)
//    val request = PaymentDataRequest.fromJson(paymentDataRequestJson.toString())
//    return paymentsClient.loadPaymentData(request)
//}