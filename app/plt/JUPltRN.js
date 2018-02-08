/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from "react";

//注意：原生plt导出模块名应为NativeModules
import { NativeModules, NativeEventEmitter } from "react-native";

//原生JUPltModule模块
var JUPlt_module = NativeModules.JUPltModule;

//业务请求基类
export class ProxyRequest {
  //业务码
  cd;
  //数据载体
  data;
  //用户ID
  userID;
  //用户token
  token;
}

/*
访问原生PltAPI
*/
export default class JUPltRN {
  /*
  用户登录
  type: 登录类型 int 0:email 1:phone
  mobile: 手机号码 String
  password: 密码原文 String
  ip: ip地址 String
  version: 系统版本号 String
  返回：Promise 对象
  */
  static userLogin(type, mobile, password, ip, version) {
    var LoginData={
      type:type,
      mobile:mobile,
      password:password,
      ip:ip,
      version:version
  }
  return new Promise(
    function(resolve,reject){
      JUPlt_module.userLogin((JSON.stringify(LoginData))).then(
        (loginRespJson)=>{
          var LoginResp=JSON.parse(loginRespJson);
          if(!LoginResp){
            resolve('登录失败');
          }else{
           // let errorMsg=LoginResp.errorMsg;
            resolve(LoginResp);
          }
        }
      );
    }
  );



  }

  /*
用户登出
userID：用户ID
token：用户token
返回：Promise 对象
*/
  static userLogout(userID, token) {
    return JUPlt_module.userLogout(userID, token);
  }

  /**
   * 用户注册
   * mobile:手机号码
   * vailCode：手机号短信验证码
   */
  static userRegister(cd,mobile,vailCode){
    var request=new ProxyRequest();
    request.cd=cd;
    var Data={
      mobile:mobile,
      vailCode:vailCode
    }
    request.data=JSON.stringify(Data);
    return JUPlt_module.proxyInvokeWithInvokeReq(request);
  }

  /**
   * 获取手机短信验证码
   * cd:业务码
   * @param {*手机号/手机号} address 
   * type:验证码类型
   * mode: 发送方式  mobile:手机号码   email:邮箱
   * userId:用户id
   * token:用户token
   */
  static getValiCode(cd,address,type,mode,userId,token){
    var request=new ProxyRequest();
    request.cd=cd;
    request.token=token;
    request.userID=userId;
    var Data={
      address:address,
      type:type,
      mode:mode
    }
    request.data=JSON.stringify(Data);
    return JUPlt_module.proxyInvokeWithInvokeReq(request);
  }

  /**
   * 修改用户密码
   * @param {*业务码} cd 
   * @param {*用户Id} userId 
   * @param {*用户token} token 
   * @param {*用户手机号} mobile 
   * @param {*旧密码} oldPwd 
   * @param {*新密码} newPwd 
   */
  static changePassword(cd,userId,token,mobile,oldPwd,newPwd){
    var request=new ProxyRequest();
    request.cd=cd;
    request.token=token;
    request.userID=userId;
    var Data={
      mobile:mobile,
      oldPwd:oldPwd,
      newPwd:newPwd
    }
    request.data=JSON.stringify(Data);
    return JUPlt_module.proxyInvokeWithInvokeReq(request);
  }

  /*
  业务访问代理
  request:ProxyRequest实例
  返回：Promise 对象
  */
  static proxyInvokeWithInvokeReq(request) {
    return JUPlt_module.proxyInvokeWithInvokeReq(request);
    /*
    var promise = new Promise(function(resolve, reject) {
      if (true) {
        resolve(value);
      } else {
        reject(error);
      }
    });

    JUPlt_module.proxyInvokeWithInvokeReq(request)
      .then(result => {
        console.log("result is ", result);
      })
      .catch(error => {
        console.log(error);
      });
  }
  */
  }

  /*
小文件上传
返回：Promise 对象
*/
  static smalFileUpload(data) {
    return JUPlt_module.smalFileUpload(data);
  }

  /*
小文件下载 promise方式调用
返回：Promise 对象
*/
  static smalFileDownload() {
    return JUPlt_module.smalFileDownload();
  }
}
