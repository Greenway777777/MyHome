<!--
 * @FileDescription 博客组件
 * @Author livre
 -->
<template>
  <div style="margin-top: 40px">
    <!--<el-button @click="addBlog()">添加博客</el-button>-->
    <div class="blogs-area">
      <el-card style="text-align: left">
        <div v-for="blog in blogs" :key="blog.id">
          <div style="float:left;width:85%;height: 150px;">
            <router-link class="blog-link" :to="{path:'blogPage/blog',query:{id: blog.id}}"><span style="font-size: 20px"><strong>{{blog.blogTitle}}</strong></span></router-link>
            <el-divider content-position="left">{{blog.blogDate}}</el-divider>
            <router-link class="blog-link" :to="{path:'blogPage/blog',query:{id: blog.id}}"><p>{{blog.blogAbstract}}</p></router-link>
          </div>
          <el-image
            style="margin:18px 0 0 30px;width:100px;height: 100px"
            :src="blog.blogCover"
            fit="cover"></el-image>
          <el-divider></el-divider>
        </div>
      </el-card>
    </div>
    <el-pagination
      background
      layout="total, prev, pager, next, jumper"
      @current-change="handleCurrentChange"
      :page-size="pageSize"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>

export default {
  name: 'Blog',
  data () {
    return {
      /**
       * @description blogs绑定博客数据
       * */
      blogs: [],
      /**
       * @description pageSize页面大小
       */
      pageSize: 4,
      total: 0
    }
  },
  mounted () {
    /**
     * @description 钩子函数,执行this.loadBlogs()方法 加载博客信息
     */
    this.loadBlogs()
  },
  methods: {
    /**
     * @description 加载博客信息方法,通过axios的get方法发送请求
     * @return 返回数据到this.blogs中
     */
    loadBlogs () {
      var _this = this
      this.$axios.get('/blog/' + this.pageSize + '/1').then(resp => {
        if (resp && resp.data.code === 200) {
          _this.blogs = resp.data.result.content
          _this.total = resp.data.result.totalElements
        }
      })
    },
    /**
     * @description 登录按钮点击方法.通过axios发送post请求,url为'/login'
     * @params {String} loginForm
     * @return 返回数据到$store保存
     */
    handleCurrentChange (page) {
      var _this = this
      this.$axios.get('/blog/' + this.pageSize + '/' + page).then(resp => {
        if (resp && resp.data.code === 200) {
          _this.blogs = resp.data.result.content
          _this.total = resp.data.result.totalElements
        }
      })
    }
  }
}
</script>

<style scoped>
  .blogs-area {
    width: 990px;
    height: 750px;
    margin-left: auto;
    margin-right: auto;
  }

  .blog-link {
    text-decoration: none;
    color: #606266;
  }

  .blog-link:hover {
    color: #409EFF;
  }
</style>
