package edu.ucsc.cse118.assignment3.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\'J\u0006\u0010\"\u001a\u00020\'J\u0006\u0010&\u001a\u00020\'J\u0016\u0010(\u001a\u00020\'2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u0006J\u000e\u0010-\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u000eJ\u000e\u0010.\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u0011R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\'\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\'\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\'\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\bj\b\u0012\u0004\u0012\u00020\u0011`\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001a\u00a8\u0006/"}, d2 = {"Ledu/ucsc/cse118/assignment3/model/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_channel", "Landroidx/lifecycle/MutableLiveData;", "Ledu/ucsc/cse118/assignment3/model/ViewModelEvent;", "Ledu/ucsc/cse118/assignment3/data/Channels;", "_channels", "Ljava/util/ArrayList;", "_error", "", "_member", "Ledu/ucsc/cse118/assignment3/data/Member;", "_message", "Ledu/ucsc/cse118/assignment3/data/Messages;", "_messages", "_workspace", "Ledu/ucsc/cse118/assignment3/data/Workspaces;", "_workspaces", "channel", "getChannel", "()Landroidx/lifecycle/MutableLiveData;", "channels", "Landroidx/lifecycle/LiveData;", "Lkotlin/collections/ArrayList;", "getChannels", "()Landroidx/lifecycle/LiveData;", "error", "getError", "member", "getMember", "message", "getMessage", "messages", "getMessages", "workspace", "getWorkspace", "workspaces", "getWorkspaces", "", "login", "email", "password", "setChannel", "value", "setMessage", "setWorkspace", "app_debug"})
public final class SharedViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Workspaces>> _workspaces = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Workspaces>> workspaces = null;
    private final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Workspaces>> _workspace = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Workspaces>> workspace = null;
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Channels>> _channels = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Channels>> channels = null;
    private final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Channels>> _channel = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Channels>> channel = null;
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Messages>> _messages = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Messages>> messages = null;
    private final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Messages>> _message = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Messages>> message = null;
    private final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<java.lang.String>> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<java.lang.String>> error = null;
    private final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.data.Member> _member = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.ucsc.cse118.assignment3.data.Member> member = null;
    
    public SharedViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Workspaces>> getWorkspaces() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Workspaces>> getWorkspace() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Channels>> getChannels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Channels>> getChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Messages>> getMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<edu.ucsc.cse118.assignment3.data.Messages>> getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.ucsc.cse118.assignment3.model.ViewModelEvent<java.lang.String>> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.ucsc.cse118.assignment3.data.Member> getMember() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void getWorkspaces() {
    }
    
    public final void getChannels() {
    }
    
    public final void getMessages() {
    }
    
    public final void setWorkspace(@org.jetbrains.annotations.NotNull()
    edu.ucsc.cse118.assignment3.data.Workspaces value) {
    }
    
    public final void setChannel(@org.jetbrains.annotations.NotNull()
    edu.ucsc.cse118.assignment3.data.Channels value) {
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    edu.ucsc.cse118.assignment3.data.Messages value) {
    }
}