<template>
  <div class="container">
    <!-- 左侧插画区域 -->
    <div class="left-illustration">
      <img
          src="https://cdn.prod.website-files.com/6364b6fd26e298b0b8b938f5/6364b6fd26e298040bb939fc_signin.png"
          alt="Illustration"
          class="illustration-img"
      />
    </div>

    <!-- 右侧表单区域 -->
    <div class="right-form">
      <el-form
          class="rgs-form"
          v-if="pageFlag=='register'"
          ref="registerForm"
          :model="registerForm"
          :rules="rules"
      >
        <div class="form-header">欢迎加入大家庭</div>

        <!-- 账号：必填项 -->
        <el-form-item class="form-item" v-if="tableName=='ordinaryUser'" prop="account">
          <label class="form-label"><span class="required">*</span>账号名称：</label>
          <el-input
              v-model="registerForm.account"
              placeholder="请输入账号"
              class="form-input"
          />
        </el-form-item>

        <!-- 密码：必填项 -->
        <el-form-item class="form-item" v-if="tableName=='ordinaryUser'" prop="password">
          <label class="form-label"><span class="required">*</span>密码：</label>
          <el-input
              v-model="registerForm.password"
              type="password"
              placeholder="请输入密码"
              class="form-input"
          />
        </el-form-item>

        <!-- 确认密码：必填项 -->
        <el-form-item class="form-item" v-if="tableName=='ordinaryUser'" prop="password2">
          <label class="form-label"><span class="required">*</span>确认密码：</label>
          <el-input
              v-model="registerForm.password2"
              type="password"
              placeholder="请再次输入密码"
              class="form-input"
          />
        </el-form-item>

        <!-- 验证码：始终显示 -->
        <el-form-item class="form-item" prop="code">
          <label class="form-label"><span class="required">*</span>验证码：</label>
          <div class="captcha-wrapper">
            <el-input
                v-model="registerForm.code"
                placeholder="请输入验证码"
                class="form-input captcha-input"
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

        <el-button class="submit-button" type="primary" @click="submitForm('registerForm')">
          注册
        </el-button>
        <router-link class="login-link" to="/login">已有账户登录</router-link>
      </el-form>
    </div>
    <footer class="bottom-footer">
      @ all right reserved by  甘肃政法大学 张恒毓 2025
    </footer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pageFlag: '',
      tableName: '',
      registerForm: {},
      rules: {},
      // 新增：用于验证码校验
      captcha: '', // 记录当前生成的验证码
      ordinaryUseruserSexOptions: [],
    };
  },
  mounted() {
    if (this.$route.query.pageFlag === 'register') {
      this.tableName = this.$route.query.role;
      if (this.tableName === 'ordinaryUser') {
        this.registerForm = {
          account: '',
          password: '',
          password2: '',
          code: '', // 用于验证码输入
          realName: '',
          userSex: '',
          mobile: '',
          email: '',
          idCard: '',
          userAvatar: '',
          money: '',
          vip: '',
        };
        // 设置必填规则
        this.rules.account = [{ required: true, message: '请输入账号', trigger: ['blur', 'change'] }];
        this.rules.password = [
          { required: true, message: '请输入密码', trigger: ['blur', 'change'] },
          { validator: this.validatePassword, trigger: ['blur', 'change'] }
        ];
        this.rules.password2 = [
          { required: true, message: '请再次输入密码', trigger: ['blur', 'change'] },
          { validator: this.validatePassword2, trigger: ['blur', 'change'] }
        ];
        this.rules.code = [{ required: true, message: '请输入验证码', trigger: ['blur', 'change'] }];
        // 其他可选规则
        this.rules.mobile = [{ required: false, validator: this.$validate?.isMobile, trigger: 'blur' }];
        this.rules.money = [{ required: false, validator: this.$validate?.isNumber, trigger: 'blur' }];
      }
      // 注册时始终生成验证码
      this.generateCaptcha();
    }
  },
  created() {
    this.pageFlag = this.$route.query.pageFlag;
    if (this.$route.query.pageFlag === 'register') {
      if (this.tableName === 'ordinaryUser') {
        // 备用：若需要在 created 中设置规则，可在此进行配置
      }
      this.ordinaryUseruserSexOptions = '男,女'.split(',');
    }
  },
  methods: {
    validatePassword(rule, value, callback) {
      // 密码复杂度要求：至少6位，必须包含大写字母、小写字母、数字和特殊符号
      const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{6,}$/;
      if (!value) {
        this.$message.error('请输入密码');
        return callback(new Error('请输入密码'));
      }
      if (!pattern.test(value)) {
        this.$message.error('密码至少6位，需包含大写字母、小写字母、数字和特殊符号');
        return callback(new Error('密码复杂度不符合要求'));
      }
      callback();
    },
    validatePassword2(rule, value, callback) {
      if (!value) {
        this.$message.error('请再次输入密码');
        return callback(new Error('请再次输入密码'));
      }
      if (value !== this.registerForm.password) {
        this.$message.error('两次密码输入不一致');
        return callback(new Error('两次密码输入不一致'));
      }
      callback();
    },
    // 生成4位随机验证码，并调用绘制函数
    generateCaptcha() {
      const chars = 'ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789';
      let result = '';
      for (let i = 0; i < 4; i++) {
        result += chars.charAt(Math.floor(Math.random() * chars.length));
      }
      this.captcha = result;
      this.drawCaptcha();
      // 清空用户输入的验证码
      this.registerForm.code = '';
    },
    // 使用Canvas绘制验证码和干扰项
    drawCaptcha() {
      const canvas = this.$refs.captchaCanvas;
      if (!canvas) return;
      const ctx = canvas.getContext('2d');
      const width = canvas.width;
      const height = canvas.height;
      ctx.clearRect(0, 0, width, height);
      // 绘制背景
      ctx.fillStyle = '#f0f0f0';
      ctx.fillRect(0, 0, width, height);
      // 绘制验证码字符
      for (let i = 0; i < this.captcha.length; i++) {
        const char = this.captcha[i];
        const fontSize = 20 + Math.floor(Math.random() * 10);
        const angle = Math.random() * 30 * Math.PI / 180;
        ctx.font = `${fontSize}px Arial`;
        ctx.fillStyle = `rgb(${Math.floor(Math.random()*100)}, ${Math.floor(Math.random()*100)}, ${Math.floor(Math.random()*100)})`;
        ctx.save();
        const x = 10 + i * 25;
        const y = 25 + Math.floor(Math.random() * 10);
        ctx.translate(x, y);
        ctx.rotate(angle);
        ctx.fillText(char, 0, 0);
        ctx.restore();
      }
      // 绘制干扰线
      for (let i = 0; i < 5; i++) {
        ctx.strokeStyle = `rgb(${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)})`;
        ctx.beginPath();
        ctx.moveTo(Math.random() * width, Math.random() * height);
        ctx.lineTo(Math.random() * width, Math.random() * height);
        ctx.stroke();
      }
      // 绘制干扰点
      for (let i = 0; i < 30; i++) {
        ctx.fillStyle = `rgb(${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)}, ${Math.floor(Math.random()*255)})`;
        const x = Math.random() * width;
        const y = Math.random() * height;
        ctx.beginPath();
        ctx.arc(x, y, 1, 0, 2 * Math.PI);
        ctx.fill();
      }
    },
    submitForm(formName) {
      // 先对密码字段进行单独验证
      this.$refs[formName].validateField('password', (error) => {
        if (error) {
          return;
        }
        // 再执行整体表单校验
        this.$refs[formName].validate((valid) => {
          if (valid) {
            const url = this.tableName + '/register';
            // 额外校验（例如账号不能为空等），这里已由规则处理
            this.$http.post(url, this.registerForm).then((res) => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  },
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      });
    },
  },
};
</script>

<style scoped lang="scss">
.container {
  display: flex;
  flex-direction: row;
  min-height: 100vh;
  background-color: #f5f7fa;
}

/* 左侧插画区域 */
.left-illustration {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}

.illustration-img {
  width: 50%;
  max-width: 800px;
}

/* 右侧表单区域 */
.right-form {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}

/* 表单整体样式 */
.rgs-form {
  background: #fff;
  border-radius: 30px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  width: 700px;
  padding: 30px 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* 表单头部 */
.form-header {
  margin: 40px;
  font-size: 35px;
  color: #333;
  text-align: center;
}

/* 表单项 */
.form-item {
  width: 540px;
  margin-bottom: 15px;
  display: flex;
  align-items: center;
}

.form-label {
  width: 90px;
  color: #666;
  font-size: 14px;
  text-align: right;
  margin-right: 10px;
}

.required {
  color: red;
}

.form-input {
  width: 540px;
  height: 50px;
}

/* 验证码样式 */
.captcha-wrapper {
  display: flex;
  align-items: center;
}
.captcha-input {
  width: 425px;
}
.captcha-canvas {
  //margin-left: 10px;
  cursor: pointer;
  border: 1px solid #ddd;
  height: 40px;
  margin-bottom: 10px;
}

/* 提交按钮 */
.submit-button {
  width: 100px;
  height: 44px;
  margin: 20px 0;
  font-size: 16px;
  background: #409eff;
  color: #fff;
  border: none;
  border-radius: 30px;
  cursor: pointer;
  &:hover {
    background: #66b1ff;
  }
}

/* 链接样式 */
.login-link {
  color: #909399;
  font-size: 14px;
  text-decoration: none;
  text-align: center;
  display: block;
  margin-top: 5px;
}

/* 脚注 */
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
</style>
