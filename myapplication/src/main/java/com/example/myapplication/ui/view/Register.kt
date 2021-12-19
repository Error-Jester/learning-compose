package com.example.myapplication.ui.view

import android.widget.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import com.example.myapplication.R.*
import com.example.myapplication.ui.theme.*

@Composable
fun Register(navController: NavController){
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameVal =  remember{ mutableStateOf(value = "") }
    val emailVal =  remember{ mutableStateOf(value = "") }
    val phoneVal =  remember{ mutableStateOf(value = "") }
    val passwordVal =  remember{ mutableStateOf(value = "") }
    val confirmPasswordVal =  remember{ mutableStateOf(value = "") }
    val passwordVisibility = remember{ mutableStateOf(false)}
    val confirmPasswordVisibility = remember{ mutableStateOf(false)}


    Box(
      modifier =  Modifier.fillMaxSize(),
      contentAlignment = Alignment.BottomCenter,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        contentAlignment = Alignment.TopCenter,
                        content = {
                            Image(
                                    painter = painterResource(id = drawable.register_img),
                                    contentDescription = "Register Image",
                                    modifier = Modifier
                                        .width(175.dp)
                                        .height(175.dp),
                                    contentScale = ContentScale.Fit)
                        }
                    )
                    Scaffold(
                            modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,
                    content = {
                        Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(30.dp))
                                    .background(Color.LightGray)
                                    .padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                content =  {
                                    Text(
                                            text = "Sign Up",
                                            fontSize = 30.sp,
                                            fontWeight = FontWeight.Bold,
                                    )
                                    Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            content = {
                                                OutlinedTextField(
                                                        value = nameVal.value,
                                                        onValueChange = {
                                                                      nameVal.value = it
                                                                  },
                                                        label = { Text(text = "Name")},
                                                        placeholder = { Text(text = "Name") },
                                                        singleLine = true,
                                                        modifier = Modifier.fillMaxWidth(0.8f)
                                                )
                                                OutlinedTextField(
                                                        value = emailVal.value,
                                                        onValueChange = {
                                                            emailVal.value = it
                                                        },
                                                        label = { Text(text = "Email Address")},
                                                        placeholder = { Text(text = "Email Address") },
                                                        singleLine = true,
                                                        modifier = Modifier.fillMaxWidth(0.8f),
                                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                                                )
                                                OutlinedTextField(
                                                        value = phoneVal.value,
                                                        onValueChange = {
                                                            phoneVal.value = it
                                                        },
                                                        label = { Text(text = "Phone Number")},
                                                        placeholder = { Text(text = "Phone Number") },
                                                        singleLine = true,
                                                        modifier = Modifier.fillMaxWidth(0.8f),
                                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                                                )
                                                OutlinedTextField(
                                                        value = passwordVal.value,
                                                        onValueChange = {
                                                            passwordVal.value = it
                                                        },
                                                        label = { Text(text = "Password")},
                                                        placeholder = { Text(text = "Password") },
                                                        singleLine = true,
                                                        modifier = Modifier.fillMaxWidth(0.8f),
                                                        trailingIcon = {
                                                            IconButton(
                                                                    onClick = {
                                                                        passwordVisibility.value = !passwordVisibility.value
                                                                    },
                                                            content = {
                                                                Icon(
                                                                        painter = painterResource(id = drawable.password_eye),
                                                                        contentDescription = "Password Eye",
                                                                        tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                                                )
                                                            },
                                                            )
                                                        },
                                                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
                                                )
                                                OutlinedTextField(
                                                        value = confirmPasswordVal.value,
                                                        onValueChange = {
                                                            confirmPasswordVal.value = it
                                                        },
                                                        label = { Text(text = "Password")},
                                                        placeholder = { Text(text = "Password") },
                                                        singleLine = true,
                                                        modifier = Modifier.fillMaxWidth(0.8f),
                                                        trailingIcon = {
                                                            IconButton(
                                                                    onClick = {
                                                                        confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                                                                    },
                                                                    content = {
                                                                        Icon(
                                                                                painter = painterResource(id = drawable.password_eye),
                                                                                contentDescription = "Password Eye",
                                                                                tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                                                        )
                                                                    },
                                                            )
                                                        },
                                                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
                                                )
                                                Spacer(modifier = Modifier.padding(10.dp))

                                                Button(
                                                        onClick = {
                                                            when {
                                                                nameVal.value.isEmpty() -> Toast.makeText(context, "Please enter the name!", Toast.LENGTH_SHORT).show()
                                                                emailVal.value.isEmpty() -> Toast.makeText(context, "Please enter the email address!", Toast.LENGTH_SHORT).show()
                                                                phoneVal.value.isEmpty() -> Toast.makeText(context, "Please enter the phone number!", Toast.LENGTH_SHORT).show()
                                                                passwordVal.value.isEmpty() -> Toast.makeText(context, "Please enter password!", Toast.LENGTH_SHORT).show()
                                                                confirmPasswordVal.value.isEmpty() -> Toast.makeText(context, "Please enter confirm password!", Toast.LENGTH_SHORT).show()
                                                                else -> Toast.makeText(context, "Successfully Registered!", Toast.LENGTH_SHORT).show()
                                                            }
                                                        },
                                                        content = {
                                                            Text(text = "Sign Up", fontSize = 20.sp)
                                                        }
                                                )
                                                Spacer(modifier = Modifier.padding(5.dp))

                                                Text(
                                                        text = "Login Instead",
                                                        modifier = Modifier.clickable(onClick = {
                                                            navController.navigate("login_page")
                                                        })
                                                )
                                            }
                                    )
                                }

                        )
                    })
                }
            )
        }
    )

}