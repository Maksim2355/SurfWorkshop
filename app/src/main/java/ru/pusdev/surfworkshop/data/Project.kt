package ru.pusdev.surfworkshop.data

data class Project(
    val id: String,
    val name: String,
    val descriptions: String,
    val team: Team,
)

data class Team(val employees: List<Employees>)