<template>
	<div :style='{"width":"100%","padding":"0 10%","margin":"10px auto","position":"relative","background":"none"}'>
	<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="warning" size="mini" @click="backClick" class="el-icon-back">返回</el-button>
	<div :style='{"width":"calc(100% - 250px)"}'>
		<div :style='{"border":"0","width":"100%","borderRadius":"60px","background":"#8E4033","height":"auto"}'>
			<div :style='{"margin":"0","fontSize":"22px","lineHeight":"54px","color":"#FFC174","textAlign":"center","fontWeight":"bold"}'>新闻资讯</div>
		</div>
		<div :style='{"border":"5px solid #FFC174","padding":"20px","borderRadius":"10px","flexWrap":"wrap","display":"flex","width":"100%","position":"relative"}'>
			<div  :style='{"width":"100%","lineHeight":"40px","fontSize":"20px","color":"#000","textAlign":"center","fontWeight":"bold"}'>{{detail.title}}</div>
			
			<div :style='{"width":"50%","alignItems":"center","justifyContent":"flex-start","display":"flex"}'>
			  <div :style='{"padding":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#9E9E9E"}'></span>
			    <span :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"12px"}'>发布时间：{{detail.addTime}}</span>
			  </div>
			  <div :style='{"padding":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#9E9E9E"}'></span>
			    <span :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"12px"}'>{{detail.name}}</span>
			  </div>
			  <div :style='{"padding":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#9E9E9E"}'></span>
			    <span :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"12px"}'>{{detail.thumbsupNum}}</span>
			  </div>
			  <div :style='{"padding":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#9E9E9E"}'></span>
			    <span :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"12px"}'>{{detail.favoriteCount}}</span>
			  </div>
			  <div :style='{"padding":"0"}'>
			    <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#9E9E9E"}'></span>
			    <span :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"12px"}'>{{detail.clickNum}}</span>
			  </div>
			</div>
			<div class="operate" :style='{"width":"50%","padding":"10px 20px","alignItems":"center","justifyContent":"flex-end","display":"flex"}'>
				<div @click="zanClick" :style='{"padding":"0 15px","alignItems":"center","borderRadius":"30px","background":"#0B4D49","justifyContent":"center","display":"flex"}'>
					<span class="icon iconfont icon-guanzhu-zhihui" :style='{"margin":"0 4px 0 0","lineHeight":"30px","fontSize":"14px","color":"#fff"}'></span>
					<span :style='{"color":"#fff","lineHeight":"30px","fontSize":"14px"}'>{{zanType?'取消赞':'点赞'}}</span>
				</div>
				<div @click="collectClick" :style='{"padding":"0 15px","margin":"0 0 0 10px","alignItems":"center","borderRadius":"30px","background":"#FFC174","display":"flex","justifyContent":"center"}'>
					<span class="icon iconfont icon-shoucang10" :style='{"margin":"0 4px 0 0","lineHeight":"30px","fontSize":"14px","color":"#fff"}'></span>
					<span :style='{"color":"#fff","lineHeight":"30px","fontSize":"14px"}'>{{collectType?'取消收藏':'收藏'}}</span>
				</div>
			</div>
			
			<div :style='{"width":"100%","lineHeight":"1.5","height":"auto"}' class="content-detail" v-html="detail.content"></div>
		</div>
		<!-- option -->
		<div :style='{"width":"100%","padding":"10px 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
		  <div :style='{"padding":"0 15px","lineHeight":"30px","fontSize":"14px","color":"#fff","borderRadius":"30px","background":"#B0B0B0"}' @click="prepDetailClick">上一篇：prev</div>
		  <div :style='{"padding":"0 15px","lineHeight":"30px","fontSize":"14px","color":"#fff","borderRadius":"30px","background":"#B0B0B0"}' @click="nextDetailClick">下一篇：next</div>
		</div>

		<!-- 热门文章 -->
		<div class="hot" :style='{"boxShadow":"none","top":"0","background":"#fff","width":"240px","position":"absolute","right":"10%","height":"auto"}'>
		  <div :style='{"border":"5px solid #FFC174","color":"#FFC174","borderRadius":"10px","textAlign":"center","background":"#0D5451","width":"100%","lineHeight":"50px","fontSize":"16px"}'>热门文章</div>
		  <div :style='{"border":"5px solid #FFC174","width":"100%","padding":"5px","borderRadius":"10px","background":"#fff","height":"auto"}'>
		    <div v-for="item in hotList" :key="item.id" :style='{"border":"5px solid #FFC174","padding":"5px","margin":"0 0 10px","borderRadius":"10px","background":"#fff","width":"100%","height":"auto"}' @click="toDetail(item.id)">
		      <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"100px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"4px 5px 0","lineHeight":"2","fontSize":"14px","color":"#000","textAlign":"center"}'>{{ item.title }}</div>
		      <div :style='{"padding":"0 5px","lineHeight":"2","fontSize":"12px","color":"#000","textAlign":"center"}'>{{item.addTime}}</div>
		    </div>
		  </div>
		</div>
		<!-- 推荐文章 -->
		<div class="news" :style='{"width":"100%","background":"#fff","height":"auto"}'>
		  <div :style='{"border":"5px solid #FFC174","padding":"0 20px","color":"#FFC174","borderRadius":"10px","textAlign":"center","background":"#0D5451","width":"100%","lineHeight":"50px","fontSize":"16px"}'>推荐文章</div>
		  <div :style='{"border":"5px solid #FFC174","padding":"10px","borderRadius":"10px","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <div v-for="item in recommendList" :key="item.id" :style='{"border":"5px solid #FFC174","width":"23%","padding":"10px","borderRadius":"10px","background":"#0D5451","height":"auto"}' @click="toDetail(item.id)">
		      <img :style='{"width":"100%","objectFit":"cover","borderRadius":"10px","display":"block","height":"150px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"0 10px","lineHeight":"2","fontSize":"16px","color":"#fff","textAlign":"center"}'>{{ item.title }}</div>
		      <div :style='{"padding":"0 10px","lineHeight":"1.5","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{item.addTime}}</div>
		    </div>
		  </div>
		</div>
	</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				id: 0,
				detail: {},
				zanType: false,
				zanForm: {},
				collectType:false,
				collectForm: {},
				baseUrl:'',
				hotList: [],
				recommendList: [],
				categoryList: [],
				currentIndex: 0,
				allList: []
			}
		},
		created() {
			this.id = this.$route.query.id
			this.baseUrl = this.$config.baseUrl;
			this.getCategoryList()
			this.getDetail()
			this.getNewsList()
			this.getHotList()
			this.getRecommendList()
		},
		watch:{
			$route(newValue) {
				this.id = this.$route.query.id
			    this.getDetail()
			}
		},
		methods: {
			  backClick() {
				  history.back()
			  },
			getNewsList() {
				let params = {page:1, limit: 100,sort:'addTime',order:'desc'};
				this.$http.get('news/list', {params: params}).then(res => {
					if (res.data.code == 0) {
						for(let x in res.data.data.list){
							if(res.data.data.list[x].id == this.id){
								this.currentIndex = Number(x)
								break
							}
						}
						this.allList = res.data.data.list
					}
				});
			},
			// 上一篇
			prepDetailClick(){
				if(this.currentIndex == 0){
					this.$message.error('已经是第一篇了')
					return false
				}
				this.currentIndex--
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			// 下一篇
			nextDetailClick(){
				if(this.currentIndex == this.allList.length - 1){
					this.$message.error('已经是最后一篇了')
					return false
				}
				this.currentIndex++
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			getCategoryList(){
				this.$http.get('newsType/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data;
					}
				});
			},
			// 获取热门列表
			getHotList(){
				let params = {page:1, limit: 4,sort:'addTime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
			// 获取推荐列表
			getRecommendList(){
				let url = 'news/autoSort'
				if(localStorage.getItem('frontToken')){
					url = 'news/autoSort2'
				}
				let params = {page:1, limit: 4,sort:'addTime',order:'desc'};
				this.$http.get(url, {params: params}).then(res => {
					if (res.data.code == 0) {
						this.recommendList = res.data.data.list;
					}
				});
			},
			// 跳转详情
			toDetail(id){
				this.$router.push({path: '/index/newsDetail', query: {id: id}});
			},
			getDetail(){
				this.$http.get(`news/detail/${this.id}`,{}).then(res=>{
					if(res.data&&res.data.code==0){
						this.detail = res.data.data
						window.scrollTo(0, 100)
						this.getZan()
						this.getCollect()
					}
				})
			},
			getZan() {
				this.$http.get('favorites/list', {
					params: {
						page: 1,
						limit: 1,
						type: 21,
						userId: localStorage.getItem('frontUserId'),
						tableName: 'news',
						refId: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.zanType = true
							this.zanForm = res.data.data.list[0]
						}else{
							this.zanType = false
						}
					}
				})
			},
			getCollect(){
				this.$http.get('favorites/list', {
					params: {
						page: 1,
						limit: 1,
						type: 1,
						userId: localStorage.getItem('frontUserId'),
						tableName: 'news',
						refId: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.collectType = true
							this.collectForm = res.data.data.list[0]
						}else{
							this.collectType = false
						}
					}
				})
			},
			zanClick() {
				if(this.zanType){
					this.$http.post('favorites/delete', [this.zanForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.thumbsupNum--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refId: this.detail.id,
						type: 21,
						tableName: 'news',
						userId: localStorage.getItem('frontUserId')
					}
					this.$http.post('favorites/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('点赞成功')
							this.detail.thumbsupNum++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}
			},
			collectClick(){
				if(this.collectType){
					this.$http.post('favorites/delete', [this.collectForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.favoriteCount--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getCollect()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refId: this.detail.id,
						type: 1,
						tableName: 'news',
						userId: localStorage.getItem('frontUserId')
					}
					this.$http.post('favorites/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.detail.favoriteCount++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.$message.success('收藏成功')
							this.getCollect()
						}
					})
				}
			},
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.section {
		width: 900px;
		margin: 0 auto;
	}
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	.section-content {
		margin-top: 30px;
	}
	.content-title {
		text-align: center;
		font-size: 22px;
		font-weight: bold;
	}
	.content-sub-title {
		text-align: center;
		margin-top: 20px;
		color: #888888;
		font-size: 14px;
	}
	.operate{
		display: flex;
		align-items: center;
		justify-content: space-between;
		padding: 0 40px;
	}
</style>