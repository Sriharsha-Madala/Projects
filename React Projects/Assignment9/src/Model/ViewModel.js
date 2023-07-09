import React from 'react';

export const workspacesContext = React.createContext();

const ViewModel = props => {
  const [loggedIn, setloggedIn] = React.useState(false);
  const [token, setToken] = React.useState();
  const [loginID, setloginID] = React.useState();
  const [workspaces, setWorkspaces] = React.useState([]);
  const [workspace, setWorkspace] = React.useState();
  const [channels, setChannels] = React.useState([]);
  const [channel, setChannel] = React.useState();
  const [messages, setMessages] = React.useState([]);
  const [message, setMessage] = React.useState();
  const [members, setMembers] = React.useState([]);

  // const getWorkspaces

  const returnName = id => {
    var i = 0;
    // console.log(members[i]);
    // members.forEach()
    while (i < members.length) {
      if (members[i].id === id) {
        // console.log(members[i].name)
        return members[i].name;
      }
      i++;
    }
  };

  React.useEffect(() => {
    const fetchData = async () => {
      // console.log(members);
      await fetch('https://cse118.com/api/v2/workspace', {
        method: 'GET',
        headers: {
          Accept: 'application/json',
          // 'Content-Type': 'application/json',
          Authorization: 'Bearer ' + token,
        },
      })
        .then(response => {
          // console.log("lione 17")
          if (response.status === 200) {
            return response.json();
          }
        })
        .then(json => {
          // console.log("this is the json "+json);
          // console.log(json);
          setWorkspaces(json);
        });
      // console.log("this is workspascse " +workspaces);
    };
    fetchData();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [loggedIn]);

  const getMembers = async () => {
    // console.log("getting workspaces");
    await fetch('https://cse118.com/api/v2/member', {
      method: 'GET',
      headers: {
        Accept: 'application/json',
        // 'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token,
      },
    })
      .then(response => {
        return response.json();
      })
      .then(json => {
        setMembers(json);
        // console.log(json);
      });
  };

  // const postMessage = async content => {
  //   console.log(channel.id);
  //   console.log('this is the contentt ' + content);
  //   await fetch(
  //     'https://cse118.com/api/v2/channel/' + channel.id + '/message',
  //     {
  //       method: 'POST',
  //       headers: {
  //         Accept: 'application/json',
  //         'Content-Type': 'application/json',
  //         Authorization: 'Bearer ' + token,
  //       },
  //       body: JSON.stringify({
  //         content: content,
  //       }),
  //     },
  //   )
  //     .then(response => {
  //       console.log('this is the response for post: ' + response);
  //       return response.json();
  //     })
  //     .then(json => {
  //       console.log(json);
  //       var x = messages;
  //       x.push(json);
  //       setMessages(x);
  //       // console.log(json);
  //     });
  // };

  // const reset = async () => {
  //   await fetch('https://cse118.com/api/v2/reset', {
  //     method: 'PUT',
  //     headers: {
  //       Accept: 'application/json',
  //       // 'Content-Type': 'application/json',
  //       Authorization: 'Bearer ' + token,
  //     },
  //   }).then(response => {
  //     console.log('this is the response for post: ' + response.status);
  //   });
  // };

  const getChannels = async () => {
    // console.log(members);
    // console.log("getting workspaces");
    await fetch(
      'https://cse118.com/api/v2/workspace/' + workspace.id + '/channel',
      {
        method: 'GET',
        headers: {
          Accept: 'application/json',
          // 'Content-Type': 'application/json',
          Authorization: 'Bearer ' + token,
        },
      },
    )
      .then(response => {
        return response.json();
      })
      .then(json => {
        setChannels(json);
      });
  };

  const getMessages = async () => {
    await fetch(
      'https://cse118.com/api/v2/channel/' + channel.id + '/message',
      {
        method: 'GET',
        headers: {
          Accept: 'application/json',
          // 'Content-Type': 'application/json',
          Authorization: 'Bearer ' + token,
        },
      },
    )
      .then(response => {
        // console.log('line 104 ' + response);
        // console.log('return status is: ' + response.status);
        // console.log('response json is: ' + response.json);
        return response.json();
      })
      .then(json => {
        // console.log('line 113 ' + json);
        setMessages(json);
      });
  };

  return (
    <workspacesContext.Provider
      value={{
        // deleteMessage,
        // reset,
        // postMessage,
        returnName,
        members,
        getMembers,
        getChannels,
        getMessages,
        loggedIn,
        setloggedIn,
        token,
        setToken,
        loginID,
        setloginID,
        workspaces,
        setWorkspaces,
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
// export function lgn() {
//   LOGIN();
// }

export default ViewModel;
