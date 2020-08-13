<!--
 * @FileDescription 主页界面,通过components导入各种小组件拼接
 * @Author livre
 * @Date 2020年2月4日
 * @LastEditTime 2020年7月31日
 -->
<template>
  <body id="poster">
  <div style="margin-top: 40px">
    <!--  SideMenu 侧边导航菜单组件  -->
<!--    <side-menu id="side-menu"></side-menu>-->
    <div class="home">
      <div id="header-div">
        <div style="height: 150px"></div>
        <!--  Carousel 循环轮播卡片组件  -->
        <carousel></carousel>
        <!--  QuickNav 快速导航组件  -->
        <quick-nav style="float: right;margin-top: -450px;margin-right: 480px"></quick-nav>
      </div>
<!--      <im-tall id="im" v-on:click="tall"></im-tall>-->
      <!--  WebTrans 资源网站跳转组件  -->
      <web-trans id="update-card"></web-trans>
      <!--   Slogan 标语组件   -->
      <slogan id="slogan"></slogan>
      <!-- About底部信息栏组件 -->
      <about id="about"></about>
    </div>
  </div>
  </body>
</template>

<script>
import Carousel from './Carousel'
import QuickNav from './QuickNav'
import Slogan from './Slogan'
import About from '../common/About'
import WebTrans from './WebTrans'
import SideMenu from './SideMenu'
export default {
  inject: ['reload'],
  name: 'AppIndex',
  components: {// 轮播卡片，快速导航，标语，关于，跳转网站表，侧边导航;使用标签时大小写不敏感，驼峰命名的改为用-连接
    Carousel,
    QuickNav,
    Slogan,
    About,
    WebTrans,
    SideMenu,
    'ImTall': {
      render (createElement) {
        return createElement(
          'script',
          {
            attrs: {
              type: 'text/javascript',
              src: 'https://sidecar.gitter.im/dist/sidecar.v1.js'
            }
          }
        )
      }
    }
  },
  mounted () {
    // this.DDDD()
    // window.location.href = 'http://localhost:8080/index'
    // this.funA()
  },
  methods: {
    // DDDD () {
    //   setTimeout(function () {
    //     alert('123')
    //     location.reload()
    //   }, 3000)
    // },
    funA () {
      if (this.$route.query.pi) {
        location.href = '/index'
      }
    }
  }
}
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;
  }

  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
  }

  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: -680px;
    top: 100px;
  }
  #poster {
    background:url("../../../static/img/bg1.png") no-repeat;
    background-position: center;
    background-size: cover;
    overflow: scroll
  }
</style>
