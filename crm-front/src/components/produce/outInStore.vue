<template>
  <div id="outInStore">
    <el-card>
      <el-row>
        <el-row :gutter="350">
          <el-col :span="16">
            <el-breadcrumb
              separator-class="el-icon-arrow-right"
              style="padding-bottom: 35px"
            >
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item
                ><a href="/outInStore">出入库办理</a></el-breadcrumb-item
              >
            </el-breadcrumb>
          </el-col>
          <el-col :span="6">
            <el-input
              style="width: 290px; float: left"
              placeholder="请输入出入库单编号"
              v-model="searchInput"
            >
              <template #append>
                <el-button
                  icon="el-icon-search"
                  size="small"
                  @click="handleSearch"
                ></el-button>
              </template>
            </el-input>
          </el-col>
        </el-row>
        <hr />
      </el-row>
      <el-row>
        <span class="font">
          <b>库存动作：</b>
          <el-checkbox-group
            v-model="inOutData.actions"
            style="display: inline-block"
          >
            <el-checkbox
              label="出库"
              key="出库"
              @change="checkChange"
            ></el-checkbox>
            <el-checkbox
              label="入库"
              key="入库"
              @change="checkChange"
            ></el-checkbox>
          </el-checkbox-group>
        </span>
      </el-row>
      <br />
      <el-row>
        <span class="font"><b>发起方式：</b></span>
        <el-checkbox-group
          v-model="inOutData.methods"
          style="display: inline-block"
        >
          <el-checkbox label="销售订单" @change="checkChange"></el-checkbox>
          <el-checkbox label="退货单" @change="checkChange"></el-checkbox>
          <el-checkbox label="其他" @change="checkChange"></el-checkbox>
        </el-checkbox-group>
      </el-row>
    </el-card>
    <el-card>
      <el-table
        :data="tableData"
        style="width: 100%"
        border
        ighlight-current-row
      >
        <el-table-column type="index" label="No" :index="index">
        </el-table-column>
        <el-table-column label="出入库单编号" width="162"> </el-table-column>
        <el-table-column label="库存动作" prop="documentDate" width="135">
        </el-table-column>
        <el-table-column label="数量合计" prop="supplierName">
        </el-table-column>
        <el-table-column label="发起方式" prop="employeeName">
        </el-table-column>
        <el-table-column label="关联单据名称" width="120px"> </el-table-column>
        <el-table-column label="关联产品" prop="warehouseName">
        </el-table-column>
        <el-table-column label="发起人" prop="audited"> </el-table-column>
        <el-table-column label="创建时间" prop="paymentStatus">
        </el-table-column>
        <el-table-column label="退货状态" prop="returnState"> </el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
              >编辑</el-button
            >
          </template>
        </el-table-column>
      </el-table>
	  <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :currentPage="requestParameters.page"
      :page-size="requestParameters.size"
      layout="total, prev, pager, next"
      :total="counts">
    </el-pagination>
    </el-card>
    <el-button @click="handleEdit">办理</el-button>
    <el-dialog title="出入库办理" v-model="dialogFormVisible">
      <el-form :model="inOutStore" label-width="100px">
        <el-form-item label="出入库时间">
          <el-date-picker
            v-model="handTime"
            type="date"
            placeholder="选择日期"
            format="YYYY-MM-DD"
            value-format="YYYY-MM-DD"
          >
          </el-date-picker>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="editInOutStore()">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import qs from "qs";
import moment from "moment";
export default {
  name: "outInStore",
  data() {
    return {
	  counts: '',//保存数据的总条数
      inOutStore: "",
      dialogFormVisible: false,
      index: 1,
      inOutData: {
        actions: [],
        methods: [],
      },
      tableData: [], //保存未办理的出入库记录
	  handleOutInStore:'',//保存出入库的时间
      tableTotal: 0,
      multipleSelection: [],
      pageParam: {
        pageNum: 1,
        pageSize: 10,
      },
    };
  },
  computed: {
    searchCondition() {
      return {
        purchDocunum: this.searchInput,
        supplierName: this.searchInput,
        warehouseName: this.searchInput,
        employeeName: this.searchInput,
      };
    },
  },
  methods: {
	//查询未完成的出入库单记录
	doQuery(){
		this.axios.get("http://localhost").
  		then(res => {
			console.log(res.data)
		}).catch((err) => {})
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
      this.requestParameters.page = val
      this.doQuery();
    },
	//处理未完成的出入库单
    handleEdit() {
      this.dialogFormVisible = true;
    },
    checkChange() {
      console.log(this.inOutData);
    },
	//------
    dateFormat(row, column) {
      var date = row[column.property];
      if (date == undefined) {
        return "";
      }
      return moment(date).format("YYYY-MM-DD HH:mm");
    },
    loadData() {
      this.axios({
        url: "http://localhost:8089/eims/purchase",
        method: "get",
        params: this.pageParam,
      })
        .then((response) => {
          this.tableData = response.data.list;
          this.tableTotal = response.data.total;
        })
        .catch((error) => {});
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;

      if (val.length > 0) this.showDeleteButton = true;
      else this.showDeleteButton = false;
    },
    handleSizeChange(val) {
      this.pageParam.pageSize = val;

      if (this.queryType == "all") this.loadData();
      else if (this.queryType == "search") this.handleSearch();
      else if (this.queryType == "screen") this.handleScreen();
    },
    handleCurrentChange(val) {
      this.pageParam.pageNum = val;

      if (this.queryType == "all") this.loadData();
      else if (this.queryType == "search") this.handleSearch();
      else if (this.queryType == "screen") this.handleScreen();
    },
    handleAudit(val) {
      this.$confirm("此操作将通过审核，是否继续？", "提示", {
        confirmButtonTest: "确定",
        cancelButtonTest: "取消",
        type: "warning",
      })
        .then(() => {
          this.axios({
            url: "http://localhost:8089/eims/purchase",
            method: "put",
            data: { purchId: val, audited: 1 },
          })
            .then((response) => {
              this.loadData();
              this.$message({
                type: "success",
                message: "审核成功",
              });
            })
            .catch((error) => {});
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },
    handleDelete() {
      var isHaveAudited = false;

      for (var i = 0; i < this.multipleSelection.length; i++) {
        if (this.multipleSelection[i].audited == 1) {
          this.$message({
            type: "info",
            message: "已审核的数据无法删除",
          });
          return false;
        } else if (this.multipleSelection[i].inStorage == 1) {
          this.$message({
            type: "info",
            message: "已入库的数据无法删除",
          });
          return false;
        } else if (this.multipleSelection[i].paymentStatus == 1) {
          this.$message({
            type: "info",
            message: "已付款的数据无法删除",
          });
          return false;
        } else if (
          this.multipleSelection[i].returnState == 1 ||
          this.multipleSelection[i].returnState == 2
        ) {
          this.$message({
            type: "info",
            message: "已退货的数据无法删除",
          });
          return false;
        }
      }

      this.$confirm("此操作将永久删除文件，是否继续？", "提示", {
        confirmButtonTest: "确定",
        cancelButtonTest: "取消",
        type: "warning",
      })
        .then(() => {
          var ids = new Array();
          for (let i = 0; i < this.multipleSelection.length; i++)
            ids.push(this.multipleSelection[i].purchId);

          this.axios({
            url: "http://localhost:8089/eims/purchase/batch",
            method: "delete",
            data: ids,
          })
            .then((response) => {
              this.loadData();
              this.$message({
                type: "success",
                message: "删除成功",
              });
            })
            .catch((error) => {});
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },
    handleSearch() {
      this.queryType = "search";

      var searchForm = Object.assign(this.searchCondition, this.pageParam);
      console.log(this.pageParam);
      this.axios({
        url: "http://localhost:8089/eims/purchase/search",
        method: "get",
        params: searchForm,
      })
        .then((response) => {
          this.tableData = response.data.list;
          this.tableTotal = response.data.total;
        })
        .catch((error) => {});
    },
    handleScreen() {
      this.queryType = "screen";

      var screenForm = Object.assign(this.screenCondition, this.pageParam);
      console.log(this.pageParam);
      this.axios({
        url: "http://localhost:8089/eims/purchase/screen",
        method: "get",
        params: screenForm,
      })
        .then((response) => {
          this.tableData = response.data.list;
          this.tableTotal = response.data.total;
        })
        .catch((error) => {});

      this.screenDialogVisible = false;
    },
    toDetail() {
      this.$router.push({
        name: "Purchase",
      });
    },
  },
  created() {
	this.doQuery();

    this.axios({
      url: "http://localhost:8089/eims/warehouse",
      method: "get",
    })
      .then((response) => {
        console.log(response.data.list);
      })
      .catch((error) => {});
  },
};
</script>

<style scope>
#outInStore {
  padding: 0px;
  min-height: 22px;
  height: 22px;
}
.font {
  font-size: 14px;
}
</style>
