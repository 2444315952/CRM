<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="按订单汇总" name="first">
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
        <el-table-column type="index" label="No." width="50"> </el-table-column>
        <el-table-column
          property="sale_order_name"
          label="订单名称"
          width="120"
        >
        </el-table-column>
        <el-table-column property="Clue_Name" label="客户名称" width="150">
        </el-table-column>
        <!-- <el-table-column label="期次名称">
          <template #default="scope">
            {{ scope.row.beriod_name + "(共" + scope.row.counts + "期)" }}
          </template>
        </el-table-column> -->
        <el-table-column property="emp_name" label="负责人"> </el-table-column>
        <el-table-column property="Clue_Company" label="所属团队">
        </el-table-column>
	<el-table-column property="sale_order_amount" label="订单金额">
        </el-table-column>
	<el-table-column property="return_amount" label="退货单金额">
		<template #default="scope">
		  <span v-if="scope.row.return_amount == null || scope.row.return_amount == 0">
			没有退货单
		  </span>
		  <span v-if="scope.row.return_amount > 1">
			{{scope.row.return_amount}}
		  </span>
          	</template>
        </el-table-column>
	<el-table-column property="hkje" label="回款金额">
		<template #default="scope">
		  <span v-if="scope.row.hkje == null || scope.row.hkje == 0">
			没有回款记录
		  </span>
		  <span v-if="scope.row.hkje > 1">
			{{scope.row.hkje}}
		  </span>
          	</template>
        </el-table-column>
	<el-table-column property="qkje" label="欠款金额">
		<template #default="scope">
		  <span v-if="scope.row.qkje == null || scope.row.qkje == 0">
			0
		  </span>
		  <span v-if="scope.row.qkje > 1">
			{{scope.row.qkje}}
		  </span>
          	</template>
        </el-table-column>
	<el-table-column property="kpje" label="开票金额">
		<template #default="scope">
		  <span v-if="scope.row.kpje == null || scope.row.kpje == 0">
			0
		  </span>
		  <span v-if="scope.row.kpje > 1">
			{{scope.row.kpje}}
		  </span>
          	</template>
        </el-table-column>
	<el-table-column property="apply" label="开票状态">
		<template #default="scope">
		  <span v-if="scope.row.apply == 0">
			待处理
		  </span>
		  <span v-if="scope.row.apply == null">
			没有开票记录
		  </span>
		  <span v-if="scope.row.apply == 1">
			{{scope.row.kpje}}
		  </span>
		  <span v-if="scope.row.apply == 2">
			已驳回
		  </span>
          	</template>
        </el-table-column>
        <el-table-column
          property="create_date"
          :formatter="dateFormat"
          label="创建日期"
        ></el-table-column>
      </el-table>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import moment from "moment";
export default {
  data() {
    return {
	activeName: "first",
	currenPage:1,
	pageSize:5,
	max:0,
	tableData:[],
    };
  },
  methods: {
    //时间转换
    dateFormat(row, column) {
      var date = row[column.property];
      if (date == undefined) {
        return "";
      }
      return moment(date).format("YYYY-MM-DD hh:mm:ss");
    },
    handleCurrentChange(val){
	this.select();
    },
    select() {
      const _this = this;
      var fy = {
        currenPage: this.currenPage,
        pageSize: this.pageSize,
      };
      this.axios({
        url: "http://localhost:8089/collectionPeriod/selectorders",
        method: "get",
        params: fy,
      })
        .then(function (response) {
	  console.log("rrrr:",response)
	  _this.tableData = response.data.record.rows
	  _this.max = response.data.record.total
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
  created() {
	  this.select();
  },
};
</script>

<style>
</style>