<template>
	<div class="addEdit-block" :style='{"padding":"30px","margin":"0"}'>
		<el-form
			:style='{"border":"1px solid rgba(167, 180, 201,.3)  ","padding":"30px","borderRadius":"6px","background":"#fff"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="设备编号" prop="equipmentId">
					<el-input v-model="ruleForm.equipmentId" placeholder="设备编号" clearable  :readonly="ro.equipmentId"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="设备编号" prop="equipmentId">
					<el-input v-model="ruleForm.equipmentId" placeholder="设备编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="设备名称" prop="equipmentName">
					<el-input v-model="ruleForm.equipmentName" placeholder="设备名称" clearable  :readonly="ro.equipmentName"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="设备名称" prop="equipmentName">
					<el-input v-model="ruleForm.equipmentName" placeholder="设备名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="型号" prop="model">
					<el-input v-model="ruleForm.model" placeholder="型号" clearable  :readonly="ro.model"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="型号" prop="model">
					<el-input v-model="ruleForm.model" placeholder="型号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="品牌" prop="brand">
					<el-input v-model="ruleForm.brand" placeholder="品牌" clearable  :readonly="ro.brand"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="品牌" prop="brand">
					<el-input v-model="ruleForm.brand" placeholder="品牌" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="小时租金" prop="rentalHourlyRate">
					<el-input-number v-model="ruleForm.rentalHourlyRate" placeholder="小时租金" :disabled="ro.rentalHourlyRate"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="小时租金" prop="rentalHourlyRate">
					<el-input v-model="ruleForm.rentalHourlyRate" placeholder="小时租金" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="数量" prop="quantity">
					<el-input v-model.number="ruleForm.quantity" placeholder="数量" clearable  :readonly="ro.quantity"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="数量" prop="quantity">
					<el-input v-model="ruleForm.quantity" placeholder="数量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="租用时长" prop="rentalDuration">
					<el-input v-model.number="ruleForm.rentalDuration" placeholder="租用时长" clearable  :readonly="ro.rentalDuration"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="租用时长" prop="rentalDuration">
					<el-input v-model="ruleForm.rentalDuration" placeholder="租用时长" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="总金额" prop="amount">
					<el-input v-model="amount" placeholder="总金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.amount" label="总金额" prop="amount">
					<el-input v-model="ruleForm.amount" placeholder="总金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="账号" prop="account">
					<el-input v-model="ruleForm.account" placeholder="账号" clearable  :readonly="ro.account"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="账号" prop="account">
					<el-input v-model="ruleForm.account" placeholder="账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="姓名" prop="realName">
					<el-input v-model="ruleForm.realName" placeholder="姓名" clearable  :readonly="ro.realName"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="姓名" prop="realName">
					<el-input v-model="ruleForm.realName" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="下单时间" prop="orderTime">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.orderTime"
						type="datetime"
						:readonly="ro.orderTime"
						placeholder="下单时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.orderTime" label="下单时间" prop="orderTime">
					<el-input v-model="ruleForm.orderTime" placeholder="下单时间" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="用途说明" prop="usageNote">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="用途说明"
					  v-model="ruleForm.usageNote" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.usageNote" label="用途说明" prop="usageNote">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}'>{{ruleForm.usageNote}}</span>
				</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao20" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao16" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui21" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>


  </div>
</template>
<script>
import {
	isNumber,
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',


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
				approvedComments: '',
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
					{ validator: validateNumber, trigger: 'blur' },
				],
				quantity: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				rentalDuration: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				amount: [
					{ validator: validateNumber, trigger: 'blur' },
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
			}
		};
	},
	props: ["parent"],
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
		this.ruleForm.orderTime = this.getCurDateTime()
	},
	methods: {

		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
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
				this.ruleForm.quantity = 0
				this.ro.quantity = false;
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(((json.account!=''&&json.account) || json.account==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.account = json.account
						this.ro.account = true;
					}
					if(((json.realName!=''&&json.realName) || json.realName==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.realName = json.realName
						this.ro.realName = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});

		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `equipmentRental/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
		this.ruleForm.payStatus = '未支付'
        this.ruleForm.amount = this.amount
var objcross = this.$storage.getObj('crossObj');
      var table = this.$storage.getObj('crossTable');
      if(objcross!=null) {
		  if(!this.ruleForm.quantity){
			  this.$message.error("数量不能为空");
			  return
		  }
	      objcross.quantity = objcross.quantity - this.ruleForm.quantity
	      if(objcross.quantity<0){
				this.$message.error("数量不足");
				return
	      }
                }
      //更新跨表属性
       var crossUserId;
       var crossRefId;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                              this.$http({
                                  url: `${table}/update`,
                                  method: "post",
                                  data: objcross
                                }).then(({ data }) => {});
                       } else {
                               crossUserId=this.$storage.get('userId');
                               crossRefId=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossRefId && crossUserId) {
					this.ruleForm.crossUserId = crossUserId;
					this.ruleForm.crossRefId = crossRefId;
					let params = {
						page: 1,
						limit: 10,
						crossUserId:this.ruleForm.crossUserId,
						crossRefId:this.ruleForm.crossRefId,
					}
				this.$http({
					url: "equipmentRental/page",
					method: "get",
					params: params
				}).then(({
					data
				}) => {
					if (data && data.code === 0) {
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `equipmentRental/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.EquipmentRentalCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
									this.$http({
										url: `${table}/update`,
										method: "post",
										data: objcross
									}).then(({ data }) => {});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else {
				}
			});
		} else {
			this.$http({
				url: `equipmentRental/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$http({
						url: `${table}/update`,
						method: "post",
						data: objcross
					}).then(({ data }) => {});
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.EquipmentRentalCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.EquipmentRentalCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}

	.search-box {
		position: absolute;
	}

	.el-date-editor.el-input {
		width: auto;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #374254;
	  	  white-space: nowrap;
	  	  font-weight: 600;
	  	  width: 180px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}

	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}

	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid rgba(167, 180, 201,.3);
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #a7b4c9;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 1px solid rgba(167, 180, 201,.3);
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #a7b4c9;
	  	  width: 400px;
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
	  	  border:  1px solid rgba(167, 180, 201,.3) ;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #a7b4c9;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}

	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border:  1px solid rgba(167, 180, 201,.3) ;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #a7b4c9;
	  	  width: 400px;
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
	  	  border: 2px dashed rgba(167, 180, 201,.3) ;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #a7b4c9  ;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}

	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed rgba(167, 180, 201,.3) ;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #a7b4c9  ;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}

	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed rgba(167, 180, 201,.3) ;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #a7b4c9  ;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}

	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid rgba(167, 180, 201,.3)     ;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #a7b4c9 ;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}

	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6574cd;
				width: auto;
				font-size: 14px;
				height: 40px;
			}

	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6574cd;
				width: auto;
				font-size: 14px;
				height: 40px;
			}

	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #ff2b88;
				width: auto;
				font-size: 14px;
				height: 40px;
			}

	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #ff2b88;
				width: auto;
				font-size: 14px;
				height: 40px;
			}

	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #ff2b88;
				width: auto;
				font-size: 14px;
				height: 40px;
			}

	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
