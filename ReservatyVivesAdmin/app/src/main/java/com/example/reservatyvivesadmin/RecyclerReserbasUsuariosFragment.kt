package com.example.reservatyvivesadmin

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.reservatyvivesadmin.databinding.FragmentRecyclerReserbasUsuariosBinding
import com.example.reservatyvivesadmin.databinding.FragmentRecyclerSalasBinding


class RecyclerReserbasUsuariosFragment : Fragment() {

  lateinit var binding: FragmentRecyclerReserbasUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRecyclerReserbasUsuariosBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var binding = FragmentRecyclerReserbasUsuariosBinding.inflate(inflater, container, false)

        binding.buttonVolverREserbasRecicler.setOnClickListener {
            view?.let {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_recyclerReserbasUsuariosFragment_to_loggingFragment)
            }
        }

        return binding.root
    }


}