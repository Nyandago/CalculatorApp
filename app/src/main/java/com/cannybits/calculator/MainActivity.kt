package com.cannybits.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

var _allowDots : Boolean = true
var _allowMinus : Boolean = true


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btNumberEvent(view: View){

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
               if(_allowMinus) {
                   btClickValue = "-$btClickValue"
                   _allowMinus = false
               }

           }

           btDot.id -> {
               if(_allowDots) {
                   btClickValue += "."
                   _allowDots = false
               }
           }

        }
        etDisplay.setText(btClickValue)
    }
}