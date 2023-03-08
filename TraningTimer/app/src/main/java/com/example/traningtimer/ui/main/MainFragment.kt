package com.example.traningtimer.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.R
import com.example.traningtimer.databinding.ActivityMainBinding
import com.example.traningtimer.ui.second.SecondFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), View.OnClickListener {

    private val mainViewModel: MainViewModelFrag by viewModel()

    private var binding: ActivityMainBinding? = null

    private val listTrainingButton = arrayListOf<Button>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTrainingButtons()

        binding?.buttonReset?.setOnClickListener {
            mainViewModel.clearSharedPreferences(listTrainingButton)
            mainViewModel.loadStateArrayButtons(listTrainingButton)
        }

        Toast.makeText(requireContext(), "${listTrainingButton.size}", Toast.LENGTH_SHORT).show()


        parentFragmentManager.setFragmentResultListener(SecondFragment.REQUEST_CODE, viewLifecycleOwner) {_, data ->
            val button = view.findViewById<Button>(data.getInt(SecondFragment.BUTTON_ID))
            button.setTextColor(Color.GREEN)
            button.text = data.getInt(SecondFragment.COUNT).toString()
            mainViewModel.saveStateArrayButtons(listTrainingButton)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finishAndRemoveTask()
            }
        })
    }

    override fun onClick(v: View) {
        mainViewModel.saveStateArrayButtons(listTrainingButton)
        findNavController().navigate(R.id.toSecondFragment, bundleOf(SecondFragment.BUTTON_ID to v.id))
    }

    private fun initTrainingButtons() {
        listTrainingButton.clear()
        listTrainingButton.apply {
            add(binding!!.button1)
            add(binding!!.button2)
            add(binding!!.button3)
            add(binding!!.button4)
            add(binding!!.button5)
            add(binding!!.button6)
            add(binding!!.button7)
            add(binding!!.button8)
            add(binding!!.button9)
            add(binding!!.button10)
        }

        listTrainingButton.forEach {
            it.textSize = 20.0F
            it.setOnClickListener(this)
        }
        mainViewModel.loadStateArrayButtons(listTrainingButton)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}