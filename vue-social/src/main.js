import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

import * as firebase_key from './firebase'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

console.log(firebase_key)
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
