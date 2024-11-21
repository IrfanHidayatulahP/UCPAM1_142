package com.example.ucp1_pam

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun inputData(modifier: Modifier) {

    var asalKota by remember { mutableStateOf("") }
    var kotaTujuan by remember { mutableStateOf("") }
    var keberangkatan by remember { mutableStateOf("") }
    var kedatangan by remember { mutableStateOf("") }
    var jenisKlass by remember { mutableStateOf("") }

    var klass = listOf("Ekonomi", "Bussiness")

    var confAsal by remember { mutableStateOf("") }
    var confTujuan by remember { mutableStateOf("") }
    var confKeberangkatan by remember { mutableStateOf("") }
    var confKedatangan by remember { mutableStateOf("") }
    var confKlass by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(14.dp)
                ) {
                    Text(text = "Good Afternoon, ")
                    Text(text = "Irfan Hidayatulah Putra")
                }
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription =  null,
                    modifier = Modifier.size(30.dp).background(Color.Blue)
                )
            }
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = asalKota,
                onValueChange = { asalKota = it },
                label = {
                    Text(text = "Asal")
                        },
                placeholder = {
                    Text(text = "Masukkan Asal Kota Anda")
                              },
                modifier = Modifier.fillMaxWidth()
                    .padding(5.dp)
                )

            TextField(
                value = kotaTujuan,
                onValueChange = { kotaTujuan = it },
                label = {
                    Text(text = "Tujuan")
                        },
                placeholder = {
                    Text(text = "Masukkan Kota Tujuan Anda")
                    },
                modifier = Modifier.fillMaxWidth()
                    .padding(5.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = keberangkatan,
                    onValueChange = { keberangkatan = it },
                    label = {
                        Text(text = "Tanggal")
                        },
                    placeholder = {
                        Text(text = "Tgl Berangkat")
                        },
                    )
                TextField(
                    value = kedatangan,
                    onValueChange = { kedatangan = it },
                    label = {
                        Text(text = "Tanggal")
                        },
                    placeholder = {
                        Text(text = "Tgl Datang")
                        },
                    )
                }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                klass.forEach { selectedKlass ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = jenisKlass == selectedKlass,
                            onClick = {
                                jenisKlass == selectedKlass
                            })
                    }
                    Text(text = selectedKlass)
                }
            }
            Button(onClick = {
                confAsal = asalKota
                confTujuan = kotaTujuan
                confKeberangkatan = keberangkatan
                confKedatangan = kedatangan
                confKlass = jenisKlass
            } ) {
                Text(text = "Submit")
            }

            TampilData(
                param = "Asal",
                argu = confAsal
            )

            TampilData(
                param = "Tujuan",
                argu = confTujuan
            )

            TampilData(
                param = "Tanggal Berangkat",
                argu = confKeberangkatan
            )

            TampilData(
                param = "Tanggal Kedatangan",
                argu = confKedatangan
            )

            TampilData(
                param = "jenisKlass",
                argu = confKlass
            )
        }
    }
}

@Composable
fun TampilData(
    param: String, argu: String
){
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ){
            Text(text = param,
                modifier = Modifier.weight(1f))
            Text(text = ": ",
                modifier = Modifier.weight(0.2f))
            Text(text = argu,
                modifier = Modifier.weight(2f))
        }
    }

}
