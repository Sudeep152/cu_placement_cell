package com.shashank.cu_placement_cell.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shashank.cu_placement_cell.repository.AuthRepository
import com.shashank.cu_placement_cell.repository.ProfileRepository
import com.shashank.cu_placement_cell.repository.ProfileRepositoryInterface

class ProfileViewModelFactory(val repository: ProfileRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         return ProfileViewModel(repository) as T
    }
}