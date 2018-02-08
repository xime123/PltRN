import React, {Component}from 'react';

import { Provider } from 'react-redux';
import {changeLocale} from './style/i18n'
import store from './store'
import getRouter from '../app/rooter';



export default class Root extends Component<{}> {

  constructor() {
      super();
      this.state = {
          store: store,
      };
      changeLocale('local');
  }


  render() {
      return (
        <Provider store={store}>
           {getRouter()}
        </Provider>
      );
  }
}