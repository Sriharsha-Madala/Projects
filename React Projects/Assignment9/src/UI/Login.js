import React from 'react';
import {Text, Button, View, StyleSheet} from 'react-native';

import {TextInput} from 'react-native-gesture-handler';

import {workspacesContext} from '../Model/ViewModel';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    alignItems: 'center',
    width: '100%',
    flexDirection: 'column',
  },
  input: {
    marginTop: 10,
    marginBottom: 10,
    width: '66%',
    paddingHorizontal: 10,
    borderColor: '#ccc',
    borderWidth: 1,
    borderRadius: 10,
    fontSize: 16,
    backgroundColor: 'white',
  },
});

const Login = ({navigation}) => {
  const [user, setUser] = React.useState('srmadala@ucsc.edu');
  const [pass, setPass] = React.useState('1755898');
  const [running, setRunning] = React.useState(false);
  const {setToken, setloggedIn} = React.useContext(workspacesContext);

  const login = async () => {
    // lgn(navigation, user, pass);
    setRunning(true);
    await fetch('https://cse118.com/api/v2/login', {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        email: user,
        password: pass,
      }),
    })
      .then(response => {
        if (response.status === 200) {
          return response.json();
        } else {
          //   console.log(response.status);
        }
      })
      .then(json => {
        // console.log(json);
        setToken(json?.accessToken);
        // console.log(token);
        // setloginID(json.id);
        // console.log(json.id);
        setloggedIn(true);
        setRunning(false);
        navigation.navigate('Workspaces', {title: 'Workspaces'});
      });
  };

  return (
    <View style={styles.container}>
      <Text>CSE118 Assignment 8</Text>
      {/* <Text style={styles.text}>{user}</Text> */}
      {/* <Text style={styles.text}>{pass}</Text> */}
      <TextInput
        style={styles.input}
        accessibilityLabel="email"
        onChangeText={setUser}
        value={user}
      />
      <TextInput
        style={styles.input}
        accessibilityLabel="password"
        onChangeText={setPass}
        value={pass}
      />
      <Button
        disabled={running}
        title="Login"
        accessibilityLabel="login"
        onPress={login}
      />
    </View>
  );
};

export default Login;
