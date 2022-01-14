package com.example.newsmart.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsmart.R
import com.example.newsmart.presentation.activity.MainActivity
import com.example.newsmart.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {
    companion object{
        fun newInstance() = RegisterFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRegisterBinding.bind(view)
        (activity as MainActivity).navigateToFragment(
            AuthFragment.newInstance()
        )
    }
}