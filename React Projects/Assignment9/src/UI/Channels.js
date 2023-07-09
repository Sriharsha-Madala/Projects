import React from 'react';
import {StyleSheet, FlatList, View} from 'react-native';

import ChannelsCard from './ChannelsCard';
import {workspacesContext} from '../Model/ViewModel';
// import StadiumCard from '../UI/StadiumCard';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
  },
  tinyLogo: {
    width: 80,
    height: 80,
  },
});

const Channels = ({navigation}) => {
  const {channels, getChannels} = React.useContext(workspacesContext);
  React.useEffect(() => {
    getChannels();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  return (
    <View style={styles.container}>
      {/* <Image style={styles.tinyLogo} source={{uri: ballclub.logo}} /> */}
      <FlatList
        data={channels}
        initialNumToRender={50}
        keyExtractor={item => item.id}
        renderItem={({item}) => (
          <ChannelsCard channel={item} navigation={navigation} />
        )}
      />
    </View>
  );
};

export default Channels;
