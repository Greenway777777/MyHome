<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>内容管理</el-breadcrumb-item>
        <el-breadcrumb-item>资源管理</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <web-site-edit-form @onSubmit="loadWebSites()" ref="edit"></web-site-edit-form>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="websites"
        stripe
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="name"
          label="资源网站名称"
          fit>
        </el-table-column>
        <el-table-column
          prop="url"
          label="网址"
          fit>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="120">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="editWebSite(scope.row)"
              type="text"
              size="small">
              编辑
            </el-button>
            <el-button
              @click.native.prevent="deleteWebSite(scope.row)"
              type="text"
              size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 20px 0;float: left">
        <el-button>取消选择</el-button>
        <el-button>批量删除</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
import WebSiteEditForm from './WebSiteEditForm'
export default {
  name: 'WebSiteManagement',
  components: {WebSiteEditForm},
  data () {
    return {
      websites: []
    }
  },
  mounted () {
    this.loadWebSites()
  },
  computed: {
    tableHeight () {
      return window.innerHeight - 320
    }
  },
  methods: {
    deleteWebSite (item) {
      this.$confirm('此操作将永久删除该网址, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios
          .post('/admin/content/websites/delete', {
            id: item.id,
            name: item.name,
            url: item.url
          }
          ).then(resp => {
            if (resp && resp.data.code === 200) {
              this.loadWebSites()
            }
          })
      }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    editWebSite (item) {
      this.$refs.edit.dialogFormVisible = true
      this.$refs.edit.form = {
        id: item.id,
        name: item.name,
        url: item.url
      }
      // this.$refs.edit.category = {
      //   id: item.category.id.toString()
      // }
    },
    loadWebSites () {
      var _this = this
      this.$axios.get('/websites').then(resp => {
        if (resp && resp.data.code === 200) {
          _this.websites = resp.data.result
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
