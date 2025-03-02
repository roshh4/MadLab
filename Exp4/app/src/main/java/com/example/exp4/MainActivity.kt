    package com.example.exp4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exp4.ui.theme.Exp4Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            // Load StudentBasicDetails fragment in the first container
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer1, StudentBasicDetails())
            .commit()

            // Load StudentMarkDetails fragment in the second container
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer2, StudentMarkDetails())
            .commit()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Exp4Theme {
        Greeting("Android")
    }
}