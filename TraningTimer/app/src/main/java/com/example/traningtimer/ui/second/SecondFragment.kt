package com.example.traningtimer.ui.second

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.databinding.ActivityMain2Binding

class SecondFragment : Fragment(), View.OnClickListener {

    private var binding: ActivityMain2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMain2Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.root?.forEach { it2 ->
            if (it2 is GridLayout) {
                it2.forEach {
                    it.setOnClickListener(this)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        parentFragmentManager
            .setFragmentResult(
                REQUEST_CODE,
                bundleOf(
                    BUTTON_ID to requireArguments().getInt(BUTTON_ID),
                    COUNT to (v as Button).text.toString().toInt()
                )
            )
        findNavController().popBackStack()
    }

    companion object {
        const val BUTTON_ID = "BUTTON_ID"
        const val COUNT = "COUNT"
        const val REQUEST_CODE = "REQUEST_CODE"
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}