package com.example.traningtimer.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traningtimer.R
import com.example.traningtimer.database.TrainingEntity
import com.example.traningtimer.databinding.FragmentListBinding
import com.example.traningtimer.ui.edit.ITEM_KEY
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.UUID

class ListFragment: Fragment() {

    private var binding: FragmentListBinding? = null
    private val listViewModel: ListFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(
            layoutInflater,
            onItemClick = {
                if (!it.isChecked) {
                    findNavController().navigate(R.id.toEditFragment, bundleOf("itemKey" to it.id.toString()))
                } else {
                    Toast.makeText(requireContext(), "Заблокировано", Toast.LENGTH_SHORT).show()
                }

            }
        )

        binding?.list?.apply {
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)

            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            listViewModel.states.collect {
                adapter.submitList(it.items)
            }
        }
    }

    fun display(model: TrainingEntity) {
        findNavController().navigate(ListFragmentDirections.toEditFragment())
    }
}