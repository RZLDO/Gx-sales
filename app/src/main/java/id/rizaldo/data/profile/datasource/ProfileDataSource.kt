package id.rizaldo.data.profile.datasource

import id.rizaldo.config.UserTokenManager
import id.rizaldo.data.ApiResponse
import id.rizaldo.data.profile.response.ProfileResponse
import id.rizaldo.utils.errorstate.GenericError
import id.rizaldo.utils.errorstate.HttpError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class ProfileDataSource @Inject constructor(
    private val service : ProfileApiService,
    private val dataStore : UserTokenManager
){
    fun fetchProfile() : Flow<ApiResponse<ProfileResponse>> = flow{
       val result =  try{
            val token = dataStore.readUserToken().first()
            val response = service.fetchProfile("Bearer $token")
            if(response.status == "success"){
                ApiResponse.Success(response)
            }else{
                 throw GenericError.FetchFailed()
            }
        }catch (e: HttpException){
            val response = e.response()
            val errorBody = response?.errorBody()?.string() ?: "Unknown error"
            try {
                val jsonObject = JSONObject(errorBody)
                val errorMessage = jsonObject.getString("message")
                ApiResponse.CustomError(HttpError.Known(e.code(), errorMessage))
            } catch (jsonException: JSONException) {
                ApiResponse.CustomError(HttpError.Known(e.code(), "Error parsing JSON"))
            }
        }catch (e : Exception){
            ApiResponse.CustomError(e);
        }
        emit(result)
    }
}