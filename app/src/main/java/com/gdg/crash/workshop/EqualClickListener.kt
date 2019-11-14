package com.gdg.crash.workshop

import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_text_views.*

class EqualClickListener(private val activity: MainActivity) : View.OnClickListener {

    override fun onClick(view: View) {
        if (activity.isAnswer) return
        if (activity.answerTextView.text.toString() != "" && activity.answerTextView.text.toString() != activity.getString(R.string.error)) {
            activity.expressionTextView.text = activity.answerTextView.text
            activity.expressionTextView.setSelection(activity.expressionTextView.text.length)
            activity.answerTextView.setText("")
            activity.isAnswer = true
        } else activity.answerTextView.setText(activity.getString(R.string.error))
    }

}