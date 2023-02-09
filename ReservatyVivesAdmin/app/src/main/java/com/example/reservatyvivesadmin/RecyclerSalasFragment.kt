package com.example.reservatyvivesadmin

import android.os.Bundle
import android.view.*
import android.view.View.inflate
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.reservatyvivesadmin.databinding.ActivityMainBinding
import com.example.reservatyvivesadmin.databinding.ActivityMainBinding.inflate
import com.example.reservatyvivesadmin.databinding.FragmentCreateReserbationBinding
import com.example.reservatyvivesadmin.databinding.FragmentRecyclerSalasBinding

class RecyclerSalasFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerSalasBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentRecyclerSalasBinding.inflate(inflater, container, false)

        binding.buttonVolverSalasRecicler.setOnClickListener {
            view?.let {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_recyclerSalasFragment_to_loggingFragment)
            }
        }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRecyclerSalasBinding.inflate(layoutInflater)
    }


}