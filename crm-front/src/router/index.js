import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLeadList from '../components/sale/SaleLeadList.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import outInStore from '../components/produce/outInStore.vue'
import product from '../components/product/Product.vue'
import SaleOrderList from '../components/sale/SaleOrderList.vue'
import SaleOrder from '../components/sale/SaleOrder.vue'
import SaleContract from '../components/sale/SaleContract.vue'

const routes = [{
		path: '/',
		redirect: '/Login'
	},
	{
		path: '/Login',
		name: "Login",
		component: Login
	},
	{
		path: '/SaleLeadList',
		name: "SaleLeadList",
		component: SaleLeadList
	},
	{
		path: '/SaleLead/:leadId?',
		name: "SaleLead",
		component: SaleLead
	},{
		path: '/outInStore',
		name: "outInStore",
		component: outInStore
	},
	{
		path:'/product',
		name:"product",
		component:product
		path: '/SaleOrderList',
		name: "SaleOrderList",
		component: SaleOrderList
	},{
		path: '/SaleOrder',
		name: "SaleOrder",
		component: SaleOrder
	},{
		path: '/SaleContract',
		name: "SaleContract",
		component: SaleContract
	}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router
