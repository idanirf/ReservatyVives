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

        getAllSalas()

        println(  " mi lista tiene  daniiiiiiiiiiii ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
        println( mlista.size )
        setupRecylerView()
        println( "EAAAA" )

<<<<<<< Updated upstream
        //cargamos datos en el recicler
       // setupRecyclerView()
=======
>>>>>>> Stashed changes

    }

    private fun setupRecylerView() {
        mAdapter = SalasAdapter(mutableListOf(), this)
        binding.recyclerSalas.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = mAdapter

        }

    }


    private fun getAllSalas() {
        val db = FirebaseFirestore.getInstance()

        db.collection("Salass")
            .get()
            .addOnSuccessListener { snapshots ->
                for (document in snapshots){
                    val sala = document.toObject(Sala::class.java)
                    mlista.add(sala)
                    println(mlista.size)
                    mAdapter.add(sala)
                    println("9999999999999999999999999999999999999999999999999999999999999999999999")
                }
<<<<<<< Updated upstream
                binding?.let{
                    mAdapter = SalasAdapter(ArrayList<Sala>(), this)
                    mLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
                    binding.recyclerSalas.apply {
                        setHasFixedSize(true)
                        layoutManager = mLayoutManager
                        adapter = mAdapter
                    }
                }
                mlista.forEach {
                    mAdapter.add(it)
                }
                mAdapter.notifyDataSetChanged()
=======
>>>>>>> Stashed changes

            }
            .addOnFailureListener{
                //Toast.makeText(this, "Error al consultar los datos", Toast.LENGTH_SHORT).show()
            }
    }

}