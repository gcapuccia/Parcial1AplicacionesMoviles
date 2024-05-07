package com.example.parcial1aplicacionesmoviles

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial1aplicacionesmoviles.ui.theme.Parcial1AplicacionesMovilesTheme


@Composable
fun MainPage(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = {MainTopAppBar()}
    ) {
        Navegacion(
            modifier = Modifier.padding(it),
            navHostController = navHostController
        )
    }
}

@Composable
fun Navegacion(
        modifier: Modifier,
        navHostController: NavHostController
    ){
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "login"
    ){
        composable("login") {
            LoginPage(
                onloginuser = {navHostController.navigate("bienvenido/$it")}
            )
        }
        composable("bienvenido/{user}"){
            val user = it.arguments?.getString("user") ?:""
            BienvenidaPage(user)
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(){
    TopAppBar(
        title = {Text(text = "Parcial 1 Aplicaciones Moviles")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}


@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    Parcial1AplicacionesMovilesTheme {
        MainPage()
    }
}