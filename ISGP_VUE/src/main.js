// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import router from './router'
// 设置反向代理，前端请求发送到http://localhost:9666/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:9665/ISGP'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
// axios.interceptors.request.use(config => {
//   config.headers.Authorization = window.sessionStorage.getItem('token')
//   // 固定写法return config
//   return config
// })
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(ElementUI)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  components: { App },
  template: '<App/>'
})
