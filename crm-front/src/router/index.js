import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import Activity from '../components/MarketCustomers/Activity.vue'
import Clue from '../components/MarketCustomers/Clue.vue'
import PublicClue from '../components/MarketCustomers/PublicClue.vue'
import PublicCustomer from '../components/MarketCustomers/PublicCustomer.vue'
import Customer from '../components/MarketCustomers/Customer.vue'
import Contacts from '../components/MarketCustomers/Contacts.vue'
import outInStore from '../components/produce/outInStore.vue'
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
		// component: SaleLead,
		// component: Activity,
		// component:Clue,
		// component: Customer,
		// component: PublicClue,
		component: PublicCustomer,
		// component: Contacts,
		// component: SaleLead
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
