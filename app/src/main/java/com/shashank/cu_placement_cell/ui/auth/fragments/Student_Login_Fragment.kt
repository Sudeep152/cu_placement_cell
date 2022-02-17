package com.shashank.cu_placement_cell.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.shashank.cu_placement_cell.R
import com.shashank.cu_placement_cell.databinding.FragmentStudentLoginBinding


class Student_Login_Fragment : Fragment() {
    lateinit var binding: FragmentStudentLoginBinding
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

        binding.gotoReg.setOnClickListener {

            findNavController().navigate(R.id.action_student_Login_Fragment_to_student_Regitster_Fragment)
        }
    }



}