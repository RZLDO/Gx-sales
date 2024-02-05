package id.rizaldo.data

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    data class CustomError(val error: Throwable): ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
}