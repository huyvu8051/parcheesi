import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import Dice from '@/components/Dice'
import Parcheesi from '@/components/Parcheesi'

Vue.use(Router)

export default new Router({
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
      component: Parcheesi
    }
  ]
})
