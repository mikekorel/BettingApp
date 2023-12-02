package com.mikekorel.bettingapp.ui.feature.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mikekorel.bettingapp.R
import com.mikekorel.designsystem.theme.AppTheme
import com.mikekorel.designsystem.theme.AppTheme.colors
import com.mikekorel.designsystem.theme.AppTheme.sizing
import com.mikekorel.designsystem.theme.AppTheme.spacing
import com.mikekorel.domain.model.SportEvent

@Composable
fun SportSectionItem(
    sportEvent: SportEvent,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(
            horizontal = spacing.spacing04,
            vertical = spacing.spacing05
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "HH:MM:SS", // fixme
            color = colors.white,
            modifier = Modifier
                .border(
                    width = sizing.xxxSmall, color = colors.blue,
                    shape = RoundedCornerShape(spacing.spacing02)
                )
                .padding(vertical = spacing.spacing02, horizontal = spacing.spacing03)
        )

        if (sportEvent.isFavorite == false) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = stringResource(R.string.favorite_button_not_highlighted),
                tint = colors.grey,
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_star_filled),
                contentDescription = stringResource(R.string.favorite_button_highlighted),
                tint = colors.yellow,
            )
        }

        Text(text = sportEvent.firstTeamName.orEmpty(), color = colors.white)

        Text(text = stringResource(R.string.vs), color = colors.red)

        Text(text = sportEvent.secondTeamName.orEmpty(), color = colors.white)
    }
}

@Preview
@Composable
private fun SportSectionItemFavoritePrev() {
    AppTheme {
        SportSectionItem(
            sportEvent = SportEvent(
                firstTeamName = "Millwall FC U21",
                secondTeamName = "AFC Bournemouth U21",
                isFavorite = true,
            )
        )
    }
}

@Preview
@Composable
private fun SportSectionItemNotFavoritePrev() {
    AppTheme {
        SportSectionItem(
            sportEvent = SportEvent(
                firstTeamName = "Millwall FC U21",
                secondTeamName = "AFC Bournemouth U21",
                isFavorite = false,
            )
        )
    }
}