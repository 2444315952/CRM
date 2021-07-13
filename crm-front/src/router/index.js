import {
	createRouter,
	createWebHistory
} from 'vue-router'

import Login from '../components/Login.vue'
import SaleLeadList from '../components/sale/SaleLeadList.vue'
import SaleLead from '../components/sale/SaleLead.vue'
import outInStore from '../components/produce/outInStore.vue'
import product from '../components/product/Product.vue'
import outInStoreBill from '../components/produce/outInStoreBill.vue'
import outInStoreWater from '../components/produce/outInStoreWater.vue'
import test1 from '../components/collection/test1.vue'
import test2 from '../components/collection/test2.vue'
import test3 from '../components/collection/test3.vue'
import SaleOrderList from '../components/sale/SaleOrderList.vue'
import SaleOrder from '../components/sale/SaleOrder.vue'
import SaleContract from '../components/sale/SaleContract.vue'
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
		path: '/SaleLeadList',
		name: "SaleLeadList",
		component: SaleLeadList
	},
	{
		path: '/SaleLead/:leadId?',
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
	},{
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
