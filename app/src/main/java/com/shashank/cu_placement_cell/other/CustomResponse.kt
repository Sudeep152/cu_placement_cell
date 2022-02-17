package com.shashank.cu_placement_cell.other

sealed class CustomResponse<T>(val data:T? =null,val message:String?=null) {

    class Success<T>(data: T):CustomResponse<T>(data)
    class Response<T>(data: T?,message: String?):CustomResponse<T>(data,message)
    class Error<T>(data: T?):CustomResponse<T>(data)




}