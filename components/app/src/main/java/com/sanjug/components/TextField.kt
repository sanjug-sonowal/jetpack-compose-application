package com.sanjug.components

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun TextFieldExample(){
    var textState by remember { mutableStateOf("type here...")  }
    val localContext = LocalContext.current

    TextField(
        value = textState,
        onValueChange = { newText ->
            textState = newText
        },
        leadingIcon = {
            IconButton(
                onClick = {
                    Toast.makeText(localContext, "Email Clicked", Toast.LENGTH_SHORT).show()
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
            }
        }
    )
}
