<template>
  <body id="login_body">
  <el-form class="login_form" ref="loginForm" :model="loginForm" label-position="left" label-width="60px">
    <h3 class="login_title">信息系统通用平台</h3>
    <el-form-item label="用户名:" prop="username">
      <el-input type="text" placeholder="请输入用户" v-model="loginForm.username" clearable> </el-input>
    </el-form-item>
    <el-form-item label="密 码:" prop="password">
      <el-input type="password" placeholder="请输入密码" v-model="loginForm.password" show-password></el-input>
    </el-form-item>
    <el-form-item label="验证码:" prop="captcha_code">
      <el-input type="captcha_code" placeholder="请输入验证码" v-model="loginForm.captcha_code" ></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="login">登录</el-button>
      <el-button @click="resetForm('loginForm')">重置</el-button>
    </el-form-item>
    <el-form-item>
      <el-link type="primary" @click="changePw">修改密码</el-link>
      <el-link type="primary" @click="forGetPw">忘记密码</el-link>
    </el-form-item>
  </el-form>
  </body>
</template>
<script>

export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: '',
        captcha_code: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/home'})
          }
        })
        .catch(failResponse => {
        })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    changePw () {
      this.$router.push('/change_pw')
    },
    forGetPw () {
      this.$router.push('/forget_pw')
    }
  }
}
</script>
