import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import BootstrapVue from 'bootstrap-vue'
import Toasted from 'vue-toasted'
import axios from 'axios'
import VueAxios from 'vue-axios'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/StartWithJEE8-web/api'
})

Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(Toasted, { duration: 2000 })
Vue.use(VueAxios, axiosInstance)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
