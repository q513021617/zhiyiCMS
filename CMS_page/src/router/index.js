import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import usermanager from '@/views/usermanager.vue'
import articleManage from '@/views/articleManage.vue'
import rolemanager from '@/views/rolemanager.vue'
import login from '@/views/login.vue'
import index from '@/views/index.vue'

import seomanage from '@/views/seomanage.vue'

import photomanage from '@/views/photomanage.vue'
// 
import menumanager from '@/views/menumanager.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/index',
    name: 'index',
    component: index,
    redict: '/index/home',
    children: [
      {
        path: 'home',
        name: 'home',
        component: Home,
      },
      {
        path: 'usermanager',
        name: 'usermanager',
        component: usermanager
      },
      {
        path: 'articleManage',
        name: 'articleManage',
        component: articleManage
      }, {
        path: 'rolemanager',
        name: 'rolemanager',
        component: rolemanager
      }, {
        path: 'seomanage',
        name: 'seomanage',
        component: seomanage
      }, {
        path: 'photomanage',
        name: 'photomanage',
        component: photomanage
      }, {
        path: 'menumanager',
        name: 'menumanager',
        component: menumanager
      }

    ]
  }

]

const router = new VueRouter({
  routes,
  linkActiveClass: 'active',

})

export default router
