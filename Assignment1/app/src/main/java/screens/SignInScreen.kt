package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.EditField
import com.example.assignment1.R
import com.example.assignment1.ui.theme.Assignment1Theme

@Composable
fun LogInPage(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit
){

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val passwordVisibility by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(95, 141, 77, 255))
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(R.string.sign_in),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
//            color = Color(254,208,73)
            color = Color.White
        )
        Spacer(Modifier.height(26.dp))
        EditField(
            label = R.string.user_name,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            value = userName,
            onValueChanged = { userName = it},
//            color = Color(254,208,73)
            color = Color.White,
//            modifier = Modifier.width(150.dp),
            passwordVisibility = true
        )
        EditField(
            label = R.string.password,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            value = password,
            onValueChanged = { password = it},
//            color = Color(254,208,73)
            color = Color.White,
            passwordVisibility = false
        )

        Button(
            onClick =
            { navigateToHome() },
            modifier= Modifier
                .align(Alignment.End)
                .border(
                    width = 4.dp,
                    shape = RoundedCornerShape(18.dp),
                    color = Color.Unspecified
                )
                .padding(end = 15.dp)
            ,
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color(254,208,73))
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        )
        {
            Text(text = "Get started",
                color = Color.DarkGray,
                modifier = Modifier
                    .clickable(
                        // check password and username
                        //if valid navigate
                        onClick = navigateToHome
                    ),
            )

        }
        Spacer(modifier = modifier.height(10.dp))
        Row {
            Text(
                text = "Not registered?  ",
//                color = Color(254,208,73)
                color = Color.White
            )
            Text(
                text = "Sign up",
                modifier = Modifier
                    .clickable(
                        onClick = navigateToSignUp
                    ),
                color = Color(77,181,249)
            )
        }
    }
}

//fun checkUser(username:String, password:String): Boolean{
//    for(user in users){
//        if(user.name == username && user.password==password){
//            return true;
//        }
//    }
//    return false;
//}

@Preview(showBackground = true)
@Composable
fun LogInPagePreview() {
    Assignment1Theme {
        LogInPage(navigateToHome = { /*TODO*/ }) {
            
        }
    }
}



