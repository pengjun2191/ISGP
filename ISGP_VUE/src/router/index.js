import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Login from '@/components/Login'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/change_pw',
      name: 'ChangePw',
      component: () => ('../components/ChangePw')
    },
    {
      path: '/forget_pw',
      name: 'ForgetPw',
      component: () => ('../components/ForgetPw')
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    }
  ]
})
