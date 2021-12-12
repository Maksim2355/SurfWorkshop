package ru.pusdev.surfworkshop.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.pusdev.surfworkshop.data.Project
import ru.pusdev.surfworkshop.data.model.Employees
import ru.pusdev.surfworkshop.foundation.Result
import ru.pusdev.surfworkshop.foundation.map
import ru.pusdev.surfworkshop.foundation.getResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val api: AppApi
) {

    suspend fun getProjects(): Flow<Result<List<Project>>> = flow<Result<List<Project>>> {
        emit(Result.loading())
        val result = getResponse {
            api.getProjectWithEmployees()
        }
        emit(result)
    }.flowOn(Dispatchers.IO)

    suspend fun getEmployees(): Flow<Result<List<Employees>>> = getProjects().map { result ->
        result.map { resultItem -> resultItem.flatMap { it.team.employees } }
    }
}