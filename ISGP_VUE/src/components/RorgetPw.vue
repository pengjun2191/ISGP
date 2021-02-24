<template>
  <el-form class="Forget_Pw" ref="loginForm" :model="forgetpw" label-position="left" label-width="60px">
    <h3 class="ForgetPw_title">信息系统通用平台</h3>
    <el-form-item label="邮箱:" prop="email">
      <el-input type="text" placeholder="Email" v-model="forgetpw.email" clearable> </el-input>
    </el-form-item>
    <el-form-item label="验证码:" prop="password">
      <el-input type="password" placeholder="请输入密码" v-model="forgetpw.captcha_code" clearable></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="send">发送验证</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: 'RorgetPw',
  data () {
    return {
      forgetpw: {
        email: '',
        captcha_code: ''
      },
      responseResult: []
    }
  },
  methods: {
    send () {
      this.$axios
        .post('/forget', {
          username: this.forgetpw.email
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/home'})
          }
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>

<style scoped>

</style>
