package id.rizaldo.config

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val USER_TOKEN = "UserToken"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_TOKEN)
class UserTokenManager(private val context: Context) {
    companion object {
        val USER_TOKEN = stringPreferencesKey("userToken")
    }

    suspend fun storeUserToken(token: String) {
        Log.d("token", token)
        context.dataStore.edit {
            it[USER_TOKEN] = token
        }
    }
    fun readUserToken(): Flow<String> {
        return context.dataStore.data.map {preference ->
            preference[USER_TOKEN] ?: ""
        }
    }
    suspend fun deleteUserToken() {
        context.dataStore.edit {
            it.clear()
        }
    }
}