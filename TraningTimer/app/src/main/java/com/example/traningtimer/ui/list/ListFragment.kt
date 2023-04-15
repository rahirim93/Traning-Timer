package com.example.traningtimer.ui.list

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class ListFragment: Fragment() {

    private var binding: FragmentListBinding? = null
    private val listViewModel: ListFragmentViewModel by viewModel()
    private lateinit var list: List<TrainingEntity>
    // Для графика
    private var listEntry1 = arrayListOf<Entry>()
    private lateinit var dataSet1: LineDataSet
    private var dataSets = arrayListOf<ILineDataSet>()
    private lateinit var lineData: LineData

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

        var menuGraph: MenuItem? = null

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.actions_list, menu)
                menuGraph = menu.findItem(R.id.filterGraph)
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
                    R.id.graph -> {
                        if (binding?.list?.visibility == View.VISIBLE) {
                            binding?.list?.visibility = View.GONE
                            binding?.chart?.visibility = View.VISIBLE
                            menuGraph?.isVisible = true
                        } else {
                            binding?.list?.visibility = View.VISIBLE
                            binding?.chart?.visibility = View.GONE
                            menuGraph?.isVisible = false
                        }
                        true
                    }
                    R.id.itemWeight -> {
                        menuItem.isChecked = true
                        drawGraph(list, 1)
                        true
                    }
                    R.id.itemTotal -> {
                        menuItem.isChecked = true
                        drawGraph(list, 2)
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
                    if (listViewModel.getBlocked()) {
                        Toast.makeText(requireContext(), "Заблокировано", Toast.LENGTH_SHORT).show()
                    } else {
                        findNavController().navigate(R.id.toEditFragment, bundleOf("itemKey" to it.id.toString()))
                    }
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
                list = it.items
                it.items.forEach {
                    Log.d("checkSize", "${SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(it.date?.time)}")
                }
                drawGraph(it.items, 1)
            }
        }
    }

    private fun drawGraph(list: List<TrainingEntity>, type: Int) {
        if(list.isNotEmpty()) {
            val list1 = list.reversed()
            val prepareList = arrayListOf<Entry>()
            for(i in list1.indices) {

                val x = list1[i].date.timeInMillis.toFloat()
                var y = 0.0F
                if (type == 1) {
                    y = list1[i].weight.toFloat()
                }
                if(type == 2) {
                    val a = list1[i].count.split(";").toMutableList()
                    a.removeLast()
                    var sum = 0
                    a.forEach {
                        sum += it.toInt()
                    }
                    y = sum.toFloat()
                }
                prepareList.add(Entry(x, y))
            }
            listEntry1 = prepareList
            dataSet1 = LineDataSet(listEntry1, "label")
            dataSets.clear()
            dataSets.add(dataSet1)
            lineData = LineData(dataSets)
            binding?.chart?.data = lineData
            binding?.chart?.invalidate()

            binding?.chart?.apply {
                xAxis.apply {
                    position = XAxis.XAxisPosition.BOTTOM
                    textColor = Color.WHITE
                    valueFormatter = MyValueFormatter()
                    setLabelCount(9, true)
                }
                axisLeft.apply {
                    textColor = Color.WHITE
                    //axisMinimum = 0F
                    //axisMaximum = 25F
                    setLabelCount(10, true)

                }
                axisRight.apply {
                    isEnabled = false
                }
                //setVisibleXRangeMaximum(1728_000_000F)
            }
        }
    }
}

class MyValueFormatter : ValueFormatter() {
    private val format = SimpleDateFormat("dd/MM", Locale.getDefault())
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = value.toLong()
        return format.format(calendar.time)
    }
}