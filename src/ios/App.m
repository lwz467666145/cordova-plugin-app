#import "App.h"
#import <Cordova/CDV.h>

@implementation App
    
- (void)openApp:(CDVInvokedUrlCommand *)command{
    NSString *scheme = command.arguments[0];
    NSURL *url = [NSURL URLWithString:[NSString stringWithFormat:@"%@://", scheme]];
    if ([[UIApplication sharedApplication] canOpenURL:url])
        [[UIApplication sharedApplication] openURL:url];
    else {
        CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Not Install"];
        [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
    }
}
    
- (void)hasApp:(CDVInvokedUrlCommand *)command{
    NSString *scheme = command.arguments[0];
    NSURL *url = [NSURL URLWithString:[NSString stringWithFormat:@"%@://", scheme]];
    BOOL flag = NO;
    if ([[UIApplication sharedApplication] canOpenURL:url])
        flag = YES;
    CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:flag];
    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}
    
@end
