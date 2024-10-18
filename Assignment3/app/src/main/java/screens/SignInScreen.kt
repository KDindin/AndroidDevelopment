package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.EditField
import com.example.assignment1.R
import com.example.assignment1.login.LoginViewModel
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.ui.theme.Green170
import com.example.assignment1.ui.theme.Yellow200

// adminadmin, admin@nimda.app
@Composable
fun LogInPage(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel? = null,
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
//    navigateToAdminHomePage: () ->Unit,
){
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    val focusManager = LocalFocusManager.current
//    val passwordVisibility by remember { mutableStateOf(false) }

    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Green170)
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
            color = Color.White
        )

        if(isError){
            Text(
                text = loginUiState?.loginError ?:"unknown error",
                color = Color.Red
            )
        }
        Spacer(Modifier.height(26.dp))
//        EditField(
//            label = R.string.email,
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Email,
//                imeAction = ImeAction.Next
//            ),
//            keyboardActions = KeyboardActions(
//                onNext = { focusManager.moveFocus(FocusDirection.Down) }
//            ),
//            value = email,
//            onValueChanged = { email = it},
////            color = Color(254,208,73)
//            color = Color.White,
////            modifier = Modifier.width(150.dp),
//            passwordVisibility = true
//        )
        OutlinedTextField(
            value = loginUiState?.userName ?: "", 
            onValueChange = {loginViewModel?.onUserNameChange(it)},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
//        EditField(
//            label = R.string.password,
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Password,
//                imeAction = ImeAction.Done
//            ),
//            keyboardActions = KeyboardActions(
//                onDone = { focusManager.clearFocus() }
//            ),
//            value = password,
//            onValueChanged = { password = it},
////            color = Color(254,208,73)
//            color = Color.White,
//            passwordVisibility = false
//        )
        OutlinedTextField(
            value = loginUiState?.password ?: "",
            onValueChange = {loginViewModel?.onPasswordChange(it)},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        Button(
            onClick = {
                  loginViewModel?.loginUser(context)
            },
            modifier= Modifier
                .align(Alignment.End)
                .border(
                    width = 4.dp,
                    shape = RoundedCornerShape(18.dp),
                    color = Color.Unspecified
                )
                .padding(end = 15.dp)
            ,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(text = "Get started",
                color = Color.DarkGray,
//                modifier = Modifier
//                    .clickable(
//                        // check password and username
//                        //if valid navigate
//                        onClick = {}
////                        navigateToHome
//                    ),
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        Row {
            Text(
                text = "Not registered?  ",
                color = Color.White
            )
//            TextButton(
//                onClick = { navigateToSignUp.invoke() }
//                ){
//                Text(
//                    text="Sign up",
//                    color = Color(77,181,249)
//                )
//            }
            Text(
                text = "Sign up",
                modifier = Modifier
                    .clickable(
                        onClick = { navigateToSignUp.invoke() }
                    ),
                color = Color(77,181,249)
            )
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if (loginViewModel?.hasUser == true){
                navigateToHome.invoke()
            }
//            if (loginViewModel?.hasUser == true){
//                if(loginViewModel?.currentUser?.email == "admin@nimda.app"){
//                    navigateToAdminHomePage.invoke()
//                }
//                else{
//                    navigateToHome.invoke()
//                }
//            }
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun LogInPagePreview() {
//    Assignment1Theme {
//        LogInPage(
//            navigateToHome = {},
//            navigateToSignUp = {}
//        )
//    }
//}



