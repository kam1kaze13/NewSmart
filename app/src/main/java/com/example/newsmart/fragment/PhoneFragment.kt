package com.example.newsmart.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsmart.R
import com.example.newsmart.activity.MainActivity
import com.example.newsmart.adapter.PhoneAdapter
import com.example.newsmart.data.DataSource
import com.example.newsmart.databinding.FragmentPhonesBinding
import com.example.newsmart.model.Specification

class PhoneFragment : Fragment(R.layout.fragment_phone) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"
        const val KEY_CHARACTERISTICS = "characteristics"

        fun newInstance (argName : String?, argDescr : String?, argIcon : Int?, argCharacter : String?) : PhoneFragment {
            val args = bundleOf(
                KEY_NAME to argName,
                KEY_DESCRIPTION to argDescr,
                KEY_ICON_RES_ID to argIcon,
                KEY_CHARACTERISTICS to argCharacter
            )
            val fragment = PhoneFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPhonesBinding.bind(view)
        val name = arguments?.getString(KEY_NAME)
        val description = arguments?.getString(KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(KEY_ICON_RES_ID)

        binding.rvPhones.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPhones.adapter = PhoneAdapter(DataSource.phones) {
            (activity as MainActivity).navigateToFragment(
                PhonesFragment.newInstance(name, description, iconResId)
            )
        }
    }
}