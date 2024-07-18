package com.redtowersoft.s7alcoholougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool : TextInputLayout
    private lateinit var textInputGasolina : TextInputLayout

    private lateinit var editAlcool : TextInputEditText
    private lateinit var editGasolina : TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarComponentesInterface()
        btnCalcular.setOnClickListener{
            calcularMelhorPreco()
        }


    }

    private fun calcularMelhorPreco() {
        // Primeiro recuperar o preco da gaolina
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        // Segundo validar o preco, esta funcao retorna um booleano
        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)

        if(resultadoValidacao){
            val resultado = precoAlcool.toDouble()/precoGasolina.toDouble()

            if( resultado >= 0.7 )
            {
                textResultado.text = "Melhor Gasolina"
            }else
            {
                textResultado.text = "Melhor Alcohol"
            }
        }


    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

            if (pAlcool.isEmpty()) {
            // este campo aparece embaixo dos textinput em vermelho
            textInputAlcool.error = "Digite o preco do alcool"
            return false
        } else if (pGasolina.isEmpty()) {
            // este campo aparece embaixo dos textinput em vermelho
            textInputGasolina.error = "Digite o preco da gasolina"
            return false
        }
        return true
    }

    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editAlcool = findViewById(R.id.edit_alcool)
        editGasolina = findViewById(R.id.edit_gasolina)
        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)
    }


}