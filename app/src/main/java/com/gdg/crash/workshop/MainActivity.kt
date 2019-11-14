package com.gdg.crash.workshop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.fragment_basic.*
import kotlinx.android.synthetic.main.fragment_text_views.*

class MainActivity : AppCompatActivity() {

    private val calculator = Calculator(this)
    private val numberClickListener = NumberClickListener(this)
    private val pointClickListener = PointClickListener(this)
    private val operatorClickListener = OperatorClickListener(this)
    private val functionClickListener = FunctionClickListener(this)
    private val equalClickListener = EqualClickListener(this)
    var isAnswer = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expressionTextView.doAfterTextChanged {
            val ans = calculator.calculate() ?: ""
            answerTextView.setText(ans)
            isAnswer = false
        }

        buttonFactorial.setOnClickListener(functionClickListener)
        buttonPower.setOnClickListener(functionClickListener)
        buttonDivide.setOnClickListener(operatorClickListener)
        buttonMultiply.setOnClickListener(operatorClickListener)
        buttonMinus.setOnClickListener(operatorClickListener)
        buttonPlus.setOnClickListener(operatorClickListener)
        buttonPoint.setOnClickListener(pointClickListener)
        buttonEqual.setOnClickListener(equalClickListener)
        buttonBackspace.setOnClickListener(::onBackspace)
        buttonBackspace.setOnLongClickListener(::onBackspaceLong)

        button0.setOnClickListener(numberClickListener)
        button1.setOnClickListener(numberClickListener)
        button2.setOnClickListener(numberClickListener)
        button3.setOnClickListener(numberClickListener)
        button4.setOnClickListener(numberClickListener)
        button5.setOnClickListener(numberClickListener)
        button6.setOnClickListener(numberClickListener)
        button7.setOnClickListener(numberClickListener)
        button8.setOnClickListener(numberClickListener)
        button9.setOnClickListener(numberClickListener)
    }

    private fun onBackspaceLong(view: View): Boolean {
        expressionTextView.text.clear()
        return true
    }

    fun onBackspace(view: View) {
        if (expressionTextView.hasSelection()) {
            expressionTextView.text.delete(
                expressionTextView.selectionStart,
                expressionTextView.selectionEnd
            )
        } else if (expressionTextView.selectionStart != 0) {
            val prefix = expressionTextView.text.substring(0, expressionTextView.selectionStart)
            expressionTextView.text.delete(
                expressionTextView.selectionStart - 1,
                expressionTextView.selectionStart
            )
        }
    }
}
