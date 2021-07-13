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
				<el-button type="primary" @click="addclue()" class="buttonOne">+新增线索</el-button>
			</div>
		</el-col>
	</el-row>
	<el-table :data="tableData" style="width: 100%">
		<el-table-column prop="clueName" label="线索名称" align="center" min-width="90">
		</el-table-column>
		<el-table-column prop="clueCompany" label="线索所属公司" align="center" min-width="50">
		</el-table-column>
		<el-table-column prop="clueContacts" label="线索联系人" align="center" min-width="50">
		</el-table-column>
		<el-table-column prop="cluePhone" label="线索联系人电话" align="center" min-width="70">
		</el-table-column>
		<el-table-column prop="activity.activityName" label="线索来源" align="center" min-width="90">
		</el-table-column>
		<el-table-column prop="employee.empName" label="线索跟进人" align="center" min-width="60">
		</el-table-column>
		<el-table-column prop="conversionType" label="转化状态" align="center" min-width="50">
			<template #default="ConversionType">
				<span v-if="ConversionType.row.conversionType== 0 ">未转化</span>
				<span v-if="ConversionType.row.conversionType== 1 ">已转化</span>
			</template>
		</el-table-column>
		<el-table-column align="center" label="操作" min-width="150">
			<template #default="operation">
				<el-button @click="conversion(operation.row)" type="text" size="small"
					v-if="operation.row.conversionType== 0 ">转化</el-button>
				<el-button @click="Update(operation.row)" type="text" size="small">修改</el-button>
				<el-button @click="Delete(operation.row)" type="text" size="small">删除</el-button>
			</template>
		</el-table-column>
	</el-table>
	<el-dialog title="新增线索" v-model="addClue" width="30%" center>
		<el-form ref="ClueFrom" :model="ClueFrom" label-width="100px" size="mini">
			<el-form-item label="线索名称" prop="clueName">
				<el-input style="width: 200px;" v-model="ClueFrom.clueName" placeholder="请输入线索名称"></el-input>
			</el-form-item>
			<el-form-item label="线索所属公司" prop="clueCompany">
				<el-input style="width: 200px;" v-model="ClueFrom.clueCompany" placeholder="请输入线索公司名称"></el-input>
			</el-form-item>
			<el-form-item label="线索联系人" prop="clueContacts">
				<el-input style="width: 200px;" v-model="ClueFrom.clueContacts" placeholder="请输入线索联系人名称"></el-input>
			</el-form-item>
			<el-form-item label="联系人电话" prop="cluePhone">
				<el-input style="width: 200px;" v-model="ClueFrom.cluePhone" placeholder="请输入联系人电话"></el-input>
			</el-form-item>
			<el-form-item label="线索跟进人:" prop="Address">
				<el-select v-model="ClueFrom.empId" placeholder="请选择" style="width: 200px;">
					<el-option v-for="item in EmpData" :key="item.empId" :label="item.empName" :value="item.empId">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item size="large">
				<el-button type="primary" @click="AddClue('ClueFrom')">确 定</el-button>
				<el-button @click="addClue = false">取 消</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
	<el-dialog title="修改线索" v-model="updateClue" width="30%" center>
		<el-form ref="ClueFrom" :model="ClueFrom" label-width="100px" size="mini">
			<el-form-item label="线索名称" prop="clueName">
				<el-input style="width: 200px;" v-model="ClueFrom.clueName" placeholder="请输入线索名称"></el-input>
			</el-form-item>
			<el-form-item label="线索所属公司" prop="clueCompany">
				<el-input style="width: 200px;" v-model="ClueFrom.clueCompany" placeholder="请输入线索公司名称"></el-input>
			</el-form-item>
			<el-form-item label="线索联系人" prop="clueContacts">
				<el-input style="width: 200px;" v-model="ClueFrom.clueContacts" placeholder="请输入线索联系人名称"></el-input>
			</el-form-item>
			<el-form-item label="联系人电话" prop="cluePhone">
				<el-input style="width: 200px;" v-model="ClueFrom.cluePhone" placeholder="请输入联系人电话"></el-input>
			</el-form-item>
			<el-form-item label="线索跟进人:" prop="Address">
				<el-select v-model="ClueFrom.empId" placeholder="请选择" style="width: 200px;">
					<el-option v-for="item in EmpData" :key="item.empId" :label="item.empName" :value="item.empId">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item size="large">
				<el-button type="primary" @click="UpdateClue('ClueFrom')">确 定</el-button>
				<el-button @click="updateClue = false">取 消</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				addClue: false,
				updateClue: false,
				LoginName: "焦凡超",
				EmpData: [],
				ClueFrom: {
					clueId: '',
					clueName: '',
					clueCompany: '',
					clueContacts: '',
					cluePhone: '',
					conversionType: '',
					timeliness: '',
					activityId: '',
					publicpondId: '',
					empId: ''
				}
			}
		},
		methods: {
			addclue() {
				Object.keys(this.ClueFrom).forEach((key) => (this.ClueFrom[key] = ''))
				this.addClue = true;
				this.EmpName();
			},
			AddClue(ClueFrom) {
				this.$refs[ClueFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.ClueFrom.conversionType = 0;
						this.ClueFrom.publicpondId = 1;
						this.ClueFrom.timeliness = 0;
						this.axios.post("http://localhost:8089/addClue", this.ClueFrom)
							.then(function(response) {
								_this.selectByClues();
								_this.addClue = false;
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
				this.updateClue = true;
			},
			UpdateClue(ClueFrom) {
				this.$refs[ClueFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.axios.put("http://localhost:8089/updateByClueKeySelective", this
								.ClueFrom)
							.then(function(response) {
								_this.selectByClues();
								_this.updateClue = false;
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
							_this.selectByClues();
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

			conversion(row) {
				this.$confirm('是否确定要将此线索转化？', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
					center: true
				}).then(() => {
					this.ClueFrom.clueId = row.clueId;
					this.ClueFrom.conversionType = 1;
					this.ClueFrom.publicpondId = 2;
					const _this = this
					this.axios.put("http://localhost:8089/updateByConversion", this.ClueFrom)
						.then(function(response) {
							_this.selectByClues();
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
			selectByClues() {
				const _this = this
				this.axios.get("http://localhost:8089/selectByClues")
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
			this.axios.get("http://localhost:8089/selectByClues")
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
