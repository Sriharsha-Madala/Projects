import React from 'react';
import {Button} from 'react-native';

import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';

import Workspaces from './UI/Workspaces';
// import BallClubView from './UI/BallClubView';
import ViewModel from './Model/ViewModel';
import Channels from './UI/Channels';
import Messages from './UI/Messages';
import MessageCard from './UI/MessageCard';
import NewMessage from './UI/NewMessage';
import Login from './UI/Login';
import {workspacesContext} from './Model/ViewModel';

const Stack = createStackNavigator();

const Main = () => {
  const {setloggedIn} = React.useContext(workspacesContext);
  return (
    <ViewModel>
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="Login" component={Login} />
          <Stack.Screen
            name="Workspaces"
            component={Workspaces}
            options={({route, navigation}) => ({
              title: route.params.title,
              headerBackTitle: 'Login',
              headerLeft: () => (
                <Button
                  onPress={() => {
                    setloggedIn(false);
                    // console.log('logout');
                    navigation.navigate('Login');
                  }}
                  accessibilityLabel="logout"
                  title="Info"
                  color="#fff"
                />
              ),
              headerBackAccessibilityLabel: 'back to Login',
            })}
          />
          <Stack.Screen
            name="Channels"
            component={Channels}
            options={({route}) => ({
              title: route.params.title,
              headerBackTitle: 'Workspaces',
              headerBackAccessibilityLabel: 'back to workspaces',
            })}
          />
          <Stack.Screen
            name="Messages"
            component={Messages}
            options={({route, navigation}) => ({
              title: route.params.title,
              headerBackTitle: 'Channels',

              headerBackAccessibilityLabel: 'back to channels',
            })}
          />
          <Stack.Screen
            name="Message"
            component={MessageCard}
            options={({route}) => ({
              title: route.params.title,
              headerBackTitle: 'Messages',
              headerBackAccessibilityLabel: 'back to channel',
            })}
          />
          <Stack.Screen
            name="New Message"
            component={NewMessage}
            options={({}) => ({
              title: 'New Message',
              headerBackTitle: 'Message',
              headerBackAccessibilityLabel: 'back to channel',
            })}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </ViewModel>
  );
};
export default Main;
