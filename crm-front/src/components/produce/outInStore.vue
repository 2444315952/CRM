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
        <el-table-column label="关联产品" prop="pro_name"> </el-table-column>
        <el-table-column
          label="创建时间"
          prop="createTime"
          width="150px"
          :formatter="dateFormat"
        >
        </el-table-column>
        <el-table-column label="办理状态" prop="hand_stauts"> </el-table-column>
        <el-table-column fixed="right" label="操作" width="150">
          <template #default="scope">
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)"
              >编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <el-dialog title="出入库办理" v-model="dialogFormVisible">
      <el-form :model="inOutStore" label-width="100px">
        <el-form-item label="出入库时间">
          <el-date-picker
            v-model="inOutStore.handDate"
            type="date"
            placeholder="请选择出入库日期"
            format="YYYY-MM-DD"
            value-format="YYYY-MM-DD"
          >
          </el-date-picker>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="handleInOutStore()"
            >确 定</el-button
          >
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import qs from "qs";
import moment from "moment";
import { ElMessage } from 'element-plus'

export default {
  name: "outInStore",
  data() {
    return {
      searchInput: "",
      requestParameters: {
        page: 1,
        size: 2,
      },
      counts: "", //保存数据的总条数
      inOutStore: {
        handDate: "",
        hid: "",
        proId:'',
        handProId:'',
        sumNum:''
      },
      dialogFormVisible: false,
      index: 1,
      inOutData: {
        actions: [],
        methods: [],
      },
      tableData: [], //保存未办理的出入库记录
      handleOutInStore: "", //保存出入库的时间
    };
  },
  computed: {},
  methods: {
    //查询未完成的出入库单记录
    doQuery() {
      var _this = this;
      this.axios
        .get("http://localhost:8089/handle")
        .then((res) => {
          _this.tableData = res.data.record;
          console.log(res.data.record);
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
    //弹出对话框输入出入库时间处理未完成的出入库单
    handleEdit(row) {
      this.dialogFormVisible = true;
      this.inOutStore.hid = row.hId;
      this.inOutStore.proId=row.pro_id;
      this.inOutStore.handProId=row.handle_product_id;
      this.inOutStore.sumNum=row.sum_num;
    },
    //对未出入库单进行办理
    handleInOutStore() {
      var _this = this;
      console.log("对未出入库单的办理：",_this.inOutStore);
      this.axios
        .post("http://localhost:8089/handle", _this.inOutStore)
        .then(res=> {
           _this.dialogFormVisible = false;
          if (res.data.success == true) {
            _this.doQuery();
            ElMessage({
              showClose: true,
             message: '办理成功！',
              type: 'success'
             });
             
          }else{
            ElMessage({
             showClose: true,
              message: res.data.message
            });
          }
        }).catch((err) => {});
        
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
