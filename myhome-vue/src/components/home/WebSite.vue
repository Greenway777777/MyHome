<!--
 * @FileDescription 常用的资源网站跳转表格
 * @Author livre
 * @Date 2020年2月4日
 * @LastEditTime 2020年7月31日
 -->
<template>
  <div class="block">
    <!--  :data 绑定list数据 prop属性对应list的key-->
    <el-table
      :data="list"
      height="960"
      style="width: 100%">
      <el-table-column
        prop="name"
        label="网站"
        width="180">
      </el-table-column>
      <el-table-column
        prop="url"
        label="地址"
        width="180">
      </el-table-column>
      <el-table-column
        prop="icon"
        label="直通车">
        <template slot-scope="scope">
          <!-- 跳转按钮 点击事件绑定gotolock方法 参数为当前数据的下标-->
          <el-button
            size="mini"
            @click="gotolock(scope.$index)">去看看</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'WebSite',
  data () {
    return {
      /**
       * @description list 给表格提供数据 绑定钩子函数返回的数据
       */
      list: [{
        id: 1,
        name: '百度',
        url: 'https://www.baidu.com/',
        icon: '去看看'
      }]
    }
  },
  mounted: function () { // 匿名钩子函数 执行loadWebsite方法
    this.loadWebsite()
  },
  methods: {
    /**
     * @description 钩子函数绑定的loadWebsite方法.通过axios发送get请求,url为'/websites'
     * @return 返回数据给this.list
     */
    loadWebsite () {
      var _this = this
      this.$axios.get('/websites').then(resp => {
        if (resp && resp.status === 200) {
          _this.list = resp.data.result
        }
      })
    },
    /**
     * @description 表格按钮点击方法.通过window.open打开网页,url为list[index].url
     * @params {index} 当前下标
     * @return void
     */
    gotolock (index) {
      window.open(this.list[index].url)
    }
  }
}
</script>

<style scoped>

</style>
