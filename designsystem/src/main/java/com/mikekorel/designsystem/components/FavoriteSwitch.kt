package com.mikekorel.designsystem.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mikekorel.designsystem.theme.AppTheme
import com.mikekorel.designsystem.theme.AppTheme.colors

@Composable
fun FavoriteSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Switch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedTrackColor = colors.grey,
            uncheckedTrackColor = colors.lightGrey,
            checkedThumbColor = colors.blue,
            uncheckedThumbColor = colors.grey,
            checkedIconColor = colors.white,
            uncheckedIconColor = colors.white,
        ),
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        },
    )
}

@Preview
@Composable
private fun FavoriteSwitchCheckedPrev() {
    AppTheme {
        FavoriteSwitch(checked = true, onCheckedChange = { })
    }
}

@Preview
@Composable
private fun FavoriteSwitchNotCheckedPrev() {
    AppTheme {
        FavoriteSwitch(checked = false, onCheckedChange = { })
    }
}