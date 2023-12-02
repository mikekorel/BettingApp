package com.mikekorel.bettingapp.ui.feature.home.components

import junit.framework.TestCase.assertEquals
import org.junit.Test

class CountdownTimerTest {

    @Test
    fun countdownTimerString_isFormattedCorrectly_whenEventTimeHasPassed() {
        val currTime = System.currentTimeMillis()
        val eventTime = currTime - 1
        val completedStr = "completed"

        assertEquals(
            completedStr,
            formatTimeUntilEvent(
                startTime = eventTime,
                currTime = currTime,
                completedStr = completedStr
            )
        )
    }

    @Test
    fun countdownTimerString_isFormattedCorrectly_whenEventTimeHasNotPassed() {
        val currTime = 0L
        val completedStr = "completed"

        val oneSec = 1000L
        val oneMin = oneSec * 60
        val oneHour = oneMin * 60

        assertEquals(
            "00:00:25",
            formatTimeUntilEvent(
                startTime = oneSec * 25,
                currTime = currTime,
                completedStr = completedStr
            )
        )

        assertEquals(
            "00:03:12",
            formatTimeUntilEvent(
                startTime = oneMin * 3 + oneSec * 12,
                currTime = currTime,
                completedStr = completedStr
            )
        )

        assertEquals(
            "14:03:12",
            formatTimeUntilEvent(
                startTime = oneHour * 14 + oneMin * 3 + oneSec * 12,
                currTime = currTime,
                completedStr = completedStr
            )
        )
    }

}