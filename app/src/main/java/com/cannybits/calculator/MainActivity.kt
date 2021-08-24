package com.cannybits.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

var mAllowDots : Boolean = true
var mAllowMinus : Boolean = true
var mOperator : String = ""
var mOldNumber : String = ""
var mIsNewOperation : Boolean = true


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btNumberEvent(view: View){
        if(mIsNewOperation){
            etDisplay.setText("")
        }
            false.also { mIsNewOperation = it }         //to false


        val enteredData = etDisplay.text
        val btSelect = view as Button
        var btClickValue: String = enteredData.toString()

        when(btSelect.id){
           bt0.id -> {btClickValue += "0"}
           bt1.id -> {btClickValue += "1"}
           bt2.id -> {btClickValue += "2"}
           bt3.id -> {btClickValue += "3"}
           bt4.id -> {btClickValue += "4"}
           bt5.id -> {btClickValue += "5"}
           bt6.id -> {btClickValue += "6"}
           bt7.id -> {btClickValue += "7"}
           bt8.id -> {btClickValue += "8"}
           bt9.id -> {btClickValue += "9"}
           btPlusMinus.id -> {
                if(mAllowMinus) {
                         btClickValue = "-$btClickValue"
                         mAllowMinus = false
                     }


           }

           btDot.id -> {
               if(mAllowDots) {
                   btClickValue += "."
                   mAllowDots = false
               }
           }

        }
        etDisplay.setText(btClickValue)
    }

    fun btOperationEvent(view: View){
        val btSelected = view as Button
        when(btSelected.id){
            btMinus.id -> {
                mOperator = "-"
            }
            btPlus.id -> {
                mOperator = "+"
            }
            btDivision.id -> {
                mOperator = "/"
            }
            btMultiply.id -> {
                mOperator = "*"
            }
        }
            mOldNumber = etDisplay.text.toString()
            true.also { mIsNewOperation = it }  //new operation setting to true
            true.also { mAllowMinus = it } //negative num to the second operation to true
            true.also { mAllowDots = it } //allow dots to the second operation to true
    }

    fun btEqualEvent(view: View){
        try {
            val newNumber = etDisplay.text.toString()
            var answer : Double? = null

            when(mOperator){
                "+" -> { answer = mOldNumber.toDouble() + newNumber.toDouble() }
                "*" -> { answer = mOldNumber.toDouble() * newNumber.toDouble() }
                "-" -> { answer = mOldNumber.toDouble() - newNumber.toDouble() }
                "/" -> { answer = mOldNumber.toDouble() / newNumber.toDouble() }

            }
            etDisplay.setText("$mOldNumber $mOperator $newNumber = $answer")
            mIsNewOperation = true
        }  catch (ex: Exception){
            Toast.makeText(this,ex.message,Toast.LENGTH_LONG).show()
        }

    }

    fun btPercentEvent(view: View){
        try {
            val num = etDisplay.text.toString().toDouble() / 100
            etDisplay.setText("$num %")
        } catch (ex: Exception){
            Toast.makeText(this,ex.message,Toast.LENGTH_LONG).show()
        }
    }
    fun btClearScreen(view: View){
       try {
           etDisplay.setText("")
           true.also { mIsNewOperation = it }  //new operation setting to true
           true.also { mAllowMinus = it } //negative num to the second operation to true
           true.also { mAllowDots = it } //allow dots to the second operation to true
       }catch (ex: Exception){
           Toast.makeText(this,ex.message,Toast.LENGTH_LONG).show()
       }
    }

}