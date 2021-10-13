package com.e.kotlin_calculattip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.kotlin_calculattip.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Calculatebutton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val costString=binding.costOfService.text.toString()
        if(costString==null){
            binding.money.text=""
            return
        }
        val cost=costString.toDouble()
        val percentage=when(binding.tipOptions.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip=percentage*cost
        if (binding.RoundUp1.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        val TipAmount=NumberFormat.getCurrencyInstance().format(tip)
        binding.money.text=getString(R.string.tip_amount,TipAmount)

    }
}