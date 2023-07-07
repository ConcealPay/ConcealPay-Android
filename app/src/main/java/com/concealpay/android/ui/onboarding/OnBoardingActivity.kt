package com.concealpay.android.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.concealpay.android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
    }
}