package com.mikekorel.bettingapp.ui.feature.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun SportSectionItem(
    sportEvent: SportEvent,
    isFavorite: Boolean,
    currTimeMillis: Long,
    onFavoriteClick: (String) -> Unit,
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
            text = formatTimeUntilEvent(sportEvent.startTime ?: 0L, currTimeMillis),
            color = colors.white,
            modifier = Modifier
                .border(
                    width = sizing.xxxSmall, color = colors.blue,
                    shape = RoundedCornerShape(spacing.spacing02)
                )
                .padding(vertical = spacing.spacing02, horizontal = spacing.spacing03)
        )

        val drawableId = if (isFavorite) R.drawable.ic_star_filled else R.drawable.ic_star
        val contDesc = if (isFavorite)
            stringResource(R.string.favorite_button_highlighted)
        else
            stringResource(R.string.favorite_button_not_highlighted)
        val tint = if (isFavorite) colors.yellow else colors.lightGrey
        Icon(
            painter = painterResource(id = drawableId),
            contentDescription = contDesc,
            tint = tint,
            modifier = Modifier.clickable {
                sportEvent.id?.let {
                    onFavoriteClick(it)
                }
            }
        )

        Text(text = sportEvent.firstTeamName.orEmpty(), color = colors.white)

        Text(text = stringResource(R.string.vs), color = colors.red)

        Text(text = sportEvent.secondTeamName.orEmpty(), color = colors.white)
    }
}

@Composable
private fun formatTimeUntilEvent(startTime: Long, currTime: Long): String {
    val diff = (startTime * 1000) - currTime
    if (diff <= 0) return stringResource(R.string.completed)

    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return sdf.format(diff)
}

@Preview
@Composable
private fun SportSectionItemFavoritePrev() {
    AppTheme {
        SportSectionItem(
            sportEvent = SportEvent(
                firstTeamName = "Millwall FC U21",
                secondTeamName = "AFC Bournemouth U21",
            ),
            isFavorite = true,
            currTimeMillis = System.currentTimeMillis(),
            { },
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
            ),
            isFavorite = false,
            currTimeMillis = System.currentTimeMillis(),
            { },
        )
    }
}