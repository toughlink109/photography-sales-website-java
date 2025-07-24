<template>
  <div class="container"  :style='{"margin":"0 200px 20px"}' style="padding: 150px 0;">
    <el-alert title="确认支付前请先核对订单信息" type="success" :closable="false"></el-alert>
    <!-- <div class="top-content">
      <span>收款人</span>
      <el-input style="width:300px" v-model="name" placeholder="收款人"></el-input>
      <span style="margin-left:20px">收款账号</span>
      <el-input style="width:300px" v-model="account" placeholder="收款账号"></el-input>
    </div> -->
    <!-- <div class="price-content">
      <span>金额</span>
      <span>￥99.0</span>
    </div> -->
    <div class="pay-type-content">
      <div class="pay-type-item" v-for="(item, index) in payTypes" :key="index">
        <el-radio v-model="type" :label="item.label">
          <img :src="item.icon" :alt="item.label">
        </el-radio>
      </div>
    </div>
    <div class="buton-content">
      <el-button @click="submitTap" type="primary">确认支付</el-button>
      <el-button @click="back()">返回</el-button>
    </div>

    <!-- 支付宝二维码支付弹窗 -->
    <el-dialog
      title="支付宝扫码支付"
      :visible.sync="qrCodeDialogVisible"
      width="400px"
      :close-on-click-modal="false"
      center>
      <div class="qr-code-container">
        <div v-if="qrCodeUrl" class="qr-code">
          <img :src="qrCodeUrl" alt="支付宝支付二维码">
        </div>
        <div v-else class="loading">
          <el-loading></el-loading>
        </div>
      </div>
      <div class="qr-code-tips">
        <p>请使用支付宝扫描二维码完成支付</p>
        <p>支付完成后将自动跳转</p>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelPay">取消支付</el-button>
        <el-button type="primary" @click="checkPayStatus">已完成支付</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
// import { Message } from "element-ui";
export default {
  data() {
    return {
      name: "",
      account: "",
      type: "",
      table: "",
      obj: "",
      qrCodeDialogVisible: false,
      qrCodeUrl: "",
      payTimer: null,
      payTypes: [
        {
          label: "支付宝支付",
          icon: require("@/assets/zhifubao.png")
        },
        {
          label: "微信支付",
          icon: require("@/assets/weixin.png")
        },
        {
          label: "建设银行",
          icon: require("@/assets/jianshe.png")
        },
        {
          label: "农业银行",
          icon: require("@/assets/nongye.png")
        },
        {
          label: "中国银行",
          icon: require("@/assets/zhongguo.png")
        },
        {
          label: "交通银行",
          icon: require("@/assets/jiaotong.png")
        }
      ]
    };
  },
  mounted() {
    let table = localStorage.getItem("paytable");
    let obj = JSON.parse(localStorage.getItem("payObject"));
    this.table = table;
    this.obj = obj;
  },
  beforeDestroy() {
    this.clearPayTimer();
  },
  methods: {
    submitTap() {
      if (!this.type) {
        this.$message.error("请选择支付方式");
        return;
      }
      this.$confirm(`确定支付?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        if (this.type === "支付宝支付") {
          // 调用支付宝二维码支付接口
          this.qrCodeDialogVisible = true;
          this.qrCodeUrl = '';  // 清空之前的二维码
          
          this.$http.post('/api/alipay/createQrCode', {
            orderId: this.obj.id,
            amount: this.obj.amount,
            subject: "订单支付"
          }).then(res => {
            if (res.data && res.data.code === 0) {
              this.qrCodeUrl = res.data.qrCode;
              this.startCheckPayStatus();
            } else {
              this.$message.error(res.data.msg);
              this.qrCodeDialogVisible = false;
            }
          });
        } else {
          // 其他支付方式的处理逻辑
          this.obj.payStatus = "已支付";
          this.$http.post(`${this.table}/update`,this.obj).then(res => {
            if (res.data && res.data.code === 0) {
              this.$message({
                message: "支付成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.$router.go(-1);
                }
              });
            } else {
              this.$message.error(res.data.msg);
            }
          });
        }
      });
    },
    startCheckPayStatus() {
      this.clearPayTimer();
      // 每3秒检查一次支付状态
      this.payTimer = setInterval(() => {
        this.checkPayStatus();
      }, 3000);
    },
    checkPayStatus() {
      this.$http.get(`${this.table}/info/${this.obj.id}`).then(res => {
        if (res.data && res.data.code === 0) {
          if (res.data.data.payStatus === "已支付") {
            this.clearPayTimer();
            this.qrCodeDialogVisible = false;
            this.$message({
              message: "支付成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.$router.go(-1);
              }
            });
          }
        }
      });
    },
    cancelPay() {
      this.clearPayTimer();
      this.qrCodeDialogVisible = false;
    },
    clearPayTimer() {
      if (this.payTimer) {
        clearInterval(this.payTimer);
        this.payTimer = null;
      }
    },
    back() {
      this.clearPayTimer();
      this.$router.go(-1);
    }
  }
};
</script>
<style lang="scss" scoped>
.container {
  margin: 10px;
  font-size: 14px;
  span {
    width: 60px;
  }
  .top-content {
    display: flex;
    align-items: center;
    padding: 20px;
  }
  .price-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    padding-bottom: 20px;
    padding: 20px;
    border-bottom: 1px solid #eeeeee;
    font-size: 20px;
    font-weight: bold;
    color: red;
  }
  .pay-type-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    flex-wrap: wrap;
    span {
      width: 100px;
    }
    .pay-type-item {
      display: flex;
      align-items: center;
      width: 300px;
      margin: 20px;
      border: 1px solid #eeeeee;
      padding: 20px;
      cursor: pointer;

      img {
        height: 40px;
        margin-left: 10px;
      }
    }
  }
  .buton-content {
    margin: 20px;
  }
  .qr-code-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 300px;
    .qr-code {
      text-align: center;
      
      img {
        width: 200px;
        height: 200px;
      }
    }
  }
  .qr-code-tips {
    text-align: center;
    margin: 20px 0;
    color: #666;
    p {
      margin: 5px 0;
    }
  }
}
</style>
