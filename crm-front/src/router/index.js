import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import outInStore from '../components/produce/outInStore.vue'
import product from '../components/product/Product.vue'
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
	}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router
