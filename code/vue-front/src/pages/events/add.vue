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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动名称" prop="activityName">
            <el-input v-model="ruleForm.activityName" 
                placeholder="活动名称" clearable :disabled=" false  ||ro.activityName"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动时间" prop="activityTime">
            <el-input v-model="ruleForm.activityTime" 
                placeholder="活动时间" clearable :disabled=" false  ||ro.activityTime"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动地点" prop="activityPlace">
            <el-input v-model="ruleForm.activityPlace" 
                placeholder="活动地点" clearable :disabled=" false  ||ro.activityPlace"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动目的" prop="eventLocation">
            <el-input v-model="ruleForm.eventLocation" 
                placeholder="活动目的" clearable :disabled=" false  ||ro.eventLocation"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="参与人群" prop="targetAudience">
            <el-input v-model="ruleForm.targetAudience" 
                placeholder="参与人群" clearable :disabled=" false  ||ro.targetAudience"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动内容" prop="eventContent">
            <el-input v-model="ruleForm.eventContent" 
                placeholder="活动内容" clearable :disabled=" false  ||ro.eventContent"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="器材要求" prop="equipmentRequire">
            <el-input v-model="ruleForm.equipmentRequire" 
                placeholder="器材要求" clearable :disabled=" false  ||ro.equipmentRequire"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="报名方式" prop="regisWay">
            <el-input v-model="ruleForm.regisWay" 
                placeholder="报名方式" clearable :disabled=" false  ||ro.regisWay"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动规则" prop="eventRules">
            <el-input v-model="ruleForm.eventRules" 
                placeholder="活动规则" clearable :disabled=" false  ||ro.eventRules"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="联系方式" prop="contactPhone">
            <el-input v-model="ruleForm.contactPhone" 
                placeholder="联系方式" clearable :disabled=" false  ||ro.contactPhone"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="注意事项" prop="notes">
            <el-input v-model="ruleForm.notes" 
                placeholder="注意事项" clearable :disabled=" false  ||ro.notes"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="封面" v-if="type!='cross' || (type=='cross' && !ro.coverImage)" prop="coverImage">
            <file-upload
            tip="点击上传封面"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.coverImage?ruleForm.coverImage:''"
            @change="coverImageUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' class="upload" v-else label="封面" prop="coverImage">
                <img v-if="ruleForm.coverImage.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.coverImage.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.coverImage.split(',')" :src="baseUrl+item" width="100" height="100">
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
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
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
        },
		centerType: false,
      };
    },
    computed: {



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
              this.ruleForm.coverImage = obj[o].split(",")[0];
              this.ro.coverImage = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
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
        this.$http.get(`events/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
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
						this.$http.get('events/list', {
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


								this.$http.post(`events/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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


						this.$http.post(`events/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
      coverImageUploadChange(fileUrls) {
          this.ruleForm.coverImage = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
