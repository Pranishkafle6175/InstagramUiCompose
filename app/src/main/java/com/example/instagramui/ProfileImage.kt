package com.example.instagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileImage(){

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

        ) {

            RoundedImage(painter = painterResource(id = R.drawable.philipp), modifier = Modifier
                .size(100.dp)
                .weight(3f)
                .padding(horizontal = 10.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                //The weight modifier is used to specify how much space each child
                // in the Row should take relative to the others
                modifier = Modifier
                    .weight(7f)
                    .padding(start = 10.dp)
            ) {
                RowElement(numberText = "601", text = "Posts")
                RowElement(numberText = "120.6K", text = "Followers")
                RowElement(numberText = "200", text = "Following")
            }

        }
        ProfileDescription(title="Programming Mentor",description="10 years of coding experience \n" +
                "Want me to make your app? Send me an email! \n" +
                "Android tutorials? Subscribe to my channel",
            url="https://youtube.com/c/PhilippLackner",
            followedby= listOf("codinginflow","miakhalifa"),
            othercount=17
            )
    }

}

@Composable
fun ProfileDescription(
    title: String,
    description: String,
    url: String,
    followedby: List<String>,
    othercount: Int
) {

    val letterSpacing= 0.5.sp
    val lineHeight=20.sp

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
        ) {
        Text(text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            letterSpacing=letterSpacing,
            lineHeight = lineHeight
        )

        Text(text = description,
            letterSpacing=letterSpacing,
            lineHeight = lineHeight
            )

        Text(text = url,
            color = Color(0xFF3D3D91),
            letterSpacing=letterSpacing,
            lineHeight = lineHeight
            )

        followedby.forEachIndexed { index, value ->

            Text(text = buildAnnotatedString {
                append("Followed by ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){

                }
            }
            )
        }


    }
}


//The matchHeightConstraintsFirst suggest that if there is any
// conflicting constraints then the height constraint will be priotirized.

@Composable
fun RoundedImage(painter: Painter,modifier:Modifier=Modifier){
    Image(painter = painter, contentDescription = null,
        modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 2.dp,
                color = Color.LightGray, shape = CircleShape
            )
            .clip(CircleShape)
        )
}

@Composable
fun RowElement(numberText:String,text:String,modifier : Modifier=Modifier){
    Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = numberText,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
                )

            Spacer(modifier.height(4.dp))

        Text(text = text)
    }
}