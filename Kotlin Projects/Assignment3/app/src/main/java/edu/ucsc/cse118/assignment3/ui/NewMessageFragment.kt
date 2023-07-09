package edu.ucsc.cse118.assignment3.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import edu.ucsc.cse118.assignment3.data.Messages
import edu.ucsc.cse118.assignment3.databinding.FragmentNewmessageBinding
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.model.ViewModelEvent

class NewMessageFragment : Fragment() {
    private var binding: FragmentNewmessageBinding? = null

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var nmessage: String? = null

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        val error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding?.newMessageButton?.isEnabled =
                (binding?.content?.text?.length!! >= 16);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.error.observe(this, errorObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.error.removeObserver(errorObserver)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewmessageBinding.inflate(inflater, container, false)
        binding?.newMessageButton?.isEnabled = false
        binding?.content?.addTextChangedListener(textWatcher)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.newMessageFragment = this



        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "New Message"

        nmessage = binding?.content?.text.toString()
    }

//    fun newMessage() {
//        sharedViewModel.addMessage()
//    }
}