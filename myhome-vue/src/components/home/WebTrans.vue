<template>

  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">资源网站</span>
      <!--<el-button style="float: right; padding: 3px 0" type="text">修改</el-button>-->
    </div>
    <web-site></web-site>
  </el-card>
</template>

<script>
import WebSite from './WebSite'
export default {
  name: 'WebTrans',
  components: {WebSite}
}
</script>

<style scoped>
  .box-card {
    margin-top: 5px;
    width: 988px;
    height: 1050px;
    text-align: left;
  }
</style>
