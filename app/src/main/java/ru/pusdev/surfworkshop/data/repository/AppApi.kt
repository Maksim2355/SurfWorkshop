package ru.pusdev.surfworkshop.data.repository

import retrofit2.Response
import retrofit2.http.GET
import ru.pusdev.surfworkshop.data.Project

interface AppApi {

    @GET("/projects-with-employees")
    suspend fun getProjectWithEmployees(): Response<List<Project>>

}