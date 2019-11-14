package com.gdg.crash.workshop

import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_text_views.*

class OperatorClickListener(private val activity: MainActivity) : View.OnClickListener {

    override fun onClick(view: View) {
        var cur = activity.expressionTextView.selectionStart

        val arr = when ((view as Button).text) {
            "-" -> arrayOf('+', '-')
            else -> arrayOf('+', '×', '÷', '-')
        }
        if (cur > 0 && activity.expressionTextView.text[cur - 1] in arr) {
            activity.onBackspace(view)
            --cur
            if (cur > 0 && activity.expressionTextView.text[cur - 1] in arr) {  // for '×-' and '÷-' situation
                activity.onBackspace(view)
                --cur
            }
        }
        if (cur > 0 || view.text == "-") {
            activity.expressionTextView.text.insert(cur, view.text)
        }
    }

}