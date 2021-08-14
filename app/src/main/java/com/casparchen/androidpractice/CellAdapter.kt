package com.casparchen.androidpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.casparchen.androidpractice.databinding.CellRestaurantBinding

class CellAdapter(private val restaurants: List<RowRestaurant>): RecyclerView.Adapter<CellAdapter.CellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var binding = CellRestaurantBinding.inflate(inflater, parent, false)
        return CellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val currentRestaurant = restaurants[position]
        holder.binding.nameRestaurant.text = currentRestaurant.rowName
        holder.binding.telRestaurant.text = currentRestaurant.rowTel
        holder.binding.addRestaurant.text = currentRestaurant.rowAdd
        holder.binding.opentimeRestaurant.text = currentRestaurant.rowOpentime
        holder.binding.introRestaurant.text = currentRestaurant.rowDescription
    }

    override fun getItemCount(): Int {
        return restaurants.count()
    }


    inner class CellViewHolder(val binding: CellRestaurantBinding): RecyclerView.ViewHolder(binding.root) {
//        lateinit var textView: TextView
//
//        init {
//            textView = findViewById(R.id.tel)
//        }
    }
}