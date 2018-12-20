import { NativeModules } from 'react-native';
import AssetSourceResolver from "react-native/Libraries/Image/AssetSourceResolver";
const { Smartassets } = NativeModules;
let iOSRelateMainBundlePath='';
let _sourceCodeScriptURL: ?string;
function getSourceCodeScriptURL(): ?string {
    if (_sourceCodeScriptURL) {
        return _sourceCodeScriptURL;
    }
    let sourceCode =
        global.nativeExtensions && global.nativeExtensions.SourceCode;
    if (!sourceCode) {
        sourceCode = NativeModules && NativeModules.SourceCode;
    }
    _sourceCodeScriptURL = sourceCode.scriptURL;
    return _sourceCodeScriptURL;
}
const defaultMainBundePath = Smartassets.DefaultMainBundlePath;
var _ = require('lodash');
var SmartAssets= {
    initSmartAssets(){
        var initialize = _.once(this.initSmartAssetsInner);
        initialize();
    },
     initSmartAssetsInner() {
         let drawablePathInfos = [];
         Smartassets.travelDrawable(getSourceCodeScriptURL(),
             (retArray)=>{
             drawablePathInfos = drawablePathInfos.concat(retArray);
         });
         AssetSourceResolver.prototype.defaultAsset=_.wrap(AssetSourceResolver.prototype.defaultAsset, function (func, ...args) {
             if (this.isLoadedFromServer()) {
                 return this.assetServerURL();
             }
             if (Platform.OS === 'android') {
                 if(this.isLoadedFromFileSystem()){//begin assets ios begin drawable android
                     let resolvedAssetSource = this.drawableFolderInBundle();
                     let resPath = resolvedAssetSource.uri;
                     if(drawablePathInfos.includes(resPath)){//已经在bundle目录中有
                         return resolvedAssetSource;
                     }
                     let isFileExist =  Smartassets.isFileExist(resPath);
                     if(isFileExist===true){
                         return resolvedAssetSource;
                     }else {
                         return this.resourceIdentifierWithoutScale();
                     }
                 }else {
                     return this.resourceIdentifierWithoutScale();
                 }
             } else {
                 let iOSAsset = this.scaledAssetURLNearBundle();
                 let isFileExist =  Smartassets.isFileExist(iOSAsset.uri);
                 if(isFileExist) {
                     return iOSAsset;
                 }else{
                     let oriJsBundleUrl = 'file://'+defaultMainBundePath+'/'+iOSRelateMainBundlePath;
                     iOSAsset.uri = iOSAsset.uri.replace(this.jsbundleUrl, oriJsBundleUrl);
                     return iOSAsset;
                 }
             }
         });
     },
    setiOSRelateMainBundlePath(relatePath){
        iOSRelateMainBundlePath = relatePath;
    }
}

export  {SmartAssets};
