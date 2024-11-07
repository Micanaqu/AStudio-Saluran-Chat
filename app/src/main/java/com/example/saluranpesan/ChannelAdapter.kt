package com.example.saluranpesan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChannelAdapter(
    private val channels: List<Channel>,
    private val onClick: (Channel) -> Unit
) : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

    class ChannelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val channelImage: ImageView = view.findViewById(R.id.channelImage)
        val channelName: TextView = view.findViewById(R.id.channelName)
        val channelDescription: TextView = view.findViewById(R.id.channelDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.channel_item, parent, false)
        return ChannelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channels[position]
        holder.channelName.text = channel.name
        holder.channelDescription.text = channel.description
        // Load image with Glide or Picasso (not implemented here)
        holder.itemView.setOnClickListener { onClick(channel) }
    }

    override fun getItemCount(): Int = channels.size
}
