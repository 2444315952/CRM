import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import outInStore from '../components/produce/outInStore.vue'
import product from '../components/product/Product.vue'
import outInStoreBill from '../components/produce/outInStoreBill.vue'
import outInStoreWater from '../components/produce/outInStoreWater.vue'
import test1 from '../components/collection/test1.vue'
import test2 from '../components/collection/test2.vue'
import test3 from '../components/collection/test3.vue'
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
		name:"product",
		component:product
	},{
		path: '/outInStoreBill',
		name: "outInStoreBill",
		component: outInStoreBill
	},{
		path: '/outInStoreWater',
		name: "outInStoreWater",
		component: outInStoreWater
	},{
		path: '/test1',
		name: "test1",
		component: test1
	},{
		path: '/test2',
		name: "test2",
		component: test2
	},{
		path: '/test3',
		name: "test3",
		component: test3
	},
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router
