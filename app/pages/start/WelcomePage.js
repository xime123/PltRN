/**
 * Created by guoshuyu on 2017/11/7.
 */

import React, {Component} from 'react';
import {
    View, Image, StatusBar, Platform
} from 'react-native';
import {Actions} from 'react-native-router-flux';
import styles, {screenHeight, screenWidth} from "../../style"
import I18n from '../../style/i18n'
import loginActions from '../../store/actions/login'
import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'
import * as Constant from "../../style/constant"


/**
 * 欢迎页
 */
class WelcomePage extends Component {

    constructor(props) {
        super(props);
        this.toNext = this.toNext.bind(this);
    }


    componentDidMount() {
        //是否登陆，是否用户信息
        // userActions.initUserInfo().then((res) => {
        //     this.toNext(res)
        // });
        this.toNext()
    }

    componentWillUnmount() {

    }

    toNext(res) {
        setTimeout(() => {
            // if (res && res.result) {
            //     Actions.reset("mainTabPage");
            // } else {
            //     Actions.reset("LoginPage");
            // }
            Actions.reset("LoginPage");
        }, 1000);
    }

    render() {
        return (
            <View style={[styles.mainBox, {backgroundColor: Constant.white}]}>
                <StatusBar hidden={true}/>
                <View style={[styles.centered, {flex: 1}]}>
                    <Image source={require("../../img/welcome.png")}
                           resizeMode={"contain"}
                           style={{width: screenWidth, height: screenHeight}}/>
                </View>
            </View>
        )
    }
}

export default connect(state => ({
    state
}), dispatch => ({
    actions: bindActionCreators(loginActions, dispatch),
}))(WelcomePage)
