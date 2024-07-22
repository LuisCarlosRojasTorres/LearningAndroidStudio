package com.redtowersoft.s8

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class dummyActivity : AppCompatActivity() {

    lateinit var buttonCerrar : Button
    lateinit var txtDummy : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dummy)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonCerrar = findViewById(R.id.button_go_back)
        txtDummy = findViewById(R.id.txt_dummy)


        val bundle = intent.extras // Aqui tem todos os parametros adicionados com PutExtra
        if( bundle != null)
        {
            /*
            val dummy_message = bundle.getString("dummy_string")
            val dummy_int = bundle.getInt("dummy_int")
            val dummy_double = bundle.getDouble("dummy_double")

            val result = "Msg: $dummy_message , Int: $dummy_int , double: $dummy_double"
            */

            val person = if( Build.VERSION.SDK_INT >= 33){
                bundle.getParcelable("person", DummyPerson::class.java)
            }else{
                bundle.getParcelable("person")
            }

            val result = "Name: ${person?.name} , Sobrenome: ${person?.surname}  , Idade: ${person?.age} "
            txtDummy.text = result
        }

        buttonCerrar.setOnClickListener {
            finish()
        }
    }
}