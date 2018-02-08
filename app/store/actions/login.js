import {LOGIN} from './actiontype'
import JUPltRN from'../../plt/JUPltRN'
import * as Constant from '../../style/constant'
const toLogin = () => async (dispatch, getState) => {

};


/**
 * 登陆请求
 */
const doLogin = (userName, password, callback) => async (dispatch, getState) => {
    
    //记住账号密码
    // AsyncStorage.setItem(Constant.USER_NAME_KEY, userName);
    // AsyncStorage.setItem(Constant.USER_BASIC_CODE, password);
    
    let res = await JUPltRN.userLogin('mobile',userName,password);
    if (res && res.errorCode===0) {
        dispatch({
            type: LOGIN.IN,
            res
        });
    }
    setTimeout(() => {
        callback && callback(res);
    }, 1000)
};

/**
 * 退出登录
 */
const loginOut = () => async (dispatch, getState) => {

};

/**
 * 获取当前登录用户的参数
 */
const getLoginParams = async () => {
    let userName = await AsyncStorage.getItem(Constant.USER_NAME_KEY);
    let password = await AsyncStorage.getItem(Constant.PW_KEY);
    return {
        userName: (userName) ? userName : "",
        password: (password) ? password : "",
    }
};

export default {
    toLogin,
    doLogin,
    getLoginParams,
    loginOut

}