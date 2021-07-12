<template>
<div id="Product">
     <el-row>
			<el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 16px">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item><a href="/product">全部产品</a></el-breadcrumb-item>
			</el-breadcrumb>
     </el-row>

	 	<el-container style="background-color: white;padding-top: 15px;">
		   <el-header style="height: 30px;">
				<el-row>

					<el-col :span="16">
						<el-input style="width: 290px;float: left;" placeholder="请输入产品编号">
						
						</el-input>
					</el-col>

					<el-col :span="3">
						<el-button v-show="" style="float: right;" size="medium" type="primary">新增</el-button>
					</el-col>
				</el-row>
			</el-header>

			<el-main style="background-color: white;">
        <el-table :data="proData" max-height="477" style="width: 100%;height:477px;"
					@selection-change="handleSelectionChange">
					<el-table-column type="selection">
					</el-table-column>
					<el-table-column label="产品名称"  prop="proName" width="162">
					</el-table-column>
					<el-table-column sortable  label="负责人" prop="emp">
					</el-table-column>
					<el-table-column label="产品单位" prop="proUnit">
					</el-table-column>
					<el-table-column sortable label="价格" prop="proPrice">
					</el-table-column>
					<el-table-column label="库存状态" prop="proStatus">
					</el-table-column>
					<el-table-column sortable  label="库存数量" prop="proNum">
						
					</el-table-column>
					<el-table-column label="产品型号" prop="proType">
						
					</el-table-column>
					<el-table-column sortable  label="产品描述" prop="proDes">
						
					</el-table-column>
					<el-table-column sortable  label="创建时间" prop="createtime" >
					</el-table-column>
				
					
				</el-table>
			</el-main>
		<el-footer>
				<div class="block" style="float: right;">
					<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
						:page-sizes="[10,20,40,80]" :page-size="pageParam.pageSize"
						layout="total, sizes, prev, pager, next, jumper" :total="tableTotal">
					</el-pagination>
				</div>
			</el-footer>
		</el-container>

	</div>
</template>

<script>
export default {
		name: "Product",
		data() {
			return {
				proData: [],
				tableTotal: 0,
				multipleSelection: [],
				pageParam: {
					"pageNum": 1,
					"pageSize": 10
				}
			}
		},
		created() {
			const _this=this			
			this.axios.get("http:localhost:8089/product").then(function(response){
				this.proData=response.data
				console.log(response)
			}).catch(function(error){
				console.log(error)
			})
		}
	}
</script>

<style>
	#PurchaseList .el-table .cell .el-button {
		padding: 0px;
		min-height: 22px;
		height: 22px;
	}
</style>
