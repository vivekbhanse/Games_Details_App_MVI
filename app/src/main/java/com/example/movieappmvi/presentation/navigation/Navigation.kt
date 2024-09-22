package com.example.movieappmvi.presentation.navigation


import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieappmvi.presentation.freegame.components.GameScreen
import com.example.movieappmvi.presentation.freegame.states.UiEffect
import com.example.movieappmvi.presentation.freegame.viewmodel.FreeGameViewModel
import com.example.movieappmvi.presentation.navigation.screens.Screen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.GameScreen.route) {
        composable(Screen.GameScreen.route) {
            val freeGameViewModel = hiltViewModel<FreeGameViewModel>()
            val state = freeGameViewModel.freeGameState.collectAsStateWithLifecycle()
            val snackBarState= remember {
                SnackbarHostState()
            }
            GameScreen(freeGameState = state.value, modifier = Modifier)

            LaunchedEffect(key1 = true) {
                freeGameViewModel.uiEffect.collectLatest{
                    when(it){
                        UiEffect.NavigateToDetailScreen -> {

                        }
                        is UiEffect.ShowSnackBar -> {
                            snackBarState.showSnackbar(it.msg)
                        }
                    }
                }
            }
        }
    }

}
