package com.example.myfirstapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(
                        onNavigateToDetails = {arg,title,description -> navController.navigate("detailScreen/$arg,$title,$description")}
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
