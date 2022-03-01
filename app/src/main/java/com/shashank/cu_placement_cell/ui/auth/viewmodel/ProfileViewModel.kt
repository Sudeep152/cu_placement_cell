package com.shashank.cu_placement_cell.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.cu_placement_cell.repository.ProfileRepositoryInterface
import kotlinx.coroutines.launch

class ProfileViewModel(val repository: ProfileRepositoryInterface):ViewModel() {


 fun profileSetUp(name:String,email:String,mobileNumber:String,studentId:String,course:String){

        viewModelScope.launch {
            repository.userInformation(name,email,mobileNumber,studentId,course)
        }

    }


}