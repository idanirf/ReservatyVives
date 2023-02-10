package com.example.reservatyvivesadmin.recycler

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.View.inflate
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.reservatyvivesadmin.R
import com.example.reservatyvivesadmin.Sala
import com.example.reservatyvivesadmin.databinding.ActivityMainBinding
import com.example.reservatyvivesadmin.databinding.ActivityMainBinding.inflate
import com.example.reservatyvivesadmin.databinding.FragmentCreateReserbationBinding
import com.example.reservatyvivesadmin.databinding.FragmentRecyclerSalasBinding
import com.example.reservatyvivesadmin.databinding.ItemSalaBinding
import com.example.reservatyvivesadmin.recycler.ClickListenerInterface

class SalasAdapter(private var list: MutableList<Sala>, private val clickListenerInterface: ClickListenerInterface)
    : RecyclerView.Adapter<SalasAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context //inicializar el contexto
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_sala, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.bind(item)

        holder.setListener(item)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(p: Sala){
        if (!list.contains(p)){
            list.add(p)
            notifyItemInserted(list.size-1)
        }else{
            update(p)
        }
    }

    fun update(p: Sala){
        val index = list.indexOf(p)
        if (index != -1){
            list.set(index, p)
            notifyItemChanged(index)
        }
    }

    fun delete(p: Sala){
        val index = list.indexOf(p)
        if (index != -1){
            list.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun setData(l: ArrayList<Sala>) {
        this.list = l
        notifyDataSetChanged()
    }



    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemSalaBinding.bind(view)

        fun bind(p: Sala) {
            // binding.imageViewSala
            binding.textViewEdificio.text = p.edificio
            binding.textViewNombre.text = p.nombre
            binding.textViewLocalizacion.text = p.localizacion

            /**

            Glide.with(mContext)
            .load(p.imagen)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.imageViewSala)



             */


        }

        fun setListener(item: Sala) {
            binding.root.setOnLongClickListener { clickListenerInterface.click(item) }
        }
    }
    }