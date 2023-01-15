package com.ozancanguz.universities_turkey.ui.fragments.list

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.universities_turkey.R
import com.ozancanguz.universities_turkey.adapters.UniListAdapter
import com.ozancanguz.universities_turkey.databinding.FragmentListBinding
import com.ozancanguz.universities_turkey.util.observeOnce
import com.ozancanguz.universities_turkey.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment(),SearchView.OnQueryTextListener {

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
        setHasOptionsMenu(true)


        // update ui
      //  observeLiveData()

        // listfromDb() instead of from api
        listfromDb()

        // set up rv
        setupRv()



        return view
    }

    private fun listfromDb() {
        lifecycleScope.launch {
            listViewModel.universityEntityList.observeOnce(viewLifecycleOwner, Observer { database ->
                if(database.isNotEmpty()){
                    Log.d("viewmodel","database called")
                    uniListAdapter.setData(database[0].university)

                }else{
                    Log.d("viewmodel","requested from api")
                    observeLiveData()
                }
            })
        }
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

    private fun loadDataFromCache() {
        lifecycleScope.launch {
            listViewModel.universityEntityList.observe(viewLifecycleOwner) { database ->
                if (database.isNotEmpty()) {
                    uniListAdapter.setData(database[0].university)
                }
            }
        }
    }


    // show menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.searchmenu,menu)
     //   super.onCreateOptionsMenu(menu, inflater)
        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

    }
    override fun onQueryTextSubmit(p0: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }



}