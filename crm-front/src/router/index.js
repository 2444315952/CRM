import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import outInStore from '../components/produce/outInStore.vue'
import outInStoreBill from '../components/produce/outInStoreBill.vue'
import outInStoreWater from '../components/produce/outInStoreWater.vue'
import Product from '../components/product/Product.vue'


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
	},{
		path: '/outInStoreBill',
		name: "outInStoreBill",
		component: outInStoreBill
	},{
		path: '/outInStoreWater',
		name: "outInStoreWater",
		component: outInStoreWater
	}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router
