<template>
  <body id="register_body">
  <el-form class="register_form" :model="registerForm" status-icon :rules="rules" ref="registerForm" label-width="100px">
    <el-form-item label="用户名:" prop="username" :rules="[
      { required: true, message: '用户名不能为空'},
    ]">
      <el-input type="text" placeholder="请输入用户" v-model="registerForm.username" clearable> </el-input>
    </el-form-item>
    <el-form-item label="密码:" prop="pass">
      <el-input type="password" v-model="registerForm.pass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="确认密码:" prop="checkPass">
      <el-input type="password" v-model="registerForm.checkPass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="年龄:" prop="age" :rules="[
      { required: true, message: '年龄不能为空'},
      { type: 'number', message: '年龄必须为数字值'}
    ]">
      <el-input type="age" v-model.number="registerForm.age" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item prop="email" label="邮箱:" :rules="[
      { required: true, message: '请输入邮箱地址', trigger: 'blur' },
      { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
    ]">
      <el-input v-model="registerForm.email"></el-input>
    </el-form-item>
    <el-form-item label="联系电话:" prop="userPhone">
      <el-input type="text" placeholder="请输入联系方式" v-model="registerForm.userPhone" clearable> </el-input>
    </el-form-item>
    <el-form-item label="联系地址:" prop="userAddr">
      <el-input type="text" placeholder="请输入联系地址" v-model="registerForm.userAddr" clearable> </el-input>
    </el-form-item>
    <el-form-item class="efi" label="实名认证类型:" prop="userAuthType" label-width=25% :rules="[
      { required: true, message: '实际名字不能为空',trigger: 'change' },
    ]">
      <el-select v-model="registerForm.userAuthType" placeholder="请选择实名认证类型">
        <el-option label="身份证" value="identity_card"></el-option>
        <el-option label="其它" value="other"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="实际名字:" prop="user" :rules="[
      { required: true, message: '实际名字不能为空'},
    ]">
      <el-input type="text" placeholder="请输入名字" v-model="registerForm.user" clearable> </el-input>
    </el-form-item>
    <el-form-item label="证件号码:" prop="userAuthNum" :rules="[
      { required: true, message: '证件号码不能为空'},
    ]">
      <el-input type="text" placeholder="请输入证件号码" v-model="registerForm.userAuthNum" clearable> </el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('registerForm')">提交</el-button>
      <el-button @click="resetForm('registerForm')">重置</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
export default {
  name: 'register',
  data () {
    let validatePass
    validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.registerForm.checkPass !== '') {
          this.$refs.registerForm.validateField('checkPass')
        }
        callback()
      }
    }
    let validatePass2
    validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.registerForm.pass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      registerForm: {
        username: '',
        pass: '',
        checkPass: '',
        age: '',
        email: '',
        userPhone: '',
        userAddr: '',
        userAuthType: '',
        user: '',
        userAuthNum: ''
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios
            .post('/admin/user', this.$refs[formName])
            .then(successResponse => {
              if (successResponse.data.code === 200) {
                this.$router.replace({path: '/UserIndex'})
              }
            })
            .catch(failResponse => {})
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
