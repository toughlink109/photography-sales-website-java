<template>
<div>
	<div :style='{"border":"5px solid #FFC174","width":"80%","padding":"25px 30px","margin":"10px auto","borderRadius":"30px","background":"linear-gradient(180deg, #10615F 0%, #0A4742 100%)"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/equipmentRental"><a>{{item.name}}</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"border":"5px solid #FFC174","width":"80%","padding":"25px 30px","margin":"10px auto","borderRadius":"30px","background":"linear-gradient(180deg, #10615F 0%, #0A4742 100%)"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="detail-preview" :style='{"padding":"0 10%","margin":"10px auto","alignItems":"flex-start","flexWrap":"wrap","display":"flex","width":"100%","position":"relative"}'>
		<div class="attr" :style='{"border":"5px solid #FFC174","padding":"10px","borderRadius":"30px","background":"#fff","display":"flex","width":"45%","position":"relative","order":"2"}'>

			<div class="info" :style='{"padding":"0","margin":"0","background":"#fff","flex":"1"}'>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"flex-start","background":"#fff","justifyContent":"space-between","display":"flex"}'>
					<div :style='{"color":"#000","fontSize":"16px","fontWeight":"bold"}'>
                    </div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>设备编号</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.equipmentId}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>设备名称</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.equipmentName}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>型号</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.model}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>品牌</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.brand}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>用途说明</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.usageNote}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>小时租金</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.rentalHourlyRate}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>数量</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.quantity}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>租用时长</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.rentalDuration}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>总金额</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.amount}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>账号</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.account}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>姓名</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.realName}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>下单时间</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.orderTime}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}' v-if="centerType">
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>是否支付</div>
					<div  :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.payStatus=='已支付'?'已支付':'未支付'}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}' v-if="centerType">
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>审核状态</div>
					<div :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.isApproved=='是'?'通过':(detail.isApproved=='否'?'不通过':'待审核')}}</div>
				</div>
				<div class="item" :style='{"padding":"10px","margin":"0 0 10px 0","background":"#fff","justifyContent":"spaceBetween","display":"flex"}' v-if="centerType">
					<div class="lable" :style='{"width":"102px","padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","textAlign":"right"}'>审核回复</div>
					<div :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#818181","flex":"1","height":"auto"}'>{{detail.approvedComments}}</div>
				</div>
				<div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('equipmentRental','修改')&&detail.isApproved!='是'&&detail.isApproved!='否' " @click="editClick">修改</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('equipmentRental','删除')" @click="delClick">删除</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('equipmentRental','私聊')&&detail.id!=mid" @click="chatClick">联系TA</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('equipmentRental','设备归还')" @click="onAcross('equipmentReturns','是','','','')" type="warning">设备归还</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('equipmentRental','审核') && (detail.isApproved=='待审核'||!detail.isApproved)" @click="onSH" type="warning">审核</el-button>
					<el-button v-if="centerType&&(detail.payStatus=='未支付'||!detail.payStatus)&&btnAuth('equipmentRental','支付')" :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="warning" size="small" @click="payClick">支付</el-button>
				</div>
			</div>
		</div>

			<div class="swiper3" v-if="detailBanner.length" :style='{"width":"calc(55% - 20px)","padding":"0 0 60px","margin":"0 20px 0 0","background":"#fff","height":"auto","order":"1"}'>
			  <div class="big" :style='{"border":"5px solid #FFC174","margin":"0 0 10px","overflow":"hidden","borderRadius":"30px","background":"#fff","width":"100%","position":"relative","height":"400px"}'>
				<img id="big" :style='{"width":"100%","boxShadow":"none","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}' :src="swiperBigUrl" class="image">
			  </div>
			  <div class="samll" :style='{"width":"100%","padding":"0 5px","background":"#fff","display":"flex","height":"100px"}'>
			    <div :style='{"border":"5px solid #FFC174","margin":"0 5px","overflow":"hidden","borderRadius":"30px","background":"#fff","width":"25%","position":"relative","height":"100%"}' v-for="item in detailBanner" :key="item.id">
				  <img :style='{"width":"100%","boxShadow":"0 1px 8px rgba(0,0,0,.2)","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}' v-if="item.substr(0,4)=='http'" :src="item" @click="swiperClick3(item)" class="image">
				  <img :style='{"width":"100%","boxShadow":"0 1px 8px rgba(0,0,0,.2)","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}' v-else :src="baseUrl + item" @click="swiperClick3(baseUrl + item)" class="image">
			    </div>
			  </div>
			</div>





		<el-tabs class="detail" :style='{"border":"0px solid #DCDFE6","width":"100%","boxShadow":"none","background":"#FFF","order":"4"}' v-model="activeName" type="border-card">
		</el-tabs>
		<el-dialog title="审核" :visible.sync="isApprovedVisiable" width="50%">
			<el-form ref="shForm" :model="shForm" label-width="80px">
				<el-form-item label="审核状态">
					<el-select v-model="shForm.isApproved" placeholder="审核状态">
						<el-option label="通过" value="是"></el-option>
						<el-option label="不通过" value="否"></el-option>
						<el-option label="待审核" value="待审核"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="内容">
					<el-input type="textarea" :rows="8" v-model="shForm.approvedComments"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="isApprovedVisiable = false">取 消</el-button>
				<el-button type="primary" @click="shHandler">确 定</el-button>
			</div>
		</el-dialog>
	</div>
	<div class="share_view" :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","position":"fixed","right":"0","bottom":"20%","background":"#fff","zIndex":"11"}'>
	</div>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  import axios from 'axios'
  import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        tableName: 'equipmentRental',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '摄影设备租用'
          }
        ],
        title: '',
        detailBanner: [],
		userId: localStorage.getItem('frontUserId'),
		id: 0,
        detail: {},
        activeName: 'first',
        total: 1,
        pageSize: 5,
        totalPage: 1,
        quantity: 1,
        isApprovedVisiable: false,
        shForm: {
			isApproved: '是',
			approvedComments: ''
        },
		centerType: false,
		shareUrl: location.href,
		swiperBigUrl: null,
      }
    },
    created() {
		if(this.$route.query.centerType) {
			this.centerType = true
		}

        this.init();
    },
	mounted() {
	},
    //方法集合
    methods: {
		swiperClick3(src) {
			this.swiperBigUrl = src
		},
        init() {
		  this.id = this.$route.query.id
          this.baseUrl = this.$config.baseUrl;
          this.$http.get(this.tableName + '/detail/'  + this.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
				this.$forceUpdate();

				if(localStorage.getItem('frontToken')){
				}

            }
			if (this.detailBanner.length) {
				if (this.detailBanner[0].substr(0,4)=='http') {
					this.swiperBigUrl = this.detailBanner[0]
				} else {
					this.swiperBigUrl = this.baseUrl + this.detailBanner[0]
				}
			}
          });
        },
      async onAcross(acrossTable,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
		if(crossOptAudit=='是'&&this.detail.isApproved!='是') {
			this.$message({
				message: "请审核通过后再操作",
				type: "error",
				duration: 1500,
				onClose: () => {
				}
			});
			return
		}
		if(crossOptPay=='是'&&this.detail.payStatus!='已支付') {
			this.$message.error('请支付完成再操作');
			return;
		}
        localStorage.setItem('crossTable',`equipmentRental`);
        localStorage.setItem('crossObj', JSON.stringify(this.detail));
        localStorage.setItem('statusColumnName',statusColumnName);
        localStorage.setItem('statusColumnValue',statusColumnValue);
        localStorage.setItem('tips',tips);
        if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
            var obj = JSON.parse(localStorage.getItem('crossObj'));
            for (var o in obj){
                if(o==statusColumnName && obj[o]==statusColumnValue){
                    this.$message({
                        type: 'error',
                        message: tips,
                        duration: 1500
                    });
                    return
                }
            }
        }
        this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
      },
      onSH() {
        this.isApprovedVisiable = true;
      },
      shHandler(){
        this.$confirm(`确定操作?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.detail.isApproved = this.shForm.isApproved;
          this.detail.approvedComments = this.shForm.approvedComments;
          this.$http.post(`${this.tableName}/update`, this.detail).then(res => {
            if (res.data.code == 0) {
              this.isApprovedVisiable = false;
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
              });
            }
          });
        });
      },
		payClick(){
			if(this.detail.isApproved!='是'){
				this.$message.error('请审核通过后再支付')
				return false
			}
			
			// 获取用户信息和余额
			let table = localStorage.getItem("UserTableName");
			this.$http.get(table+'/session', {}).then(res => {
				if (res.data.code == 0) {
					let user = res.data.data;
					// 判断余额是否充足
					if (Number(user.money) < Number(this.detail.amount)) {
						this.$message({
							message: '余额不足，请先充值',
							type: 'error',
							duration: 1500
						});
						return;
					}
					
					// 扣除余额
					user.money = Number((Number(user.money) - Number(this.detail.amount)).toFixed(2));
					
					// 更新用户余额
					this.$http.post(table+'/update', user).then(res => {
						if (res.data.code == 0) {
							// 更新订单状态
							this.detail.payStatus = '已支付';
							this.$http.post(`${this.tableName}/update`, this.detail).then(res => {
								if (res.data.code == 0) {
									localStorage.setItem('sessionForm', JSON.stringify(user));
									this.$message({
										message: '支付成功',
										type: 'success',
										duration: 1500,
										onClose: () => {
											this.init(); // 刷新页面数据
										}
									});
								} else {
									this.$message.error(res.data.msg);
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					this.$message.error(res.data.msg);
				}
			});
		},
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
		// 返回按钮
		backClick(){
			let params = {}
			if(this.centerType){
				params.centerType = 1
			}
			this.$router.push({path: '/index/equipmentRental', query: params});
		},
		// 下载
		download(file){
			if(!file) {
				this.$message({
				  type: 'error',
				  message: '文件不存在',
				  duration: 1500,
				});
				return;
			}
		  let arr = file.replace(new RegExp('upload/', "g"), "")
		  axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: localStorage.getItem("frontToken")
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  },err=>{
			  axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
			  	headers: {
			  		token: localStorage.getItem("frontToken")
			  	},
			  	responseType: "blob"
			  }).then(({
			  	data
			  }) => {
			  	const binaryData = [];
			  	binaryData.push(data);
			  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
			  		type: 'application/pdf;chartset=UTF-8'
			  	}))
			  	const a = document.createElement('a')
			  	a.href = objectUrl
			  	a.download = arr
			  	// a.click()
			  	// 下面这个写法兼容火狐
			  	a.dispatchEvent(new MouseEvent('click', {
			  		bubbles: true,
			  		cancelable: true,
			  		view: window
			  	}))
			  	window.URL.revokeObjectURL(data)
			  })
		  })
      },


		// 权限判断
		btnAuth(tableName,key){
			if(this.centerType){
				return this.isBackAuth(tableName,key)
			}else{
				return this.isAuth(tableName,key)
			}
		},
		// 修改
		editClick(){
			this.$router.push(`/index/equipmentRentalAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		async delClick(){
			await this.$confirm('是否删除此摄影设备租用？')
			  .then(_ => {
			    this.$http.post('equipmentRental/delete', [this.detail.id]).then(async res => {
					if (res.data.code == 0) {
						this.$message({
							type: 'success',
							message: '删除成功!',
							duration: 1500,
							onClose: () => {
								history.back()
							}
						});
					}
			    });
			  }).catch(_ => {});
		},
    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}

	.detail-preview {

	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }

	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }

	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }

	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}

	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}

	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}

	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 4px 0 0 4px;
		top: 1px;
		left: 1px;
		background: #000;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}

	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #fff;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		right: 1px;
		border-radius: 0 4px 4px 0;
		top: 1px;
		background: #000;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #fff;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #000;
		border-radius: 4px;
		padding: 0 40px;
		outline: none;
		color: #666;
		background: #FFF;
		display: inline-block;
		width: 100%;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
		height: 40px;
	}

	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		border-radius: 30px;
		margin: 0;
		overflow: hidden;
		background: #0C4E49;
		border-color: #FFC174;
		border-width: 5px;
		border-style: solid;
	}

	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 0;
		padding: 0 5px;
		margin: 0 40px;
		color: #fff;
		background: transparent;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		line-height: 40px;
		position: relative;
		list-style: none;
		height: 40px;
	}

	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		border: 0;
		padding: 0 5px;
		margin: 0 40px;
		color: #fff;
		background: #FFC174;
	}

	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		padding: 0 5px;
		margin: 0 40px;
		color: #fff;
		background: #FFC174;
	}

	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}

	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		display: none;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}

	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
	}

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 15px;
		color: #FFC174;
		font-weight: 500;
	}

	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #FFC174;
		display: inline-block;
	}

	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #FFC174;
		display: inline-block;
	}

	.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
		color: #FFC174;
		display: inline-block;
	}

	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0 10px;
		margin: 0 5px;
		color: #fff;
		background: #0D5451;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0 10px;
		margin: 0 5px;
		color: #fff;
		background: #FFC174;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0 10px;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0 10px;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}

	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #000;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #CBCBCB;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #FFC174;
		text-align: center;
		min-width: 30px;
		height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #FFC174;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}

	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}

	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	.share_view{
		position: fixed;
		right:0;
		bottom: 20%;
		background: #fff;
		box-shadow: 0 4px 6px rgba(0,0,0,.1);
		.share{
			width: 40px;
			height: 40px;
			display: flex;
			align-items: center;
			justify-content: center;
			border-bottom: 1px solid #eee;
			cursor: pointer;
		}
		.share:last-of-type{
			border:none;
		}
	}


	.detail-preview .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}

	.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
