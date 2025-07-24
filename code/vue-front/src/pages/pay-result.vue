<template>
  <div class="container">
    <el-result
      icon="success"
      title="支付成功"
      sub-title="您的订单已支付成功，请等待商家处理"
    >
      <template slot="extra">
        <el-button type="primary" @click="goBack">返回</el-button>
      </template>
    </el-result>
  </div>
</template>

<script>
export default {
  methods: {
    goBack() {
      this.$router.go(-1);
    }
  }
}
</script>

<style scoped>
.container {
  padding: 20px;
  text-align: center;
}
</style> 