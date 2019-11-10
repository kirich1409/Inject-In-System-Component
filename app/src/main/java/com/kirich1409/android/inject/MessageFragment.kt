package com.kirich1409.android.inject

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kirich1409.android.inject.data.MessageProvider
import javax.inject.Inject

class MessageFragment @Inject constructor(
    private val messageProvider: MessageProvider
) : Fragment(R.layout.fragment_message) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = view.findViewById(R.id.message)
        textView.text = messageProvider.getMessage()
    }
}