/*
 * Copyright (C) 2022-2023 David C. Harrison. All right reserved.
 *
 * You may not use, distribute, publish, or modify this code without
 * the express written permission of the copyright holder.
 */

import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';

import Workspaces from './UI/Workspaces';
// import BallClubView from './UI/BallClubView';
import ViewModel from './Model/ViewModel';
import Channels from './UI/Channels';
import Messages from './UI/Messages';
import MessageCard from './UI/MessageCard';

const Stack = createStackNavigator();

const Main = () => {
  return (
    <ViewModel>
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="Workspaces" component={Workspaces} />
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
            options={({route}) => ({
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
        </Stack.Navigator>
      </NavigationContainer>
    </ViewModel>
  );
};

export default Main;
