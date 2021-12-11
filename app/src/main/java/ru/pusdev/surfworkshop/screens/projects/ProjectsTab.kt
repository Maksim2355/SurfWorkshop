package ru.pusdev.surfworkshop.screens.projects

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProjectsTab(projectsViewModel: ProjectsViewModel = hiltViewModel()) {
    LazyColumn() {
    }
}