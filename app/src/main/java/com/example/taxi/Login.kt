package com.example.taxi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val dados : Bundle? = intent.extras
        val emails = dados?.getString("emails")
        val senhas = dados?.getString("senhas")


        botaoEntrar.setOnClickListener {

            if(LabelEmail.text.toString() == emails){
                if(LabelSenha.text.toString() == senhas){

                    Toast.makeText(applicationContext, "Login efetuado com sucesso!.", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)

                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext, "Senha inválida.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext, "E-mail não cadastrado.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}