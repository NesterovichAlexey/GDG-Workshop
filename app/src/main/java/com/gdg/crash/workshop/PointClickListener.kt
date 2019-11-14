package com.gdg.crash.workshop

import android.view.View
import kotlinx.android.synthetic.main.fragment_text_views.*

class PointClickListener(private val activity: MainActivity) : View.OnClickListener {

    override fun onClick(view: View) {
        val cur = activity.expressionTextView.selectionStart
        if (activity.expressionTextView.text[cur - 1] != '.') {
            activity.expressionTextView.text.insert(cur, ".")
        }
    }

}