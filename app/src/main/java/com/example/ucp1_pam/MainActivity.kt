package com.example.ucp1_pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ucp1_pam.ui.theme.UCP1_PAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UCP1_PAMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    inputData(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
