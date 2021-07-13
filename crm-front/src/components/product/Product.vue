<template>
<div id="product">
     <el-row>
			<el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 16px">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item><a href="/product">全部产品</a></el-breadcrumb-item>
				
			</el-breadcrumb>
     </el-row>

	 	<el-container style="background-color: white;padding-top: 15px;">
		   <el-header style="height: 60px;">
				<el-row>
			
       <!--
			 	<el-button  style="float: right;" size="medium" type="primary" @click="aa()">新增</el-button>
        	<el-col :span="16">
						<el-input style="width: 290px;float: left;" placeholder="请输入产品编号" v-model="searchInput">
						 <template #append>
						   <el-button icon="el-icon-search" size="small" @click="handleSearch" ></el-button>
                         </template>
						</el-input>
        	</el-col>
				<el-button  style="float: right;" size="medium" type="primary" @click="aa()">新增</el-button>
 <el-input
              style="width: 290px; float: right"
              placeholder="请输入出入库单编号"
              v-model="searchInput"
            >
						</el-input>	
-->

      	<el-col :span="23">
					<el-button  style="float: right;" size="medium" type="primary" @click="aa()">新增</el-button>
						<el-input style="width: 290px;float: right;" placeholder="请输入产品名称" v-model="searchInput">
						 <template #append>
						    <el-button icon="el-icon-search" size="small" @click="handleSearch" ></el-button>
             </template>
						</el-input>
        	</el-col>		

				</el-row>
							

			</el-header>

			<el-main style="background-color: white;">
            <el-table :data="tableData" max-height="477" style="width: 100%;height:477px;"
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

					<el-table-column fixed="right" label="操作" width="100">
					   <template #default="scope">
	                     <el-button type="text" size="small" @click="productEdit(scope.row)">编辑</el-button>
			             <el-button type="text" size="small" @click="productDelete(scope.row)">删除</el-button>
	                   </template>
					</el-table-column>			
	
				</el-table>
			 
     
			</el-main>
		<el-footer>
				<div class="block" style="float: right;">
					<el-pagination
              @current-change="handleCurrentChange"
              v-model:currentPage="currenPage"
              :page-size="pageSize"
              layout=" prev, pager, next"
              :total="max"
              style="margin-top: 18px;"
            >
            </el-pagination>
				</div>
			</el-footer>
		</el-container>
     <el-dialog title="编辑" v-model="updatedialogFormVisible" >
      <!-- model : 数据模型 -->
      <el-form :model="form" label-width="120px">
      
        <el-form-item label="产品名称">
          <el-input v-model="form.proName"  ></el-input>
        </el-form-item>
        <el-form-item label="负责人">
          <el-input v-model="form.emp"  ></el-input>
        </el-form-item>

        <el-form-item label="产品单位">
          <el-input v-model="form.proUnit"  ></el-input>
        </el-form-item>

		<el-form-item label="价格">
          <el-input v-model="form.proPrice"  ></el-input>
        </el-form-item>

		<el-form-item label="当前状态">
          <el-input v-model="form.proStatus"  ></el-input>
        </el-form-item>

		<el-form-item label="库存数量">
          <el-input v-model="form.proNum"  ></el-input>
        </el-form-item>

		<el-form-item label="产品型号">
          <el-input v-model="form.proType"  ></el-input>
        </el-form-item>

		<el-form-item label="产品描述">
          <el-input v-model="form.proDes"  ></el-input>
        </el-form-item>

      </el-form>
			<template #footer>
       <span class="dialog-footer">
          <el-button @click="updatedialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="updatfrom(from)">确 定</el-button>
      </span>
  </template>
    </el-dialog>


	 <el-dialog title="新增"  v-model="adddialogFormVisible" >
      <!-- model : 数据模型 -->
      <el-form :model="form" label-width="120px" >
      
        <el-form-item label="产品名称">
          <el-input v-model="form.proName"  ></el-input>
        </el-form-item>
        <el-form-item label="负责人">

          <el-input v-model="form.emp"></el-input>
        </el-form-item>

        <el-form-item label="产品单位">
          <el-input v-model="form.proUnit"  ></el-input>
        </el-form-item>

		<el-form-item label="价格">
          <el-input v-model="form.proPrice"  ></el-input>
        </el-form-item>

		<el-form-item label="当前状态">
          <el-input v-model="form.proStatus"  ></el-input>
        </el-form-item>

		<el-form-item label="库存数量">
          <el-input v-model="form.proNum"  ></el-input>
        </el-form-item>

		<el-form-item label="产品型号">
          <el-input v-model="form.proType"  ></el-input>
        </el-form-item>

		<el-form-item label="产品描述">
          <el-input v-model="form.proDes"  ></el-input>
        </el-form-item>
       
      </el-form>
			 
    <template #footer>
         <span class="dialog-footer">
          <el-button @click="adddialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="addPro()">确 定</el-button>
          </span>
       </template>

			
    </el-dialog>


	</div>
</template>

<script>
export default {
		name: "Product",
		data() {
			return {
				emp:[],
				tableData: [],
				adddialogFormVisible:false,
				updatedialogFormVisible:false,
				pro:{},
				tableTotal: 0,
				multipleSelection: [],
				pageParam: {
					"pageNum": 1,
					"pageSize": 10
				},
				  //分页
					currenPage: 1, //当前页
					max: 0,
					pageSize: 5, //每页几条数据

				form:{
					proName:"",
					emp:"",
					proUnit:"",
					proPrice:"",
					proStatus:"",
					proNum:"",
					proType:"",
					proDes:"",
					createtime:""
				}
			}
		},
		methods:{
		  //查询产品记录
		  doQuery(){
				var fy = {
        currenPage: this.currenPage,
        pageSize: this.pageSize,
      };

			  	const _this=this
				this.axios.get("http://localhost:8089/product",{params:fy}).then(function(response){
					console.log("res:::::",response)
					_this.tableData=response.data.record.list
					_this.max = response.data.record.total
					console.log(response)
				}).catch(function(error){
					console.log(error)
				})
		  },
		  // 每页显示信息条数
          handleSizeChange(size) {
           this.requestParameters.size = size
           if (this.requestParameters.page === 1) {
           this.doQuery(this.requestParameters);
           }
		  },
		  // 进入某一页
          handleCurrentChange(val) {
						
						console.log("currenPage",this.currenPage,"---","currenPage:",this.currenPage)
						this.doQuery();
           //this.requestParameters.page = val
          },
		  handleSelectionChange(val){
			  this.multipleSelection=[]
			  for(let i=0;i<val.length;i++){
				  this.multipleSelection[i]=val[i].id;
			  }
		  },
					  //删除产品
		  productDelete(row){
			  const _this=this
			  var flag=true
			  this.$confirm('此操作将永久删除该数据，是否继续?','提示',{
				  confirmButtonText:'确定',
				  cancelButtonText:'取消',
				  type:'warning'
			  }).then(()=>{
				  _this.axios.delete("http://localhost:8089/delProduct/"+row.proId)
				  console.log(row.proId)
				  .then(function(response){
					  _this.doQuery()
					  var pro=response.data
					  var rows=_this.tableData.filter(d=>d.proId!=row.proId)
					  console.log("del rows:%o",rows)
					  _this.tableData=rows

				  }).catch(function(success){
					  console.log(error)
				  })

			  }).catch(()=>{
				
					 _this.doQuery()
             this.$message({
							 
					        type:'success',
					        message:'删除成功'
				      });
					
							 _this.doQuery()
			  });
		  }	,
		
			aa(){
				this.form={}
				this.adddialogFormVisible=true

			},

	     //新增产品
		 addPro(){
			const _this=this
		
				  this.axios.post("http://localhost:8089/addProduct",this.form)
				   .then(function(response){
						 _this.doQuery()
					 console.log(response)
				 var products=response.data
				 _this.tableData.push(products)
				 console.log(products)
				_this.adddialogFormVisible=false
          
		

				  }).catch(function(error){
					  console.log(error)
				  })
		 },

		 //查看产品信息显示在修改框
		 productEdit(row){
			 this.form.proId=row.proId
			 this.form.proName=row.proName
			 this.form.emp=row.emp
			 this.form.proUnit=row.proUnit
			 this.form.proPrice=row.proPrice
			 this.form.proStatus=row.proStatus
			 this.form.proNum=row.proNum
			 this.form.proType=row.proType
			 this.form.proDes=row.proDes
			 this.updatedialogFormVisible=true
			 // _this.doQuery();
		 },

	
		updatfrom(form) {
				console.log(this.form)
				const _this = this
				this.axios.put("http://localhost:8089/updateProduct", this.form)
					.then(function(response) {
					
						_this.updatedialogFormVisible = false
							_this.doQuery()
						
					}).catch(function(error) {
						console.log(error)
					})
			
			},
		},
		created() {
		   this.doQuery()
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
