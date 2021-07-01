package com.example.bacaberita.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bacaberita.Model.ModelBerita
import com.example.bacaberita.R
import com.example.bacaberita.UI.Detail_News

class AdapterBerita(private val modelBerita: List<ModelBerita>) : RecyclerView.Adapter<AdapterBerita.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = modelBerita.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = modelBerita[position]
        holder.title.text = model.title
        holder.desc.text = model.abstract
        holder.card!!.setOnClickListener {
//            val intent = Intent(this, Detail_News::class.java)
//                startActivity(intent)
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val desc: TextView = itemView.findViewById(R.id.desc)
        val card: CardView = itemView.findViewById(R.id.card)
    }
}