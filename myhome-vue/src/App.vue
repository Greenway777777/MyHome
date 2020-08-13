<!--
 * @FileDescription 单页面应用顶级父组件 <router-view>加载路由渲染
 * @Author livre
 * @Date 2020年2月4日
 * @LastEditTime 2020年2月8日
 -->
<template>
  <div id="app">
<!--    <img id="poster" src="./assets/img/icon/bg1.png">-->
    <router-view v-id="isRouterAlive"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
  #poster {
    background:url("../static/img/bg1.png") no-repeat;
    background-position: center;
    background-size: cover;
  }
</style>
