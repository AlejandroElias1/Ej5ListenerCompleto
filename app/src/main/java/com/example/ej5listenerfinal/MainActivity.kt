package com.example.ej5listenerfinal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.ej5listenerfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actboton(binding)
        anadirtext(binding)
        tag(binding)
    }

    fun actboton(binding: ActivityMainBinding){
        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.editTextTextPersonName.text
                        .isNotEmpty() && binding.editTextTextPersonName2.text
                        .isNotEmpty()
                ) {
                    binding.button.isEnabled = true
                } else {
                    binding.button.isEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.editTextTextPersonName2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.editTextTextPersonName2.text
                        .isNotEmpty() && binding.editTextTextPersonName2.text
                        .isNotEmpty()
                ) {
                    binding.button.isEnabled = true
                } else {
                    binding.button.isEnabled = false
                }

            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        }


    fun anadirtext(binding: ActivityMainBinding){
        binding.button.setOnClickListener {
            binding.editTextTextPersonName.setText(binding.editTextTextPersonName.text.toString() + binding.editTextTextPersonName2.text.toString())
            binding.editTextTextPersonName2.text.clear()
        }
    }
    fun tag(binding: ActivityMainBinding){
        binding.editTextTextPersonName2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textView.text= binding.editTextTextPersonName2.tag.toString()
            }
        }
        binding.editTextTextPersonName.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textView.text= binding.editTextTextPersonName.tag.toString()
            }
        }
    }
    }
