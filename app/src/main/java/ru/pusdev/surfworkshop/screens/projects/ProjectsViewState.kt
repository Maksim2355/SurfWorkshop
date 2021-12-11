package ru.pusdev.surfworkshop.screens.projects

import ru.pusdev.surfworkshop.data.Project

sealed class ProjectsViewState {
    object EnterScreen: ProjectsViewState()
    data class OpenDetails(val project: Project): ProjectsViewState()
}
