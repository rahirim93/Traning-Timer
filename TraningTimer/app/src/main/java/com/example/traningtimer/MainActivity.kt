package com.example.traningtimer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginLeft
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

const val EXTRA_BUTTON_1 = "button1"
const val TAG = "myMain"
const val SHARED_PREFERENCES_NAME = "name"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var string = ""
    var counter = 0

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button10: Button
    private lateinit var button11: Button
    private lateinit var button12: Button
    var arrayButtons = ArrayList<Button>()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private var sharedPreferences: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtons()

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        arrayButtons.forEach {
            val key1 = it.id.toString()
            val key2 = it.id.toString() + "C"
            val text = sharedPreferences?.getString(key1, "")
            it.text = text
            val color = sharedPreferences?.getInt(key2, 0)
            if (color != null) {
                it.setTextColor(color)
            }
        }

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                var data: Intent? = result.data
                var button = data?.getIntExtra(EXTRA_BUTTON, 0)
                var count = data?.getIntExtra(EXTRA_COUNT, 0)
                var but = findViewById<Button>(button!!)
                but.setTextColor(Color.GREEN)
                but.text = "$count"
                //finish()
                //var intent = Intent(Intent.ACTION_MAIN)
                //intent.addCategory(Intent.CATEGORY_ALTERNATIVE)
                //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                //startActivity(intent)

                //var intent = Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER)
                //startActivity(intent)
            }
        }
    }

    private fun initButtons() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button10 = findViewById(R.id.button10)
        createArrayButtons()
        arrayButtons.forEach {
            it.textSize = 20.0F
            it.setOnClickListener(this)
        }

        button11 = findViewById(R.id.button11)
        button11.setOnClickListener {
            button12.isEnabled = true
            string = ""
            counter = 0

            val date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                .format(Calendar.getInstance().time)
            string = string + date + "\n"

            for (i in 1..arrayButtons.size) {
                counter += arrayButtons[i-1].text.toString().toInt()
                string = string + "$i - ${arrayButtons[i-1].text} $counter 3" + "\n"
            }
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage("com.google.android.keep");
            intent.putExtra(Intent.EXTRA_TEXT, string)
            startActivity(intent)
        }
        button12 = findViewById(R.id.button12)
        button12.isEnabled = true
        button12.setOnClickListener {
            val editor = sharedPreferences?.edit()
            editor?.clear()
            editor?.apply()
            for (a in 1..arrayButtons.size) {
                arrayButtons[a-1].text = a.toString()
                arrayButtons[a-1].setTextColor(Color.BLACK)
            }
        }
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra(EXTRA_BUTTON_1, v?.id)
        resultLauncher.launch(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        arrayButtons.forEach {
            val editor = sharedPreferences?.edit()
            editor?.putString("${it.id}", it.text.toString())
            editor?.putInt("${it.id}C", it.currentTextColor)
            editor?.apply()
        }
    }

    private fun createArrayButtons() {
        arrayButtons.add(button1)
        arrayButtons.add(button2)
        arrayButtons.add(button3)
        arrayButtons.add(button4)
        arrayButtons.add(button5)
        arrayButtons.add(button6)
        arrayButtons.add(button7)
        arrayButtons.add(button8)
        arrayButtons.add(button9)
        arrayButtons.add(button10)
    }
}