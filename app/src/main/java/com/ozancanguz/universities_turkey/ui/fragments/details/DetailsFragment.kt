package com.ozancanguz.universities_turkey.ui.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.universities_turkey.R
import com.ozancanguz.universities_turkey.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:DetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        updateUi()

        return view
    }

    private fun updateUi() {
        binding.detailsImage.setImageResource(R.drawable.img)
        binding.detailsCountryTv.text="Country: "+args.currentUni.country
        binding.detailsWebPage.text=args.currentUni.webPages.toString()
        binding.detailsName.text="Name: "+args.currentUni.name.toString()

    }


}