<!--
 * @FileDescription 标语组件
 * @Author livre
 * @Date 2020年2月4日
 * @LastEditTime 2020年7月31日
 -->
<template>
  <div>
    <el-card class="box-card">
      <div style="font-size: 45px;color: azure;white-space: nowrap">Talk is cheap. Show me the code.</div>
      <!--   github图片超链接   -->
      <a href="https://github.com/" target="_blank">
        <img src="../../assets/img/icon/icon6.png" alt="" class="git-link">
      </a>
      <!--   csdn图片超链接   -->
      <a href="https://blog.csdn.net/" target="_blank">
        <img src="../../assets/img/icon/csdn.png" alt="" class="csdn-link">
      </a>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Slogan'
}
</script>

<style scoped>
  .box-card {
    width: 100%;
    height: 150px;
    background-color: #222;
    text-align: center;
    margin-top: 5px;
  }

  .slogan {
    width: 100%;
  }

  .git-link {
    width: 80px;
    /*position: absolute;*/
  }

  .csdn-link {
    width: 65px;
    /*position: absolute;*/
    margin-bottom: 7px;
    margin-left: 20px;
  }
</style>
