<!--
 * @FileDescription 导航菜单组件容器
 * @Author livre
 * @Date 2020年2月5日
 * @LastEditTime 2020年7月31日
 -->
<template>
  <!--开启router 会以index作为path进行路由跳转-->
  <div>
  <el-menu
    :default-active="'/index'"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="green"
    style="min-width: 1300px">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
    <i class="el-icon-switch-button" v-on:click="logout" style="float:right;font-size: 40px;color: #222;padding: 10px"></i>
<!--    <a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>-->
<!--    <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>-->
    <span style="position: absolute;padding-top: 20px;right: 40%;font-size: 30px;font-weight: bold">Livre's Personal Home Page</span>
  </el-menu>
  </div>
</template>

<script>
export default {
  name: 'NavMenu',
  data () {
    return {
      /**
       * @description 导航菜单信息
       */
      navList: [
        {name: '/index', navItem: '首页'},
        {name: '/blogPage', navItem: '博客'},
        // {name: '/bank', navItem: '题库'},
        // {name: '/chat', navItem: '聊天室'},
        {name: '/admin', navItem: '管理中心'}
      ]
    }
  },
  methods: {
    /**
     * @description 退出登录按钮点击方法.通过axios发送get请求,url为'/logout'
     * @return 接收到成功状态码200,触发$store的logout方法清除保存在本地的登录信息
     */
    logout () {
      var _this = this
      this.$axios.get('/logout').then(resp => {
        if (resp.data.code === 200) {
          // 前后端状态保持一致
          _this.$store.commit('logout')
          _this.$router.replace('/login')
        }
      })
    }
  }
}
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
  .el-icon-switch-button {
    cursor: pointer;
    outline:0;
  }
</style>
