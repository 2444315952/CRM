<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="回款" name="first">
      <div style="width: 935px">
        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <span><i class="el-icon-s-finance">回款</i></span>
              <span style="float: right">
                <el-button type="primary" size="mini" @click="addperiod"
                  >+新建回款期次</el-button
                >
                <el-button type="primary" size="mini">+批量新建</el-button>
              </span>
            </div>
          </template>
          <div class="text item">
            <el-col :span="8">
              <el-card shadow="hover" style="width: 281px; heiht: 76px">
                <i style="" class="el-icon-s-finance iss"></i>
                <div class="divss" style="">
                  <span style="" class="spsp">金额总计</span>
                  <span style="color: #f9941c" class="spsp">{{ zje }}</span>
                </div>
              </el-card>
            </el-col>
            <el-col :span="8">
              <el-card
                shadow="hover"
                style="margin-left: 20px; width: 588px; heiht: 76px"
              >
                <i style="" class="el-icon-s-finance iss"></i>
                <div class="divss" style="">
                  <span style="" class="spsp">已回款金额</span>
                  <span style="color: #f9941c" class="spsp">{{ yhk }}</span>
                </div>
                <!-- <el-divider style="height: 40px;" direction="vertical"></el-divider> -->
                <i style="" class="el-icon-s-finance iss"></i>
                <div class="divss" style="">
                  <span style="" class="spsp">未回款金额</span>
                  <span style="color: #f9941c" class="spsp">{{ whk }}</span>
                </div>
                <i style="" class="el-icon-s-claim iss"></i>
                <div class="divss" style="">
                  <span style="" class="spsp">已开票金额</span>
                  <span style="color: #f9941c" class="spsp">{{ ykp }}</span>
                </div>
              </el-card>
            </el-col>
          </div>
          <el-dialog
          title="提示"
          v-model="dialogVisible2"
          width="30%"
          :before-close="handleClose"
          style="text-align: center"
        >
          <span>
            <div
              style="
                border-bottom: 1px solid #dcdfe6;
                border-left: 1px solid #dcdfe6;
                border-right: 1px solid #dcdfe6;
                text-align: center;
              "
            >
              <el-divider content-position="left">请选择查看的的记录</el-divider>
              <span style="margin-left: 20px">
                <el-radio-group v-model="radio">
                  <el-radio
                    :label="0"
                    style="margin-left: -20px"
                    >查看回款记录</el-radio
                  >
                  <el-radio :label="1">查看开票记录</el-radio>
                  <div style="height: 10px"></div>
                </el-radio-group>
              </span>
            </div>
          </span>
          <template #footer>
            <span class="dialog-footer">
              <el-button @click="dialogVisible2 = false">取 消</el-button>
              <el-button
                type="primary"
                @click="
                  addres();
                  dialogVisible2 = false;
                "
                >确 定</el-button
              >
            </span>
          </template>
        </el-dialog>
        <el-dialog
          :title="title"
          v-model="centerDialogVisibleckjl"
          width="40%"
          custom-class="sss ccc"
          @check-change="checkChange"
        >
          <span>            
            <el-table v-if="radio==0" :header-cell-style="{ background: '#d6e1ec', color: '#000000' }" class="qwe" :data="tableData2" border style="width: 100%">
              <el-table-column fixed prop="beriod_name" label="期次" > </el-table-column>
              <el-table-column prop="sale_order_name" label="订单名称"> </el-table-column>
              <el-table-column prop="Clue_Name"  label="客户名称">
              </el-table-column>
              <el-table-column prop="emp_name" label="负责人"> </el-table-column>
              <el-table-column prop="payment_money" label="回款金额">
              </el-table-column>
              <el-table-column prop="payment_date" :formatter="dateFormat" label="回款日期"> </el-table-column>
              <el-table-column prop="record_static_name" label="回款方式"> </el-table-column>
              <el-table-column prop="remarks" label="备注"> </el-table-column>
              <el-table-column prop="remarks" label="操作"> 
                <template #default="scope">
                  <el-button type="text" size="small" @click="del(scope.row)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
            <el-table v-if="radio==1" :header-cell-style="{ background: '#d6e1ec', color: '#000000' }" class="qwe" :data="tableData3" border style="width: 100%">
              <el-table-column  prop="sale_order_name" width="120" label="订单名称" > </el-table-column>
              <el-table-column prop="emp_name" label="负责人"> </el-table-column>
              <el-table-column prop="receipt_name" width="150" label="开票申请名称">
              </el-table-column>
              <el-table-column prop="Bill_title" label="票据抬头"> </el-table-column>
              <el-table-column prop="pay_taxes" show-overflow-tooltip width="150" label="纳税识别号">
                <template #default="scope">
                    <el-tooltip :content="scope.row.pay_taxes" placement="top">
                      {{scope.row.pay_taxes}}
                    </el-tooltip>
                </template>
              </el-table-column>
              <el-table-column prop="remarks" label="备注"></el-table-column>
              <el-table-column label="开票金额">
                <template #default="scope">
                  <span v-if="scope.row.apply == null">
                      未开票
                  </span>
                  <span v-if="scope.row.apply == 0">
                     ￥{{scope.row.receipt_money}}<br/>待处理
                  </span>
                  <span v-if="scope.row.apply == 1">
                      {{scope.row.receipt_money}}
                  </span>
                  <span v-if="scope.row.apply == 2">
                      已驳回
                  </span>
                </template>
              </el-table-column>
           <el-table-column  v-if="ifpd != 1" label="操作" fixed width="120">
                <template #default="scope">
                    <el-button type="text" size="small" @click="tg(scope.row)">通过</el-button>
                    <el-button type="text" size="small"  @click="bh(scope.row)">驳回</el-button>
                </template>
           </el-table-column>
            </el-table>
          </span>
          <template #footer>
            <span class="dialog-footer">
              <el-button @click="centerDialogVisibleckjl = false">关  闭</el-button>
            </span>
          </template>
        </el-dialog>
          <div class="divhk">
            <el-table :header-cell-style="{ background: '#d6e1ec', color: '#000000' }" class="qwe" :data="tableData"  style="width: 100%;height:347px">
              <el-table-column fixed prop="qx" :label="qc" > </el-table-column>
              <el-table-column prop="emp_name" label="负责人"> </el-table-column>
              <el-table-column prop="blanned_date" width="200" :formatter="dateFormat" label="计划回款日期">
              </el-table-column>
              <el-table-column prop="blanned_moeny" label="计划回款"> </el-table-column>
              <el-table-column label="实际回款">
                <template #default="scope">
                  <span v-if="scope.row.bmount_moeny == null">
                      未回款
                  </span>
                  <span v-if="scope.row.bmount_moeny != 0">
                      {{scope.row.bmount_moeny}}
                  </span>
                </template>
              </el-table-column>
              <el-table-column  label="开票金额">
                <template #default="scope">
                  <span v-if="scope.row.apply == null">
                      未开票
                  </span>
                  <span v-if="scope.row.apply == 0">
                      待处理
                  </span>
                  <span v-if="scope.row.apply == 1">
                      开票完成 <br/>{{scope.row.receipt_money}}
                  </span>
                  <span v-if="scope.row.apply == 2">
                      已驳回
                  </span>
                </template>
              </el-table-column>
              <el-table-column fixed="right" label="操作" width="280">
                <template #default="scope">
                  <el-button
                    @click="ckck(scope.row)"
                    type="text"
                    size="small"
                    >查看</el-button
                  >
                  <el-button v-if="scope.row.blanned_moeny!=scope.row.bmount_moeny" type="text" size="small" @click="addhk(scope.row)">添加回款记录</el-button>
                  <el-button v-if="scope.row.receipt_money==null" type="text" size="small" @click="createkp(scope.row)">新建开票申请</el-button>
                </template>
              </el-table-column>
            </el-table>
            <p style="text-align: center">
            <el-pagination

              @current-change="handleCurrentChange"
              v-model:currentPage="currenPage"
              :page-size="pageSize"
              layout=" prev, pager, next"
              :total="max"
              style="margin-top: 18px;"
            >
            </el-pagination>
          </p>
          </div>
        </el-card>
      </div>
      <el-dialog
        title="新建回款期次"
        v-model="dialogVisible"
        width="26%"
        custom-class="xubox_title"
      >
        <el-form :model="form" label-width="80px">
          <el-form-item label="关联订单" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form.ddmc"
            ></el-input>
          </el-form-item>
          <el-form-item label="期次名称" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form.beriodName"
            ></el-input>
          </el-form-item>
          <el-form-item label="负责人" class="ttt itemlabel forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 33px"
              v-model="form.fzr"
            ></el-input>
          </el-form-item>
          <el-form-item label="计划回款金额" class="itemlabel forms">
            <el-input
              size="mini"
              style="width: 300px"
              v-model="form.blannedMoeny"
            ></el-input>
          </el-form-item>
          <el-form-item label="计划回款日期" class="itemlabel forms">
            <el-date-picker
              v-model="form.blannedDate"
              size="mini"
              style="width: 300px"
              type="date"
              placeholder="选择日期"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="备注" class="itemlabel bzs forms">
            <el-input
              type="textarea"
              size="mini"
              style="width: 300px; margin-left: 43px"
              v-model="form.remarks"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="quedadd"
              >确 定</el-button
            >
          </span>
        </template>
      </el-dialog>
      <el-dialog
        title="添加回款记录"
        v-model="dialogVisible1"
        width="26%"
        custom-class="xubox_title"
      >
        <el-form :model="form1" label-width="80px">
          <el-form-item label="关联订单" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form1.ddmc"
            ></el-input>
          </el-form-item>
          <el-form-item label="回款期次" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form1.beriodName"
            ></el-input>
          </el-form-item>
          <el-form-item label="经办人" class="ttt itemlabel forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 33px"
              v-model="form1.fzr"
            ></el-input>
          </el-form-item>
          <el-form-item label="回款金额" class="itemlabel ccc forms">
            <el-input-number size="mini" style="width: 300px;margin-left: 24px" v-model="form1.paymentMoney" :precision="2" :step="1" :max="form1.blanned_moeny"></el-input-number>
          </el-form-item>
          <el-form-item label="回款日期" class="itemlabel ccc forms">
            <el-date-picker
              v-model="form1.paymentDate"
              size="mini"
              style="width: 300px;margin-left: 24px"
              type="date"
              format="YYYY-MM-DD"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="回款方式" class="itemlabel ccc forms">
            <el-select size="mini"
              style="width: 300px;margin-left: 24px" v-model="form1.recordStaticId" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.recordStaticId"
              :label="item.recordStaticName"
              :value="item.recordStaticId">
            </el-option>
          </el-select>
          </el-form-item>
          <el-form-item label="备注" class="itemlabel bzs forms">
            <el-input
              type="textarea"
              size="mini"
              style="width: 300px; margin-left: 43px"
              v-model="form1.remarks"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible1 = false">取 消</el-button>
            <el-button type="primary" @click="addhkjl"
              >确 定</el-button
            >
          </span>
        </template>
      </el-dialog>
      <el-dialog
        title="新建开票申请"
        v-model="dialogVisiblekp"
        width="26%"
        custom-class="xubox_title"
      >
        <el-form :model="form2" label-width="80px">
          <el-form-item label="申请名称" class="itemlabel ccc forms">
            <el-input
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form2.receiptName"
            ></el-input>
          </el-form-item>
          <el-form-item label="关联订单" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form2.ddmc"
            ></el-input>
          </el-form-item>
          <el-form-item label="关联客户" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form2.ddmc"
            ></el-input>
          </el-form-item>
          <el-form-item label="回款期次" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form2.beriodName"
            ></el-input>
          </el-form-item>
          <el-form-item label="开票金额" class="itemlabel ccc forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form2.receiptMoney"
            ></el-input>
          </el-form-item>
          <el-form-item label="经办人" class="ttt itemlabel forms">
            <el-input
              disabled
              size="mini"
              style="width: 300px; margin-left: 33px"
              v-model="form2.fzr"
            ></el-input>
          </el-form-item>
          <el-form-item label="票据抬头" class="itemlabel ccc forms">
            <el-input
              size="mini"
              style="width: 300px;margin-left: 24px"
              v-model="form2.billTitle"
            ></el-input>
          </el-form-item>
          <el-form-item label="纳税识别号" style="margin-left:11px" class="itemlabel ccc forms">
           <el-input
              size="mini"
              style="width: 300px;margin-left: 13px"
              v-model="form2.payTaxes"
            ></el-input>
          </el-form-item>
          <el-form-item label="备注说明" class="itemlabel ccc forms">
            <el-input
              type="textarea"
              size="mini"
              style="width: 300px; margin-left: 24px"
              v-model="form2.remarks"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisiblekp = false">取 消</el-button>
            <el-button type="primary" @click="kpadd(row)"
              >确 定</el-button
            >
          </span>
        </template>
      </el-dialog>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import { ElMessage } from 'element-plus'
import moment from 'moment'
export default {

  data() {
    return {
      ifpd:null,
      centerDialogVisibleckjl:false,
      dialogVisiblekp:false,
       //分页
      currenPage: 1, //当前页
      max: 0,
      pageSize: 5, //每页几条数据
      title:'',
      cid:null,
      cname:null,
      activeName: "second",
      dialogVisible: false,
      dialogVisible1: false,
      radio:null,
      dialogVisible2:false,
      form: {
        blannedMoeny:0.0,
      },
      options:[],
      form1:{
        
      },
      form2:{},
      cs:{},
      date: "",
      zje: 0,
      yhk:0,
      whk:0,
      ykp:0,
      tableData: [],
      tableData2:[],
      tableData3:[],
      //期次
      qc: "",
    };
  },
  methods: {
    //新增回款期次
    addperiod() {
      this.form.fzr = "白给";
      this.form.ddmc = "测试订单1";
      this.form.beriodName = "第"+(this.tableData.length+1)+"期次";
      
      this.dialogVisible = true;
    },
    handleCurrentChange(){
      this.selectperiod();
      console.log(
        "handleCurrentChange",
        this.currenPage,
        "this.pageSize",
        this.pageSize
      );
    },
    //新增一个回款期次
    quedadd(){
      if(this.form.blannedMoeny > this.zje){
          ElMessage({
            showClose: true,
            message: '计划金额不能大于总金额！',
            type: 'warning'
          });
          return false;
      }
      this.form.saleorderIid = 1;
      this.form.empId = 1;
      const _this = this;
      console.log("from:",this.form)
      this.axios({
          url: "http://localhost:8089/collectionPeriod/addPeriod",
          method: "post",
          data:{period:this.form}
        })
        .then(function (response) {
          ElMessage({
            type:'success',
            message: '新增回款期次成功！'
          });
          _this.selectperiod();
          console.log("res:",response)
        })
        .catch(function (error) {
          console.log(error);
        });
        this.dialogVisible = false
    },
    //查询该订单的所有回款期次
    selectperiod() {
      const _this = this;
      var fy = {
        currenPage: this.currenPage,
        pageSize: this.pageSize,
        id:1
      };
      this.axios({
          url: "http://localhost:8089/collectionPeriod/queryByorder_idas",
          method: "get",
          params:fy
        })
        .then(function (response) {
          console.log("selectperiod:",response)
          _this.tableData = response.data.record.rows;
          _this.max = response.data.record.total;
          _this.qc = "共"+_this.max+"期";
          var index = 1;
          _this.tableData.forEach(item=>{
              item.qx = "第"+index+"期"
              index++;
          })
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    //新建回款记录
    addhk(row){
        this.form1={};
        this.selectperiod();
        this.dialogVisible1 = true;
        this.form1.fzr = "白给";
        this.form1.ddmc = "测试订单1";
        this.form1.beriodName = row.qx+"("+this.qc+")";
        this.form1.collectionId = row.collection_id;
        this.form1.empId = 1;
        if(row.bmount_moeny == null){
          row.bmount_moeny = 0;
        }
        this.form1.blanned_moeny = row.blanned_moeny - row.bmount_moeny;
        this.cs = row;
    },
    //确认新建回款记录
    addhkjl(){
      const _this = this;
      var xx = this.form1.paymentMoney*1 + this.cs.bmount_moeny;
      if(xx > this.cs.blanned_moeny){
          ElMessage({
            showClose: true,
            message: '当前期次的累计最大金额不能大于计划回款金额',
            type: 'warning'
          });
          return false;
      }
      console.log("from1:",this.form1)
      this.axios({
          url: "http://localhost:8089/collectionRecord/addRecord",
          method: "post",
          data:{record:this.form1}
        })
        .then(function (response) {
          ElMessage({
            type:'success',
            message: '新增回款记录成功！'
          });
          _this.selectperiod();
          console.log("res:",response)
        })
        .catch(function (error) {
          console.log(error);
        });
        this.dialogVisible1 = false
    },
    //新建开票申请
    createkp(row){
        if(row.blanned_moeny == row.bmount_moeny){
            this.form2={};
            this.form2.fzr = "白给";
            this.form2.ddmc = "测试订单1";
            this.form2.beriodName = row.qx+"("+this.max+")";
            this.form2.collectionId = row.collection_id;
            this.form2.empId = 1;
            this.form2.sale_order_id = 1;
            this.form2.receiptMoney = row.bmount_moeny;
            this.dialogVisiblekp = true;
        }else{
          ElMessage({
            type:'warning',
            message: '该期次有未回款金额，请先回款完成后开票！'
          });
        }
        
    },
    //时间转换
    dateFormat(row, column) {
				var date = row[column.property];
				if (date == undefined) {
					return ''
				};
				return moment(date).format("YYYY-MM-DD")
			},
    //查询付款方式
    selectfkfs(){
        const _this = this;
        this.axios({
            url: "http://localhost:8089/recordStatic/queryalls",
            method: "get",
        })
        .then(function (response) {
          console.log("response:",response)
          _this.options = response.data.record;
        })
        .catch(function (error) {
          console.log(error);
        });
        console.log("from1:",this.form1)
    },
    ckck(row){
      this.dialogVisible2 = true;
      console.log("ck:rows:",row);
      this.cid = row.collection_id;
      this.cname = row.qx
      this.ifpd = row.apply
    },
    //确认查看记录
    addres(){
        const _this = this;
        if(this.radio == 0){
          this.title = "正在查看当前订单期次的 ["+this.cname+"] 回款记录"
          this.axios({
            url: "http://localhost:8089/collectionPeriod/queryByhuikjl",
            method: "get",
            params:{id:this.cid}
          })
          .then(function (response) {
            _this.tableData2 = response.data.record
          })
          .catch(function (error) {
            console.log(error);
          });
        }else{
          
          this.title = "正在查看当前订单期次的 ["+this.cname+"] 开票记录"
          this.axios({
            url: "http://localhost:8089/receipt/queryreceipt",
            method: "get",
            params:{id:this.cid}
          })
          .then(function (response) {
            console.log("addre开票记录s:res:",response)
            _this.tableData3 = response.data.record
             
            
          })
          .catch(function (error) {
            console.log(error);
          });
        }
        this.centerDialogVisibleckjl = true;
    },
    //开票确认
    kpadd(){
        console.log("from2::",this.form2)
        const _this = this;
        this.axios({
            url: "http://localhost:8089/receipt/addReceipt",
            method: "post",
            data:{receipt:this.form2}
          })
          .then(function (response) {
            console.log("开票确认:",response)
            ElMessage({
              type:'success',
              message: '新建开票申请成功！'
            });
            _this.selectperiod();
            _this.dialogVisiblekp = false;
          })
          .catch(function (error) {
            console.log(error);
          });
    },
    tg(row){
      const _this = this;
       this.$confirm("是否通过？",{
          confirmButtonText: "是",
          cancelButtonText: "否",
          type: "warning",
        })
          .then(_ => {
           this.axios({
            url: "http://localhost:8089/receipt/updatereceiptasone",
            method: "get",
            params:{id:row.receipt_id}
          })
          .then(function (response) {
            ElMessage({
              type:'success',
              message: response.data.record
            });
            _this.selectperiod();
            _this.centerDialogVisibleckjl = false;
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
    bh(row){
      const _this = this;
        this.$confirm('提示：驳回后可重新申请？',"是否确认驳回？",{
          confirmButtonText: "是",
          cancelButtonText: "否",
          type: "warning",
        })
          .then(_ => {
           this.axios({
            url: "http://localhost:8089/receipt/updatereceiptastwo",
            method: "get",
            params:{id:row.receipt_id}
          })
          .then(function (response) {
            ElMessage({
              type:'warning',
              message: response.data.record
            });
            _this.selectperiod();
            _this.addres();
            _this.centerDialogVisibleckjl = false;
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
    del(row){
      console.log("reosssss",row)
       const _this = this;
        this.$confirm('提示：删除后无法恢复',"是否确认删除？",{
          confirmButtonText: "是",
          cancelButtonText: "否",
          type: "warning",
        })
          .then(_ => {
           this.axios({
            url: "http://localhost:8089/collectionRecord/deleterecord",
            method: "get",
            params:{id:row.record_id}
          })
          .then(function (response) {
            _this.addres();
            _this.selectperiod();
            ElMessage({
              type:'warning',
              message: response.data.record
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
    queryByOrderid_all(){
      const _this = this;
      this.axios({
            url: "http://localhost:8089/collectionPeriod/queryByOrderid_all",
            method: "get",
            params:{id:1 || orderid}
          })
          .then(function (response) {
              console.log("resssss:",response)
              _this.zje = response.data.record[0].a
              _this.yhk = response.data.record[0].b
              _this.whk = response.data.record[0].c
              _this.ykp = response.data.record[0].d
          })
            .catch(function (error) {
              console.log(error);
            });
    },
  },
  created(){
    this.selectperiod();
    this.selectfkfs();
    this.queryByOrderid_all();
  }
};
</script>

<style>
.iss {
  display: block;
  float: left;
  width: 19px;
  height: 21px;
  margin-left: 36px;
  margin-top: 3px;
  margin-right: 16px;
  font-size: 28px;
}
.divss {
  display: block;
  float: left;
  width: 111px;
  font-size: 14px;
  height: 60px;
}
.spsp {
  display: block;
  width: 100%;
  line-height: 22px;
}
.divhk {
  width: 892px;
  height: 500px;
  margin-top: 110px;
}
.qwe .cell {
  text-align: center;
}
.sss > .el-dialog__header {
  background-color: aqua;
  border-top-left-radius: 7px;
  border-top-right-radius: 7px;
  background-color: #1890ff;
}
.ccc .el-dialog__title {
  color: #fff;
  font-size: 16px;
  font-weight: 600;
}
.el-dialog__close {
  color: #fff;
  background: transparent;
}
</style>