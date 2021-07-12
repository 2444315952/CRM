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
				<el-table-column prop="activityState" label="活动状态" align="center" min-width="60">
				</el-table-column>
				<el-table-column prop="planincome" label="活动成本" align="center" min-width="80">
				</el-table-column>
				<el-table-column prop="actualincome" label="活动收入" align="center" min-width="80">
				</el-table-column>
				<el-table-column prop="profitloss" label="活动盈亏" align="center" min-width="80">
				</el-table-column>
				<el-table-column prop="person" label="活动负责人" align="center" min-width="60">
				</el-table-column>
				<el-table-column label="操作" align="center" min-width="100">
					<template #default="scope">
						<el-button @click="start()" type="text" size="small">开始活动</el-button>
						<div class="ivu-divider"></div>
						<el-button @click="end()" type="text" size="small">结束活动</el-button>
						<div class="ivu-divider"></div>
						<el-button @click="Delete()" type="text" size="small">删除</el-button>
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
		<el-dialog title="新建活动计划" v-model="addDialog" width="30%" center :before-close="handleClose">
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
				<!-- <el-form-item label="活动负责人" prop="empId">
					<el-select v-model="ActFrom.empId" placeholder="请选择" style="width: 200px;">
						<el-option v-for="item in EmpData" :key="item.Employee.empId"
							:label="item.Employee.empName" :value="item.Employee.empId">
						</el-option>
					</el-select>
				</el-form-item> -->
				<el-form-item size="large">
					<el-button type="primary" @click="AddDialog('ActFrom')">确 定</el-button>
					<el-button @click="addDialog = false">取 消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>

		<el-tab-pane label="我负责的" name="second">我负责的</el-tab-pane>
	</el-tabs>

</template>

<script>
	export default {
		data() {
			return {
				activeName: 'first',
				input: '',
				addDialog: false,
				LoginName: "焦凡超", //默认测试姓名数据
				tableData: [],
				ActFrom: {
					activityId: '',
					activityName: '',
					addTime: '',
					endTime: '',
					address: '',
					activityType: '',
					activityState: '',
					planincome: '',
					actualincome: '',
					profitloss: '',
					activityPlan: '',
					timeliness: '',
					person: '',
					empId: ''
				}
			};
		},
		methods: {
			AddActivity() {
				Object.keys(this.ActFrom).forEach((key) => (this.ActFrom[key] = ''))
				this.addDialog = true;
			},
			AddDialog(ActFrom) {
				this.$refs[ActFrom].validate((valid) => {
					if (valid) {
						const _this = this
						this.ActFrom.person = this.LoginName;
						this.axios.post("http://localhost:8089/Training/addActivity", this.ActFrom)
							.then(function(response) {
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
			handleClose(done) {
				this.$confirm('确认关闭？')
					.then(_ => {
						done();
					})
					.catch(_ => {});
			}
		},
		created() {
			const _this = this
			this.axios.get("http://localhost:8089/Training/selectByActivitys")
				.then(function(response) {
					_this.tableData = response.data.list
					console.log(_this.tableData);
					console.log("我在这");
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
