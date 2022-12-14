package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

private const val TAG = "MainActivity"

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides
        val dice = Dice(6)

        // Update the screen with the two dice rolls
        val diceImg1 = findViewById<ImageView>(R.id.imageView)
        val diceRoll1 = dice.roll()
        val drawableDice1 = getDiceDrawable(diceRoll1)
        diceImg1.setImageResource(drawableDice1)
        diceImg1.contentDescription = drawableDice1.toString()
        Log.i(TAG, "Dice 1 rolls in $diceRoll1")

        val diceImg2 = findViewById<ImageView>(R.id.imageView2)
        val diceRoll2 = dice.roll()
        val drawableDice2 = getDiceDrawable(diceRoll2)
        diceImg2.setImageResource(drawableDice2)
        diceImg2.contentDescription = drawableDice2.toString()
        Log.i(TAG, "Dice 2 rolls in $diceRoll2")
    }

    /**
     * Determine which drawable resource ID to use based on the dice roll
     */
    private fun getDiceDrawable(diceRoll: Number): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}