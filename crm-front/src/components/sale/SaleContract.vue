<template>

	<div id="SaleContract">

		<el-row>
			<el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 16px">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item><a href="/PurchaseList">销售合同列表</a></el-breadcrumb-item>
			</el-breadcrumb>
		</el-row>

		<el-container style="background-color: white;padding-top: 15px;">

			<el-header style="height: 30px;">
				<el-row>

					<el-col :span="21">
						<el-input style="width: 290px;float: left;" placeholder="请输入销售合同名称"
							v-model="searchInput">
							<template #append>
								<el-button icon="el-icon-search" size="small" @click="handleSearch"></el-button>
							</template>
						</el-input>

					</el-col>

					<el-col :span="3">

						<el-button style="float: right;" icon="el-icon-plus" size="medium" type="primary"
							@click="dialogFormVisible = true">新增销售合同</el-button>

					</el-col>
				</el-row>
			</el-header>

			<el-main style="background-color: white;">
				<el-table :data="tableData" max-height="477" style="width: 100%;height:477px;"
					highlight-current-row @current-change="handleCurrentChange">
					<el-table-column label="合同名称" prop="contractName">
					</el-table-column>
					<el-table-column label="负责人" prop="empName">
					</el-table-column>
					<el-table-column label="所属客户" prop="customerName">
					</el-table-column>
					<el-table-column label="合同金额" prop="contractAmount">
					</el-table-column>
					<el-table-column label="签订时间" prop="contractDate" :formatter="dateFormat">
					</el-table-column>
					<el-table-column label="合同状态" prop="contractSate">
					</el-table-column>
					<el-table-column label="开始时间" prop="startDate" :formatter="dateFormat">
					</el-table-column>
					<el-table-column label="结束时间" prop="endDate" :formatter="dateFormat">
					</el-table-column>
				</el-table>

				<el-dialog title="新增销售合同" v-model="dialogFormVisible" >
				  <el-form :model="ruleForm" :rules="rules" ref="ruleForm">
				    <el-row>
				    	<el-col :span="12">
				    		<el-form-item label="合同名称" style="float: left;" prop="contractName">
				    			<el-input v-model="ruleForm.contractName" size="medium"></el-input>
				    		</el-form-item>
				    		
							<el-form-item label="负责人" style="float: left;" prop="empName">
								<el-select @click="clickEmployeeSelect()" @change="changeEmployeeSelect"
									v-model="ruleForm.empName" style="width: 206px;" placeholder="请选择负责人">
									<el-option v-for="e in employeeSelectValue" :label="e.empName"
										:value="e.empName"></el-option>
								</el-select>
							</el-form-item>
							
				    		<el-form-item label="开始时间" style="float: left;" prop="startDate">
				    			<el-date-picker type="datetime" placeholder="选择日期" size="medium"
				    				v-model="ruleForm.startDate" style="width: 206px;"></el-date-picker>
				    		</el-form-item>
				    		
				    		<el-form-item label="合同状态" style="float: left;" prop="employeeId">
				    			<el-select v-model="ruleForm.contractSate" style="width: 206px;" placeholder="请选择支付方式">
				    				<el-option label="未开始" value="未开始"></el-option>
				    				<el-option label="执行中" value="执行中"></el-option>
				    				<el-option label="意外终止" value="意外终止"></el-option>
				    				<el-option label="已完成" value="已完成"></el-option>
				    			</el-select>
				    		</el-form-item>
				    		
				    	</el-col>
				    	
				    	<el-col :span="12">
							<el-form-item label="签订时间" style="float: left;" prop="contractDate">
								<el-date-picker type="datetime" placeholder="选择日期" size="medium"
									v-model="ruleForm.contractDate" style="width: 206px;"></el-date-picker>
							</el-form-item>
							
				    		<el-form-item label="所属客户" style="float: left;" prop="customerName">
				    			<el-select @click="clickCustomerSelect()" @change="changeCustomerSelect"
				    				v-model="ruleForm.customerName" style="width: 206px;" placeholder="请选择负责人">
				    				<el-option v-for="c in customerSelectValue" :label="c.clueName"
				    					:value="c.clueName"></el-option>
				    			</el-select>
				    		</el-form-item>
				    		
				    		<el-form-item label="结束时间" style="float: left;" prop="endDate">
				    			<el-date-picker type="datetime" placeholder="选择日期" size="medium"
				    				v-model="ruleForm.endDate" style="width: 206px;"></el-date-picker>
				    		</el-form-item>
							
				    	</el-col>
						
				    </el-row>
				  </el-form>
				  <template #footer>
				    <span class="dialog-footer">
				      <el-button @click="dialogFormVisible = false">取 消</el-button>
				      <el-button type="primary" @click="submitForm('ruleForm')">确 定</el-button>
				    </span>
				  </template>
				</el-dialog>
				
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
		name: "SaleContract",
		data() {
			return {
				ruleForm: {
					saleProductList: [],
					leadProductString:''
				},
				rules: {
					contractName: [{
						required: true,
						message: '请输入合同名称',
						trigger: 'blur'
					}],
					empName: [{
						required: true,
						message: '请选择负责人',
						trigger: 'blur'
					}],
					customerName: [{
						required: true,
						message: '请选择所属客户',
						trigger: 'blur'
					}],
					contractDate: [{
						required: true,
						message: '请输入签订时间',
						trigger: 'change'
					}]
				},
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
				queryType: 'all',
				dialogFormVisible:false,
				employeeSelectValue: [],
				customerSelectValue: []
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
					url: "http://localhost:8089/saleContract",
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
					url: "http://localhost:8089/saleContract/search",
					method: "get",
					params: {"contractName":this.searchInput}
				}).then(response => {
					this.tableData = response.data.record.list
					this.tableTotal = response.data.record.total
				}).catch(error => {

				})
			},clickEmployeeSelect() {
				if (this.employeeSelectValue.length > 0)
					return false

				this.axios({
					url: 'http://localhost:8089/employee',
					method: 'get'
				}).then(response => {
					console.log(response)
					this.employeeSelectValue = response.data.record.list
				}).catch(error => {

				})
			},
			changeEmployeeSelect() {
				this.employeeSelectValue.forEach(e => {
					if (e.empName == this.ruleForm.empName)
						this.ruleForm.empId = e.empId
				})
			},
			clickCustomerSelect() {
				if (this.customerSelectValue.length > 0)
					return false
			
				this.axios({
					url: 'http://localhost:8089/common/customer',
					method: 'get'
				}).then(response => {
					console.log(response)
					this.customerSelectValue = response.data.record.list
				}).catch(error => {
			
				})
			},
			changeCustomerSelect() {
				this.customerSelectValue.forEach(e => {
					if (e.customerName == this.ruleForm.clueName){
						this.ruleForm.customerId = e.clueId
						this.ruleForm.customerContacts = e.clueContacts
						this.ruleForm.customerPhone = e.cluePhone
					}
				})
			},
			submitForm(formName) {

				this.$refs[formName].validate((valid) => {
					if (valid) {

						this.axios({
							url: 'http://localhost:8089/saleContract',
							method: 'post',
							data: this.ruleForm
						}).then(response => {
							this.$message({
								type: 'success',
								message: '销售合同数据新增成功！'
							})
							
							this.dialogFormVisible = false
							this.loadData()
						
						}).catch(error => {
						
						})
						
					} else {
						return false;
					}
				});
			}
		},
		created() {
			this.loadData()
		}
	}
</script>

<style>
	#SaleContract .el-table .cell .el-button {
		padding: 0px;
		min-height: 22px;
		height: 22px;
	}
</style>
