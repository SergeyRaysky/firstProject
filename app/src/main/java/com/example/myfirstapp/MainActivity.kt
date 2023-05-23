package com.example.myfirstapp


import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val colors = listOf(
                Color.RED,
                Color.GREEN,
                Color.YELLOW,
                Color.BLUE,
                Color.CYAN,
                Color.DKGRAY,
                Color.GRAY,
                Color.LTGRAY,
                Color.MAGENTA,
                Color.TRANSPARENT
            )
            val list = List(100) {
                com.example.myfirstapp.Item(
                    id = it,
                    color = colors.random()
                )
            }
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(
                        data = list,
                        onNavigateToDetails = { arg, title, description -> navController.navigate("detailScreen/$arg,$title,$description") }
                    )
                }
                composable(
                    "detailScreen/{id},{title},{description}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType },
                        navArgument("title") { type = NavType.StringType },
                        navArgument("description") { type = NavType.StringType }
                    )
                ) {
                    val elementId = it.arguments?.getInt("id") ?: -1
                    val titleId = it.arguments?.getString("title") ?: "error"
                    val descriptionId = it.arguments?.getString("description") ?: "error"
                    DetailScreen(
                        id = elementId,
                        title = titleId,
                        description = descriptionId,
                        onNavigateToHome = {
                            navController.navigate("home")
                        })
                }

            }
        }
    }
}
