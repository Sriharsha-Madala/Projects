package edu.ucsc.cse118.assignment3.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\tR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Ledu/ucsc/cse118/assignment3/model/ViewModelEvent;", "T", "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "handled", "", "getRawContent", "()Ljava/lang/Object;", "getUnhandledContent", "app_debug"})
public class ViewModelEvent<T extends java.lang.Object> {
    private final T content = null;
    private boolean handled = false;
    
    public ViewModelEvent(T content) {
        super();
    }
    
    /**
     * Returns the content and prevents its use again.
     */
    @org.jetbrains.annotations.Nullable()
    public final T getUnhandledContent() {
        return null;
    }
    
    /**
     * Returns the content, even if it's already been handled.
     */
    public final T getRawContent() {
        return null;
    }
}