package com.example.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_basics.ui.theme.Compose_basicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_basicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}


@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose", "Blannon Network")
){
    Column(modifier = modifier .padding(vertical = 4.dp)) {
            for (name in names){
                MyApp1(name = name)
            }

        }


}
@Composable
fun MyApp1(name: String){

    val expanded = remember{ mutableStateOf(false)}

    val extrapadding =if(expanded.value) 48.dp else 0.dp
    Surface (
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)){

        Row (
            modifier = Modifier
                .padding(24.dp)
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extrapadding))

            {
                Text(text ="Hello ")
                Text(text = name)

            }

            ElevatedButton(onClick = {expanded.value = !expanded.value}) {

                Text(if (expanded.value) "Show Less" else "Show More" )
                
            }
        }

    }


}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppPreview(){
  Compose_basicsTheme{
        MyApp( )
    }

}