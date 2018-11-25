
# react-native-smartassets

## Getting started

Smartassets change the react native image load logic by hook defaultAsset method.


Smartassets let your app can load image form apk(ipa in iOS case) and filesystem with smart choose.



<img src="https://github.com/smallnew/react-native-smartassets/raw/master/Sample/before_smart.jpg" width="350" alt="before"></img>
      <img src="https://github.com/smallnew/react-native-smartassets/raw/master/Sample/after_smart.png" width="390" alt="after"></img>
 

`$ npm install --save https://github.com/smallnew/react-native-smartassets.git`

### Mostly automatic installation

`$ react-native link react-native-smartassets`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-smartassets` and add `RNSmartassets.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSmartassets.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.smallnew.smartassets.RNSmartassetsPackage;` to the imports at the top of the file
  - Add `new RNSmartassetsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-smartassets'
  	project(':react-native-smartassets').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-smartassets/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-smartassets')
  	```


## Usage
```javascript
import {SmartAssets} from 'react-native-smartassets';
SmartAssets.initSmartAssets();
SmartAssets.setiOSRelateMainBundlePath(youOriginJsBundlePath);//optional

```
  
