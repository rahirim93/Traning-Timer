package com.example.traningtimer.ui.second

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.core.os.bundleOf
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.databinding.ActivityMain2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment(), View.OnClickListener {

    private var binding: ActivityMain2Binding? = null
    private val secondFragmentViewModel: SecondFragmentViewModel by viewModel()

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
        // Добавляем данные для передачи первому фрагменту
        parentFragmentManager
            .setFragmentResult(
                REQUEST_CODE,
                bundleOf(
                    BUTTON_ID to requireArguments().getInt(BUTTON_ID),
                    COUNT to (v as Button).text.toString().toInt()
                )
            )


        // Здесь нужно внести изменения в репозиторий
        val id = requireArguments().getInt(BUTTON_ID) // Получаем id кнопки подхожа нажатой в первом фрагменте
        val count = (v as Button).text.toString() // Получаем количество раз от кнопки нажатой по втором фрагменте
        // Сохраняем в репозиторий
        secondFragmentViewModel.apply {
            setText(id, count)
            setColor(id, Color.GREEN)
        }

        findNavController().popBackStack() // Возврат к первому фрагменту
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