package com.example.reservatyvivesadmin

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.reservatyvivesadmin.databinding.FragmentCreateReserbationBinding
import com.google.firebase.firestore.FirebaseFirestore


class CreateReserbationFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentCreateReserbationBinding.inflate(inflater, container, false)

        binding.buttonCancelarSala.setOnClickListener {
            view?.let {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_createReserbationFragment_to_loggingFragment)
            }
        }
        binding.buttonGuargarSala.setOnClickListener {

            println("creamos sala ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
            //crear sala

            var s = Sala(
                nombre = binding.editTextTextNombreSala.text.toString(),
                localizacion = binding.editTextTextLocalizacionSala.text.toString(),
                edificio = binding.editTextTextEdificioSala.text.toString(),
                horaApertura = binding.editTextNumberApertura.text.toString().toInt(),
                horaCierre = binding.editTextNumberCierre.text.toString().toInt(),
                imagen = ""
            )

            println( "sala creada¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
            println(s)
            saveSala(s)

            view?.let {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_createReserbationFragment_to_loggingFragment)
            }
        }
        return binding.root
    }

    private fun saveSala(s: Sala) {
        println( "¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
        println(s)

        val db = FirebaseFirestore.getInstance()
        println( db.collection("salas").document().toString())

        db.collection("Salass")
            .add(s)
            .addOnSuccessListener {
                Toast.makeText(activity, "Producto añadido", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener {
                Toast.makeText(activity, "Error al insertar", Toast.LENGTH_SHORT).show()
            }


    }
}