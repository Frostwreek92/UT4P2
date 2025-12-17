package com.example.ut4p2.files

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.ut4p2.files.screens.ChatsScreen
import com.example.ut4p2.files.screens.LlamadasScreen
import com.example.ut4p2.files.screens.NovedadesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyWhatsAppApp() {
    val tabs = listOf("Chats", "Novedades", "Llamadas")
    var selectedTabIndex by remember { mutableStateOf(0) }
    MaterialTheme {
        Scaffold(
            topBar = {
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