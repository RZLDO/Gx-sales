package id.rizaldo.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import id.rizaldo.ui.theme.blackColor
import id.rizaldo.ui.theme.primaryColor

@Composable
fun PrimaryButton(
    text : String,
    icon:  Int? = null,
    enable : Boolean = true,
    onClickListener : ()-> Unit = {}
){
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = primaryColor, shape = RoundedCornerShape(8.dp))
            .clickable {
                Modifier.background(color = primaryColor ,shape = RoundedCornerShape(8.dp))
                onClickListener()
            }
            .padding(vertical = 8.dp, horizontal = 14.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = text, style = MaterialTheme.typography.bodyMedium.copy(
                color = blackColor
            ))
            if(icon!= null){
                Icon(
                    modifier = Modifier.height(20.dp).width(20.dp),
                    painter = painterResource(id = icon), contentDescription = "icon button", tint = blackColor)
            }
        }
    }
}