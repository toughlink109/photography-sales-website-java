<template>
<div :style='{"width":"100%","padding":"0 10%","margin":"10px auto","position":"relative","background":"none"}'>
    <div class="section-title" :style='{"margin":"10px auto 0","color":"#FFC174","borderRadius":"60px","textAlign":"center","background":"#8E4033","width":"80%","fontSize":"24px","lineHeight":"54px","fontWeight":"bold"}'>留言板</div>
	<el-form :model="form" :rules="rules" ref="form" label-width="65px" label-position="left">
	  <el-form-item label="留言" prop="content">
		<editor
		    :style='{"padding":"0","boxShadow":"none","margin":"0","borderColor":"#E2E3E5","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
		    v-model="form.content" 
		    class="editor" 
		    action="file/upload">
		</editor>
	  </el-form-item>
      <el-form-item label="图片" prop="msgImage">
        <file-upload
        tip="点击上传图片"
        action="file/upload"
        :limit="1"
        :multiple="true"
        :fileUrls="form.msgImage?form.msgImage:''"
        @change="msgImageUploadChange"
        ></file-upload>
      </el-form-item>
	  <el-form-item>
		<el-button type="primary" @click="submitForm('form')">立即提交</el-button>
		<el-button @click="resetForm('form')">重置</el-button>
	  </el-form-item>
	</el-form>
	<div class="section-content">
	  <span v-for="item in infoList" :key="item.id">
		<div class="header-block">
		  <el-avatar v-if="item.avatarUrl" :size="50" :src="$config.baseUrl + item.avatarUrl"></el-avatar>
		  <el-avatar v-if="!item.avatarUrl" :size="50" :src="require('@/assets/userAvatar.png')"></el-avatar>
		  <span class="userinfo">用户：{{item.username}}</span>
		</div>
		<div class="content-block-ask">
		  <div v-html="item.content"></div>
		</div>
        <div v-if="item.msgImage" class="content" style="margin: 0;flex: 1;">
            <img style="max-width: 300px;max-height: 300px;border: 2px solid #EEEEEE;margin:8px 0 0 50px;" :src="$config.baseUrl+item.msgImage">
        </div>
		<div class="content-block-reply" v-if="item.reply">
		  回复：<div v-html="item.reply"></div>
		</div>
        <div v-if="item.replyImage" class="content" style="margin: 0;flex: 1;">
            <img style="max-width: 300px;max-height: 300px;border: 2px solid #EEEEEE;margin:8px 0 0 50px;" :src="$config.baseUrl+item.replyImage">
        </div>
		<el-divider></el-divider>
	  </span>
	</div>
	
    <el-pagination
      background
      id="pagination" class="pagination"
      :pager-count="7"
      :page-size="pageSize"
	  prev-text="上一页"
      next-text="下一页"
      :hide-on-single-page="true"
      :layout='["prev","pager","next"].join()'
      :total="total"
      :style='{"width":"1200px","padding":"0","margin":"10px auto","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
      @current-change="curChange"
      @prev-click="prevClick"
      @next-click="nextClick"
    ></el-pagination>
	  
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
		  layouts: '',
        form: {
          content: '',
          userId: localStorage.getItem('frontUserId'),
          username: localStorage.getItem('username')
        },
        total: 1,
        pageSize: 20,
        totalPage: 1,
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ]
        },
        infoList: []
      }
    },
    created() {
      this.getInfo(1);
    },
    //方法集合
    methods: {
      getInfo(page) {
        this.$http.get('messages/list', {params: {page, limit: this.pageSize,sort:"addTime", order:"desc"}}).then(res => {
          if (res.data.code == 0) {
            this.infoList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = Number(res.data.data.pageSize);
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
      curChange(page) {
        this.getInfo(page);
      },
      prevClick(page) {
        this.getInfo(page);
      },
      nextClick(page) {
        this.getInfo(page);
      },
      msgImageUploadChange(fileUrls) {
          this.form.msgImage = fileUrls;
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if(this.form.msgImage!=null) {
               this.form.msgImage = this.form.msgImage.replace(new RegExp(this.$config.baseUrl,"g"),"");
            }
            this.form.avatarUrl = localStorage.getItem('frontHeadImage')?localStorage.getItem('frontHeadImage'):'';
            let sensitiveWords = "";
            let sensitiveWordsArr = [];
            if(sensitiveWords) {
                sensitiveWordsArr = sensitiveWords.split(",");
            }
            for(var i=0; i<sensitiveWordsArr.length; i++){
                //全局替换
                var reg = new RegExp(sensitiveWordsArr[i],"g");
                //判断内容中是否包括敏感词
                if (this.form.content.indexOf(sensitiveWordsArr[i]) > -1) {
                    // 将敏感词替换为 **
                    this.form.content = this.form.content.replace(reg,"**");
                }
            }
            this.$http.post('messages/add', this.form).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  type: 'success',
                  message: '留言成功!',
                  duration: 1500,
                  onClose: () => {
                    this.form.content = '';
                    this.getInfo(1);
                  }
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .section {
    width: 900px;
    margin: 0 auto;
  }

  .section-content {
    margin-top: 50px;
  }
  .section-pagination {
    margin-top: 30px;
    text-align: center;
  }
  .header-block {
    height: 50px;
    line-height: 50px;
    display: flex;
  }
  .userinfo {
    align-self: center;
    margin-left: 15px;
  }
  .content-block-ask, .content-block-reply {
    margin-left: 65px;
    margin-top: 15px;
  }
  .content-block-reply {
    margin-top: 30px;
  }
  .z-box {
  	  width: 100% !important;
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
</style>
