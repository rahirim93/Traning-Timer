package com.example.traningtimer.ui.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traningtimer.R
import com.example.traningtimer.database.TrainingEntity
import com.example.traningtimer.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment: Fragment() {

    private var binding: FragmentListBinding? = null
    private val listViewModel: ListFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val act = activity as AppCompatActivity


        binding = FragmentListBinding.inflate(inflater, container, false)
        act.setSupportActionBar(binding?.toolbar)
        act.supportActionBar?.setDisplayShowTitleEnabled(false)
        return binding!!.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.actions_list, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.all -> {
                        menuItem.isChecked = true
                        listViewModel.load(0)
                        true
                    }
                    R.id.type12 -> {
                        menuItem.isChecked = true
                        listViewModel.load(5)
                        true
                    }
                    R.id.type1 -> {
                        menuItem.isChecked = true
                        listViewModel.load(1)
                        true
                    }
                    R.id.type2 -> {
                        menuItem.isChecked = true
                        listViewModel.load(2)
                        true
                    }
                    R.id.type3 -> {
                        menuItem.isChecked = true
                        listViewModel.load(3)
                        true
                    }
                    R.id.type4 -> {
                        menuItem.isChecked = true
                        listViewModel.load(4)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

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