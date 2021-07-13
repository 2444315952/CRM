<template>
  <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick">
    <el-tab-pane name="first" label="待审批票据">
      <p style="margin-top: 10px">
        <el-button type="primary" @click="pltg">审核通过</el-button>
        <el-button type="primary" @click="bhdj">驳回单据</el-button>
      </p>
      <el-table
        :header-cell-style="{ background: '#d6e1ec', color: '#000000' }"
        class="qwe"
        ref="singleTable"
        :data="tableData"
        highlight-current-row
        @selection-change="handleCurrentChange"
        style="width: 100%"
        height="500"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column type="index" label="No." width="50"> </el-table-column>
        <el-table-column
          property="sale_order_name"
          label="订单名称"
          width="120"
        >
        </el-table-column>
        <el-table-column property="Clue_Name" label="客户名称" width="150">
        </el-table-column>
        <el-table-column label="期次名称">
          <template #default="scope">
            {{ scope.row.beriod_name + "(共" + scope.row.counts + "期)" }}
          </template>
        </el-table-column>
        <el-table-column property="emp_name" label="经办人"> </el-table-column>
        <el-table-column property="receipt_money" label="开票金额">
        </el-table-column>
        <el-table-column
          property="create_date"
          :formatter="dateFormat"
          label="开票日期"
        >
        </el-table-column>
        <el-table-column property="pay_taxes" label=" 开票号码">
        </el-table-column>
        <el-table-column property="remarks" label="备注"> </el-table-column>
        <el-table-column label="状态">
          <template #default="scope">
            <span v-if="scope.row.apply == 0"> 待审批 </span>
          </template>
        </el-table-column>
        <!-- <el-table-column label="操作">
          <template #default="scope">
            <el-button type="primary" @click="edit(scope.row)">编辑</el-button>
          </template>
        </el-table-column> -->
      </el-table>
    </el-tab-pane>
    <el-tab-pane name="second" label="已审批票据">
      <el-table
        :header-cell-style="{ background: '#d6e1ec', color: '#000000' }"
        class="qwe"
        ref="singleTable"
        :data="tableData"
        highlight-current-row
        @current-change="handleCurrentChange"
        style="width: 100%"
        height="500"
      >
        <el-table-column type="index" label="No." width="50"> </el-table-column>
        <el-table-column
          property="sale_order_name"
          label="订单名称"
          width="120"
        >
        </el-table-column>
        <el-table-column property="Clue_Name" label="客户名称" width="150">
        </el-table-column>
        <el-table-column label="期次名称">
          <template #default="scope">
            {{ scope.row.beriod_name + "(共" + scope.row.counts + "期)" }}
          </template>
        </el-table-column>
        <el-table-column property="emp_name" label="经办人"> </el-table-column>
        <el-table-column property="receipt_money" label="开票金额">
        </el-table-column>
        <el-table-column
          property="create_date"
          :formatter="dateFormat"
          label="开票日期"
        >
        </el-table-column>
        <el-table-column property="pay_taxes" label=" 开票号码">
        </el-table-column>
        <el-table-column property="remarks" label="备注"> </el-table-column>
        <el-table-column label="状态">
          <template #default="scope">
            <span v-if="scope.row.apply == 1"> 已审批 </span>
          </template>
        </el-table-column>
      </el-table>
    </el-tab-pane>
    <el-tab-pane name="third" label="已驳回票据">
      <p style="margin-top: 10px">
        <el-button type="primary" @click="plbh">撤销驳回</el-button>
      </p>
      <el-table
        :header-cell-style="{ background: '#d6e1ec', color: '#000000' }"
        class="qwe"
        ref="singleTable"
        :data="tableData"
        highlight-current-row
        @selection-change="handleCurrentChange"
        style="width: 100%"
        height="500"
      >
        <el-table-column type="selection" width="50"> </el-table-column>
        <el-table-column type="index" label="No." width="50"> </el-table-column>
        <el-table-column
          property="sale_order_name"
          label="订单名称"
          width="120"
        >
        </el-table-column>
        <el-table-column property="Clue_Name" label="客户名称" width="150">
        </el-table-column>
        <el-table-column label="期次名称">
          <template #default="scope">
            {{ scope.row.beriod_name + "(共" + scope.row.counts + "期)" }}
          </template>
        </el-table-column>
        <el-table-column property="emp_name" label="经办人"> </el-table-column>
        <el-table-column property="receipt_money" label="开票金额">
        </el-table-column>
        <el-table-column
          property="create_date"
          :formatter="dateFormat"
          label="开票日期"
        >
        </el-table-column>
        <el-table-column property="pay_taxes" label=" 开票号码">
        </el-table-column>
        <el-table-column property="remarks" label="备注"> </el-table-column>
        <el-table-column label="状态">
          <template #default="scope">
            <span v-if="scope.row.apply == 2"> 已驳回 </span>
          </template>
        </el-table-column>
      </el-table>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import { ElMessage } from "element-plus";
import moment from "moment";
export default {
  data() {
    return {
      tableData: [],
      currentRow: null,
      activeName: "first",
      fff: [],
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log("activeName", this.activeName);
      this.selectallreceipt();
    },
    //时间转换
    dateFormat(row, column) {
      var date = row[column.property];
      if (date == undefined) {
        return "";
      }
      return moment(date).format("YYYY-MM-DD hh:mm:ss");
    },
    setCurrent(row) {
      this.$refs.singleTable.setCurrentRow(row);
    },
    handleCurrentChange(val) {
      this.fff = [];
      if(val != null ){
        for (var i = 0; i < val.length; i++) {
        this.fff.push(val[i].receipt_id);
      }
      }
    },
    //查询所有开票
    selectallreceipt() {
      const _this = this;
      this.axios({
        url: "http://localhost:8089/receipt/selectallreceipt",
        method: "get",
        params: { activeName: this.activeName },
      })
        .then(function (response) {
          _this.tableData = response.data.record;
          console.log("res:", response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    pltg() {  
        if(this.fff.length == 0){
            ElMessage({
              type:'warning',
              message: "请选择需要通过的票据！"
            });
            return false;
        }
       this.$confirm("是否确认通过选中的票据？","(提示:如果多选则批量通过)",{
          confirmButtonText: "是",
          cancelButtonText: "否",
          type: "warning",
        })
          .then(_ => {
            const _this = this;
            this.axios({
              url: "http://localhost:8089/receipt/updatespltg",
              method: "post",
              data: {list: this.fff},
            })
              .then(function (response) {
                _this.selectallreceipt();
                ElMessage({
                  type: "success",
                  message: response.data.record,
                });
                
              })
              .catch(function (error) {
                console.log(error);
              });

          })
          .catch(_ => {
            ElMessage({
              type:'info',
              message: "已取消操作"
            });
          });
    },
    bhdj(){
      if(this.fff.length == 0){
            ElMessage({
              type:'warning',
              message: "请选择需要驳回的票据！"
            });
            return false;
        }
       this.$confirm("是否确认将选中的票据驳回？","(提示:如果多选则批量驳回)",{
          confirmButtonText: "是",
          cancelButtonText: "否",
          type: "warning",
        })
          .then(_ => {
            const _this = this;
            this.axios({
              url: "http://localhost:8089/receipt/updatesplbh",
              method: "post",
              data: {list: this.fff},
            })
              .then(function (response) {
                _this.selectallreceipt();
                ElMessage({
                  type: "success",
                  message: response.data.record,
                });
                
              })
              .catch(function (error) {
                console.log(error);
              });

          })
          .catch(_ => {
            ElMessage({
              type:'info',
              message: "已取消操作"
            });
          });
    },
    plbh() {  
        if(this.fff.length == 0){
            ElMessage({
              type:'warning',
              message: "请选择需要撤销驳回的票据！"
            });
            return false;
        }
       this.$confirm("是否确认撤销驳回选中的票据？","(提示:如果多选则批量撤销驳回)",{
          confirmButtonText: "是",
          cancelButtonText: "否",
          type: "warning",
        })
          .then(_ => {
            const _this = this;
            this.axios({
              url: "http://localhost:8089/receipt/updatesplcx",
              method: "post",
              data: {list: this.fff},
            })
              .then(function (response) {
                _this.selectallreceipt();
                ElMessage({
                  type: "success",
                  message: response.data.record,
                });
                
              })
              .catch(function (error) {
                console.log(error);
              });
          })
          .catch(_ => {
            ElMessage({
              type:'info',
              message: "已取消操作"
            });
          });
    },
    edit(row){
        console.log("rows:",row)
    },
  },
  created() {
    this.selectallreceipt();
  },
};
</script>

<style>
</style>