package ru.pusdev.surfworkshop.screens.projects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.pusdev.surfworkshop.data.Project
import ru.pusdev.surfworkshop.data.repository.AppRepository
import ru.pusdev.surfworkshop.foundation.EventHandler
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel(), EventHandler<ProjectsViewState> {

    private val _projectsLiveData: MutableStateFlow<ProjectsViewState> =
        MutableStateFlow(ProjectsViewState.LoadingState)
    val projectsLiveData: StateFlow<ProjectsViewState>
        get() = _projectsLiveData

    override fun obtainEvent(event: ProjectsViewState) {
        when (event) {
            is ProjectsViewState.Action.EnterScreen, is ProjectsViewState.Action.ReloadData -> {
                viewModelScope.launch {
                    val result = appRepository.getProjects()
                }
            }
            is ProjectsViewState.Action.OpenDetails -> {
                //
            }
        }
    }
}