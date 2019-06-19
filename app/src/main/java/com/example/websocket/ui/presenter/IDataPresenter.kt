package com.example.websocket.ui.presenter

import com.example.websocket.ui.model.Response

interface IDataPresenter {

    fun success(response: Response)
    fun error(msg: String)
}