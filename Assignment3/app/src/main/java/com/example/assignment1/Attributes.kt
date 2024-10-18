package com.example.assignment1

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.ui.theme.Assignment1Theme
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

@Composable
fun Menu(
        navigateToWelcome: () -> Unit
){
    var expanded by remember { mutableStateOf(false) }
    Box {
        Row(){
            IconButton(
                onClick = { expanded = true },
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(
                    Icons.Rounded.Menu, contentDescription = "Menu icon"
                )
            }
            Text(
                text = "Explore",
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .offset(x = 70.dp)
                    .padding(15.dp)
            )
            IconButton(
                onClick = { /*TODO   navigate to HomeScreen*/ },
                modifier = Modifier
                    .offset(x = 125.dp)
                    .padding(10.dp)
            ) {
                Icon(
                    Icons.Rounded.Home, contentDescription = "Home icon" )
            }

        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                "Profile",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = {})
            )
            Text(
                "Catalog",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = {})
            )
            Text(
                "Favourites",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = {})
            )
            Text(
                "Saved",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = {})
            )
            Text(
                "Settings",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = {})
            )
            Divider()
            Text(
                "Exit",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = { navigateToWelcome.invoke() })
            )
        }

    }
}



@Composable
fun BookIcon(){
    Row(
        modifier = Modifier
    ){
       Image(
           painter = painterResource(R.drawable.book_icon),
           contentDescription = "image of the book",
           modifier = Modifier
//               .size()
       )
//        Text()
    }
}

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun BookIconPreview() {
    Assignment1Theme {
        BookIcon()
    }
}







