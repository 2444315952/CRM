<template>
	<div id="app">
		<el-container>
			<el-header v-if="$route.name!== 'Login'"
				style="height: 55px;background-color: #B3C0D1;color: #333;line-height: 60px;">
				<el-dropdown style="float: right;">
					<el-button icon="el-icon-user-solid" circle id="content" style="float: right;margin-top: 6px;">
					</el-button>
					<template #dropdown>
						<el-dropdown-menu>
							<el-dropdown-item>石松炼</el-dropdown-item>
							<el-dropdown-item>退出登录</el-dropdown-item>
						</el-dropdown-menu>
					</template>
				</el-dropdown>

			</el-header>
			<el-container>
				<el-aside v-if="$route.name!== 'Login'" width="200px" style="text-align: center;">
					<el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
						<el-submenu index="1">
							<template #title>
								<span>协作事务</span>
							</template>
							<el-menu-item-group>
								<!-- <el-menu-item index="1-1"><router-link :to="{name:'PurchaseList'}">采购单</router-link></el-menu-item> -->
								<el-menu-item index="1-1">
									<router-link to="/FollowPlan">跟进计划</router-link>
								</el-menu-item>
								<el-menu-item index="1-2">
									<router-link to="/FollowRecord">跟进记录</router-link>
								</el-menu-item>

								<el-menu-item index="1-3">
									<router-link to="/Task">CRM任务</router-link>
								</el-menu-item>
							</el-menu-item-group>
						</el-submenu>
						<el-submenu index="2">
							<template #title>
								<span>市场及客户</span>
							</template>
							<el-menu-item-group>
								<el-menu-item index="2-1">市场活动</el-menu-item>
							</el-menu-item-group>
						</el-submenu>
						<el-submenu index="3">
							<template #title>
								<span>销售过程管理</span>
							</template>
							<el-menu-item-group>
								<el-menu-item index="3-1">销售机会</el-menu-item>
							</el-menu-item-group>
						</el-submenu>
						<el-submenu index="4">
							<template #title>
								<span>回款及开票</span>
							</template>
							<el-menu-item-group>
								<el-menu-item index="4-1">回款期次</el-menu-item>
							</el-menu-item-group>
						</el-submenu>
						<el-submenu index="5">
							<template #title>
								<span>产品</span>
							</template>
							<el-menu-item-group>
								<el-menu-item index="5-1">产品库</el-menu-item>
								<el-menu-item index="5-2">
									<router-link to="/outInStore">出入库办理</router-link>
								</el-menu-item>
								<el-menu-item index="5-3">出入库单</el-menu-item>
								<el-menu-item index="5-4">出入库流水</el-menu-item>
								<el-menu-item index="5-1">
									<router-link to="/product">产品库</router-link>
								</el-menu-item>

							</el-menu-item-group>
						</el-submenu>
					</el-menu>
				</el-aside>
				<el-container>
					<el-main v-if="$route.name!== 'Login'">
						<router-view></router-view>
					</el-main>
					<el-main v-if="$route.name== 'Login'" style="padding-top: 0px;padding-bottom: 0px;">
						<router-view></router-view>
					</el-main>
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
