import React from 'react';
import {FlatList, Text, View, StyleSheet} from 'react-native';

import {workspacesContext} from '../Model/ViewModel';
import WorkspaceCard from '../UI/WorkspaceCard';

const styles = StyleSheet.create({
  container1: {
    flex: 1,
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

const Workspaces = ({navigation}) => {
  const {workspaces, response, getMembers} =
    React.useContext(workspacesContext);
  React.useEffect(() => {
    getMembers();
    // navigation.setOptions({
    //   headerRight: () => (
    //     <Button
    //       onPress={() => {
    //         // console.log('logout');
    //         reset();
    //       }}
    //       accessibilityLabel="reset"
    //       title="add"
    //       color="#fff"
    //     />
    //   ),
    // })
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  // console.log("line 32: " +members);
  return (
    <View style={styles.container1}>
      <Text style={styles.text}>{response}</Text>
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
