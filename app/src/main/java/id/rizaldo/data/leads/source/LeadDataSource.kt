package id.rizaldo.data.leads.source

import id.rizaldo.config.UserTokenManager
import id.rizaldo.data.ApiResponse
import id.rizaldo.data.leads.response.LeadsResponse
import id.rizaldo.utils.errorstate.GenericError
import id.rizaldo.utils.errorstate.HttpError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LeadDataSource @Inject constructor(
    private val apiService: LeadApiService,
    private val token : UserTokenManager,
){
    fun fetchLeads() : Flow<ApiResponse<LeadsResponse>> = flow{
        val result = try{
            val userToken = token.readUserToken()
            val response = apiService.fetchLeads(token = "Bearer $userToken")
            if(response.status == "success"){
                ApiResponse.Success(response)
            }else{
                throw GenericError.FetchFailed()
            }
        }catch (http : HttpException){
            val response = http.response()
            val errorBody = response?.errorBody()?.string() ?: "Unknown error"
            try {
                val jsonObject = JSONObject(errorBody)
                val errorMessage = jsonObject.getString("message")
                ApiResponse.CustomError(HttpError.Known(http.code(), errorMessage))
            } catch (jsonException: JSONException) {
                ApiResponse.CustomError(HttpError.Known(http.code(), "Error parsing JSON"))
            }
        }catch (io : IOException){
            ApiResponse.CustomError(io)
        }
        emit(result)
    }
}