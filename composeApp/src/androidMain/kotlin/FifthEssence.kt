import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ui.components.BottomBar
import ui.screens.ComposeWebView
import ui.screens.CreateSomeScreen
import ui.screens.LoginScreen
import ui.screens.ProfileScreen
import ui.screens.PublicationsScreen
import ui.screens.RegisterScreen
import ui.screens.ScheduleScreen
import ui.screens.SplashScreen
import ui.screens.StreamScreen
import ui.screens.StreamViewScreen

enum class FifthEssenceScreens {
    SPLASH_SCREEN,
    LOGIN,
    REGISTER,
    HOME,
    STREAMS,
    STREAM_VIEW,
    SCHEDULE,
    PUBLICATIONS,
    PROFILE,
    CREATE_SOMETHING,
    PAYMENT
}


@Composable
fun FifthEssence(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    Scaffold (
        bottomBar = {
            if (currentRoute != FifthEssenceScreens.LOGIN.name &&
                currentRoute != FifthEssenceScreens.REGISTER.name &&
                currentRoute != FifthEssenceScreens.SPLASH_SCREEN.name
            ) {
                BottomBar(navHostController = navController)
            }
        }
    ) {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = FifthEssenceScreens.SPLASH_SCREEN.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = FifthEssenceScreens.SPLASH_SCREEN.name) {
                SplashScreen(navController = navController)
            }
            composable(route = FifthEssenceScreens.LOGIN.name) {
                LoginScreen(navController = navController)
            }
            composable(route = FifthEssenceScreens.REGISTER.name) {
                RegisterScreen(navHostController = navController)
            }
            composable(route = FifthEssenceScreens.PUBLICATIONS.name) {
                PublicationsScreen()
            }
            composable(route = FifthEssenceScreens.PROFILE.name) {
                ProfileScreen()
            }
            composable(route = FifthEssenceScreens.STREAMS.name) {
                StreamScreen(navHostController = navController)
            }
            composable(route = FifthEssenceScreens.SCHEDULE.name) {
                ScheduleScreen()
            }
            composable(route = FifthEssenceScreens.CREATE_SOMETHING.name) {
                CreateSomeScreen()
            }
            composable(route = FifthEssenceScreens.STREAM_VIEW.name + "/{id}") {
                val id = it.arguments?.getString("id")
                StreamViewScreen(navController, streamId = id!!.toInt())
            }
            composable(route = FifthEssenceScreens.PAYMENT.name) {
                ComposeWebView()
            }
        }
    }
}