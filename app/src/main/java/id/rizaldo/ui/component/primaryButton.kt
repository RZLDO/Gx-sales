package id.rizaldo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import id.rizaldo.ui.theme.blackColor

@Composable
fun PrimaryButton(
    text : String,
    icon:  Int? = null,
    enable : Boolean = true,
    onClickListener : ()-> Unit = {}
){
    Button(
        shape = RoundedCornerShape(8.dp),
        enabled = enable,
        onClick = { onClickListener()}
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(text = text, style = MaterialTheme.typography.bodyMedium.copy(
                color = blackColor
            ))
            if(icon!= null){
                Icon(painter = painterResource(id = icon), contentDescription = "icon button")
            }
        }
    }
}