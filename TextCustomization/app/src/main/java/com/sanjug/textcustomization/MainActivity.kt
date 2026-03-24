package com.sanjug.textcustomization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sanjug.textcustomization.ui.theme.TextCustomizationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextCustomizationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column() {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        Spacer(
                            modifier = Modifier.padding(16.dp)
                        )
                        SelectableText("Sanjug","This is not selectable")
                        Spacer(
                            modifier = Modifier.padding(16.dp)
                        )
                        SuperScript("10","4")
                        Spacer(
                            modifier = Modifier.padding(16.dp)
                        )
                        SubScriptText("10","4")
                    }
                }
            }
        }
    }
}

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
){
    Column() {
        Text(
            text = text,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )
    }
}

@Composable
fun AnnotedText(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var annotedText = buildAnnotatedString {
            append("Hello ")

            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                block = {
                    append("Android")
                }
            )
            
        }

        Text(
            text = annotedText
        )
    }
}

@Composable
fun SelectableText(
    text : String,
    deselectText:String
){
    Column() {
        SelectionContainer() {
            Text(text = text)
            DisableSelection {
                Text(text = deselectText)
            }
        }
    }
}

@Composable
fun SuperScript(
    NormalText:String,
    SuperText:String
){
    Column() {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 24.sp
                    )
                ){
                    append((NormalText))
                }

                withStyle(
                    style = SpanStyle(
                        fontSize = 12.sp,
                        baselineShift = BaselineShift.Superscript
                    )
                ){
                    append((SuperText))
                }

            }
        )
    }
}

@Composable
fun SubScriptText(
    NormalText: String,
    SubText: String
){
    Column() {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 24.sp
                    )
                ){
                    append((NormalText))
                }

                withStyle(
                    style = SpanStyle(
                        fontSize = 12.sp,
                        baselineShift = BaselineShift.Subscript
                    )
                ){
                    append((SubText))
                }
            }
        )
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
    TextCustomizationTheme {
        Column() {
            Greeting("Android")
            CustomText("sanjug",Modifier)
            AnnotedText()
            SelectableText("Sanjug","This is not selectable")
            SuperScript("10","4")
        }
    }
}