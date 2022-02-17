package com.shashank.cu_placement_cell.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.shashank.cu_placement_cell.R
import com.shashank.cu_placement_cell.databinding.FragmentStudentRegitsterBinding


class Student_Regitster_Fragment : Fragment() {
    lateinit var binding: FragmentStudentRegitsterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentStudentRegitsterBinding.inflate(layoutInflater)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


}