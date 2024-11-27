package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "Resultactivity.KEY_IMC"

class Resultactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()


         val (classificacao, color) = when {

             result <= 18.5f -> "MAGREZA" to R.color.red
             result > 18.5f && result <= 24.9f -> "NORMAL" to R.color.green
             result >= 25.0f && result <= 29.9f -> "SOBREPESO" to R.color.yellow
             result >= 30f && result <= 39.9f -> "OBESIDADE" to R.color.red
             else -> "OBESIDADE GRAVE" to R.color.red
             
         }


        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(ContextCompat.getColor(this, color))









    }
}