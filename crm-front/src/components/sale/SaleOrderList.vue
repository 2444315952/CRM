<template>

	<div id="SaleOrderList">

		<el-row>
			<el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 16px">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item><a href="/PurchaseList">销售订单列表</a></el-breadcrumb-item>
			</el-breadcrumb>
		</el-row>

		<el-container style="background-color: white;padding-top: 15px;">

			<el-header style="height: 30px;">
				<el-row>

					<el-col :span="21">
						<el-input style="width: 290px;float: left;" placeholder="请输入销售机会名称"
							v-model="searchInput">
							<template #append>
								<el-button icon="el-icon-search" size="small" @click="handleSearch"></el-button>
							</template>
						</el-input>

					</el-col>

					<el-col :span="3">

						<el-button style="float: right;" icon="el-icon-plus" size="medium" type="primary"
							@click="toDetail()">新增销售订单</el-button>

					</el-col>
				</el-row>
			</el-header>

			<el-main style="background-color: white;">
				<el-table :data="tableData" max-height="477" style="width: 100%;height:477px;"
					highlight-current-row @current-change="handleCurrentChange">
					<el-table-column label="订单名称" prop="saleOrderName">
					</el-table-column>
					<el-table-column label="负责人" prop="empName">
					</el-table-column>
					<el-table-column label="所属客户" prop="customerName">
					</el-table-column>
					<el-table-column label="订单金额" prop="saleOrderAmount">
					</el-table-column>
					<el-table-column label="回款金额" prop="collectionAmount">
					</el-table-column>
					<el-table-column label="欠款金额" prop="owedAmount">
					</el-table-column>
					<el-table-column label="开票金额" prop="receiptAmount">
					</el-table-column>
					<el-table-column label="回款状态" prop="collectionState">
					</el-table-column>
					<el-table-column label="开票状态" prop="receiptState">
					</el-table-column>
					<el-table-column label="成交日期" prop="transactionDate" :formatter="dateFormat">
					</el-table-column>
				</el-table>

			</el-main>
			<el-footer>
				<div class="block" style="float: right;">
					<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
						:page-sizes="[10,20,40,80]" :page-size="pageParam.pageSize"
						layout="total, sizes, prev, pager, next, jumper" :total="tableTotal">
					</el-pagination>
				</div>
			</el-footer>
		</el-container>

	</div>

</template>

<script>
	import qs from 'qs'
	import moment from 'moment'

	export default {
		name: "SaleOrderList",
		data() {
			return {
				tableData: [],
				tableTotal: 0,
				multipleSelection: [],
				pageParam: {
					"pageNum": 1,
					"pageSize": 10
				},
				searchInput: '',
				screenCondition: {

				},
				screenDialogVisible: false,
				showDeleteButton: false,
				queryType: 'all'
			}
		},
		methods: {
			dateFormat(row, column) {
				var date = row[column.property];
				if (date == undefined) {
					return ''
				};
				return moment(date).format("YYYY-MM-DD")
			},
			loadData() {
				this.axios({
					url: "http://localhost:8089/saleOrder",
					method: 'get',
					params: this.pageParam
				}).then((response) => {
					console.log(response)
					this.tableData = response.data.record.list
					this.tableTotal = response.data.record.total
					
					this.tableData.forEach(t=>{
						t.owedAmount = t.saleOrderAmount - t.collectionAmount
						t.collectionState = t.saleOrderAmount == t.collectionAmount ? '全部回款':(t.collectionAmount>0? '部分回款':'未回款')
						t.receiptState = t.saleOrderAmount == t.receiptAmount ? '全部开票':(t.receiptAmount>0? '部分开票':'未开票')
					})
				}).catch((error) => {receiptAmount

				})
			},
			handleSelectionChange(val) {
				this.multipleSelection = val

				if (val.length > 0)
					this.showDeleteButton = true
				else
					this.showDeleteButton = false
			},
			handleSizeChange(val) {
				this.pageParam.pageSize = val

				if (this.queryType == 'all')
					this.loadData()
				else if (this.queryType == 'search')
					this.handleSearch()
				else if (this.queryType == 'screen')
					this.handleScreen()
			},
			handleCurrentChange(val) {
				this.pageParam.pageNum = val

				if (this.queryType == 'all')
					this.loadData()
				else if (this.queryType == 'search')
					this.handleSearch()
				else if (this.queryType == 'screen')
					this.handleScreen()
			},
			handleSearch() {

				this.queryType = 'search'

				this.axios({
					url: "http://localhost:8089/saleOrder/search",
					method: "get",
					params: {"saleOrderName":this.searchInput}
				}).then(response => {
					this.tableData = response.data.record.list
					this.tableTotal = response.data.record.total
				}).catch(error => {

				})
			},
			toDetail() {
				this.$router.push({
					name: 'SaleOrder'
				})
			}
		},
		created() {
			this.loadData()
		}
	}
</script>

<style>
	#SaleOrderList .el-table .cell .el-button {
		padding: 0px;
		min-height: 22px;
		height: 22px;
	}
</style>
