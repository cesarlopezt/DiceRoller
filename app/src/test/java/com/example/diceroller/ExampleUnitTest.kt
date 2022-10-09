package com.example.diceroller

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun diceRoll_returnsValue() {
        val roll = Dice(6).roll()
        assertNotNull("Roll dice returned a null value", roll)
    }

    @Test
    fun diceRoll_generatesRandomNumber() {
        val roll = Dice(6).roll()
        assertTrue("The value of rollResult was not between 1 and 6",roll in 1..6)
    }
}