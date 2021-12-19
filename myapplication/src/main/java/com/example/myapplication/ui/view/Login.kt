package com.example.myapplication.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.LoginUITheme
import com.example.myapplication.ui.theme.Purple500

@Preview
@Composable
fun PreviewLoginFrame() {
    LoginUITheme {
        LoginPage(navController = NavController(LocalContext.current))
    }
}



@Composable
fun LoginPage(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember { mutableStateOf("")}
    val passwordVal = remember { mutableStateOf("")}
    val passwordVisibility = remember { mutableStateOf(value = false)}

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                content = {
                    // Image Box
                    Box(
                        modifier = Modifier.background(color = Color.White),
                        contentAlignment = Alignment.TopCenter,
                        content = {
                            Image(
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(250.dp),
                                painter = painterResource(R.drawable.login_img),
                                contentDescription = "Login Image",
                                contentScale = ContentScale.Fit,
                            )
                        }
                    )
                    Spacer(modifier = Modifier.padding(all = 20.dp))
                    // Text Field Scaffold
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState,
                        content = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(color = Color.LightGray)
                                    .padding(all = 10.dp),
                                content = {
                                    Text(
                                        text = "Sign IN",
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                    Spacer(modifier = Modifier.padding(all = 20.dp))

                                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                                        content = {
                                            OutlinedTextField(
                                                value = emailVal.value,
                                                onValueChange = {emailVal.value = it},
                                                label = {Text(text = "Email Address")},
                                                placeholder = {Text(text = "Email Address")},
                                                singleLine = true,
                                                modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                                            )

                                            OutlinedTextField(
                                                value = passwordVal.value,
                                                onValueChange = {passwordVal.value = it},
                                                label = {Text(text = "Password")},
                                                placeholder = {Text(text = "Password")},
                                                singleLine = true,
                                                modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                                                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                                                trailingIcon =  {
                                                    IconButton(
                                                        onClick = { passwordVisibility.value = !passwordVisibility.value },
                                                        content = {
                                                            Icon(
                                                                painter = painterResource(id = R.drawable.password_eye),
                                                                contentDescription = "Password",
                                                                tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                                            )
                                                        }
                                                    )
                                                }
                                            )
                                            Spacer(modifier = Modifier.padding(10.dp))

                                            Button(
                                                modifier = Modifier
                                                    .fillMaxWidth(0.8f)
                                                    .height(height = 50.dp),
                                                onClick = {
                                                    if (emailVal.value.isEmpty()) {
                                                        Toast.makeText(context, "Please Enter a Value", Toast.LENGTH_SHORT).show()
                                                    } else if (passwordVal.value.isEmpty()) {
                                                        Toast.makeText(context, "Please Enter a Value", Toast.LENGTH_SHORT).show()
                                                    } else {
                                                        Toast.makeText(context, "Successful Login", Toast.LENGTH_SHORT).show()
                                                    }
                                                },
                                                content = {
                                                    Text(text = "Sign In", fontSize = 20.sp)
                                                }
                                            )

                                            Spacer(modifier = Modifier.padding(20.dp))

                                            Text(
                                                text = "Create An Account?",
                                                modifier = Modifier.clickable { navController.navigate("register_page") }
                                            )
                                            Spacer(modifier = Modifier.padding(all = 20.dp))
                                        })
                                }
                            )
                        }
                    )


                }
            )
        }

    )




}