package com.example.taxi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern


class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


    }

    fun btCadastrar(view: View) {
        val nomes = LabelNome.text.toString()
        val emails = LabelEmail2.text.toString()
        val senhas = LabelSenha2.text.toString()

        val validaCampos = validarCampos(nomes, emails, senhas)
        val validaNome = validarNomes(nomes)
        val validaEmail = validarEmails(emails)
        val validaSenha = validarSenhas(senhas)

        if (validaCampos) {
            if(validaNome){
                if(validaEmail){
                    if(validaSenha){


                        val nomes = LabelNome.text.toString()
                        val emails = LabelEmail2.text.toString()
                        val senhas = LabelSenha2.text.toString()





                        botaoCadastrar.setOnClickListener {
                            Toast.makeText(applicationContext, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, Login::class.java)

                            intent.putExtra("emails", emails)
                            intent.putExtra("senhas", senhas)

                            startActivity(intent)
                        }


                    }else{
                        Toast.makeText(applicationContext, "Senha inválida, mínimo de 6 caracteres, precisa ter pelo menos um caracter especial, um número, uma letra minúscula e uma letra maiúscula", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(applicationContext, "E-mail inválido", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext,"O nome precisa conter no mínimo 6 caracteres e no máximo 50 caracteres.",Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(applicationContext, "Preencha os dados primeiro", Toast.LENGTH_SHORT).show()
        }




    }

    fun validarCampos(nomes: String, emails: String, senhas: String): Boolean {

        var camposValidados: Boolean = true

        if (nomes == null || nomes.equals("")) {
            camposValidados = false
        } else if (emails == null || emails.equals("")) {
            camposValidados = false
        } else if (senhas == null || senhas.equals("")) {
            camposValidados = false
        }
        return camposValidados
    }

    fun validarNomes(nomes2: String): Boolean {

        var nomesValidado: Boolean = true

        if (nomes2.length < 6) {
            nomesValidado = false
        } else if (nomes2.length > 50) {
            nomesValidado = false
        }
        return nomesValidado
    }

    fun validarEmails(email: String?): Boolean {
        return !(email == null || TextUtils.isEmpty(email)) && Patterns.EMAIL_ADDRESS.matcher(email)
            .matches()
    }

    private fun validarSenhas(password: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }






}
