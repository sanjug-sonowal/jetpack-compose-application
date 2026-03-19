package com.flowmatrixinnovations.jetpackcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flowmatrixinnovations.jetpackcomposeapplication.ui.theme.JetpackComposeApplicationTheme
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeApplicationTheme {
        Column() {
            Greeting("Android")
            SanjugCustomComposable("Sanjug",21)
        }
    }
}