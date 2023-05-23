package com.example.myfirstapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailScreen(
    id: Int,
    title: String,
    description: String,
    onNavigateToHome: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { onNavigateToHome.invoke() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Меню"
                        )
                    }
                    Text("$id", fontSize = 24.sp)
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Icon(
                modifier = Modifier.size(size = 240.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Text("$title ", fontSize = 32.sp)
            Text(description, fontSize = 32.sp)

        }
    }

}
//private var back_pressed: Long = 0
//
//fun onBackPressed() {
//    if (back_pressed + 2000 > System.currentTimeMillis()) onBackPressed() else Toast.makeText(
//        TODO(), "Press once again to exit!",
//        Toast.LENGTH_SHORT
//    ).show()
//    back_pressed = System.currentTimeMillis()
//}

