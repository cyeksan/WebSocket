package com.example.websocket.enum

enum class Codes(private val code: Int) {

    NORMAL_CLOSURE_CODE(Constants.NORMAL_CLOSURE_CODE);

    object Constants {
        const val NORMAL_CLOSURE_CODE = 1000
    }
}