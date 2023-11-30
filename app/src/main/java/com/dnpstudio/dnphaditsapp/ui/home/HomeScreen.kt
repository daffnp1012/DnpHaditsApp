package com.dnpstudio.dnphaditsapp.ui.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dnpstudio.dnphaditsapp.item.PerawiItem
import com.dnpstudio.dnphaditsapp.ui.destinations.HadistListScreenDestination
import com.dnpstudio.dnphaditsapp.ui.home.event.HomeEvent
import com.dnpstudio.dnphaditsapp.ui.home.state.HomeState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = HomeViewModel(),
    navigator: DestinationsNavigator
) {

    val homeState by homeViewModel.loadingStatus.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(true){
        homeViewModel.onEvent(HomeEvent.getPerawi)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    Color.DarkGray
                ),
                title = {
                    Text(
                        text = "PocketHadist",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 72.dp)
            ){
                homeState.let { state ->
                    when(state){
                        is HomeState.Error -> {
                            Toast.makeText(context, "Error Occured", Toast.LENGTH_SHORT).show()
                        }
                        is HomeState.Loading -> {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                        is HomeState.Success -> {
                            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                                items(state.list){ perawi ->
                                    PerawiItem(
                                        modifier = Modifier,
                                        perawi = perawi,
                                        onClick = {
                                            navigator.navigate(HadistListScreenDestination(perawi.slug))
                                        }
                                    )
                                }
                            }
                        }
                        null -> {
                            Text(
                                text = "Loading content...",
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}