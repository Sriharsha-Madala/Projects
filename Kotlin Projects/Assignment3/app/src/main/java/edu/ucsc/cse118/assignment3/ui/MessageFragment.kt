package edu.ucsc.cse118.assignment3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import edu.ucsc.cse118.assignment3.R
import edu.ucsc.cse118.assignment3.data.Messages
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.databinding.FragmentMessageBinding
import edu.ucsc.cse118.assignment3.model.ViewModelEvent


class MessageFragment : Fragment() {

    private lateinit var binding: FragmentMessageBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        var error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }

    private val messageObserver = Observer<ViewModelEvent<Messages>> { event ->
        val message = event.getUnhandledContent()
        if (message != null) {
            (activity as AppCompatActivity?)!!.supportActionBar!!.title = message.poster
            binding?.name?.text = message.date
            binding?.channels?.text = message.content
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.error.observe(this, errorObserver)
        sharedViewModel.message.observe(this, messageObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.error.removeObserver(errorObserver)
        sharedViewModel.message.removeObserver(messageObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val message = sharedViewModel.message.value
        view.findViewById<TextView>(R.id.name).text = message?.getRawContent()?.date
        view.findViewById<TextView>(R.id.channels).text = message?.getRawContent()?.content
    }
}