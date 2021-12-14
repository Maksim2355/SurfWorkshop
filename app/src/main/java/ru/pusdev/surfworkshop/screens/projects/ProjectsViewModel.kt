package ru.pusdev.surfworkshop.screens.projects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.pusdev.surfworkshop.data.repository.AppRepository
import ru.pusdev.surfworkshop.foundation.EventHandler
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel(), EventHandler<ProjectsViewState> {

    private val _projectsFlow: MutableStateFlow<ProjectsViewState> =
        MutableStateFlow(ProjectsViewState.LoadingState)

    val projects: StateFlow<ProjectsViewState>
        get() = _projectsFlow

    override fun obtainEvent(event: ProjectsViewState) {
        when (event) {
            is ProjectsViewState.Action.EnterScreen, is ProjectsViewState.Action.ReloadData -> {
                viewModelScope.launch {
                    appRepository.getProjects().collect {
                        when {
                            it.status.isError() -> _projectsFlow.tryEmit(ProjectsViewState.ErrorState)
                            it.status.isLoading() -> _projectsFlow.tryEmit(ProjectsViewState.LoadingState)
                            it.status.isSuccess() -> it.data?.let { it1 ->
                                ProjectsViewState.DataState(
                                    it1
                                )
                            }?.let { it2 -> _projectsFlow.tryEmit(it2) }
                        }
                    }

                }
            }
            is ProjectsViewState.Action.OpenDetails -> {
                //
            }
        }
    }
}