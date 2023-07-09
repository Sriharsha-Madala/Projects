package edu.ucsc.cse118.assignment3;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import edu.ucsc.cse118.assignment3.databinding.FragmentChannelBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentLoginBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentMessageBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentMessagesBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentNewmessageBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentWorkspacesBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTCHANNEL = 1;

  private static final int LAYOUT_FRAGMENTLOGIN = 2;

  private static final int LAYOUT_FRAGMENTMESSAGE = 3;

  private static final int LAYOUT_FRAGMENTMESSAGES = 4;

  private static final int LAYOUT_FRAGMENTNEWMESSAGE = 5;

  private static final int LAYOUT_FRAGMENTWORKSPACES = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_channel, LAYOUT_FRAGMENTCHANNEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_message, LAYOUT_FRAGMENTMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_messages, LAYOUT_FRAGMENTMESSAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_newmessage, LAYOUT_FRAGMENTNEWMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_workspaces, LAYOUT_FRAGMENTWORKSPACES);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTCHANNEL: {
          if ("layout/fragment_channel_0".equals(tag)) {
            return new FragmentChannelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_channel is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMESSAGE: {
          if ("layout/fragment_message_0".equals(tag)) {
            return new FragmentMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_message is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMESSAGES: {
          if ("layout/fragment_messages_0".equals(tag)) {
            return new FragmentMessagesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_messages is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEWMESSAGE: {
          if ("layout/fragment_newmessage_0".equals(tag)) {
            return new FragmentNewmessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_newmessage is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWORKSPACES: {
          if ("layout/fragment_workspaces_0".equals(tag)) {
            return new FragmentWorkspacesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_workspaces is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "channelFragment");
      sKeys.put(2, "loginFragment");
      sKeys.put(3, "messageFragment");
      sKeys.put(4, "messagesFragment");
      sKeys.put(5, "newMessageFragment");
      sKeys.put(6, "viewModel");
      sKeys.put(7, "workspacesFragment");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/fragment_channel_0", edu.ucsc.cse118.assignment3.R.layout.fragment_channel);
      sKeys.put("layout/fragment_login_0", edu.ucsc.cse118.assignment3.R.layout.fragment_login);
      sKeys.put("layout/fragment_message_0", edu.ucsc.cse118.assignment3.R.layout.fragment_message);
      sKeys.put("layout/fragment_messages_0", edu.ucsc.cse118.assignment3.R.layout.fragment_messages);
      sKeys.put("layout/fragment_newmessage_0", edu.ucsc.cse118.assignment3.R.layout.fragment_newmessage);
      sKeys.put("layout/fragment_workspaces_0", edu.ucsc.cse118.assignment3.R.layout.fragment_workspaces);
    }
  }
}
