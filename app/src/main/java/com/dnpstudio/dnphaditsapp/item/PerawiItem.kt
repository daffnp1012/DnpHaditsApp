package com.dnpstudio.dnphaditsapp.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dnpstudio.dnphaditsapp.data.source.remote.model.PerawiResponseItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerawiItem(
    modifier: Modifier,
    perawi: PerawiResponseItem,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(Color.DarkGray)
    )  {
        Row(modifier.fillMaxWidth()){
            Column(
                modifier = modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    perawi.name,
                    fontSize = 21.sp,
                    color = Color.White
                )
                Spacer(modifier = modifier.height(12.dp))
                Text(
                    "Total Hadits: ${perawi.total}",
                    color = Color.White
                )
            }
        }
    }
}