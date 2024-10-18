package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomePage(
    modifier : Modifier = Modifier,
    navigateToSignIn : () -> Unit,
    navigateToSignUp : () -> Unit
){
    Surface(modifier = modifier.fillMaxSize(),
        color = Color(95,141,77,255)
    ){
        Column(modifier = Modifier) {
            Spacer(Modifier.height(30.dp))
            Image(
                painter = painterResource(id = com.example.assignment1.R.drawable.white_tree),
                contentDescription = stringResource(id = com.example.assignment1.R.string.logo_tree),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                Alignment.Center
            )

            Spacer(Modifier.height(45.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                Arrangement.SpaceEvenly

            ) {
                Text(
                    text = stringResource(com.example.assignment1.R.string.sign_up),
                    modifier = Modifier
                        .wrapContentWidth(align = Alignment.End)
                        .border(width = 2.dp, color = Color.White, shape = CircleShape)
                        .padding(16.dp)
                        .clickable(
                            onClick = navigateToSignUp
                        ),
                    color = Color.White,
                    fontSize = 20.sp
                )

                Text(
                    text = stringResource(com.example.assignment1.R.string.sign_in),
                    modifier = Modifier
                        .wrapContentWidth(align = Alignment.Start)
                        .border(width = 2.dp, color = Color.White, shape = CircleShape)
                        .padding(16.dp)
                        .clickable(
                            onClick = navigateToSignIn
                        ),
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun WelcomePageAppPreview() {
//    Assignment1Theme {
//        WelcomePage()
//    }
//}