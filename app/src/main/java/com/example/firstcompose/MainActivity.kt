package com.example.firstcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            Text(
                text = "Hello World", modifier = Modifier.statusBarsPadding()
            )
            Previewfun()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Previewfun() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Hello Prateek",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Dummy Image",
            colorFilter = ColorFilter.tint(Color.Blue),
            contentScale = ContentScale.Crop
        )

        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black,
            ), enabled = true
        ) {
            Text(text = "Hello")
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Dummy Image"
            )
        }
        TextField(
            value = "Prateek Singh",
            onValueChange = {},
            label = { Text(text = "Enter Name") },
            placeholder = {})
    }
    Previewfun2()
    Column {
        ListViewItem(R.drawable.ic_android_black_24dp, "Prateek Singh", "Android Developer")
        ListViewItem(R.drawable.ic_android_black_24dp, "Pranjal", "Android Developer")
        ListViewItem(R.drawable.ic_android_black_24dp, "Tushar", "Android Developer")
    }
    ModiInfo()
    CircularImage()
}


@Composable
private fun Previewfun2() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "C", fontSize = 24.sp)
        Text(text = "D", fontSize = 24.sp)
    }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(), contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = ""
        )
    }
}


@Composable
fun ListViewItem(imgId: Int, name: String, occupation: String) {
    Row(
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        Column {
            Text(
                text = name, fontWeight = FontWeight.Bold
            )
            Text(
                text = occupation, fontSize = 12.sp
            )

        }
    }
}


@Composable
fun ModiInfo() {
    Text(
        text = "Hello",
        color = Color.Red,
        modifier = Modifier
            .clickable {}
            .background(Color.Blue)
            .size(200.dp)
            .border(4.dp, Color.Green)
            .clip(CircleShape)
            .background(Color.Yellow))
}


@Composable
fun CircularImage() {

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape),
        contentDescription = ""
    )

}


@Composable
fun TextInput() {
    val state = remember { mutableStateOf("") }
    TextField(value = state.value, onValueChange = {
        state.value = it
    }, label = { Text(text = "Enter Message") })
}