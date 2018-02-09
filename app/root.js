import React, {Component}from 'react';

import { Provider } from 'react-redux';
import {changeLocale} from './style/i18n'
import store from './store'
import getRouter from '../app/rooter';
import {DeviceEventEmitter}from'react-native';
import { Actions } from 'react-native-router-flux';


export default class Root extends Component<{}> {

  constructor() {
      super();
      this.state = {
          store: store,
      };
    
      changeLocale('local');
  }




  componentDidMount(){
               //注册路由监听
               DeviceEventEmitter.addListener('ROOTER_RN',(rooterActionJson)=>{
                console.log('ROOTER_RN======>');
                if(rooterActionJson){
        
                    var rooterAction=JSON.parse(rooterActionJson);
                    console.log('start Actions.push======>'+rooterAction.targetComponent);
                   
                    Actions.push(rooterAction.targetComponent);
                    console.log('end Actions.push======>'+rooterAction.targetComponent);
                    
                }
            });
  }


  componentWillUnmount(){
    console.log('componentWillUnmount======>');
    DeviceEventEmitter.removeListener('ROOTER_RN');
  }

  render() {
      return (
        <Provider store={store}>
           {getRouter()}
        </Provider>
      );
  }
}