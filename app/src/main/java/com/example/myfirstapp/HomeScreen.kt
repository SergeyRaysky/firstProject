package com.example.myfirstapp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    data: List<Item>,
    onNavigateToDetails: (Int, String, String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Кнопка поиска"
                    )
                }
            }
        }
    ) {


        Log.d("TAG", "-------HomeScreen----------")


        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .border(width = 2.dp, color = Color.Blue)
                .padding(12.dp)
        ) {
            items(
                data.size,
                itemContent = {
                    Element(
                        id = data[it].id,
                        color = data[it].color,
                        onNavigateToDetails
                    )
                })

        }
    }

}
//   DetailScreen(i = list.size )


@Composable
fun Element(
    id: Int,
    color: Int,
    onNavigateToDetails: (Int, String, String) -> Unit,
) {
    val stateBg = remember {
        mutableStateOf(false)

    }
    val context = LocalContext.current
    val title = "Title $id"
    val description = "Description $id"
    Log.d("TAG", "-------Element $id----------")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(
                        context,
                        "Вы нажали на  $id",
                        Toast.LENGTH_SHORT
                    )
                    .show()
                //                stateBg.value = !stateBg.value
                onNavigateToDetails.invoke(id, title, description)
            }
            //            .background(if (stateBg.value) Color.Red else Color.White)
            .background(Color(color))
            .border(width = 3.dp, color = Color.Black)
            .padding(16.dp)
    ) {


        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
        )
        Column() {
            Text(
                title,
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 24.sp
            )
            Text(
                description,
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 24.sp
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
}
