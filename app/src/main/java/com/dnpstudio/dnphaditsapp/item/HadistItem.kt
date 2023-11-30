package com.dnpstudio.dnphaditsapp.item

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dnpstudio.dnphaditsapp.R

@Composable
fun HadistItem(
    modifier: Modifier,
    noHadits: Int,
    hadits: String,
    translate: String,

) {

    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, hadits)
        type = "text/plain"
    }
    val share = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hadist Ke-${noHadits.toString()}",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = hadits,
                textAlign = TextAlign.Right
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Artinya:", fontWeight = FontWeight.Bold)
            Text(text = translate)

            Row(
                modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 6.dp,
                        vertical = 12.dp
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_content_copy_24),
                    contentDescription = "",
                    modifier
                        .clickable {
                            clipboardManager.setText(AnnotatedString(hadits))
                            Toast.makeText(context, "Copied Successfully", Toast.LENGTH_SHORT).show()
                        }
                )
                Spacer(modifier = modifier.width(18.dp))
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "",
                    modifier
                        .clickable {
                            context.startActivity(share)
                        }
                )
            }
        }
    }
}