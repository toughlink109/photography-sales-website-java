<template>
  <div class="login-page">
    <!-- 左侧插画区域 -->
    <div class="login-left">
      <img
          class="login-illustration"
          src="https://cdn.prod.website-files.com/6364b6fd26e298b0b8b938f5/6364b6fd26e2987e0cb93a02_reset%20password.png"
          alt="Illustration"
      />
    </div>

    <!-- 右侧表单区域 -->
    <div class="login-right">
      <!-- 再嵌套一层容器，以便灵活调整表单位置/宽度 -->
      <div class="form-container">
        <el-form
            ref="loginForm"
            :model="loginForm"
            :rules="rules"
            class="login-form"
        >
          <!-- 标题 -->
          <h2 class="login-title">欢迎回来，别来无恙啊!</h2>
          <p class="login-subtitle">基于Java的个人摄影管理网站</p>

          <!-- 用户名 -->
          <el-form-item prop="username">
            <el-input
                class="localinput"
                v-model="loginForm.username"
                placeholder="请输入账号"
                clearable
            />
          </el-form-item>

          <!-- 密码 -->
          <el-form-item prop="password">
            <el-input
                class="localinput"
                v-model="loginForm.password"
                type="password"
                placeholder="请输入密码"
                clearable
            />
          </el-form-item>

          <!-- 角色选择(若需要) -->
          <el-form-item v-if="roles.length > 1">
            <el-select
                v-model="loginForm.tableName"
                placeholder="请选择角色"
                @change="selectChange"
                style="width: 100%;"
            >
              <el-option
                  v-for="(item, index) in roles"
                  :key="index"
                  :label="item.roleName"
                  :value="item.tableName"
              />
            </el-select>
          </el-form-item>

          <!-- 验证码：当连续输错3次后显示 -->
          <el-form-item v-if="loginErrorCount >= 3">
            <!-- 使用一个容器统一水平排列验证码输入框和Canvas -->
            <div class="captcha-wrapper">
              <el-input
                  class="authcode"
                  v-model="captchaInput"
                  placeholder="请输入验证码"
                  clearable
              />
              <canvas
                  ref="captchaCanvas"
                  width="120"
                  height="40"
                  class="captcha-canvas"
                  @click="generateCaptcha"
              ></canvas>
            </div>
          </el-form-item>

          <!-- 登录按钮 -->
          <el-form-item>
            <el-button
                type="primary"
                class="btn-login"
                @click="submitForm('loginForm')"
            >
              登录
            </el-button>
          </el-form-item>

          <!-- 注册按钮(若需要) -->
          <div class="register-links" v-if="roles.length">
            <router-link
                v-for="(item, index) in roles"
                :key="index"
                v-if="item.hasFrontRegister === '是'"
                :to="{ path: '/register', query: { role: item.tableName, pageFlag: 'register' } }"
                class="btn-register"
            >
              还没有账号？点击注册{{ item.roleName.replace('注册', '') }}
            </router-link>
          </div>
        </el-form>
      </div>
    </div>
    <footer class="bottom-footer">
      @ all right reserved by  甘肃政法大学 张恒毓 2025
    </footer>
  </div>
</template>

<script>
import menu from '@/config/menu'

export default {
  data() {
    return {
      baseUrl: this.$config.baseUrl,
      loginType: 1,
      roleMenus: [],
      loginForm: {
        username: '',
        password: '',
        tableName: '',
        code: '', // 若后续需要提交验证码，此字段可使用
      },
      role: '',
      roles: [],
      rules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      },
      // 新增字段：记录连续登录失败次数、验证码文本、用户输入的验证码
      loginErrorCount: 0,
      captcha: '',
      captchaInput: ''
    }
  },
  created() {
    // 角色信息
    this.roleMenus = menu.list()
    for (let item in this.roleMenus) {
      if (this.roleMenus[item].hasFrontLogin === '是') {
        this.roles.push(this.roleMenus[item])
      }
    }
  },
  methods: {
    selectChange(e) {
      for (let x in this.roles) {
        if (this.roles[x].tableName === e) {
          this.role = this.roles[x].roleName
        }
      }
    },
    // 生成一个4位随机验证码，并绘制带干扰项的图形验证码
    generateCaptcha() {
      const chars = 'ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789'
      let result = ''
      for (let i = 0; i < 4; i++) {
        result += chars.charAt(Math.floor(Math.random() * chars.length))
      }
      this.captcha = result
      this.drawCaptcha()
      this.captchaInput = ''
    },
    // 利用Canvas绘制验证码及干扰项
    drawCaptcha() {
      const canvas = this.$refs.captchaCanvas
      if (!canvas) return
      const ctx = canvas.getContext('2d')
      const width = canvas.width
      const height = canvas.height
      // 清除画布
      ctx.clearRect(0, 0, width, height)
      // 绘制背景
      ctx.fillStyle = '#f0f0f0'
      ctx.fillRect(0, 0, width, height)
      // 绘制验证码字符
      for (let i = 0; i < this.captcha.length; i++) {
        const char = this.captcha[i]
        const fontSize = 20 + Math.floor(Math.random() * 10)
        const angle = Math.random() * 30 * Math.PI / 180
        ctx.font = `${fontSize}px Arial`
        ctx.fillStyle = `rgb(${Math.floor(Math.random()*100)}, ${Math.floor(Math.random()*100)}, ${Math.floor(Math.random()*100)})`
        ctx.save()
        const x = 10 + i * 25
        const y = 25 + Math.floor(Math.random() * 10)
        ctx.translate(x, y)
        ctx.rotate(angle)
        ctx.fillText(char, 0, 0)
        ctx.restore()
      }
      // 绘制干扰线
      for (let i = 0; i < 5; i++) {
        ctx.strokeStyle = `rgb(${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)})`
        ctx.beginPath()
        ctx.moveTo(Math.random() * width, Math.random() * height)
        ctx.lineTo(Math.random() * width, Math.random() * height)
        ctx.stroke()
      }
      // 绘制干扰点
      for (let i = 0; i < 30; i++) {
        ctx.fillStyle = `rgb(${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)})`
        const x = Math.random() * width
        const y = Math.random() * height
        ctx.beginPath()
        ctx.arc(x, y, 1, 0, 2 * Math.PI)
        ctx.fill()
      }
    },
    submitForm(formName) {
      if (this.roles.length !== 1) {
        if (!this.role) {
          this.$message.error('请选择登录用户类型')
          return
        }
      } else {
        this.role = this.roles[0].roleName
        this.loginForm.tableName = this.roles[0].tableName
      }
      // 当连续输错3次后校验验证码
      if (this.loginErrorCount >= 3) {
        if (!this.captchaInput) {
          this.$message.error('请输入验证码')
          return
        }
        if (this.captchaInput.toLowerCase() !== this.captcha.toLowerCase()) {
          this.$message.error('验证码错误，请重新输入')
          this.generateCaptcha()
          return
        }
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http
              .get(`${this.loginForm.tableName}/login`, { params: this.loginForm })
              .then((res) => {
                if (res.data.code === 0) {
                  localStorage.setItem('frontToken', res.data.token)
                  localStorage.setItem('UserTableName', this.loginForm.tableName)
                  localStorage.setItem('username', this.loginForm.username)
                  localStorage.setItem('frontSessionTable', this.loginForm.tableName)
                  localStorage.setItem('frontRole', this.role)
                  localStorage.setItem('keyPath', 0)
                  this.$router.push('/')
                  this.$message.success('登录成功')
                  // 登录成功后重置错误计数及验证码数据
                  this.loginErrorCount = 0
                  this.captcha = ''
                  this.captchaInput = ''
                } else {
                  this.$message.error(res.data.msg)
                  // 登录失败，累计错误次数；达到3次时生成验证码
                  this.loginErrorCount++
                  if (this.loginErrorCount === 3) {
                    this.generateCaptcha()
                  }
                }
              })
        } else {
          return false
        }
      })
    }
  },
}
</script>

<style lang="scss" scoped>
.login-page {
  display: flex;
  min-height: 100vh;

  /* 左侧插画区域 (占比6) */
  .login-left {
    flex: 6;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #f8f9fa;
  }

  .login-illustration {
    max-width: 40%;
    height: auto;
  }

  /* 右侧表单区域 (占比4) */
  .login-right {
    flex: 4;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #fff;
  }

  .form-container {
    width: 80%;
    max-width: 560px;
    margin: 0 auto;
  }

  .login-subtitle {
    margin-bottom: 150px;
    font-size: 18px;
    text-align: center;
    color: #747474;
  }
  .login-form {
    .login-title {
      margin-top: 50px;
      margin-bottom: 30px;
      font-size: 40px;
      font-weight: 600;
      color: #333;
      text-align: center;
    }
    // 错误标签外边框左移
    .el-form-item__error{
      margin-left: 120px;

    .el-form-item {
      margin-bottom: 30px;
      .el-input__inner {
        height: 44px;
      }

    }


    }

    .localinput, .authcode{
      width: 300px;
      border-radius: 30px;
      margin-left: 120px;

    }
    .authcode{
      width: 175px;
    }
    .btn-login {
      width: 100px;
      height: 44px;
      font-size: 16px;
      margin: 30px 230px;
      border-radius: 30px;
    }

    .register-links {
      margin-top: 20px;
      display: flex;
      flex-direction: column;

      .btn-register {
        margin-top: 8px;
        text-align: center;
        color: #909399;
        text-decoration: none;

        &:hover {
          text-decoration: none;
        }
      }
    }
  }
}

.bottom-footer {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 80px;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  background-color: white;
  font-size: 16px;
  color: #909399;
  border-top: 1px solid #ddd;
}

///* 新增：验证码容器统一水平排列 */
// 用于包裹验证码输入框和 Canvas，这样可以通过 CSS 使它们在同一行排列。
.captcha-wrapper {
  display: flex;
  align-items: center;

}

.captcha-canvas {
  //margin-left: 10px;
  width: 125px;
  height: 40px;
  cursor: pointer;
  border: 1px solid #ddd;
}
</style>
