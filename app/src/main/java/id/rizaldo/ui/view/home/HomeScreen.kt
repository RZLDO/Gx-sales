package id.rizaldo.ui.view.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import id.rizaldo.R
import id.rizaldo.ui.theme.neutral100
import id.rizaldo.ui.theme.neutral300
import id.rizaldo.ui.theme.neutral40
import id.rizaldo.ui.theme.neutral400
import id.rizaldo.ui.theme.primaryColor
import id.rizaldo.ui.view.profile.ProfileViewModel
import io.eyram.iconsax.IconSax

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel : ProfileViewModel = hiltViewModel()
){
    val profileUiState = viewModel.uiState.collectAsStateWithLifecycle()
    Column {
        Row(
            modifier  = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            AsyncImage(
                model = "",
                contentDescription = "",
                placeholder = painterResource(id = R.drawable.icon_login),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(45.dp)
                    .width(45.dp)
                    .clip(shape = CircleShape))
            Column {
                Text(text = profileUiState.value.profileData.name, style =MaterialTheme.typography.bodyLarge.copy(

                ))
                Text(text = profileUiState.value.profileData.email,style =MaterialTheme.typography.bodySmall.copy(
                    fontSize = 10.sp
                ))
            }
        }
        HorizontalDivider()

        Box(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .border(width = 1.dp, color = neutral400, shape = RoundedCornerShape(9.dp))
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(painter = painterResource(id = IconSax.Linear.Calendar), contentDescription = "", tint = neutral100)
                Text("01 Jan 2024 - 31 Jan 2024", style = MaterialTheme.typography.titleMedium.copy(
                    color = neutral100
                ))
            }
        }
        LazyVerticalGrid(
            columns =  GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
        ) {
            items(4){
                Box(
                   modifier = Modifier
                       .padding(8.dp)
                       .fillMaxWidth()
                       .border(width = 1.dp, color = neutral400, shape = RoundedCornerShape(9.dp))
                       .padding(16.dp)
                ){
                    Column {
                        Text(text = "15", style = MaterialTheme.typography.titleLarge.copy(
                            color = primaryColor,
                            fontSize = 34.sp
                        ))
                        Text(text = "Total All Leads", style = MaterialTheme.typography.titleSmall.copy(
                            color = neutral300,
                            fontSize = 16.sp
                        ))
                    }
                }
            }
        }
    }
}
