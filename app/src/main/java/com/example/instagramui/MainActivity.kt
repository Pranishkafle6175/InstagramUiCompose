package com.example.instagramui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramui.ui.theme.InstagramUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUITheme {

                Column(modifier = Modifier.fillMaxSize()) {
                    TopBar(name = "pranish_official",modifier = Modifier.padding(10.dp))
                    ProfileImage()
                }

            }
        }
    }
}

@Composable
fun TopBar(
    name: String? =null,
    modifier: Modifier
           ){
    Row(
        modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

        Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="menu icon",modifier.size(24.dp), tint = Color.Black)


        Text(text = name!! , fontWeight = FontWeight.Bold, fontSize = 20.sp )


        Icon(painter = painterResource(id = R.drawable.ic_bell), contentDescription ="Notification Bell",modifier=Modifier.size(24.dp)
        , tint = Color.Black
        )



        Icon(painter = painterResource(id = R.drawable.ic_dotmenu), contentDescription ="Menu Icon",modifier=Modifier.size(24.dp)
            , tint = Color.Black
        )

    }
}
