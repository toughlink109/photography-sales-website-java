const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "用户",
                    "menuJump": "列表",
                    "tableName": "ordinaryUser"
                }], "menu": "用户管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "作品投票"],
                    "appFrontIcon": "cuIcon-similar",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "摄影作品",
                    "menuJump": "列表",
                    "tableName": "photographyWorks"
                }], "menu": "摄影作品管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-goodsnew",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "作品分类",
                    "menuJump": "列表",
                    "tableName": "workCategory"
                }], "menu": "作品分类管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "租用"],
                    "appFrontIcon": "cuIcon-shop",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "摄影设备",
                    "menuJump": "列表",
                    "tableName": "photographyEquipments"
                }], "menu": "摄影设备管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "支付", "设备归还"],
                    "appFrontIcon": "cuIcon-brand",
                    "buttons": ["查看", "修改", "删除", "审核"],
                    "menu": "摄影设备租用",
                    "menuJump": "列表",
                    "tableName": "equipmentRental"
                }], "menu": "摄影设备租用管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-attentionfavor",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "设备归还",
                    "menuJump": "列表",
                    "tableName": "equipmentReturns"
                }], "menu": "设备归还管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "报名"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "摄影活动",
                    "menuJump": "列表",
                    "tableName": "events"
                }], "menu": "摄影活动管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核"],
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["查看", "修改", "删除", "审核"],
                    "menu": "报名活动",
                    "menuJump": "列表",
                    "tableName": "activityRegistration"
                }], "menu": "报名活动管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-goods",
                    "buttons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "menu": "摄影话题",
                    "menuJump": "列表",
                    "tableName": "photographyTopics"
                }], "menu": "摄影话题管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-copy",
                    "buttons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "menu": "作品发布",
                    "menuJump": "列表",
                    "tableName": "workPublish"
                }], "menu": "作品发布管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-circle",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "话题分类",
                    "menuJump": "列表",
                    "tableName": "topicCategories"
                }], "menu": "话题分类管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-send",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "作品投票",
                    "menuJump": "列表",
                    "tableName": "workVote"
                }], "menu": "作品投票管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "论坛管理",
                    "tableName": "forum"
                }], "menu": "论坛管理"
            }, {
                "child": [{
                    "allButtons": ["查看", "修改", "回复", "删除"],
                    "appFrontIcon": "cuIcon-paint",
                    "buttons": ["查看", "修改", "回复", "删除"],
                    "menu": "留言板管理",
                    "tableName": "messages"
                }], "menu": "留言板管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-vipcard",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "allButtons": ["查看", "修改"],
                    "appFrontIcon": "cuIcon-camera",
                    "buttons": ["查看", "修改"],
                    "menu": "关于我们",
                    "tableName": "aboutUs"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-list",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "新闻资讯",
                    "tableName": "news"
                }, 
                // 关闭系统简介
                // {
                //     "allButtons": ["查看", "修改"],
                //     "appFrontIcon": "cuIcon-copy",
                //     "buttons": ["查看", "修改"],
                //     "menu": "系统简介",
                //     "tableName": "systemIntro"
                    
                // }, 
                {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-similar",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "资讯分类",
                    "tableName": "newsType"
                }], "menu": "系统管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流"],
                    "appFrontIcon": "cuIcon-time",
                    "buttons": ["查看", "删除"],
                    "menu": "已退款订单",
                    "tableName": "orders/已退款"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "确认收货", "物流"],
                    "appFrontIcon": "cuIcon-taxi",
                    "buttons": ["查看", "删除", "物流"],
                    "menu": "已发货订单",
                    "tableName": "orders/已发货"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["查看", "删除"],
                    "menu": "未支付订单",
                    "tableName": "orders/未支付"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "发货", "物流", "核销"],
                    "appFrontIcon": "cuIcon-shop",
                    "buttons": ["查看", "删除", "发货"],
                    "menu": "已支付订单",
                    "tableName": "orders/已支付"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流", "退货审核"],
                    "appFrontIcon": "cuIcon-pic",
                    "buttons": ["查看", "删除", "日销量", "月销量", "年销量", "日销额", "月销额", "年销额", "退货审核"],
                    "menu": "已完成订单",
                    "tableName": "orders/已完成"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
                    "appFrontIcon": "cuIcon-circle",
                    "buttons": ["查看", "删除"],
                    "menu": "已取消订单",
                    "tableName": "orders/已取消"
                }], "menu": "订单管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "作品投票"],
                    "appFrontIcon": "cuIcon-taxi",
                    "buttons": ["查看", "作品投票"],
                    "menu": "摄影作品列表",
                    "menuJump": "列表",
                    "tableName": "photographyWorks"
                }], "menu": "摄影作品模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "租用"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "租用"],
                    "menu": "摄影设备列表",
                    "menuJump": "列表",
                    "tableName": "photographyEquipments"
                }], "menu": "摄影设备模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "报名"],
                    "appFrontIcon": "cuIcon-pay",
                    "buttons": ["查看", "报名"],
                    "menu": "摄影活动列表",
                    "menuJump": "列表",
                    "tableName": "events"
                }], "menu": "摄影活动模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-cardboard",
                    "buttons": ["查看"],
                    "menu": "摄影话题列表",
                    "menuJump": "列表",
                    "tableName": "photographyTopics"
                }], "menu": "摄影话题模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-send",
                    "buttons": ["查看"],
                    "menu": "作品发布列表",
                    "menuJump": "列表",
                    "tableName": "workPublish"
                }], "menu": "作品发布模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "admins"
        }, {
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "支付", "设备归还"],
                    "appFrontIcon": "cuIcon-brand",
                    "buttons": ["设备归还", "查看", "支付"],
                    "menu": "摄影设备租用",
                    "menuJump": "列表",
                    "tableName": "equipmentRental"
                }], "menu": "摄影设备租用管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-attentionfavor",
                    "buttons": ["查看"],
                    "menu": "设备归还",
                    "menuJump": "列表",
                    "tableName": "equipmentReturns"
                }], "menu": "设备归还管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核"],
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["查看"],
                    "menu": "报名活动",
                    "menuJump": "列表",
                    "tableName": "activityRegistration"
                }], "menu": "报名活动管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-goods",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "摄影话题",
                    "menuJump": "列表",
                    "tableName": "photographyTopics"
                }], "menu": "摄影话题管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-copy",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "作品发布",
                    "menuJump": "列表",
                    "tableName": "workPublish"
                }], "menu": "作品发布管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-send",
                    "buttons": ["查看"],
                    "menu": "作品投票",
                    "menuJump": "列表",
                    "tableName": "workVote"
                }], "menu": "作品投票管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "作品投票"],
                    "appFrontIcon": "cuIcon-taxi",
                    "buttons": ["查看", "作品投票"],
                    "menu": "摄影作品列表",
                    "menuJump": "列表",
                    "tableName": "photographyWorks"
                }], "menu": "摄影作品模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "租用"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "租用"],
                    "menu": "摄影设备列表",
                    "menuJump": "列表",
                    "tableName": "photographyEquipments"
                }], "menu": "摄影设备模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "报名"],
                    "appFrontIcon": "cuIcon-pay",
                    "buttons": ["查看", "报名"],
                    "menu": "摄影活动列表",
                    "menuJump": "列表",
                    "tableName": "events"
                }], "menu": "摄影活动模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-cardboard",
                    "buttons": ["查看"],
                    "menu": "摄影话题列表",
                    "menuJump": "列表",
                    "tableName": "photographyTopics"
                }], "menu": "摄影话题模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论"],
                    "appFrontIcon": "cuIcon-send",
                    "buttons": ["查看"],
                    "menu": "作品发布列表",
                    "menuJump": "列表",
                    "tableName": "workPublish"
                }], "menu": "作品发布模块"
            }],
            "hasBackLogin": "否",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "用户",
            "tableName": "ordinaryUser"
        }]
    }
}
export default menu;
