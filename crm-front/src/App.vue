<template>
  <div id="app">
	<el-container>
		  <el-header v-if="$route.name!== 'Login'" style="height: 55px;background-color: #B3C0D1;color: #333;line-height: 60px;" >
			<el-dropdown style="float: right;">
				<el-button icon="el-icon-user-solid" circle id="content" style="float: right;margin-top: 6px;"></el-button> 
			  <template #dropdown>
			    <el-dropdown-menu>
			      <el-dropdown-item>{{$store.getters.empName}}</el-dropdown-item>
			      <el-dropdown-item><router-link :to="{name:'Login'}">退出登录</router-link></el-dropdown-item>
			    </el-dropdown-menu>
			  </template>
			</el-dropdown> 
			  
		  </el-header>
		  <el-container>
		  	<el-aside v-if="$route.name!== 'Login'" width="200px" style="text-align: center;">
		  		 <el-menu
		  		  default-active="2"
		  		  class="el-menu-vertical-demo"
		  		  @open="handleOpen"
		  		  @close="handleClose">
		  		  <el-submenu index="1">
		  			<template #title>
		  			  <span>协作事务</span>
		  			</template>
		  			<el-menu-item-group>
		  				<el-menu-item index="1-1"><router-link :to="{name:'FollowPlan'}">跟进计划</router-link></el-menu-item>
		  				<el-menu-item index="1-2"><router-link :to="{name:'FollowRecord'}">跟进记录</router-link></el-menu-item>
		  				<el-menu-item index="1-3"><router-link :to="{name:'Task'}">CRM任务</router-link></el-menu-item>
					</el-menu-item-group>
		  		  </el-submenu>
		  		  <el-submenu index="2">
		  			<template #title>
		  			  <span>市场及客户</span>
		  			</template>
		  			<el-menu-item-group>	
						<el-menu-item index="2-1"><router-link :to="{name:'Activity'}">市场活动</router-link></el-menu-item>
						<el-menu-item index="2-2"><router-link :to="{name:'Clue'}">线索</router-link></el-menu-item>
						<el-menu-item index="2-3"><router-link :to="{name:'PublicClue'}">线索公海池</router-link></el-menu-item>
						<el-menu-item index="2-4"><router-link :to="{name:'Customer'}">客户</router-link></el-menu-item>
						<el-menu-item index="2-5"><router-link :to="{name:'PublicCustomer'}">客户公海池</router-link></el-menu-item>
						<el-menu-item index="2-6"><router-link :to="{name:'Contacts'}">联系人</router-link></el-menu-item>
		  			</el-menu-item-group>
		  		  </el-submenu>
		  		  <el-submenu index="3">
		  			<template #title>
		  			  <span>销售过程管理</span>
		  			</template>
		  			<el-menu-item-group>	
		  				<el-menu-item index="3-1"><router-link :to="{name:'SaleLeadList'}">销售机会</router-link></el-menu-item>
						<el-menu-item index="3-2"><router-link :to="{name:'SaleOrderList'}">销售订单</router-link></el-menu-item>
						<el-menu-item index="3-3"><router-link :to="{name:'SaleContract'}">销售合同</router-link></el-menu-item>
		  			</el-menu-item-group>
		  		  </el-submenu>
		  		  <el-submenu index="4">
		  			<template #title>
		  			  <span>回款及开票</span>
		  			</template>
		  			<el-menu-item-group>	
		  				<el-menu-item index="4-1">
							<router-link to="/test3">订单汇总</router-link>
						</el-menu-item>
						<el-menu-item index="4-2">
							<router-link to="/test2">开票查询</router-link>
						</el-menu-item>
		  			</el-menu-item-group>
		  		  </el-submenu>
		  		  <el-submenu index="5">
		  			<template #title>
		  			  <span>产品</span>
		  			</template>
		  			<el-menu-item-group>
					  	<el-menu-item index="5-1">
					    	<router-link to="/product">产品库</router-link>
						</el-menu-item>
						<el-menu-item index="5-2">
							  <router-link to="/outInStore">出入库办理</router-link>
						</el-menu-item>
						<el-menu-item index="5-3">
							<router-link to="/outInStoreBill">出入库单</router-link>
						</el-menu-item>
						<el-menu-item index="5-4">
							<router-link to="/outInStoreWater">出入库流水</router-link>
						</el-menu-item>
		  			</el-menu-item-group>
		  		  </el-submenu>
		  		</el-menu>
		  	</el-aside>
		  	<el-container>
		  	  <el-main v-if="$route.name!== 'Login'"><router-view></router-view></el-main>
		  	  <el-main v-if="$route.name== 'Login'" style="padding-top: 0px;padding-bottom: 0px;"><router-view></router-view></el-main>
		  	</el-container>
		  </el-container>
	</el-container>
  </div>
 
</template>

<script>

export default {
  name: 'App'
}
</script>
