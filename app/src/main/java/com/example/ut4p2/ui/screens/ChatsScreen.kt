package com.example.ut4p2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ut4p2.data.Contact
import com.example.ut4p2.data.ContactRepository
import androidx.compose.foundation.combinedClickable
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun ChatsScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        ContactRepository.contactGroups.forEach { group ->
            stickyHeader {
                GroupHeader(title = group.title)
            }
            items(group.contacts) { contact ->
                ChatItem(contact)
            }
        }
    }
}

@Composable
fun GroupHeader(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun ChatItem(contact: Contact) {
    var showMenu by remember { mutableStateOf(false) }
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = {
                        // Click normal (abrir chat, por ejemplo)
                    },
                    onLongClick = {
                        showMenu = true
                    }
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = contact.imageRes),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = contact.name,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            DropdownMenuItem(
                text = { Text("Salir del grupo") },
                onClick = {
                    showMenu = false
                    // Acción salir del grupo
                }
            )
            DropdownMenuItem(
                text = { Text("Info. grupo") },
                onClick = {
                    showMenu = false
                    // Acción info grupo
                }
            )
            DropdownMenuItem(
                text = { Text("Crear acceso directo") },
                onClick = {
                    showMenu = false
                    // Acción crear acceso directo
                }
            )
        }
    }
}