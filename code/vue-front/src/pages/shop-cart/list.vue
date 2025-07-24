<template>
	<div :style='{"width":"100%","padding":"0 10%","margin":"10px auto","position":"relative","background":"none"}'>
		<div class="section-title" :style='{"margin":"10px auto 0","color":"#FFC174","borderRadius":"60px","textAlign":"center","background":"#8E4033","width":"80%","fontSize":"24px","lineHeight":"54px","fontWeight":"bold"}'>购物车</div>
		<el-button size="small" type="danger" @click="delAllClick" :disabled="selRows.length?false:true">删除</el-button>
		<el-table @selection-change="handleSelectionChange" :data="tableData" style="width: 100%">
			<el-table-column type="selection" width="50" align="center" />
			<el-table-column label="商品名称">
				<template slot-scope="scope">
					<div class="shangpin">
						<el-image style="width: 100px; height: 100px;flex: 1"
							:src="baseUrl + scope.row.picture" fit="fill"></el-image>
						<span style="margin-left: 10px;flex: 1">{{ scope.row.productTitle }}</span>
					</div>
				</template>
			</el-table-column>
			<el-table-column label="价格">
				<template slot-scope="scope">
					<span :style='{"fontSize":"12px"}'>￥</span>{{ scope.row.price }}
				</template>
			</el-table-column>
			<el-table-column label="数量">
				<template slot-scope="scope">
					<el-input-number :min="1" v-model="scope.row.quantity" @change="(value) => handleChange(value, scope.$index, scope.row)" size="small"></el-input-number>
				</template>
			</el-table-column>
			<el-table-column label="总价">
				<template slot-scope="scope">
					<span :style='{"fontSize":"12px"}'>￥</span>{{ (scope.row.price * scope.row.quantity).toFixed(2) }}
				</template>
			</el-table-column>
			<el-table-column label="操作" width="150">
				<template slot-scope="scope">
					<el-button size="mini" type="danger"
						@click="handleDelete(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		<div class="buy" v-if="tableData.length > 0">
			<span style="color: red;margin-right: 10px;font-weight: 700;">总价：<span :style='{"fontSize":"12px"}'>￥</span>{{totalPrice}}</span>
			<el-button type="warning" @click="buyClick">点击购买</el-button>
		</div>
	</div>
</template>

<script>
	import config from '@/config/config'
	export default {
		data() {
			return {
				baseUrl: config.baseUrl,
				tableData: [],
				selRows:[]
			}
		},
		created() {
			this.getCartList();
		},
		methods: {
			handleSelectionChange(e){
				this.selRows = e
			},
			getCartList() {
				this.$http.get('cart/list', {params: {page: 1, limit: 1000, userId: localStorage.getItem('frontUserId')}}).then(res => {
					if (res.data.code == 0) {
						this.tableData = res.data.data.list;
					}
				});
			},
			handleChange(value, index, row) {
				this.$http.get(`${row.tableName}/detail/${row.productId}`).then(res => {
					if (res.data.code == 0) {
						if (res.data.data.limitOne&&res.data.data.limitOne > 0) {
							if (value > res.data.data.limitOne) {
								this.tableData[index].quantity = --value;
								this.$message.error(`每人单次只能购买${res.data.data.limitOne}件`);
							} else {
								row.quantity = value;
								this.$http.post('cart/update', row).then(res => {});
							}
						} else {
							row.quantity = value;
							this.$http.post('cart/update', row).then(res => {});
						}
					}
				});
			},
			handleDelete(index, row) {
				this.$confirm('是否确认删除?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					let delIds = new Array();
					delIds.push(row.id);
					this.$http.post('cart/delete', delIds).then(res => {
						if (res.data.code == 0) {
							this.$message({
								type: 'success',
								message: '删除成功!',
								duration: 1500,
								onClose: () => {
									this.getCartList();
								}
							});
						}
					});
				});
			},
			delAllClick(){
				this.$confirm('是否确认选中商品删除?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					let delIds = new Array();
					for(let x in this.selRows){
						delIds.push(this.selRows[x].id)
					}
					this.$http.post('cart/delete', delIds).then(res => {
						if (res.data.code == 0) {
							this.$message({
								type: 'success',
								message: '删除成功!',
								duration: 1500,
								onClose: () => {
									this.getCartList();
								}
							});
						}
					});
				});
			},
			buyClick() {
				if(this.selRows.length==0) {
					this.$message({
						type: 'warning',
						message: '请选择商品',
						duration: 1500,
					});
					return
				}
				var gn = "";
				for(let x in this.selRows){
					var g = this.selRows[x];
					console.log(g.productTitle)
					let that = this;
					this.$http.get(`${g.tableName}/detail/${g.productId}`).then(res => {
						if (res.data.code == 0 && g.quantity > res.data.data.goodsStocks) {
							gn = g.productTitle;
						}
					});
				}
			
				setTimeout(() => {
					if(gn=="") {
						localStorage.setItem('orderGoods', JSON.stringify(this.selRows));
						this.$router.push('/index/shop-order/orderConfirm');
					} else {
						this.$message.error(gn+` 库存不足`);
						return;
					}
				}, 200)
			}
		},
		computed: {
			totalPrice() {
				let totalPrice = 0;
				for(let x in this.selRows){
					  totalPrice += Number(this.selRows[x].price) * Number(this.selRows[x].quantity)
				}
				return totalPrice.toFixed(2);
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.section {
		width: 900px;
		margin: 0 auto;
	}
	
	.shangpin {
		display: flex;
	}
	.buy {
		text-align: right;
		padding-right: 82px;
	}
</style>
