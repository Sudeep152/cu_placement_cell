package com.shashank.cu_placement_cell.repository

import com.google.firebase.auth.AuthResult
import com.shashank.cu_placement_cell.other.CustomResponse

interface AuthRepositoryInterface {

    suspend fun register(email:String,password:String,studentUid:String):CustomResponse<AuthResult>


}