package com.concealpay.android.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.concealpay.android.R
import com.concealpay.android.databinding.ActivityOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}