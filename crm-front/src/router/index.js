import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLead from '../components/sale/SaleLead.vue'
<<<<<<< HEAD
import outInStore from '../components/produce/outInStore.vue'
=======
import Product from '../components/product/Product.vue'
>>>>>>> 09d3c67beb44e15228debe9ac95eba24099e6028

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
	}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router
