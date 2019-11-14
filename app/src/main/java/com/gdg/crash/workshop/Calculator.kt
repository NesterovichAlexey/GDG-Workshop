package com.gdg.crash.workshop

import kotlinx.android.synthetic.main.fragment_text_views.*
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.operator.Operator
import java.math.BigDecimal
import java.math.BigInteger

class Calculator(private val activity: MainActivity) {

    private var factorial =
        object : Operator("!", 1, true, PRECEDENCE_POWER + 1) {
            override fun apply(vararg args: Double): Double {
                val n = args[0].toInt()
                return (1..n).map { BigInteger("$it") }.reduce { fact, i -> fact * i }.toDouble()

            }
        }
    private var pow =
        object : Operator("^", 2, true, PRECEDENCE_POWER + 2) {
            override fun apply(vararg args: Double): Double {
                val a = args[0].toBigDecimal()
                val b = args[1].toInt()
                if (b == 0) {
                    return 1.0
                }
                var ans = BigDecimal(1.0)
                repeat(b) { ans *= a }
                return ans.toDouble()
            }
        }

    fun calculate(): String? {
        val txt = activity.expressionTextView.text.toString()
            .replace('×', '*')
            .replace('÷', '/')
        return try {
            val result = ExpressionBuilder(txt).operator(factorial, pow).build()
                .evaluate()
            return "%.7f".format(result).replace(',', '.').trimEnd('0').trimEnd('.')
        } catch (ex: IllegalArgumentException) {
            null
        }
    }
}