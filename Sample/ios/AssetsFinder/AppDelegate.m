/**
 * Copyright (c) 2015-present, Facebook, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

#import "AppDelegate.h"

#import <React/RCTBundleURLProvider.h>
#import <React/RCTRootView.h>

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  
  NSFileManager*fileManager =[NSFileManager defaultManager];
  NSError*error;
  NSArray*paths =NSSearchPathForDirectoriesInDomains(NSDocumentDirectory,NSUserDomainMask, YES);
  NSString*documentsDirectory =[paths objectAtIndex:0];
  
  NSString*destJsBundlePath =[documentsDirectory stringByAppendingPathComponent:@"main.bundle"];
  if([fileManager fileExistsAtPath:destJsBundlePath]== NO){
    NSString*resourcePath =[[NSBundle mainBundle] pathForResource:@"main" ofType:@"bundle"];
    [fileManager copyItemAtPath:resourcePath toPath:destJsBundlePath error:&error];
  }
  
  NSURL *jsCodeLocation;
  //jsCodeLocation = [[NSBundle mainBundle] URLForResource:@"main" withExtension:@"bundle"];
  jsCodeLocation = [NSURL URLWithString:destJsBundlePath];
  
  RCTRootView *rootView = [[RCTRootView alloc] initWithBundleURL:jsCodeLocation
                                                      moduleName:@"AssetsFinder"
                                               initialProperties:nil
                                                   launchOptions:launchOptions];
  rootView.backgroundColor = [[UIColor alloc] initWithRed:1.0f green:1.0f blue:1.0f alpha:1];

  self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
  UIViewController *rootViewController = [UIViewController new];
  rootViewController.view = rootView;
  self.window.rootViewController = rootViewController;
  [self.window makeKeyAndVisible];
  return YES;
}

@end
