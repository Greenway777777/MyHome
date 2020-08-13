<!--
 * @FileDescription 快速导航组件
 * @Author livre
 * @Date 2020年2月4日
 * @LastEditTime 2020年7月31日
 -->
<template>
    <div class="quick-nav">
      <img src="../../assets/img/icon/welc.png" alt="" class="wel">
      <!--  图片超链接  新建窗口跳转到项目github地址  -->
      <a href="https://github.com/Greenway777777" target="_blank">
        <img src="../../assets/img/icon/icon5.png" alt="" class="readme">
      </a>
    </div>
</template>

<script>
export default {
  name: 'QuickNav'
}
</script>

<style scoped>
  .quick-nav {
    width: 303px;
    height: 318px;
    background-color: transparent;
  }

  .wel {
    width: 600px;
    height: 100px;
    /*position: absolute;*/
    /*top: 150px;*/
    /*left: 700px;*/
  }

  .readme {
    width: 250px;
    height: 280px;
    position: absolute;
    margin-left: 50%;
    top: 210px;
    left: 230px;
  }

  .spark {
    position: absolute;
    margin-left: 50%;
    top: 100px;
    left: 20px;
  }

  .logo {
    width: 280px;
    position: absolute;
    margin-left: 50%;
    top: 50px;
    left: 210px;
  }

</style>
