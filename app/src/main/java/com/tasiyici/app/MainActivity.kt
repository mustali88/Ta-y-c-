package com.tasiyici.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Lacivert = Color(0xFF071421)
private val Panel = Color(0xFF102638)
private val Altin = Color(0xFFD6AE62)
private val Beyaz = Color(0xFFF4F1E9)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasiyiciApp()
        }
    }
}

@Composable
fun TasiyiciApp() {
    var sayfa by remember { mutableStateOf("Başlangıç") }

    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Altin,
            background = Lacivert,
            surface = Panel,
            onPrimary = Lacivert,
            onBackground = Beyaz,
            onSurface = Beyaz
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Lacivert
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {
                Text(
                    "TAŞIYICI",
                    color = Altin,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    "İş ve tahsilat takip sistemi",
                    color = Beyaz.copy(alpha = 0.7f),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                if (sayfa != "Başlangıç") {
                    TextButton(onClick = { sayfa = "Ana Sayfa" }) {
                        Text("← Ana Sayfaya Dön", color = Altin)
                    }
                }

                when (sayfa) {
                    "Başlangıç" -> BaslangicEkrani {
                        sayfa = "Ana Sayfa"
                    }

                    "Alınan Ödemeler" -> BilgiEkrani(
                        "ALINAN ÖDEMELER",
                        "Tahsilat kayıtları burada tutulacak."
                    )

                    "Yapılan İşler" -> BilgiEkrani(
                        "YAPILAN İŞLER",
                        "İş detayları, bütçe ve ödeme durumları burada tutulacak."
                    )

                    "Masraflar" -> BilgiEkrani(
                        "MASRAFLAR",
                        "Yakıt, ceza, yemek, tamir ve diğer masraflar burada tutulacak."
                    )

                    "Alınan Avans" -> BilgiEkrani(
                        "ALINAN AVANS",
                        "Avans kayıtları burada tutulacak."
                    )

                    "Taksitler" -> BilgiEkrani(
                        "TAKSİTLER",
                        "Borç ve taksit ödemeleri burada takip edilecek."
                    )

                    "Yedekleme" -> BilgiEkrani(
                        "YEDEKLEME",
                        "Verileri yedekleme ve geri yükleme bölümü burada olacak."
                    )

                    else -> AnaSayfa { sayfa = it }
                }
            }
        }
    }
}

@Composable
fun BaslangicEkrani(devam: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "TAŞIYICI",
            color = Altin,
            fontSize = 38.sp,
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Bu binekleri emrimize veren, onlardan rızık elde etmeyi bize nasip eden Allah’ın şanı ne yücedir.",
            color = Beyaz,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Zuhruf: 13", color = Altin)

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = devam,
            colors = ButtonDefaults.buttonColors(
                containerColor = Altin
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Başlarken", color = Lacivert)
        }
    }
}

@Composable
fun AnaSayfa(ac: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Ana Menü",
            color = Altin,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        val bolumler = listOf(
            "Alınan Ödemeler",
            "Yapılan İşler",
            "Masraflar",
            "Alınan Avans",
            "Taksitler",
            "Yedekleme"
        )

        bolumler.forEach { bolum ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Panel
                ),
                onClick = { ac(bolum) }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        bolum,
                        color = Beyaz,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text("›", color = Altin, fontSize = 25.sp)
                }
            }
        }
    }
}

@Composable
fun BilgiEkrani(baslik: String, aciklama: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Lacivert)
            .padding(12.dp)
    ) {
        Text(
            baslik,
            color = Altin,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            aciklama,
            color = Beyaz,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Bu bölümün kayıt formları ve veri saklama sistemi sonraki geliştirme adımında eklenecek.",
            color = Beyaz.copy(alpha = 0.65f),
            fontSize = 13.sp
        )
    }
}
