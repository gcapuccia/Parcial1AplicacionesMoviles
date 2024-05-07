package com.example.parcial1aplicacionesmoviles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginPage(
    onloginuser: (user:String) -> Unit
    ) {

    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login",
            modifier = Modifier.padding(10.dp)
        )

        TextField(
            value = user,
            onValueChange = { user = it},
            label = {Text(text = "Ingrese Usuario")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        TextField(
            value = pass,
            onValueChange = { pass = it},
            label = {Text(text = "Ingrese Contraseña")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            modifier = Modifier ,
            onClick = {
                if(user == "pedro@pe.com.ar"){
                            if (pass == "abc123"){
                                onloginuser(user)
                            }else{
                                error = "error en Contraseña"
                            }
                    }else{
                        error = "error en Usuario"
                    }
                }
            ) {
                Text(text = "Login")
            }
        Text(text = error)
        }





}