import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import Activity from '../components/MarketCustomers/Activity.vue'

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
		// component: SaleLead,
		component: Activity
	}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router
