package com.mikekorel.bettingapp.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppSpacing(
    val default: Dp = 0.dp,

    val spacing01: Dp = 1.dp,
    val spacing02: Dp = 2.dp,
    val spacing03: Dp = 4.dp,
    val spacing04: Dp = 8.dp,
    val spacing05: Dp = 12.dp,
    val spacing06: Dp = 16.dp,
    val spacing07: Dp = 24.dp,
    val spacing08: Dp = 32.dp,
    val spacing09: Dp = 40.dp,
    val spacing10: Dp = 48.dp,
    val spacing11: Dp = 56.dp,
    val spacing12: Dp = 64.dp,

)

internal val LocalSpacing = staticCompositionLocalOf { AppSpacing() }