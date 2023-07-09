package edu.ucsc.cse118.assignment3.ui.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.R
import edu.ucsc.cse118.assignment3.data.Messages
import edu.ucsc.cse118.assignment3.databinding.FragmentMessagesBinding
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.model.ViewModelEvent
import edu.ucsc.cse118.assignment3.ui.MessagesListener

class MessagesFragment : Fragment(), MessagesListener {

    private var binding: FragmentMessagesBinding? = null

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        val error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }

    private val workspacesObserver = Observer<ArrayList<Messages>> { messages ->
        recyclerView.adapter = MessageAdapter(messages, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.error.observe(this, errorObserver)
        sharedViewModel.messages.observe(this, workspacesObserver)

    }

    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.error.removeObserver(errorObserver)
        sharedViewModel.messages.removeObserver(workspacesObserver)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMessagesBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = MessageAdapter(arrayListOf(), this)
        sharedViewModel.getMessages()

        (activity as AppCompatActivity?)!!.supportActionBar!!.title = sharedViewModel.channel.value?.getRawContent()?.name

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            findNavController().navigate(R.id.action_messagesFragment2_to_newMessageFragment)
        }
    }

    override fun onClick(message: Messages) {
        sharedViewModel.setMessage(message)
        goToNextScreen()
    }

    private fun goToNextScreen() {
        findNavController().navigate(R.id.action_messagesFragment2_to_messageFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}