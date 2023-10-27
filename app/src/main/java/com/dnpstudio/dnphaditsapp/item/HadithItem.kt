package com.dnpstudio.dnphaditsapp.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HadithItem(modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(Color.LightGray)
    )  {
        Row(modifier.fillMaxWidth()){
            Column(
                modifier = modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier.padding()
                ) {
                    Text(
                        text = "Perawi",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = modifier.width(12.dp))
                    Text(
                        text = "0",
                        modifier = modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 20.dp),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = modifier.height(12.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed id turpis in mauris porttitor aliquet. Suspendisse urna sapien, mollis sed.",
                    fontSize = 15.sp,
                )
                Spacer(modifier = modifier.height(12.dp))
                Text(
                    text = "Artinya:",
                    fontSize = 15.sp,
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed id turpis in mauris porttitor aliquet. Suspendisse urna sapien, mollis sed.",
                    fontSize = 15.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HadithItemPreview(){
    HadithItem(modifier = Modifier)
}