package com.example.otsi.presentation.screen.login


import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.otsi.ui.theme.TopAppBarBackgroundGray
import com.example.otsi.ui.theme.TopAppBarTextOrange

@Composable
fun LoginTopBar() {
    TopAppBar(
        title = {
            Text(text = "Sign in" , color = TopAppBarTextOrange)
        } ,
        backgroundColor = TopAppBarBackgroundGray

    )



}