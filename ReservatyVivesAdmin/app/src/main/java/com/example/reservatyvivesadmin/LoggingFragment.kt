package com.example.reservatyvivesadmin

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.reservatyvivesadmin.databinding.FragmentLoggingBinding


class LoggingFragment : Fragment() , MenuProvider{

    private  lateinit var binding: FragmentLoggingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         var binding = FragmentLoggingBinding.inflate(layoutInflater)

                return binding.root
    }
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.salirItem){

        }
        if(menuItem.itemId == R.id.salas_itenMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_loggingFragment_to_recyclerSalasFragment) }
        }
        if(menuItem.itemId == R.id.gestionReserbasItemMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_loggingFragment_to_recyclerReserbasUsuariosFragment) }
        }
        if(menuItem.itemId == R.id.sesionIntemMenu){

        }
        if(menuItem.itemId == R.id.crearSalaItenMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_loggingFragment_to_createReserbationFragment)}
        }
        return true
    }


}