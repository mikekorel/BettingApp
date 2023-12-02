package com.mikekorel.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColors(
    val yellow: Color = Color(0xFFFFAB30),
    val red: Color = Color(0xFFE7410F),
    val blue: Color = Color(0xFF0094FF),
    val grey: Color = Color(0xFF343434),
    val lightGrey: Color = Color(0xFF727272),
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),
)

internal val LocalColors = staticCompositionLocalOf { AppColors() }