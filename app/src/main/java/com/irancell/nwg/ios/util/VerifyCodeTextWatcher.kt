package com.irancell.nwg.ios.util

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.irancell.nwg.ios.R

interface VerifyValidCode {
    fun onVerifyValidCode()
}


class VerifyCodeTextWatcher(
    private val view: View,
    private val editText: Array<EditText>,
    listener: VerifyValidCode
) :
    TextWatcher {
    private val listener: VerifyValidCode

    init {
        this.listener = listener
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    override fun afterTextChanged(editable: Editable) {
        if (editText[0].length() + editText[1].length() + editText[2].length() + editText[3].length() == 4) {
            listener.onVerifyValidCode()
        }
        val text = editable.toString()
        when (view.id) {
            R.id.et_code1 -> if (text.length == 1) editText[1].requestFocus()
            R.id.et_code2 -> if (text.length == 1) editText[2].requestFocus() else if (text.length == 0) editText[0].requestFocus()
            R.id.et_code3 -> if (text.length == 1) editText[3].requestFocus() else if (text.length == 0) editText[1].requestFocus()
            R.id.et_code4 -> if (text.length == 0) editText[2].requestFocus()
        }
    }
}

