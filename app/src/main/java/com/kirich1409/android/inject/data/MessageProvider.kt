package com.kirich1409.android.inject.data

import javax.inject.Inject

class MessageProvider @Inject constructor() {

    fun getMessage() = "Sample message"
}