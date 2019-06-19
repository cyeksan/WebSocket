package com.example.websocket.presenter

import android.content.Context
import com.example.websocket.R
import com.example.websocket.enum.Codes
import com.example.websocket.enum.Tags
import com.example.websocket.enum.Urls
import com.example.websocket.model.Channels
import com.example.websocket.model.Response
import com.example.websocket.model.Send
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class DataPresenter(
    val context: Context,
    private val iDataPresenter: IDataPresenter
) {
    private val gdaxUrl = Urls.Constants.WSS_URL

    init {

        getCoinPrice()

    }

    private fun getCoinPrice() {
        val okHttpClient = OkHttpClient()
        val requestCoinPrice: Request = Request.Builder().url(gdaxUrl).build()

        val sendModel = Send().apply {

            type = Tags.Constants.TYPE_TAG
            channels = ArrayList<Channels>().apply {

                add(Channels().apply {

                    name = Tags.Constants.CHANNEL_NAME_TAG
                    product_ids = java.util.ArrayList<String>().apply {

                        add(Tags.Constants.PRODUCT_ID_TAG)
                    }
                })

            }
        }

        val webSocketListenerCoinPrice: WebSocketListener = object : WebSocketListener() {

            override fun onOpen(webSocket: WebSocket, response: okhttp3.Response) {
                webSocket.send(Gson().toJson(sendModel))
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                iDataPresenter.success(Gson().fromJson(text, Response::class.java))
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                webSocket.close(Codes.Constants.NORMAL_CLOSURE_CODE, null)
                webSocket.cancel()
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {

            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: okhttp3.Response?) {

                iDataPresenter.error(context.resources.getString(R.string.an_error_occurred))

            }
        }
        okHttpClient.newWebSocket(requestCoinPrice, webSocketListenerCoinPrice)
        okHttpClient.dispatcher().executorService()
    }
}