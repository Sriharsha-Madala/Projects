package edu.ucsc.cse118.assignment3.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucsc.cse118.assignment3.data.Channels
import edu.ucsc.cse118.assignment3.data.Messages
import edu.ucsc.cse118.assignment3.data.Workspaces
import edu.ucsc.cse118.assignment3.data.Member
import edu.ucsc.cse118.assignment3.model.ViewModelEvent
import edu.ucsc.cse118.assignment3.repo.ChannelsRepository
import edu.ucsc.cse118.assignment3.repo.MemberRepository
import edu.ucsc.cse118.assignment3.repo.MessagesRepository
import edu.ucsc.cse118.assignment3.repo.WorkspacesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.time.LocalDateTime

class SharedViewModel : ViewModel() {
    private val _workspaces = MutableLiveData<ArrayList<Workspaces>>()
    val workspaces: LiveData<ArrayList<Workspaces>> = _workspaces

    private val _workspace = MutableLiveData<ViewModelEvent<Workspaces>>()
    val workspace: LiveData<ViewModelEvent<Workspaces>> = _workspace

    private val _channels = MutableLiveData<ArrayList<Channels>>()
    val channels : LiveData<ArrayList<Channels>> = _channels

    private val _channel = MutableLiveData<ViewModelEvent<Channels>>()
    val channel : MutableLiveData<ViewModelEvent<Channels>> = _channel

    private val _messages = MutableLiveData<ArrayList<Messages>>()
    val messages : LiveData<ArrayList<Messages>> = _messages

    private val _message = MutableLiveData<ViewModelEvent<Messages>>()
    val message : MutableLiveData<ViewModelEvent<Messages>> = _message

    private val _error = MutableLiveData<ViewModelEvent<String>>()
    val error : LiveData<ViewModelEvent<String>> = _error

    private val _member = MutableLiveData<Member>()
    val member : LiveData<Member> = _member

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                print("at shared view model")
                _member.postValue(MemberRepository().login(email, password))
            } catch (e: Exception) {
                print("at shared view model")
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }

    fun getWorkspaces() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _workspaces.postValue(WorkspacesRepository().getWorkspaces(member.value))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }

    fun getChannels() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _channels.postValue(ChannelsRepository().getChannels(member.value, _workspace.value?.getRawContent()))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }

    fun getMessages() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _messages.postValue(MessagesRepository().getMessages(member.value, _channel.value?.getRawContent()))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }

//    fun addMessage(nmessage: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                MessagesRepository().addMessage(member.value, Messages(channel.value?.getRawContent()!!.id, member.value!!.name, LocalDateTime.now().toString(), nmessage))
//                _club.postValue(ViewModelEvent(club))
//            } catch (e: Exception) {
//                _error.postValue(ViewModelEvent(e.message.toString()))
//            }
//        }
//    }

    fun setWorkspace(value: Workspaces) {
      _workspace.value = ViewModelEvent(value)
    }
    fun setChannel(value: Channels) {
        _channel.value = ViewModelEvent(value)
    }
    fun setMessage(value: Messages) {
        _message.value = ViewModelEvent(value)
    }
}