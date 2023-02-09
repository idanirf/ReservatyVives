package com.example.reservatyvivesadmin

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class RecyclerSalasFragment : Fragment(), MenuProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_salas, container, false)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.salirItem){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_recyclerSalasFragment_to_loggingFragment)}
        }
        if(menuItem.itemId == R.id.salas_itenMenu){

        }
        if(menuItem.itemId == R.id.gestionReserbasItemMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_recyclerSalasFragment_to_recyclerReserbasUsuariosFragment) }
        }
        if(menuItem.itemId == R.id.sesionIntemMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_recyclerSalasFragment_to_loggingFragment)}
        }
        if(menuItem.itemId == R.id.crearSalaItenMenu){
            view?.let { Navigation.findNavController(it.rootView).navigate(R.id.action_recyclerSalasFragment_to_createReserbationFragment)}
        }

        return true
    }
}