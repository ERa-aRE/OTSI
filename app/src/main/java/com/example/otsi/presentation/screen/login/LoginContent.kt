package com.example.otsi.presentation.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googleauthapp.R
import com.example.otsi.component.GoogleButton
import com.example.otsi.component.MessageBar
import com.example.otsi.domain.model.MessageBarState

@Composable
fun LoginContent(
    signInState: Boolean,
    messageBarState: MessageBarState,
    onButtonClicked: () -> Unit,


    ) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            MessageBar(messageBarState = messageBarState)
        }
        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CentralContent(signInState = signInState, onButtonClicked = onButtonClicked)

        }
    }

}

@Composable
fun CentralContent(
    signInState: Boolean,
    onButtonClicked: () -> Unit
) {
    Image(
        painter = painterResource(com.google.android.gms.base.R.drawable.googleg_standard_color_18),
        contentDescription = "Google Logo",
        modifier = Modifier
            .padding(20.dp)
            .size(120.dp)
    )

    Text(
        text = "Sign In to Continue",
        fontWeight = FontWeight.Bold,
        fontSize = MaterialTheme.typography.h5.fontSize
    )

    Text(
        text = stringResource(id = R.string.login_detail),
        modifier = Modifier
            .alpha(ContentAlpha.medium)
            .padding(top = 4.dp, bottom = 40.dp),
        fontSize = MaterialTheme.typography.subtitle1.fontSize,
        textAlign = TextAlign.Center
    )
    GoogleButton(loadingState = signInState, onClick = onButtonClicked)
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun contentPreview() {
    LoginContent(signInState = true, messageBarState =MessageBarState() ) {
        
    }

}