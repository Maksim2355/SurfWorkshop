package ru.pusdev.surfworkshop.data

import ru.pusdev.surfworkshop.data.model.Employees

data class Project(
    val id: String,
    val name: String,
    val descriptions: String,
    val team: Team,
)

data class Team(val employees: List<Employees>)