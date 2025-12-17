package com.example.ut4p2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ut4p2.ui.theme.UT4P2Theme
import com.example.ut4p2.files.MyWhatsAppApp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT4P2Theme {
                MyWhatsAppApp()
            }
        }
    }
}

