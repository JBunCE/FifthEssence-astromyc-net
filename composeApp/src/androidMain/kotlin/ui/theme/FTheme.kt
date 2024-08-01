package ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

private val colorScheme = ColorScheme(
    primary = Color(64, 9, 165, 255), // Color principal violeta oscuro
    onPrimary = Color(0xFFFFFFFF), // Color del texto en el botón primario
    primaryContainer = Color(0xFFD1C4E9), // Color de fondo del contenedor primario
    onPrimaryContainer = Color(0xCB512DA8), // Color del texto en el contenedor primario
    inversePrimary = Color(0xFFD1C4E9), // Color primario inverso
    secondary = Color(156, 88, 203), // Color secundario violeta más claro
    onSecondary = Color(0xFFFFFFFF), // Color del texto en el botón secundario
    secondaryContainer = Color(0xFF9575CD), // Color de fondo del contenedor secundario
    onSecondaryContainer = Color(0xFF311B92), // Color del texto en el contenedor secundario
    tertiary = Color(0xFFE1BEE7), // Color terciario
    onTertiary = Color(0xFF000000), // Color del texto en el botón terciario
    tertiaryContainer = Color(0xFFBA68C8), // Color de fondo del contenedor terciario
    onTertiaryContainer = Color(0xFF4A148C), // Color del texto en el contenedor terciario
    background = Color(0xFF121212), // Color de fondo general
    onBackground = Color(0xFFFFFFFF), // Color del texto en el fondo general
    surface = Color(0x65212121), // Color de superficie
    onSurface = Color(0xFFFFFFFF), // Color del texto en la superficie
    surfaceVariant = Color(0xFF424242), // Variante de color de superficie
    onSurfaceVariant = Color(0xFFBDBDBD), // Color del texto en la variante de superficie
    surfaceTint = Color(0xFF7F39FB), // Tinte de la superficie
    inverseSurface = Color(0xFFFFFFFF), // Color inverso de la superficie
    inverseOnSurface = Color(0xFF000000), // Color inverso del texto en la superficie
    error = Color(0xFFCF6679), // Color de error
    onError = Color(0xFFFFFFFF), // Color del texto en el color de error
    errorContainer = Color(0xFFB00020), // Color de fondo del contenedor de error
    onErrorContainer = Color(0xFFCF6679), // Color del texto en el contenedor de error
    outline = Color(0xFFBDBDBD), // Color de contorno
    outlineVariant = Color(0xFF757575), // Variante de color de contorno
    scrim = Color(0xFF000000), // Color del scrim
    surfaceBright = Color(0xFF484848), // Color de superficie brillante
    surfaceDim = Color(0xFF1B1B1B), // Color de superficie tenue
    surfaceContainer = Color(0xFF2C2C2C), // Color de contenedor de superficie
    surfaceContainerHigh = Color(0xFF3C3C3C), // Color de contenedor de superficie alto
    surfaceContainerHighest = Color(0xFF4D4D4D), // Color de contenedor de superficie más alto
    surfaceContainerLow = Color(0xFF242424), // Color de contenedor de superficie bajo
    surfaceContainerLowest = Color(0xFF121212) // Color de contenedor de superficie más bajo
)

@RequiresApi(Build.VERSION_CODES.O)
private val Typography = Typography(
    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

@Composable
fun FTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}