package com.gocheck.com.kidscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var addition = false
    var substraction = false
    var multiplication = false
    var division = false

    var value1 = 0
    var value2 = 0
    var answer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            inputDisplay.text = savedInstanceState.getString("inputValues")
            displayText.text = savedInstanceState.getString("display")
            ansText.text = savedInstanceState.getString("answerText")
            value1 = savedInstanceState.getInt("value1", 0)
            value2 = savedInstanceState.getInt("value2", 0)
            answer = savedInstanceState.getInt("answer", 0)
        }

        clickDigits()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("inputValues", inputDisplay.text.toString())
        outState.putString("display", displayText.text.toString())
        outState.putString("answerText", ansText.text.toString())
        outState.putInt("value1", value1)
        outState.putInt("value2", value2)
        outState.putInt("answer", answer)
    }

    private fun clickDigits(){

        oneButton.setOnClickListener {
            val one = oneButton.text.toString()
            inputDisplay.append(one)
        }

        twoButton.setOnClickListener {
            inputDisplay.append(twoButton.text.toString())
        }

        threeButton.setOnClickListener {
            inputDisplay.append(threeButton.text.toString())
        }

        fourButton.setOnClickListener {
            inputDisplay.append(fourButton.text.toString())
        }

        fiveButton.setOnClickListener {
            inputDisplay.append(fiveButton.text.toString())
        }

        sixButton.setOnClickListener {
            inputDisplay.append(sixButton.text.toString())
        }

        sevenButton.setOnClickListener {
            inputDisplay.append(sevenButton.text.toString())
        }

        eightButton.setOnClickListener {
            inputDisplay.append(eightButton.text.toString())
        }

        nineButton.setOnClickListener {
            inputDisplay.append(nineButton.text.toString())
        }

        zeroButton.setOnClickListener {
            inputDisplay.append(zeroButton.text.toString())
        }

        backspace.setOnClickListener {
            if(inputDisplay.text.isNotEmpty() && displayText.text.isNotEmpty()){
                inputDisplay.text = inputDisplay.text.toString().substring(0, inputDisplay.text.length - 1)
//                displayText.text = displayText.text.substring(0, displayText.text.length - 1)
            }
        }

        plusButton.setOnClickListener {
            value1 = Integer.parseInt(inputDisplay.text.toString())
            inputDisplay.append(plusButton.text.toString())
            displayText.text = inputDisplay.text.toString()
            addition = true
            inputDisplay.text = null

            if (ansText.text.isNotEmpty() ){
                value1 = answer
                inputDisplay.append(plusButton.text.toString())
            }

        }

        minusButton.setOnClickListener {
            value1 = Integer.parseInt(inputDisplay.text.toString())
            inputDisplay.append(minusButton.text.toString())
            displayText.text = inputDisplay.text.toString()
            substraction = true
            inputDisplay.text = null

            if (ansText.text.isNotEmpty() ){
                inputDisplay.append(minusButton.text.toString())
            }
        }

        multiplyButton.setOnClickListener {
            value1 = Integer.parseInt(inputDisplay.text.toString())
            inputDisplay.append(multiplyButton.text.toString())
            displayText.text = inputDisplay.text.toString()
            multiplication = true
            inputDisplay.text = null

            if (ansText.text.isNotEmpty() ){
                inputDisplay.append(multiplyButton.text.toString())
            }
        }

        divideSign.setOnClickListener {
            value1 = Integer.parseInt(inputDisplay.text.toString())
            inputDisplay.append(divideSign.text.toString())
            displayText.text = inputDisplay.text.toString()
            division = true
            inputDisplay.text = null

            if (ansText.text.isNotEmpty() ){
                value1 = answer
                inputDisplay.append(divideSign.text.toString())
            }
        }

        equalsSign.setOnClickListener {
            value2 = Integer.parseInt(inputDisplay.text.toString())
            displayText.append(value2.toString())

            when {
                addition -> {
                    answer = value1 + value2
                    value1 = answer
                    ansText.text = answer.toString()
                    addition = false
                }
                substraction -> {
                    answer = value1 - value2
                    ansText.text = answer.toString()
                    substraction = false
                }
                multiplication -> {
                    answer = value1 * value2
                    ansText.text = answer.toString()
                    multiplication = false
                }
                division -> {
                    val ans = value1.toFloat() / value2.toFloat()
                    ansText.text = ans.toString()
                    division = false
                }
            }

        }
    }


}
