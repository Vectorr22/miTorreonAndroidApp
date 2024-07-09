package com.example.mitorreonapp.components

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.mitorreonapp.R
import com.example.mitorreonapp.UbicationViewModel
import com.example.mitorreonapp.data.Categories


enum class DESTINATIONS(@StringRes val destinationId: Int) {
    Home(R.string.mi_torreon_home),
    AllUbications(R.string.allUbications),
    DetailScreen(R.string.detailScreen),
    InfoScreen(R.string.infoScreen)
}


@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    viewModel: UbicationViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController(),
    deviceWidth: WindowSizeClass,
) {
    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()

    val isTablet =
        deviceWidth.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM || deviceWidth.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED

    val isFirstScreen = currentBackStackEntry?.destination?.route == DESTINATIONS.Home.name

    Scaffold(
        containerColor = Color.White,
        contentColor = Color.Black,
        topBar = {
            MyTopAppBar(
                currentNav = DESTINATIONS.valueOf(
                    currentBackStackEntry?.destination?.route ?: DESTINATIONS.Home.name
                ),
                isFirstScreen = navHostController.previousBackStackEntry == null,
                onBackArrowPressed = { navHostController.navigateUp() }
            )
        },
        bottomBar = {


            MyBottomAppBar(
                onHomeClicked = {
                    navHostController.popBackStack(DESTINATIONS.Home.name, inclusive = false)
                },
                onListClicked = { navHostController.navigate(DESTINATIONS.AllUbications.name) },
                onInfoClicked = { navHostController.navigate(DESTINATIONS.InfoScreen.name) },
                isFirstScreen = isFirstScreen,
            )
        },
        modifier = modifier
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navHostController,
            startDestination = DESTINATIONS.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = DESTINATIONS.Home.name)
            {
                if (isTablet)
                {
                    CategoryScreenTablet(
                        listOfCategories = Categories.entries.toTypedArray(),
                        onCategoryPressed = {
                            viewModel.changeCategory(it)
                            navHostController.navigate(DESTINATIONS.AllUbications.name)
                        }
                    )
                }
                else
                {
                    MainScreen(
                        listOfCategories = Categories.entries.toTypedArray(),
                        onCategoryPressed = {
                            viewModel.changeCategory(it)
                            navHostController.navigate(DESTINATIONS.AllUbications.name)
                        }
                    )
                }
            }

            composable(route = DESTINATIONS.AllUbications.name)
            {
                if (isTablet)
                {
                    DetailScreenTablet(
                        listOfCurrentUbications = uiState.listOfCategorieUbications,
                        onUbicationClicked = { viewModel.changeCurrentUbication(it) },
                        ubication = uiState.currentUbication ?: uiState.listOfCategorieUbications.first(),
                        currentImage = uiState.currentImageToDisplay ?: uiState.listOfCategorieUbications.first().imageResource,
                        onNextImageClicked = { viewModel.changeToNextImage()},
                        isTablet = isTablet,
                        onLastImageClicked = { viewModel.changeToLastImage()})
                }
                else
                {
                    MainSectionScreen(
                        listOfCurrentUbications = uiState.listOfCategorieUbications,
                        onUbicationClicked = { viewModel.changeCurrentUbication(it) },
                        onIconClicked = { navHostController.navigate(DESTINATIONS.DetailScreen.name) },
                    )
                }
            }

            composable(route = DESTINATIONS.DetailScreen.name)
            {
                DetailScreenComposable(
                    ubication = uiState.currentUbication!!,
                    currentImage = uiState.currentImageToDisplay!!,
                    onNextImageClicked = { viewModel.changeToNextImage() },
                    onLastImageClicked = { viewModel.changeToLastImage() },
                    isTablet = isTablet
                )
            }

            composable(route = DESTINATIONS.InfoScreen.name)
            {
                InfoScreen()
            }
        }


    }
}