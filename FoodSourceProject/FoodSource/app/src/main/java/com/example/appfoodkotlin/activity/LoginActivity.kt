package com.example.appfoodkotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.appfoodkotlin.R
import com.example.foodkotlin.App.Base

class LoginActivity : AppCompatActivity() {

    lateinit var edName: EditText
    lateinit var edPhone: EditText
    lateinit var btnLogin: Button

    var name: String? = null
    var phone: String? = null

    var login: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edName = findViewById(R.id.ed_name)
        edPhone = findViewById(R.id.ed_phone)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            name = edName.text.toString()
            phone = edPhone.text.toString()

            if (name!!.isEmpty()) {
                Toast.makeText(this, "لطفا نام خود را وارد کنید", Toast.LENGTH_LONG).show()
            } else if (phone!!.isEmpty()) {
                Toast.makeText(this, "لطفا شماره خود را وارد کنید", Toast.LENGTH_LONG).show()
            } else {
                login()
            }
        }
    }

    private fun login() {
        login = !login
        Base.sharedPref!!.setName(name!!)
        Base.sharedPref!!.setPhone(phone!!)
        Base.sharedPref!!.setLogin(login)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}