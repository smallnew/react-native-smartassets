/** @format */
import {AppRegistry,NativeModules} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import {SmartAssets} from 'react-native-smartassets';
SmartAssets.initSmartAssets();
AppRegistry.registerComponent(appName, () => App);
