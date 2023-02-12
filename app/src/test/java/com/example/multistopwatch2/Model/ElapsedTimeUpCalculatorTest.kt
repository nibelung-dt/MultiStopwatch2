package com.example.multistopwatch2.Model

// import org.junit.jupiter.api.Assertions.*

import org.junit.Test

import org.junit.Assert.*

internal class ElapsedTimeUpCalculatorTest {

    // @org.junit.jupiter.api.Test
    val stopwatch = ElapsedTimeUpCalculator.Base(0)
    fun calculateTimeUp() {

    }
}


class TestHandler {

    val stopwatch = ElapsedTimeUpCalculator.Base(0)
    var time: Long = 0

    @Test
    fun testCalculateTimeUp() {
        stopwatch.calculateTimeUp(time)
        assertEquals(10, time)
    }

}