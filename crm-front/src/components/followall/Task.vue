<template>
	<div>
		<el-button type="primary" @click="addTask() " plain style="margin-left: -10px;">新增</el-button>
	</div>
	<div>
		<el-table :data="tableData">
			<el-table-column type="index" :index="indexMethod" label="编号">
			</el-table-column>
			<el-table-column prop="taskName" label="任务名称" align="center">
			</el-table-column>
			<el-table-column prop="clueName" label="任务对象" align="center">
			</el-table-column>
			<el-table-column prop="task" label="任务说明" align="center">
			</el-table-column>
			<el-table-column prop="closingtime" label="截止时间" align="center">
			</el-table-column>
			<el-table-column prop="endtime" label="完成时间" align="center">
			</el-table-column>
			<el-table-column prop="taskPerson" label="负责人" align="center">
			</el-table-column>
			<el-table-column prop="empName" label="参与人" align="center">
			</el-table-column>
			<el-table-column prop="taskState" label="状态" align="center">
				<template #default="scope">
					<span v-if="scope.row.taskState==0">进行中</span>
					<span style="color: green" v-if="scope.row.taskState==1">已完成</span>
				</template>
			</el-table-column>
			<el-table-column label="操作" align="center">
				<template #default="scope">
					<el-button @click="showEdit(scope.row)" type="text" size="small">编辑</el-button>
					<el-button @click="updataState(scope.row)" type="text" size="small">完成</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
	<el-dialog title="增加任务" v-model="dialogVisible" width="40%" :before-close="handleClose">
		<el-form :model="task" ref="task" class="demo-ruleForm">
			<el-form-item label="任务名称" prop="taskName">
				<el-input v-model="task.taskName" placeholder="请输入任务名称"></el-input>
			</el-form-item>
			<el-form-item label="负责人" prop="taskPerson">
				<el-input v-model="task.taskPerson" placeholder="请输入跟进内容" disabled></el-input>
			</el-form-item>
			<el-form-item label="所属客户" prop="clueId">
				<el-select @click="clickCustomerSelect()"
					v-model="task.clueId" placeholder="请选择负责人">
					<el-option v-for="c in customerSelectValue" :label="c.clueName"
						:value="c.clueId"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="截止日期" prop="closingtime">
				<el-date-picker v-model="task.closingtime" type="date" placeholder="选择日期">
				</el-date-picker>
			</el-form-item>
			<el-form-item label="任务说明" prop="task">
				<el-input v-model="task.task" placeholder="请输入跟进内容"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="addTask2(task)">保存</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
	
	<el-dialog title="编辑任务" v-model="dialogVisible2" width="40%" :before-close="handleClose">
		<el-form :model="task" ref="task" class="demo-ruleForm">
			<el-form-item label="任务名称" prop="taskName">
				<el-input v-model="task.taskName" placeholder="请输入任务名称"></el-input>
			</el-form-item>
			<el-form-item label="负责人" prop="taskPerson">
				<el-input v-model="task.taskPerson" disabled></el-input>
			</el-form-item>
			
			<el-form-item label="参与人" prop="empName">
				<el-select @click="clickEmployeeSelect()" @change="changeEmployeeSelect"
					v-model="task.empId" placeholder="请选择负责人">
					<el-option v-for="e in employeeSelectValue" :label="e.empName"
						:value="e.empId"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="截止日期" prop="closingtime">
				<el-date-picker v-model="task.closingtime" type="date" placeholder="选择日期">
				</el-date-picker>
			</el-form-item>
			<el-form-item label="任务说明" prop="task">
				<el-input v-model="task.task" placeholder="请输入任务说明"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="updataTask('task')">保存</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<script>
	import {
		ElMessage
	} from 'element-plus'
	import axios from 'axios'
	export default {
		data() {
			return {
				tableData: [],
				dialogVisible: false,
				dialogVisible2: false,
				task: {
					taskId:"",
					empId: "",
					clueId: "",
					closingtime: "",
					taskPerson: "",
					taskName: "",
					task: "",
                    taskState:"",
				},
				employeeSelectValue: [],
				customerSelectValue: []
			}
		},
		methods: {
			clickEmployeeSelect() {
				if (this.employeeSelectValue.length > 0)
					return false
			
				this.axios({
					url: 'http://localhost:8089/employee',
					method: 'get'
				}).then(response => {
					this.employeeSelectValue = response.data.record.list
				}).catch(error => {
			
				})
			},
			clickCustomerSelect() {
				if (this.customerSelectValue.length > 0)
					return false
			
				this.axios({
					url: 'http://localhost:8089/common/customer',
					method: 'get'
				}).then(response => {
					this.customerSelectValue = response.data.record.list
				}).catch(error => {
			
				})
			},
			handleClose(done) {
				this.$confirm('确定关闭？')
					.then(_ => {
						done();
					})
					.catch(_ => {});
			},
			indexMethod(index) {
				return index + 1;
			},
			selectAllTask() {
				const _this = this;
				this.axios.get("http://localhost:8089/task/selectAllTask")
					.then(function(response) {
						_this.tableData = response.data
						console.log(response)

					}).catch(function(error) {
						console.log(error)
					})
			},
			addTask() {
				this.dialogVisible = true;
				Object.keys(this.task).forEach((key) => (this.task[key] = ""))

				//this.task.taskPerson = this.$store.getters.empName
				this.task.empId = this.$store.getters.empId

			},
			addTask2(task) {
				const _this = this
				console.log(this.task)
				this.axios.post("http://localhost:8089/task/addTask", this.task)
					.then(function(response) {
						_this.selectAllTask();
						_this.dialogVisible = false
					}).catch(function(error) {
						console.log(error)
					})
			},
			showEdit(row) {
				this.task.taskId=row.taskId
				this.task.closingtime = row.closingtime
				this.task.taskPerson=row.taskPerson
				this.task.taskName=row.taskName
				this.task.task=row.task
				this.dialogVisible2 = true
			},
			updataTask(task){
				console.log(this.task)
				const _this = this
				this.axios.put("http://localhost:8089/task/updateTask", this.task)
					.then(function(response) {
						_this.selectAllTask()
						_this.dialogVisible2 = false
						
					}).catch(function(error) {
						console.log(error)
					})
			
			},
			updataState(row){
				console.log(this.task.taskId)
				this.task.taskId=row.taskId
				const _this = this
				this.axios.put("http://localhost:8089/task/updateState", this.task)
					.then(function(response) {
						_this.selectAllTask()
						_this.dialogVisible2 = false
						
					}).catch(function(error) {
						console.log(error)
					})
			
			}

		},
		created() {
			this.selectAllTask()
		}
	}
</script>

<style>
</style>
