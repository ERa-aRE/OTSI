package com.example.otsi.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.otsi.ui.theme.LoadingBlue

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = true,
    primaryText: String = "Sing in with Google",
    secondaryText: String = "Please wait ",
    icon: Int = com.google.android.gms.base.R.drawable.googleg_standard_color_18,
    shape: Shape = shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    borderStrokeWidth: Dp = 1.dp,
    progressIndicatorColor: Color = LoadingBlue,
    onClick: () -> Unit,
) {
    var buttonText by remember { mutableStateOf(primaryText) }
    LaunchedEffect(key1 = loadingState) {
        buttonText = if (loadingState) secondaryText else primaryText
    }
    Surface(
        modifier = modifier.clickable(enabled = !loadingState) {// only clickable if we are not in the loading state
            onClick()
        },
        shape = shape,
        border = BorderStroke(width = borderStrokeWidth, color = borderColor),
        color = backgroundColor,
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Google Logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = buttonText)
            if (loadingState) {
                Spacer(modifier = Modifier.width(15.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 3.dp,
                    color = progressIndicatorColor
                )
            }


        }
    }

}

@Composable
@Preview
fun GoogleButtonPreview() {
    GoogleButton {}
}