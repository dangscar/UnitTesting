package com.nlhd.unittesting

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { 
                    Text(text = "Main Screen", style = MaterialTheme.typography.titleLarge)
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
        ) {
            Text(text = "Welcome to the Main Screen!")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { Log.d("AAA", "Click") }) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun TextScreen(modifier: Modifier = Modifier) {
    Text(text = "AAAA", style = MaterialTheme.typography.titleLarge, modifier = Modifier.testTag("text"))
}

@Composable
fun MyTextField() {
    var value by remember {
        mutableStateOf("")
    }
    TextField(
        value = value,
        onValueChange = {value = it},
        label = { Text("Enter text") },
        modifier = Modifier.testTag("MyTextField")
    )
}
