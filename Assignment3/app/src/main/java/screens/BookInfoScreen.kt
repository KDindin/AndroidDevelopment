package screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
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
import com.example.assignment1.detail.DetailUiState
import com.example.assignment1.detail.DetailViewModel
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.ui.theme.Yellow200

@Composable
fun InfoAboutBookPage(
    navigateToWelcome: () -> Unit
) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Yellow200)
    ) {
        Menu(navigateToWelcome)
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
//            elevation = 2.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
            ) {

                Image(
                    painter = painterResource(R.drawable.colored_tree),
                    contentDescription = "image of the book",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(20.dp, top = 50.dp)
                        .width(200.dp)
                        .height(240.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Text(
                    text = "Name of the book here",
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(15.dp)
                )
                Text(
                    text = "by Author name here",
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "date of publication here",
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Row{
                    Text(
                        text = "Synopsis",
                        textAlign = TextAlign.Left,
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .offset(x = -75.dp)
                            .padding(15.dp)
                    )
                    Text(
                        text = "1000тг",
                        textAlign = TextAlign.Right,
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .offset(x = 50.dp)
                            .padding(15.dp)
                    )
                }
                Text(
                    text = "Comfort reached gay perhaps chamber his six detract besides add. " +
                            "Moonlight newspaper up he it enjoyment agreeable depending. " +
                            "Timed voice share led his widen noisy young. " +
                            "On weddings believed laughing although material do exercise of. " +
                            "Up attempt offered ye civilly so sitting to. " +
                            "She new course get living within elinor joy. " +
                            "She her rapturous suffering concealed." +
                            "Particular unaffected projection sentiments no my. " +
                            "Music marry as at cause party worth weeks. " +
                            "Saw how marianne graceful dissuade new outlived prospect followed. " +
                            "Uneasy no settle whence nature narrow in afraid. " +
                            "At could merit by keeps child. While dried maids on he of linen in.",
                    textAlign = TextAlign.Justify,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .offset(y = -23.dp)
                        .padding(25.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun InfoAboutBookPagePreview() {
    Assignment1Theme {
        InfoAboutBookPage {

       }
    }
}