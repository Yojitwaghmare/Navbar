package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        val view=binding.root
        //here profile pic
        //name
        //history of previous purchases (Recyclerview + adapter)
        //QR button

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}