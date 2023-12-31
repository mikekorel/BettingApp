package com.mikekorel.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppSizing(
    val default: Dp = 0.dp,
    val xxxSmall: Dp = 1.dp,
    val xxSmall: Dp = 2.dp,
    val xSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val xLarge: Dp = 32.dp,
    val xxLarge: Dp = 64.dp,
    val xxxLarge: Dp = 96.dp,
)

internal val LocalSizing = staticCompositionLocalOf { AppSizing() }