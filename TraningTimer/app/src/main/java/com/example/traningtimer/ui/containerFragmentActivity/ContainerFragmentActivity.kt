package com.example.traningtimer.ui.containerFragmentActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traningtimer.databinding.ActivityContainerFragmentBinding

class ContainerFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityContainerFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}