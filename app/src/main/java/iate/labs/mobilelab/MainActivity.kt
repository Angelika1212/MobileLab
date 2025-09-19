package iate.labs.mobilelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import iate.labs.mobilelab.ui.theme.MobileLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileLabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskImage(
                    )
                }
            }
        }
    }
}

@Composable
fun TaskImage(modifier: Modifier = Modifier){
    val img = painterResource(R.drawable.background_image)
    Box(modifier) {
        Image(
            painter = img,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
        )
        TaskCalculator(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        )

    }

}

@Composable
fun TaskCalculator(modifier: Modifier = Modifier){
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val calculator: Calculator = Calculator()

    Column (
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.padding(bottom = 50.dp)
    ) {
        Text(
            text = "Сгенерированный список:",
            color = Color.White,
            fontSize = 20.sp
        )

        TextField(
            value = input,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )

        Text(
            text = "Вычисленный результат:",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp)
        )

        TextField(
            value = result,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )

        ElevatedButton(
            onClick = {
                val generatedList = calculator.getGenerateArray()
                input = generatedList.toString()
                result = calculator.calculateAverage(generatedList).toString()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)) {
            Text(text = "Вычислить среднее",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    MobileLabTheme {
    }
}