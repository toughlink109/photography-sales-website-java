<template>
<div :style='{"width":"100%","padding":"0 10%","margin":"10px auto","position":"relative","background":"none"}'>
    <el-form
	  :style='{"width":"100%","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","padding":"20px","position":"relative","borderRadius":"30px","background":"#fff"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="设备编号" prop="equipmentId">
            <el-input v-model="ruleForm.equipmentId"
                placeholder="设备编号" clearable :disabled=" false  ||ro.equipmentId"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="设备名称" prop="equipmentName">
            <el-input v-model="ruleForm.equipmentName"
                placeholder="设备名称" clearable :disabled=" false  ||ro.equipmentName"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="型号" prop="model">
            <el-input v-model="ruleForm.model"
                placeholder="型号" clearable :disabled=" false  ||ro.model"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="品牌" prop="brand">
            <el-input v-model="ruleForm.brand"
                placeholder="品牌" clearable :disabled=" false  ||ro.brand"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="小时租金" prop="rentalHourlyRate">
			<el-input-number v-model="ruleForm.rentalHourlyRate" placeholder="小时租金" :disabled="ro.rentalHourlyRate"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="数量" prop="quantity">
            <el-input v-model.number="ruleForm.quantity"
                placeholder="数量" clearable :disabled=" false  ||ro.quantity"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="租用时长" prop="rentalDuration">
            <el-input v-model.number="ruleForm.rentalDuration"
                placeholder="租用时长" clearable :disabled=" false  ||ro.rentalDuration"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="总金额" prop="amount">
              <el-input v-model="amount" placeholder="总金额" disabled></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="账号" prop="account">
            <el-input v-model="ruleForm.account"
                placeholder="账号" clearable :disabled=" false  ||ro.account"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="姓名" prop="realName">
            <el-input v-model="ruleForm.realName"
                placeholder="姓名" clearable :disabled=" false  ||ro.realName"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="下单时间" prop="orderTime">
              <el-date-picker
				  :disabled=" false  ||ro.orderTime"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.orderTime"
                  type="datetime"
                  placeholder="下单时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="用途说明" prop="usageNote">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="用途说明"
              v-model="ruleForm.usageNote">
            </el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#FFC174","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#0B4D49","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				equipmentId : false,
				equipmentName : false,
				model : false,
				brand : false,
				usageNote : false,
				rentalHourlyRate : false,
				quantity : false,
				rentalDuration : false,
				amount : false,
				account : false,
				realName : false,
				orderTime : false,
				isApproved : false,
				approvedComments : false,
				payStatus : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          equipmentId: '',
          equipmentName: '',
          model: '',
          brand: '',
          usageNote: '',
          rentalHourlyRate: '',
          quantity: '',
          rentalDuration: '',
          amount: '',
          account: '',
          realName: '',
          orderTime: '',
          payStatus: '',
        },


        rules: {
          equipmentId: [
          ],
          equipmentName: [
          ],
          model: [
          ],
          brand: [
          ],
          usageNote: [
          ],
          rentalHourlyRate: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          quantity: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          rentalDuration: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          amount: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          account: [
          ],
          realName: [
          ],
          orderTime: [
          ],
          isApproved: [
          ],
          approvedComments: [
          ],
          payStatus: [
          ],
        },
		centerType: false,
      };
    },
    computed: {


        amount:{
            get: function () {
                return 1*this.ruleForm.rentalHourlyRate*this.ruleForm.quantity*this.ruleForm.rentalDuration
            }
        },

    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.orderTime = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='equipmentId'){
              this.ruleForm.equipmentId = obj[o];
              this.ro.equipmentId = true;
              continue;
            }
            if(o=='equipmentName'){
              this.ruleForm.equipmentName = obj[o];
              this.ro.equipmentName = true;
              continue;
            }
            if(o=='model'){
              this.ruleForm.model = obj[o];
              this.ro.model = true;
              continue;
            }
            if(o=='brand'){
              this.ruleForm.brand = obj[o];
              this.ro.brand = true;
              continue;
            }
            if(o=='usageNote'){
              this.ruleForm.usageNote = obj[o];
              this.ro.usageNote = true;
              continue;
            }
            if(o=='rentalHourlyRate'){
              this.ruleForm.rentalHourlyRate = obj[o];
              this.ro.rentalHourlyRate = true;
              continue;
            }
            if(o=='quantity'){
              this.ruleForm.quantity = obj[o];
              this.ro.quantity = true;
              continue;
            }
            if(o=='rentalDuration'){
              this.ruleForm.rentalDuration = obj[o];
              this.ro.rentalDuration = true;
              continue;
            }
            if(o=='amount'){
              this.ruleForm.amount = obj[o];
              this.ro.amount = true;
              continue;
            }
            if(o=='account'){
              this.ruleForm.account = obj[o];
              this.ro.account = true;
              continue;
            }
            if(o=='realName'){
              this.ruleForm.realName = obj[o];
              this.ro.realName = true;
              continue;
            }
            if(o=='orderTime'){
              this.ruleForm.orderTime = obj[o];
              this.ro.orderTime = true;
              continue;
            }
          }
            this.ruleForm.quantity = 0;
            this.ro.quantity = false;
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.account!=''&&json.account) || json.account==0){
                this.ruleForm.account = json.account;
				this.ro.account = true;
            }
            if((json.realName!=''&&json.realName) || json.realName==0){
                this.ruleForm.realName = json.realName;
				this.ro.realName = true;
            }
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`equipmentRental/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
		this.ruleForm.payStatus = '未支付'
			this.ruleForm.amount = this.amount
			if(!this.ruleForm.quantity){
				this.$message.error("数量不能为空");
				return
			}
			var obj = JSON.parse(localStorage.getItem('crossObj'));
			var table = localStorage.getItem('crossTable');
			obj.quantity = obj.quantity - this.ruleForm.quantity
			if(obj.quantity<0){
				this.$message.error("数量不足");
				return
			}
			//this.$http.post(table+`/update`, obj).then(res => {});
			//更新跨表属性
			var crossUserId;
			var crossRefId;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossUserId=Number(localStorage.getItem('frontUserId'));
								crossRefId=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossRefId && crossUserId) {
						this.ruleForm.crossUserId=crossUserId;
						this.ruleForm.crossRefId=crossRefId;
						var params = {
							page: 1,
							limit: 10,
							crossUserId:crossUserId,
							crossRefId:crossRefId,
						}
						this.$http.get('equipmentRental/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								var table = localStorage.getItem('crossTable');

								obj.quantity = parseFloat(obj.quantity) - parseFloat(this.ruleForm.quantity)

								this.$http.post(table+`/update`,obj).then(res => {});
								this.$http.post(`equipmentRental/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {
						var obj = JSON.parse(localStorage.getItem('crossObj'));
						var table = localStorage.getItem('crossTable');

						obj.quantity = parseFloat(obj.quantity) - parseFloat(this.ruleForm.quantity)

						this.$http.post(table+`/update`,obj).then(res => {});
						this.$http.post(`equipmentRental/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}

	.add-update-preview .el-input /deep/ .el-input__inner {
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
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
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
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}

	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 40px;
	}

	.add-update-preview .el-date-editor /deep/ .el-input__inner {
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

	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}

	.add-update-preview /deep/ .upload .upload-img {
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

	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
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

	.add-update-preview /deep/ .el-upload .el-icon-plus {
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

	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 4px;
	  padding: 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
