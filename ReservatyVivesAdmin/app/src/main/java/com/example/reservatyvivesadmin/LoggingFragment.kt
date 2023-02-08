package com.example.reservatyvivesadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.reservatyvivesadmin.databinding.FragmentLoggingBinding


class LoggingFragment : Fragment() {

    private  lateinit var binding: FragmentLoggingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoggingBinding.inflate(layoutInflater)

        binding.exit.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_loggingFragment_to_createReserbationFragment)
        }

        return binding.root
    }



}