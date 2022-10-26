package com.miodemi.squirrelsbox.profile.navigation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miodemi.squirrelsbox.R
import com.miodemi.squirrelsbox.databinding.FragmentHomeItemBinding
import com.miodemi.squirrelsbox.databinding.FragmentHomeSearchBinding

class HomeSearchFragment : Fragment() {

    //binding
    internal lateinit var binding: FragmentHomeSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //init data binding in a fragment
        binding = FragmentHomeSearchBinding.inflate(layoutInflater)
        //this value must be returned
        val view : View = binding.root

        // Inflate the layout for this fragment
        return  view
    }

}