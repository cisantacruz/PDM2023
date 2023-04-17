package com.example.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textResult: TextView
    private lateinit var fivecentButton: ImageButton
    private lateinit var tencentButton: ImageButton
    private lateinit var quatercentButton: ImageButton
    private lateinit var dollarButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding()
        setListeners()
    }

    private fun binding(){
        textResult = findViewById(R.id.textResult)
        fivecentButton = findViewById(R.id.fivecentButton)
        tencentButton = findViewById(R.id.tencentButton)
        quatercentButton = findViewById(R.id.quatercentButton)
        dollarButton = findViewById(R.id.dollarButton)
    }

    private fun setListeners(){
        var acumulado = textResult.text.toString()

        fivecentButton.setOnClickListener{
            val coin = 0.05
            val calculo = sumaCoin(acumulado.toDouble(), coin)
            acumulado = String.format("%.2f", calculo)
            textResult.text = acumulado
        }

        tencentButton.setOnClickListener{
            val coin = 0.10
            val calculo = sumaCoin(acumulado.toDouble(), coin)
            acumulado = String.format("%.2f", calculo)
            textResult.text = acumulado
        }

        quatercentButton.setOnClickListener{
            val coin = 0.25
            val calculo = sumaCoin(acumulado.toDouble(), coin)
            acumulado = String.format("%.2f", calculo)
            textResult.text = acumulado
        }

        dollarButton.setOnClickListener{
            val coin = 1.00
            val calculo = sumaCoin(acumulado.toDouble(), coin)
            acumulado = String.format("%.2f", calculo)
            textResult.text = acumulado
        }
    }

    private fun sumaCoin(result: Double, coin: Double): Double {
        return result + coin
    }
}