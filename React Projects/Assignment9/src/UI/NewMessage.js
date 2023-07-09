import React from 'react';
import {StyleSheet, Button, View} from 'react-native';
import {TextInput} from 'react-native-gesture-handler';

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
});

// import {workspacesContext} from '../Model/ViewModel';

const NewMessage = ({navigation}) => {
  //   const {postMessage} = React.useContext(workspacesContext);
  const [newMessage, setnewMessage] = React.useState('');

  return (
    <View style={styles.container1}>
      <TextInput
        style={styles.input}
        accessibilityLabel="content"
        onChangeText={setnewMessage}
        value={newMessage}
      />
      <View style={styles.container2}>
        <Button
          title="OK"
          accessibilityLabel="add"
          onPress={() => {
            console.log('pressed add message');
          }}
        />
        <Button
          title="Cancel"
          accessibilityLabel="cancel message"
          onPress={() => {
            // navigation.goBack();
            console.log('went back');
          }}
        />
      </View>
    </View>
  );
};

export default NewMessage;
