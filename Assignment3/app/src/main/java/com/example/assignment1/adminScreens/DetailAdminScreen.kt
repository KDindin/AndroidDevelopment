package com.example.assignment1.adminScreens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExitToApp as ExitToApp2
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment1.detail.DetailUiState
import com.example.assignment1.detail.DetailViewModel
import com.example.assignment1.home.HomeViewModel
import com.example.assignment1.ui.theme.Assignment1Theme
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DetailAdminPage(
    homeViewModel: HomeViewModel?,
    detailViewModel: DetailViewModel?,
    bookId:String,
    onNavigate:() -> Unit,
    navigateToWelcomePage: () -> Unit
){
    val detailUiState = detailViewModel?.detailUiState ?: DetailUiState()

    val isFormsNotBlank = detailUiState.title.isNotBlank() &&
            detailUiState.description.isNotBlank()

    val isBookIdNotBlank = bookId.isNotBlank()

//    val icon = if (isBookIdNotBlank) Icons.Default.Refresh
//    else Icons.Default.Check
    val icon = Icons.Default.Refresh

    LaunchedEffect(key1 = Unit) {
        if (isBookIdNotBlank) {
            detailViewModel?.getBook(bookId)
        } else {
            detailViewModel?.resetState()
        }
    }

    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            AnimatedVisibility(visible = isFormsNotBlank) {
                FloatingActionButton(
                    onClick = {
                        if (isBookIdNotBlank) {
                            detailViewModel?.updateBook(bookId)
                        } else {
                            detailViewModel?.addBook()
                        }
                    }
                ) {
                    Icon(imageVector = icon, contentDescription = null)
                }
            }
        },
        topBar = {
            TopAppBar(
                navigationIcon = {},
                actions = {
                    IconButton(onClick = {
                        homeViewModel?.signOut()
                        navigateToWelcomePage.invoke()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp2,
                            contentDescription = null,

                            )
                    }
                },
                title = {
                    Text(text = "Home")
                }
            )
        }
    ) {
        padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
        ) {
            if (detailUiState.bookAddedStatus){
                scope.launch {
                    scaffoldState.snackbarHostState
                        .showSnackbar("Book added successfully")
                    detailViewModel?.resetBookAddedStatus()
                    onNavigate.invoke()
                }
            }
            
            if (detailUiState.updateBookStatus){
                    scope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar("Book updated successfully")
                        detailViewModel?.resetBookAddedStatus()
                        onNavigate.invoke()
                    }
                }
            
//            LazyRow(modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly,
//                contentPadding = PaddingValues(
//                    vertical = 16.dp,
//                    horizontal = 8.dp,
//                )
//            ){
//
//            }
            OutlinedTextField(
                value = detailUiState.title,
                onValueChange = {
                    detailViewModel?.onTitleChange(it)
                },
                label = { Text(text = "Title")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            OutlinedTextField(
                value = detailUiState.description,
                onValueChange = {
                    detailViewModel?.onDescriptionChange(it)
                },
                label = { Text(text = "Description")},
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(8.dp)
            )

        }
    }
}

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun DetailAdminPagePreview() {
    Assignment1Theme {
        DetailAdminPage(
            homeViewModel = null,
            detailViewModel = null ,
            bookId = "",
            onNavigate = { /*TODO*/ }) {

        }
    }
}


