package ru.pusdev.surfworkshop.screens.projects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.pusdev.surfworkshop.components.custom.avatars.AvatarRow
import ru.pusdev.surfworkshop.components.placeholder.ErrorScreenState
import ru.pusdev.surfworkshop.components.placeholder.LoadingScreenState
import ru.pusdev.surfworkshop.data.Project
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@Composable
fun ProjectsTab(projectsViewModel: ProjectsViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = Unit) {

    }

    val viewState = projectsViewModel.projectsLiveData.observeAsState()

    when (viewState.value) {
        is ProjectsViewState.ErrorState -> ErrorScreenState {
            projectsViewModel.obtainEvent(ProjectsViewState.Action.ReloadData)
        }
        is ProjectsViewState.LoadingState -> LoadingScreenState()
        is ProjectsViewState.DataState -> ProjectsList(
            projects = (viewState.value as ProjectsViewState.DataState).data,
            onProjectClick = { projectsViewModel.obtainEvent(ProjectsViewState.Action.OpenDetails(it)) }
        )
    }
}

@Composable
fun ProjectsList(projects: List<Project>, onProjectClick: (Project) -> Unit) {
    LazyColumn {
        items(projects.size) {

        }
    }
}

@Composable
fun ProjectCard(project: Project, onProjectClick: (Project) -> Unit) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 20.dp,
                vertical = 16.dp
            )
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = WorkshopTheme.defaultColors.surface,
        shape = WorkshopTheme.defaultShapes.large
    ) {
        Column {
            Row() {
                AvatarRow(urls = project.team.employees.map { it.photoUrl })
            }
            Text(
                text = project.team.employees.count().toString() + "Участника",
                style = WorkshopTheme.typography.subtitle1
            )
            Text(text = project.name, style = WorkshopTheme.typography.h2)
        }
    }
}