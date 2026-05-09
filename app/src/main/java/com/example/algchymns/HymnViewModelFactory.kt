package com.example.algchymns

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.algchymns.data.repo.AlgcRepo

class HymnViewModelFactory(
    private val repo: AlgcRepo,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HymnViewModel(
            repo
        ) as T
    }
}