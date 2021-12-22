package com.example.newsmart.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmart.R
import com.example.newsmart.activity.MainActivity
import com.example.newsmart.adapter.PhoneAdapter
import com.example.newsmart.data.DataSource
import com.example.newsmart.databinding.FragmentPhonesBinding

class PhonesFragment : Fragment(R.layout.fragment_phones) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance (argName : String?, argDescr : String?, argIcon : Int?) : PhonesFragment {
            val args = bundleOf(
                KEY_NAME to argName,
                KEY_DESCRIPTION to argDescr,
                KEY_ICON_RES_ID to argIcon
            )
            val fragment = PhonesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPhonesBinding.bind(view)
        val name = arguments?.getString(PhoneFragment.KEY_NAME)
        val description = arguments?.getString(PhoneFragment.KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(PhoneFragment.KEY_ICON_RES_ID)
        val character = arguments?.getString(PhoneFragment.KEY_CHARACTERISTICS)

        binding.rvPhones.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPhones.adapter = PhoneAdapter(DataSource.phones) {
            (activity as MainActivity).navigateToFragment(
                PhoneFragment.newInstance(name, description, iconResId,character)
            )
        }
    }
}

