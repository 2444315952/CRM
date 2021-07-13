<template>
	<div>
		<el-button type="primary" @click="addFollow()" plain style="margin-left: -10px;">新增</el-button>
	</div>
	<div>
		<el-table :data="tableData">
			<el-table-column type="index" :index="indexMethod" label="编号">
			</el-table-column>
			<el-table-column prop="clueName" label="客户名称" align="center">
			</el-table-column>
			<el-table-column prop="followType" label="跟进计划类型" align="center">
			</el-table-column>
			<el-table-column prop="followContent" label="计划内容" align="center">
			</el-table-column>
			<el-table-column prop="addtime" label="计划时间" align="center">
			</el-table-column>
			<el-table-column label="查看" align="center">
				<template #default="scope">
					<el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
					<el-button @click="showEdit(scope.row)" type="text" size="small">填写跟进计划</el-button>
				</template>
				
			</el-table-column>
		</el-table>
	</div>
	<el-dialog title="增加跟进计划" v-model="dialogVisible" width="40%" :before-close="handleClose">
		<el-form :model="follow" ref="follow" class="demo-ruleForm">
			<el-form-item label="请选择跟进类型" prop="followType" style="padding-right: 85px;">
				<el-select v-model="follow.followType" placeholder="请选择跟进类型">
					<el-option v-for="item in optiontype" :key="item.value" :label="item.label" :value="item.value">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="跟进内容" prop="followContent">
				<el-input v-model="follow.followContent" placeholder="请输入跟进内容"></el-input>
			</el-form-item>
			<el-form-item label="计划跟进时间" prop="addtime">
				<el-date-picker v-model="follow.addtime" type="date" placeholder="选择日期">
				</el-date-picker>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="addFollow2('follow')">保存</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
	
	<el-dialog title="填写跟进计划" v-model="dialogVisible2" width="40%" :before-close="handleClose">
		<el-form :model="follow" ref="follow" class="demo-ruleForm">
			<el-form-item label="请选择跟进类型" prop="followType" style="padding-right: 85px;">
				<el-select v-model="follow.followType" placeholder="请选择跟进类型">
					<el-option v-for="item in optiontype" :key="item.value" :label="item.label" :value="item.value">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="跟进内容" prop="followContent">
				<el-input v-model="follow.followContent" placeholder="请输入跟进内容"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="updataState(follow)">保存</el-button>
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
				optiontype: [{
						value: "电话回访",
						label: "电话回访"
					},
					{
						value: "二次回访",
						label: "二次回访"
					},
					{
						value: "线下拜访",
						label: "线下拜访"
					},
					{
						value: "多次拜访",
						label: "多次拜访"
					}
				],
				tableData: [],
				dialogVisible: false,
				dialogVisible2:false,
				follow: {
					followId: "",
					empId: "",
					empName: "",
					clueId: "",
					clueName: "",
					followType: "",
					followContent: "",
					followTime: "",
					addtime: ""
				},

			}
		},
		methods: {
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
			selectAllFollow() {
				const _this = this;
				this.axios.get("http://localhost:8089/follow/selectAllFollow")
					.then(function(response) {
						_this.tableData = response.data
						console.log(response)

					}).catch(function(error) {
						console.log(error)
					})
			},
			addFollow() {
				this.dialogVisible = true;
				Object.keys(this.follow).forEach((key) => (this.follow[key] = ""))

			},
			addFollow2(follow) {
				this.follow.clueId = 10002
				const _this = this
				console.log(this.follow)
				this.axios.post("http://localhost:8089/follow/addFollow", this.follow)
					.then(function(response) {
						_this.selectAllFollow();
						_this.dialogVisible = false
					}).catch(function(error) {
						console.log(error)
					})
			},
			delfollow(row) {
				const _this = this
				_this.axios.delete("http://localhost:8089/follow/delFollowById/" + row.followId)
				
					.then(function(response) {
						_this.selectAllFollow()
						
					}).catch(function(error) {
						console.log(error)
					})
			},
			showEdit(row) {
				
				this.follow.followId = row.followId
				this.follow.clueId=row.clueId
				this.follow.empId=1
				this.follow.followType=row.followType
				this.follow.followContent=row.followContent
				this.dialogVisible2 = true
			},
			updataState(follow){
				console.log(this.follow)
				const _this = this
				this.axios.put("http://localhost:8089/follow/updateRecprd", this.follow)
					.then(function(response) {
						_this.selectAllFollow()
						_this.dialogVisible2 = false
						
					}).catch(function(error) {
						console.log(error)
					})
			
			}
		},
		created() {
			this.selectAllFollow()
		}
	}
</script>

<style>

</style>
