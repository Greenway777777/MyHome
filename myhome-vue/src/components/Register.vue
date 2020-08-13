<!--
 * @FileDescription 注册界面
 * @Author livre
 -->
<template>
  <body id="paper">
  <el-form class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">用户注册</h3>
    <el-form-item>
      <el-input type="text" v-model="registerForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="registerForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #FF4500;border: none" v-on:click="register">注册</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>
<script>
export default{
  data () {
    return {
      /**
       * @description 注册界面表单信息 用户名+密码
       */
      registerForm: {
        username: '',
        password: '',
        name: '',
        phone: '',
        email: '',
        enabled: ''
      },
      /**
       * @description v-loading加载
       */
      loading: false
    }
  },
  methods: {
    /**
     * @description 注册按钮点击方法.通过axios发送post请求,url为'/register'
     * @params {String} registerForm
     * @return 返回成功状态码200弹出确认框,点击确认自动跳转到登录页面
     */
    register () {
      var _this = this
      this.$axios
        .post('/register', {
          username: this.registerForm.username,
          password: this.registerForm.password,
          name: '',
          phone: '',
          email: '',
          enabled: ''
        })
        .then(resp => {
          if (resp.data.code === 200) {
            this.$alert('注册成功', '提示', {
              confirmButtonText: '确定'
            })
            _this.$router.replace('/login')
          } else {
            this.$alert(resp.data.message, '提示', {
              confirmButtonText: '确定'
            })
          }
        })
        .catch(failResponse => {})
    }
  }
}
</script>
<style>
  #paper {
    background:url("../assets/eva.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
</style>
