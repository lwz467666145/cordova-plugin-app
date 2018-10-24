#import <Cordova/CDVPlugin.h>

@interface App : CDVPlugin
    
- (void)openApp:(CDVInvokedUrlCommand*)command;
- (void)hasApp:(CDVInvokedUrlCommand*)command;
- (void)exitApp:(CDVInvokedUrlCommand*)command;
    
@end
