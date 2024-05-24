package com.example.androidmonth6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidmonth6.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCounterBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[CounterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            btnInc.setOnClickListener {
                viewModel.updateCounterData(true)
            }
            btnDec.setOnClickListener {
                viewModel.updateCounterData(false)
            }

            viewModel.counterData.observe(this@CounterActivity) { result ->
                tvResult.text = result.toString()
            }
        }
    }
}
