package com.example.multistopwatch2.Model

import kotlinx.coroutines.*

// import com.example.multistopwatch2.Model.StopwatchState.Running

interface ElapsedTimeUpCalculator {
    fun calculateTimeUp(currentTime: Long): Long
    fun startCalculate()
    fun stopCalculate()
    fun pauseCalculate()

    class Base(private var time: Long) : ElapsedTimeUpCalculator {
        val scope = MainScope() // CoroutineScope() //
        var job: Job? = null
        override fun calculateTimeUp(currentTime: Long): Long {
            time = currentTime
            job = scope.launch {
                while(true) {
                    time++
                    delay(1000)
                }
            }
            return time++
        }

        override fun startCalculate() {
            TODO("Not yet implemented")
        }

        override fun stopCalculate() {
            TODO("Not yet implemented")
        }

        override fun pauseCalculate() {
            TODO("Not yet implemented")
        }

    }

}



/*
fun calculate(state: StopwatchState.Running): Long {
    val currentTimestamp = timestampProvider.getMilliseconds()
    val timePassedSinceStart = if (currentTimestamp > state.startTime) {
        currentTimestamp - state.startTime
    } else {
        0
    }
    return timePassedSinceStart + state.elapsedTime
}
 */