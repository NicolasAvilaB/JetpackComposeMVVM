package com.example.jetpackcomposeinstagram.login.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun MessageDialog(show: Boolean, onDismiss: () -> Unit, text: String) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Divider(Modifier.fillMaxWidth(), Color.DarkGray)
                Column(Modifier.fillMaxWidth()) {
                    Text(text)
                }
                Row(Modifier.align(Alignment.End).padding(8.dp)){
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}