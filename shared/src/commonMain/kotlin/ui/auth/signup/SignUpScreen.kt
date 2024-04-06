package ui.auth.signup

import BackgroundColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.SelfManagedTextField
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.app_name
import rdv_mobile.shared.generated.resources.ic_back
import rdv_mobile.shared.generated.resources.sign_up_btn_back
import rdv_mobile.shared.generated.resources.sign_up_btn_next
import rdv_mobile.shared.generated.resources.sign_up_header
import rdv_mobile.shared.generated.resources.sign_up_input_birthday
import rdv_mobile.shared.generated.resources.sign_up_input_city
import rdv_mobile.shared.generated.resources.sign_up_input_country
import rdv_mobile.shared.generated.resources.sign_up_input_email
import rdv_mobile.shared.generated.resources.sign_up_input_fio
import rdv_mobile.shared.generated.resources.sign_up_input_gender
import rdv_mobile.shared.generated.resources.sign_up_input_nickname
import rdv_mobile.shared.generated.resources.sign_up_input_phone

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun SignUpScreen(
    component: SignUpComponent
) {

    val state by component.state.collectAsState()

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = BackgroundColor
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Text(
                    text = stringResource(Res.string.sign_up_header),
                    color = Color(89, 72, 136),
                    fontSize = 40.sp,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally)
                )

                LazyColumn(
                    modifier = Modifier
                        .imePadding()
                        .padding(bottom = 16.dp)

                ) {

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        Icon(
//                            painter = PainterRes.loginBackground(),
//                            contentDescription = ""
//                        )

//                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_fio)) { data ->
//                            return@InputValidateField data.isNotBlank()
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_fio),
                            validator = { input -> input.matches(Regex("\\+7[0-9]{10}")) },
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        InputValidateField(placeholders = stringResource(R.string.sign_up_input_nickname)) { data ->
//                            return@InputValidateField data.count() > 5
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_nickname),
                            validator = { input -> input.count() > 5},
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_gender)) { data ->
//                            return@InputValidateField data.count() > 5
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_gender),
                            validator = { input -> input.count() > 5},
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_phone)) { data ->
//                            return@InputValidateField data.count() > 5
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_phone),
                            validator = { input -> input.count() > 5},
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_email)) { data ->
//                            return@InputValidateField data.count() > 5
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_email),
                            validator = { input -> input.count() > 5},
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_country)) { data ->
//                            return@InputValidateField data.count() > 5
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_country),
                            validator = { input -> input.count() > 5},
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )

                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_city)) { data ->
//                            return@InputValidateField data.count() > 5
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_city),
                            validator = { input -> input.count() > 5},
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

//                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_birthday)) { data ->
//                            return@InputValidateField data.count() > 5
//                        }
                        SelfManagedTextField(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                            label = stringResource(Res.string.sign_up_input_birthday),
                            validator = { input -> input.count() > 5},
                            onValidationFailed = { /* Ваш код для обработки ошибки */ }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 64.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Button(
                                modifier = Modifier
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                ),
                                enabled = true,
                                onClick = {
//                                    component.onBackClicked()
                                }) {
                                Text(
                                    text = stringResource(Res.string.sign_up_btn_back),
//                                    stringResource(id = R.string.sign_up_btn_back),
                                    color = Color(0xFF594888),
                                    fontSize = 16.sp
                                )
                            }

                            Button(
                                modifier = Modifier
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFF1EAFF)
                                ),
                                enabled = true,
                                shape = RoundedCornerShape(4.dp),
                                onClick = {

                                }) {
                                Text(
                                    text = stringResource(Res.string.sign_up_btn_next),
//                                    "",
//                                    stringResource(id = R.string.sign_up_btn_next),
                                    color = Color(0xFF594888),
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}