<!--
 * @FileDescription 登录界面
 * @Author livre
 -->
<template>
  <body id="poster">
  <!-- 登录表单 rules实现前端信息验证 loginForm绑定表单数据 -->
  <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <!-- 记住密码选择框 checked默认值为false 不选中 -->
<!--    <el-checkbox class="login_remember" v-model="checked"-->
<!--                 label-position="left"><span style="color: #505458">记住密码</span></el-checkbox>-->
    <el-form-item style="width: 100%">
      <!-- 登录按钮 点击事件绑定login方法 -->
      <el-button type="primary" style="width: 40%;background: #FF4500;border: none" v-on:click="login">登录</el-button>
      <router-link to="register"><el-button type="primary" style="width: 40%;background: #FF4500;border: none">注册</el-button></router-link>
    </el-form-item>
    <p class="alt" style="color:#999; line-height:0;font-size: 12px;">&#174;建议使用Chrome浏览器访问 &nbsp;
    </p>
  </el-form>
  <div class="footer1">
    <div style="border-top:1px #1F1F1F solid;">
      <p class="alt" style="color:#999; line-height:0;">&copy; 版权所有：Livre &nbsp;
        <span>技术支持：</span>
        <a href="" target="_blank" style="color:#999;">Livre &nbsp;</a>
        <span>联系我：</span>
        <a href="" target="_blank" style="color:#999;">068-18319792414</a>
      </p>
    </div>
  </div>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      /**
       * @description rules验证 内容：required:true表示必填，提示信息为 message，trigger触发器为blur 失去焦点时验证，如果为空
       */
      rules: {
        username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
      },
      /**
       * @description 记住密码选择框 默认值 false
       */
      checked: false,
      /**
       * @description 登录界面表单信息 用户名+密码 默认值
       */
      loginForm: {
        username: 'youke',
        password: '123456'
      },
      /**
       * @description v-loading加载
       */
      loading: false
    }
  },
  methods: {
    /**
     * @description 登录按钮点击方法.通过axios发送post请求,url为'/login'
     * @params {String} loginForm
     * @return 返回数据到$store保存
     */
    login () {
      var _this = this
      this.$axios
        .post('/login', {
          username: this.loginForm.username, // 表单数据
          password: this.loginForm.password
        })
        .then(resp => { // 发送成功  回调函数
          if (resp.data.code === 200) { // 状态码200  表示一切正常
            var data = resp.data.result // 返回的json数据
            _this.$store.commit('login', data) // 触发store中的login方法 传送data数据
            var path = _this.$route.query.redirect
            // location.href('/index')
            // eslint-disable-next-line standard/object-curly-even-spacing
            _this.$router.replace({path: path === '/' || path === undefined ? '/index' : path, query: { pi: 1} }) // 判断path后进行页面跳转
          } else { // 其他错误状态码 弹出alert确认框提示信息
            this.$alert(resp.data.message, '提示', {
              confirmButtonText: '确定'
            })
          }
        })
        .catch(failResponse => {
          this.$alert('服务器异常', '提示', {
            confirmButtonText: '确定'
          })
        }) // 发送失败  回调函数
    }
  }
}
</script>

<style>
  #poster {
    background:url("../../static/img/eva.jpg") no-repeat;
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
  .login_remember {
    margin: 0px 0px 5px 0px;
    text-align: left;
  }
  span {
    font-size: 12px;
  }

  .footer1 {
    background: #2b2e33;
    height: 40px;
    width: 100%;
    position: fixed;
    bottom: 0;
    font-size: 12px;
  }

  .footer1 .alt {
    overflow: hidden;
    padding: 20px 0;
    margin: auto;
    font-size: 12px;
  }
  .footer1 .alt .foot p {
    color: #FFF;
    line-height: 28px;
    font-size: 12px;
  }

  a{
    text-decoration: none;
  }

  .footer1 .alt .foot a {
    color: #999;
    display: block;
    line-height: 24px;
    font-size: 12px;
  }

</style>
