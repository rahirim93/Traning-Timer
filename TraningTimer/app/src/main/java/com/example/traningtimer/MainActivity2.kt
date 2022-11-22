package com.example.traningtimer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar

const val EXTRA_COUNT = "count"
const val EXTRA_BUTTON = "button"
const val SHARED_COUNT = "shared_count"

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private var sharedPreferences: SharedPreferences? = null


    var arrayButtons = ArrayList<Button>()

    private lateinit var seekBar: SeekBar
    var counte = 0

    private lateinit var button21: Button
    private lateinit var button22: Button
    private lateinit var button23: Button
    private lateinit var button24: Button
    private lateinit var button25: Button
    private lateinit var button26: Button
    private lateinit var button27: Button
    private lateinit var button28: Button
    private lateinit var button29: Button
    private lateinit var button210: Button
    private lateinit var button211: Button
    private lateinit var button212: Button

    private var numberButton = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)


        initButtons()

        seekBar = findViewById(R.id.seekBar)
        var seekBarProgress = sharedPreferences?.getInt(SHARED_COUNT, 0)
        seekBar.progress = seekBarProgress!!
        for (i in 1..arrayButtons.size) {
            arrayButtons[i-1].text = "${seekBarProgress + i}"
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                for (i in 1..arrayButtons.size) {
                    arrayButtons[i-1].text = "${progress + i}"
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        numberButton = intent.getIntExtra(EXTRA_BUTTON_1, 0)
        Log.d(TAG, "ID второго активити: $numberButton")
    }

    private fun initButtons() {
        button21 = findViewById(R.id.button21)
        button22 = findViewById(R.id.button22)
        button23 = findViewById(R.id.button23)
        button24 = findViewById(R.id.button24)
        button25 = findViewById(R.id.button25)
        button26 = findViewById(R.id.button26)
        button27 = findViewById(R.id.button27)
        button28 = findViewById(R.id.button28)
        button29 = findViewById(R.id.button29)
        button210 = findViewById(R.id.button210)
        button211 = findViewById(R.id.button211)
        button212 = findViewById(R.id.button212)
        initArrayButtons()
        arrayButtons.forEach {
            it.setOnClickListener(this)
        }



    }

    private fun initArrayButtons() {
        arrayButtons.add(button21)
        arrayButtons.add(button22)
        arrayButtons.add(button23)
        arrayButtons.add(button24)
        arrayButtons.add(button25)
        arrayButtons.add(button26)
        arrayButtons.add(button27)
        arrayButtons.add(button28)
        arrayButtons.add(button29)
        arrayButtons.add(button210)
        arrayButtons.add(button211)
        arrayButtons.add(button212)
    }

    override fun onClick(v: View?) {
        val data = Intent()
        val button = findViewById<Button>(v!!.id)
        data.putExtra(EXTRA_COUNT, button.text.toString().toInt())
        data.putExtra(EXTRA_BUTTON, numberButton)
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        val editor = sharedPreferences?.edit()
        editor?.putInt(SHARED_COUNT, seekBar.progress)
        editor?.apply()
    }
}