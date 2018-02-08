/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from "react";

//注意：原生plt导出模块名应为NativeModules
import { NativeEventEmitter } from "react-native";

//原生JUPltEventEmitter模块
var tmpEventEmitter = NativeModules.JUPltEventEmitter;
const JUPlt_eventMitter = new NativeEventEmitter(tmpEventEmitter);

//ice连接状态变化通知
const kEventNameNetworkStatusChange = JUPlt_eventMitter.kEventNameNetworkStatusChange;
//用户强制下线通知
const kEventNameUseForceOffline = JUPlt_eventMitter.kEventNameUseForceOffline;
//用户收到推送
const kEventNameUseReveiveNotify = JUPlt_eventMitter.kEventNameUseReveiveNotify;

/*
访问原生PltAPI
*/
export default class JUPltEventEmitter {

  //ice连接状态变化通知
  static AddNetworkStatusChangeListener(callback){
    return JUPlt_eventMitter.addListener(
      kEventNameNetworkStatusChange,callback(data)
    );
  }

  //用户强制下线通知
  static AddUseForceOfflineListener(){
    return JUPlt_eventMitter.addListener(
      kEventNameUseForceOffline,callback(data)
    );
  }

  //用户收到推送
  static AddUseReveiveNotifyListener(){
    return JUPlt_eventMitter.addListener(
      kEventNameUseReveiveNotify,callback(data)
    );
  }

}
