package id.rizaldo.data.auth.datasource

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.auth.response.LoginResponse
import id.rizaldo.domain.model.auth.PostSignIn
import id.rizaldo.utils.errorstate.GenericError
import id.rizaldo.utils.errorstate.HttpError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthDataSource @Inject constructor(
    private val service: AuthService
) {
    fun signIn(data : PostSignIn) : Flow<ApiResponse<LoginResponse>> = flow {
        val result = try{
            val response = service.signIn(data)
            if(response.status == "success"){
                ApiResponse.Success(response)
            }else{
                throw GenericError.FetchFailed()
            }
        }catch (e: HttpException) {
            val response = e.response()
            val errorBody = response?.errorBody()?.string() ?: "Unknown error"
            try {
                val jsonObject = JSONObject(errorBody)
                val errorMessage = jsonObject.getString("message")
                ApiResponse.CustomError(HttpError.Known(e.code(), errorMessage))
            } catch (jsonException: JSONException) {
                ApiResponse.CustomError(HttpError.Known(e.code(), "Error parsing JSON"))
            }
        }
        catch (e: IOException) {
            ApiResponse.CustomError(e);
        }
        emit(result)
    }.flowOn(Dispatchers.IO)
}