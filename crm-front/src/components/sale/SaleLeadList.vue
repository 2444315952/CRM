<template>

	<div id="SaleLeadList">

		<el-row>
			<el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 16px">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item><a href="/PurchaseList">销售机会列表</a></el-breadcrumb-item>
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
							@click="toDetail()">新增销售机会</el-button>

					</el-col>
				</el-row>
			</el-header>

			<el-main style="background-color: white;">
				<el-table :data="tableData" max-height="477" style="width: 100%;height:477px;"
					highlight-current-row @current-change="handleCurrentChange">
					<el-table-column label="机会名称" prop="leadName">
					</el-table-column>
					<el-table-column label="负责人" prop="empName">
					</el-table-column>
					<el-table-column label="所属客户" prop="customerName">
					</el-table-column>
					<el-table-column label="机会金额" prop="leadAmount">
					</el-table-column>
					<el-table-column label="预计成交日" prop="transactionDate" :formatter="dateFormat">
					</el-table-column>
					<el-table-column label="销售阶段" prop="leadStage">
					</el-table-column>
					<el-table-column label="机会类型" prop="leadType">
					</el-table-column>
					<el-table-column label="机会来源" prop="leadSource">
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
		name: "SaleLeadList",
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
				return moment(date).format("YYYY-MM-DD HH:mm")
			},
			loadData() {
				this.axios({
					url: "http://localhost:8089/saleLead",
					method: 'get',
					params: this.pageParam
				}).then((response) => {
					console.log(response)
					this.tableData = response.data.record.list
					this.tableTotal = response.data.record.total
				}).catch((error) => {

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
					url: "http://localhost:8089/saleLead/search",
					method: "get",
					params: {"leadName":this.searchInput}
				}).then(response => {
					this.tableData = response.data.record.list
					this.tableTotal = response.data.record.total
				}).catch(error => {

				})
			},
			toDetail() {
				this.$router.push({
					name: 'SaleLead'
				})
			}
		},
		created() {
			this.loadData()
		}
	}
</script>

<style>
	#SaleLeadList .el-table .cell .el-button {
		padding: 0px;
		min-height: 22px;
		height: 22px;
	}
</style>
