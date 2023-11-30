package com.mikekorel.bettingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mikekorel.bettingapp.ui.feature.home.HomeScreen
import com.mikekorel.designsystem.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MainActivityContent()
            }
        }
    }
}

@Composable
private fun MainActivityContent(
    modifier: Modifier = Modifier
) {
    HomeScreen(modifier)
}

@Preview
@Composable
private fun MainActivityContentPrev() {
    AppTheme {
        MainActivityContent()
    }
}