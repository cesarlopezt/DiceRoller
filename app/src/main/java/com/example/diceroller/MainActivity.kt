package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

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
        val diceImg1: ImageView = findViewById(R.id.imageView)
        val drawableDice1 = getDiceDrawable(dice.roll())
        diceImg1.setImageResource(drawableDice1)
        diceImg1.contentDescription = drawableDice1.toString()

        val diceImg2: ImageView = findViewById(R.id.imageView2)
        val drawableDice2 = getDiceDrawable(dice.roll())
        diceImg2.setImageResource(drawableDice2)
        diceImg2.contentDescription = drawableDice2.toString()
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