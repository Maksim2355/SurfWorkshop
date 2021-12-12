package ru.pusdev.surfworkshop.data.model

data class Employees(
    val id: String,
    val userInfo: UserInfo,
    val position: String,
    val skills: List<String>,
    val createdDate: Int,
    val department: String,
    val photoUrl: String,
    val currentProject: String,
    val experience: String
)

data class UserInfo(
    val name: String,
    val age: Int,
    val city: String,
    val phone: String
)