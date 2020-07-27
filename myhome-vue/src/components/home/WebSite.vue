<template>
  <div class="block">
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
      list: [{
        id: 1,
        name: '百度',
        url: 'https://www.baidu.com/',
        icon: '去看看'
      }]
    }
  },
  mounted: function () {
    this.loadWebsite()
  },
  methods: {
    loadWebsite () {
      var _this = this
      this.$axios.get('/websites').then(resp => {
        _this.list = resp.data
      })
    },
    gotolock (index) {
      window.open(this.list[index].url)
    }
  }
}
</script>

<style scoped>

</style>
