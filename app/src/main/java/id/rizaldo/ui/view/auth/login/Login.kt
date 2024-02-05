package id.rizaldo.ui.view.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import id.rizaldo.R
import id.rizaldo.domain.model.auth.PostSignIn
import id.rizaldo.ui.component.button.PrimaryButton
import id.rizaldo.ui.component.textfield.PrimaryTextField
import id.rizaldo.ui.theme.footerColor
import id.rizaldo.ui.view.auth.AuthViewModel
import io.eyram.iconsax.IconSax

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            modifier = Modifier
                .height(130.dp)
                .width(130.dp),
            model = "https://s3-alpha-sig.figma.com/img/fbe0/5ef9/a274b954e44aef88a75beecf25a1b8ae?Expires=1707696000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=bgZCSMpXnS7Cd61KmefUY-GD9L7uLRM6uKW9xiS5pXJESfeEYYq~mPei~ioeLPhJ4WV7k-dWEL~eyOkqaBKUmcdgIerhiJgBY9Oujke~ZhsnpAwI~86u8jgCTHYsLUyb7Hq72hklH~au7WuEDb9SIbH5NIhNfq-2kLlZxSCru2oB0Xtl1O78DhUG~GOcJZ5I59pvWbSii3Qq05EZLUYU1hNitgiUdxBkTxwxHE803ksGdnJyV~kxQf49ep1Ss3XETP6Jz-dIAEWI4r9AvInEWfIZcbAeMY1vhNsA305a0fAXjHyc9tgvCpUC8vUIPfi9bPCteP-Xz~O6DbkaSM9uSA__",
            contentDescription = "Image Apps")
        Spacer(modifier = Modifier.weight(0.2f))
        PrimaryTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            leadingIcon= painterResource(id = IconSax.Linear.Sms),
            textTitle = stringResource(id = R.string.text_email),
            value = "",
            onValueChange ={} ,
            hint = stringResource(id = R.string.email_placeholder))
        PrimaryTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            leadingIcon = painterResource(id = IconSax.Linear.Lock),
            textTitle = stringResource(id = R.string.text_password),
            trailingIcon = painterResource(id = IconSax.Linear.Eye),
            value = "",
            onValueChange ={},
            isPassword = true,
            hint = "OOOOOO")
        PrimaryButton(text = stringResource(id = R.string.cta_sig_in), icon = R.drawable.icon_login){
            viewModel.signIn(data = PostSignIn("admin@globalxtreme.net", "admingx2023"))
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = stringResource(id = R.string.sign_in_footer), style = MaterialTheme.typography.bodySmall.copy(
            color = footerColor
        ))
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenContentPreview() {
    LoginScreen(navController = rememberNavController())
}