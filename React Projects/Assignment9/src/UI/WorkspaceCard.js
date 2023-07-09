import React from 'react';
import Icon from 'react-native-vector-icons/Ionicons';
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

import {workspacesContext} from '../Model/ViewModel';

const WorkspaceCard = ({workspace, navigation}) => {
  const {setWorkspace} = React.useContext(workspacesContext);
  return (
    <TouchableWithoutFeedback
      onPress={() => {
        setWorkspace(workspace);
        navigation.navigate('Channels', {title: workspace.name});
      }}>
      <View style={styles.container1}>
        <Text style={styles.item}>{workspace.name}</Text>
        <View style={styles.container2}>
          <Icon name="folder-outline" size={20} color="black" />
          <Text style={styles.item} aria-label={'count for ' + workspace.name}>
            {workspace.channels.length}
          </Text>
        </View>
      </View>
    </TouchableWithoutFeedback>
  );
};

export default WorkspaceCard;
