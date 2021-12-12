package ru.pusdev.surfworkshop.foundation

import retrofit2.Response

suspend fun <T> getResponse(
    defaultErrorMessage: String = "",
    request: suspend () -> Response<T>
): Result<T> {
    return try {
        val result = request.invoke()
        if (result.isSuccessful) {
            return Result.success(result.body())
        } else {
            //FIXME заменить на нормальный парсинг ошибки
            val errorResponse = null
            Result.error(errorResponse ?: defaultErrorMessage, errorResponse)
        }
    } catch (e: Throwable) {
        Result.error("Unknown Error", null)
    }
}