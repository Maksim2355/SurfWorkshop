package ru.pusdev.surfworkshop.screens.projects

import ru.pusdev.surfworkshop.data.Project

sealed class ProjectsViewState {

    object ErrorState : ProjectsViewState()
    object LoadingState : ProjectsViewState()
    data class DataState(val data: List<Project>) : ProjectsViewState()

    sealed class Action : ProjectsViewState() {
        data class OpenDetails(val project: Project) : Action()
        object EnterScreen : Action()
        object ReloadData : Action()
    }
}
