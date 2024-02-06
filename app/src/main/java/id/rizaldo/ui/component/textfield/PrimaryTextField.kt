package id.rizaldo.ui.component.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.rizaldo.ui.theme.Inter
import id.rizaldo.ui.theme.Poppins
import id.rizaldo.ui.theme.gray300
import id.rizaldo.ui.theme.gray500
import id.rizaldo.ui.theme.primaryColor
import id.rizaldo.ui.theme.redError
import id.rizaldo.utils.ValidationResult

@Composable
fun PrimaryTextField(
    modifier: Modifier,
    readOnly: Boolean = false,
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    value: String,
    isEnable : Boolean = true,
    onValueChange: (String) -> Unit,
    textTitle : String? = null,
    hint: String,
    isPassword : Boolean = false,
    validationResult: ValidationResult? = null,
    trailingClickListener : ()-> Unit = {}
){

    Column {
        if(textTitle != null ){
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = textTitle,
                style = MaterialTheme.typography.bodyMedium)
        }
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            leadingIcon = {
                if (leadingIcon != null) {
                    Icon(leadingIcon, contentDescription = "leading Icon")
                }
            },
            visualTransformation = if(isPassword){
                PasswordVisualTransformation()
            }else {
                VisualTransformation.None
                  },

            readOnly = readOnly,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = gray500,
                        fontSize =12.sp
                    )
                )
            },
            supportingText = {
                if (validationResult != null && !validationResult.isValid) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, bottom = 16.dp).fillMaxWidth() ,
                        text = stringResource(id = validationResult.stringRes),
                        color = redError,
                        fontSize = 12.sp,
                        fontFamily = Inter
                    )
                }
            },
            trailingIcon = {
                if (trailingIcon != null) {
                    Box(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .size(32.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            trailingIcon, contentDescription = "trailing icon",modifier = Modifier.clickable {
                                trailingClickListener()
                            },)
                    }
                }
            },

            textStyle= MaterialTheme.typography.bodySmall.copy(
                color = gray500,
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = gray300,
                unfocusedBorderColor = gray300,
                focusedLeadingIconColor = gray500,
                unfocusedLeadingIconColor = gray500,
                focusedTrailingIconColor = gray500,
                unfocusedTrailingIconColor = gray500,
            ),
            shape = RoundedCornerShape(8.dp),
            enabled =isEnable,
        )
    }
}