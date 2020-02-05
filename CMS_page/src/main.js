import Vue from 'vue'
import App from './App.vue'
import router from './router'
import httpmethods from './tools/http'
import store from './store'
import cors from 'koa2-cors'


import 'admin-lte/dist/css/adminlte.min.css'
import 'admin-lte/dist/js/adminlte.min.js'
import 'admin-lte/plugins/fontawesome-free/css/all.min.css'
import 'admin-lte/plugins/chart.js/Chart.min.js'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  cors,

  httpmethods,
  render: h => h(App)
}).$mount('#app')
