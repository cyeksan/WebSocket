package com.example.websocket.enum

enum class Tags constructor(private val text: String) {

    TYPE_TAG(Constants.TYPE_TAG),
    CHANNEL_NAME_TAG(Constants.CHANNEL_NAME_TAG),
    PRODUCT_ID_TAG(Constants.PRODUCT_ID_TAG);

    override fun toString(): String {
        return text
    }

    object Constants {
        const val TYPE_TAG = "subscribe"
        const val CHANNEL_NAME_TAG = "ticker"
        const  val PRODUCT_ID_TAG = "BTC-USD" // In order to see Ethereum price, PRODUCT_ID_TAG = "ETH-USD"
    }
}
