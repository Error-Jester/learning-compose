package com.example.myapplication

import android.os.*
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.example.myapplication.ui.theme.*
import com.example.myapplication.ui.view.*

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(
                content = {
                    LoginUITheme(
                            content = { NavigatePage() }
                    ) 
                }
        )
    }

    @Composable
    fun NavigatePage() {
        val navController = rememberNavController()
        
        NavHost(
                navController = navController,
                startDestination = "login_page",
                builder = {
                    composable(route = "login_page", content = { LoginPage(navController = navController)})
                    composable(route = "register_page", content = { Register(navController = navController)})
                }
                )
    }
    
}