package com.example.assignment1.adminScreens

import android.content.res.Resources
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment1.home.HomeUiState
import com.example.assignment1.home.HomeViewModel
import com.example.assignment1.models.Book
import com.example.assignment1.ui.theme.Assignment1Theme
import androidx.compose.material.icons.filled.ExitToApp as ExitToApp1

@Composable
fun HomeAdminPage(
    homeViewModel: HomeViewModel?,
    onBookClick:(id:String) -> Unit,
    navigateToDetailPage:() -> Unit,
    navigateToWelcomePage: () -> Unit
) {
    val homeUiState = homeViewModel?.homeUiState ?: HomeUiState()

    var openDialog by remember {
        mutableStateOf(false)
    }

    var selectedBook: Book? by remember {
        mutableStateOf(null)
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    
    LaunchedEffect(key1 = Unit){
        homeViewModel?.loadBooks()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = { navigateToDetailPage.invoke() }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                )
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
                              imageVector = Icons.Default.ExitToApp1,
                              contentDescription = null,

                          )
                      }
                },
                title = {
                    Text(text = "Home")
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            when(homeUiState.booksList){
                is com.example.assignment1.repository.Resources.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }
                is com.example.assignment1.repository.Resources.Success -> {
                    LazyVerticalGrid(columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(16.dp),
                    ){
                       items(homeUiState.booksList.data ?: emptyList()
                       ) {
                            book -> 
                            BookItem(
                                books = book,
                                onLongClick = {
                                    openDialog = true
                                    selectedBook = book
                                },
                            ) {
                                onBookClick.invoke(book.documentId)
                            }
                        }
                        
                    }
                    AnimatedVisibility(visible = openDialog) {
                        AlertDialog(
                            onDismissRequest = {
                                openDialog = false
                            },
                            title = { Text(text = "Delete book?")},
                            confirmButton = {
                                Button(
                                    onClick = {
                                        selectedBook?.documentId?.let {
                                            homeViewModel?.deleteBook(it)
                                        }
                                        openDialog = false
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color.Red
                                    ),
                                ) {
                                    Text(text = "Delete")
                                }
                            },
                            dismissButton = {
                                Button(onClick = { openDialog = false }) {
                                    Text(text = "Cancel")
                                }
                            }
                        )
                    }
                        
                }
                else ->{
                    Text(
                        text = homeUiState
                            .booksList.throwable?.localizedMessage ?: "Unknown error",
                        color = Color.Red
                    )
                }
            }
        }
    }

    LaunchedEffect(key1 = homeViewModel?.hasUser){
        if (homeViewModel?.hasUser == false){
            navigateToWelcomePage.invoke()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookItem(
    books: Book,
    onLongClick: () ->Unit,
    onClick:() ->Unit
){
    Card(
        modifier = Modifier
            .combinedClickable(
                onLongClick = { onLongClick.invoke() },
                onClick = { onClick.invoke() }
            )
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = books.title,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Clip,
                modifier = Modifier.padding(4.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.disabled
            ) {
                Text(
                    text = books.description,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(4.dp),
                    maxLines = 4
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
//            CompositionLocalProvider(
//                LocalContentAlpha provides ContentAlpha.disabled
//            ) {
//                Text(
//                    text = books.description,
//                    style = MaterialTheme.typography.body1,
//                    overflow = TextOverflow.Ellipsis,
//                    modifier = Modifier.padding(4.dp).align(Alignment.End),
//                    maxLines = 4
//                )
//            }
        }
    }
    
}

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun HomeAdminPagePreview() {
    Assignment1Theme {
        HomeAdminPage(homeViewModel = null, onBookClick = {}, navigateToDetailPage = { /*TODO*/ }) {

        }
    }
}


