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
import workVote from '@/views/modules/workVote/list'
import aboutUs from '@/views/modules/aboutUs/list'
import workPublish from '@/views/modules/workPublish/list'
import topicCategories from '@/views/modules/topicCategories/list'
import equipmentReturns from '@/views/modules/equipmentReturns/list'
import events from '@/views/modules/events/list'
import discussWorkComments from '@/views/modules/discussWorkComments/list'
import equipmentComments from '@/views/modules/equipmentComments/list'
import activityRegistration from '@/views/modules/activityRegistration/list'
import forum from '@/views/modules/forum/list'
import workComments from '@/views/modules/workComments/list'
import workCategory from '@/views/modules/workCategory/list'
import photographyTopicComments from '@/views/modules/photographyTopicComments/list'
import photographyTopics from '@/views/modules/photographyTopics/list'
import systemIntro from '@/views/modules/systemIntro/list'
import ordinaryUser from '@/views/modules/ordinaryUser/list'
import messages from '@/views/modules/messages/list'
import photographyWorks from '@/views/modules/photographyWorks/list'
import orders from '@/views/modules/orders/list'
import photographyEquipments from '@/views/modules/photographyEquipments/list'
import config from '@/views/modules/config/list'
import equipmentRental from '@/views/modules/equipmentRental/list'
import newsType from '@/views/modules/newsType/list'


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
        meta: {icon: '', title: 'center', affix: true}
    }, {
        path: '/updatePassword',
        name: '修改密码',
        component: UpdatePassword,
        meta: {icon: '', title: 'updatePassword'}
    }, {
        path: '/pay',
        name: '支付',
        component: pay,
        meta: {icon: '', title: 'pay'}
    }, {
        path: '/center',
        name: '个人信息',
        component: center,
        meta: {icon: '', title: 'center'}
    }
        , {
            path: '/news',
            name: '新闻资讯',
            component: news
        }
        , {
            path: '/workVote',
            name: '作品投票',
            component: workVote
        }
        , {
            path: '/aboutUs',
            name: '关于我们',
            component: aboutUs
        }
        , {
            path: '/workPublish',
            name: '作品发布',
            component: workPublish
        }
        , {
            path: '/topicCategories',
            name: '话题分类',
            component: topicCategories
        }
        , {
            path: '/equipmentReturns',
            name: '设备归还',
            component: equipmentReturns
        }
        , {
            path: '/events',
            name: '摄影活动',
            component: events
        }
        , {
            path: '/discussWorkComments',
            name: '摄影作品评论',
            component: discussWorkComments
        }
        , {
            path: '/equipmentComments',
            name: '摄影设备评论',
            component: equipmentComments
        }
        , {
            path: '/activityRegistration',
            name: '报名活动',
            component: activityRegistration
        }
        , {
            path: '/forum',
            name: '论坛管理',
            component: forum
        }
        , {
            path: '/workComments',
            name: '作品发布评论',
            component: workComments
        }
        , {
            path: '/workCategory',
            name: '作品分类',
            component: workCategory
        }
        , {
            path: '/photographyTopicComments',
            name: '摄影话题评论',
            component: photographyTopicComments
        }
        , {
            path: '/photographyTopics',
            name: '摄影话题',
            component: photographyTopics
        }
        , {
            path: '/systemIntro',
            name: '系统简介',
            component: systemIntro
        }
        , {
            path: '/ordinaryUser',
            name: '用户',
            component: ordinaryUser
        }
        , {
            path: '/messages',
            name: '留言板管理',
            component: messages
        }
        , {
            path: '/photographyWorks',
            name: '摄影作品',
            component: photographyWorks
        }
        , {
            path: '/orders/:status',
            name: '订单管理',
            component: orders
        }
        , {
            path: '/photographyEquipments',
            name: '摄影设备',
            component: photographyEquipments
        }
        , {
            path: '/config',
            name: '轮播图管理',
            component: config
        }
        , {
            path: '/equipmentRental',
            name: '摄影设备租用',
            component: equipmentRental
        }
        , {
            path: '/newsType',
            name: '资讯分类',
            component: newsType
        }
    ]
},
    {
        path: '/login',
        name: 'login',
        component: Login,
        meta: {icon: '', title: 'login'}
    },
    {
        path: '/register',
        name: 'register',
        component: register,
        meta: {icon: '', title: 'register'}
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
