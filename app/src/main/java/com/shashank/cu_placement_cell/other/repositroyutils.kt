package com.shashank.cu_placement_cell.other

import java.lang.Exception

inline fun <T> safeCall(action: () -> CustomResponse<T>): CustomResponse<T> {
    return try {
        action()
    } catch(e: Exception) {
        CustomResponse.Error("Something went wrong")
    }
}