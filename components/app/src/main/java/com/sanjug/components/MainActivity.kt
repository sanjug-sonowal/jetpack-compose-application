package com.sanjug.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sanjug.components.ui.theme.ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())

                    ) {
                        ExpandableCard()
                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                        TextFieldExample()
                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                        PassWordTextField()
                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                        GradientButton(
                            text = "Submit",
                            gradient = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF2196F3),
                                    Color(0xFF64B5F6)
                                )
                            ),
                            textColor = Color.White,
                            onclick = {}
                        )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComponentsTheme {
        ExpandableCard()
    }
}