package com.devmaster.calculadorasimples

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devmaster.calculadorasimples.databinding.ActivityMainBinding

private const val SOMA = "Soma"

private const val SUBTRACAO = "Subtração"

private const val MULTIPLICACAO = "Multiplicação"

private const val DIVISAO = "Divisão"

private const val SELECIONE = "Selecione uma operação"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        loadSpinner()

        binding.buttonCalcular.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calcular) {
            val operacao = binding.spinnerOperacoes.selectedItem
            if (operacao != SELECIONE) {
                val val1 = binding.editTextValue1.text.toString().toInt()
                val val2 = binding.editTextValue2.text.toString().toInt()
                if (val1.toString() == "" || val2.toString() == "") Toast.makeText(
                    this,
                    "Faltou informat valor",
                    Toast.LENGTH_SHORT
                ).show()
                else {
                    when (operacao) {
                        SOMA -> {
                            binding.textResultado.text = (val1 + val2).toString()
                        }
                        SUBTRACAO -> {
                            if (val1 >= val2) binding.textResultado.text = (val1 - val2).toString()
                            else binding.textResultado.text = (val2 - val1).toString()
                        }
                        MULTIPLICACAO -> {
                            binding.textResultado.text = (val1 * val2).toString()
                        }
                        DIVISAO -> {
                            if (val1 >= val2) binding.textResultado.text = (val1 / val2).toString()
                            else binding.textResultado.text = (val2 / val1).toString()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Selecione uma opeção", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun loadSpinner() {
        val list = listOf(SELECIONE, SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO)
        val adapetr = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
        binding.spinnerOperacoes.adapter = adapetr
    }

}