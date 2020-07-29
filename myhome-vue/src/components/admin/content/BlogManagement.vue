<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>内容管理</el-breadcrumb-item>
        <el-breadcrumb-item>博客管理</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-link href="/admin/content/editor" :underline="false" target="_blank" class="add-link">
      <el-button type="success">写博客</el-button>
    </el-link>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="blogs"
        stripe
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline>
              <el-form-item>
                <span>{{ props.row.blogAbstract }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          prop="blogTitle"
          label="题目（展开查看摘要）"
          fit>
        </el-table-column>
        <el-table-column
          prop="blogDate"
          label="发布日期"
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="180">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="viewBlog(scope.row.id)"
              type="text"
              size="small">
              查看
            </el-button>
            <el-button
              @click.native.prevent="editBlog(scope.row)"
              type="text"
              size="small">
              编辑
            </el-button>
            <el-button
              @click.native.prevent="deleteBlog(scope.row.id)"
              type="text"
              size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 50px 0">
        <el-pagination
          background
          style="float:right;"
          layout="total, prev, pager, next, jumper"
          @current-change="handleCurrentChange"
          :page-size="pageSize"
          :total="total">
        </el-pagination>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'BlogManagement',
  data () {
    return {
      blogs: [],
      pageSize: 10,
      total: 0
    }
  },
  mounted () {
    this.loadBlogs()
  },
  computed: {
    tableHeight () {
      return window.innerHeight - 320
    }
  },
  methods: {
    loadBlogs () {
      var _this = this
      this.$axios.get('/blog/' + this.pageSize + '/1').then(resp => {
        if (resp && resp.data.code === 200) {
          _this.blogs = resp.data.result.content
          _this.total = resp.data.result.totalElements
        }
      })
    },
    handleCurrentChange (page) {
      var _this = this
      this.$axios.get('/blog/' + this.pageSize + '/' + page).then(resp => {
        if (resp && resp.data.code === 200) {
          _this.blogs = resp.data.result.content
          _this.total = resp.data.result.totalElements
        }
      })
    },
    viewBlog (id) {
      let blogUrl = this.$router.resolve(
        {
          path: '../../blogPage/blog',
          query: {
            id: id
          }
        }
      )
      window.open(blogUrl.href, '_blank')
    },
    editBlog (blog) {
      this.$router.push(
        {
          name: 'Editor',
          params: {
            blog: blog
          }
        }
      )
    },
    deleteBlog (id) {
      this.$confirm('此操作将永久删除该文章, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios
          .delete('/admin/content/blog/' + id).then(resp => {
            if (resp && resp.data.code === 200) {
              this.loadBlogs()
            }
          })
      }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>

<style scoped>
  .add-link {
    margin: 18px 0 15px 10px;
    float: left;
  }
</style>
