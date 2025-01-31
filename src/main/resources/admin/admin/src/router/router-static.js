import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import zuopintoupiao from '@/views/modules/zuopintoupiao/list'
    import aboutus from '@/views/modules/aboutus/list'
    import zuopinfabu from '@/views/modules/zuopinfabu/list'
    import huatifenlei from '@/views/modules/huatifenlei/list'
    import shebeiguihai from '@/views/modules/shebeiguihai/list'
    import sheyinghuodong from '@/views/modules/sheyinghuodong/list'
    import discusssheyingzuopin from '@/views/modules/discusssheyingzuopin/list'
    import discusssheyingshebei from '@/views/modules/discusssheyingshebei/list'
    import baominghuodong from '@/views/modules/baominghuodong/list'
    import forum from '@/views/modules/forum/list'
    import discusszuopinfabu from '@/views/modules/discusszuopinfabu/list'
    import zuopinfenlei from '@/views/modules/zuopinfenlei/list'
    import discusssheyinghuati from '@/views/modules/discusssheyinghuati/list'
    import sheyinghuati from '@/views/modules/sheyinghuati/list'
    import systemintro from '@/views/modules/systemintro/list'
    import yonghu from '@/views/modules/yonghu/list'
    import messages from '@/views/modules/messages/list'
    import sheyingzuopin from '@/views/modules/sheyingzuopin/list'
    import orders from '@/views/modules/orders/list'
    import sheyingshebei from '@/views/modules/sheyingshebei/list'
    import config from '@/views/modules/config/list'
    import sheyingshebeizuyong from '@/views/modules/sheyingshebeizuyong/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '新闻资讯',
        component: news
      }
      ,{
	path: '/zuopintoupiao',
        name: '作品投票',
        component: zuopintoupiao
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/zuopinfabu',
        name: '作品发布',
        component: zuopinfabu
      }
      ,{
	path: '/huatifenlei',
        name: '话题分类',
        component: huatifenlei
      }
      ,{
	path: '/shebeiguihai',
        name: '设备归还',
        component: shebeiguihai
      }
      ,{
	path: '/sheyinghuodong',
        name: '摄影活动',
        component: sheyinghuodong
      }
      ,{
	path: '/discusssheyingzuopin',
        name: '摄影作品评论',
        component: discusssheyingzuopin
      }
      ,{
	path: '/discusssheyingshebei',
        name: '摄影设备评论',
        component: discusssheyingshebei
      }
      ,{
	path: '/baominghuodong',
        name: '报名活动',
        component: baominghuodong
      }
      ,{
	path: '/forum',
        name: '论坛管理',
        component: forum
      }
      ,{
	path: '/discusszuopinfabu',
        name: '作品发布评论',
        component: discusszuopinfabu
      }
      ,{
	path: '/zuopinfenlei',
        name: '作品分类',
        component: zuopinfenlei
      }
      ,{
	path: '/discusssheyinghuati',
        name: '摄影话题评论',
        component: discusssheyinghuati
      }
      ,{
	path: '/sheyinghuati',
        name: '摄影话题',
        component: sheyinghuati
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
      ,{
	path: '/sheyingzuopin',
        name: '摄影作品',
        component: sheyingzuopin
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/sheyingshebei',
        name: '摄影设备',
        component: sheyingshebei
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/sheyingshebeizuyong',
        name: '摄影设备租用',
        component: sheyingshebeizuyong
      }
      ,{
	path: '/newstype',
        name: '资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
