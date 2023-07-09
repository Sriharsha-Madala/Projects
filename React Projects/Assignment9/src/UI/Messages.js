import React from 'react';
import {FlatList, StyleSheet, View, Button} from 'react-native';

import {workspacesContext} from '../Model/ViewModel';
import MessagesCard from './MessagesCard';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
  },
});

const Messages = ({navigation}) => {
  const {messages, getMessages} = React.useContext(workspacesContext);
  React.useEffect(() => {
    getMessages();
    navigation.setOptions({
      headerRight: () => (
        <Button
          onPress={() => {
            // console.log('logout');
            navigation.navigate('New Message');
          }}
          accessibilityLabel="add message"
          title="add"
          color="#fff"
        />
      ),
    });
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [navigation]);
  return (
    <View style={styles.container}>
      <FlatList
        data={messages} //.sort((a, b) => a.posted.localeCompare(b.posted))}//Date.parse(a.posted) < Date.parse(b.posted))}
        // data={messages}
        initialNumToRender={50}
        keyExtractor={item => item.id}
        renderItem={({item}) => (
          <MessagesCard message={item} navigation={navigation} />
        )}
      />
    </View>
  );
};

export default Messages;
