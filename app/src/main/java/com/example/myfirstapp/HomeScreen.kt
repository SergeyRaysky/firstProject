package com.example.myfirstapp

import android.content.res.AssetManager
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.widget.TextClock
import android.widget.Toast
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.newFixedThreadPoolContext
import org.intellij.lang.annotations.JdkConstants
import java.sql.RowId
import kotlin.random.Random

@Composable
fun HomeScreen(
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

        val list = List(100) { it }
        LazyColumn() {
            items(
                list.size,
                itemContent = {
                    Element(
                        i = it,
                        onNavigateToDetails
                    )
                })
        }
    }

}
//   DetailScreen(i = list.size )


@Composable
fun Element(
    i: Int,
    onNavigateToDetails: (Int, String, String) -> Unit,
) {
    val stateBg = remember {
        mutableStateOf(false)

    }
    val color = colorResource(id = R.color.red)
    val context = LocalContext.current
    val title = "Title $i"
    val description = "Description $i"
    Log.d("TAG", "-------Element $i----------")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(
                        context,
                        "Вы нажали на  $i",
                        Toast.LENGTH_SHORT
                    )
                    .show()
                //                stateBg.value = !stateBg.value
                onNavigateToDetails.invoke(i,title, description)
            }
        //            .background(if (stateBg.value) Color.Red else Color.White)
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
