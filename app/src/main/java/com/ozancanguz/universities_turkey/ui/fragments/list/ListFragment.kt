package com.ozancanguz.universities_turkey.ui.fragments.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.universities_turkey.R
import com.ozancanguz.universities_turkey.adapters.UniListAdapter
import com.ozancanguz.universities_turkey.databinding.FragmentListBinding
import com.ozancanguz.universities_turkey.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    private val listViewModel:ListViewModel by viewModels()

    private val uniListAdapter=UniListAdapter()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root


        // update ui
        observeLiveData()

        // set up rv
        setupRv()



        return view
    }


    private fun observeLiveData() {
        binding.progressbarList.visibility=View.VISIBLE
        listViewModel.requestApiData()
        listViewModel.universityList.observe(viewLifecycleOwner, Observer {
            uniListAdapter.setData(it)
            binding.progressbarList.visibility=View.INVISIBLE

        })

    }

    private fun setupRv() {
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=uniListAdapter
    }



}