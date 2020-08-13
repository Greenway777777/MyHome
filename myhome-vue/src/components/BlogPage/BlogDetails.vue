<!--
 * @FileDescription 博客详情组件
 * @Author livre
 -->
<template>
  <div class="blogs-area">
    <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
      <div>
        <!-- 通过blog获取博客信息渲染页面 -->
        <span style="font-size: 20px"><strong>{{blog.blogTitle}}</strong></span>
        <el-divider content-position="left">{{blog.blogDate}}</el-divider>
        <div class="markdown-body">
          <div v-html="blog.blogContentHtml"></div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'BlogDetails',
  data () {
    return {
      /**
       * @description 保存完整的博客信息
       */
      blog: []
    }
  },
  mounted () {
    /**
     * @description 钩子函数执行loadBlog()方法
     */
    this.loadBlog()
  },
  methods: {
    /**
     * @description 加载当前博客id的完整信息
     * @return 返回数据到this.blog中
     */
    loadBlog () {
      var _this = this
      this.$axios.get('/blog/' + this.$route.query.id).then(resp => {
        if (resp && resp.data.code === 200) {
          _this.blog = resp.data.result
        }
      })
    }
  }
}
</script>

<style scoped>
  @import "../../styles/markdown.css";
</style>
