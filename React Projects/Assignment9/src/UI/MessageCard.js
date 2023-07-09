import React from 'react';
import {StyleSheet, Text, View} from 'react-native';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    padding: 2,
  },
  item: {
    paddingLeft: 10,
    fontSize: 18,
  },
  teenyLogo: {
    width: 20,
    height: 20,
  },
});

import {workspacesContext} from '../Model/ViewModel';

const format = x => {
  var y = new Intl.DateTimeFormat('en-US', {
    month: 'short',
    day: 'numeric',
    year: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
    hour12: 'true',
  }).format(x);
  var parts = y.split(',');
  return parts[0] + ',' + parts[1] + ' at' + parts[2];
};

const MessageCard = ({navigation}) => {
  const {message} = React.useContext(workspacesContext);
  return (
    <View style={styles.container}>
      <Text style={styles.item}>{message.content}</Text>
      <Text style={styles.item}>{format(new Date(message.posted))}</Text>
    </View>
  );
};

export default MessageCard;
