import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 创建store数据源，所有共享的数据都逃统一放到store的state中进行储存

const store = new Vuex.Store({


  
state: {
      userinfo:{}
  },
  mutations: {
      setUserinfo(state,info){
        state.userinfo=info;
      }
  },
  actions: {

  },
  modules: {

  }
  
});
export default store
