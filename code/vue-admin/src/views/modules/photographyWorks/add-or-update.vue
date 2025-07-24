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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="作品名称" prop="workName">
					<el-input v-model="ruleForm.workName" placeholder="作品名称" clearable  :readonly="ro.workName"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="作品名称" prop="workName">
					<el-input v-model="ruleForm.workName" placeholder="作品名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="作品分类" prop="workCategory">
					<el-select :disabled="ro.workCategory" v-model="ruleForm.workCategory" placeholder="请选择作品分类" >
						<el-option
							v-for="(item,index) in workCategoryOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="作品分类" prop="workCategory">
					<el-input v-model="ruleForm.workCategory"
						placeholder="作品分类" readonly></el-input>
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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="拍摄时间" prop="shotTime">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.shotTime" 
						type="datetime"
						:readonly="ro.shotTime"
						placeholder="拍摄时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.shotTime" label="拍摄时间" prop="shotTime">
					<el-input v-model="ruleForm.shotTime" placeholder="拍摄时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="拍摄地点" prop="shotLocation">
					<el-input v-model="ruleForm.shotLocation" placeholder="拍摄地点" clearable  :readonly="ro.shotLocation"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="拍摄地点" prop="shotLocation">
					<el-input v-model="ruleForm.shotLocation" placeholder="拍摄地点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="发布日期" prop="publishDate">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.publishDate" 
						type="date"
						:readonly="ro.publishDate"
						placeholder="发布日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.publishDate" label="发布日期" prop="publishDate">
					<el-input v-model="ruleForm.publishDate" placeholder="发布日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="单限" prop="limitOne">
					<el-input v-model.number="ruleForm.limitOne" placeholder="单限" clearable  :readonly="ro.limitOne"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="单限" prop="limitOne">
					<el-input v-model="ruleForm.limitOne" placeholder="单限" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="库存" prop="goodsStocks">
					<el-input v-model.number="ruleForm.goodsStocks" placeholder="库存" clearable  :readonly="ro.goodsStocks"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="库存" prop="goodsStocks">
					<el-input v-model="ruleForm.goodsStocks" placeholder="库存" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="投票票数" prop="voteCount">
					<el-input v-model.number="ruleForm.voteCount" placeholder="投票票数" clearable  :readonly="ro.voteCount"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="投票票数" prop="voteCount">
					<el-input v-model="ruleForm.voteCount" placeholder="投票票数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="价格" prop="price">
					<el-input-number v-model="ruleForm.price" placeholder="价格" :disabled="ro.price"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="价格" prop="price">
					<el-input v-model="ruleForm.price" placeholder="价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="会员价" prop="vipPrice">
					<el-input-number v-model="ruleForm.vipPrice" placeholder="会员价" :disabled="ro.vipPrice"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="会员价" prop="vipPrice">
					<el-input v-model="ruleForm.vipPrice" placeholder="会员价" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="作品内容" prop="workContent">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.workContent" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.workContent" label="作品内容" prop="workContent">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.workContent"></span>
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
			
			
			ruleForm: {
				workName: '',
				workCategory: '',
				coverImage: '',
				shotTime: '',
				shotLocation: '',
				publishDate: '',
				workContent: '',
				limitOne: '-1',
				goodsStocks: '-1',
				voteCount: '0',
				lastClickTime: '',
				price: '',
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
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				goodsStocks: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				voteCount: [
					{ required: true, message: '投票票数不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				thumbsupNum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				crazilyNum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				lastClickTime: [
				],
				clickNum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				commentCount: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				price: [
					{ required: true, message: '价格不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				vipPrice: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				favoriteCount: [
					{ validator: validateIntNumber, trigger: 'blur' },
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
		this.ruleForm.shotTime = this.getCurDateTime()
		this.ruleForm.publishDate = this.getCurDate()
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
							this.ruleForm.coverImage = obj[o];
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
				this.ruleForm.limitOne = Number('-1'); 				this.ruleForm.goodsStocks = Number('-1'); 				this.ruleForm.voteCount = Number('0'); 			}
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
            this.$http({
				url: `option/workCategory/workCategory`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.workCategoryOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `photographyWorks/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.workContent = this.ruleForm.workContent.replace(reg,'../../../springboottvfo8kua/upload');
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
					url: "photographyWorks/page", 
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
								url: `photographyWorks/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.photographyWorksCrossAddOrUpdateFlag = false;
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
				url: `photographyWorks/${!this.ruleForm.id ? "save" : "update"}`,
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
							this.parent.photographyWorksCrossAddOrUpdateFlag = false;
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
      this.parent.photographyWorksCrossAddOrUpdateFlag = false;
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
