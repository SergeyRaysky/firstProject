package com.example.myfirstapp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
    viewModel: HomeViewModel,
    onNavigateToDetails: (Int, String, String, Int) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar {
                IconButton(onClick = {
                        viewModel.sortedKey()
                }) {
                   Icon(if(!viewModel.sortFlag.value){
                            Icons.Filled.KeyboardArrowUp
                   }
                       else Icons.Filled.KeyboardArrowDown,
                       contentDescription = "Кнопка сортировки" )
                }
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = {viewModel.refreshData()}) {
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
                viewModel.data.value.size,
                itemContent = {
                    Element(
                        id = viewModel.data.value[it].id,
                        key = viewModel.data.value[it].key,
                        color = viewModel.data.value[it].color,
                        onNavigateToDetails
                    )
                })

        }
    }

}

@Composable
fun Element(
    id: Int,
    key: Int,
    color: Int,
    onNavigateToDetails: (Int, String, String, Int) -> Unit,
) {
    val context = LocalContext.current
    val title = "Title $id"
    val description = "key: $key"
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
                onNavigateToDetails.invoke(id, title, description, color)
            }
            .background(Color(color))
            .border(width = 3.dp, color = Color.Black)
            .padding(16.dp)
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
        )
        Column {
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
