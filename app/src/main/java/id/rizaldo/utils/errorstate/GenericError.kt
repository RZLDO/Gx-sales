package id.rizaldo.utils.errorstate

sealed class GenericError: Exception() {
    class FetchFailed(val error: Throwable? = null): GenericError()
    class RequestFailed(val error: Throwable? = null): GenericError()
}