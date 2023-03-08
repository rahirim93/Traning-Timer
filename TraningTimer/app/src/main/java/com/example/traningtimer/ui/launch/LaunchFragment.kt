package com.example.traningtimer.ui.launch

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.R


class LaunchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Проверка приложения, применена ли к нему оптимизация батареи
        //val powerManager = getSystemService(requireContext().POWER_SERVICE) as PowerManager
        val powerManager = requireContext().getSystemService(Context.POWER_SERVICE) as PowerManager
        val isIgnoring = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            powerManager.isIgnoringBatteryOptimizations(requireContext().packageName)
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        if (isIgnoring) {
            findNavController().navigate(LaunchFragmentDirections.toMainFragment())
        } else {
            startActivity(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS))
            Toast.makeText(requireContext(), "Выключите оптимизация расхода батареи и перезапустите приложение", Toast.LENGTH_LONG).show()
            activity?.finish()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}