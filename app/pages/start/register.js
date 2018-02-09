import React, { Component } from 'react';
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
}from'react-native';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import styles, {screenHeight, screenWidth} from "../../style";
import * as Constant from "../../style/constant";
import loginActions from '../../store/actions/login';
import PropTypes from 'prop-types';
import I18n from '../../style/i18n';
import Modal from 'react-native-modalbox';

import Icon from 'react-native-vector-icons/FontAwesome'
import IconC from 'react-native-vector-icons/Entypo';
import {Fumi} from 'react-native-textinput-effects';
import {Actions} from 'react-native-router-flux';
import ToastUtil from '../../util/ToastUtil';
export default class Register extends Component{
  
    constructor(props) {
        super(props);
        this.startActivity = this.startActivity.bind(this);
    }
 
    startActivity(){
        var {NativeModules}=require('react-native');
        let RNNativeRooter=NativeModules.RNNativeRooter;
        var RooterAction={
            targetComponent:'com.juappfromwork.TestTwoActivity',
            orginComponent:'Register',
            rooterType:1,
            props:'我是来自RN的数据'
        };
        RNNativeRooter.pushComponent(JSON.stringify(RooterAction));
    }
    
    render(){
        return <View style={[{backgroundColor: Constant.miWhite}, {
            height: 360,
            width: screenWidth - 80,
            margin: 50,
            borderRadius: 10
        }]}>
            <Text onPress={()=>{
                this.startActivity();
            }}>
            注册页面
            </Text>
        
        </View>;
    }
}
