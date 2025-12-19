package com.example.ut4p2.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(text = "MyWhatsApp") },
        actions = {
            IconButton(onClick = { /* Buscar */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar"
                )
            }
            IconButton(onClick = { /* Compartir */ }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Compartir"
                )
            }
        }
    )
}