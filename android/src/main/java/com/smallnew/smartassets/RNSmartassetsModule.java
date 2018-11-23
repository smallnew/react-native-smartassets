
package com.smallnew.smartassets;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.MapBuilder;

import java.io.File;
import java.io.FileFilter;
import java.util.Map;

public class RNSmartassetsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  static final Map<String, Object> CONSTANTS = MapBuilder.<String, Object>of(
          "hello", "kitty");

  public RNSmartassetsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "Smartassets";
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  public boolean isFileExist(String filePath){
    Log.e("Smartassets","filePath ====> "+filePath);
    if(filePath==null){
      return false;
    }
    File imageFile = new File(filePath.replace("file://",""));
    return (imageFile.exists());
  }

  @ReactMethod
  public void travelDrawable(String bundlePath, Callback callback){
    Log.e("Smartassets","bundlePath ===> "+bundlePath);
    WritableArray fileMaps = Arguments.createArray();
    File bundleFile = new File(bundlePath);
    File bundleDir = bundleFile.getParentFile();
    if(bundleDir.isDirectory()){
      FileFilter filter = new FileFilter(){
        @Override
        public boolean accept(File file) {
          return file!=null&&file.getName().startsWith("drawable")&&file.isDirectory();
        }
      };
      File[] drawableDirs = bundleDir.listFiles(filter);
      if(drawableDirs!=null){
        for(File dir:drawableDirs){
          String parentPath = dir.getAbsolutePath();
          String[] files = dir.list();
          for(String file:files){
            Log.e("Smartassets","drawable ===> "+"file://"+parentPath+File.separator+file);
            fileMaps.pushString("file://"+parentPath+File.separator+file);
          }
        }
        callback.invoke(fileMaps);
      }
    }
  }


  @Override
  public Map<String, Object> getConstants() {
    return CONSTANTS;
  }
}