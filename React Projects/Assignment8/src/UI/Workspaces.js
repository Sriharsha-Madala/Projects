import React from 'react';
import {FlatList, StyleSheet, View} from 'react-native';

import {workspacesContext} from '../Model/ViewModel';
import WorkspaceCard from '../UI/WorkspaceCard';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
  },
});

const Workspaces = ({navigation}) => {
  const {workspaces} = React.useContext(workspacesContext);
  return (
    <View style={styles.container}>
      <FlatList
        data={workspaces}
        initialNumToRender={50}
        keyExtractor={item => item.id}
        renderItem={({item}) => (
          <WorkspaceCard workspace={item} navigation={navigation} />
        )}
      />
    </View>
  );
};

export default Workspaces;
