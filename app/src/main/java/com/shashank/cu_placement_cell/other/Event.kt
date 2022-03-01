package com.shashank.cu_placement_cell.other

import androidx.lifecycle.Observer
import java.util.*

class Event<out   T>(private val content: T) {


    var hasBeenHandle = false
    private set

    fun  getContentIfNotHandled():T?{
        return if(!hasBeenHandle){
            hasBeenHandle=true
            content
        }else null
    }

    fun peekContent()=content
}

class EventObserver<T>(
    private inline val onError:((String)-> Unit)?=null,
    private inline val onLoading:(()-> Unit)?=null,
    private inline val onSuccess:(T)-> Unit

): Observer<Event<CustomResponse<T>>> {
    override fun onChanged(t: Event<CustomResponse<T>>?) {

        when(val content =t?.peekContent() ){

            is CustomResponse.Success ->{
              content.data?.let(onSuccess)

            }

            is CustomResponse.Error ->{
               t.getContentIfNotHandled()?.let {
                   onError?.let { error ->
                       error(it.message.toString()!!)
                   }
               }
            }
            is CustomResponse.Loading ->{

                onLoading?.let { loading->

                    loading()
                }
            }
        }
    }


}