<template>
<div :style='{"width":"100%","padding":"0 10%","margin":"10px auto","position":"relative","background":"none"}'>
    <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"#FFC174","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="warning" size="mini" @click="backClick" class="el-icon-back">返回</el-button>
    <div class="section-title" :style='{"margin":"10px auto 0","color":"#FFC174","borderRadius":"60px","textAlign":"center","background":"#8E4033","width":"80%","fontSize":"24px","lineHeight":"54px","fontWeight":"bold"}'>我的订单</div>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="未支付" name="未支付"></el-tab-pane>
      <el-tab-pane label="已支付" name="已支付"></el-tab-pane>
      <el-tab-pane label="已发货" name="已发货"></el-tab-pane>
      <el-tab-pane label="已完成" name="已完成"></el-tab-pane>
      <el-tab-pane label="已退款" name="已退款"></el-tab-pane>
      <el-tab-pane label="已取消" name="已取消"></el-tab-pane>
    </el-tabs>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="订单编号" prop="orderId"></el-table-column>
      <el-table-column label="商品" align="center" width="200px">
        <template slot-scope="scope">
          <div class="shangpin">
            <el-image style="width: 100px; height: 100px;flex: 1" :src="baseUrl + scope.row.picture" fit="fill"></el-image>
            <span style="margin-left: 10px;flex: 1" >{{ scope.row.productTitle }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="价格">
        <template slot-scope="scope">
          <span v-if="(scope.row.type == 1 || scope.row.type == 3)&&scope.row.price>0"><span :style='{"fontSize":"12px"}'>￥</span>{{ scope.row.price }}</span>
          <span v-if="scope.row.type == 2&&scope.row.price>0">{{ scope.row.price }}积分</span>
        </template>
      </el-table-column>
      <el-table-column label="数量" prop="quantity"></el-table-column>
      <el-table-column label="总价">
        <template slot-scope="scope">
          <span v-if="(scope.row.type == 1 || scope.row.type == 3)&&scope.row.total>0"><span :style='{"fontSize":"12px"}'>￥</span>{{ scope.row.total }}</span>
          <span v-if="scope.row.type == 2&&scope.row.total>0">{{ scope.row.total }}积分</span>
        </template>
      </el-table-column>
      <el-table-column label="地址" prop="address"></el-table-column>
      <el-table-column label="电话" prop="tel"></el-table-column>
      <el-table-column label="收货人" prop="consignee"></el-table-column>
      <el-table-column label="下单时间" prop="addTime"></el-table-column>
      <el-table-column label="备注" prop="remark"></el-table-column>
      <el-table-column label="退货审核" prop="isApproved">
		<template slot-scope="scope">
		  <el-tag type="success" v-if="scope.row.isApproved=='是'">已通过</el-tag>
		  <el-tag type="warning" v-if="scope.row.isApproved=='待审核'">待审核</el-tag>
		  <el-tag type="danger" v-if="scope.row.isApproved=='否'">未通过</el-tag>
		</template>
	  </el-table-column>
      <el-table-column label="审核回复" prop="approvedComments"></el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button v-show="activeName == '未支付'" type="success" :style='{"margin":"2px auto",}' size="mini" @click="pay(scope.row)">支付</el-button>
          <el-button v-show="activeName == '未支付'" type="danger" :style='{"margin":"2px auto",}' size="mini" @click="cancel(scope.row)">取消</el-button>
          <el-button v-show="activeName == '已支付'" type="danger" :style='{"margin":"2px auto",}' size="mini" @click="refund(scope.row)">{{scope.row.total>0?'退款':'退订'}}</el-button>
          <el-button v-if="scope.row.logistics" type="warning" :style='{"margin":"2px auto",}' size="mini" @click="logistics(scope.row)">物流</el-button>
          <el-button v-if="activeName == '已完成'&&scope.row.isApproved==''" type="danger" :style='{"margin":"2px auto",}' size="mini" @click="returnGood(scope.row)">退货</el-button>
          <el-button v-show="activeName == '已完成'" type="primary" :style='{"margin":"2px auto",}' size="mini" @click="toDetail(scope.row)">评价</el-button>
          <el-button v-show="activeName == '已发货'" type="success" :style='{"margin":"2px auto",}' size="mini" @click="confirm(scope.row)">确认收货</el-button>
        </template>
      </el-table-column>
    </el-table>
    
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

    <el-dialog title="物流信息" :visible.sync="logisticsVisible" width="30%">
        <div v-html="logisticsText"></div>
    </el-dialog>
	
</div>
</template>

<script>
  import config from '@/config/config'
  export default {
    data() {
      return {
		layouts: '',
        baseUrl: config.baseUrl,
        activeName: '未支付',
        tableData: [],
        total: 1,
        pageSize: 10,
        totalPage: 1,
        session: {},
        userTableName: localStorage.getItem('UserTableName'),
        logisticsVisible: false,
        logisticsText: ''
      }
    },
    created() {
      this.getSession();
      this.getMyOrderList(1);
    },
    methods: {
      backClick() {
          this.$router.push('/index/center')
      },
      getSession() {
        this.$http.get(this.userTableName+'/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.session = res.data.data;
          }
        });
      },
      handleClick(tab, event) {
        tab.activeName = event.target.outerText;
        this.getMyOrderList(1);
      },
      toDetail(row) {
          this.$router.push({path: '/index/'+row.tableName+'Detail', query: {id: row.productId}});
      },
      handleAction(index, row) {
        if (index == '已支付' && this.session.money < row.total) {
          this.$message.error('余额不足，请先充值');
          return;
        }

        row.status = index;
        this.$http.post('orders/update', row).then(res => {
          if (res.data.code == 0) {
            if (index == '已支付') this.session.money -= row.total;
            if (index == '已退款' && row.type == 1) this.session.money += row.total;
            if (index == '已退款' && row.type == 2) this.session.jifen += row.total;
            if (index == '已支付' || index == '已退款') {
              this.session.money = this.session.money.toFixed(2);
              this.$http.post(this.userTableName+'/update', this.session).then(res => {});
            }
            this.$message({
              message: '操作成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.getMyOrderList(1);
              }
            });
          }
        });
      },
        // 退款
        refund(item) {
            this.$confirm(`${item.total>0?'确定退款吗？退款金额将返回账户中。':'是否退订？'}`, "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            }).then(() => {
				
                // 获取商品详情信息
                this.$http.get(item.tableName+'/info/'+item.productId, {}).then(res => {
                    // 商品信息
                    let good = res.data.data;
                    // 用户当前用户信息
                    let table = localStorage.getItem("UserTableName");
                    this.$http.get(table+'/session', {}).then(res => {
                        this.user = res.data.data;
                        if(item.type==1||item.type==3) {
                            // 如果该商品存在积分
                            if (good.jf) {
                                this.user.jf = (Number(this.user.jf) - Number(item.total)).toFixed(2);
                            }
                            this.user.money = (Number(this.user.money) + Number(item.total)).toFixed(2);
                            // 更新用户余额
                            this.$http.post(table+'/update', this.user).then(res => {
                                item.status = '已退款'
								localStorage.setItem('sessionForm',JSON.stringify(this.user))
                                this.$http.post(`orders/update`, item).then(res => {
                                    if(item.tableName == `photographyWorks`){
                                        // 加回库存数量
                                        good.goodsStocks = good.goodsStocks + item.quantity;
                                        this.$http.post(`photographyWorks/update`, good).then(res => {
                                        });
                                    }
                                    this.$message({
                                      message: `${item.total>0?'退款成功':'退订成功'}`,
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                        this.getMyOrderList(1);
                                      }
                                    });
                                });
                            });
                        } else if(item.type==2) {
                            this.user.jf = Number(this.user.jf) + Number(item.total);
                            // 更新用户余额
                            this.$http.post(table+'/update', this.user).then(res => {
                                item.status = '已退款'
								localStorage.setItem('sessionForm',JSON.stringify(this.user))
                                this.$http.post(`orders/update`, item).then(res => {
                                    if(item.tableName == `photographyWorks`){
                                        // 加回库存数量
                                        good.goodsStocks = good.goodsStocks + item.quantity;
                                        this.$http.post(`photographyWorks/update`, good).then(res => {
                                        });
                                    }
                                    this.$message({
                                      message: `${item.total>0?'退款成功':'退订成功'}`,
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                        this.getMyOrderList(1);
                                      }
                                    });
                                });
                            });

                        }
                    });
                });
            });
        },
        //物流
        logistics(row) {
            this.logisticsText = row.logistics;
            this.logisticsVisible = true;
        },
        //退货
        returnGood(item) {
            this.$confirm(`确定退货吗？审核通过后退款金额将返回账户中。`, "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            }).then(() => {
				item.isApproved = '待审核'
				this.$http.post(`orders/update`, item).then(res => {
					this.$message({
						message: '申请成功',
						type: 'success',
						duration: 1500,
						onClose: () => {
							this.getMyOrderList(1);
						}
					});
				})
            });
        },

        // 支付
        pay(item) {
            // 获取商品详情信息
            this.$http.get(item.tableName+'/info/'+item.productId, {}).then(res => {
                // 商品信息
                let data = res.data.data;
                // 用户当前用户信息
                let table = localStorage.getItem("UserTableName");
                this.$http.get(table+'/session', {}).then(res => {
                    this.user = res.data.data;
                    // 判断余额是否充足
                    if (Number(this.user.money) < Number(item.total)) {
                        this.$message({
                            message: '余额不足，请先充值',
                            type: 'error',
                            duration: 1500
                        });
                        return
                    }
                    // 如果该商品存在积分
                    if (data.jf) {
                        this.user.jf = Number((Number(this.user.jf) + Number(item.total)).toFixed(2));
                    }
                    this.user.money = Number((Number(this.user.money) - Number(item.total)).toFixed(2));
                    // 更新用户余额
                    this.$http.post(table+'/update', this.user).then(res => {
                        item.status = '已支付'
						localStorage.setItem('sessionForm',JSON.stringify(this.user))
                        this.$http.post(`orders/update`, item).then(res => {
                            this.$message({
                              message: '支付成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                this.getMyOrderList(1);
                              }
                            });
                        });
                    });
                });
            });
        },
      confirm(item){
          this.$confirm(`是否确定收货？`, "提示", {
              confirmButtonText: "确定",
              cancelButtonText: "取消",
              type: "warning"
          }).then(() => {
              item.status = '已完成'
              this.$http.post(`orders/update`, item).then(res => {
                  this.$message({
                    message: '确认收货成功',
                    type: 'success',
                    duration: 1500,
                    onClose: () => {
                      this.getMyOrderList(1);
                    }
                  });
              });
          });
      },
		cancel(item){
			this.$confirm(`是否取消订单？`, "提示", {
				confirmButtonText: "确定",
				cancelButtonText: "取消",
				type: "warning"
			}).then(() => {
				item.status = '已取消'
				this.$http.post(`orders/update`, item).then(res => {
                    // 获取商品详情信息
                    this.$http.get(item.tableName+'/info/'+item.productId, {}).then(res => {
                        // 商品信息
                        let good = res.data.data;
                        if(item.tableName == `photographyWorks`){
                            // 加回库存数量
                            good.goodsStocks = good.goodsStocks + item.quantity;
                            this.$http.post(`photographyWorks/update`, good).then(res => {
                            });
                        }
						this.$message({
							message: '订单取消成功',
							type: 'success',
							duration: 1500,
							onClose: () => {
								this.getMyOrderList(1);
							}
						});
					});
				});
			});
		},
		getMyOrderList(page) {
			this.$http.get('orders/list', {params: {page, limit: this.pageSize,sort:'addTime',order:'desc', userId: localStorage.getItem('frontUserId'), status: this.activeName}}).then(res => {
				if (res.data.code == 0) {
					this.tableData = res.data.data.list;
					this.total = res.data.data.total;
					this.pageSize = Number(res.data.data.pageSize);
					this.totalPage = res.data.data.totalPage;
				}
			});
		},
		curChange(page) {
			this.getMyOrderList(page);
		},
		prevClick(page) {
			this.getMyOrderList(page);
		},
		nextClick(page) {
			this.getMyOrderList(page);
		}
	}
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.section {
	  width: 1000px;
	  margin: 0 auto;
	}

	.shangpin {
	  display: flex;
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
