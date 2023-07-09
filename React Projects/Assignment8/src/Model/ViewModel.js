import React from 'react';

import {GET as GET_WORKSPACES} from '../Repo/WorkspacesRepo';

export const workspacesContext = React.createContext();

const ViewModel = props => {
  const [workspaces, setWorkspaces] = React.useState([]);
  const [workspace, setWorkspace] = React.useState();
  const [channels, setChannels] = React.useState([]);
  const [channel, setChannel] = React.useState();
  const [messages, setMessages] = React.useState([]);
  const [message, setMessage] = React.useState();

  React.useEffect(() => {
    const fetchData = async () => {
      var wks = await GET_WORKSPACES();
      setWorkspaces(wks);
    };
    fetchData();
  }, []);

  return (
    <workspacesContext.Provider
      value={{
        workspaces,
        workspace,
        setWorkspace,
        channels,
        setChannels,
        channel,
        setChannel,
        messages,
        setMessages,
        message,
        setMessage,
      }}>
      {props.children}
    </workspacesContext.Provider>
  );
};

export default ViewModel;
