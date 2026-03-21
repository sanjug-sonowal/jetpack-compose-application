package com.flowmatrixinnovations.jetpackcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flowmatrixinnovations.jetpackcomposeapplication.ui.theme.JetpackComposeApplicationTheme
import com.flowmatrixinnovations.jetpackcomposeapplication.ui.theme.Pink40
import com.flowmatrixinnovations.jetpackcomposeapplication.ui.theme.Pink80
import com.flowmatrixinnovations.jetpackcomposeapplication.ui.theme.Purple40
import com.flowmatrixinnovations.jetpackcomposeapplication.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column() {
                        Greeting(
                            "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        SanjugCustomComposable("Sanjug",21)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun SanjugCustomComposable(name:String,rollNo: Int){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = name,
            fontFamily = Typography.titleLarge.fontFamily,
            fontSize = Typography.titleLarge.fontSize
        )

        Text(
            text = rollNo.toString(),
            fontFamily = Typography.titleLarge.fontFamily,
            fontSize = Typography.titleLarge.fontSize
        )
    }
}

@Composable
fun CustomColumnPractice(){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Surface(
            color = Purple40,
            modifier = Modifier.padding(8.dp)
                .width(200.dp)
                .height(40.dp)
        ) { }

        Surface(
            color = Pink40,
            modifier = Modifier.padding(8.dp)
                .width(200.dp)
                .height(40.dp)
        ) { }
    }
}

@Composable
fun CustomRowPractice(){
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Surface(
            color = Purple40,
            modifier = Modifier.padding(8.dp)
                .width(200.dp)
                .height(40.dp)
        ) {

        }
        Surface(
            color = Pink80,
            modifier = Modifier.padding(8.dp)
                .width(200.dp)
                .height(40.dp)
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeApplicationTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            CustomRowPractice()
            CustomColumnPractice()
        }
    }
}