package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
          }
        }

    @Composable
    fun NewsStory() {
        MaterialTheme{
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.header),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(80.dp))

                Text("A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                    overflow = TextOverflow.Ellipsis,
                    style = typography.h6,
                    maxLines = 2
                )
                Text("Davenport, California")
                Text("December 2018")
            }
            Greeting(name = "hei")
            MyScreenContent()
        }

    }
    @Preview
    @Composable
    fun DefaultPreview(){
      NewsStory()
    }
    
    @Composable
    fun Greeting(name:String){
        Surface(color = Color.Blue) {
            Text(text = "Hello $name",modifier = Modifier.padding(24.dp))
        }
    }
    @Composable
    fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
        Column {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
            Divider(color = Color.Transparent, thickness = 32.dp)
            Counter()
        }
    }
    @Composable
    fun Counter() {
        val count = remember { mutableStateOf(0) }
        Button(onClick = {count.value++}) {
            Text(text = "${count.value}")
        }
    }
}



