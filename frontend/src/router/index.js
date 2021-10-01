import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import Dice from '@/components/Dice'
import Parcheesi from '@/components/Parcheesi'
import Login from '@/views/Login'


Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/dice',
      component: Dice
    },
    {
      path: "/parcheesi",
      name: "parcheesi",
      component: Parcheesi
    },
    {
      path: "/login",
      name: "login",
      component: Login
    }
  ]
})
