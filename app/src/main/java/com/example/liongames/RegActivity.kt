package com.example.liongames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegActivity : AppCompatActivity() {

    val pattern=("[a-zA-Z0-6]{1,30}" + "@" + "[a-z]{1,8}" + "\\." + "[a-z]{1,5}")

    lateinit var mail:EditText
    lateinit var pass:EditText
    lateinit var repass:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_activity)
        mail = findViewById(R.id.EditText_login)
        pass = findViewById(R.id.EditText_password)
        repass = findViewById(R.id.EditText_password2)
    }

    fun emailValid(text:String):Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }

   fun next5(view: View) {

    if (mail.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty()&&repass.text.toString().isNotEmpty())
    {   if (emailValid(mail.text.toString()))
        {
            if (pass.text.toString()==repass.text.toString())
            {
                if (pass.text.toString().length >= 4)
                {
                    Toast.makeText(this, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@RegActivity, PatchActivity::class.java)
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
                Toast.makeText(this, "Пароли должны совпадать", Toast.LENGTH_SHORT).show()
                }
        }
        else
            {
            Toast.makeText(this, "Ошибка при заполнении поля E-mail", Toast.LENGTH_SHORT).show()
            }
    }
    else
        {
        Toast.makeText(this, "Все поля должны быть заполненны", Toast.LENGTH_SHORT).show()
        }
    }




    fun back(view: View) {
        val intent = Intent(this@RegActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}