package com.example.myfirstapp


import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
            val viewModelList = HomeViewModel()

            NavHost(navController = navController, startDestination = "home") {

                composable("home") {
                    HomeScreen(
                        viewModel = viewModelList ,
                        onNavigateToDetails = { arg, title, description, color -> navController.navigate("detailScreen/$arg,$title,$description,$color") }
                    )
                }

                composable(
                    "detailScreen/{id},{title},{description},{color}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType },
                        navArgument("title") { type = NavType.StringType },
                        navArgument("description") { type = NavType.StringType },
                        navArgument("color") { type = NavType.IntType}
                    )

                ) {

                    val elementId = it.arguments?.getInt("id") ?: -1
                    val titleId = it.arguments?.getString("title") ?: "error"
                    val descriptionId = it.arguments?.getString("description") ?: "error"
                    val colorId = it.arguments?.getInt("color") ?: Color.WHITE
                    DetailScreen(
                        id = elementId,
                        title = titleId,
                        description = descriptionId,
                        color = colorId,
                        onNavigateToHome = {
                            navController.navigate("home")

                        })

                }

            }
        }
    }

}
