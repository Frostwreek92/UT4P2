package com.example.ut4p2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.ut4p2.ui.topbar.MyTopAppBar
import com.example.ut4p2.ui.screens.ChatsScreen
import com.example.ut4p2.ui.screens.LlamadasScreen
import com.example.ut4p2.ui.screens.NovedadesScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.input.nestedscroll.nestedScroll


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyWhatsAppApp() {

    val tabs = listOf("Chats", "Novedades", "Llamadas")
    var selectedTabIndex by remember { mutableStateOf(0) }

    // 🔑 Scroll behavior para colapsar/expandir la TopAppBar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            Column {
                MyTopAppBar(scrollBehavior)
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
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción FAB */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Nuevo"
                )
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
