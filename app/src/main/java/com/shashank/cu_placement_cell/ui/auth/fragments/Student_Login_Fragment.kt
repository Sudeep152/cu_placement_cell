package com.shashank.cu_placement_cell.ui.auth

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shashank.cu_placement_cell.R
import com.shashank.cu_placement_cell.databinding.FragmentStudentLoginBinding
import com.shashank.cu_placement_cell.other.EventObserver
import com.shashank.cu_placement_cell.repository.AuthRepository
import com.shashank.cu_placement_cell.ui.auth.viewmodel.AuthViewModelFactory
import com.shashank.cu_placement_cell.ui.auth.viewmodel.Student_Auth_ViewModel
import com.shashank.cu_placement_cell.ui.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_student__login_.*


class Student_Login_Fragment : Fragment() {
    lateinit var binding: FragmentStudentLoginBinding
    lateinit var authViewModel:Student_Auth_ViewModel
    lateinit var repository: AuthRepository
    private lateinit var process: ProgressDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentStudentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        process= ProgressDialog(context,R.style.Base_ThemeOverlay_MaterialComponents_MaterialAlertDialog)
        process.setMessage("Loading...")
        process.setCancelable(false)
            repository= AuthRepository()
        authViewModel = ViewModelProvider(this,AuthViewModelFactory(repository)).get(Student_Auth_ViewModel::class.java)

        regEdt.setOnClickListener {

            val email = emailEdt.text.toString()
            val pass = passEdt.text.toString()
            observer()
            authViewModel.login(email,pass)


        }

        binding.gotoReg.setOnClickListener {

            findNavController().navigate(R.id.action_student_Login_Fragment_to_student_Regitster_Fragment)
        }
    }

    fun observer(){

        authViewModel.loginStatus.observe(viewLifecycleOwner,EventObserver(
            onError = {
                process.dismiss()
                Toast.makeText(activity, "${it.toString()}", Toast.LENGTH_SHORT).show()
            }, onLoading = {
             process.show()
            }
        ){
            Toast.makeText(activity, "login successfully", Toast.LENGTH_SHORT).show()
            process.dismiss()
            Intent(requireContext(), HomeActivity::class.java).also {
                startActivity(it)
                requireActivity().finish()
            }
        })
    }


}