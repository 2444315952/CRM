<template>
	<div id="SaleOrder">

		<el-form :inline="true" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
			class="demo-ruleForm">

			<el-row>
				<el-col :span="12">
					<el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 16px">
						<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
						<el-breadcrumb-item><a href="/SaleOrderList">销售订单列表</a></el-breadcrumb-item>
						<el-breadcrumb-item><a href="/">销售订单</a></el-breadcrumb-item>
					</el-breadcrumb>
				</el-col>

				<el-col :span="12">
					<el-button style="float: right;position: relative;bottom:8px;right: 3px;" size="medium"
						type="primary" @click="submitForm('ruleForm')">保存</el-button>
				</el-col>

			</el-row>

			<el-container style="background-color: white;padding-top: 15px;">

				<el-main style="background-color: white;">
					<el-row>
						<el-col :span="8">
							<el-form-item label="订单名称" style="float: left;" prop="saleOrderName">
								<el-input v-model="ruleForm.saleOrderName" size="medium"></el-input>
							</el-form-item>
							
							<el-form-item label="关联机会" style="float: left;" prop="leadName">
								<el-input v-model="ruleForm.leadName" size="medium" disabled>
									<template #append>
										<el-button icon="el-icon-plus" size="small"
											@click="supplier.dialogVisible = true;supplierLoadData()">
										</el-button>
									</template>
								</el-input>
							</el-form-item>
							
							<el-form-item label="订单金额" style="float: left;" prop="saleOrderAmount">
								<el-input v-model="ruleForm.saleOrderAmount" size="medium" :disabled="inputLeadAmount"></el-input>
							</el-form-item>
							
							<el-form-item label="联系人" style="float: left;" prop="customerContacts">
								<el-input v-model="ruleForm.customerContacts" size="medium"></el-input>
							</el-form-item>
							
						</el-col>

						<el-col :span="8">
							<el-form-item label="负责人" style="float: left;" prop="empName">
								<el-select @click="clickEmployeeSelect()" @change="changeEmployeeSelect"
									v-model="ruleForm.empName" style="width: 206px;" placeholder="请选择负责人">
									<el-option v-for="e in employeeSelectValue" :label="e.empName"
										:value="e.empName"></el-option>
								</el-select>
							</el-form-item>
							
							<el-form-item label="关联产品" style="float: left;" prop="leadProductString">
								<el-input v-model="ruleForm.leadProductString" size="medium" disabled>
									<template #append>
										<el-button icon="el-icon-plus" size="small"
											@click="product.dialogVisible = true;productLoadData()">
										</el-button>
									</template>
								</el-input>
							</el-form-item>
							
							<el-form-item label="付款方式" style="float: left;" prop="employeeId">
								<el-select v-model="ruleForm.leadType" style="width: 206px;" placeholder="请选择支付方式">
									<el-option label="现金" value="现金"></el-option>
									<el-option label="转账" value="转账"></el-option>
									<el-option label="网银" value="网银"></el-option>
									<el-option label="其他" value="其他"></el-option>
								</el-select>
							</el-form-item>
							
							<el-form-item label="联系电话" style="float: left;" prop="customerPhone">
								<el-input v-model="ruleForm.customerPhone" size="medium"></el-input>
							</el-form-item>
							
						</el-col>
						
						<el-col :span="8">
							<el-form-item label="所属客户" style="float: left;" prop="customerName">
								<el-select @click="clickCustomerSelect()" @change="changeCustomerSelect"
									v-model="ruleForm.customerName" style="width: 206px;" placeholder="请选择负责人">
									<el-option v-for="c in customerSelectValue" :label="c.clueName"
										:value="c.clueName"></el-option>
								</el-select>
							</el-form-item>
							
							<el-form-item label="关联合同" style="float: left;" prop="contractName">
								<el-input v-model="ruleForm.contractName" size="medium" disabled>
									<template #append>
										<el-button icon="el-icon-plus" size="small"
											@click="warehouse.dialogVisible = true;warehouseLoadData()">
										</el-button>
									</template>
								</el-input>
							</el-form-item>
							
							<el-form-item label="成交日期" style="float: left;" prop="transactionDate">
								<el-date-picker type="datetime" placeholder="选择日期" size="medium"
									v-model="ruleForm.transactionDate" style="width: 206px;"></el-date-picker>
							</el-form-item>
							
						</el-col>
						
						<el-dialog title="产品" v-model="product.dialogVisible">
							<el-row type="flex" justify="end" style="padding-bottom: 12px;">
								<el-col :span="7.5">
									<el-input v-model="product.searchInput" placeholder="请搜索产品名称" size="small">
										<template #append>
											<el-button @click="productLoadData" icon="el-icon-search" size="mini">
											</el-button>
										</template>
									</el-input>
								</el-col>
						
							</el-row>
						
							<el-table :data="product.tableData" max-height="286" style="height: 286px;"
								@selection-change="productSelectionChange">
								<el-table-column type="selection" width="25">
								</el-table-column>
								<el-table-column property="proName" label="产品名称"></el-table-column>
								<el-table-column property="proType" label="产品型号"></el-table-column>
								<el-table-column property="proUnit" label="单位"></el-table-column>
								<el-table-column property="proPrice" label="基准价"></el-table-column>
								<el-table-column property="proNum" label="库存数量"></el-table-column>
								<el-table-column label="单价" prop="unitPrice">
									<template #default="scope">
										<el-input v-model="product.tableData[scope.$index].unitPrice"
											@change="changePriceOrQuantity(scope.$index)" size="small">
										</el-input>
									</template>
								</el-table-column>
								<el-table-column label="数量" prop="quantity">
									<template #default="scope">
										<el-input v-model="product.tableData[scope.$index].quantity"
											@change="changePriceOrQuantity(scope.$index)" size="small">
										</el-input>
									</template>
								</el-table-column>
								<el-table-column label="小计" prop="subtotal">
								</el-table-column>
							</el-table>
							<el-row>
								<el-col :span="24">
									<el-pagination style="float: right;margin-top: 15px;" @size-change="productSizeChange"
										@current-change="productCurrentChange" :page-sizes="[10,20,40,80]"
										:page-size="product.pageParam.pageSize"
										layout="total, sizes, prev, pager, next, jumper" :total="product.tableTotal">
									</el-pagination>
								</el-col>
							</el-row>
						
							<template #footer>
								<span class="dialog-footer">
									<el-button @click="product.dialogVisible = false" size="medium">取 消</el-button>
									<el-button type="primary" @click="productConfirmButton" size="medium">确 定
									</el-button>
								</span>
							</template>
						</el-dialog>
						
						<el-dialog title="销售机会" v-model="supplier.dialogVisible">
							<el-row type="flex" justify="end" style="padding-bottom: 12px;">
								<el-col :span="7.5">
									<el-input v-model="supplier.searchInput" placeholder="请搜索销售机会名称" size="small">
										<template #append>
											<el-button @click="supplierLoadData()" icon="el-icon-search" size="mini">
											</el-button>
										</template>
									</el-input>
								</el-col>
						
							</el-row>
						
							<el-table :data="supplier.tableData" max-height="477" style="width: 100%;height:477px;"
								highlight-current-row @current-change="supplierSelectionChange">
								<el-table-column label="机会名称" prop="leadName">
								</el-table-column>
								<el-table-column label="负责人" prop="empName">
								</el-table-column>
								<el-table-column label="所属客户" prop="customerName">
								</el-table-column>
								<el-table-column label="机会金额" prop="leadAmount">
								</el-table-column>
								<el-table-column label="销售阶段" prop="leadStage">
								</el-table-column>
								<el-table-column label="机会类型" prop="leadType">
								</el-table-column>
								<el-table-column label="机会来源" prop="leadSource">
								</el-table-column>
							</el-table>
							<el-row>
								<el-col :span="24">
									<el-pagination style="float: right;margin-top: 15px;"
										@size-change="supplierSizeChange" @current-change="supplierCurrentChange"
										:page-sizes="[10,20,40,80]" :page-size="supplier.pageParam.pageSize"
										layout="total, sizes, prev, pager, next, jumper" :total="supplier.tableTotal">
									</el-pagination>
								</el-col>
							</el-row>
						
							<template #footer>
								<span class="dialog-footer">
									<el-button @click="supplier.dialogVisible = false" size="medium">取 消</el-button>
									<el-button type="primary" @click="supplierConfirmButton" size="medium">确 定
									</el-button>
								</span>
							</template>
						</el-dialog>
						
						<el-dialog title="销售合同" v-model="warehouse.dialogVisible">
							<el-row type="flex" justify="end" style="padding-bottom: 12px;">
								<el-col :span="7.5">
									<el-input v-model="warehouse.searchInput" placeholder="请搜索仓库名称" size="small">
										<template #append>
											<el-button icon="el-icon-search" @click="warehouseLoadData()" size="mini">
											</el-button>
										</template>
									</el-input>
								</el-col>
						
							</el-row>
						
							<el-table :data="warehouse.tableData" max-height="286" style="height: 286px;"
								highlight-current-row @current-change="warehouseSelectionChange">
								<el-table-column label="合同名称" prop="contractName">
								</el-table-column>
								<el-table-column label="负责人" prop="empName">
								</el-table-column>
								<el-table-column label="所属客户" prop="customerName" width="140">
								</el-table-column>
								<el-table-column label="合同金额" prop="contractAmount">
								</el-table-column>
								<el-table-column label="签订时间" prop="contractDate" :formatter="dateFormat">
								</el-table-column>
								<el-table-column label="合同状态" prop="contractSate">
								</el-table-column>
								<!-- <el-table-column label="开始时间" prop="startDate" :formatter="dateFormat">
								</el-table-column>
								<el-table-column label="结束时间" prop="endDate" :formatter="dateFormat">
								</el-table-column> -->
							</el-table>
							<el-row>
								<el-col :span="24">
									<el-pagination style="float: right;margin-top: 15px;"
										@size-change="warehouseSizeChange" @current-change="warehouseCurrentChange"
										:page-sizes="[10,20,40,80]" :page-size="warehouse.pageParam.pageSize"
										layout="total, sizes, prev, pager, next, jumper" :total="warehouse.tableTotal">
									</el-pagination>
								</el-col>
							</el-row>
						
							<template #footer>
								<span class="dialog-footer">
									<el-button @click="warehouse.dialogVisible = false" size="medium">取 消</el-button>
									<el-button type="primary" @click="warehouseConfirmButton" size="medium">确 定
									</el-button>
								</span>
							</template>
						</el-dialog>
						
					</el-row>
					

				</el-main>
				<el-footer style="height: 56;">
				</el-footer>

			</el-container>
		</el-form>

	</div>
</template>

<script>
	import moment from 'moment'
	
	export default {
		name: "SaleOrder",
		data() {
			return {
				isAdd: true,
				ruleForm: {
					saleProductList: [],
					leadProductString:''
				},
				inputLeadAmount:false,
				rules: {
					saleOrderName: [{
						required: true,
						message: '请输入订单名称',
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
					saleOrderAmount: [{
						required: true,
						message: '请输入订单金额',
						trigger: 'change'
					}]
				},

				employeeSelectValue: [],
				customerSelectValue: [],
				supplier: {
					dialogVisible: false,
					searchInput: '',
					tableData: [],
					tableTotal: '',
					singleSelection: {},
					pageParam: {
						"pageNum": 1,
						"pageSize": 10
					}
				},
				product: {
					dialogVisible: false,
					searchInput: '',
					tableData: [],
					tableTotal: '',
					multipleSelection: [],
					pageParam: {
						"pageNum": 1,
						"pageSize": 10
					},
					sourceRowIndex: 0
				},warehouse: {
					dialogVisible: false,
					searchInput: '',
					tableData: [],
					tableTotal: '',
					singleSelection: {},
					pageParam: {
						"pageNum": 1,
						"pageSize": 10
					}
				}
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
			loadData(){
				this.axios({
					url: "http://localhost:8089/eims/purchase/one",
					method: "get",
					params: {
						"id": this.ruleForm.purchId
					}
				}).then(response => {
					this.ruleForm = response.data
				}).catch(error => {
				
				})
			},
			clickEmployeeSelect() {
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
			supplierLoadData() {
				this.axios({
					url: 'http://localhost:8089/saleLead',
					method: 'get'
				}).then(response => {
					console.log(response)
					
					this.supplier.tableData = response.data.record.list
					this.supplier.tableTotal = response.data.record.total
				}).catch(error => {

				})
			},
			supplierSelectionChange(val) {
				this.supplier.singleSelection = val
			},
			supplierSizeChange(val) {
				this.supplier.pageParam.pageSize = val
				this.supplierLoadData()
			},
			supplierCurrentChange(val) {
				this.supplier.pageParam.pageNum = val
				this.supplierLoadData()
			},
			supplierConfirmButton() {
				this.supplier.dialogVisible = false
				this.ruleForm.leadId = this.supplier.singleSelection.leadId
				this.ruleForm.leadName = this.supplier.singleSelection.leadName
			},
			productOpenDialog(index) {
				this.product.sourceRowIndex = index
				this.product.dialogVisible = true
				this.productLoadData()
			},
			productLoadData() {
				this.axios({
					url: 'http://localhost:8089/common/product',
					method: 'get',
					params: this.product.pageParam
				}).then(response => {
					this.product.tableData = response.data.record.list
					this.product.tableTotal = response.data.record.total
					
					this.product.tableData.forEach(t=>{
						t.unitPrice = t.proPrice
						t.quantity = 1
						t.subtotal = t.proPrice
					})
				}).catch(error => {

				})
			},
			productSelectionChange(val) {
				this.product.multipleSelection = val
			},
			productSizeChange(val) {
				this.product.pageParam.pageSize = val
				this.productLoadData()
			},
			productCurrentChange(val) {
				this.product.pageParam.pageNum = val
				this.productLoadData()
			},
			productConfirmButton() {
				this.product.dialogVisible = false
				
				var str = "";
				this.product.multipleSelection.forEach(m=>{
					this.ruleForm.saleProductList.push(m)
					str += (m.proName+",")
				})
				
				if(this.product.multipleSelection.length>0){
					str = str.substring(0,str.length-1)
					this.ruleForm.leadProductString = str
					this.inputLeadAmount = true
				}else{
					this.inputLeadAmount = false
				}
				
				var saleOrderAmount = 0
				this.product.multipleSelection.forEach(m => {
					saleOrderAmount += m.subtotal
				})
				this.ruleForm.saleOrderAmount = saleOrderAmount

			},
			warehouseLoadData() {
				this.axios({
					url: 'http://localhost:8089/saleContract',
					method: 'get',
					params: this.warehouse.pageParam
				}).then(response => {
					this.warehouse.tableData = response.data.record.list
					this.warehouse.tableTotal = response.data.record.total
				}).catch(error => {

				})
			},
			warehouseSelectionChange(val) {
				this.warehouse.singleSelection = val
			},
			warehouseSizeChange(val) {
				this.warehouse.pageParam.pageSize = val
				this.warehouseLoadData()
			},
			warehouseCurrentChange(val) {
				this.warehouse.pageParam.pageNum = val
				this.warehouseLoadData()
			},
			warehouseConfirmButton() {
				this.warehouse.dialogVisible = false
				this.ruleForm.saleContractId = this.warehouse.singleSelection.saleContractId
				this.ruleForm.contractName = this.warehouse.singleSelection.contractName
			},
			addRow() {
				this.ruleForm.purchaseDetailList.push({});
			},
			removeRow(index) {
				if (this.ruleForm.purchaseDetailList.length > 1)
					this.ruleForm.purchaseDetailList.splice(index, 1);
			},
			changePriceOrQuantity(index) {
				const detail = this.product.tableData[index]
				const subtotal = detail.unitPrice * detail.quantity
				this.product.tableData[index].subtotal = subtotal
			},
			submitForm(formName) {

				this.$refs[formName].validate((valid) => {
					if (valid) {

						if (this.isAdd) {
							console.log(this.ruleForm)
							
							this.axios({
								url: 'http://localhost:8089/saleOrder',
								method: 'post',
								data: this.ruleForm
							}).then(response => {
								this.$message({
									type: 'success',
									message: '销售订单数据新增成功！'
								})

								this.$router.push({
									name: 'SaleOrderList'
								})
							}).catch(error => {

							})
						} else {
						
							if(this.ruleForm.audited == 1){
								this.$message({
									type:'info',
									message:'已审核的数据无法更改'
								})
								this.loadData()
								return false
							}else if(this.ruleForm.inStorage == 1){
								this.$message({
									type:'info',
									message:'已入库的数据无法更改'
								})
								this.loadData()
								return false
							}else if(this.ruleForm.paymentStatus == 1 || this.ruleForm.paymentStatus == 2){
								this.$message({
									type:'info',
									message:'已付款的数据无法更改'
								})
								this.loadData()
								return false
							}else if(this.ruleForm.returnState == 1 || this.ruleForm.returnState == 2){
								this.$message({
									type:'info',
									message:'已退货的数据无法更改'
								})
								this.loadData()
								return false
							}
						
							this.axios({
								url:'http://localhost:8089/eims/purchase/detail',
								method:'put',
								data:this.ruleForm
							}).then(response=>{
								this.$message({
									type:'success',
									message:'采购单信息更改成功！'
								})
								
								this.$router.push({
									name:'PurchaseList'
								})
							}).catch(error=>{
								
							})

						}

					} else {
						return false;
					}
				});
			}
		},
		created() {
			this.ruleForm.purchId = this.$route.params.purchId
			this.isAdd = typeof(this.ruleForm.purchId) == "undefined" || this.ruleForm.purchId == ""

			if (this.isAdd){
				
			}else{
				this.loadData()
			}
		}
	}
</script>

<style>
	/* 表头与表行对齐 */
	#SaleLead .cell {
		padding-left: 0px;
	}

	/* 加号按钮 */
	#SaleLead .el-input-group__append,
	.el-input-group__prepend {
		padding: 0px 18px;
	}

	#SaleLead .el-table .el-input-group__append,
	.el-input-group__prepend {
		padding: 0px 15px;
	}

	#SaleLead .el-table {
		padding: 0px 10px;
	}

	#SaleLead .el-table td,
	#SaleLead .el-table th {
		padding: 6px 0px;
	}

	#SaleLead .el-dialog .el-table td,
	#SaleLead .el-dialog .el-table th {
		padding: 9px 0px;
	}

	#SaleLead .el-footer {
		padding-bottom: 20px;
	}

	#SaleLead .el-main {
		padding: 15px;
	}

	.underline-input {
		border: 0px;
		outline: none;
		width: 105px;
		padding: 1px 0px;
		border-bottom: 1px solid rgb(204, 204, 204);
	}

	.underline-input:hover {
		border-bottom: 1px solid rgb(35, 134, 238);
	}

	#SaleLead .el-dialog .el-dialog__body {
		padding: 20px;
	}
	
	#SaleLead .el-form-item{
		width: 100%;
	}
	
	#SaleLead .el-form-item .el-input{
		width: 245px;;
	}
</style>
