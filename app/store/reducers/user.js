import {USER} from '../actions/actiontype';
import {createReducer} from '../'

const initialState = {
    //当前登录用户信息
    userInfo: {},
};

const actionHandler = {
    [USER.USER_INFO]: (state, action) => {
        return {
            ...state,
            userInfo: action.res
        }
    },
};

export default createReducer(initialState, actionHandler)