package edu.ucsc.cse118.assignment3.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.ui.workspaces.WorkspacesListener
import edu.ucsc.cse118.assignment3.R
import edu.ucsc.cse118.assignment3.data.Workspaces
import edu.ucsc.cse118.assignment3.data.Channels
import edu.ucsc.cse118.assignment3.databinding.FragmentWorkspacesBinding
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.model.ViewModelEvent

class WorkspacesFragment : Fragment(), WorkspacesListener {

    private var binding: FragmentWorkspacesBinding? = null

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        val error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }

    private val workspacesObserver = Observer<ArrayList<Workspaces>> { workspaces ->
        recyclerView.adapter = WorkspaceAdapter(workspaces, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.error.observe(this, errorObserver)
        sharedViewModel.workspaces.observe(this, workspacesObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.error.removeObserver(errorObserver)
        sharedViewModel.workspaces.removeObserver(workspacesObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentWorkspacesBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WorkspaceAdapter(arrayListOf(), this)
        sharedViewModel.getWorkspaces()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = sharedViewModel.member.value?.name
    }

    override fun onClick(workspace: Workspaces) {
        sharedViewModel.setWorkspace(workspace)
        goToNextScreen()
    }

    private fun goToNextScreen() {
        findNavController().navigate(R.id.action_workspacesFragment_to_channelsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}