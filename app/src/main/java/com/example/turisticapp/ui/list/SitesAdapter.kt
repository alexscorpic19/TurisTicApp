package com.example.turisticapp.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turisticapp.R
import com.example.turisticapp.models.SitesItem

import com.squareup.picasso.Picasso

class SitesAdapter(
    private val sitesList: ArrayList<SitesItem>,
    private val onItemClicked: (SitesItem) -> Unit
) : RecyclerView.Adapter<SitesAdapter.SitesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_sites_item, parent, false)
        return SitesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SitesViewHolder, position: Int) {
        val sites = sitesList[position]
        holder.itemView.setOnClickListener { onItemClicked(sitesList[position]) }
        holder.bind(sites)
    }

    override fun getItemCount(): Int = sitesList.size

    fun appendItems(newItems: ArrayList<SitesItem>) {
        sitesList.clear()
        sitesList.addAll(newItems)
        notifyDataSetChanged()
    }

    class SitesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.tvName)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.tvDescription)
        private var pointsTextView: TextView = itemView.findViewById(R.id.tvPoints)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.itemImage)

        fun bind(sites: SitesItem){
            Log.d("nombre",sites.name)
            nameTextView.text = sites.name
            descriptionTextView.text = sites.description
            pointsTextView.text = sites.points
            Picasso.get().load(sites.linkimage).into(pictureImageView)
        }
    }
}