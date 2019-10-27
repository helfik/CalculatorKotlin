package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    var one = findViewById<TextView>(R.id.one)
    var two = findViewById<TextView>(R.id.two)
    var three = findViewById<TextView>(R.id.three)
    var four = findViewById<TextView>(R.id.four)
    var five = findViewById<TextView>(R.id.five)
    var six = findViewById<TextView>(R.id.six)
    var seven = findViewById<TextView>(R.id.seven)
    var eight = findViewById<TextView>(R.id.eight)
    var nine = findViewById<TextView>(R.id.nine)
    var zero = findViewById<TextView>(R.id.zero)
    var plus = findViewById<TextView>(R.id.plus)
    var minus = findViewById<TextView>(R.id.minus)
    var multiple = findViewById<TextView>(R.id.multiple)
    var divide = findViewById<TextView>(R.id.divide)
    var expression = findViewById<TextView>(R.id.expression)
    var result = findViewById<TextView>(R.id.result)
    var clear = findViewById<TextView>(R.id.clear)
    var equal = findViewById<TextView>(R.id.equal)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
