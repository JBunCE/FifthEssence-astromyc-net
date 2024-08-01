package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FTextField(
    placeholder: String,
    onValueChange: (String) -> Unit = {},
    Extra: @Composable () -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = text,
        onValueChange = {
            onValueChange(it)
            text = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
            .height(56.dp)
            .padding(16.dp)
            .background(Color.Transparent),
        textStyle = LocalTextStyle.current.copy(color = Color.White),
        decorationBox = { innerTextField ->
            if (text == "" || text.isEmpty()) {
                Row {
                    Extra()
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(placeholder, color = Color.White)
                }
            }
            innerTextField()
        }
    )
}