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
				<el-button type="primary" @click="AddActivity()" class="buttonOne">+新增活动</el-button>
			</div>
		</el-col>
	</el-row>
	<el-tabs v-model="activeName" type="card">
		<el-tab-pane label="所有活动" name="first">
			<el-table :data="tableData" style="width: 100%">
				<el-table-column prop="activityName" label="活动名称" width="180" align="center" min-width="80">
				</el-table-column>
				<el-table-column prop="activityState" label="活动状态" align="center" min-width="40">
					<template #default="ActivityState">
						<span v-if="ActivityState.row.activityState== 0 ">待进行</span>
						<span v-if="ActivityState.row.activityState== 1 ">进行中</span>
						<span v-if="ActivityState.row.activityState== 2 ">已完成</span>
					</template>
				</el-table-column>
				<el-table-column prop="planincome" label="活动成本" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="actualincome" label="活动收入" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="profitloss" label="活动盈亏" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="employee.empName" label="活动负责人" align="center" min-width="60">
				</el-table-column>
				<el-table-column label="操作" align="center" min-width="100">
					<template #default="scope">
						<el-button @click="start(scope.row)" v-if="scope.row.activityState === 0" type="text" size="small">开始活动</el-button>
						<el-button @click="end(scope.row)" v-if="scope.row.activityState === 1" type="text" size="small">结束活动</el-button>
						<el-button @click="Delete(scope.row)" type="text" v-if="scope.row.activityState === 0" size="small">删除</el-button>
						<el-button @click="Update(scope.row)" v-if="scope.row.activityState === 0" type="text" size="small">修改</el-button>
						<el-button type="text" size="small" @click="addclue(scope.row)"  v-if="scope.row.activityState != 0">+活动线索</el-button>
						<el-button type="text" size="small" @click="addcustomer(scope.row)"  v-if="scope.row.activityState != 0">+活动客户</el-button>
					</template>
				</el-table-column>
				<el-table-column type="expand" lable="详细" :show-overflow-tooltip="true">
					<template #default="props">
						<el-form label-position="left" inline class="demo-table-expand">
							<div style="width: 100%; display: inline-block;">
								<el-form-item label="开始时间:" style="width: 100%;color: #aaaa7f;">
									<span>{{ props.row.addTime }}</span>
								</el-form-item>
								<el-form-item label="结束时间:" style="width: 400px;color: #aaaa7f;">
									<span>{{ props.row.endTime }}</span>
								</el-form-item>
								<el-form-item label="活动地址:" style="width: 400px;color: #aaaa7f;">
									<span>{{ props.row.address }}</span>
								</el-form-item>
								<el-form-item label="活动计划:" style="width: 400px;color: #aaaa7f;">
									<span>{{ props.row.activityPlan }}</span>
								</el-form-item>
							</div>
						</el-form>
					</template>
				</el-table-column>
			</el-table>
		</el-tab-pane>
		<el-dialog title="新建活动计划" v-model="addDialog" width="30%" center>
			<el-form ref="ActFrom" :model="ActFrom" label-width="100px" size="mini">
				<el-form-item label="活动名称" prop="ActivityName">
					<el-input style="width: 200px;" v-model="ActFrom.activityName" placeholder="请输入活动名称"></el-input>
				</el-form-item>
				<el-form-item label="活动地址:" prop="Address">
					<el-input style="width: 200px;" v-model="ActFrom.address"></el-input>
				</el-form-item>
				<el-form-item label="活动成本:" prop="Address">
					<el-input style="width: 200px;" v-model="ActFrom.planincome"></el-input>
				</el-form-item>
				<el-form-item label="活动负责人:" prop="Address">
					<el-select v-model="ActFrom.empId" placeholder="请选择" style="width: 200px;">
						<el-option v-for="item in EmpData" :key="item.empId" :label="item.empName" :value="item.empId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="活动计划:" prop="ActivityPlan">
					<el-input type="textarea" placeholder="请输入内容" v-model="ActFrom.activityPlan" :rows="2"
						maxlength="300" show-word-limit>
					</el-input>
				</el-form-item>
				<el-form-item size="large">
					<el-button type="primary" @click="AddDialog('ActFrom')">确 定</el-button>
					<el-button @click="addDialog = false">取 消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
		
		<el-dialog title="修改活动计划" v-model="updateDialog" width="30%" center>
			<el-form ref="ActFrom" :model="ActFrom" label-width="100px" size="mini">
				<el-form-item label="活动名称" prop="ActivityName">
					<el-input style="width: 200px;" v-model="ActFrom.activityName" placeholder="请输入活动名称"></el-input>
				</el-form-item>
				<el-form-item label="活动地址:" prop="Address">
					<el-input style="width: 200px;" v-model="ActFrom.address"></el-input>
				</el-form-item>
				<el-form-item label="活动成本:" prop="Address">
					<el-input style="width: 200px;" v-model="ActFrom.planincome"></el-input>
				</el-form-item>
				<el-form-item label="活动负责人:" prop="Address">
					<el-select v-model="ActFrom.empId" placeholder="请选择" style="width: 200px;">
						<el-option v-for="item in EmpData" :key="item.empId" :label="item.empName" :value="item.empId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="活动计划:" prop="ActivityPlan">
					<el-input type="textarea" placeholder="请输入内容" v-model="ActFrom.activityPlan" :rows="2"
						maxlength="300" show-word-limit>
					</el-input>
				</el-form-item>
				<el-form-item size="large">
					<el-button type="primary" @click="UpdateDialog('ActFrom')">确 定</el-button>
					<el-button @click="updateDialog = false">取 消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
		

		<el-dialog title="本次活动收入金额" v-model="endDialog" width="30%" center>
			<el-form ref="ActFrom" :model="ActFrom" label-width="100px" size="mini">
				<el-form-item label="活动收入:" prop="ActualIncome">
					<el-input style="width: 200px;" v-model="ActFrom.actualincome"></el-input>
				</el-form-item>
				<el-form-item size="large">
					<el-button type="primary" @click="EndDialog('ActFrom')">确 定</el-button>
					<el-button @click="endDialog = false">取 消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>

		<el-dialog title="活动线索" v-model="addClue" width="30%" center>
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
				<el-form-item size="large">
					<el-button type="primary" @click="AddClue('ClueFrom')">确 定</el-button>
					<el-button @click="addClue = false">取 消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>

		<el-dialog title="活动客户" v-model="addCustomer" width="30%" center>
			<el-form ref="ClueFrom" :model="ClueFrom" label-width="100px" size="mini">
				<el-form-item label="客户名称" prop="customerName">
					<el-input style="width: 200px;" v-model="ClueFrom.clueName" placeholder="请输入客户名称">
					</el-input>
				</el-form-item>
				<el-form-item label="客户所属公司" prop="customerCompany">
					<el-input style="width: 200px;" v-model="ClueFrom.clueCompany" placeholder="请输入客户公司名称">
					</el-input>
				</el-form-item>
				<el-form-item label="客户联系人" prop="customerContacts">
					<el-input style="width: 200px;" v-model="ClueFrom.clueContacts" placeholder="请输入客户联系人名称">
					</el-input>
				</el-form-item>
				<el-form-item label="客户电话" prop="customerPhone">
					<el-input style="width: 200px;" v-model="ClueFrom.cluePhone" placeholder="请输入客户电话">
					</el-input>
				</el-form-item>
				<el-form-item size="large">
					<el-button type="primary" @click="AddCustomer('ClueFrom')">确 定</el-button>
					<el-button @click="addCustomer = false">取 消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>

		<el-tab-pane label="我负责的" name="second">
			<el-table :data="MytableData" style="width: 100%">
				<el-table-column prop="activityName" label="活动名称" width="180" align="center" min-width="80">
				</el-table-column>
				<el-table-column prop="activityState" label="活动状态" align="center" min-width="40">
					<template #default="ActivityState">
						<span v-if="ActivityState.row.activityState== 0 ">待进行</span>
						<span v-if="ActivityState.row.activityState== 1 ">进行中</span>
						<span v-if="ActivityState.row.activityState== 2 ">已完成</span>
					</template>
				</el-table-column>
				<el-table-column prop="planincome" label="活动成本" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="actualincome" label="活动收入" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="profitloss" label="活动盈亏" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="employee.empName" label="活动负责人" align="center" min-width="60">
				</el-table-column>
				<el-table-column label="操作" align="center" min-width="100">
					<template #default="scope">
						<el-button @click="start(scope.row)" v-if="scope.row.activityState === 0" type="text" size="small">开始活动</el-button>
						<el-button @click="end(scope.row)" v-if="scope.row.activityState === 1" type="text" size="small">结束活动</el-button>
						<el-button @click="Delete(scope.row)" type="text" v-if="scope.row.activityState === 0" size="small">删除</el-button>
						<el-button @click="Update(scope.row)" v-if="scope.row.activityState === 0" type="text" size="small">修改</el-button>
						<el-button type="text" size="small" @click="addclue(scope.row)"  v-if="scope.row.activityState != 0">+活动线索</el-button>
						<el-button type="text" size="small" @click="addcustomer(scope.row)"  v-if="scope.row.activityState != 0">+活动客户</el-button>
					</template>
				</el-table-column>
				<el-table-column type="expand" lable="详细" :show-overflow-tooltip="true">
					<template #default="props">
						<el-form label-position="left" inline class="demo-table-expand">
							<div style="width: 100%; display: inline-block;">
								<el-form-item label="开始时间:" style="width: 100%;color: #aaaa7f;">
									<span>{{ props.row.addTime }}</span>
								</el-form-item>
								<el-form-item label="结束时间:" style="width: 400px;color: #aaaa7f;">
									<span>{{ props.row.endTime }}</span>
								</el-form-item>
								<el-form-item label="活动地址:" style="width: 400px;color: #aaaa7f;">
									<span>{{ props.row.address }}</span>
								</el-form-item>
								<el-form-item label="活动计划:" style="width: 400px;color: #aaaa7f;">
									<span>{{ props.row.activityPlan }}</span>
								</el-form-item>
								<el-form-item size="large">
									<el-button type="primary" @click="addcustomer()" class="buttonOne">+活动客户</el-button>
									<el-button type="primary" @click="addclue()" class="buttonOne">+活动线索</el-button>
								</el-form-item>
							</div>
						</el-form>
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
				activeName: 'first',
				input: '',
				addDialog: false,
				updateDialog:false,
				addClue: false,
				addCustomer: false,
				endDialog: false,
				LoginName: "焦凡超", //默认测试姓名数据
				tableData: [],
				MytableData: [],
				ClueData: [],
				EmpData: [],
				ActivityData: [],
				ActFrom: {
					activityId: '',
					activityName: '',
					addTime: '',
					endTime: '',
					address: '',
					activityState: '',
					planincome: '',
					actualincome: '',
					profitloss: '',
					activityPlan: '',
					timeliness: '',
					empId: ''
				},
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
			};
		},
		methods: {
			AddActivity() {
				Object.keys(this.ActFrom).forEach((key) => (this.ActFrom[key] = ''))
				this.addDialog = true;
				this.EmpName();
			},
			AddDialog(ActFrom) {
				this.$refs[ActFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.ActFrom.activityState = 0;
						this.ActFrom.timeliness = 0;
						this.axios.post("http://localhost:8089/addActivity", this.ActFrom)
							.then(function(response) {
								_this.selectByActivitys();
								_this.addDialog = false;
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
			Update(row){
				this.ActFrom.activityId = row.activityId;
				this.ActFrom.activityName = row.activityName;
				this.ActFrom.address = row.address;
				this.ActFrom.planincome = row.planincome;
				this.EmpName();
				this.ActFrom.activityPlan = row.activityPlan;
				this.ActFrom.empId = row.empId;
				this.updateDialog=true;
			},
			UpdateDialog(ActFrom){
				this.$refs[ActFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.axios.put("http://localhost:8089/updateByActivityKeySelective", this
								.ActFrom)
							.then(function(response) {
								_this.selectByActivitys();
								_this.updateDialog = false;
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
					this.ActFrom.activityId = row.activityId;
					this.ActFrom.timeliness = 1;
					const _this = this
					this.axios.put("http://localhost:8089/deleteByActivityKey", this.ActFrom)
						.then(function(response) {
							_this.selectByActivitys();
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
			
			
			/**
			 * @param {Object} page
			 * 将活动状态改为进行中
			 */
			start(row) {
				this.$confirm('是否确定要开始进行此活动！！', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
					center: true
				}).then(() => {
					this.ActFrom.activityId = row.activityId;
					this.ActFrom.activityState = 1;
					const _this = this
					this.axios.put("http://localhost:8089/updateByStartActivity", this.ActFrom)
						.then(function(response) {
							_this.selectByActivitys();
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
			/**
			 * 结束活动
			 */
			end(row) {
				this.endDialog = true;
				this.ActFrom = row;
			},
			EndDialog(ActFrom) {
				this.$refs[ActFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.ActFrom.activityState = 2;
						this.ActFrom.profitloss = this.ActFrom.actualincome - this.ActFrom.planincome;
						this.axios.put("http://localhost:8089/updateByEndActivity", this.ActFrom)
							.then(function(response) {
								_this.selectByActivitys();
								_this.endDialog = false;
								_this.$message({
									type: 'success',
									message: '恭喜你，活动完成!'
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



			addclue(row) {
				Object.keys(this.ClueFrom).forEach((key) => (this.ClueFrom[key] = ''))
				this.ClueFrom.activityId = row.activityId;
				this.addClue = true;
			},
			AddClue(ClueFrom) {
				this.$refs[ClueFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.ClueFrom.empId = 1;
						this.ClueFrom.conversionType = 0;
						this.ClueFrom.timeliness = 0;
						this.ClueFrom.publicpondId = 1;
						console.log(this.ClueFrom);
						this.axios.post("http://localhost:8089/addClue", this.ClueFrom)
							.then(function(response) {
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
			addcustomer(row) {
				Object.keys(this.ClueFrom).forEach((key) => (this.ClueFrom[key] = ''))
				this.ClueFrom.activityId = row.activityId;
				this.addCustomer = true;
			},
			AddCustomer(ClueFrom) {
				this.$refs[ClueFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.ClueFrom.empId = 1;
						this.ClueFrom.conversionType = 1;
						this.ClueFrom.timeliness = 0;
						this.ClueFrom.publicpondId = 2;
						this.axios.post("http://localhost:8089/addClue", this.ClueFrom)
							.then(function(response) {
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
			},

			ActivityName() {
				const _this = this
				this.axios.get("http://localhost:8089/selectByAllActivityName")
					.then(function(response) {
						console.log(response);
						console.log("-----------");
						_this.ActivityData = response.data
						console.log(response);
					}).catch(function(error) {
						console.log(error)
					})
			},

			selectByActivitys() {
				const _this = this
				this.axios.get("http://localhost:8089/selectByActivitys")
					.then(function(response) {
						_this.tableData = response.data
						console.log(response);
					}).catch(function(error) {
						console.log(error)
					}),
					this.axios.get("http://localhost:8089/selectByMyActivitys")
					.then(function(response) {
						_this.MytableData = response.data
						console.log(response);
					}).catch(function(error) {
						console.log(error)
					})
			}
		},
		created() {
			const _this = this
			this.axios.get("http://localhost:8089/selectByActivitys")
				.then(function(response) {
					_this.tableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				}),
				this.axios.get("http://localhost:8089/selectByMyActivitys")
				.then(function(response) {
					_this.MytableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				})
		}
	};
</script>

<style>
	.select-input {
		width: 300px;
		margin-right: 20px;
	}

	.buttonOne {
		float: right;
		margin-right: 10px;
	}
</style>
