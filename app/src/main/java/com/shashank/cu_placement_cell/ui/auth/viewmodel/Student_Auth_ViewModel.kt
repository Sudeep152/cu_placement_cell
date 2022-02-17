package com.shashank.cu_placement_cell.ui.auth.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult


import com.shashank.cu_placement_cell.other.BaseClass.Companion.MIN_VAL
import com.shashank.cu_placement_cell.other.CustomResponse
import com.shashank.cu_placement_cell.other.Event
import com.shashank.cu_placement_cell.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class Student_Auth_ViewModel(private  val repository: AuthRepository,private val context: Context

, private  val dispatcher: CoroutineDispatcher
):ViewModel() {


    private val _registration_status= MutableLiveData<Event<CustomResponse<AuthResult>>>()
    private val registration_status: MutableLiveData<Event<CustomResponse<AuthResult>>> =_registration_status


    fun register(email:String,password:String,userFullName:String,mobileNumber:String,studentUID:String,reEnterPassword:String,

                 course:String){

        val error = if(email.isEmpty() ||password.isEmpty()||userFullName.isEmpty()||studentUID.isEmpty()
            || mobileNumber.isEmpty()||reEnterPassword.isEmpty()||course.isEmpty()){
            error("Enter all fields")
        }else if(password!=reEnterPassword){
            error("Please enter same password")
        }else if(password.length< MIN_VAL){
            error("Please enter 6digit password")
        }else null


     error.let{

         _registration_status.postValue(Event(CustomResponse.Error(it.toString())))
         return
     }
        _registration_status.postValue(Event(CustomResponse.Loading()))

        viewModelScope.launch {

            val result = repository.register(email,password,studentUID)

            _registration_status.postValue(Event(result))



        }



    }





}