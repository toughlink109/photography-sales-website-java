<template>
  <div class="page-wrapper">
    <!-- 单一容器：宽1200px，高600px -->
    <div class="login-container">
      <!-- 左侧：表单区域 -->
      <div class="form-section">
        <el-form class="login-el-form">
          <!-- 将表单字段单独放入一个 div 中 -->
          <div class="form-fields">
            <!-- 标题 -->
            <div class="form-title" v-if="true">
              欢迎您，管理员用户
            </div>

            <!-- 用户名 -->
            <div class="list-item" v-if="loginType == 1">
              <div class="label">用户名：</div>
              <input
                  class="login-input"
                  placeholder="请输入用户名"
                  name="username"
                  type="text"
                  v-model="rulesForm.username"
              />
            </div>

            <!-- 密码 -->
            <div class="list-item" v-if="loginType == 1">
              <div class="label">密&nbsp;&nbsp;&nbsp;码：</div>
              <input
                  class="login-input"
                  placeholder="请输入密码"
                  name="password"
                  type="password"
                  v-model="rulesForm.password"
              />
            </div>

            <!-- 验证码：当连续输错3次后显示 -->
            <div class="list-item" v-if="loginErrorCount >= 3">
              <div class="label">验证码：</div>
              <input
                  class="login-authcode"
                  placeholder="请输入验证码"
                  name="captcha"
                  type="text"
                  v-model="captchaInput"
              />
              <!-- 使用canvas展示验证码，点击刷新 -->
              <canvas
                  ref="captchaCanvas"
                  width="120"
                  height="40"
                  class="captcha-canvas"
                  @click="generateCaptcha"
              ></canvas>
            </div>

            <!-- 角色单选 -->
            <div class="login-radio" v-if="roles.length > 1" prop="loginInRole">
              <el-radio
                  v-if="loginType == 1 || (loginType == 2 && item.roleName != '管理员')"
                  v-for="item in roles"
                  :key="item.roleName"
                  v-model="rulesForm.role"
                  :label="item.roleName"
              >
                {{ item.roleName }}
              </el-radio>
            </div>

            <!-- 登录按钮 -->
            <div class="login-btn-wrap">
              <el-button
                  class="login-btn"
                  v-if="loginType == 1"
                  type="primary"
                  @click="login"
              >
                登录
              </el-button>
            </div>
          </div>
        </el-form>
      </div>

      <!-- 右侧：图片区域 -->
      <div class="image-section">
        <img
            src="https://img.freepik.com/free-vector/mobile-login-concept-illustration_114360-83.jpg"
            alt="登录插画"
        />
      </div>
    </div>
    <footer class="bottom-footer">
      @ all right reserved by  甘肃政法大学 张恒毓 2025
    </footer>
  </div>
</template>

<script>
import menu from "@/utils/menu";

export default {
  data() {
    return {
      verifyCheck2: false,
      flag: false,
      baseUrl: this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
      // 新增字段
      loginErrorCount: 0, // 记录连续登录失败次数
      captcha: "",        // 验证码字符串
      captchaInput: "",   // 用户输入的验证码
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;
    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin == '是') {
        this.roles.push(this.menus[i]);
      }
    }
  },
  methods: {
    // 生成验证码及绘制干扰项
    generateCaptcha() {
      // 生成一个随机4位验证码字符串
      const chars = 'ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789';
      let result = '';
      for (let i = 0; i < 4; i++) {
        result += chars.charAt(Math.floor(Math.random() * chars.length));
      }
      this.captcha = result;
      // 调用绘制方法
      this.drawCaptcha();
      // 每次刷新时清空用户输入
      this.captchaInput = "";
    },
    // 绘制验证码到canvas上
    drawCaptcha() {
      const canvas = this.$refs.captchaCanvas;
      if (!canvas) return;
      const ctx = canvas.getContext("2d");
      const width = canvas.width;
      const height = canvas.height;
      // 清空画布
      ctx.clearRect(0, 0, width, height);
      // 绘制背景颜色
      ctx.fillStyle = "#f0f0f0";
      ctx.fillRect(0, 0, width, height);
      // 绘制验证码文字
      for (let i = 0; i < this.captcha.length; i++) {
        const char = this.captcha[i];
        // 随机字体大小和颜色
        const fontSize = 20 + Math.floor(Math.random() * 10);
        const angle = Math.random() * 30 * Math.PI / 180;
        ctx.font = `${fontSize}px Arial`;
        ctx.fillStyle = `rgb(${Math.floor(Math.random()*100)}, ${Math.floor(Math.random()*100)}, ${Math.floor(Math.random()*100)})`;
        // 设置文字位置及旋转
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
    // 注册
    register(tableName) {
      this.$storage.set("loginTable", tableName);
      this.$router.push({ path: "/register", query: { pageFlag: "register" } });
    },
    // 登陆
    login() {
      // 当连续失败3次后，需要验证验证码
      if (this.loginErrorCount >= 3) {
        if (!this.captchaInput) {
          this.$message.error("请输入验证码");
          return;
        }
        if (this.captchaInput.toLowerCase() !== this.captcha.toLowerCase()) {
          this.$message.error("验证码错误，请重新输入");
          this.generateCaptcha();
          return;
        }
      }
      if (!this.rulesForm.username) {
        this.$message.error("请输入用户名");
        return;
      }
      if (!this.rulesForm.password) {
        this.$message.error("请输入密码");
        return;
      }
      if (this.roles.length > 1) {
        if (!this.rulesForm.role) {
          this.$message.error("请选择角色");
          return;
        }
        let menus = this.menus;
        for (let i = 0; i < menus.length; i++) {
          if (menus[i].roleName == this.rulesForm.role) {
            this.tableName = menus[i].tableName;
          }
        }
      } else {
        this.tableName = this.roles[0].tableName;
        this.rulesForm.role = this.roles[0].roleName;
      }
      this.loginPost();
    },
    loginPost() {
      this.$http({
        url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
        method: "post",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          // 登录成功后重置失败次数和验证码信息
          this.loginErrorCount = 0;
          this.captcha = "";
          this.captchaInput = "";
          this.$storage.set("Token", data.token);
          this.$storage.set("role", this.rulesForm.role);
          this.$storage.set("sessionTable", this.tableName);
          this.$storage.set("adminName", this.rulesForm.username);
          this.$router.replace({ path: "/" });
        } else {
          this.$message.error(data.msg);
          // 累计登录失败次数
          this.loginErrorCount++;
          // 当连续失败达到3次时生成验证码
          if (this.loginErrorCount === 3) {
            this.generateCaptcha();
          }
        }
      });
    },
  },
};
</script>

<style lang="scss" scoped>
.page-wrapper {
  width: 100%;
  height: 100vh;
  background-color: #f5f6fa;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0;
}

.login-container {
  width: 1200px;
  height: 600px;
  display: flex;
  flex-direction: row;
  margin: 0;
  padding: 0;
  border: 1px solid #ddd;
  box-sizing: border-box;
}

.form-section {
  width: 60%;
  height: 100%;
  display: flex;
  background: #fff;
}

.login-el-form {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: #fff;
  box-shadow: 0 1px 20px rgba(255, 255, 255, 0.8);
  border-radius: 4px;
}

.form-fields {
  width: 80%;
  margin: 0 auto;
}

.form-title {
  width: 100%;
  margin: 100px 20px 100px 20px;
  line-height: 44px;
  font-size: 35px;
  color: #374254;
  text-align: center;
}

.list-item {
  margin: 0 auto 10px;
  display: flex;
  align-items: center;
}

.label {
  width: 64px;
  line-height: 44px;
  font-size: 14px;
  color: #374254;
  font-weight: 600;
  margin-left: 50px;
  margin-top: 10px;
  margin-bottom: 10px;
}

.login-input, .login-authcode {
  border: 1px solid rgba(167, 180, 201, 0.3);
  padding: 0 10px;
  color: #374254;
  outline-offset: 4px;
  font-size: 14px;
  height: 44px;
  border-radius: 30px;
}

.login-input {
  width: 400px;
}

.login-authcode {
  width: 265px;
}

.captcha-canvas {
  margin-left: 10px;
  vertical-align: middle;
  border: 1px solid #ddd;
  cursor: pointer;
}

.login-radio {
  margin: 20px auto;
  text-align: center;
}

.login-btn-wrap {
  width: 100%;
  margin: 20px auto;
  display: flex;
  justify-content: center;
}

.login-btn {
  border: 0;
  cursor: pointer;
  padding: 0 24px;
  margin: 10px;
  outline: none;
  color: #fff;
  border-radius: 30px;
  background: #409eff;
  width: 100px;
  font-size: 16px;
  height: 44px;
  margin-left: 80px;
  margin-top: 30px;
}

.image-section {
  width: 50%;
  height: 100%;
  overflow: hidden;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;
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
</style>
