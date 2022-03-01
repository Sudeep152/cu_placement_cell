package com.shashank.cu_placement_cell.ui.auth.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult


import com.shashank.cu_placement_cell.other.BaseClass.Companion.MIN_VAL
import com.shashank.cu_placement_cell.other.CustomResponse
import com.shashank.cu_placement_cell.other.Event
import com.shashank.cu_placement_cell.repository.AuthRepository
import com.shashank.cu_placement_cell.repository.AuthRepositoryInterface
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Student_Auth_ViewModel(private  val repository: AuthRepositoryInterface
,  private val dispatcher: CoroutineDispatcher= Dispatchers.Main):ViewModel() {


    private val _registerStatus = MutableLiveData<Event<CustomResponse<AuthResult>>>()
    val  registerStatus : LiveData<Event<CustomResponse<AuthResult>>> = _registerStatus



    fun register(email:String,password:String,userFullName:String,mobileNumber:String,studentUID:String,reEnterPassword:String,course:String){

        val error = if(email.isEmpty() ||password.isEmpty()||userFullName.isEmpty()||studentUID.isEmpty()
            || mobileNumber.isEmpty()||reEnterPassword.isEmpty()||course.isEmpty()){
            "Enter all fields"
        }else if(password!=reEnterPassword){
            "Please enter same password"
        }else if(password.length< MIN_VAL){
            "Please enter 6digit password"
        }else null
        error?.let {
            _registerStatus.postValue(Event(CustomResponse.Error(it)))
            return
        }
        _registerStatus.postValue(Event((CustomResponse.Loading())))

        viewModelScope.launch(dispatcher) {
            val result = repository.register(email,password, studentUID)
            _registerStatus.postValue(Event(result))

        }





    }


    }

