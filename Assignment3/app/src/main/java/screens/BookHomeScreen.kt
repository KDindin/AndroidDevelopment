package screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.Menu
import com.example.assignment1.R
import com.example.assignment1.home.HomeUiState
import com.example.assignment1.home.HomeViewModel
import com.example.assignment1.models.Book
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.ui.theme.Gray100
import com.example.assignment1.ui.theme.Gray120
import com.example.assignment1.ui.theme.Yellow200

@Composable
fun BooksHomePage(
    navigateToWelcomePage: () -> Unit
){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Yellow200)
    ) {
        Menu(navigateToWelcomePage)
        Card(
            modifier = Modifier
                .padding(top = 85.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp,
                        topStart = 40.dp,
                        topEnd = 40.dp
                    )
                )
                .background(Color.White),
        ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Row(modifier = Modifier
                        .background(Color.White)
                        .padding(25.dp)
                    )
                    {
                        TextField(
                            value = "",
                            singleLine = true,
                            modifier = Modifier
                                .offset(x = -8.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .size(width = 265.dp, height = 50.dp)
                                .background(Gray100),
                            onValueChange = {},
                            label = { Text("Search books") },
                            keyboardOptions = KeyboardOptions.Default,
                            keyboardActions = KeyboardActions()
                        )
                        Box(
                            modifier = Modifier
                                .padding(5.dp)
                                .size(width = 50.dp, height = 50.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(Gray120)

                        ){
                            Icon(
                                Icons.Rounded.Search,
                                contentDescription = "Search icon",
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxSize()
                            )

                        }
                    }
//                    LazyRow(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.White)
//                    ){
//                        itemsIndexed(
//                            listOf(
//                                CategorisedModel(),
//                                CategorisedModel(),
//                                CategorisedModel(),
//                            )
//                        ){
//                            _, item -> MyRow(item = item)
//                        }
//                    }
//                    Image(
//                        painter = painterResource(R.drawable.decor_cropped),
//                        contentDescription = "image of the book",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .padding(20.dp, top = 50.dp)
//                            .width(200.dp)
//                            .height(240.dp)
//                            .clip(RoundedCornerShape(16.dp))
//                    )
//                    LazyColumn(
//
//                    ){
//
//                    }
                }
            }
        }
}

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun BookHomePagePreview() {
    Assignment1Theme {
        BooksHomePage {

        }
    }
}