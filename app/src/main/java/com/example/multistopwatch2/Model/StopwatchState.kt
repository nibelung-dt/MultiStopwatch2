package com.example.multistopwatch2.Model

internal sealed class StopwatchState {

    data class Running(
        val startTime: Long,
        val elapsedTime: Long
    ) : StopwatchState()

    data class Paused(
        val elapsedTime: Long
    ) : StopwatchState()
}