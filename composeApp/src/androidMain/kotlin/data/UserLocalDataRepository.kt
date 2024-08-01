package data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import core.model.response.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.noctisdev.fifth.dataStore

class UserLocalDataRepository(private val context: Context) {
    private val dataStore = context.dataStore
    private val gson = Gson()

    companion object {
        val USER_KEY = stringPreferencesKey("user")
    }

    suspend fun saveUser(user: UserResponse) {
        val userJson = gson.toJson(user)

        dataStore.edit {preference ->
            preference[USER_KEY] = userJson
        }
    }

    val user: Flow<UserResponse?> = dataStore.data.map(::getPreference)

    private fun getPreference(preferences: Preferences): UserResponse? {
        return preferences[USER_KEY]?.let {
            gson.fromJson(it, UserResponse::class.java)
        }
    }
}