package com.alexander.itm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alexander.itm.ui.theme.ITMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITMTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val showMenu = remember {
        mutableStateOf(false)
    }

    Column {
        TopAppBar(
            title = { Text(text = "Ind x Tai x Mal") },
            actions = {
                IconButton(
                    onClick = { showMenu.value = true }
                ) {
                    Icon(Icons.Default.MoreVert, contentDescription = null)
                }
                DropdownMenu(
                    expanded = showMenu.value, onDismissRequest = { showMenu.value = false }
                ) {
                    DropdownMenuItem(
                        onClick = {
                            navController.navigate("JumpFirst")
                        })
                    {
                        Text(text = "Indonesia")
                    }

                    DropdownMenuItem(
                        onClick =
                        {
                            navController.navigate("JumpSecond")
                        })
                    {
                        Text(text = "Taiwan")
                    }
                    DropdownMenuItem(
                        onClick =
                        {
                            navController.navigate("JumpThird")
                        })
                    {
                        Text(text = "Malaysia")
                    }
                }
            }
        )
        NavHost(navController = navController, startDestination = "JumpFirst") {
            composable("JumpFirst") {
                Indonesia(navController = navController)
            }
            composable("JumpSecond") {
                Taiwan(navController = navController)
            }
            composable("JumpThird") {
                Malaysia(navController = navController)
            }
        }
    }
}

@Composable
fun Indonesia(navController : NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("JumpSecond")
        }) {
            Image(
                painterResource(id = R.drawable.ind),
                contentDescription = "Indonesia"
            )
        }
    }
}

@Composable
fun Taiwan(navController : NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("JumpThird")
        }) {
            Image(
                painterResource(id = R.drawable.tai),
                contentDescription = "Taiwan"
            )
        }
    }
}

@Composable
fun Malaysia(navController : NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("JumpFirst")
        }) {
            Image(
                painterResource(id = R.drawable.mal),
                contentDescription = "Malaysia"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ITMTheme {
        Greeting("Android")
    }
}