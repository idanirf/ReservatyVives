package com.example.reservatyvivesadmin

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.reservatyvivesadmin.databinding.FragmentCreateReserbationBinding


class CreateReserbationFragment : Fragment(), MenuProvider {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentCreateReserbationBinding.inflate(inflater, container, false)

        binding.buttonCancelarSala.setOnClickListener {
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_createReserbationFragment_to_recyclerSalasFragment)}
            }
        binding.buttonGuargarSala .setOnClickListener {
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_createReserbationFragment_to_recyclerSalasFragment)}
            }
        return binding.root

    }
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.salirItem){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_createReserbationFragment_to_loggingFragment) }
        }
        if(menuItem.itemId == R.id.salas_itenMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_createReserbationFragment_to_recyclerSalasFragment) }
        }
        if(menuItem.itemId == R.id.gestionReserbasItemMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_createReserbationFragment_to_recyclerReserbasUsuariosFragment) }
        }
        if(menuItem.itemId == R.id.sesionIntemMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_createReserbationFragment_to_loggingFragment) }
        }
        if(menuItem.itemId == R.id.crearSalaItenMenu){
        }
        return true
    }



}