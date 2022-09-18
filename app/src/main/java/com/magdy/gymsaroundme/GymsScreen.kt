package com.magdy.gymsaroundme

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.magdy.gymsaroundme.ui.theme.GymsAroundMeTheme
import com.magdy.gymsaroundme.ui.theme.Purple200
import com.magdy.gymsaroundme.ui.theme.Purple500

@Composable
fun GymsScreen() {
    // lazy Column 
    LazyColumn(){
        items(gymsList) {gym->
            GymItem(gym = gym)
        }
    }
    
    // Column Iteration
//   Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//       gymsList.forEach {
//           GymItem(it)
//       }
//
//   }
}

@Composable
fun GymItem(gym:Gym) {
    Card(
        elevation = 3.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            GymIcon(Icons.Filled.Place, Modifier.weight(.15f))
            GymDetails(gym= gym,Modifier.weight(.85f))
        }

    }
}

@Composable
fun GymDetails(gym:Gym,modifier: Modifier) {
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
fun GymIcon(place: ImageVector, modifier: Modifier) {
    Image(
        imageVector = place,
        contentDescription = "Gym Icon",
        modifier = modifier,
        colorFilter = ColorFilter.tint(Color.DarkGray)
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewMyGymScreen(){
  GymsAroundMeTheme {
      GymsScreen()
  }
}




