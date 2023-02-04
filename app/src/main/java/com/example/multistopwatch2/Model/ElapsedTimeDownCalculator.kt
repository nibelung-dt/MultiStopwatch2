package com.example.multistopwatch2.Model



import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

interface ElapsedTimeDownCalculator {
    fun startCalculateTimeDown(): Flow<Any>
    fun pauseCalculate()
    fun stopCalculate()

    // val timer = ElapsedTimeDownCalculator.Base()
    // timer.startCalculateTimeDown()
    // timer.pauseCalculate()
    // timer.stopCalculate()

    class Base(): ElapsedTimeDownCalculator {
        private var totalSeconds = 10

        override fun startCalculateTimeDown(): Flow<Int> = flow {

            (totalSeconds - 1 downTo 0).asFlow()
                .onEach { delay(1000) } // Each second later emit a number
                .onStart { emit(totalSeconds) } // Emit total seconds immediately
            // .conflate() // In case the operation onTick takes some time, conflate keeps the time ticking separately
            //.transform { remainingSeconds: Int -> emit(onTick(remainingSeconds))
        }

        override fun pauseCalculate() {
            TODO("Not yet implemented")
        }

        override fun stopCalculate() {
            TODO("Not yet implemented")
        }

    }
}

// про паузу для flow
// https://stackoverflow.com/questions/71473597/how-to-pause-emitting-flow-in-kotlin
// https://dev.to/aniketsmk/kotlin-flow-implementing-an-android-timer-ieo

