package com.irancell.nwg.ios.util

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun Bitmap.toByteArray() : ByteArray {
    val stream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, 100, stream)
    return stream.toByteArray()
}

fun ByteArray.toBase64(): String =
    String(Base64.encode(this,Base64.DEFAULT))


fun String.fromBase64(): ByteArray =
    Base64.decode(this,Base64.DEFAULT)