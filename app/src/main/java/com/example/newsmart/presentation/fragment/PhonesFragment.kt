package com.example.newsmart.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsmart.R
import com.example.newsmart.presentation.ScreenState
import com.example.newsmart.presentation.activity.MainActivity
import com.example.newsmart.presentation.adapter.PhoneAdapter
import com.example.newsmart.data.DataSource
import com.example.newsmart.databinding.FragmentPhonesBinding
import com.example.newsmart.domain.model.Smartphone
import com.example.newsmart.data.network.NetworkService
import com.example.newsmart.onClickFlow
import com.example.newsmart.onRefreshFlow
import com.example.newsmart.presentation.viewmodel.PhonesViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi

class PhonesFragment : Fragment(R.layout.fragment_phones) {
    private val phoneViewModel by lazy { PhonesViewModel(requireContext(), lifecycleScope) }
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

    private fun setLoading(isLoading: Boolean) = with(binding) {
        progressBar.isVisible = isLoading && !rvPhones.isVisible
        swRefreshRW.isRefreshing = isLoading && rvPhones.isVisible
    }
    private fun setData(headphones: List<Smartphone>?) = with(binding){
        rvPhones.isVisible = headphones != null
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
    private fun setError(message: String?) = with(binding){
        ErrLayout.isVisible = message != null
        textError.text = message
    }

    private lateinit var binding: FragmentPhonesBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        binding.progressBar.visibility = View.GONE
        println("CoroutineExceptionHandler got $exception")
    }

    private val scope = CoroutineScope(Dispatchers.Main + Job() + coroutineExceptionHandler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPhonesBinding.bind(view)
        merge(
            flowOf(Unit),
            binding.swRefreshRW.onRefreshFlow(),
            binding.buttonError.onClickFlow()
        )
            .flatMapLatest{loadPhones()}
            .distinctUntilChanged()
        phoneViewModel.screenState.onEach{
                when(it){
                    is ScreenState.DataLoaded -> {
                        setLoading(false)
                        setError(null)
                        setData(it.phones)
                    }
                    is ScreenState.Error -> {
                        setLoading(false)
                        setError(it.error)
                        setData(null)
                    }
                    ScreenState.Loading -> {
                        setLoading(true)
                        setError(null)
                    }
                }
            }
            .launchIn(lifecycleScope)

        if(savedInstanceState == null) {
            phoneViewModel.loadData()
        }
        binding.swRefreshRW.setOnRefreshListener {
            phoneViewModel.loadData()
        }
        binding.swRefreshRW.setOnRefreshListener {
            phoneViewModel.loadData()
        }
    }

    @ExperimentalSerializationApi
    private fun loadPhones() = flow {

        emit(ScreenState.Loading)
        val phones = NetworkService.loadSmartphones()
        emit(ScreenState.DataLoaded(phones))
    }
        .catch{
            emit(ScreenState.Error(getString(R.string.errorConnect)))
        }
}

