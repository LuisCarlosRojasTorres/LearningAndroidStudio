package com.redtowersoft.s8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonAbrir : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonAbrir = findViewById(R.id.button_newActivity)

        buttonAbrir.setOnClickListener {
            val intent  = Intent(this,
                dummyActivity::class.java)

            /*
            intent.putExtra("dummy_double",73.90)
            intent.putExtra("dummy_int",4888)
            intent.putExtra("dummy_string","This is a Message from MainActivity")
            */
            val dummyPerson = DummyPerson("Rufa", "VonRufinstein", 12)

            intent.putExtra("person", dummyPerson)

            startActivity(intent)
        }
        Log.i("lifecycle_lobo","OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle_lobo","OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle_lobo","OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle_lobo","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle_lobo","OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifecycle_lobo","OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifecycle_lobo","OnRestart")
    }
}