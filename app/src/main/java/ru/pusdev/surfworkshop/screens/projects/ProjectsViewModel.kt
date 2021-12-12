package ru.pusdev.surfworkshop.screens.projects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.pusdev.surfworkshop.data.Project
import ru.pusdev.surfworkshop.foundation.EventHandler
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor() : ViewModel(), EventHandler<ProjectsViewState> {

    private val _projectsLiveData: MutableLiveData<ProjectsViewState> = MutableLiveData()
    val projectsLiveData: LiveData<ProjectsViewState>
        get() = _projectsLiveData

    override fun obtainEvent(event: ProjectsViewState) {
        when (event) {
            is ProjectsViewState.Action.EnterScreen -> {
                //
            }
            is ProjectsViewState.Action.OpenDetails -> {
                //
            }
        }
    }
}