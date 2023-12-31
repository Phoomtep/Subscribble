@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.subscribble.navbar

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavControl(){
    val navController = rememberNavController()
    
    Scaffold (
        bottomBar = { BottomBar(navController = navController) }
    ){
        NavGraphControl(navController = navController)
    }

}

@Composable
fun BottomBar(navController: NavController)
{
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Add,
        BottomBarScreen.Data_visual,
        BottomBarScreen.Bills
    )

    val navStackBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackStackEntry?.destination

    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)
            //.background(Color.White)
            .fillMaxWidth()
    ) {
        screens.forEach {screen ->
            if (currentDestination != null) {
                AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination,
    navController: NavController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            //.background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
        ){
        Row(
            modifier = Modifier
                .padding(start = 35.dp, end = 35.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = if (selected) screen.icon else screen.icon),
                contentDescription = "icon",
                tint = if (selected) Color(0xFF0AA6EC) else Color(0xFFD808080)
            )
            
        }
    }
}

@Composable
@Preview
fun NavControlReview() {
    NavControl()
}