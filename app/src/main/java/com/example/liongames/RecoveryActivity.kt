package com.example.liongames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RecoveryActivity : AppCompatActivity() {
    lateinit var mail:EditText

    val pattern=("[a-zA-Z0-6]{1,30}" + "@" + "[a-z]{1,8}" + "\\." + "[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)
        mail = findViewById(R.id.EditText_login)
    }
    fun emailValid(text:String):Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun next7(view: View)
    {
        if (mail.text.toString().isNotEmpty())
        {

            if (emailValid(mail.text.toString()))
            {
                Toast.makeText(this, "Пароль успешно отправлен на Ваш E-mail", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RecoveryActivity, RecoveryokActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
                {
                Toast.makeText(this, "Ошибка при заполнении поля E-mail", Toast.LENGTH_SHORT).show()
                }
        }
        else
            {
            Toast.makeText(this, "Введите Ваш E-mail для восстановления", Toast.LENGTH_SHORT).show()
            }
    }

    fun back2(view: View)
        {
        val intent = Intent(this@RecoveryActivity, SigninActivity::class.java)
        startActivity(intent)
        finish()
        }
}