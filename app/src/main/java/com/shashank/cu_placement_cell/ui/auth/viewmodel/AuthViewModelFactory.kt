package com.shashank.cu_placement_cell.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shashank.cu_placement_cell.repository.AuthRepository

class AuthViewModelFactory(val repository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return Student_Auth_ViewModel(repository) as T
    }
}