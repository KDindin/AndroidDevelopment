package screens

import android.security.identity.AccessControlProfile
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    navigateToProfile: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(95,141,77,255))
            .padding(15.dp),
    ) {
        Menu(navigateBack, navigateToProfile)
//        Button(onClick = navigateBack) {
//            Text("Back")
//        }
        Content()
    }
}


@Composable
fun Content(){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        repeat(10){
            Post()
        }
    }
}

@Composable
fun Post(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(700.dp)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f),
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(fraction = 0.15f)
                    .aspectRatio(1f)
                    .background(color = Color(253,253,253), shape = CircleShape)
                ){

                }
                Text(
                    text = stringResource(com.example.assignment1.R.string.user_name),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .background(color = Color(253,253,253), shape = RectangleShape)
            ){
                //image
            }

        }
    }
}

@Composable
fun Menu(
    navigateBack: () -> Unit,
    navigateToProfile: () -> Unit
){
    var expanded by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "View menu")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(150.dp)
        ) {
                Text(
                    "Profile",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp).clickable(onClick = navigateToProfile)
                )
                Text(
                    "Catalog",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp).clickable(onClick = {})
                )
                Text(
                    "Favourites",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp).clickable(onClick = {})
                )
                Text(
                    "Saved",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp).clickable(onClick = {})
                )
                Text(
                    "Settings",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp).clickable(onClick = {})
                )
                Divider()
                Text(
                    "Exit",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp).clickable(onClick = navigateBack)
                )
            }

    }
}

//@Composable
//fun DropdownMenuItem(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    contentPadding: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
//    content: RowScope.() -&t; Unit
//): @Composable Unit

//@Preview(showBackground = true,  showSystemUi = true)
//@Composable
//fun HomePagePreview() {
//    Assignment1Theme {
//        HomePage()
//    }
//}