package edu.ucsc.cse118.assignment3.ui.channels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.R
import edu.ucsc.cse118.assignment3.data.Channels
import edu.ucsc.cse118.assignment3.ui.channels.ChannelsListener

class ChannelAdapter (private val channels: ArrayList<Channels>, private val listener: ChannelsListener) :
    RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_workspaces, parent, false)
        return ChannelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(channels[position])
        holder.itemView.setOnClickListener { listener.onClick(channels[position]) }
    }

    override fun getItemCount(): Int {
        return channels.size
    }

    class ChannelViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val message : TextView = itemView.findViewById(R.id.channels)

        fun bind(channel: Channels) {
            name.text = channel.name
            val txt = channel.messages.toString() + " Messages"
            message.text = txt
        }
    }
}