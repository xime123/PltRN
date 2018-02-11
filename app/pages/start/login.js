import React, {Component} from 'react';
import{
    Text,
    View,
    TouchableOpacity,
    Animated,
    Image,
    StatusBar,
    BackHandler,
    Keyboard,
    Alert,
    DeviceEventEmitter
}from'react-native';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import styles, {screenHeight, screenWidth} from "../../style";
import * as Constant from "../../style/constant";
import loginActions from '../../store/actions/login'
import PropTypes from 'prop-types';
import I18n from '../../style/i18n';
import Modal from 'react-native-modalbox';

import Icon from 'react-native-vector-icons/FontAwesome'
import IconC from 'react-native-vector-icons/Entypo'
import {Fumi} from 'react-native-textinput-effects';
import {Actions} from 'react-native-router-flux';
import ToastUtil from '../../util/ToastUtil';
const animaTime = 600;
class LoginPage extends Component{
    constructor(props) {
        super(props);
        this.onClose = this.onClose.bind(this);
        this.userInputChange = this.userInputChange.bind(this);
        this.passwordChange = this.passwordChange.bind(this);
        this.toLogin = this.toLogin.bind(this);
        this.startActivity=this.startActivity.bind(this);
        this.params = {
            userName: '',
            password: ''
        };
        this.state = {
            userName: '',
            password: '',
            secureTextEntry: true,
            secureIcon: "eye-with-line",
            opacity: new Animated.Value(0),
            userInfo:null
        }
    }

   

    componentWillUnmount() {
        
        if (this.handle) {
            this.handle.remove();
        }


    }


    componentDidMount(){

        console.log('componentDidMount======>');

        this.handle = BackHandler.addEventListener('hardwareBackPress-LoginPage', this.onClose)
        Animated.timing(this.state.opacity,{
            duration:animaTime,
            toValue:1
        }).start();
      }

    onClose() {
        if (Actions.state.index === 0) {
            return false;
        }
        Animated.timing(this.state.opacity, {
            duration: animaTime,
            toValue: 0,
        }).start(Actions.pop());
        return true;

    }

    userInputChange(text) {
        this.params.userName = text;
    }

    passwordChange(text) {
        this.params.password = text;
    }

    startActivity(){
        var {NativeModules}=require('react-native');
        let RNNativeRooter=NativeModules.RNNativeRooter;
        var RooterAction={
            targetComponent:'com.juappfromwork.TestActivity',
            orginComponent:'LoginPage',
            rooterType:1,
            props:'我是来自RN的数据'
        };
        RNNativeRooter.pushComponent(JSON.stringify(RooterAction));
    }

    toLogin() {
        let {login} = this.props;
        if (!this.params.userName || this.params.userName.length === 0) {
            Alert.alert(I18n('LoginNameTip'));
      
            return
        }
        if (!this.params.password || this.params.password.length === 0) {
            Alert.alert(I18n('LoginPWTip'));
            return
        }
        this.setState({
            userName: this.params.userName,
            password: this.params.password
        });
        Actions.LoadingModal({backExit: false});
        Keyboard.dismiss();
   
        login.doLogin(this.params.userName, this.params.password,(res)=>{
            this.exitLoading();
            if(!res){
                Alert.alert('登录失败');
            }else{
                if(res.errorCode===0){
                    Actions.reset("mainTabPage");
                }else{
                    ToastUtil.showLong(res.errorMsg);
                }
            
            }
        });
    
    }

    userInputChange(text) {
        this.params.userName = text;
    }

    passwordChange(text) {
        this.params.password = text;
    }

    exitLoading() {
        if (Actions.currentScene === 'LoadingModal') {
            Actions.pop();
        }
    }

    render() {
        let textInputProps = {
            style: {width: 250, height: 70, backgroundColor: Constant.miWhite},
            activeColor: Constant.primaryColor,
            passiveColor: '#dadada',
            iconClass: Icon,
            iconColor: Constant.primaryColor,
            iconSize: 25,
            clearButtonMode: "always"
        };
        return (
            <Animated.View
                style={[styles.centered, styles.absoluteFull, {backgroundColor: Constant.primaryColor}, {opacity: this.state.opacity}]}>
                <StatusBar hidden={false} backgroundColor={Constant.primaryColor} translucent
                           barStyle={'light-content'}/>
                <View
                    style={[{backgroundColor: Constant.miWhite}, {
                        height: 360,
                        width: screenWidth - 80,
                        margin: 50,
                        borderRadius: 10
                    }]}
                    onClosed={this.onClose}
                    onOpened={this.onOpen}>
                    <View style={[styles.centered, {marginTop: Constant.normalMarginEdge}]}>
                        <Image source={require("../../img/logo.png")}
                               resizeMode={"contain"}
                               style={{width: 80, height: 80}}/>
                    </View>
                    <View style={[styles.centered, {marginTop: Constant.normalMarginEdge}]}>
                        <Fumi
                            ref={"userNameInput"}
                            {...textInputProps}
                            label={I18n('UserName')}
                            iconName={'user-circle-o'}
                            value={this.state.userName}
                            onChangeText={this.userInputChange}
                        />
                    </View>
                    <View style={[styles.centered, {marginTop: Constant.normalMarginEdge}]}>
                        <Fumi
                            ref={"passwordInput"}
                            {...textInputProps}
                            label={I18n('Password')}
                            returnKeyType={'send'}
                            secureTextEntry={this.state.secureTextEntry}
                            password={this.state.secureTextEntry}
                            iconName={'keyboard-o'}
                            value={this.state.password}
                            onChangeText={this.passwordChange}
                        />
                        <View style={[{
                            position: "absolute",
                            left: screenWidth - 150,
                            right: 2 * Constant.normalMarginEdge,
                            zIndex: 12,
                        }, styles.alignItemsEnd]}>
                            <TouchableOpacity style={[styles.centered, {
                                marginTop: Constant.normalMarginEdge,
                                padding: Constant.normalMarginEdge
                            }]}
                                              onPress={() => {
                                                  this.setState({
                                                      secureIcon: (this.state.secureTextEntry) ? "eye" : "eye-with-line",
                                                      secureTextEntry: !this.state.secureTextEntry,
                                                  });
                                              }}>
                                <IconC name={this.state.secureIcon}
                                       backgroundColor={Constant.transparentColor}
                                       color={Constant.primaryColor} size={13}
                                       style={styles.centered}/>
                            </TouchableOpacity>
                        </View>
                    </View>
                    <View>
                    </View>
                    <TouchableOpacity style={[styles.centered, {marginTop: Constant.normalMarginEdge}]}
                                      onPress={() => {
                                          this.toLogin();
                                      }}>
                        <View
                            style={[styles.centered, {
                                backgroundColor: Constant.primaryColor,
                                width: 230,
                                marginTop: Constant.normalMarginEdge,
                                paddingHorizontal: Constant.normalMarginEdge,
                                paddingVertical: Constant.normalMarginEdge,
                                borderRadius: 5
                            }]}>
                            <Text style={[styles.normalTextWhite]}>{I18n('Login')}</Text>
                        </View>
                    </TouchableOpacity>
                    <TouchableOpacity style={[styles.centered, {marginTop: Constant.normalMarginEdge}]}
                                      onPress={() => {
                                        //   Linking.openURL("https://github.com/join")
                                        this.startActivity();
                                      }}>
                        <Text
                            style={[styles.subSmallText,]}>{" " + I18n('register') + " "}</Text>
                    </TouchableOpacity>
                </View>
            </Animated.View>
        )
    }

}

export default connect(state => ({state}), dispatch => ({
    login: bindActionCreators(loginActions, dispatch)
})
)(LoginPage)