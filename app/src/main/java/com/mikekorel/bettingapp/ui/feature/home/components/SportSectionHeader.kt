package com.mikekorel.bettingapp.ui.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mikekorel.bettingapp.R
import com.mikekorel.designsystem.components.FavoriteSwitch
import com.mikekorel.designsystem.theme.AppTheme
import com.mikekorel.designsystem.theme.AppTheme.colors
import com.mikekorel.designsystem.theme.AppTheme.sizing
import com.mikekorel.designsystem.theme.AppTheme.spacing
import com.mikekorel.designsystem.theme.Typography
import com.mikekorel.domain.model.Sport

@Composable
fun SportSectionHeader(
    sport: Sport,
    switchChecked: Boolean,
    sectionExpanded: Boolean,
    onSwitchClick: (Boolean) -> Unit,
    onExpandClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.white)
            .padding(horizontal = spacing.spacing07, vertical = spacing.spacing04)
    ) {
        Text(
            text = sport.name.orEmpty(),
            style = Typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = colors.black,
            modifier = Modifier
                .weight(1f)
        )

        FavoriteSwitch(
            checked = switchChecked,
            onCheckedChange = onSwitchClick,
            modifier = Modifier.scale(0.8f)
        )

        Icon(
            painterResource(id = R.drawable.ic_arrow_down),
            contentDescription = stringResource(R.string.expand_and_collapse_section_button),
            modifier = Modifier
                .padding(start = spacing.spacing04)
                .clickable(onClick = onExpandClick)
                .rotate(if (sectionExpanded) 180f else 0f)
        )


    }
}

@Preview
@Composable
private fun SportSectionHeaderPrev() {

}