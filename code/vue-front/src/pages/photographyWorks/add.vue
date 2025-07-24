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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="作品名称" prop="workName">
            <el-input v-model="ruleForm.workName" 
                placeholder="作品名称" clearable :disabled=" false  ||ro.workName"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'  label="作品分类" prop="workCategory">
            <el-select v-model="ruleForm.workCategory" placeholder="请选择作品分类" :disabled=" false  ||ro.workCategory" >
              <el-option
                  v-for="(item,index) in workCategoryOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="拍摄时间" prop="shotTime">
              <el-date-picker
				  :disabled=" false  ||ro.shotTime"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.shotTime" 
                  type="datetime"
                  placeholder="拍摄时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="拍摄地点" prop="shotLocation">
            <el-input v-model="ruleForm.shotLocation" 
                placeholder="拍摄地点" clearable :disabled=" false  ||ro.shotLocation"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="发布日期" prop="publishDate">
              <el-date-picker
				  :disabled=" false  ||ro.publishDate"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.publishDate" 
                  type="date"
                  placeholder="发布日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="单限" prop="limitOne">
            <el-input v-model.number="ruleForm.limitOne" 
                placeholder="单限" clearable :disabled=" false  ||ro.limitOne"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="库存" prop="goodsStocks">
            <el-input v-model.number="ruleForm.goodsStocks" 
                placeholder="库存" clearable :disabled=" false  ||ro.goodsStocks"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="投票票数" prop="voteCount">
            <el-input v-model.number="ruleForm.voteCount" 
                placeholder="投票票数" clearable :disabled=" false  ||ro.voteCount"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="价格" prop="price">
			<el-input-number v-model="ruleForm.price" placeholder="价格" :disabled="ro.price"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="作品内容" prop="workContent">
            <editor 
                :style='{"padding":"0","boxShadow":"none","margin":"0","borderColor":"#E2E3E5","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.workContent" 
                class="editor" 
                action="file/upload">
            </editor>
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
				workName : false,
				workCategory : false,
				coverImage : false,
				shotTime : false,
				shotLocation : false,
				publishDate : false,
				workContent : false,
				limitOne : false,
				goodsStocks : false,
				voteCount : false,
				thumbsupNum : false,
				crazilyNum : false,
				lastClickTime : false,
				clickNum : false,
				commentCount : false,
				price : false,
				vipPrice : false,
				favoriteCount : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          workName: '',
          workCategory: '',
          coverImage: '',
          shotTime: '',
          shotLocation: '',
          publishDate: '',
          workContent: '',
          limitOne: Number('-1') ,
          goodsStocks: Number('-1') ,
          voteCount: Number('0') ,
          thumbsupNum: '',
          crazilyNum: '',
          lastClickTime: '',
          clickNum: '',
          commentCount: '',
          price: '',
          vipPrice: '',
          favoriteCount: '',
        },
        workCategoryOptions: [],


        rules: {
          workName: [
            { required: true, message: '作品名称不能为空', trigger: 'blur' },
          ],
          workCategory: [
            { required: true, message: '作品分类不能为空', trigger: 'blur' },
          ],
          coverImage: [
          ],
          shotTime: [
          ],
          shotLocation: [
          ],
          publishDate: [
          ],
          workContent: [
          ],
          limitOne: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          goodsStocks: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          voteCount: [
            { required: true, message: '投票票数不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          thumbsupNum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          crazilyNum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          lastClickTime: [
          ],
          clickNum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          commentCount: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          vipPrice: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          favoriteCount: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
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
      this.ruleForm.shotTime = this.getCurDateTime()
      this.ruleForm.publishDate = this.getCurDate()
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
            if(o=='workName'){
              this.ruleForm.workName = obj[o];
              this.ro.workName = true;
              continue;
            }
            if(o=='workCategory'){
              this.ruleForm.workCategory = obj[o];
              this.ro.workCategory = true;
              continue;
            }
            if(o=='coverImage'){
              this.ruleForm.coverImage = obj[o].split(",")[0];
              this.ro.coverImage = true;
              continue;
            }
            if(o=='shotTime'){
              this.ruleForm.shotTime = obj[o];
              this.ro.shotTime = true;
              continue;
            }
            if(o=='shotLocation'){
              this.ruleForm.shotLocation = obj[o];
              this.ro.shotLocation = true;
              continue;
            }
            if(o=='publishDate'){
              this.ruleForm.publishDate = obj[o];
              this.ro.publishDate = true;
              continue;
            }
            if(o=='workContent'){
              this.ruleForm.workContent = obj[o];
              this.ro.workContent = true;
              continue;
            }
            if(o=='limitOne'){
              this.ruleForm.limitOne = obj[o];
              this.ro.limitOne = true;
              continue;
            }
            if(o=='goodsStocks'){
              this.ruleForm.goodsStocks = obj[o];
              this.ro.goodsStocks = true;
              continue;
            }
            if(o=='voteCount'){
              this.ruleForm.voteCount = obj[o];
              this.ro.voteCount = true;
              continue;
            }
            if(o=='thumbsupNum'){
              this.ruleForm.thumbsupNum = obj[o];
              this.ro.thumbsupNum = true;
              continue;
            }
            if(o=='crazilyNum'){
              this.ruleForm.crazilyNum = obj[o];
              this.ro.crazilyNum = true;
              continue;
            }
            if(o=='lastClickTime'){
              this.ruleForm.lastClickTime = obj[o];
              this.ro.lastClickTime = true;
              continue;
            }
            if(o=='clickNum'){
              this.ruleForm.clickNum = obj[o];
              this.ro.clickNum = true;
              continue;
            }
            if(o=='commentCount'){
              this.ruleForm.commentCount = obj[o];
              this.ro.commentCount = true;
              continue;
            }
            if(o=='price'){
              this.ruleForm.price = obj[o];
              this.ro.price = true;
              continue;
            }
            if(o=='vipPrice'){
              this.ruleForm.vipPrice = obj[o];
              this.ro.vipPrice = true;
              continue;
            }
            if(o=='favoriteCount'){
              this.ruleForm.favoriteCount = obj[o];
              this.ro.favoriteCount = true;
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
        this.$http.get('option/workCategory/workCategory', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.workCategoryOptions = res.data.data;
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
        this.$http.get(`photographyWorks/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			if(this.ruleForm.price<0){
				this.$message.error("价格不能输入负数");
				return
			}
			if(this.ruleForm.vipPrice<0){
				this.$message.error("VIP价格不能输入负数");
				return
			}
			if(this.ruleForm.goodsStocks<0){
				this.$message.error("库存不能输入负数");
				return
			}
			if(this.ruleForm.limitOne<0){
				this.$message.error("单次购买不能输入负数");
				return
			}
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
						this.$http.get('photographyWorks/list', {
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


								this.$http.post(`photographyWorks/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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


						this.$http.post(`photographyWorks/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
