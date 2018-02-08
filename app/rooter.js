/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {StackNavigator,TabNavigator} from'react-navigation';
import {
  Platform,
  StyleSheet,
  Text,
  View
} from 'react-native';

import {
  Scene,
  Router,
  Lightbox, Drawer
} from 'react-native-router-flux';

import { 
  DrawerNavigator ,
  DrawerItems ,
  } from 'react-navigation';
import TabIcon from './components/widget/TabIcon'
import I18n, {changeLocale} from './style/i18n'
import MainContainer from './containers/MainContainer';
import CategaryContainer from './containers/CategaryContainer';
import MineContainer from './containers/MineContainer';
import LoginPage from './pages/start/login';
import Register from './pages/start/Register';
import BackUtils from './util/backUtils'
import * as Constant from './style/constant'
import {screenWidth, drawerWidth} from "./style/index";
import WelcomePage from './pages/start/WelcomePage';
import styles from './style'

/**
 * 全局路由
 */
const getRouter = () => {
  return (
      <Router
          getSceneStyle={() => {
              return styles.routerStyle
          }}
          backAndroidHandler={
              BackUtils()}>
          <Lightbox>
              <Scene key="root"
                     navigationBarStyle={styles.navigationBar}
                     titleStyle={{color: Constant.titleTextColor}}>
                  <Scene key="main">
                      <Scene key="WelcomePage" component={WelcomePage} hideNavBar hideTabBar hide/>
                  </Scene>
                  <Scene key="mainTabPage"
                         tabs
                         lazy
                         wrap={false}
                         showLabel={false}
                         tabBarPosition={"bottom"}
                         title={I18n('appName')}
                        //  renderRightButton={
                        //      () => <SearchButton/>
                        //  }
                         tabBarStyle={{
                             height: Constant.tabBarHeight,
                             alignItems: 'center',
                             justifyContent: 'center',
                             backgroundColor: Constant.tabBackgroundColor
                         }}>
                      <Scene
                          key="DynamicPage"
                          component={MainContainer}
                          icon={TabIcon}
                          title={I18n('market')}
                          tabIconName={'tabDynamic'}
                      />
                      <Scene
                          key="TrendPage"
                          component={CategaryContainer}
                          icon={TabIcon}
                          title={I18n('transaction')}
                          tabIconName={'tabRecommended'}
                      />
                      <Scene
                          key="MyPage"
                          component={MineContainer}
                          icon={TabIcon}
                          title={I18n('tabMy')}
                          tabIconName={'tabMy'}
                      />
                  </Scene>
                  <Scene key="LoginPage" component={LoginPage}
                         showLabel={false}
                         hideNavBar/>
                  <Scene key="Register" component={Register}
                         showLabel={false}
                         hideNavBar/>
                         
              </Scene>
            
          </Lightbox>
      </Router>
  )
};


export default getRouter;


