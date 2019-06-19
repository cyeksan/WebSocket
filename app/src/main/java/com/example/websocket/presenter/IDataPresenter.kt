package com.example.websocket.presenter

import com.example.websocket.model.Response

interface IDataPresenter {

    fun success(response: Response)
    fun error(msg: String)
}