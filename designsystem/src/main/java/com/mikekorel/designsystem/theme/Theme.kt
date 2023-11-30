package com.mikekorel.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colors = AppTheme.colors
    val spacing = AppTheme.spacing
    val sizing = AppTheme.sizing

    CompositionLocalProvider (
        LocalColors provides colors,
        LocalSpacing provides spacing,
        LocalSizing provides sizing,
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = colors.blue.toArgb()
            }
        }

        content()
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalColors.current

    val spacing: AppSpacing
        @Composable
        get() = LocalSpacing.current

    val sizing: AppSizing
        @Composable
        get() = LocalSizing.current

}