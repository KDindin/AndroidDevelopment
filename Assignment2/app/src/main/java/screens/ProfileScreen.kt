package screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserInfo(navigateBack: () -> Unit) {
    Button(
        onClick = navigateBack,
        modifier= Modifier
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
        Text(text = "To home page",
            color = Color.DarkGray
        )

    }
}

//@Preview(showBackground = true)
//@Composable
//fun LogInPagePreview() {
//    UserInfo()
//}