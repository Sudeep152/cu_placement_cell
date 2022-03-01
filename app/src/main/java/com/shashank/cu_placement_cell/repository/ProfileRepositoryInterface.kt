package com.shashank.cu_placement_cell.repository

import com.shashank.cu_placement_cell.other.CustomResponse

interface ProfileRepositoryInterface {

    suspend fun userInformation( name:String,email:String,mobile:String,studentId:String,course:String):CustomResponse<Any>
}