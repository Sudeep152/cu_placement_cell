package com.shashank.cu_placement_cell.ui.auth

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shashank.cu_placement_cell.R
import com.shashank.cu_placement_cell.databinding.FragmentStudentRegitsterBinding
import com.shashank.cu_placement_cell.other.EventObserver
import com.shashank.cu_placement_cell.repository.AuthRepository
import com.shashank.cu_placement_cell.repository.ProfileRepository
import com.shashank.cu_placement_cell.ui.auth.viewmodel.AuthViewModelFactory
import com.shashank.cu_placement_cell.ui.auth.viewmodel.ProfileViewModel
import com.shashank.cu_placement_cell.ui.auth.viewmodel.ProfileViewModelFactory
import com.shashank.cu_placement_cell.ui.auth.viewmodel.Student_Auth_ViewModel
import kotlinx.android.synthetic.main.fragment_student__regitster_.*


class Student_Regitster_Fragment : Fragment(R.layout.fragment_student__regitster_) {

    lateinit var authViewModel: Student_Auth_ViewModel
    lateinit var repository: AuthRepository
    lateinit var prorepository: ProfileRepository
    lateinit var profileViewModel: ProfileViewModel
    private lateinit var process: ProgressDialog



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        process= ProgressDialog(context,R.style.Base_ThemeOverlay_MaterialComponents_MaterialAlertDialog)
        process.setMessage("Loading...")
        process.setCancelable(false)
        repository = AuthRepository()
        prorepository= ProfileRepository()
        authViewModel = ViewModelProvider(this,
            AuthViewModelFactory(repository)).get(Student_Auth_ViewModel::class.java)
        profileViewModel= ViewModelProvider(this,ProfileViewModelFactory(prorepository)).get(ProfileViewModel::class.java)

        subscribeToObservers()
        regEdt.setOnClickListener {

            subscribeToObservers()
            val name = nameEdt.text.toString()
            val email = emailEdt.text.toString()
            val mobile = mobEdt.text.toString()
            val studentId = idEdt.text.toString()
            val password = passEdt.text.toString()
            val re_password =  re_passEdt.text.toString()
            val course = courseEdt.text.toString()
           authViewModel.register(email,password,name,mobile,studentId,re_password,course)
     }
    }

    fun subscribeToObservers(){

        authViewModel.registerStatus.observe(viewLifecycleOwner,EventObserver(
            onError = {

                process.dismiss()
                Toast.makeText(activity, "${it}", Toast.LENGTH_SHORT).show()
            }
            ,onLoading = {

   process.show()
            }
        ){
            Toast.makeText(activity, "${it}", Toast.LENGTH_SHORT).show()
            val name = nameEdt.text.toString()
            val email = emailEdt.text.toString()
            val mobile = mobEdt.text.toString()
            val studentId = idEdt.text.toString()
            val course = courseEdt.text.toString()
            profileViewModel.profileSetUp(name,email,mobile,studentId,course)
      process.dismiss()
        })
    }

}




