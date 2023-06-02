package com.example.liongames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class SigninActivity : AppCompatActivity() {
    lateinit var mail:EditText
    lateinit var pass:EditText

    val pattern=("[a-zA-Z0-6]{1,30}" + "@" + "[a-z]{1,8}" + "\\." + "[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        mail=findViewById(R.id.EditText_login)
        pass=findViewById(R.id.EditText_password)
    }

    fun emailValid(text:String):Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun next3(view: View) {
        if (mail.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty())
        {
            if (emailValid(mail.text.toString()))
            {
                if (pass.text.toString().length >= 4)
                {
                    Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SigninActivity, PatchActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                    {
                    Toast.makeText(this, "Минимальная длина пароля 4 символа", Toast.LENGTH_SHORT).show()
                    }

            }
            else
                {
                Toast.makeText(this,"Ошибка при заполнении поля логин или email",Toast.LENGTH_SHORT).show()
                }
        }
        else
            {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
    }

    fun next4(view: View) {
        val intent = Intent(this@SigninActivity, RecoveryActivity::class.java)
        startActivity(intent)
        finish()
    }
}