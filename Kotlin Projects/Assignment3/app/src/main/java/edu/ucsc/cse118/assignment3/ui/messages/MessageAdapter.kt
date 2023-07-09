package edu.ucsc.cse118.assignment3.ui.messages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.R
import edu.ucsc.cse118.assignment3.data.Messages
import edu.ucsc.cse118.assignment3.ui.MessagesListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MessageAdapter(private val messages: ArrayList<Messages>, private val listener: MessagesListener) :  RecyclerView.Adapter<MessageAdapter.MessageViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_workspaces, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
        holder.itemView.setOnClickListener { listener.onClick(messages[position]) }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    class MessageViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val date : TextView = itemView.findViewById(R.id.channels)
        private val content : TextView = itemView.findViewById(R.id.extra)

        fun bind(message: Messages) {
            name.text = message.poster
            val parts = message.date.split("Z")
            val lt = LocalDateTime.parse(parts[0])
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, YYYY, K:mm:ss a")
            val formatDateTime: String = lt.format(formatter)
            message.date = formatDateTime
            date.text = formatDateTime
            content.text = message.content
        }
    }
}