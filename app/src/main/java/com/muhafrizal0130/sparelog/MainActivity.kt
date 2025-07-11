package com.muhafrizal0130.sparelog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.muhafrizal0130.sparelog.ui.theme.SparelogTheme
import com.muhafrizal0130.sparelog.ui.theme.screen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SparelogTheme {
                MainScreen()
            }
        }
    }
}


