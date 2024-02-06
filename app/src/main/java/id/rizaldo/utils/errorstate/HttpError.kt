package id.rizaldo.utils.errorstate

sealed class HttpError : Exception() {

    data class Known(val code: Int, val customMessage: String) : HttpError()
    object Unknown : HttpError()
}
