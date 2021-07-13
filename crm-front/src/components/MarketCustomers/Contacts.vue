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
		<el-tab-pane label="所有联系人">
			<el-table :data="tableData" style="width: 100%">
				<el-table-column prop="clueName" label="合作信息" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueCompany" label="所属公司" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueContacts" label="联系人" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="conversionType" label="联系人类型" align="center" min-width="60">
					<template #default="ConversionType">
						<span v-if="ConversionType.row.conversionType== 0 ">线索联系人</span>
						<span v-if="ConversionType.row.conversionType== 1 ">客户联系人</span>
					</template>
				</el-table-column>
				<el-table-column prop="cluePhone" label="联系人电话" align="center" min-width="50">
				</el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="线索联系人">
			<el-table :data="CutableData" style="width: 100%">
				<el-table-column prop="clueName" label="合作信息" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueCompany" label="所属公司" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueContacts" label="联系人" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="conversionType" label="类型" align="center" min-width="60">
					<template #default="ConversionType">
						<span v-if="ConversionType.row.conversionType== 0 ">线索联系人</span>
						<span v-if="ConversionType.row.conversionType== 1 ">客户联系人</span>
					</template>
				</el-table-column>
				<el-table-column prop="cluePhone" label="联系人电话" align="center" min-width="50">
				</el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="客户联系人">
			<el-table :data="CltableData" style="width: 100%">
				<el-table-column prop="clueName" label="合作信息" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueCompany" label="所属公司" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueContacts" label="联系人" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="conversionType" label="类型" align="center" min-width="60">
					<template #default="ConversionType">
						<span v-if="ConversionType.row.conversionType== 0 ">线索联系人</span>
						<span v-if="ConversionType.row.conversionType== 1 ">客户联系人</span>
					</template>
				</el-table-column>
				<el-table-column prop="cluePhone" label="联系人电话" align="center" min-width="50">
				</el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="我负责的">
			<el-table :data="MytableData" style="width: 100%">
				<el-table-column prop="clueName" label="合作信息" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueCompany" label="所属公司" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="clueContacts" label="联系人" align="center" min-width="50">
				</el-table-column>
				<el-table-column prop="conversionType" label="类型" align="center" min-width="60">
					<template #default="ConversionType">
						<span v-if="ConversionType.row.conversionType== 0 ">线索联系人</span>
						<span v-if="ConversionType.row.conversionType== 1 ">客户联系人</span>
					</template>
				</el-table-column>
				<el-table-column prop="employee.empName" label="跟进人" align="center" min-width="60">
				</el-table-column>
				<el-table-column prop="cluePhone" label="联系人电话" align="center" min-width="50">
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
				CutableData: [],
				CltableData: [],
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
		created() {
			const _this = this
			this.axios.get("http://localhost:8089/selectByContacts")
				.then(function(response) {
					_this.tableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				}),

				this.axios.get("http://localhost:8089/selectByMyContacts")
				.then(function(response) {
					_this.MytableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				}),
				this.axios.get("http://localhost:8089/selectByClues")
				.then(function(response) {
					_this.CutableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				}),
				this.axios.get("http://localhost:8089/selectByCustomer")
				.then(function(response) {
					_this.CltableData = response.data
					console.log(response);
				}).catch(function(error) {
					console.log(error)
				})
		}
	}
</script>

<style>
</style>
