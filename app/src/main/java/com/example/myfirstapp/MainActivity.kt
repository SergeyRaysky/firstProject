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
import com.example.myfirstapp.detail.DetailScreen
import com.example.myfirstapp.detail.DetailViewModel
import com.example.myfirstapp.home.HomeScreen
import com.example.myfirstapp.home.HomeViewModel

@Suppress("NAME_SHADOWING")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val viewModelList = HomeViewModel()

            NavHost(navController = navController, startDestination = "home") {

                composable("home") {
                    HomeScreen(viewModel = viewModelList,
                        onNavigateToDetails = { arg, title, description ->
                            navController.navigate(
                                "detailScreen/$arg,$title,$description"
                            )
                        })
                }

                composable(
                    "detailScreen/{id},{title},{description}", arguments = listOf(
                        navArgument("id") { type = NavType.IntType },
                        navArgument("title") { type = NavType.StringType },
                        navArgument("description") { type = NavType.StringType },
                        )

                ) {

                    val elementId = it.arguments?.getInt("id") ?: -1
                    val titleId = it.arguments?.getString("title") ?: "error"
                    val descriptionId = it.arguments?.getString("description") ?: "error"
                    val viewModelDetail = DetailViewModel(
                        id = elementId,
                        title = titleId,
                        description = descriptionId
                    )
                    DetailScreen(detailViewModel = viewModelDetail, onNavigateToHome = {
                        navController.popBackStack()

                    }, onNavigateToOy = { descriptionId, colorId ->
                        navController.navigate("oyScreen/$descriptionId,$colorId")
                    })


                }

//                composable(
//                    "oyScreen/{key}",
//                    arguments = listOf(navArgument("key") { type = NavType.StringType },
//                        navArgument("color") { type = NavType.IntType })
//                ) {
//                    val keyId = it.arguments?.getString("key") ?: "error"
//                    OyScreen(
//                        key = keyId,
//                        onBackFun = { navController.popBackStack() },
//                        onBackHome = {})
//                }

            }
        }
    }

}
