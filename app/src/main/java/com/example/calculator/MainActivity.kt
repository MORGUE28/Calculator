package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_0 = findViewById<AppCompatButton>(R.id.btn_0)
        val btn_1 = findViewById<AppCompatButton>(R.id.btn_1)
        val btn_2 = findViewById<AppCompatButton>(R.id.btn_2)
        val btn_3 = findViewById<AppCompatButton>(R.id.btn_3)
        val btn_4 = findViewById<AppCompatButton>(R.id.btn_4)
        val btn_5 = findViewById<AppCompatButton>(R.id.btn_5)
        val btn_6 = findViewById<AppCompatButton>(R.id.btn_6)
        val btn_7 = findViewById<AppCompatButton>(R.id.btn_7)
        val btn_8 = findViewById<AppCompatButton>(R.id.btn_8)
        val btn_9 = findViewById<AppCompatButton>(R.id.btn_9)
        val btn_add = findViewById<AppCompatButton>(R.id.btn_add)
        val btn_dif = findViewById<AppCompatButton>(R.id.btn_dif)
        val btn_prdt = findViewById<AppCompatButton>(R.id.btn_prdt)
        val btn_div = findViewById<AppCompatButton>(R.id.btn_div)
        val btn_dec = findViewById<AppCompatButton>(R.id.btn_dec)
        val btn_clr = findViewById<AppCompatButton>(R.id.btn_clr)
        val btn_bktL = findViewById<AppCompatButton>(R.id.btn_bktL)
        val btn_bktR = findViewById<AppCompatButton>(R.id.btn_bktR)
        val btn_calc = findViewById<AppCompatButton>(R.id.btn_calc)
        val input = findViewById<TextView>(R.id.input)
        val output = findViewById<TextView>(R.id.output)

        btn_clr.setOnClickListener {
            input.text=""
            output.text=""
        }
        btn_bktL.setOnClickListener{
            input.text=addtoinputtext("(",input)
        }
        btn_bktR.setOnClickListener{
            input.text=addtoinputtext(")",input)
        }
        btn_0.setOnClickListener{
            input.text=addtoinputtext("0",input)
        }
        btn_1.setOnClickListener{
            input.text=addtoinputtext("1",input)
        }
        btn_2.setOnClickListener{
            input.text=addtoinputtext("2",input)
        }
        btn_3.setOnClickListener{
            input.text=addtoinputtext("3",input)
        }
        btn_4.setOnClickListener{
            input.text=addtoinputtext("4",input)
        }
        btn_5.setOnClickListener{
            input.text=addtoinputtext("5",input)
        }
        btn_6.setOnClickListener{
            input.text=addtoinputtext("6",input)
        }
        btn_7.setOnClickListener{
            input.text=addtoinputtext("7",input)
        }
        btn_8.setOnClickListener{
            input.text=addtoinputtext("8",input)
        }
        btn_9.setOnClickListener{
            input.text=addtoinputtext("9",input)
        }
        btn_dec.setOnClickListener{
            input.text=addtoinputtext(".",input)
        }
        btn_add.setOnClickListener{
            input.text=addtoinputtext("+",input)
        }
        btn_dif.setOnClickListener{
            input.text=addtoinputtext("-",input)
        }
        btn_prdt.setOnClickListener{
            input.text=addtoinputtext("×",input)
        }
        btn_div.setOnClickListener{
            input.text=addtoinputtext("÷",input)
        }
        btn_calc.setOnClickListener{
            calc(input,output)
        }

    }

    private fun addtoinputtext(btnval: String, input:TextView):String {
        return "${input.text}$btnval"
    }
    private fun retval(input: TextView):String{
        var expression = input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }
    private fun calc(input: TextView,output:TextView){
        val finalexp = retval(input)
        val result = Expression(finalexp).calculate()
        output.text = DecimalFormat("0.######").format(result).toString()
    }
}