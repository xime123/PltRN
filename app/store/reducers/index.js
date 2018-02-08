import {combineReducers} from 'redux';
import login from "./login"
import user from "./user"



export default combineReducers({
    login: login,
    user: user,
});

export function clear(state) {
    state().event.received_events_data_list = [];
    state().repository.trend_repos_data_list = [];
}