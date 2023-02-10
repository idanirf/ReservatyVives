package com.example.reservatyvivesadmin

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.View.inflate
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reservatyvivesadmin.databinding.ActivityMainBinding
import com.example.reservatyvivesadmin.databinding.ActivityMainBinding.inflate
import com.example.reservatyvivesadmin.databinding.FragmentCreateReserbationBinding
import com.example.reservatyvivesadmin.databinding.FragmentRecyclerSalasBinding
import com.example.reservatyvivesadmin.databinding.ItemSalaBinding
import com.example.reservatyvivesadmin.recycler.ClickListenerInterface
import com.example.reservatyvivesadmin.recycler.SalasAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class RecyclerSalasFragment : Fragment(), ClickListenerInterface {
    override fun click(s: Sala): Boolean {
        TODO("Not yet implemented")
    }



    private lateinit var binding: FragmentRecyclerSalasBinding
    private lateinit var mAdapter: SalasAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var mListenerRegistration: ListenerRegistration
    private  var mlista = ArrayList<Sala>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentRecyclerSalasBinding.inflate(inflater, container, false)

        binding.buttonVolverREserbasRecicler.setOnClickListener {
            Toast.makeText(context, "pulsaste boton volver", Toast.LENGTH_SHORT).show()
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

        //  mAdapter = SalasAdapter(ArrayList<Sala>(), this)
        //asi se hace para cojer los datos reactuvamente
        //getRpoductsInRealTime()

        getProducts()

        println(  " mi lista tiene ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
        println( mlista.size )

        //cargamos datos en el recicler
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding?.let{
            mAdapter = SalasAdapter(mlista, this)
            mLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerSalas.apply {
                setHasFixedSize(true)
                layoutManager = mLayoutManager
                adapter = mAdapter
            }
        }

    }

    private fun getProducts() {

        println("entra en get products¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
        val db = FirebaseFirestore.getInstance()
        //leia con p minuscula
        db.collection("Salass")
            //.whereEqualTo("category", "productos")
            .get()
            .addOnSuccessListener { documents ->

                println("entra en obtener datos11111111111111111111111111111111")
                for (document in documents) {
                    var p = document.toObject(Sala::class.java) //convertir el document en objeto
                    println("obtenemos producto " + p.toString())
                    p.id = document.id.toString()
                    println(p.toString())
                    println("imprimimos sala obtenida en la lista 1111111111111111111111111111111")
                    mlista.add(p)
                }
                println( mAdapter.itemCount)
            }
            .addOnFailureListener {
                Toast.makeText(this.context, "Error al consultar los datos", Toast.LENGTH_SHORT).show()
            }
    }



}