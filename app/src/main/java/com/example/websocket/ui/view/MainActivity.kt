package com.example.websocket.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.websocket.R
import com.example.websocket.ui.model.Response
import com.example.websocket.ui.presenter.DataPresenter
import com.example.websocket.ui.presenter.IDataPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), IDataPresenter {

    private var price: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)

        id.setOnClickListener {

            DataPresenter(this@MainActivity, this@MainActivity)

        }
    }

    override fun success(response: Response) {

        price = response.price
        if (price != null && price != "null")
            textView.text = "Bitcoin price: $price"
    }

    override fun error(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}


