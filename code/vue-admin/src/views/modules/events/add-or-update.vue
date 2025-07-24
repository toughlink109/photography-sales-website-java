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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动名称" prop="activityName">
					<el-input v-model="ruleForm.activityName" placeholder="活动名称" clearable  :readonly="ro.activityName"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动名称" prop="activityName">
					<el-input v-model="ruleForm.activityName" placeholder="活动名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动时间" prop="activityTime">
					<el-input v-model="ruleForm.activityTime" placeholder="活动时间" clearable  :readonly="ro.activityTime"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动时间" prop="activityTime">
					<el-input v-model="ruleForm.activityTime" placeholder="活动时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动地点" prop="activityPlace">
					<el-input v-model="ruleForm.activityPlace" placeholder="活动地点" clearable  :readonly="ro.activityPlace"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动地点" prop="activityPlace">
					<el-input v-model="ruleForm.activityPlace" placeholder="活动地点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动目的" prop="eventLocation">
					<el-input v-model="ruleForm.eventLocation" placeholder="活动目的" clearable  :readonly="ro.eventLocation"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动目的" prop="eventLocation">
					<el-input v-model="ruleForm.eventLocation" placeholder="活动目的" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="参与人群" prop="targetAudience">
					<el-input v-model="ruleForm.targetAudience" placeholder="参与人群" clearable  :readonly="ro.targetAudience"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="参与人群" prop="targetAudience">
					<el-input v-model="ruleForm.targetAudience" placeholder="参与人群" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动内容" prop="eventContent">
					<el-input v-model="ruleForm.eventContent" placeholder="活动内容" clearable  :readonly="ro.eventContent"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动内容" prop="eventContent">
					<el-input v-model="ruleForm.eventContent" placeholder="活动内容" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="器材要求" prop="equipmentRequire">
					<el-input v-model="ruleForm.equipmentRequire" placeholder="器材要求" clearable  :readonly="ro.equipmentRequire"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="器材要求" prop="equipmentRequire">
					<el-input v-model="ruleForm.equipmentRequire" placeholder="器材要求" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="报名方式" prop="regisWay">
					<el-input v-model="ruleForm.regisWay" placeholder="报名方式" clearable  :readonly="ro.regisWay"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="报名方式" prop="regisWay">
					<el-input v-model="ruleForm.regisWay" placeholder="报名方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动规则" prop="eventRules">
					<el-input v-model="ruleForm.eventRules" placeholder="活动规则" clearable  :readonly="ro.eventRules"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动规则" prop="eventRules">
					<el-input v-model="ruleForm.eventRules" placeholder="活动规则" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="联系方式" prop="contactPhone">
					<el-input v-model="ruleForm.contactPhone" placeholder="联系方式" clearable  :readonly="ro.contactPhone"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="联系方式" prop="contactPhone">
					<el-input v-model="ruleForm.contactPhone" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="注意事项" prop="notes">
					<el-input v-model="ruleForm.notes" placeholder="注意事项" clearable  :readonly="ro.notes"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="注意事项" prop="notes">
					<el-input v-model="ruleForm.notes" placeholder="注意事项" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.coverImage" label="封面" prop="coverImage">
					<file-upload
						tip="点击上传封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.coverImage?ruleForm.coverImage:''"
						@change="coverImageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.coverImage" label="封面" prop="coverImage">
					<img v-if="ruleForm.coverImage.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.coverImage.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.coverImage.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
			</template>
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
export default {
	data() {
		return {
			id: '',
			type: '',
			
			
			ro:{
				activityName : false,
				activityTime : false,
				activityPlace : false,
				eventLocation : false,
				targetAudience : false,
				eventContent : false,
				equipmentRequire : false,
				regisWay : false,
				eventRules : false,
				contactPhone : false,
				notes : false,
				coverImage : false,
			},
			
			
			ruleForm: {
				activityName: '',
				activityTime: '',
				activityPlace: '',
				eventLocation: '',
				targetAudience: '',
				eventContent: '',
				equipmentRequire: '',
				regisWay: '',
				eventRules: '',
				contactPhone: '',
				notes: '',
				coverImage: '',
			},
		

			
			rules: {
				activityName: [
				],
				activityTime: [
				],
				activityPlace: [
				],
				eventLocation: [
				],
				targetAudience: [
				],
				eventContent: [
				],
				equipmentRequire: [
				],
				regisWay: [
				],
				eventRules: [
				],
				contactPhone: [
				],
				notes: [
				],
				coverImage: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
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
						if(o=='activityName'){
							this.ruleForm.activityName = obj[o];
							this.ro.activityName = true;
							continue;
						}
						if(o=='activityTime'){
							this.ruleForm.activityTime = obj[o];
							this.ro.activityTime = true;
							continue;
						}
						if(o=='activityPlace'){
							this.ruleForm.activityPlace = obj[o];
							this.ro.activityPlace = true;
							continue;
						}
						if(o=='eventLocation'){
							this.ruleForm.eventLocation = obj[o];
							this.ro.eventLocation = true;
							continue;
						}
						if(o=='targetAudience'){
							this.ruleForm.targetAudience = obj[o];
							this.ro.targetAudience = true;
							continue;
						}
						if(o=='eventContent'){
							this.ruleForm.eventContent = obj[o];
							this.ro.eventContent = true;
							continue;
						}
						if(o=='equipmentRequire'){
							this.ruleForm.equipmentRequire = obj[o];
							this.ro.equipmentRequire = true;
							continue;
						}
						if(o=='regisWay'){
							this.ruleForm.regisWay = obj[o];
							this.ro.regisWay = true;
							continue;
						}
						if(o=='eventRules'){
							this.ruleForm.eventRules = obj[o];
							this.ro.eventRules = true;
							continue;
						}
						if(o=='contactPhone'){
							this.ruleForm.contactPhone = obj[o];
							this.ro.contactPhone = true;
							continue;
						}
						if(o=='notes'){
							this.ruleForm.notes = obj[o];
							this.ro.notes = true;
							continue;
						}
						if(o=='coverImage'){
							this.ruleForm.coverImage = obj[o];
							this.ro.coverImage = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `events/info/${id}`,
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
	if(this.ruleForm.coverImage!=null) {
		this.ruleForm.coverImage = this.ruleForm.coverImage.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
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
					url: "events/page", 
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
								url: `events/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.eventsCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
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
				url: `events/${!this.ruleForm.id ? "save" : "update"}`,
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
							this.parent.eventsCrossAddOrUpdateFlag = false;
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
      this.parent.eventsCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    coverImageUploadChange(fileUrls) {
	    this.ruleForm.coverImage = fileUrls;
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
