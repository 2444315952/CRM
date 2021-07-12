import {createStore} from 'vuex'
const store=createStore({
	state:{
		userInfo:{
			empId:"",
			empName:"",
			empPhone:""
		}
	},
	getters:{
		empId:(state)=>{
			return state.userInfo.empId
		},
		empName:(state)=>{
			return state.userInfo.empName
		},
		empPhone:(state)=>{
			return state.userInfo.empPhone
		}
	},
	mutations:{
		updateUserInfo(state,user){
			if(user==null){
				sessionStorage.removeItem('state')
				state.userInfo.empId=null
				state.userInfo.empName=null
				state.userInfo.empPhone=null
			}else{
				state.userInfo.empId=user.empId
				state.userInfo.empName=user.empName
				state.userInfo.empPhone=user.empPhone
				sessionStorage.setItem('state', JSON.stringify(state))
			}
			
		}
	}
})
export default store