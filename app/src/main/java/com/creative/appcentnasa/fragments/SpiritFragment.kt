package com.creative.appcentnasa.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.creative.appcentnasa.R
import com.creative.appcentnasa.databinding.FragmentSpiritBinding


class SpiritFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
private lateinit var binding: FragmentSpiritBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_spirit, container, false)
        binding = FragmentSpiritBinding.inflate(layoutInflater)
        return binding.root
    }


}