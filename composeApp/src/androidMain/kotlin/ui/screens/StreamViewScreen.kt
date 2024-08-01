package ui.screens

import FifthEssenceScreens
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ui.model.CheckoutViewModel
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData
import com.google.android.gms.wallet.PaymentDataRequest
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.button.ButtonOptions
import com.google.pay.button.ButtonType
import com.google.pay.button.PayButton
import core.bunstream.StreamData
import core.bunstream.StreamRequest
import core.payment.allowedPaymentMethods
import core.payment.createPaymentsClient
import core.payment.getPaymentDataRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ui.components.CommentCard
import ui.components.FButton
import ui.components.FButtonWithMod
import ui.components.FText
import ui.components.FTextField
import ui.components.InteractionBar
import ui.components.UserLabel
import java.net.Socket

fun decodeBase64(input: String): ByteArray? {
    // Validate Base64 string (basic example, consider a more robust validation)
    val base64Regex = "^[A-Za-z0-9+/]+={0,2}$".toRegex()
    if (!base64Regex.matches(input.replace("\n", ""))) {
        println("Invalid Base64 input")
        return null
    }

    return try {
        Base64.decode(input, Base64.DEFAULT)
    } catch (e: IllegalArgumentException) {
        println("Failed to decode Base64: ${e.message}")
        null
    }
}

@Composable
fun StreamViewData(streamId : Int) {
    var currentFrame by remember { mutableStateOf<Bitmap?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = "socket_connection") {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val socket = Socket("192.168.0.109", 1935)
                val outputStream = socket.getOutputStream()
                val message = StreamRequest("Connect", StreamData(0, streamId)).toJson()
                outputStream.write(message.toByteArray())
                outputStream.flush()

                val buffer = ByteArray(10000000)
                val inputStream = socket.getInputStream()
                var bytesRead: Int
                var frameData = ""
                while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                    frameData += String(buffer, 0, bytesRead)
                    // Check for the end of a complete frame
                    if (frameData.endsWith("$")) {
                        frameData = frameData.removeSuffix("$") // Remove the delimiter
                        // Validate and decode Base64
                        if (decodeBase64(frameData) != null) {
                            val imageBytes = Base64.decode(frameData, Base64.DEFAULT)
                            val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                            if (bitmap != null) {
                                withContext(Dispatchers.Main) {
                                    currentFrame = bitmap
                                }
                            } else {
                                println("Failed to decode bitmap, result is null")
                            }
                        }
                        frameData = "" // Reset for the next frame
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    currentFrame?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
    }
}
@Composable
fun StreamComponent(currentFrame: Bitmap?) {
    currentFrame?.let {
        Image(bitmap = it.asImageBitmap(), contentDescription = null, modifier = Modifier
            .fillMaxWidth()
            .height(250.dp))
    }
}

@Composable
fun StreamViewScreen(
    navHostController: NavHostController,
    streamId: Int
) {

    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var donationAmount by remember { mutableStateOf(0) }
    val paymentClient = createPaymentsClient(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row (
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier.width(100.dp),
            ) {
                UserLabel()
            }
            Box(modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .height(35.dp)
                .width(100.dp),
                contentAlignment = Alignment.Center
            ) {
                FText(text = "Live", fontSize = 13, color = Color.Red)
            }
            FButtonWithMod(
                content = { FText(text = "Donate", fontSize = 12) },
                onClick = {
                    showDialog = true
                },
                modifier = Modifier
                    .height(35.dp)
                    .width(100.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            StreamViewData(streamId)
        }
        InteractionBar()
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            CommentCard("Nice stream!")
            Spacer(modifier = Modifier.height(10.dp))
            CommentCard("Ta muy bonito")
            Spacer(modifier = Modifier.height(10.dp))
            CommentCard("Actually I don't like it")
            Spacer(modifier = Modifier.height(10.dp))
            CommentCard("You are the best streamer that i was knew!")
            Spacer(modifier = Modifier.height(10.dp))
            CommentCard("Nice stream!")
        }

        ButtonOptions.newBuilder().setAllowedPaymentMethods(allowedPaymentMethods.toString()).build()

        if (showDialog) {
            AlertDialog(
                containerColor = MaterialTheme.colorScheme.primary,
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    FButton(text = "Donate") {
                        navHostController.navigate(FifthEssenceScreens.PAYMENT.name)
                    }
                },
                text = {
                    FTextField(
                        placeholder = "30",
                        onValueChange = { donationAmount = it.toInt() },
                        Extra = { FText("$", 17) }
                    )
                }
            )
        }
    }
}

@Composable
fun ComposeWebView() {
    // AndroidView permite integrar una vista de Android en Compose
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient() // Maneja la navegación interna en el WebView
                settings.javaScriptEnabled = true // Habilita JavaScript
                loadUrl("https://buy.stripe.com/00g8x36sUgiP44o6oo") // Carga la URL inicial
            }
        },
        update = { webView ->
            webView.loadUrl("https://buy.stripe.com/00g8x36sUgiP44o6oo") // Actualiza la URL si es necesario, útil si la URL es dinámica
        }
    )
}