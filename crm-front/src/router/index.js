import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import outInStore from '../components/produce/outInStore.vue'
import Product from '../components/product/Product.vue'
import FollowPlan from '../components/followall/FollowPlan.vue'
import FollowRecord from '../components/followall/FollowRecord.vue'
import Task from '../components/followall/Task.vue'
const routes = [{
		path: '/',
		redirect: '/Login'
	},
	{
		path: '/Task',
		name: "Task",
		component: Task
	},
	{
		path: '/FollowRecord',
		name: "FollowRecord",
		component: FollowRecord
	},
	{
		path: '/FollowPlan',
		name: "FollowPlan",
		component: FollowPlan
	},
	{
		path: '/Login',
		name: "Login",
		component: Login
	},
	{
		path: '/SaleLead',
		name: "SaleLead",
		component: SaleLead
	},{
		path: '/outInStore',
		name: "outInStore",
		component: outInStore
	},
	{
		path:'/product',
		name:"Product",
		component:Product
	}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router
