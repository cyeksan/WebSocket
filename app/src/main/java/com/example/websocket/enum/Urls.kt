package com.example.websocket.enum

enum class Urls(private val text: String) {

    WSS_URL(Constants.WSS_URL);


    override fun toString(): String {
        return text
    }

    object Constants {
        const val WSS_URL = "wss://ws-feed.gdax.com"
    }
}