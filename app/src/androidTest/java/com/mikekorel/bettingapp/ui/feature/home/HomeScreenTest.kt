package com.mikekorel.bettingapp.ui.feature.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.mikekorel.core.utils.TestTag
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun emptyStateComponent_isPresented_whenThereAreNoSportItems() {
        composeTestRule.setContent {
            HomeScreenContent(
                currState = HomeScreenContract.State(),
                onEvent = { }
            )
        }

        composeTestRule
            .onNodeWithTag(TestTag.HOME_SCREEN_EMPTY_COMPONENT)
            .assertIsDisplayed()
    }

    @Test
    fun errorStateComponent_isPresented_whenThereAreIsAnError() {
        composeTestRule.setContent {
            HomeScreenContent(
                currState = HomeScreenContract.State(
                    hasError = true
                ),
                onEvent = { }
            )
        }

        composeTestRule
            .onNodeWithTag(TestTag.HOME_SCREEN_ERROR_COMPONENT)
            .assertIsDisplayed()
    }

}