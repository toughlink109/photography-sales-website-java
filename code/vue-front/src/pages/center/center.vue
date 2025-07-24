<template>
  <div class="center-preview"
       :style='{"width":"100%","padding":"0","margin":"10px auto","position":"relative","background":"none"}'>
    <div class="title"
         :style='{"margin":"10px auto 0","color":"#FFC174","borderRadius":"60px","textAlign":"center","background":"#8E4033","width":"80%","fontSize":"24px","lineHeight":"54px","fontWeight":"bold"}'>
      {{ title }}
    </div>

    <div class="info"
         :style='{"padding":"30px 70px","boxShadow":"none","margin":"0 auto 20px","alignItems":"center","display":"flex","justifyContent":"center","borderRadius":"10px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20240113/af5db0ea80244cc3a4cb58b8083aa02f.png)","width":"80%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"auto"}'>
      <div
          :style='{"borderColor":"#efefef","color":"#fff","borderWidth":"0","display":"none","width":"100%","lineHeight":"44px","fontSize":"15px","borderStyle":"solid","height":"44px"}'>
        个人信息
      </div>
      <div
          :style='{"width":"auto","borderColor":"#efefef","fontSize":0,"borderStyle":"solid","borderWidth":"0","height":"auto"}'
          v-if="userTableName=='ordinaryUser'">
        <el-image
            :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0","display":"block","width":"110px","borderStyle":"solid","height":"110px"}'
            :src="sessionForm.userAvatar?baseUrl + sessionForm.userAvatar:require('@/assets/userAvatar.png')"
            fit="cover"></el-image>
      </div>
      <div
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"20px 0 0","alignItems":"center","borderWidth":"0","flexDirection":"column","display":"flex","width":"auto","lineHeight":"30px","borderStyle":"solid","justifyContent":"center","height":"auto"}'
          v-if="userTableName=='ordinaryUser'">
        <span class="icon iconfont icon-shouye-zhihui"
              :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
        <div :style='{"color":"#FFC174","fontSize":"14px"}'>账号</div>
        <div :style='{"fontSize":"16px","color":"#FFC174","textAlign":"left","flex":1,"fontWeight":"bold"}'>
          {{ sessionForm.account }}
        </div>
      </div>
      <div
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"20px 0 0","alignItems":"center","flexDirection":"column","display":"flex","justifyContent":"center","borderRadius":"5px","borderWidth":"0","background":"none","width":"auto","lineHeight":"30px","borderStyle":"solid","height":"auto"}'
          v-if="userTableName=='ordinaryUser'">
        <span class="icon iconfont icon-shouye-zhihui"
              :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
        <div :style='{"color":"#FFC174","fontSize":"14px"}'>姓名</div>
        <div :style='{"fontSize":"14px","color":"#FFC174","textAlign":"center","flex":1}'>{{ sessionForm.realName }}
        </div>
      </div>
      <div
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"20px 0 0","alignItems":"center","borderWidth":"0","flexDirection":"column","display":"flex","width":"auto","lineHeight":"30px","borderStyle":"solid","justifyContent":"center","height":"auto"}'
          v-if="userTableName=='ordinaryUser'">
        <span class="icon iconfont icon-shouye-zhihui"
              :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
        <div :style='{"color":"#FFC174","fontSize":"14px"}'>性别</div>
        <div :style='{"fontSize":"14px","color":"#FFC174","textAlign":"center","flex":1}'>{{ sessionForm.userSex }}
        </div>
      </div>
      <div
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"20px 0 0","alignItems":"center","borderWidth":"0","flexDirection":"column","display":"flex","width":"auto","lineHeight":"30px","borderStyle":"solid","justifyContent":"center","height":"auto"}'
          v-if="userTableName=='ordinaryUser'">
        <span class="icon iconfont icon-shouye-zhihui"
              :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
        <div :style='{"color":"#FFC174","fontSize":"14px"}'>手机</div>
        <div :style='{"fontSize":"14px","color":"#FFC174","textAlign":"center","flex":1}'>{{ sessionForm.mobile }}</div>
      </div>
      <div
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"20px 0 0","alignItems":"center","borderWidth":"0","flexDirection":"column","display":"flex","width":"auto","lineHeight":"30px","borderStyle":"solid","justifyContent":"center","height":"auto"}'
          v-if="userTableName=='ordinaryUser'">
        <span class="icon iconfont icon-shouye-zhihui"
              :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
        <div :style='{"color":"#FFC174","fontSize":"14px"}'>邮箱</div>
        <div :style='{"color":"#FFC174","textAlign":"center","fontSize":"14px"}'>{{ sessionForm.email }}</div>
      </div>
      <div
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"20px 0 0","alignItems":"center","borderWidth":"0","flexDirection":"column","display":"flex","width":"auto","lineHeight":"30px","borderStyle":"solid","justifyContent":"center","height":"auto"}'
          v-if="userTableName=='ordinaryUser'">
        <span class="icon iconfont icon-shouye-zhihui"
              :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
        <div :style='{"color":"#FFC174","fontSize":"14px"}'>身份证</div>
        <div :style='{"fontSize":"14px","color":"#FFC174","textAlign":"center","flex":1}'>{{ sessionForm.idCard }}</div>
      </div>

    </div>

    <el-tabs tab-position="left" :style='{"background":"none","flexDirection":"column","display":"flex"}'
             @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="80px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="账号" prop="account">
            <el-input v-model="sessionForm.account" placeholder="账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="姓名" prop="realName">
            <el-input v-model="sessionForm.realName" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="性别" prop="userSex">
            <el-select v-model="sessionForm.userSex" placeholder="请选择性别">
              <el-option v-for="(item, index) in dynamicProp.userSex" :key="index" :label="item"
                         :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="手机" prop="mobile">
            <el-input v-model="sessionForm.mobile" placeholder="手机"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="邮箱" prop="email">
            <el-input v-model="sessionForm.email" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="身份证" prop="idCard">
            <el-input v-model="sessionForm.idCard" placeholder="身份证"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="头像" prop="userAvatar">
            <file-upload
                tip="点击上传头像"
                action="file/upload"
                :limit="1"
                :multiple="true"
                :fileUrls="sessionForm.userAvatar?sessionForm.userAvatar:''"
                @change="ordinaryUseruserAvatarHandleAvatarSuccess"
            ></file-upload>
          </el-form-item>
          <el-form-item class="balance" :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
              <el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
              <div @click="dialogFormVisibleMoney = true"
                   :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 0 0 10px","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"#FFC174","width":"100px","lineHeight":"40px","fontSize":"14px","height":"40px"}'>
                点我充值
              </div>
            </div>
          </el-form-item>
          <el-form-item class="balance" :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'
                        v-if="userTableName=='ordinaryUser'" label="会员">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
              <el-input v-model="sessionForm.vip" placeholder="会员" readonly></el-input>
              <div @click="dialogFormVisibleVip = true"
                   :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 0 0 10px","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"#FFC174","width":"100px","lineHeight":"40px","fontSize":"14px","height":"40px"}'>
                会员购买
              </div>
            </div>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button
                :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#FFC174","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                type="primary" @click="onSubmit('sessionForm')">更新信息
            </el-button>
            <el-button
                :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#0B4D49","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                type="danger" @click="logout">退出登录
            </el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="修改密码">
        <el-form class="center-preview-pv" ref="passwordForm" :model="passwordForm" :rules="passwordRules"
                 label-width="80px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="原密码" prop="password">
            <el-input type="password" v-model="passwordForm.password" placeholder="原密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="新密码"
                        prop="newpassword">
            <el-input type="password" v-model="passwordForm.newpassword" placeholder="新密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="确认密码"
                        prop="repassword">
            <el-input type="password" v-model="passwordForm.repassword" placeholder="确认密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button
                :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#FFC174","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                type="primary" @click="updatePassword">修改密码
            </el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu"
                   :name="item.child[0].tableName"></el-tab-pane>
      <el-tab-pane label="我的发布"></el-tab-pane>
      <el-tab-pane label="我的订单"></el-tab-pane>
      <el-tab-pane label="我的地址" name="MyAddress">
        <router-view></router-view>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>

    <el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
      <el-form :model="chongzhiForm">
        <el-form-item label="充值金额" label-width="120px">
          <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
        </el-form-item>
        <el-form-item label-width="120px">
          <el-radio-group v-model="chongzhiForm.radio">
            <el-radio style="margin-bottom: 30px" label="微信支付">
              <el-image
                  style="width: 60px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/weixin.png')"
                  fit="fill"></el-image>
              <span style="display: inline-block;margin-left: 10px">微信支付</span>
            </el-radio>
            <el-radio label="支付宝支付">
              <el-image
                  style="width: 60px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/zhifubao.png')"
                  fit="fill"></el-image>
              <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
            </el-radio>
            <el-radio label="中国建设银行支付">
              <el-image
                  style="width: 120px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/jianshe.png')"
                  fit="fill"></el-image>
            </el-radio>
            <el-radio label="中国农业银行支付">
              <el-image
                  style="width: 126px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/nongye.png')"
                  fit="fill"></el-image>
            </el-radio>
            <el-radio label="中国银行支付">
              <el-image
                  style="width: 140px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/zhongguo.png')"
                  fit="fill"></el-image>
            </el-radio>
            <el-radio label="交通银行支付">
              <el-image
                  style="width: 120px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/jiaotong.png')"
                  fit="fill"></el-image>
            </el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
        <el-button type="primary" @click="chongzhi">确认充值</el-button>
      </div>
    </el-dialog>
    <el-dialog title="会员购买" :visible.sync="dialogFormVisibleVip" width="726px" center>
      <el-form :model="chongzhiForm">
        <el-form-item label="会员卡" label-width="120px">
          <el-input readonly autocomplete="off" value="￥199/年"></el-input>
        </el-form-item>
        <el-form-item label-width="120px">
          <el-radio-group v-model="chongzhiForm.radio">
            <el-radio style="margin-bottom: 30px" label="微信支付">
              <el-image
                  style="width: 60px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/weixin.png')"
                  fit="fill"></el-image>
              <span style="display: inline-block;margin-left: 10px">微信支付</span>
            </el-radio>
            <el-radio label="支付宝支付">
              <el-image
                  style="width: 60px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/zhifubao.png')"
                  fit="fill"></el-image>
              <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
            </el-radio>
            <el-radio label="中国建设银行支付">
              <el-image
                  style="width: 120px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/jianshe.png')"
                  fit="fill"></el-image>
            </el-radio>
            <el-radio label="中国农业银行支付">
              <el-image
                  style="width: 126px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/nongye.png')"
                  fit="fill"></el-image>
            </el-radio>
            <el-radio label="中国银行支付">
              <el-image
                  style="width: 140px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/zhongguo.png')"
                  fit="fill"></el-image>
            </el-radio>
            <el-radio label="交通银行支付">
              <el-image
                  style="width: 120px; height: 60px;vertical-align: middle;"
                  :src="require('@/assets/jiaotong.png')"
                  fit="fill"></el-image>
            </el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleVip = false">取 消</el-button>
        <el-button type="primary" @click="chongzhivip">确认支付</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import config from '@/config/config'
import menu from '@/config/menu'
import Vue from 'vue'
import QRCode from 'qrcode'

export default {
  //数据集合
  data() {
    return {
      title: '个人中心',
      baseUrl: config.baseUrl,
      sessionForm: {},
      passwordForm: {},
      passwordRules: {
        password: [
          {
            required: true,
            message: "密码不能为空",
            trigger: "blur"
          }
        ],
        newpassword: [
          {
            required: true,
            message: "新密码不能为空",
            trigger: "blur"
          }
        ],
        repassword: [
          {
            required: true,
            message: "确认密码不能为空",
            trigger: "blur"
          }
        ]
      },
      rules: {},
      chongzhiForm: {
        money: '',
        radio: ''
      },
      menuList: [],
      disabled: false,
      dialogFormVisibleMoney: false,
      dialogFormVisibleVip: false,
      uploadUrl: config.baseUrl + 'file/upload',
      imageUrl: '',
      headers: {Token: localStorage.getItem('frontToken')},
      userTableName: localStorage.getItem('UserTableName'),
      dynamicProp: {},
    }
  },
  created() {
    let menus = menu.list()
    for (let x in menus) {
      if (menus[x].tableName == this.userTableName) {
        this.menuList = menus[x].backMenu
      }
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'account', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'password', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'realName', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'userSex', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'mobile', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'email', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'idCard', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'userAvatar', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'money', null);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.sessionForm, 'vip', null);
    }

    if ('ordinaryUser' == this.userTableName && this.rules['account']) {
      this.rules['account'].push({required: true, message: '请输入账号', trigger: 'blur'})
    } else if ('ordinaryUser' == this.userTableName && !this.rules['account']) {
      this.$set(this.rules, 'account', [{required: true, message: '请输入账号', trigger: 'blur'}]);
    }
    if ('ordinaryUser' == this.userTableName && this.rules['password']) {
      this.rules['password'].push({required: true, message: '请输入密码', trigger: 'blur'})
    } else if ('ordinaryUser' == this.userTableName && !this.rules['password']) {
      this.$set(this.rules, 'password', [{required: true, message: '请输入密码', trigger: 'blur'}]);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.rules, 'mobile', [{required: false, validator: this.$validate.isMobile, trigger: 'blur'}]);
    }
    if ('ordinaryUser' == this.userTableName) {
      this.$set(this.rules, 'money', [{required: false, validator: this.$validate.isNumber, trigger: 'blur'}]);
    }

    this.init();
    this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
  },
  //方法集合
  methods: {
    init() {
      if ('ordinaryUser' == this.userTableName) {
        this.dynamicProp.userSex = '男,女'.split(',');
      }
      if ('ordinaryUser' == this.userTableName) {
        this.dynamicProp.vip = '是,否'.split(',');
      }
    },
    setSession() {
      localStorage.setItem('sessionForm', JSON.stringify(this.sessionForm))
    },
    onSubmit(formName) {
      if (`ordinaryUser` == this.userTableName && this.sessionForm.userAvatar != null) {
        this.sessionForm.userAvatar = this.sessionForm.userAvatar.replace(new RegExp(this.$config.baseUrl, "g"), "");
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
            if (res.data.code == 0) {
              this.setSession()
              this.$message({
                message: '更新成功',
                type: 'success',
                duration: 1500
              });
            }
          });
        } else {
          return false;
        }
      });
    },
    ordinaryUseruserAvatarHandleAvatarSuccess(fileUrls) {
      this.sessionForm.userAvatar = fileUrls;
    },
    chongzhi() {
      if (this.chongzhiForm.money == '') {
        this.$message({
          message: '请输入充值金额',
          type: 'error',
          duration: 1500
        });
        return;
      }
      if (this.chongzhiForm.radio == '') {
        this.$message({
          message: '请选择支付方式',
          type: 'error',
          duration: 1500
        });
        return;
      }

      if (this.chongzhiForm.radio === "支付宝支付") {
        // 调用支付宝支付接口
        const orderId = 'CZ' + new Date().getTime(); // 充值订单号
        this.$http.post('/springboottvfo8kua/api/alipay/createQrCodeOrder', {
          orderId: orderId,
          amount: this.chongzhiForm.money,
          subject: "账户充值"
        }, {
          headers: {
            'Token': localStorage.getItem('frontToken')
          }
        }).then(async res => {
          if (res.data && res.data.code === 0 && res.data.data) {
            // 生成二维码
            const qrCodeUrl = await this.generateQRCode(res.data.data);
            if (!qrCodeUrl) {
              return;
            }
            // 显示支付二维码弹窗
            this.$confirm('', '支付宝扫码支付', {
              dangerouslyUseHTMLString: true,
              message: `
                <div style="text-align: center;">
                  <img src="${qrCodeUrl}" style="width: 200px; height: 200px;"/>
                  <p style="margin: 10px 0;">请使用支付宝扫描二维码完成支付</p>
                  <p style="margin: 5px 0;">支付金额：￥${this.chongzhiForm.money}</p>
                </div>
              `,
              confirmButtonText: '已完成支付',
              cancelButtonText: '取消支付',
              center: true,
              showClose: false,
              closeOnClickModal: false
            }).then(() => {
              // 检查支付状态
              this.checkPayStatus(orderId, () => {
                // 支付成功后更新用户余额
                if (!this.sessionForm.money) {
                  this.sessionForm.money = parseFloat(this.chongzhiForm.money);
                } else {
                  this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
                }
                
                this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
                  if (res.data.code == 0) {
                    this.setSession();
                    this.$message({
                      message: '充值成功',
                      type: 'success',
                      duration: 1500,
                      onClose: () => {
                        this.dialogFormVisibleMoney = false;
                      }
                    });
                  }
                });
              });
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '取消支付'
              });
            });
          } else {
            this.$message.error(res.data.msg || '获取支付二维码失败');
          }
        }).catch(error => {
          console.error('支付接口调用失败:', error);
          if (error.response) {
            this.$message.error(`支付接口调用失败: ${error.response.status} - ${error.response.data?.msg || '未知错误'}`);
          } else if (error.request) {
            this.$message.error('无法连接到支付服务器，请检查网络连接');
          } else {
            this.$message.error('支付请求配置错误，请稍后重试');
          }
        });
      } else {
        // 其他支付方式的处理逻辑
        if (!this.sessionForm.money) {
          this.sessionForm.money = parseFloat(this.chongzhiForm.money);
        } else {
          this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
        }

        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.setSession();
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      }
    },
    chongzhivip() {
      this.chongzhiForm.money == 199;
      if (this.chongzhiForm.radio == '') {
        this.$message({
          message: '请选择支付方式',
          type: 'error',
          duration: 1500
        });
        return;
      }
      if (this.sessionForm.vip == '是') {
        this.$message({
          message: '您已是我们的尊贵会员。',
          type: 'success',
          duration: 1500
        });
        return;
      }

      this.sessionForm.vip = "是"
      this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
        if (res.data.code == 0) {
          this.setSession()
          this.$message({
            message: '会员购买成功',
            type: 'success',
            duration: 1500,
            onClose: () => {
              localStorage.setItem('vip', this.sessionForm.vip);
              this.dialogFormVisibleVip = false;
            }
          });
        }
      });
    },
    handleClick(tab, event) {
      switch (event.target.outerText) {
        case '个人中心':
          tab.$router.push('/index/center');
          break;
        case '修改密码':
          this.passwordForm = {
            password: '',
            newpassword: '',
            repassword: '',
          }
          this.$forceUpdate()
          break;
        case '我的发布':
          tab.$router.push('/index/myForumList');
          break;
        case '我的订单':
          tab.$router.push('/index/shop-order/order');
          break;
        case '我的地址':
          tab.$router.push('/index/shop-address/list');
          break;
        case '我的收藏':
          localStorage.setItem('favoritesType', 1);
          tab.$router.push('/index/favorites');
          break;
        default:
          tab.$router.push(`/index/${tab.name}?centerType=1`);
      }

      this.title = event.target.outerText;
    },
    async updatePassword() {
      this.$refs["passwordForm"].validate(async valid => {
        if (valid) {
          var password = "";
          if (this.sessionForm.password) {
            password = this.sessionForm.password;
          } else if (this.sessionForm.password) {
            password = this.sessionForm.password;
          }
          if (this.passwordForm.password != password) {
            this.$message.error("原密码错误");
            return;
          }
          if (this.passwordForm.newpassword != this.passwordForm.repassword) {
            this.$message.error("两次密码输入不一致");
            return;
          }
          if (this.passwordForm.newpassword == this.passwordForm.password) {
            this.$message.error("新密码与原密码相同！");
            return;
          }
          if (this.userTableName == 'ordinaryUser') {
          }
          this.sessionForm.password = this.passwordForm.newpassword;
          this.sessionForm.password = this.passwordForm.newpassword;
          this.$http.post(`${this.userTableName}/update`, this.sessionForm).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: "修改密码成功,下次登录系统生效",
                type: "success",
                duration: 1500,
                onClose: () => {
                }
              });
              this.setSession()
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      })
    },
    logout() {
      localStorage.clear();
      Vue.http.headers.common['Token'] = "";
      this.$router.push('/index/home');
      this.activeIndex = '0'
      localStorage.setItem('keyPath', this.activeIndex)
      this.$forceUpdate()
      this.$message({
        message: '登出成功',
        type: 'success',
        duration: 1500,
      });
    },
    hasBack(name) {
      switch (name) {
        case '订单管理':
          return false
          break;
        case '我的收藏管理':
          return false
          break;
        default:
          return true
      }
    },
    // 检查支付状态
    checkPayStatus(orderId, callback) {
      let checkCount = 0;
      const maxChecks = 60; // 最多检查60次
      const checkInterval = 3000; // 每3秒检查一次
      let timer = null;
      
      const check = () => {
        this.$http.get(`/springboottvfo8kua/api/alipay/checkPayStatus/${orderId}`, {
          headers: {
            'Token': localStorage.getItem('frontToken')
          }
        }).then(res => {
          if (res.data && res.data.code === 0) {
            const status = res.data.data.status;
            if (status === 'TRADE_SUCCESS' || status === 'TRADE_FINISHED') {
              if (timer) {
                clearInterval(timer);
                timer = null;
              }
              callback && callback();
            } else if (status === 'WAIT_BUYER_PAY') {
              // 等待支付，继续轮询
              if (checkCount >= maxChecks) {
                if (timer) {
                  clearInterval(timer);
                  timer = null;
                }
                this.$message.error('支付超时，请重新尝试');
              }
              checkCount++;
            } else {
              if (timer) {
                clearInterval(timer);
                timer = null;
              }
              this.$message.error('支付失败：' + status);
            }
          } else {
            console.error('查询支付状态失败:', res.data.msg);
          }
        }).catch(error => {
          console.error('支付状态查询失败:', error);
          if (error.response) {
            this.$message.error(`支付状态查询失败: ${error.response.status} - ${error.response.data?.msg || '未知错误'}`);
          } else if (error.request) {
            this.$message.error('无法连接到支付服务器，请检查网络连接');
          } else {
            this.$message.error('支付状态查询失败，请稍后重试');
          }
        });
      };
      
      // 立即执行一次检查
      check();
      // 开始定时检查
      timer = setInterval(check, checkInterval);
    },
    async generateQRCode(text) {
      try {
        // 生成二维码的DataURL
        const url = await QRCode.toDataURL(text, {
          width: 200,
          margin: 2,
          color: {
            dark: '#000000',
            light: '#ffffff'
          }
        });
        return url;
      } catch (err) {
        console.error('二维码生成失败:', err);
        this.$message.error('二维码生成失败，请重试');
        return '';
      }
    },
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.center-preview {

  .el-tabs {
    & /deep/ .el-tabs__header {
      .el-tabs__nav {
        overflow: auto;
      }

      ::-webkit-scrollbar {
        -webkit-appearance: none;
        width: 6px;
        height: 6px;
      }

      ::-webkit-scrollbar-track {
        background: rgba(0, 0, 0, 0.1);
        border-radius: 0;
      }

      ::-webkit-scrollbar-thumb {
        cursor: pointer;
        border-radius: 5px;
        background: rgba(0, 0, 0, 0.15);
        transition: color 0.2s ease;
      }

      ::-webkit-scrollbar-thumb:hover {
        background: rgba(0, 0, 0, 0.3);
      }

      .el-tabs__nav-wrap {
        margin: 0;

        &::after {
          content: none;
        }
      }

      .el-tabs__active-bar {
        display: none !important;
      }
    }

    .center-preview-pv {
      .el-date-editor.el-input {
        width: auto;
      }

      .balance {
        .el-input {
          width: auto;
        }
      }
    }
  }
}

.center-preview .el-tabs /deep/ .el-tabs__header {
  padding: 0 0 60px;
  margin: 0;
  background: #8E4033;
  display: flex;
  width: 100%;
  border-color: #eee;
  border-width: 0;
  justify-content: center;
  position: relative;
  float: left;
  border-style: solid;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  padding: 0 30px;
  margin: 0 10px;
  color: #fff;
  background: none;
  font-weight: 500;
  display: inline-block;
  font-size: 15px;
  line-height: 120px;
  position: relative;
  text-align: center;
  height: 120px;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  padding: 0 30px;
  margin: 0 10px;
  color: #fff;
  background: #FFC174;
  font-weight: 500;
  display: inline-block;
  font-size: 15px;
  line-height: 120px;
  position: relative;
  text-align: center;
  height: 120px;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  padding: 0 30px;
  margin: 0 10px;
  color: #fff;
  background: #FFC174;
  font-weight: 500;
  display: inline-block;
  font-size: 15px;
  line-height: 120px;
  position: relative;
  text-align: center;
  height: 120px;
}

.center-preview .el-tabs /deep/ .el-tabs__content {
  border-radius: 30px;
  padding: 20px;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  margin: -60px auto 0;
  background: #fff;
  width: 80%;
}

.center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  width: 100%;
}

.center-preview-pv .el-form-item /deep/ .el-form-item__label {
  padding: 0 10px 0 0;
  color: #000;
  font-weight: 500;
  width: 80px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.center-preview-pv .el-form-item .el-form-item__content {
  margin-left: 80px;
}

.center-preview-pv .el-input /deep/ .el-input__inner {
  border: 1px solid #E2E3E5;
  border-radius: 0;
  padding: 0 12px;
  box-shadow: none;
  outline: none;
  color: #000;
  width: 500px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv .el-select /deep/ .el-input__inner {
  border: 1px solid #E2E3E5;
  border-radius: 0;
  padding: 0 12px;
  box-shadow: none;
  outline: none;
  color: #000;
  width: 500px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv .el-date-editor /deep/ .el-input__inner {
  border: 1px solid #E2E3E5;
  border-radius: 0;
  padding: 0 10px 0 30px;
  box-shadow: none;
  outline: none;
  color: #000;
  width: 500px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv /deep/ .avatar-uploader-icon {
  border: 1px solid #E2E3E5;
  cursor: pointer;
  border-radius: 6px;
  color: #000;
  width: 100px;
  font-size: 32px;
  line-height: 100px;
  text-align: center;
  height: 100px;
}

.center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  border: 1px solid #E2E3E5;
  border-radius: 4px;
  padding: 0 12px;
  box-shadow: none;
  outline: none;
  color: #000;
  display: inline-block;
  width: 390px;
  font-size: 14px;
  height: 40px;
}
</style>
