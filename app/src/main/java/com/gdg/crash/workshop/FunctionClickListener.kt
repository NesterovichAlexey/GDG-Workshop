package com.gdg.crash.workshop

import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_text_views.*

class FunctionClickListener(private val activity: MainActivity) : View.OnClickListener {

    override fun onClick(view: View) {
        if (activity.isAnswer && view.id !in arrayOf(R.id.buttonFactorial, R.id.buttonPower)) {
            activity.expressionTextView.text.clear()
        }
        activity.expressionTextView.text.insert(
            activity.expressionTextView.selectionStart,
            (view as Button).text
        )
    }

}