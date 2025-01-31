<template>
<div class="home-preview" :style='{"width":"100%","margin":"0 auto","flexDirection":"column","display":"flex"}'>



		<!-- 关于我们 -->
		<div id="about" class="animate__animated" :style='{"padding":"100px 10% 100px 45%","boxShadow":"none","margin":"0 0 10px","display":"flex","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20240111/a157ad1a3608480a9d2e42426e83c029.png)","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","position":"relative","backgroundRepeat":"no-repeat","height":"auto","order":"7"}'>
		  <div :style='{"border":"5px solid #FFC174","margin":"0","color":"#FFC174","borderRadius":"30px 30px 0 0","textAlign":"center","background":"#10615F","borderWidth":"5px 5px 0","width":"100%","lineHeight":"95px","fontSize":"32px","height":"95px"}'>{{aboutUsDetail.title}}</div>
		  <div :style='{"border":"5px solid #FFC174","margin":"0 0 10px","color":"#FFC174","borderRadius":"0 0 30px 30px","textAlign":"center","background":"#10615F","borderWidth":"0 5px 5px","width":"100%","lineHeight":"95px","fontSize":"24px","height":"95px"}'>{{aboutUsDetail.subtitle}}</div>
		  <div :style='{"padding":"0 10px","top":"120px","flexWrap":"wrap","left":"10%","display":"flex","width":"26%","position":"absolute","height":"50%"}'>
		    <img :style='{"margin":"0 10px","objectFit":"cover","borderRadius":"50px","flex":1,"display":"block","height":"100%"}' :src="baseUrl + aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture3">
		  </div>
		  <div :style='{"padding":"0","margin":"20px 0","overflow":"hidden","color":"#fff","display":"-webkit-box","width":"100%","lineHeight":"2","fontSize":"16px","textOverflow":"ellipsis","-webkit-box-orient":"vertical","-webkit-line-clamp":"5"}' v-html="aboutUsDetail.content"></div>
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"0","margin":"10px auto","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}' @click="toDetail('aboutusDetail',aboutUsDetail)">
		    <span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		    <span class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"12px"}'></span>
		  </div>
		</div>
		<!-- 关于我们 -->

		<!-- 系统简介 -->
		<div id="system" class="animate__animated" :style='{"padding":"60px 0 20px","boxShadow":"0 1px 6px rgba(255, 255, 255, .3)","margin":"0 0 10px","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto","order":"5"}'>
		  <div :style='{"border":"5px solid #FFC174","color":"#FFC174","alignItems":"flex-end","textAlign":"center","display":"flex","justifyContent":"center","background":"linear-gradient(180deg, #10615F 0%, #10615F 100%)","borderWidth":"5px 5px 0","width":"100%","lineHeight":"1.5","fontSize":"36px","height":"95px","order":"1"}'>{{systemIntroductionDetail.title}}</div>
		  <div :style='{"border":"5px solid #FFC174","margin":"0 0 50px","color":"#FFC174","textAlign":"center","background":"linear-gradient(180deg, #10615F 0%, #0A4742 100%)","borderWidth":"0 5px 5px","width":"100%","lineHeight":"2","fontSize":"24px","height":"95px","order":"2"}'>{{systemIntroductionDetail.subtitle}}</div>
		  <div :style='{"padding":"0 0","margin":"0 auto","flexWrap":"wrap","display":"flex","width":"80%","height":"auto","order":"4"}'>
		    <img :style='{"margin":"0 10px","objectFit":"cover","borderRadius":"30px","flex":1,"display":"block","height":"250px"}' :src="baseUrl + systemIntroductionDetail.picture1">
		    <img :style='{"margin":"0 10px","objectFit":"cover","borderRadius":"30px","flex":1,"display":"block","height":"250px"}' :src="baseUrl + systemIntroductionDetail.picture2">
		    <img :style='{"margin":"0 10px","objectFit":"cover","borderRadius":"30px","flex":1,"display":"block","height":"250px"}' :src="baseUrl + systemIntroductionDetail.picture3">
		  </div>
		  <div :style='{"padding":"0","margin":"0 auto 10px ","color":"#000","display":"-webkit-box","minHeight":"160px","overflow":"hidden","width":"80%","lineHeight":"2","fontSize":"16px","textOverflow":"ellipsis","-webkit-box-orient":"vertical","-webkit-line-clamp":"5","order":"3"}' v-html="systemIntroductionDetail.content"></div>
		  <div :style='{"margin":"-480px 0 0","background":"url(http://codegen.caihongy.cn/20240110/8562c8dc4e3b4cebbaaf952878ee2548.png)","display":"block","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"600px","order":"5","zIndex":"-1"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"0","margin":"10px auto","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}' @click="toDetail('systemintroDetail',systemIntroductionDetail)">
		    <span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		    <span class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"12px"}'></span>
		  </div>
		</div>
		<!-- 系统简介 -->
		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"width":"80%","margin":"0 auto 10px","position":"relative","background":"#fff","order":"3"}'>
		<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
			<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"border":"4px solid #FFC174","padding":"0 30px","margin":"10px auto","borderRadius":"30px","textAlign":"left","background":"linear-gradient(180deg, #10615F 0%, #0A4742 100%)","width":"100%","lineHeight":"54px"}'>
			<span :style='{"color":"#FFC174","fontSize":"24px","fontWeight":"bold"}'>新闻资讯</span>
		</div>
		
			
			
			
			
			
			<!-- 样式五 -->
		<div v-if="newsList.length" class="list list5 index-pv1" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
		  <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="list-item animation-box" :style='{"width":"100%","margin":"0 0 30px","alignItems":"center","background":"#fff","display":"flex","height":"auto"}'>
		    <img :style='{"width":"30vw","objectFit":"cover","borderRadius":"30px","float":"left","height":"20vw"}' :src="baseUrl + newsList[0].picture" alt="">
		    <div :style='{"width":"calc(100% - 30vw)","padding":"0 20px","background":"#fff","flexDirection":"column","display":"flex","height":"auto"}'>
		      <div :style='{"padding":"0","lineHeight":"32px","fontSize":"18px","color":"#000","fontWeight":"bold","order":"1"}' class="new5-one-info-title line1">{{newsList[0].title}}</div>
		      <div :style='{"padding":"20px 0","overflow":"hidden","color":"#757575","display":"-webkit-box","lineHeight":"1.5","fontSize":"15px","textOverflow":"ellipsis","-webkit-box-orient":"vertical","-webkit-line-clamp":"2","order":"2"}' class="new5-one-info-descript line3">{{newsList[0].introduction}}</div>
			  <div :style='{"padding":"0 0","order":"7"}'>
			    <span class="icon iconfont icon-shijian21" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[0].addtime}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"6"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[0].name}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"3"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[0].thumbsupnum}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"4"}'>
			    <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[0].storeupnum}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"5"}'>
			    <span class="icon iconfont icon-chakan9" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[0].clicknum}}</span>
			  </div>
			</div>
		  </div>
		  <div :style='{"width":"100%","flexWrap":"wrap","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}' class="list-body">
		    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new5-item animation-box" :style='{"border":"5px solid #FFC174","padding":"20px","borderRadius":"30px","background":"#fff","flexDirection":"column","display":"flex","width":"32%","position":"relative","height":"auto"}'>
		      <div :style='{"padding":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"32px","fontSize":"18px","textOverflow":"ellipsis","order":"1"}' class="new5-item-title line1">{{newsList[1].title}}</div>
		      <div :style='{"padding":"0","margin":"10px 0","overflow":"hidden","color":"#757575","display":"-webkit-box","lineHeight":"1.5","fontSize":"15px","textOverflow":"ellipsis","-webkit-box-orient":"vertical","-webkit-line-clamp":"2","order":"2"}' class="new5-item-descript line3">{{newsList[1].introduction}}</div>
			  <div :style='{"padding":"0 0","order":"7"}'>
			    <span class="icon iconfont icon-shijian21" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[1].addtime}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"6"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[1].name}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"3"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[1].thumbsupnum}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"4"}'>
			    <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[1].storeupnum}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"5"}'>
			    <span class="icon iconfont icon-chakan9" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[1].clicknum}}</span>
			  </div>
		    </div>
			<div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new5-item animation-box" :style='{"border":"5px solid #FFC174","padding":"20px","borderRadius":"30px","background":"#fff","flexDirection":"column","display":"flex","width":"32%","position":"relative","height":"auto"}'>
			  <div :style='{"padding":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"32px","fontSize":"18px","textOverflow":"ellipsis","order":"1"}' class="new5-item-title line1">{{newsList[2].title}}</div>
			  <div :style='{"padding":"0","margin":"10px 0","overflow":"hidden","color":"#757575","display":"-webkit-box","lineHeight":"1.5","fontSize":"15px","textOverflow":"ellipsis","-webkit-box-orient":"vertical","-webkit-line-clamp":"2","order":"2"}' class="new5-item-descript line3">{{newsList[2].introduction}}</div>
			  <div :style='{"padding":"0 0","order":"7"}'>
			    <span class="icon iconfont icon-shijian21" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[2].addtime}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"6"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[2].name}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"3"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[2].thumbsupnum}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"4"}'>
			    <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[2].storeupnum}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"5"}'>
			    <span class="icon iconfont icon-chakan9" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[2].clicknum}}</span>
			  </div>
			</div>
			<div @click="toDetail('newsDetail', newsList[3])" v-if="newsList.length>3" class="new5-item animation-box" :style='{"border":"5px solid #FFC174","padding":"20px","borderRadius":"30px","background":"#fff","flexDirection":"column","display":"flex","width":"32%","position":"relative","height":"auto"}'>
			  <div :style='{"padding":"0","lineHeight":"32px","fontSize":"18px","color":"#000"}' class="new5-item-title line1">{{newsList[3].title}}</div>
			  <div :style='{"padding":"0","margin":"10px 0","overflow":"hidden","color":"#757575","display":"-webkit-box","lineHeight":"1.5","fontSize":"15px","textOverflow":"ellipsis","-webkit-box-orient":"vertical","-webkit-line-clamp":"2"}' class="new5-item-descript line3">{{newsList[3].introduction}}</div>
			  <div :style='{"padding":"0 0","order":"7"}'>
			    <span class="icon iconfont icon-shijian21" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[3].addtime}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"6"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[3].name}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"3"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[3].thumbsupnum}}</span>
			  </div>
			  <div :style='{"padding":"6px 0","order":"4"}'>
			    <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[3].storeupnum}}</span>
			  </div>
			  <div :style='{"padding":"0 0","order":"5"}'>
			    <span class="icon iconfont icon-chakan9" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#4D4D4D"}'></span>
			    <span class="text" :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"14px"}'>{{newsList[3].clicknum}}</span>
			  </div>
			</div>
		  </div>
		</div>
			
			
			
			
			
		











		<div @click="moreBtn('news')" :style='{"border":"0","margin":"10px auto","top":"5px","alignItems":"center","textAlign":"center","background":"none","display":"flex","width":"80px","lineHeight":"54px","position":"absolute","right":"30px"}'>
			<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>更多</span>
			<i :style='{"margin":"0 0 0 6px","color":"#f5f5f5","alignItems":"center","borderRadius":"50%","background":"#FFC174","display":"flex","width":"30px","fontSize":"14px","justifyContent":"center","height":"30px"}' class="icon iconfont icon-gengduo1"></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->


<!-- 商品推荐 -->
<div id="animate_recommendsheyingzuopin" class="recommend animate__animated" :style='{"margin":"20px 0","position":"relative","background":"#fff","order":"4"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","padding":"0 10%","margin":"10px auto","lineHeight":"140px","textAlign":"left","background":"#8E4033"}'>
		<span :style='{"color":"#fff","fontSize":"28px"}'>摄影作品推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	



	<div v-if="sheyingzuopinRecommend.length" class="list list12 index-pv1 list12sheyingzuopin" :style='{"width":"100%","padding":"10px 10%","background":"#fff","height":"auto"}'>
	  <div class="list" :style='{"overflow":"hidden","flex":"1","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
	    <div :style='{"border":"5px solid #FFC174","padding":"10px","borderRadius":"30px","background":"#5F848D","width":"16%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in sheyingzuopinRecommend" :key="index" @click="toDetail('sheyingzuopinDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"5px 10px 0","lineHeight":"1.5","fontSize":"18px","color":"#fff","textAlign":"center"}'>{{item.zuopinmingcheng}}</div>
			<div class="line1" :style='{"padding":"5px 10px 0","lineHeight":"1.5","fontSize":"18px","color":"#fff","textAlign":"center"}'>{{item.zuopinfenlei}}</div>
	    </div>
	  </div>
	</div>




	
	<div @click="moreBtn('sheyingzuopin')" :style='{"border":"0","cursor":"pointer","margin":"10px auto","top":"55px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(10% + 10px)"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","borderRadius":"100%","background":"#FFC174","display":"inline-block","width":"30px","fontSize":"12px","height":"30px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendsheyingshebei" class="recommend animate__animated" :style='{"margin":"20px 0","position":"relative","background":"#fff","order":"4"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","padding":"0 10%","margin":"10px auto","lineHeight":"140px","textAlign":"left","background":"#8E4033"}'>
		<span :style='{"color":"#fff","fontSize":"28px"}'>摄影设备推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	



	<div v-if="sheyingshebeiRecommend.length" class="list list12 index-pv1 list12sheyingshebei" :style='{"width":"100%","padding":"10px 10%","background":"#fff","height":"auto"}'>
	  <div class="list" :style='{"overflow":"hidden","flex":"1","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
	    <div :style='{"border":"5px solid #FFC174","padding":"10px","borderRadius":"30px","background":"#5F848D","width":"16%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in sheyingshebeiRecommend" :key="index" @click="toDetail('sheyingshebeiDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"5px 10px 0","lineHeight":"1.5","fontSize":"18px","color":"#fff","textAlign":"center"}'>{{item.shebeimingcheng}}</div>
	    </div>
	  </div>
	</div>




	
	<div @click="moreBtn('sheyingshebei')" :style='{"border":"0","cursor":"pointer","margin":"10px auto","top":"55px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(10% + 10px)"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","borderRadius":"100%","background":"#FFC174","display":"inline-block","width":"30px","fontSize":"12px","height":"30px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendsheyinghuati" class="recommend animate__animated" :style='{"margin":"20px 0","position":"relative","background":"#fff","order":"4"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","padding":"0 10%","margin":"10px auto","lineHeight":"140px","textAlign":"left","background":"#8E4033"}'>
		<span :style='{"color":"#fff","fontSize":"28px"}'>摄影话题推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	



	<div v-if="sheyinghuatiRecommend.length" class="list list12 index-pv1 list12sheyinghuati" :style='{"width":"100%","padding":"10px 10%","background":"#fff","height":"auto"}'>
	  <div class="list" :style='{"overflow":"hidden","flex":"1","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
	    <div :style='{"border":"5px solid #FFC174","padding":"10px","borderRadius":"30px","background":"#5F848D","width":"16%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in sheyinghuatiRecommend" :key="index" @click="toDetail('sheyinghuatiDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"5px 10px 0","lineHeight":"1.5","fontSize":"18px","color":"#fff","textAlign":"center"}'>{{item.biaoti}}</div>
	    </div>
	  </div>
	</div>




	
	<div @click="moreBtn('sheyinghuati')" :style='{"border":"0","cursor":"pointer","margin":"10px auto","top":"55px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(10% + 10px)"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","borderRadius":"100%","background":"#FFC174","display":"inline-block","width":"30px","fontSize":"12px","height":"30px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendzuopinfabu" class="recommend animate__animated" :style='{"margin":"20px 0","position":"relative","background":"#fff","order":"4"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","padding":"0 10%","margin":"10px auto","lineHeight":"140px","textAlign":"left","background":"#8E4033"}'>
		<span :style='{"color":"#fff","fontSize":"28px"}'>作品发布推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	



	<div v-if="zuopinfabuRecommend.length" class="list list12 index-pv1 list12zuopinfabu" :style='{"width":"100%","padding":"10px 10%","background":"#fff","height":"auto"}'>
	  <div class="tab" :style='{"width":"100%","margin":"0 0 20px","justifyContent":"space-between","display":"flex","height":"auto"}'>
	    <template v-for="item,index in recommendList12zuopinfabu">
		<div v-if="index < 6" @click="recommendIndexClick12(index + 1, 'zuopinfabu')" class="item" :class="index + 1 == recommendIndex12zuopinfabu ? 'active' : ''">
			<img v-if="item.image" :style='{"width":"60px","margin":"0 0 10px","objectFit":"cover","borderRadius":"50%","display":"block","height":"60px"}' :src="baseUrl + (item.image?item.image.split(',')[0]:'')">
			<div :style='{"color":"inherit","fontSize":"inherit"}'>{{item[recommendColumn12zuopinfabu]}}</div>
		</div>
		</template>
		<div class="more" @click="moreBtn('zuopinfabu')">
		  <div :style='{"color":"#FFC174","fontSize":"16px","fontWeight":"bold"}'>更多</div>
		  <span class="icon iconfont icon-jiantou25" :style='{"margin":"0 0 0 6px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#FFC174","width":"30px","fontSize":"16px","lineHeight":"30px","height":"30px"}'></span>
		</div>
	  </div>
	  <div class="list" :style='{"overflow":"hidden","flex":"1","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
	    <div :style='{"border":"5px solid #FFC174","padding":"10px","borderRadius":"30px","background":"#5F848D","width":"16%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in zuopinfabuRecommend" :key="index" @click="toDetail('zuopinfabuDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-if="preHttp(item.zuopin)" :src="item.zuopin.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"230px"}' v-else :src="baseUrl + (item.zuopin?item.zuopin.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"5px 10px 0","lineHeight":"1.5","fontSize":"18px","color":"#fff","textAlign":"center"}'>{{item.biaoti}}</div>
			<div class="line1" :style='{"padding":"5px 10px 0","lineHeight":"1.5","fontSize":"18px","color":"#fff","textAlign":"center"}'>{{item.zuopinfenlei}}</div>
	    </div>
	  </div>
	</div>




	
	<div @click="moreBtn('zuopinfabu')" :style='{"border":"0","cursor":"pointer","margin":"10px auto","top":"55px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(10% + 10px)"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","borderRadius":"100%","background":"#FFC174","display":"inline-block","width":"30px","fontSize":"12px","height":"30px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->


<!-- 特价商品 -->
<div id="animate_listsheyingshebei" class="lists animate__animated" :style='{"margin":"0 0 10px","position":"relative","background":"#fff","order":"6"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"padding":"0 10% 0 13%","margin":"0 auto","textAlign":"left","background":"url(http://codegen.caihongy.cn/20240110/a4f11fd0784b43bc85f01dba4285b590.png)","width":"100%","lineHeight":"90px","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"90px"}'>
	  <span :style='{"color":"#1D3F48","fontSize":"36px"}'>摄影设备展示</span>
	</div>
	
	
	
	
	
	
	
	
	
	


	<div v-if="sheyingshebeiList.length" class="list list11 index-pv1" :style='{"padding":"20px 0","margin":"0 auto","alignItems":"flex-start","background":"#fff","display":"flex","width":"80%","justifyContent":"space-between","height":"auto"}'>
	  <div class="list" :style='{"flexWrap":"wrap","flex":"1","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
	    <div :style='{"border":"5px solid #FFC174","padding":"10px","margin":"0 0 30px","borderRadius":"30px","background":"#5F848D","width":"31%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in sheyingshebeiList" :key="index" @click="toDetail('sheyingshebeiDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"300px"}' v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","borderRadius":"30px","display":"block","height":"300px"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"0 10px","lineHeight":"2","fontSize":"18px","color":"#fff","textAlign":"center"}'>{{item.shebeimingcheng}}</div>
	    </div>
	  </div>
	</div>




	
	
	<div @click="moreBtn('sheyingshebei')" :style='{"border":"0","padding":"0 30px","margin":"10px auto","alignItems":"center","textAlign":"center","display":"flex","right":"10%","top":"0","borderRadius":"40px","background":"#8E4033","width":"auto","lineHeight":"70px","position":"absolute","height":"70px"}'>
		<span :style='{"color":"#fff","fontSize":"16px"}'>查看更多</span>
		<i :style='{"margin":"0 0 0 6px","color":"#f5f5f5","borderRadius":"50%","alignItems":"center","background":"#FFC174","display":"flex","width":"30px","fontSize":"16px","justifyContent":"center","height":"30px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	

</div>
<!-- 特价商品 -->
	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        systemIntroductionDetail: {},
        newsList: [],
        sheyingzuopinRecommend: [],
        sheyingshebeiRecommend: [],
        sheyinghuatiRecommend: [],
        zuopinfabuRecommend: [],

        sheyingshebeiList: [],


		recommendIndex12sheyingzuopin: 0,
		recommendList12sheyingzuopin: [],
		recommendColumn12sheyingzuopin: '',
		recommendIndex12sheyinghuati: 0,
		recommendList12sheyinghuati: [],
		recommendColumn12sheyinghuati: '',
		recommendIndex12zuopinfabu: 0,
		recommendList12zuopinfabu: [],
		recommendColumn12zuopinfabu: '',


      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getAboutUs();
		this.getSystemIntroduction();
		this.getList();
		this.sheyingzuopinRecommendCate()
		this.sheyinghuatiRecommendCate()
		this.zuopinfabuRecommendCate()
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			setTimeout(()=>{
			},750)
		},
		sheyingzuopinRecommendCate(){
			this.$http.get('zuopinfenlei/list',{}).then(res => {
			  if (res.data.code == 0) {
				this.recommendList12sheyingzuopin = res.data.data.list
			  }
			});
			this.recommendColumn12sheyingzuopin = 'zuopinfenlei'
		},
		sheyinghuatiRecommendCate(){
			this.$http.get('huatifenlei/list',{}).then(res => {
			  if (res.data.code == 0) {
				this.recommendList12sheyinghuati = res.data.data.list
			  }
			});
			this.recommendColumn12sheyinghuati = 'huatifenlei'
		},
		zuopinfabuRecommendCate(){
			this.$http.get('zuopinfenlei/list',{}).then(res => {
			  if (res.data.code == 0) {
				this.recommendList12zuopinfabu = res.data.data.list
			  }
			});
			this.recommendColumn12zuopinfabu = 'zuopinfenlei'
		},
		recommendIndexClick12(index, name) {
			this['recommendIndex12' + name] = index
			this.getList()
			
			document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
			  el.classList.remove("active")
			})
			setTimeout(() => {
			  document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
			    el.classList.add("active")
			  })
			}, 1);
		},

		listIndexClick11(index, name) {
			this['listIndex11' + name] = index[this['listColumn11' + name]]
			this.getList()
		},

		handleScroll() {
			let arr = [
				{id:'search',css:'animate__backInDown'},
				{id:'about',css:'animate__backInUp'},
				{id:'system',css:'animate__shakeX'},
				{id:'animate_recommendsheyingzuopin',css:'animate__jackInTheBox'},
				{id:'animate_recommendsheyingshebei',css:'animate__jackInTheBox'},
				{id:'animate_listsheyingshebei',css:'animate__fadeInRight'},
				{id:'animate_recommendsheyinghuati',css:'animate__jackInTheBox'},
				{id:'animate_recommendzuopinfabu',css:'animate__jackInTheBox'},
				{id:'animate_newsnews',css:'animate__bounceInRight'},
				{id:'msgs',css:'animate__swing'},
				{id:'friendly',css:'animate__pulse'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getAboutUs() {
          this.$http.get('aboutus/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.aboutUsDetail = res.data.data;
            }
          })
      },
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 6,
                sort: 'addtime',
				order: 'desc'
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
          autoSortUrl = "sheyingzuopin/autoSort";
          if(localStorage.getItem('frontToken')) {
              autoSortUrl = "sheyingzuopin/autoSort2";
          }
			data = {
				page: 1,
				limit: 6,
			}
			if(this.recommendIndex12sheyingzuopin != 0){
				data.zuopinfenlei = this.recommendList12sheyingzuopin[this.recommendIndex12sheyingzuopin - 1].zuopinfenlei
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.sheyingzuopinRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "sheyingshebei/autoSort";
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.sheyingshebeiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "sheyinghuati/autoSort";
          if(localStorage.getItem('frontToken')) {
              autoSortUrl = "sheyinghuati/autoSort2";
          }
			data = {
				page: 1,
				limit: 6,
			}
			data['sfsh'] = '是'
			if(this.recommendIndex12sheyinghuati != 0){
				data.huatifenlei = this.recommendList12sheyinghuati[this.recommendIndex12sheyinghuati - 1].huatifenlei
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.sheyinghuatiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "zuopinfabu/autoSort";
			data = {
				page: 1,
				limit: 6,
			}
			data['sfsh'] = '是'
			if(this.recommendIndex12zuopinfabu != 0){
				data.zuopinfenlei = this.recommendList12zuopinfabu[this.recommendIndex12zuopinfabu - 1].zuopinfenlei
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.zuopinfabuRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get('sheyingshebei/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.sheyingshebeiList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 4px solid #FFC174;
			border-radius: 90px 0 0 90px;
			padding: 0 30px 0 10px;
			box-shadow: none;
			outline: none;
			color: #000;
			background: linear-gradient(360deg, #F4D09B 0%, #FEFAF4 100%);
			width: 120px;
			font-size: 16px;
			border-color: #FFC174 #000 #FFC174 #FFC174;
			border-width: 4px 1px 4px 4px;
			height: 90px;
		}
		
		.search .input /deep/ .el-input__inner {
			border: 4px solid #FFC174;
			border-radius: 0 90px 90px 0;
			padding: 0 10px;
			box-shadow: none;
			outline: none;
			color: #000;
			background: linear-gradient(360deg, #F4D09B 0%, #FEFAF4 100%);
			width: 100%;
			font-size: 16px;
			border-width: 4px 4px 4px 0;
			height: 90px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				background: #20454E !important;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				background: #20454E !important;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	







	.home-preview .recommend .list12 .tab .item {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				margin: 0 10px;
				color: #999;
				display: flex;
				font-size: 16px;
				line-height: 1;
				flex-direction: column;
				background: url(http://codegen.caihongy.cn/20240110/c5e5d110806b4a988878669fb65d880f.png) center center / 100% 100% no-repeat;
				width: 140px;
				justify-content: center;
				align-items: center;
				height: 140px;
			}
	
	.home-preview .recommend .list12 .tab .item:hover {
				color: #20454E;
				font-size: 18px;
			}
	
	.home-preview .recommend .list12 .tab .item.active {
				color: #20454E;
				font-size: 18px;
				border-color: #999;
				border-width: 0;
				border-style: solid;
			}
	
	.home-preview .recommend .list12 .tab .more {
				cursor: pointer;
				padding: 5px 10px;
				margin: 0 10px;
				color: #666;
				background: #fff;
				display: none;
				line-height: 44px;
				align-items: center;
			}
	
	.home-preview .recommend .list12 .tab .more:hover {
				opacity: 0.5;
			}
	
	.home-preview .recommend .list12 .item.active {
	  animation-name: mymove;
	
	  &:nth-of-type(1) {
	    animation-duration: 1s;
	  }
	  &:nth-of-type(2) {
	    animation-duration: 1.2s;
	  }
	  &:nth-of-type(3) {
	    animation-duration: 1.4s;
	  }
	  &:nth-of-type(4) {
	    animation-duration: 1.6s;
	  }
	  &:nth-of-type(5) {
	    animation-duration: 1.8s;
	  }
	  &:nth-of-type(6) {
	    animation-duration: 2s;
	  }
	}
	
	@keyframes mymove
	{
		from {top: 320px;}
		to {top: 0;}
	}



</style>
