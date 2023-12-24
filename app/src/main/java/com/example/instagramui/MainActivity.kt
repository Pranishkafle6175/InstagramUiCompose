package com.example.instagramui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
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
                    Spacer(modifier = Modifier.height(25.dp))
                    ProfileImage()
                    Spacer(modifier = Modifier.height(25.dp))
                    ButtonSection(modifier = Modifier.fillMaxWidth())
                    ImageSection(modifier= Modifier.fillMaxWidth())

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


//The = Modifier part provides a default value of Modifier if no explicit modifier is provided when calling the function.
@Composable
fun ButtonSection(modifier: Modifier=Modifier){

    val minWidth=95.dp
    val height=30.dp

//    If i use modifier = Modifier.padding(10.dp) the width will be limited to the space the action
//    button takes but when i use modifier = modifier.padding(10.dp)
//i get fillmaxWidth with modifier from above function so using this will first fill max width and then apply padding in it .
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.padding(10.dp)
        ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }

}

@Composable
fun ActionButton(
    text:String?=null,
    icon:ImageVector?=null,
    modifier: Modifier=Modifier
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier= modifier
            .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .padding(6.dp)

    ){
        if(text!=null){
          Text(text = text,
              color = Color.Black, fontWeight = FontWeight.Bold,
              fontSize = 14.sp
              )
        }
        if(icon!=null){
            Icon(imageVector = icon,
                contentDescription = null,
                tint = Color.Black
                )
        }
    }

}

//The weight modifier in Jetpack Compose is used to specify
// how much of the available space a composable should occupy within a Row or Column.
// It is a way to distribute the available space among the children of a layout based on
// their relative weights.
@Composable
fun ImageSection(modifier: Modifier?=Modifier){
    Row (modifier = Modifier.padding(10.dp)){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            RoundedImage(painter = painterResource(id =R.drawable.youtube),
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )

            Text(text = "Youtube",
                    fontWeight = FontWeight.SemiBold
                )

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            RoundedImage(painter = painterResource(id =R.drawable.qa),
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )

            Text(text = "Q&A",
                fontWeight = FontWeight.SemiBold)

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            RoundedImage(painter = painterResource(id =R.drawable.discord),
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )

            Text(text = "Discord",
                fontWeight = FontWeight.SemiBold)

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            RoundedImage(painter = painterResource(id =R.drawable.telegram),
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )

            Text(text = "Telegram",
                fontWeight = FontWeight.SemiBold)

        }

    }
}

