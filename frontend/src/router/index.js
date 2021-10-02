import Vue from 'vue'
import Router from 'vue-router'

import Dice from '@/components/Dice'
import Parcheesi from '@/components/Parcheesi'
import Login from '@/components/Login'
import ListGame from '@/components/ListGame'


Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: "login",
      component: Login
    }
    ,
    {
      path: '/game',
      name: "game",
      component: ListGame
    },
    {
      path: '/dice',
      component: Dice
    },
    {
      path: "/parcheesi",
      name: "parcheesi",
      component: Parcheesi
    }
  ]
})
