//package com.example.myfirstapp
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.heightIn
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.Button
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun OyScreen(
//    key: String,
//
//    onBackFun: () -> Unit,
//    onBackHome: () -> Unit,
//
//    ) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Icon(
//            modifier = Modifier.size(size = 240.dp),
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = null
//        )
//        Text(text = key, fontSize = 32.sp)
//
//        Spacer(modifier = Modifier.heightIn(115.dp))
//        Row {
//            Button(
//                onClick = { onBackFun.invoke() },
//                Modifier
//                    .width(150.dp)
//                    .height(75.dp)
//            ) {
//                Text(text = "Back",
//                    fontSize = 32.sp,
//                    modifier = Modifier.clickable { onBackFun.invoke() }
//                )
//
//            }
//            Spacer(modifier = Modifier.width(50.dp))
//            Button(
//                onClick = { /*TODO*/ },
//                Modifier
//                    .width(150.dp)
//                    .height(75.dp)
//            ) {
//                Text(text = "Home",
//                    fontSize = 32.sp,
//                    modifier = Modifier.clickable { onBackHome.invoke() })
//            }
//        }
//    }
//}