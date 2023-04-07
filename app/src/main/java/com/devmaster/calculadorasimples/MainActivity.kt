package com.devmaster.calculadorasimples

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devmaster.calculadorasimples.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var value1 = 0.0
    private var value2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonSoma.setOnClickListener(this)
        binding.buttonSubtracao.setOnClickListener(this)
        binding.buttonMultiplicacao.setOnClickListener(this)
        binding.buttonDivisao.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (binding.editTextValue1.text.toString() != "" || binding.editTextValue2.text.toString() != "") {
            value1 = binding.editTextValue1.text.toString().toDouble()
            value2 = binding.editTextValue2.text.toString().toDouble()

            when (v.id) {
                R.id.button_soma -> {
                    binding.textResultado.text = (value1 + value2).toString()
                }
                R.id.button_subtracao -> {
                    if (value1 >= value2) binding.textResultado.text = (value1 - value2).toString()
                    else binding.textResultado.text = (value2 - value1).toString()
                }
                R.id.button_multiplicacao -> {
                    binding.textResultado.text = (value1 * value2).toString()
                }
                R.id.button_divisao -> {
                    if (value1 >= value2) binding.textResultado.text = (value1 / value2).toString()
                    else binding.textResultado.text = (value2 / value1).toString()
                }
            }
        } else Toast.makeText(this, "Informar valor", Toast.LENGTH_SHORT).show()
    }
}