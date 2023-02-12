package com.example.multistopwatch2.Model

import android.R
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import kotlinx.coroutines.*
//import org.junit.rules.Timeout.seconds
import java.util.concurrent.Executor


// import com.example.multistopwatch2.Model.StopwatchState.Running

interface ElapsedTimeUpCalculator {
    fun calculateTimeUp(currentTime: Long): Long
    //fun startCalculate()
   //fun stopCalculate()
    //fun pauseCalculate()

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
    }

    class BaseHandler(private var time: Long) : ElapsedTimeUpCalculator {
        override fun calculateTimeUp(currentTime: Long): Long {
            val handler = Handler(Looper.myLooper()!!) // .getMainLooper())
            handler.run {
                while (time <= 10) {
                    time++
                    return time
                }
            }
            return time
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