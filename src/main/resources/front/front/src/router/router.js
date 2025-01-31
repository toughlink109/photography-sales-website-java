import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import sheyingzuopinList from '../pages/sheyingzuopin/list'
import sheyingzuopinDetail from '../pages/sheyingzuopin/detail'
import sheyingzuopinAdd from '../pages/sheyingzuopin/add'
import zuopinfenleiList from '../pages/zuopinfenlei/list'
import zuopinfenleiDetail from '../pages/zuopinfenlei/detail'
import zuopinfenleiAdd from '../pages/zuopinfenlei/add'
import sheyingshebeiList from '../pages/sheyingshebei/list'
import sheyingshebeiDetail from '../pages/sheyingshebei/detail'
import sheyingshebeiAdd from '../pages/sheyingshebei/add'
import sheyingshebeizuyongList from '../pages/sheyingshebeizuyong/list'
import sheyingshebeizuyongDetail from '../pages/sheyingshebeizuyong/detail'
import sheyingshebeizuyongAdd from '../pages/sheyingshebeizuyong/add'
import shebeiguihaiList from '../pages/shebeiguihai/list'
import shebeiguihaiDetail from '../pages/shebeiguihai/detail'
import shebeiguihaiAdd from '../pages/shebeiguihai/add'
import sheyinghuodongList from '../pages/sheyinghuodong/list'
import sheyinghuodongDetail from '../pages/sheyinghuodong/detail'
import sheyinghuodongAdd from '../pages/sheyinghuodong/add'
import baominghuodongList from '../pages/baominghuodong/list'
import baominghuodongDetail from '../pages/baominghuodong/detail'
import baominghuodongAdd from '../pages/baominghuodong/add'
import sheyinghuatiList from '../pages/sheyinghuati/list'
import sheyinghuatiDetail from '../pages/sheyinghuati/detail'
import sheyinghuatiAdd from '../pages/sheyinghuati/add'
import zuopinfabuList from '../pages/zuopinfabu/list'
import zuopinfabuDetail from '../pages/zuopinfabu/detail'
import zuopinfabuAdd from '../pages/zuopinfabu/add'
import huatifenleiList from '../pages/huatifenlei/list'
import huatifenleiDetail from '../pages/huatifenlei/detail'
import huatifenleiAdd from '../pages/huatifenlei/add'
import zuopintoupiaoList from '../pages/zuopintoupiao/list'
import zuopintoupiaoDetail from '../pages/zuopintoupiao/detail'
import zuopintoupiaoAdd from '../pages/zuopintoupiao/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discusssheyingzuopinList from '../pages/discusssheyingzuopin/list'
import discusssheyingzuopinDetail from '../pages/discusssheyingzuopin/detail'
import discusssheyingzuopinAdd from '../pages/discusssheyingzuopin/add'
import discusssheyingshebeiList from '../pages/discusssheyingshebei/list'
import discusssheyingshebeiDetail from '../pages/discusssheyingshebei/detail'
import discusssheyingshebeiAdd from '../pages/discusssheyingshebei/add'
import discusssheyinghuatiList from '../pages/discusssheyinghuati/list'
import discusssheyinghuatiDetail from '../pages/discusssheyinghuati/detail'
import discusssheyinghuatiAdd from '../pages/discusssheyinghuati/add'
import discusszuopinfabuList from '../pages/discusszuopinfabu/list'
import discusszuopinfabuDetail from '../pages/discusszuopinfabu/detail'
import discusszuopinfabuAdd from '../pages/discusszuopinfabu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'sheyingzuopin',
					component: sheyingzuopinList
				},
				{
					path: 'sheyingzuopinDetail',
					component: sheyingzuopinDetail
				},
				{
					path: 'sheyingzuopinAdd',
					component: sheyingzuopinAdd
				},
				{
					path: 'zuopinfenlei',
					component: zuopinfenleiList
				},
				{
					path: 'zuopinfenleiDetail',
					component: zuopinfenleiDetail
				},
				{
					path: 'zuopinfenleiAdd',
					component: zuopinfenleiAdd
				},
				{
					path: 'sheyingshebei',
					component: sheyingshebeiList
				},
				{
					path: 'sheyingshebeiDetail',
					component: sheyingshebeiDetail
				},
				{
					path: 'sheyingshebeiAdd',
					component: sheyingshebeiAdd
				},
				{
					path: 'sheyingshebeizuyong',
					component: sheyingshebeizuyongList
				},
				{
					path: 'sheyingshebeizuyongDetail',
					component: sheyingshebeizuyongDetail
				},
				{
					path: 'sheyingshebeizuyongAdd',
					component: sheyingshebeizuyongAdd
				},
				{
					path: 'shebeiguihai',
					component: shebeiguihaiList
				},
				{
					path: 'shebeiguihaiDetail',
					component: shebeiguihaiDetail
				},
				{
					path: 'shebeiguihaiAdd',
					component: shebeiguihaiAdd
				},
				{
					path: 'sheyinghuodong',
					component: sheyinghuodongList
				},
				{
					path: 'sheyinghuodongDetail',
					component: sheyinghuodongDetail
				},
				{
					path: 'sheyinghuodongAdd',
					component: sheyinghuodongAdd
				},
				{
					path: 'baominghuodong',
					component: baominghuodongList
				},
				{
					path: 'baominghuodongDetail',
					component: baominghuodongDetail
				},
				{
					path: 'baominghuodongAdd',
					component: baominghuodongAdd
				},
				{
					path: 'sheyinghuati',
					component: sheyinghuatiList
				},
				{
					path: 'sheyinghuatiDetail',
					component: sheyinghuatiDetail
				},
				{
					path: 'sheyinghuatiAdd',
					component: sheyinghuatiAdd
				},
				{
					path: 'zuopinfabu',
					component: zuopinfabuList
				},
				{
					path: 'zuopinfabuDetail',
					component: zuopinfabuDetail
				},
				{
					path: 'zuopinfabuAdd',
					component: zuopinfabuAdd
				},
				{
					path: 'huatifenlei',
					component: huatifenleiList
				},
				{
					path: 'huatifenleiDetail',
					component: huatifenleiDetail
				},
				{
					path: 'huatifenleiAdd',
					component: huatifenleiAdd
				},
				{
					path: 'zuopintoupiao',
					component: zuopintoupiaoList
				},
				{
					path: 'zuopintoupiaoDetail',
					component: zuopintoupiaoDetail
				},
				{
					path: 'zuopintoupiaoAdd',
					component: zuopintoupiaoAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discusssheyingzuopin',
					component: discusssheyingzuopinList
				},
				{
					path: 'discusssheyingzuopinDetail',
					component: discusssheyingzuopinDetail
				},
				{
					path: 'discusssheyingzuopinAdd',
					component: discusssheyingzuopinAdd
				},
				{
					path: 'discusssheyingshebei',
					component: discusssheyingshebeiList
				},
				{
					path: 'discusssheyingshebeiDetail',
					component: discusssheyingshebeiDetail
				},
				{
					path: 'discusssheyingshebeiAdd',
					component: discusssheyingshebeiAdd
				},
				{
					path: 'discusssheyinghuati',
					component: discusssheyinghuatiList
				},
				{
					path: 'discusssheyinghuatiDetail',
					component: discusssheyinghuatiDetail
				},
				{
					path: 'discusssheyinghuatiAdd',
					component: discusssheyinghuatiAdd
				},
				{
					path: 'discusszuopinfabu',
					component: discusszuopinfabuList
				},
				{
					path: 'discusszuopinfabuDetail',
					component: discusszuopinfabuDetail
				},
				{
					path: 'discusszuopinfabuAdd',
					component: discusszuopinfabuAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
