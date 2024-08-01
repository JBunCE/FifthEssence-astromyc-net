package ui.components

import FifthEssenceScreens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BottomBar(
    navHostController: NavHostController
) {
    BottomAppBar(
        containerColor = Color(64, 9, 165, 154),
        modifier = Modifier.height(53.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FIconButton(onClick = {
                navHostController.navigate(FifthEssenceScreens.PUBLICATIONS.name)
            }, icon = Icons.Outlined.Home)
            FIconButton(onClick = {
                navHostController.navigate(FifthEssenceScreens.STREAMS.name)
            }, icon = Icons.Rounded.PlayArrow)
            FIconButton(onClick = {
                navHostController.navigate(FifthEssenceScreens.CREATE_SOMETHING.name)
            }, icon = Icons.Rounded.Add)
            FIconButton(onClick = {
                navHostController.navigate(FifthEssenceScreens.SCHEDULE.name)
            }, icon = Icons.Rounded.DateRange)
            FIconButton(onClick = {
                navHostController.navigate(FifthEssenceScreens.PROFILE.name)
            }, icon = Icons.Rounded.AccountBox)
        }
    }
}

@Composable
fun FIconButton(
    onClick: () -> Unit,
    icon: ImageVector,
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.fillMaxHeight()
    ) {
        Icon(
            icon,
            contentDescription = "profile",
            modifier = Modifier.fillMaxSize(),
        )
    }
}