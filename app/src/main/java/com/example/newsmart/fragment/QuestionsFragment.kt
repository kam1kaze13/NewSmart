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
import com.example.newsmart.adapter.QuestionAdapter
import com.example.newsmart.data.DataSource
import com.example.newsmart.databinding.FragmentPhonesBinding
import com.example.newsmart.databinding.FragmentQuestionsBinding
import com.example.newsmart.network.NetworkService
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

class QuestionsFragment : Fragment(R.layout.fragment_questions) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DATE = "date"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance (argName : String?, argDate : String?, argDescr : String?, argIcon : Int?) : QuestionsFragment {
            val args = bundleOf(
                QuestionsFragment.KEY_NAME to argName,
                QuestionsFragment.KEY_DATE to argDate,
                QuestionsFragment.KEY_DESCRIPTION to argDescr,
                QuestionsFragment.KEY_ICON_RES_ID to argIcon
            )
            val fragment = QuestionsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: FragmentQuestionsBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        binding.progressBar.visibility = View.GONE
        println("CoroutineExceptionHandler got $exception")
    }

    private val scope = CoroutineScope(Dispatchers.Main + Job() + coroutineExceptionHandler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentQuestionsBinding.bind(view)
        val name = arguments?.getString(QuestionsFragment.KEY_NAME)
        val date = arguments?.getString(QuestionsFragment.KEY_DATE)
        val description = arguments?.getString(QuestionsFragment.KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(QuestionsFragment.KEY_ICON_RES_ID)

        binding.rvQuestions.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuestions.adapter = QuestionAdapter(DataSource.questions) {
            (activity as MainActivity).navigateToFragment(
                QuestionsFragment.newInstance(name, date, description, iconResId)
            )
        }
    }

    @ExperimentalSerializationApi
    private fun loadQuestions() {
        scope.launch {
            val questions = NetworkService.loadQuestions()
            binding.rvQuestions.layoutManager = LinearLayoutManager(context)
            binding.rvQuestions.adapter = QuestionAdapter(questions) {}
            binding.progressBar.visibility = View.GONE
            binding.swRefreshRW.isRefreshing = false
        }
    }
}