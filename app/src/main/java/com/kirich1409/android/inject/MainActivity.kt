package com.kirich1409.android.inject

import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity @Inject constructor() : AppCompatActivity(R.layout.activity_main)
