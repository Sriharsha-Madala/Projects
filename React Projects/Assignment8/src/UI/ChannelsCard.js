import React from 'react';
import Icon from 'react-native-vector-icons/SimpleLineIcons';
import {TouchableWithoutFeedback, StyleSheet, Text, View} from 'react-native';

const styles = StyleSheet.create({
  container1: {
    flex: 1,
    flexDirection: 'column',
    padding: 2,
  },
  container2: {
    flex: 1,
    flexDirection: 'row',
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

// const days = x => {
//   // if (x.length > 0) {
//   //   var date1 = new Date(x[0]);
//   //   print(x[0]);
//   //   var date2 = new Date();
//   //   var diffDays = date2.getDate() - date1.getDate();
//   //   return diffDays;
//   // }
//   return typeof x;
// };

import {workspacesContext} from '../Model/ViewModel';

const ChannelsCard = ({channel, navigation}) => {
  const {setChannel, setMessages} = React.useContext(workspacesContext);
  return (
    <TouchableWithoutFeedback
      onPress={() => {
        setChannel(channel);
        setMessages(
          channel.messages.sort((a, b) => b.posted.localeCompare(a.posted)),
        );
        navigation.navigate('Messages', {title: channel.name});
      }}>
      <View style={styles.container1}>
        <Text style={styles.item}>{channel.name}</Text>
        <View style={styles.container2}>
          <Icon name="envelope" size={20} color="black" />
          <Text style={styles.item} aria-label={'count for ' + channel.name}>
            {channel.messages.length}
          </Text>
        </View>
      </View>
    </TouchableWithoutFeedback>
  );
};

export default ChannelsCard;
