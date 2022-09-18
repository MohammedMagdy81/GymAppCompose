package com.magdy.gymsaroundme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.magdy.gymsaroundme.ui.theme.GymsAroundMeTheme
import com.magdy.gymsaroundme.ui.theme.Purple500

@Composable
fun GymsScreen() {
    val viewModel: GymViewModel = viewModel()
    // lazy Column 
    LazyColumn() {
        items(viewModel.getGymList()) { gym ->
            GymItem(gym = gym)
        }
    }

}

@Composable
fun GymItem(gym: Gym) {
    var isFavoriteState by remember { mutableStateOf(false) }
    val icon = if (isFavoriteState) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }
    Card(
        elevation = 3.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            DefaultIcon(Icons.Filled.Place, Modifier.weight(.15f), contentDescription = "Location Icon")
            GymDetails(gym = gym, Modifier.weight(.70f))
            DefaultIcon(icon = icon,
                modifier = Modifier.weight(.15f),
                contentDescription = "Favorite Icon", onClick = {
                    isFavoriteState= ! isFavoriteState
                })
        }

    }
}

@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = gym.name,
            style = MaterialTheme.typography.h6,
            color = Purple500,
            modifier = Modifier.paddingFromBaseline(bottom = 12.dp)
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            Text(
                text = gym.address,
                style = MaterialTheme.typography.body2
            )
        }

    }
}

@Composable
fun DefaultIcon(
    icon: ImageVector,
    modifier: Modifier,
    onClick: () -> Unit = {},
    contentDescription: String

) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onClick()
            },
        colorFilter = ColorFilter.tint(Color.DarkGray)
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewMyGymScreen() {
    GymsAroundMeTheme {
        GymsScreen()
    }
}




