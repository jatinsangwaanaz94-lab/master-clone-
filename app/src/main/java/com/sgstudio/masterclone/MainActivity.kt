package com.sgstudio.masterclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var names by remember {
                    mutableStateOf(listOf("Test Instance 1"))
                }
                var nextId by remember { mutableIntStateOf(2) }

                Scaffold { padding ->
                    Column(
                        Modifier.fillMaxSize()
                            .padding(padding)
                            .padding(20.dp)
                    ) {
                        Text(
                            "MASTER CLONE",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text("SG Studio • Prototype 1.0")
                        Spacer(Modifier.height(20.dp))

                        Text(
                            "Instances: ${names.size}",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(Modifier.height(12.dp))

                        Button(onClick = {
                            names = names + "Test Instance $nextId"
                            nextId++
                        }) {
                            Text("Add Test Instance")
                        }

                        Spacer(Modifier.height(16.dp))
                        Text("Your instances")

                        LazyColumn {
                            items(names) { name ->
                                Card(
                                    Modifier.fillMaxWidth()
                                        .padding(vertical = 5.dp)
                                ) {
                                    Row(
                                        Modifier.fillMaxWidth()
                                            .padding(12.dp),
                                        horizontalArrangement =
                                            Arrangement.SpaceBetween
                                    ) {
                                        Text(name)
                                        TextButton(onClick = {
                                            names = names - name
                                        }) {
                                            Text("Remove")
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(Modifier.height(12.dp))
                        Text(
                            "Prototype only: these are dashboard entries, " +
                            "not running virtual Android apps."
                        )
                    }
                }
            }
        }
    }
}
