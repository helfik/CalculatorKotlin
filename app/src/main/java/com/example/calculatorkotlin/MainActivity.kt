package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val one = findViewById<TextView>(R.id.one)
        val two = findViewById<TextView>(R.id.two)
        val three = findViewById<TextView>(R.id.three)
        val four = findViewById<TextView>(R.id.four)
        val five = findViewById<TextView>(R.id.five)
        val six = findViewById<TextView>(R.id.six)
        val seven = findViewById<TextView>(R.id.seven)
        val eight = findViewById<TextView>(R.id.eight)
        val nine = findViewById<TextView>(R.id.nine)
        val zero = findViewById<TextView>(R.id.zero)
        val plus = findViewById<TextView>(R.id.plus)
        val minus = findViewById<TextView>(R.id.minus)
        val multiple = findViewById<TextView>(R.id.multiple)
        val divide = findViewById<TextView>(R.id.divide)
        val expression = findViewById<TextView>(R.id.expression)
        val result = findViewById<TextView>(R.id.result)
        val clear = findViewById<TextView>(R.id.clear)
        val equal = findViewById<TextView>(R.id.equal)

        one.setOnClickListener { appendOnExpresstion("1", true) }
        two.setOnClickListener { appendOnExpresstion("2", true) }
        three.setOnClickListener { appendOnExpresstion("3", true) }
        four.setOnClickListener { appendOnExpresstion("4", true) }
        five.setOnClickListener { appendOnExpresstion("5", true) }
        six.setOnClickListener { appendOnExpresstion("6", true) }
        seven.setOnClickListener { appendOnExpresstion("7", true) }
        eight.setOnClickListener { appendOnExpresstion("8", true) }
        nine.setOnClickListener { appendOnExpresstion("9", true) }
        zero.setOnClickListener { appendOnExpresstion("0", true) }

        plus.setOnClickListener { appendOnExpresstion("+", false) }
        minus.setOnClickListener { appendOnExpresstion("-", false) }
        multiple.setOnClickListener { appendOnExpresstion("*", false) }
        divide.setOnClickListener { appendOnExpresstion("/", false) }

        clear.setOnClickListener {
            expression.text = ""
            result.text = ""
        }

        equal.setOnClickListener {
            try {

                val expressionR = ExpressionBuilder(expression.text.toString()).build()
                val resultR = expressionR.evaluate()
                val longResult = resultR.toLong()
                if(resultR == longResult.toDouble())
                    result.text = longResult.toString()
                else
                    result.text = resultR.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        val expression = findViewById<TextView>(R.id.expression)
        val result = findViewById<TextView>(R.id.result)

        if(result.text.isNotEmpty()){
            expression.text = ""
        }

        if (canClear) {
            result.text = ""
            expression.append(string)
        } else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }


}
