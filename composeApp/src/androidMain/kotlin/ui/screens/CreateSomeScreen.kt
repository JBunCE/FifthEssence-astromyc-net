package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import data.UserLocalDataRepository
import ui.components.FButtonWithMod
import ui.components.FCustomButton
import ui.components.FText
import ui.model.CreateSomeViewModel

@Composable
fun CreateSomeScreen(
    createSomeViewModel: CreateSomeViewModel = viewModel()
) {
    val context = LocalContext.current
    val userRepository = remember {
        UserLocalDataRepository(context)
    }

    val user by userRepository.user.collectAsState(initial = null)

    user?.let {
        createSomeViewModel.setAuthorId(it.id)
    }

    Column(
        Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            FText(text = "Write something", fontSize = 18)
            FButtonWithMod(content = {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = "Create",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    FText(text = "Attach Image", fontSize = 15)
                }
            }, onClick = { /*TODO*/}, modifier = Modifier.height(40.dp))
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        PostTextField(onValueChange = createSomeViewModel::onBodyChanged)
        Spacer(modifier = Modifier.height(10.dp))
        FCustomButton(content = {
           Row (
               verticalAlignment = Alignment.CenterVertically
           ) {
                Icon(
                     Icons.Rounded.DateRange,
                     contentDescription = "Post",
                     tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                FText(text = "Mark as event", fontSize = 15)
           }
        }, onClick = { /*TODO*/ })

        Spacer(modifier = Modifier.height(15.dp))

        FCustomButton(content = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Rounded.Create,
                    contentDescription = "Post",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                FText(text = "Post", fontSize = 15)
            }
        }, onClick = {
            createSomeViewModel.createPublication()
        })
    }
}

@Composable
fun PostTextField(
    onValueChange: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = text,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.small
            )
            .padding(20.dp)
            .fillMaxWidth()
            .height(200.dp),
        textStyle = LocalTextStyle.current.copy(color = Color.White),
        onValueChange = {
            text = it
            onValueChange(it)
        },
        decorationBox = { innerTextField ->
            if (text == "" || text.isEmpty()) {
                Row {
                    FText(text = "Body", fontSize = 15)
                }
            }
            innerTextField()
        }
    )
}