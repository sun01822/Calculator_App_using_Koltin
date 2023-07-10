package com.sun.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.sun.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonC.setOnClickListener {
            binding.input.setText("")
            binding.output.setText("0")
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.output))
        }

        binding.buttonOpenBracket.setOnClickListener {
            binding.input.text = addToInputText("(")
        }

        binding.buttonCloseBracket.setOnClickListener {
            binding.input.text = addToInputText(")")
        }

        binding.buttonAc.setOnClickListener {
            val removedLast = binding.input.text.toString().dropLast(1)
            binding.input.text = removedLast
        }

        binding.button0.setOnClickListener {
            binding.input.text = addToInputText("0")
        }

        binding.button1.setOnClickListener {
            binding.input.text = addToInputText("1")
        }

        binding.button2.setOnClickListener {
            binding.input.text = addToInputText("2")
        }

        binding.button3.setOnClickListener {
            binding.input.text = addToInputText("3")
        }

        binding.button4.setOnClickListener {
            binding.input.text = addToInputText("4")
        }

        binding.button5.setOnClickListener {
            binding.input.text = addToInputText("5")
        }

        binding.button6.setOnClickListener {
            binding.input.text = addToInputText("6")
        }

        binding.button7.setOnClickListener {
            binding.input.text = addToInputText("7")
        }

        binding.button8.setOnClickListener {
            binding.input.text = addToInputText("8")
        }

        binding.button9.setOnClickListener {
            binding.input.text = addToInputText("9")
        }
        binding.buttonDot.setOnClickListener {
            binding.input.text = addToInputText(".")
        }

        binding.buttonPlus.setOnClickListener {
            binding.input.text = addToInputText("+")
        }

        binding.buttonMinus.setOnClickListener {
            binding.input.text = addToInputText("-")
        }

        binding.buttonMultiply.setOnClickListener {
            binding.input.text = addToInputText("×")
        }

        binding.buttonDivide.setOnClickListener {
            binding.input.text = addToInputText("÷")
        }

        binding.buttonEquals.setOnClickListener {
            showResult()
        }


    }
    private fun addToInputText(buttonValue : String) : String{
        return binding.input.text.toString() + "" + buttonValue
    }

    private fun getInputExpression() : String{
        var expression = binding.input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult(){
        try{
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                binding.output.text = ""
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else{
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.output))
            }
        } catch (e: Exception){
            binding.output.text = ""
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

}