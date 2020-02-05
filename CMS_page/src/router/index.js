import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import usermanager from '@/views/usermanager.vue'
import articleManage from '@/views/articleManage.vue'
import rolemanager from '@/views/rolemanager.vue'
import skilltreemanage from '@/views/skilltreemanage.vue'
// 
import seomanage from '@/views/seomanage.vue'

import photomanage from '@/views/photomanage.vue'
// 
import menumanager from '@/views/menumanager.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'index',
    component: Home
  },
  {
    path: '/home',
    name: 'home',
    component: Home
  },
  {
    path: '/usermanager',
    name: 'usermanager',
    component: usermanager
  },
  {
    path: '/articleManage',
    name: 'articleManage',
    component: articleManage
  },{
    path: '/rolemanager',
    name: 'rolemanager',
    component: rolemanager
  },{
    path: '/skilltreemanage',
    name: 'skilltreemanage',
    component: skilltreemanage
  },{
    path: '/seomanage',
    name: 'seomanage',
    component: seomanage
  },{
    path: '/photomanage',
    name: 'photomanage',
    component: photomanage
  },{
    path: '/menumanager',
    name: 'menumanager',
    component: menumanager
  }
]

const router = new VueRouter({
  routes,
  linkActiveClass:'active',
  
})

export default router
