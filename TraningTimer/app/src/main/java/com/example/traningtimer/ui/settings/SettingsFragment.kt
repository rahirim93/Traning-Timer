package com.example.traningtimer.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment: Fragment() {

    private val settingsViewModel: SettingsFragmentViewModel by viewModel()
    private var binding: FragmentSettingsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding!!.root
    }
    // Type - тип тренировки. На текущий момент типа 4:
    //      1 - подтягивания;
    //      2 - подтягивания обратным хватом;
    //      3 - отжимания на брусьях;
    //      4 - выходы силой.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (settingsViewModel.getStarted()) {
            binding?.buttonReset?.isEnabled = true
            binding?.buttonStart?.text = "Продолжить"
        }

        when(settingsViewModel.getWeight()) {
            0 -> { binding?.button0?.isEnabled = false }
            16 -> { binding?.button16?.isEnabled = false }
            24 -> { binding?.button24?.isEnabled = false }
            32 -> { binding?.button32?.isEnabled = false }
        }

        when(settingsViewModel.getType()) {
            1 -> { binding?.buttonType1?.isEnabled = false }
            2 -> { binding?.buttonType2?.isEnabled = false }
            3 -> { binding?.buttonType3?.isEnabled = false }
            4 -> { binding?.buttonType4?.isEnabled = false }
        }

        binding?.button0?.setOnClickListener {
            settingsViewModel.setWeight(0) // Сохраняем вес в репозиторий

            binding?.button0!!.isEnabled = false
            binding?.button16!!.isEnabled = true
            binding?.button24!!.isEnabled = true
            binding?.button32!!.isEnabled = true

            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }
        binding?.button16?.setOnClickListener {
            settingsViewModel.setWeight(16) // Сохраняем вес в репозиторий

            binding?.button16!!.isEnabled = false
            binding?.button0!!.isEnabled = true
            binding?.button24!!.isEnabled = true
            binding?.button32!!.isEnabled = true

            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }
        binding?.button24?.setOnClickListener {
            settingsViewModel.setWeight(24)

            binding?.button24!!.isEnabled = false
            binding?.button0!!.isEnabled = true
            binding?.button16!!.isEnabled = true
            binding?.button32!!.isEnabled = true

            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }
        binding?.button32?.setOnClickListener {
            settingsViewModel.setWeight(32) // Сохраняем вес в репозиторий

            binding?.button32!!.isEnabled = false
            binding?.button0!!.isEnabled = true
            binding?.button16!!.isEnabled = true
            binding?.button24!!.isEnabled = true

            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }

        binding?.buttonType1?.setOnClickListener {
            settingsViewModel.setType(1)
            binding?.buttonType1!!.isEnabled = false
            binding?.buttonType2!!.isEnabled = true
            binding?.buttonType3!!.isEnabled = true
            binding?.buttonType4!!.isEnabled = true

            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }
        binding?.buttonType2?.setOnClickListener {
            settingsViewModel.setType(2)
            binding?.buttonType2!!.isEnabled = false
            binding?.buttonType1!!.isEnabled = true
            binding?.buttonType3!!.isEnabled = true
            binding?.buttonType4!!.isEnabled = true


            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }
        binding?.buttonType3?.setOnClickListener {
            settingsViewModel.setType(3)
            binding?.buttonType3!!.isEnabled = false
            binding?.buttonType1!!.isEnabled = true
            binding?.buttonType2!!.isEnabled = true
            binding?.buttonType4!!.isEnabled = true

            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }
        binding?.buttonType4?.setOnClickListener {
            settingsViewModel.setType(4)
            binding?.buttonType4!!.isEnabled = false
            binding?.buttonType1!!.isEnabled = true
            binding?.buttonType2!!.isEnabled = true
            binding?.buttonType3!!.isEnabled = true

            Log.d("chechPref", "IsStarted: ${settingsViewModel.getStarted()}")
            Log.d("chechPref", "Weight: ${settingsViewModel.getWeight()}")
            Log.d("chechPref", "Type: ${settingsViewModel.getType()}")
        }

        binding?.buttonReset?.setOnClickListener {
            binding?.buttonReset?.isEnabled = false
            settingsViewModel.setStarted(false)
            binding?.buttonStart?.text = "Начать"
        }

        binding?.buttonStart?.setOnClickListener {
            if (settingsViewModel.getStarted()) {
                findNavController().navigate(SettingsFragmentDirections.toMainFragment())
            } else {
                settingsViewModel.setStarted(true)
                settingsViewModel.setDate()
                findNavController().navigate(SettingsFragmentDirections.toMainFragment())
            }
        }

        // Выход из приложения при смахивании вправо.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finishAndRemoveTask()
            }
        })
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}