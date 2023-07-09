package edu.ucsc.cse118.assignment3.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a8\u0006\f"}, d2 = {"Ledu/ucsc/cse118/assignment3/repo/MessagesRepository;", "", "()V", "getMessages", "Ljava/util/ArrayList;", "Ledu/ucsc/cse118/assignment3/data/Messages;", "Lkotlin/collections/ArrayList;", "member", "Ledu/ucsc/cse118/assignment3/data/Member;", "channels", "Ledu/ucsc/cse118/assignment3/data/Channels;", "Companion", "app_debug"})
public final class MessagesRepository {
    @org.jetbrains.annotations.NotNull()
    public static final edu.ucsc.cse118.assignment3.repo.MessagesRepository.Companion Companion = null;
    private static final java.lang.String url = "https://cse118.com/api/v0/channel";
    
    public MessagesRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Messages> getMessages(@org.jetbrains.annotations.Nullable()
    edu.ucsc.cse118.assignment3.data.Member member, @org.jetbrains.annotations.Nullable()
    edu.ucsc.cse118.assignment3.data.Channels channels) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ledu/ucsc/cse118/assignment3/repo/MessagesRepository$Companion;", "", "()V", "url", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}