<template>
  <div style="text-align: left">
    <el-button class="add-button" type="success" @click="dialogFormVisible = true">添加资源网站</el-button>
    <el-dialog
      title="添加/修改资源网站"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="资源网站名称" :label-width="formLabelWidth" prop="name">
          <el-input v-model="form.name" autocomplete="off" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label="网址url" :label-width="formLabelWidth" prop="url">
          <el-input v-model="form.url" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'WebSiteEditForm',
  components: {},
  data () {
    return {
      dialogFormVisible: false,
      form: {
        id: '',
        name: '',
        url: ''
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    clear () {
      this.$refs.imgUpload.clear()
      this.form = {
        id: '',
        name: '',
        url: ''
      }
    },
    onSubmit () {
      this.$axios
        .post('/websites', {
          id: this.form.id,
          name: this.form.name,
          url: this.form.url
        }).then(resp => {
          if (resp && resp.data.code === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
    }
  }
}
</script>

<style scoped>
  .add-button {
    margin: 18px 0 0 10px;
  }
</style>
