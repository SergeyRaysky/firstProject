package com.example.myfirstapp.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel,
    onNavigateToHome: () -> Unit,
    onNavigateToOy: (String, Int) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { onNavigateToHome.invoke() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Меню"
                        )
                    }
                    Text("${detailViewModel.id}", fontSize = 24.sp)
                }
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = { detailViewModel.titleOy() }) {
                Icon(
                    modifier = Modifier.size(size = 240.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            }
            Text("${detailViewModel.detailTitle.value} ", fontSize = 32.sp)
            Text(detailViewModel.description, fontSize = 32.sp)
            if (detailViewModel.count.intValue == 5) {
                //onNavigateToOy.invoke(detailViewModel.description, detailViewModel.color)
            }
        }
    }

}

