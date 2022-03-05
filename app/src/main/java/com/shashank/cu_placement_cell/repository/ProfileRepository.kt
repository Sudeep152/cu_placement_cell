package com.shashank.cu_placement_cell.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.shashank.cu_placement_cell.Entites.User
import com.shashank.cu_placement_cell.other.CustomResponse

class ProfileRepository:ProfileRepositoryInterface {
    val fireStore=FirebaseFirestore.getInstance()
    val mAuth =FirebaseAuth.getInstance()
    val profileData= fireStore.collection("Students")
    override suspend fun userInformation(
        name: String,
        email: String,
        mobile: String,
        studentId: String,
        course: String,
    ): CustomResponse<Any> {

        val student =User(userId =mAuth.currentUser?.uid.toString(),name,email,mobile,studentId,course )

        profileData.document(mAuth.currentUser?.uid.toString()).set(student)

         return  CustomResponse.Success(Any())

    }

}