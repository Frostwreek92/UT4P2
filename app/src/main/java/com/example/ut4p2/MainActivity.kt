package com.example.ut4p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWhatsAppApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyWhatsAppApp() {
    val tabs = listOf("Chats", "Novedades", "Llamadas")
    var selectedTabIndex by remember { mutableStateOf(0) }

    MaterialTheme {
        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        title = { Text(text = "MyWhatsApp") },
                        actions = {
                            IconButton(onClick = { /* Acción Buscar */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Buscar"
                                )
                            }
                            IconButton(onClick = { /* Acción Compartir */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "Compartir"
                                )
                            }
                        }
                    )
                    TabRow(selectedTabIndex = selectedTabIndex) {
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                selected = selectedTabIndex == index,
                                onClick = { selectedTabIndex = index },
                                text = { Text(text = title) }
                            )
                        }
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                when (selectedTabIndex) {
                    0 -> ChatsScreen()
                    1 -> NovedadesScreen()
                    2 -> LlamadasScreen()
                }
            }
        }
    }
}

@Composable
fun ChatsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
        Text(text = "Pantalla de Chats")
    }
}

@Composable
fun NovedadesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
        Text(text = "Pantalla de Novedades")
    }
}

@Composable
fun LlamadasScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
        Text(text = "Pantalla de Llamadas")
    }
}