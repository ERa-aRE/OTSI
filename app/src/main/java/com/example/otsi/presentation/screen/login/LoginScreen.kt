package com.example.otsi.presentation.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.otsi.domain.model.MessageBarState

@Composable
fun LoginScreen(
    navHostController: NavHostController,
) {
    Scaffold(
        topBar = { LoginTopBar() },
        content = {padding->
            Column(modifier = Modifier.padding(padding)) {
                LoginContent(
                    signInState = false,
                    messageBarState = MessageBarState(),
                    onButtonClicked = {})
            }



        }
    )


}