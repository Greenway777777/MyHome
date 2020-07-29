<template>
  <div class="blogs-area">
    <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
      <div>
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
      blog: []
    }
  },
  mounted () {
    this.loadBlog()
  },
  methods: {
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
