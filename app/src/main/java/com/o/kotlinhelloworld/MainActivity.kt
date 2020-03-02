package com.o.kotlinhelloworld

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import com.o.kotlinhelloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var editText : EditText

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val rollButton : Button = binding.rollButton
        diceImage1 = binding.diceImg1
        diceImage2 = binding.diceImg2
        editText = binding.editText
        val upButton : Button = findViewById(R.id.up_button)
        rollButton.setOnClickListener {
            //Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            diceImage1.setImageResource(getRandomDiceDrawable())
            diceImage2.setImageResource(getRandomDiceDrawable())
            }
        /*upButton.setOnClickListener{
            val text : String = rollText.text.toString()
            if (text.isDigitsOnly()) {
                val num : Int = text.toInt()
                rollText.text = (num + 1).toString()
            }
        }*/
    }

    private fun getRandomDiceDrawable() : Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun editText() {
        val s : String = editText.text.toString()
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}
