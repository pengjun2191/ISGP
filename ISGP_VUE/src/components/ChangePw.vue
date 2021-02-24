<template>
<body id="change_pw_body">
  <el-form :model="changePwForm" status-icon :rules="rules" ref="changePwForm" label-width="100px" class="change_pw_form">
    <el-form-item label="旧密码:" prop="oldPass">
      <el-input v-model.number="changePwForm.oldPass"></el-input>
    </el-form-item>
    <el-form-item label="密码:" prop="pass">
      <el-input type="password" v-model="changePwForm.pass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="确认密码:" prop="checkPass">
      <el-input type="password" v-model="changePwForm.checkPass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('changePwForm')">提交</el-button>
      <el-button @click="resetForm('changePwForm')">重置</el-button>
    </el-form-item>
  </el-form>
</body>
</template>

<script>
export default {
  name: 'ChangePw',
  data () {
    var checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('年龄不能为空'))
      }
      setTimeout(() => {
        if (!Number.isInteger(value)) {
          callback(new Error('请输入数字值'))
        } else {
          if (value < 18) {
            callback(new Error('必须年满18岁'))
          } else {
            callback()
          }
        }
      }, 1000)
    }
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.changePwForm.checkPass !== '') {
          this.$refs.changePwForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.changePwForm.pass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      changePwForm: {
        oldPass: '',
        pass: '',
        checkPass: ''
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        age: [
          { validator: checkAge, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
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

<style scoped>

</style>
