<template>
	<el-row style="margin-bottom: 20px;">
		<el-col :span="12">
			<div class="grid-content bg-purple">
				<el-input class="select-input" v-model="input" placeholder="请输入内容"></el-input>
				<el-button type="primary">搜索</el-button>
			</div>
		</el-col>
	</el-row>
	<el-tabs type="border-card">
		<el-tab-pane label="所有线索">
			<el-table :data="tableData" style="width: 100%">
				<el-table-column prop="clueName" label="线索名称" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueCompany" label="线索所属公司" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueContacts" label="线索联系人" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="cluePhone" label="线索联系人电话" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="activity.activityName" label="线索来源" align="center" min-width="90">
				</el-table-column>
				<el-table-column prop="employee.empName" label="线索跟进人" align="center" min-width="60">
				</el-table-column>
				<el-table-column align="center" label="操作" min-width="150">
					<template #default="operation">
						<el-button @click="TakeIt(operation.row)" type="text" v-if="operation.row.empId ===null "
							size="small">拿取</el-button>
						<el-button @click="Delete()" type="text" size="small">删除</el-button>
					</template>
				</el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="我负责的">
			<el-table :data="MytableData" style="width: 100%">
				<el-table-column prop="clueName" label="线索名称" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueCompany" label="线索所属公司" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueContacts" label="线索联系人" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="cluePhone" label="线索联系人电话" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="activity.activityName" label="线索来源" align="center" min-width="90">
				</el-table-column>
				<el-table-column prop="employee.empName" label="线索跟进人" align="center" min-width="60">
				</el-table-column>
				<el-table-column align="center" label="操作" min-width="150">
					<template #default="operation">
						<el-button @click="Release(operation.row)" type="text" size="small">释放</el-button>
					</template>
				</el-table-column>
			</el-table>
		</el-tab-pane>
	</el-tabs>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				MytableData: [],
				EmpData: [],
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
					empId: ''
				}
			}
		},
		methods: {
			TakeIt(row) {
				this.$confirm('是否确定要负责此线索？', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
					center: true
				}).then(() => {
					this.ClueFrom.clueId = row.clueId;
					this.ClueFrom.empId = 1;
					const _this = this
					this.axios.put("http://localhost:8089/TakeItByEmpName", this.ClueFrom)
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
			Release(row) {
				this.$confirm('是否确定要负责此线索？', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
					center: true
				}).then(() => {
					this.ClueFrom.clueId = row.clueId;
					this.ClueFrom.empId = null;
					const _this = this
					this.axios.put("http://localhost:8089/TakeItByEmpName", this.ClueFrom)
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
					}),
					this.axios.get("http://localhost:8089/selectByMyClues")
						.then(function(response) {
							_this.MytableData = response.data
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
				}),

				this.axios.get("http://localhost:8089/selectByMyClues")
				.then(function(response) {
					_this.MytableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				})
		}
	}
</script>

<style>
</style>
