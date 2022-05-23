package com.example.taxi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoLogin.setOnClickListener {

            val intent = Intent(this, Login::class.java)

            startActivity(intent)
        }

        botaoCadastro.setOnClickListener {

            val intent = Intent(this, Cadastro::class.java)

            startActivity(intent)
        }
    }
}