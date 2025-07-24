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
import Favorites from '../pages/favorites/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import ordinaryUserList from '../pages/ordinaryUser/list'
import ordinaryUserDetail from '../pages/ordinaryUser/detail'
import ordinaryUserAdd from '../pages/ordinaryUser/add'
import photographyWorksList from '../pages/photographyWorks/list'
import photographyWorksDetail from '../pages/photographyWorks/detail'
import photographyWorksAdd from '../pages/photographyWorks/add'
import workCategoryList from '../pages/workCategory/list'
import workCategoryDetail from '../pages/workCategory/detail'
import workCategoryAdd from '../pages/workCategory/add'
import photographyEquipmentsList from '../pages/photographyEquipments/list'
import photographyEquipmentsDetail from '../pages/photographyEquipments/detail'
import photographyEquipmentsAdd from '../pages/photographyEquipments/add'
import equipmentRentalList from '../pages/equipmentRental/list'
import equipmentRentalDetail from '../pages/equipmentRental/detail'
import equipmentRentalAdd from '../pages/equipmentRental/add'
import equipmentReturnsList from '../pages/equipmentReturns/list'
import equipmentReturnsDetail from '../pages/equipmentReturns/detail'
import equipmentReturnsAdd from '../pages/equipmentReturns/add'
import eventsList from '../pages/events/list'
import eventsDetail from '../pages/events/detail'
import eventsAdd from '../pages/events/add'
import activityRegistrationList from '../pages/activityRegistration/list'
import activityRegistrationDetail from '../pages/activityRegistration/detail'
import activityRegistrationAdd from '../pages/activityRegistration/add'
import photographyTopicsList from '../pages/photographyTopics/list'
import photographyTopicsDetail from '../pages/photographyTopics/detail'
import photographyTopicsAdd from '../pages/photographyTopics/add'
import workPublishList from '../pages/workPublish/list'
import workPublishDetail from '../pages/workPublish/detail'
import workPublishAdd from '../pages/workPublish/add'
import topicCategoriesList from '../pages/topicCategories/list'
import topicCategoriesDetail from '../pages/topicCategories/detail'
import topicCategoriesAdd from '../pages/topicCategories/add'
import workVoteList from '../pages/workVote/list'
import workVoteDetail from '../pages/workVote/detail'
import workVoteAdd from '../pages/workVote/add'
import newsTypeList from '../pages/newsType/list'
import newsTypeDetail from '../pages/newsType/detail'
import newsTypeAdd from '../pages/newsType/add'
import aboutUsList from '../pages/aboutUs/list'
import aboutUsDetail from '../pages/aboutUs/detail'
import aboutUsAdd from '../pages/aboutUs/add'
import systemIntroList from '../pages/systemIntro/list'
import systemIntroDetail from '../pages/systemIntro/detail'
import systemIntroAdd from '../pages/systemIntro/add'
import discussWorkCommentsList from '../pages/discussWorkComments/list'
import discussWorkCommentsDetail from '../pages/discussWorkComments/detail'
import discussWorkCommentsAdd from '../pages/discussWorkComments/add'
import equipmentCommentsList from '../pages/equipmentComments/list'
import equipmentCommentsDetail from '../pages/equipmentComments/detail'
import equipmentCommentsAdd from '../pages/equipmentComments/add'
import photographyTopicCommentsList from '../pages/photographyTopicComments/list'
import photographyTopicCommentsDetail from '../pages/photographyTopicComments/detail'
import photographyTopicCommentsAdd from '../pages/photographyTopicComments/add'
import workCommentsList from '../pages/workComments/list'
import workCommentsDetail from '../pages/workComments/detail'
import workCommentsAdd from '../pages/workComments/add'

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
					path: 'favorites',
					component: Favorites
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
					path: 'ordinaryUser',
					component: ordinaryUserList
				},
				{
					path: 'ordinaryUserDetail',
					component: ordinaryUserDetail
				},
				{
					path: 'ordinaryUserAdd',
					component: ordinaryUserAdd
				},
				{
					path: 'photographyWorks',
					component: photographyWorksList
				},
				{
					path: 'photographyWorksDetail',
					component: photographyWorksDetail
				},
				{
					path: 'photographyWorksAdd',
					component: photographyWorksAdd
				},
				{
					path: 'workCategory',
					component: workCategoryList
				},
				{
					path: 'workCategoryDetail',
					component: workCategoryDetail
				},
				{
					path: 'workCategoryAdd',
					component: workCategoryAdd
				},
				{
					path: 'photographyEquipments',
					component: photographyEquipmentsList
				},
				{
					path: 'photographyEquipmentsDetail',
					component: photographyEquipmentsDetail
				},
				{
					path: 'photographyEquipmentsAdd',
					component: photographyEquipmentsAdd
				},
				{
					path: 'equipmentRental',
					component: equipmentRentalList
				},
				{
					path: 'equipmentRentalDetail',
					component: equipmentRentalDetail
				},
				{
					path: 'equipmentRentalAdd',
					component: equipmentRentalAdd
				},
				{
					path: 'equipmentReturns',
					component: equipmentReturnsList
				},
				{
					path: 'equipmentReturnsDetail',
					component: equipmentReturnsDetail
				},
				{
					path: 'equipmentReturnsAdd',
					component: equipmentReturnsAdd
				},
				{
					path: 'events',
					component: eventsList
				},
				{
					path: 'eventsDetail',
					component: eventsDetail
				},
				{
					path: 'eventsAdd',
					component: eventsAdd
				},
				{
					path: 'activityRegistration',
					component: activityRegistrationList
				},
				{
					path: 'activityRegistrationDetail',
					component: activityRegistrationDetail
				},
				{
					path: 'activityRegistrationAdd',
					component: activityRegistrationAdd
				},
				{
					path: 'photographyTopics',
					component: photographyTopicsList
				},
				{
					path: 'photographyTopicsDetail',
					component: photographyTopicsDetail
				},
				{
					path: 'photographyTopicsAdd',
					component: photographyTopicsAdd
				},
				{
					path: 'workPublish',
					component: workPublishList
				},
				{
					path: 'workPublishDetail',
					component: workPublishDetail
				},
				{
					path: 'workPublishAdd',
					component: workPublishAdd
				},
				{
					path: 'topicCategories',
					component: topicCategoriesList
				},
				{
					path: 'topicCategoriesDetail',
					component: topicCategoriesDetail
				},
				{
					path: 'topicCategoriesAdd',
					component: topicCategoriesAdd
				},
				{
					path: 'workVote',
					component: workVoteList
				},
				{
					path: 'workVoteDetail',
					component: workVoteDetail
				},
				{
					path: 'workVoteAdd',
					component: workVoteAdd
				},
				{
					path: 'newsType',
					component: newsTypeList
				},
				{
					path: 'newsTypeDetail',
					component: newsTypeDetail
				},
				{
					path: 'newsTypeAdd',
					component: newsTypeAdd
				},
				{
					path: 'aboutUs',
					component: aboutUsList
				},
				{
					path: 'aboutUsDetail',
					component: aboutUsDetail
				},
				{
					path: 'aboutUsAdd',
					component: aboutUsAdd
				},
				{
					path: 'systemIntro',
					component: systemIntroList
				},
				{
					path: 'systemIntroDetail',
					component: systemIntroDetail
				},
				{
					path: 'systemIntroAdd',
					component: systemIntroAdd
				},
				{
					path: 'discussWorkComments',
					component: discussWorkCommentsList
				},
				{
					path: 'discussWorkCommentsDetail',
					component: discussWorkCommentsDetail
				},
				{
					path: 'discussWorkCommentsAdd',
					component: discussWorkCommentsAdd
				},
				{
					path: 'equipmentComments',
					component: equipmentCommentsList
				},
				{
					path: 'equipmentCommentsDetail',
					component: equipmentCommentsDetail
				},
				{
					path: 'equipmentCommentsAdd',
					component: equipmentCommentsAdd
				},
				{
					path: 'photographyTopicComments',
					component: photographyTopicCommentsList
				},
				{
					path: 'photographyTopicCommentsDetail',
					component: photographyTopicCommentsDetail
				},
				{
					path: 'photographyTopicCommentsAdd',
					component: photographyTopicCommentsAdd
				},
				{
					path: 'workComments',
					component: workCommentsList
				},
				{
					path: 'workCommentsDetail',
					component: workCommentsDetail
				},
				{
					path: 'workCommentsAdd',
					component: workCommentsAdd
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
