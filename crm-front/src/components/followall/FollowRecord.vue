<template>
	<div class="">
		<div class="">
			跟进记录
		</div>
	</div>
	<div>
		<el-table :data="tableData">
			<el-table-column type="index" :index="indexMethod" label="编号">
			</el-table-column>
			<el-table-column prop="clueName" label="客户名称" align="center">
			</el-table-column>
			<el-table-column prop="empName" label="跟进人" align="center">
			</el-table-column>
			<el-table-column prop="followType" label="跟进计划类型" align="center">
			</el-table-column>
			<el-table-column prop="followContent" label="计划内容" align="center">
			</el-table-column>
			<el-table-column prop="addtime" label="完成时间" align="center">
			</el-table-column>
			<el-table-column label="查看" align="center">
				<template #default="scope">
					<el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
					<el-button @click="updataState(scope.row)" type="text" size="small">删除</el-button>
				</template>

			</el-table-column>
		</el-table>
	</div>
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
			selectAllRecord() {
				const _this = this;
				this.axios.get("http://localhost:8089/follow/selectAllRecord")
					.then(function(response) {
						_this.tableData = response.data
						console.log(response)

					}).catch(function(error) {
						console.log(error)
					})
			},
			
			delfollow(row) {
				const _this = this
				_this.axios.delete("http://localhost:8089/follow/delFollowById/" + row.followId)

					.then(function(response) {
						_this.selectAllRecord()

					}).catch(function(error) {
						console.log(error)
					})
			},
		},
		created() {
			this.selectAllRecord()
		}
	}
</script>

<style>
</style>
