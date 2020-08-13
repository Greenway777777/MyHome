// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui' // 完整引入Element-ui设计界面  可以优化为按需引入
import 'element-ui/lib/theme-chalk/index.css'
import store from './store' // 引入store 管理状态变量
import mavonEditor from 'mavon-editor' // 引入mavon-editor MarkDown编辑器
import 'mavon-editor/dist/css/index.css'
import 'echarts/theme/macarons.js' // 引入echarts

var axios = require('axios') // 使用axios模块

// 设置反向代理，前端请求默认发送到 http://localhost:8443/api   120.78.7.187:8848
axios.defaults.baseURL = 'http://120.78.7.187:8848/api'

// 发送请求带上sessionID 用于Shiro验证登录状态 使请求带上凭证信息
axios.defaults.withCredentials = true

// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.use(mavonEditor)

// 每个路由访问前触发调用
router.beforeEach((to, from, next) => {
  if (store.state.username && to.path.startsWith('/admin')) {
    initAdminMenu(router, store)
  }
  // 已登录状态下访问 login 页面直接跳转到后台首页
  // if (store.state.username && to.path.startsWith('/login')) {
  //   next({
  //     // path: 'admin/dashboard'
  //     name: 'Login'
  //   })
  // }
  if (from.path.startsWith('/login')) {
  }
  // 如果前端没有登录信息则直接拦截，如果有则判断后端是否正常登录（防止构造参数绕过）
  if (to.meta.requireAuth) {
    if (store.state.username) {
      axios.get('/authentication').then(resp => {
        if (resp) next()
      })
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)

// http response 拦截器
axios.interceptors.response.use(
  response => {
    return response
  },
  error => {
    if (error) {
      store.commit('logout')
      router.replace('/login')
    }
    // 返回接口返回的错误信息
    return Promise.reject(error)
  })

// 初始化后台菜单
const initAdminMenu = (router, store) => {
  // 防止重复触发加载菜单操作
  if (store.state.adminMenus.length > 0) {
    return
  }
  axios.get('/menu').then(resp => {
    if (resp && resp.status === 200) {
      var fmtRoutes = formatRoutes(resp.data.result)
      router.addRoutes(fmtRoutes)
      store.commit('initAdminMenu', fmtRoutes)
    }
  })
}

// 格式化返回的数据中的路由信息
const formatRoutes = (routes) => {
  let fmtRoutes = []
  routes.forEach(route => {
    if (route.children) {
      route.children = formatRoutes(route.children)
    }

    let fmtRoute = {
      path: route.path,
      component: resolve => {
        require(['./components/admin/' + route.component + '.vue'], resolve)
      },
      name: route.name,
      nameZh: route.nameZh,
      iconCls: route.iconCls,
      meta: {
        requireAuth: true
      },
      children: route.children
    }
    fmtRoutes.push(fmtRoute)
  })
  return fmtRoutes
}

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
