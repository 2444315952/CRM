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
                ><a href="/outInStoreWater">出入库流水</a></el-breadcrumb-item
              >
            </el-breadcrumb>
          </el-col>
          <el-col :span="6">
            <el-input
              style="width: 290px; float: left"
              placeholder="请输入产品名称"
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
        <el-table-column label="产品名称" prop="pro_name"> </el-table-column>
        <el-table-column label="产品单位" prop="pro_unit"> </el-table-column>
        <el-table-column
          label="出入库日期"
          prop="hand_date"
          width="150px"
          :formatter="dateFormat"
        ></el-table-column>
        <el-table-column label="库存动作" prop="hand_action"> </el-table-column>
        <el-table-column
          label="出入库数量"
          prop="hand_num"
          width="120px"
        ></el-table-column>
        <el-table-column label="发起方式" prop="hand_way"></el-table-column>
        <el-table-column
          label="关联单据"
          width="120px"
          prop="sale_order_name"
        ></el-table-column>
        <el-table-column label="发起人员" prop="hand_emp"></el-table-column>
        <el-table-column
          label="办理时间"
          prop="hand_date"
          width="150px"
          :formatter="dateFormat"
        ></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template #default="scope">
            <el-button size="mini" type="primary" @click="seeWater(scope.row)"
              >查看</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-size="requestParameters.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="counts"
      >
      </el-pagination>
    </el-card>
    <el-dialog title="查看流水" v-model="dialogFormIn">
      <el-form :model="outInStoreRowData">
        <el-form-item label="产品名称：">
          <b>{{ outInStoreRowData.pro_name }}</b>
        </el-form-item>
        <el-form-item label="单位名称：">
          <b>{{ outInStoreRowData.pro_unit }}</b>
        </el-form-item>
        <el-form-item label="发起方式：">
          <b>{{ outInStoreRowData.hand_way }}</b>
        </el-form-item>
        <el-form-item label="入库日期：">
          <b>{{ outInStoreRowData.hand_date.slice(0, 10) }}</b>
        </el-form-item>
        <el-form-item label="办理时间：">
          <b>{{ outInStoreRowData.hand_time.slice(0, 10) }}</b>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import qs from "qs";
import moment from "moment";
import { ElMessage } from "element-plus";

export default {
  name: "outInStore",
  data() {
    return {
      outInStoreRowData: {}, //保存出入库流水当前行的数据
      searchInput: "",
      requestParameters: {
        page: 1,
        size: 3,
      },
      counts: 0, //保存数据的总条数
      inOutStoreBill: {
        handDate: "",
        hid: "",
        proId: "",
      },
      dialogFormIn: false,
      index: 1,
      inOutData: {
        actions: [],
        methods: [],
      },
      tableData: [], //保存未办理的出入库记录
    };
  },
  computed: {},
  methods: {
    //查询出入库单下产品的明细
    doQuery() {
      var _this = this;
      this.axios
        .get("http://localhost:8089/handlePro", {
          params: _this.requestParameters,
        })
        .then((res) => {
          _this.tableData = res.data.record.list;
          _this.counts = res.data.record.total;
        })
        .catch((err) => {});
    },
    // 每页显示信息条数
    handleSizeChange(size) {
      this.requestParameters.size = size;
      if (this.requestParameters.page === 1) {
        this.doQuery();
      }
    },
    // 进入某一页
    handleCurrentChange(val) {
      this.requestParameters.page = val;
      this.doQuery();
    },
    //查看某一出入库单流水记录
    seeWater(row) {
      console.log("对未出入库单的办理：", row);
      this.outInStoreRowData = row;
      this.dialogFormIn = true;
    },
    checkChange() {
      console.log(this.inOutData);
    },
    handleSearch() {},
    //------
    dateFormat(row, column) {
      var date = row[column.property];
      if (date == undefined) {
        return "";
      }
      return moment(date).format("YYYY-MM-DD HH:mm");
    },
  },
  created() {
    this.doQuery();
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
