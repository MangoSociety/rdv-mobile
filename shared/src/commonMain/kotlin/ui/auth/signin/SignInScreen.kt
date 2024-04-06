package ui.auth.signin

import BackgroundColor
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.SelfManagedTextField
import components.Star
import components.StarAndStick



@Composable
internal fun SignInScreen(component: SignInComponent) {
    val state by component.state.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = BackgroundColor
    ) {

        Box(modifier = Modifier.fillMaxSize().padding(it)) {

            Row(
                modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
            ) {

//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.5f, 0.4f, Color(0xFFFFF4BA), 80.dp, 450.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.2f, 0.7f, Color.White, 80.dp, 250.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.5f, 0.5f, Color(0xFFC3ACE9), 80.dp, 450.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.3f, 0.6f, Color(0xFFC3ACE9), 80.dp, 250.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.5f, 0.4f, Color(0xFFC3ACE9), 80.dp, 450.dp))

                StarAndStick(
                    modifier = Modifier.weight(2.5f),
                    star = Star(20.dp, 0.5f, 0.4f, Color(0xFFF1EAFF), 200.dp, 1000.dp)
                )

                StarAndStick(
                    modifier = Modifier.weight(1.7f),
                    star = Star(20.dp, 0.3f, 0.6f, Color(0xFFF1EAFF), 300.dp, 1100.dp)
                )

                StarAndStick(
                    modifier = Modifier.weight(2f),
                    star = Star(20.dp, 0.5f, 0.4f, Color(0xFFF1EAFF), 100.dp, 1500.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(24.dp)
            ) {

                Text(
                    "Вход",
                    color = Color(89, 72, 136),
                    fontSize = 64.sp,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(bottom = 48.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                SelfManagedTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                    label = "email или телефон",
                    validator = { input -> input.matches(Regex("\\+7[0-9]{10}")) },
                    onValidationFailed = { /* Ваш код для обработки ошибки */ }
                )

//                ValidatedTextField(
//                    value = "",
//                    onValueChange = {},
//                    validator = { input -> input.matches(Regex("Паттерн для проверки номера")) },
//                    label = { Text("Номер телефона") },
//                    errorText = "Не правильно введен номер"
//                )

//                BasicInputValidateField(
//                    placeholders = "input email",
//                    onChangeData = { email = it }
//                ) { data ->
//                    return@BasicInputValidateField data.contains("@")
//                }

                Spacer(modifier = Modifier.height(16.dp))

                SelfManagedTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                    label = "пароль",
                    validator = { input -> input.length > 5 },
                    onValidationFailed = { /* Ваш код для обработки ошибки */ }
                )

//                BasicInputValidateField(
//                    placeholders = "input password",
//                    onChangeData = { password = it }
//                ) { data ->
//                    return@BasicInputValidateField data.count() > 5
//                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier
                        .width(110.dp)
                        .height(40.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF1EAFF)
                    ),
                    enabled = true,
                    shape = RoundedCornerShape(4.dp),
                    onClick = {
//                        component.onEvent(SignInStore.Intent.SignInState(email, password))
                    }) {
                    Text(
                        "войти", color = Color(0xFF594888),
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "восстановить пароль", color = Color(0xFF594888),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }

            Text(
                "зарегестрироваться", color = Color(0xFF594888),
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .clickable {
                        component.toSignUp()
                    }
            )
        }

//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
//
//            Row(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.5f, 0.4f, Color(0xFFFFF4BA), 80.dp, 450.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.2f, 0.7f, Color.White, 80.dp, 250.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.5f, 0.5f, Color(0xFFC3ACE9), 80.dp, 450.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.3f, 0.6f, Color(0xFFC3ACE9), 80.dp, 250.dp))
//                StarAndStick(Modifier.weight(1f),Star(20.dp, 0.5f, 0.4f, Color(0xFFC3ACE9), 80.dp, 450.dp))
//            }
//
//
//
////            Text("sdfdsfijdfsjdnfisdsfijdfsijndsfijn")
//        }

    }

}