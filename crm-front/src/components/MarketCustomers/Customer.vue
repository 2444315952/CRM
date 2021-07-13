<template>
	<el-row style="margin-bottom: 20px;">
		<el-col :span="12">
			<div class="grid-content bg-purple">
				<el-input class="select-input" v-model="input" placeholder="请输入内容"></el-input>
				<el-button type="primary">搜索</el-button>
			</div>
		</el-col>
		<el-col :span="12">
			<div class="grid-content bg-purple-light">
				<el-button type="primary" @click="addcustomer()" class="buttonOne">+新增客户</el-button>
			</div>
		</el-col>
	</el-row>
	<el-table :data="tableData" style="width: 100%">
		<el-table-column prop="clueName" label="客户名称" align="center" min-width="90">
		</el-table-column>
		<el-table-column prop="clueCompany" label="客户所属公司" align="center" min-width="70">
		</el-table-column>
		<el-table-column prop="clueContacts" label="客户联系人" align="center" min-width="50">
		</el-table-column>
		<el-table-column prop="cluePhone" label="客户联系人电话" align="center" min-width="70">
		</el-table-column>
		<el-table-column prop="activity.activityName" label="客户来源" align="center" min-width="90">
		</el-table-column>
		<el-table-column prop="employee.empName" label="客户跟进人" align="center" min-width="60">
		</el-table-column>
		<el-table-column align="center" label="操作" min-width="150">
			<template #default="operation">
				<el-button @click="Update(operation.row)" type="text" size="small">修改</el-button>
				<el-button @click="Delete(operation.row)" type="text" size="small">删除</el-button>
			</template>
		</el-table-column>
	</el-table>
	
	<el-dialog title="新增客户" v-model="addCustomer" width="30%" center>
		<el-form ref="ClueFrom" :model="ClueFrom" label-width="100px" size="mini">
			<el-form-item label="客户名称" prop="clueName">
				<el-input style="width: 200px;" v-model="ClueFrom.clueName" placeholder="请输入客户名称"></el-input>
			</el-form-item>
			<el-form-item label="客户所属公司" prop="clueCompany">
				<el-input style="width: 200px;" v-model="ClueFrom.clueCompany" placeholder="请输入客户公司名称"></el-input>
			</el-form-item>
			<el-form-item label="客户联系人" prop="clueContacts">
				<el-input style="width: 200px;" v-model="ClueFrom.clueContacts" placeholder="请输入客户联系人名称"></el-input>
			</el-form-item>
			<el-form-item label="客户电话" prop="cluePhone">
				<el-input style="width: 200px;" v-model="ClueFrom.cluePhone" placeholder="请输入客户电话"></el-input>
			</el-form-item>
			<el-form-item label="客户跟进人:" prop="Address">
				<el-select v-model="ClueFrom.empId" placeholder="请选择" style="width: 200px;">
					<el-option v-for="item in EmpData" :key="item.empId" :label="item.empName" :value="item.empId">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item size="large">
				<el-button type="primary" @click="AddCustomer('ClueFrom')">确 定</el-button>
				<el-button @click="addCustomer = false">取 消</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
	
	<el-dialog title="修改线索" v-model="updateCustomer" width="30%" center>
		<el-form ref="ClueFrom" :model="ClueFrom" label-width="100px" size="mini">
			<el-form-item label="客户名称" prop="clueName">
				<el-input style="width: 200px;" v-model="ClueFrom.clueName" placeholder="请输入客户名称"></el-input>
			</el-form-item>
			<el-form-item label="客户所属公司" prop="clueCompany">
				<el-input style="width: 200px;" v-model="ClueFrom.clueCompany" placeholder="请输入客户公司名称"></el-input>
			</el-form-item>
			<el-form-item label="客户联系人" prop="clueContacts">
				<el-input style="width: 200px;" v-model="ClueFrom.clueContacts" placeholder="请输入客户联系人名称"></el-input>
			</el-form-item>
			<el-form-item label="客户电话" prop="cluePhone">
				<el-input style="width: 200px;" v-model="ClueFrom.cluePhone" placeholder="请输入客户电话"></el-input>
			</el-form-item>
			<el-form-item label="客户跟进人:" prop="Address">
				<el-select v-model="ClueFrom.empId" placeholder="请选择" style="width: 200px;">
					<el-option v-for="item in EmpData" :key="item.empId" :label="item.empName" :value="item.empId">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item size="large">
				<el-button type="primary" @click="UpdateCustomer('ClueFrom')">确 定</el-button>
				<el-button @click="updateCustomer = false">取 消</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				addCustomer: false,
				updateCustomer:false,
				LoginName: "焦凡超",
				EmpData:[],
				ClueFrom: {
					clueId: '',
					clueName: '',
					clueCompany: '',
					clueContacts: '',
					cluePhone: '',
					clueType: '',
					conversionType: '',
					timeliness: '',
					activityId: '',
					publicpondId: '',
					empId: '',
					contactsId:''
				}
			}
		},
		methods: {
			addcustomer() {
				Object.keys(this.ClueFrom).forEach((key) => (this.ClueFrom[key] = ''))
				this.addCustomer = true;
				this.EmpName();
			},
			AddCustomer(ClueFrom) {
				this.$refs[ClueFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.ClueFrom.timeliness = 0;
						this.ClueFrom.publicpondId = 2;
						this.ClueFrom.conversionType = 1;
						this.ClueFrom.contactsId = 2;
						this.axios.post("http://localhost:8089/addClue", this.ClueFrom)
							.then(function(response) {
								_this.selectByCustomer();
								_this.addCustomer = false;
								_this.$message({
									type: 'success',
									message: '添加成功!'
								});
							}).catch(function(error) {
								console.log(error)
							})
					} else {
						ElMessage.warning({
							message: '有必填项未填写',
							type: 'warning'
						});
						return false;
					}
				});
			},
			Update(row) {
				this.ClueFrom.clueId = row.clueId;
				this.ClueFrom.clueName = row.clueName;
				this.ClueFrom.clueCompany = row.clueCompany;
				this.ClueFrom.clueContacts = row.clueContacts;
				this.ClueFrom.cluePhone = row.cluePhone;
				this.ClueFrom.conversionType = row.conversionType;
				this.ClueFrom.activityId = row.activityId;
				this.ClueFrom.publicpondId = row.publicpondId;
				this.EmpName();
				this.ClueFrom.empId = row.empId;
				this.updateCustomer = true;
			},
			UpdateCustomer(ClueFrom) {
				this.$refs[ClueFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.axios.put("http://localhost:8089/updateByClueKeySelective", this
								.ClueFrom)
							.then(function(response) {
								_this.selectByCustomer();
								_this.updateCustomer = false;
								_this.$message({
									type: 'success',
									message: '修改成功!'
								});
							}).catch(function(error) {
								console.log(error)
							})
					} else {
						ElMessage.warning({
							message: '有必填项未填写',
							type: 'warning'
						});
						return false;
					}
				});
			},
			
			Delete(row){
				this.$confirm('是否确定要删除此数据！！', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
					center: true
				}).then(() => {
					this.ClueFrom.clueId = row.clueId;
					this.ClueFrom.timeliness = 1;
					const _this = this
					this.axios.put("http://localhost:8089/deleteByClueKey", this.ClueFrom)
						.then(function(response) {
							_this.selectByCustomer();
							_this.$message({
								type: 'success',
								message: '操作成功!'
							});
						}).catch(function(error) {
							console.log(error)
						})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消操作'
					});
				});
			},
			
			
			selectByCustomer() {
				const _this = this
				this.axios.get("http://localhost:8089/selectByCustomer")
					.then(function(response) {
						_this.tableData = response.data
						console.log(response);
					}).catch(function(error) {
						console.log(error)
					})
			},
			EmpName() {
				const _this = this
				this.axios.get("http://localhost:8089/selectAllEmpName")
					.then(function(response) {
						console.log(response);
						_this.EmpData = response.data
						console.log(response);
					}).catch(function(error) {
						console.log(error)
					})
			}
		},
		created() {
			const _this = this
			this.axios.get("http://localhost:8089/selectByCustomer")
				.then(function(response) {
					_this.tableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				})
		}
	}
</script>

<style>
</style>
