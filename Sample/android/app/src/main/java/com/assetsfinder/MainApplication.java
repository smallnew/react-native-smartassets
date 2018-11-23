package com.assetsfinder;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.smallnew.smartassets.RNSmartassetsPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return false;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new RNSmartassetsPackage()
      );
    }
//
//    @Override
//    protected String getJSMainModuleName() {
//      return "index";
//    }

    @Override
    protected String getBundleAssetName() {
      return "index.android.bundle";
    }

    @Override
    protected String getJSBundleFile() {
      File fileDir = getApplication().getFilesDir();
      String rnBundlePath = fileDir.getAbsolutePath()+File.separator+File.separator+"index.android.bundle";
      File bundleFile = new File(rnBundlePath);
      if(bundleFile.exists()){
        Log.i("FileUtil","use file js bundle");
        return bundleFile.getAbsolutePath();
      }
      return super.getJSBundleFile();
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    FileUtils.copyAssetFile(this,"","",true);
  }
}
