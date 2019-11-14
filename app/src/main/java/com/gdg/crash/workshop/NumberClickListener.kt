package com.gdg.crash.workshop

import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_text_views.*

class NumberClickListener(private val activity: MainActivity) : View.OnClickListener {

    override fun onClick(view: View) {
        if (activity.isAnswer) {
            activity.expressionTextView.setText((view as Button).text)
            activity.expressionTextView.setSelection(activity.expressionTextView.text.length)
        } else {
            val start = activity.expressionTextView.selectionStart
            val end = activity.expressionTextView.selectionEnd
            activity.expressionTextView.text.replace(start, end, (view as Button).text)
        }
    }

}