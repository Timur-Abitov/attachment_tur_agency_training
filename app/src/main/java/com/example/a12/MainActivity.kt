package com.example.a12

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ComponentActivity
import com.example.a12.ui.theme._12Theme
import com.google.gson.Gson
import kotlinx.coroutines.launch

class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _12Theme {
                GreetingPreview()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    val scrollState = rememberScrollState()

    val Products = remember {
        mutableStateOf(false)
    }
    val AboutUs = remember {
        mutableStateOf(false)
    }
    val Support = remember {
        mutableStateOf(false)
    }

    val LogIn = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {},
                navigationIcon={IconToggleButton(
                    checked = LogIn.value,
                    onCheckedChange = {
                        Support.value=false
                        AboutUs.value=false
                        Products.value=false
                    },Modifier.size(85.dp, 40.dp)
                ) {
                    Text(
                        "название",
                        color = Color(0xFFFFFFFF),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }},
                actions = {
                IconToggleButton(
                    checked = Products.value,
                    onCheckedChange = { Products.value = it
                        Support.value=false
                        AboutUs.value=false},
                    modifier = Modifier.size(70.dp, 50.dp)
                ) {
                    Text(
                        "Produst",
                        color = Color(0xFFFFFFFF),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                IconToggleButton(
                    checked = AboutUs.value,
                    onCheckedChange = { AboutUs.value = it
                        Products.value=false
                        Support.value=false},
                    modifier = Modifier.size(80.dp, 50.dp)
                ) {
                    Text(
                        "AboutUs",
                        color = Color(0xFFFFFFFF),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                IconToggleButton(
                    checked = Support.value,
                    onCheckedChange = { Support.value = it
                        Products.value=false
                        AboutUs.value=false},
                    modifier = Modifier.size(70.dp, 50.dp)
                ) {
                    Text(
                        "Support",
                        color = Color(0xFFFFFFFF),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFF1C1508)
            )
            )
        },
        containerColor = Color(0xFFF1C1508),

        ) {


        if (AboutUs.value) {
            Abnutus()
        } else {
            if (Products.value) {
                Produst()
            } else {
                if (Support.value) {
                    Suppor()
                } else {
                    if (LogIn.value) {
                        Login()
                    } else {
                        Column(
                            modifier = Modifier
                                .padding(it)
                                .background(Color(0xFFF1C1508))


                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.padding(10.dp)
                                ) {
                                    Text(
                                        "Tired of ", fontSize = 28.sp, color = Color.White
                                    )
                                    Text(
                                        "sitting at ", fontSize = 28.sp, color = Color.White
                                    )
                                    Text(
                                        "home?", fontSize = 28.sp, color = Color.White
                                    )
                                    Text(
                                        "We can help with that!",
                                        fontSize = 10.sp,
                                        color = Color.White
                                    )

                                    IconToggleButton(
                                        checked = Products.value,
                                        onCheckedChange = {Products.value = it
                                            AboutUs.value=false
                                            Support.value=false},
                                        modifier = Modifier.size(120.dp, 50.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.oval),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier.size(100.dp, 25.dp)
                                        )
                                    }

                                }
                                Image(
                                    painter = painterResource(id = R.drawable.image),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .clip(CircleShape)
                                        .padding(10.dp)

                                )
                            }
                            Box(Modifier.size(500.dp, 1.dp).background(Color.White)) {  }
                            Box(Modifier.size(500.dp,25.dp)) { Text(text = "The most relevant directions", color=Color.White) }

                            Column(modifier = Modifier.verticalScroll(scrollState).fillMaxSize()) {

                                Image(
                                    painter = painterResource(id = R.drawable.turkey),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(400.dp,200.dp)
                                        .clip(CircleShape)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.greece),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(400.dp,200.dp)
                                        .clip(CircleShape)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.turkey),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(400.dp,200.dp)
                                        .clip(CircleShape)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.turkey),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(400.dp,200.dp)
                                        .clip(CircleShape)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.turkey),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(400.dp,200.dp)
                                        .clip(CircleShape)
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun Produst() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val hostel = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(10.dp)
    ) {
        /*Row {
            Image(
                painter = painterResource(id = R.drawable.turkey),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(top = 100.dp, bottom = 10.dp)
            )
        }

        Row{
            Image(
                painter = painterResource(id = R.drawable.tyrkey_flag),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp).size(75.dp,50.dp)
            )
            IconToggleButton(
                checked = hostel.value,
                onCheckedChange = { hostel.value = it },
                modifier = Modifier.size(140.dp, 50.dp)
            ) {
                Text(
                    "отели",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }*/
        if (hostel.value){
            Hostel()
        }

        Row {
            Image(
                painter = painterResource(id = R.drawable.picture1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.picture2),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.picture3),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.picture4),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.picture5),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
            )
        }


    }
}

@Composable
fun Hostel(){
    Column(Modifier.padding(top=10.dp, bottom = 50.dp).fillMaxSize()) { Text("ты че тут ожидал увидеть? Чтоб тут что то было надо чтоб это предоставили!", color = Color.White)  }
}



@Composable
fun Abnutus() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color(0xFFF1C1508))
    ) {

        Box(
            modifier = Modifier
                .padding(0.dp, 45.dp, 0.dp, 0.dp)
                .background(Color(0xFFF1C1508))
        ) {
            Text(
                "▎ О нас\n" + "\n" + "Добро пожаловать в наше тур агентство! Мы - команда опытных профессионалов, увлеченная путешествиями и открытием новых горизонтов. Наша цель - создать незабываемые впечатления для каждого клиента, предлагая индивидуальные маршруты и высококачественные услуги.\n" + "\n" + "▎ Наша миссия\n" + "\n" + "Мы стремимся сделать ваши путешествия легкими и увлекательными. Мы предлагаем широкий выбор туров, от спокойного отдыха на берегу до захватывающих приключений в диких местах.\n" + "\n" + "▎ Почему выбирают нас?\n" + "\n" + "- Индивидуальный подход к каждому клиенту\n" + "- Команда экспертов, готовая ответить на все ваши вопросы\n" + "- Конкурентные цены без скрытых платежей\n" + "- Проверенные партнеры в каждой стране\n" + "\n" + "Присоединяйтесь к нам и откройте для себя мир вместе с нами!",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

// Data class для представления сообщения
data class Message(val text: String, val isUser: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Suppor() {
    var messageText by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(listOf<Message>()) }
    var awaitingReply by remember { mutableStateOf(false) } // Новое состояние

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "ведите 1 для вызова команд")
        // Список сообщений
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true  // Чтобы новые сообщения добавлялись снизу
        ) {
            items(messages.reversed()) { message -> // Отображаем сообщения в обратном порядке
                MessageBubble(message = message)
            }
        }

        // Поле ввода и кнопка отправки
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Enter your message",color=Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(  // Add this line
                    focusedTextColor = Color.White  // And this line
                ),
                enabled = !awaitingReply // Отключаем поле ввода, когда ждем ответ

            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = {
                    if (messageText.isNotBlank() && !awaitingReply) { // Проверяем awaitingReply
                        messages = messages + Message(messageText, true) // Добавляем сообщение пользователя
                        messageText = "" // Очищаем поле ввода
                        awaitingReply = true // Ждем ответ
                        // Simulate reply from support (Replace with actual logic)
                        simulateSupportReply(
                            onReply = { reply ->
                                messages = messages + Message(reply, false) // Добавляем ответ от техподдержки
                                awaitingReply = false // Больше не ждем ответ
                            }
                        )
                    }
                },
                enabled = !awaitingReply,  // Отключаем кнопку, когда ждем ответ
            ) {
                Icon(Icons.Filled.Send, contentDescription = "Send", tint = Color.White)
            }
        }

        if (awaitingReply) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth()) // Индикатор загрузки
        }
    }
}

@Composable
fun MessageBubble(message: Message) {
    val backgroundColor = if (message.isUser) Color.White else Color.LightGray
    val alignment = if (message.isUser) Alignment.BottomEnd else Alignment.BottomStart

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        contentAlignment = alignment
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = backgroundColor,
            modifier = Modifier.padding(4.dp) // Add padding to the surface
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(8.dp),
                color = Color.Black  // Устанавливаем цвет текста в белый
            )
        }
    }
}

// Функция для имитации ответа от техподдержки
fun simulateSupportReply(onReply: (String) -> Unit) {
    Thread {
        Thread.sleep(1000)
        val reply = "Шо надо"
        onReply(reply) // Вызываем функцию обратного вызова с ответом
    }.start()
}

@Composable
fun Login() {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting()

}