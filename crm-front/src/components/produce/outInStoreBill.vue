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
                ><a href="/outInStoreBill">出入库单</a></el-breadcrumb-item
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
      <br />
      <el-row>
        <el-button size="mini" type="primary" @click="dialogFormIn = true"
          >添加入库单</el-button
        >
        <el-button size="mini" type="primary" @click="dialogFormOut = true"
          >添加出库单</el-button
        >
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
        <el-table-column label="出入库单编号" width="162" prop="hand_id">
        </el-table-column>
        <el-table-column label="库存动作" prop="hand_action" width="135">
        </el-table-column>
        <el-table-column label="数量合计" prop="sum_num"> </el-table-column>
        <el-table-column label="发起方式" prop="hand_way"> </el-table-column>
        <el-table-column
          label="关联单据名称"
          width="120px"
          prop="sale_order_name"
        >
        </el-table-column>
        <el-table-column label="关联产品" prop="pro_name"></el-table-column>
        <el-table-column
          label="创建时间"
          prop="createTime"
          width="150px"
          :formatter="dateFormat"
        >
        </el-table-column>
        <el-table-column
          label="办理时间"
          prop="hand_date"
          width="150px"
          :formatter="dateFormat"
        ></el-table-column>
        <el-table-column label="发起人员" prop="hand_emp"> </el-table-column>
        <el-table-column label="办理状态" prop="hand_stauts"> </el-table-column>
        <el-table-column fixed="right" label="操作" width="120">
          <template #default="scope">
            <el-button type="danger" size="mini" @click="handleDel(scope.row)"
              >删除</el-button
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
    <!-- 新增入库单 -->
    <el-dialog title="新增入库单" v-model="dialogFormIn">
      <el-form :model="inStoreBill" label-width="100px">
        <el-form-item label="产品">
          <el-select v-model="inStoreBill.proId" placeholder="请选择产品">
            <el-option
              v-for="item in products"
              :label="item.proName"
              :value="item.proId"
              :key="item.proName"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入库时间">
          <el-date-picker
            v-model="inStoreBill.handDate"
            type="date"
            placeholder="请选择入库日期"
            format="YYYY-MM-DD"
            value-format="YYYY-MM-DD"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入库数量">
          <el-input
            v-model="inStoreBill.outInStoreNum"
            type="number"
          ></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormIn = false">取 消</el-button>
          <el-button type="primary" @click="saveInStore()"
            >保存并入库</el-button
          >
        </span>
      </template>
    </el-dialog>
    <!-- 新增出库单 -->
    <el-dialog title="新增出库单" v-model="dialogFormOut">
      <el-form :model="outStoreBill" label-width="100px">
        <el-form-item label="产品">
          <el-select v-model="outStoreBill.proId" placeholder="请选择产品">
            <el-option
              v-for="item in products"
              :label="item.proName"
              :value="item.proId"
              :key="item.proName"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出库时间">
          <el-date-picker
            v-model="outStoreBill.handDate"
            type="date"
            placeholder="请选择出库日期"
            format="YYYY-MM-DD"
            value-format="YYYY-MM-DD"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出库数量">
          <el-input
            v-model="outStoreBill.outInStoreNum"
            type="number"
          ></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormOut = false">取 消</el-button>
          <el-button type="primary" @click="saveOutStore()"
            >保存并出库</el-button
          >
        </span>
      </template>
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
      searchInput: "",
      requestParameters: {
        page: 1,
        size: 3,
      },
      counts: 0, //保存数据的总条数
      inStoreBill: {
        //保存添加的入库单数据
        handDate: "",
        proId: "",
        outInStoreNum: "",
        storeAction: "入库",
        mode: "其他",
        handStauts: "已办理",
      },
      outStoreBill: {
        //保存添加的出库数据
        handDate: "",
        proId: "",
        outInStoreNum: "",
        storeAction: "出库",
        mode: "其他",
        handStauts: "已办理",
      },
      dialogFormIn: false,
      dialogFormOut: false,
      index: 1,
      inOutData: {
        actions: [],
        methods: [],
      },
      tableData: [], //保存未办理的出入库记录
      handleOutInStore: "", //保存出入库的时间
      products: [], //保存所有的产品
    };
  },
  computed: {},
  methods: {
    //查询产品的库存
    findProNum(proId) {
      for (var i = 0; i < this.products.length; i++) {
        if (this.products[i].proId == proId) {
          return this.products[i].proNum;
        }
      }
    },
    //添加出库单
    saveOutStore() {
      const _this = this;
      console.log(_this.outStoreBill.proId);
      var storeNum = _this.findProNum(_this.outStoreBill.proId);
      console.log("库存数量", storeNum);
      console.log("出库数量", _this.outStoreBill.outInStoreNum);
      //库存充裕
      if (storeNum < _this.outStoreBill.outInStoreNum) {
        _this.outStoreBill.handStauts = "未办理";
      }
      this.axios
        .put("http://localhost:8089/handle", _this.outStoreBill)
        .then((res) => {
          _this.dialogFormOut = false;
          if (
            res.data.success == true &&
            storeNum > _this.outStoreBill.outInStoreNum
          ) {
            _this.doQuery();
            ElMessage({
              showClose: true,
              message: "出库办理成功！",
              type: "success",
            });
          } else {
            ElMessage({
              showClose: true,
              message: "产品可用库存不足，冲正后再次操作",
              type: "error",
            });
          }
        })
        .catch((err) => {});
    },
    //添加入库单
    saveInStore() {
      const _this = this;
      console.log(_this.inStoreBill);
      this.axios
        .put("http://localhost:8089/handle", _this.inStoreBill)
        .then((res) => {
          _this.dialogFormIn = false;
          if (res.data.success == true) {
            _this.doQuery();
            ElMessage({
              showClose: true,
              message: "入库办理成功！",
              type: "success",
            });
          } else {
            ElMessage("入库办理失败！");
          }
        })
        .catch((err) => {});
    },
    //查询所有的产品
    findAllProduct() {
      const _this = this;
      this.axios
        .get("http://localhost:8089/product")
        .then((res) => {
          _this.products = res.data;
          console.log("所有的产品", _this.products);
        })
        .catch((err) => {});
    },
    //查询所有的出入库单记录
    doQuery() {
      var _this = this;
      //Object.assign(this.searchCondition,this.pageParam) 对象的拷贝
      this.axios
        .get("http://localhost:8089/handle/all", {
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
        this.doQuery(this.requestParameters);
      }
    },
    // 进入某一页
    handleCurrentChange(val) {
      this.requestParameters.page = val;
      this.doQuery();
    },
    //删除出入库单记录
    handleDel(row) {
      var _this = this;
      console.log("对未出入库单的办理：", row.hId);
      this.$confirm("此操作将永久删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          _this.axios
            .delete("http://localhost:8089/handle/" + row.hId)
            .then(res => {
              _this.dialogFormVisible = false;
              if (res.data.success == true) {
                _this.doQuery();
                ElMessage({
                  showClose: true,
                  message: "办理成功！",
                  type: "success"
                });
              } else {
                ElMessage({
                  showClose: true,
                  message: "办理失败",
                  type: "success",
                });
              }
            })
            .catch(error=>{
              console.log(error);
            });
        })
        .catch(() => {
        });
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
    this.findAllProduct();
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
