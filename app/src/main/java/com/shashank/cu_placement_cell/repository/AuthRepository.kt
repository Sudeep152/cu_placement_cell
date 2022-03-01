package com.shashank.cu_placement_cell.repository

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.shashank.cu_placement_cell.other.CustomResponse
import com.shashank.cu_placement_cell.other.CustomResponse.Success
import com.shashank.cu_placement_cell.other.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository :AuthRepositoryInterface {
    val mAuth =FirebaseAuth.getInstance()



    override suspend fun register(
        email: String,
        password: String,
        studentUid: String,
    ): CustomResponse<AuthResult> {


        return withContext(Dispatchers.IO){
            safeCall {
                val result =mAuth.createUserWithEmailAndPassword(email, password).await()
                Success(result)
            }

        }


    }
}