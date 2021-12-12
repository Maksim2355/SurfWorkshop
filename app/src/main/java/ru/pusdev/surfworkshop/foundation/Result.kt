package ru.pusdev.surfworkshop.foundation

/**
 * Generic class for holding success response, error response and loading status
 */
data class Result<out T>(
    val status: Status,
    val data: T?,
    val error: Error?,
    val message: String?
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING;

        fun isSuccess() = this == SUCCESS

        fun isError() = this == ERROR

        fun isLoading() = this == LOADING
    }

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, error: Error?): Result<T> {
            return Result(Status.ERROR, null, error, message)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}

fun <T, R> Result<T>.map(mapper: (T) -> R): Result<R> {
    return Result(
        status = status,
        data = data?.let { mapper(it) },
        error = error,
        message = message
    )
}