package com.aregyan.github.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import kotlinx.coroutines.flow.*





fun EditText.calculateLengthNoSpace(): Int {
    this.text.toString().replace(" ", "")
    return this.text.toString().length
}