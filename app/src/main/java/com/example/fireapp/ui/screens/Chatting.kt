package com.example.fireapp.ui.screens

import android.graphics.drawable.AdaptiveIconDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.Person
import com.example.fireapp.R
import com.google.android.play.integrity.internal.i

@Composable
fun Chatting() {


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            HeaderAndStory()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            )

        }
    }
}

@Composable
fun HeaderAndStory(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(start = 20.dp, top = 20.dp)
    ) {
        Header()
        ViewStoryLayout()

    }
    
}

@Composable
fun ViewStoryLayout (modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
        item{
            AddStoryLayout()


        }
        items(personList, key = {it.id}){
            UserStoryLayout(person = it)

        }

    }
    
}
@Composable
fun Header (modifier: Modifier = Modifier) {
    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.W300
            )

        ){
            append(
               "Welcome Back "
            )
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

        ){
            append(
                stringResource(R.string.robert)
            )
        }
    }
    Text(text = text)
}

@Composable
fun UserStoryLayout (
    modifier: Modifier=Modifier,
    person: com.example.fireapp.ui.screens.Person
) {

    Column (
        modifier=Modifier.padding(end = 10.dp)
    ){
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(Yellow, CircleShape)
            .size(70.dp), contentAlignment = Alignment.Center){
            Icon(imageVector = Icons.Default.Person, contentDescription =null,Modifier.size(65.dp) )

        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = person.name,
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.White
            ), modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }

}

@Composable
fun AddStoryLayout(modifier: Modifier = Modifier) {
    Column(
        modifier=Modifier.padding(end = 10.dp)
    ) {
        Box(modifier = Modifier
            .border(
                2.dp, DarkGray, CircleShape
            )
            .background(
                Yellow, shape = CircleShape
            )
            .size(70.dp),
            contentAlignment = Alignment.Center){

            Box(modifier = Modifier
                .clip(CircleShape)
                .background(Color.Black)
                .size(20.dp), contentAlignment = Alignment.Center){
                Icon(imageVector = Icons.Default.Add, contentDescription = null,Modifier.size(12.dp), tint = Yellow)

            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.add_story),
            style = TextStyle(
                fontSize = 13.sp,
                color = White
            ),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)

            )
    }
}


@Preview
@Composable
private fun ChattingScreenPreview() {

    Chatting()
    
}