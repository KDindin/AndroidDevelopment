package com.example.assignment1

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.assignment1.ui.theme.Shapes

@Composable
fun EditField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    value: String,
    onValueChanged: (String) -> Unit,
    color: Color,
    passwordVisibility: Boolean
) {
//    TextField(
//        value = value,
//        singleLine = true,
//        modifier = modifier
//            .background(color),
//        onValueChange = onValueChanged,
//        label = { Text(stringResource(label)) },
//        keyboardOptions = keyboardOptions,
//        keyboardActions = keyboardActions
//    )

    OutlinedTextField(
        value = value,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = color
        ),
        onValueChange = onValueChanged,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}







