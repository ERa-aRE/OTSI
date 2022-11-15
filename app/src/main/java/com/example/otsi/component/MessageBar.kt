package com.example.otsi.component

import android.os.Message
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.otsi.domain.model.MessageBarState
import com.example.otsi.ui.theme.ErrorRed
import com.example.otsi.ui.theme.InfoGreen
import kotlinx.coroutines.delay
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun MessageBar(
    messageBarState: MessageBarState
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }
    LaunchedEffect(key1 = messageBarState) {
        if (messageBarState.error != null) {
            errorMessage = when (messageBarState.error) {
                is SocketTimeoutException -> {
                    "Connection timeout exception "
                }
                is ConnectException -> {
                    "Internet connection is not available "
                }
                else -> {
                    "${messageBarState.error.message}"
                }
            }
        }
        startAnimation = true
        delay(3000)
        startAnimation = false
    }
    AnimatedVisibility(
        visible = messageBarState.error != null && startAnimation
                || messageBarState.message != null && startAnimation,
        enter = expandVertically(
            animationSpec = tween(300),
            expandFrom = Alignment.Top
        ),
        exit = shrinkVertically(
            animationSpec = tween(300),
            shrinkTowards = Alignment.Top
        )
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = if (messageBarState.error != null) ErrorRed else InfoGreen)
                .padding(horizontal = 20.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (messageBarState.error != null) Icons.Default.Warning
                              else Icons.Default.Check,
                contentDescription = "MessageBar Icon" ,
                tint = Color.White,
            )
            Divider(modifier = Modifier.width(12.dp), color = Color.Transparent)
            Text(
                text = if (messageBarState.error != null ) errorMessage
                       else messageBarState.message.toString() ,
                color = Color.White ,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.button.fontSize,
                overflow = TextOverflow.Ellipsis, // connection error ...
                maxLines = 1 ,


            )


        }

    }

}

@Composable
fun row(messageBarState:MessageBarState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (messageBarState.error != null) ErrorRed else InfoGreen)
            .padding(horizontal = 20.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (messageBarState.error != null) Icons.Default.Warning
            else Icons.Default.Check,
            contentDescription = "MessageBar Icon" ,
            tint = Color.White,
        )
        Divider(modifier = Modifier.width(12.dp), color = Color.Transparent)
        Text(
            text = if (messageBarState.error != null ) "${messageBarState.error}"
            else messageBarState.message.toString() ,
            color = Color.White ,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.button.fontSize,
            overflow = TextOverflow.Ellipsis, // connection error ...
            maxLines = 1 ,


            )


    }

}
@Preview
@Composable
fun Message() {
    row(messageBarState = MessageBarState(error = SocketTimeoutException()))

}