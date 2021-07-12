<template>
	<div class="Login min-h-screen bg-gray-100 text-gray-900 flex justify-center dlbox">
		<div class="max-w-screen-xl m-0 sm:m-20 bg-white shadow sm:rounded-lg flex justify-center flex-1">
			<div class="lg:w-1/2 xl:w-5/12 p-6 sm:p-12">
				<div class="mt-12 flex flex-col items-center">
					<h1 class="text-2xl xl:text-3xl font-extrabold">用户登录</h1>
					<div class="w-full flex-1 mt-8">

						<div class="flex flex-col items-center">
							<button
								class="w-full max-w-xs font-bold shadow-sm rounded-lg py-3 bg-indigo-100 text-gray-800 flex items-center justify-center ease-in-out focus:outline-none hover:shadow focus:shadow-sm focus:shadow-outline">
								<div class="weixin" style=""></div>
								<span class="ml-4">使用微信登录</span>
							</button>
							<button
								class="w-full max-w-xs font-bold shadow-sm rounded-lg py-3 bg-indigo-100 text-gray-800 flex items-center justify-center ease-in-out focus:outline-none hover:shadow focus:shadow-sm focus:shadow-outline mt-5">
								<div class="weibo"></div>
								<span class="ml-4">使用微博登录</span>
							</button>
						</div>

						<div class="my-12 border-b text-center">
							<div
								class="leading-none px-2 inline-block text-sm text-gray-600 tracking-wide font-medium bg-white transform translate-y-1/2">
								或者使用用户名密码登录</div>
						</div>

						<div class="mx-auto max-w-xs">
							<input
								class="w-full px-8 py-4 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-sm focus:outline-none focus:border-gray-400 focus:bg-white"
								type="email" placeholder="用户名" v-model="form.username">
								type="email" placeholder="用户名" v-model="form.empName">
							<input
								class="w-full px-8 py-4 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-sm focus:outline-none focus:border-gray-400 focus:bg-white mt-5"
								type="password" placeholder="密码" v-model="form.password">
								type="password" placeholder="密码" v-model="form.empPwd">
							<button @click="onSubmit()"
								class="mt-5 tracking-wide font-semibold bg-indigo-500 text-gray-100 w-full py-4 rounded-lg hover:bg-indigo-700 ease-in-out flex items-center justify-center focus:shadow-outline focus:outline-none">
								<span class="ml-3">登 录</span>
							</button>
							<p class="mt-6 text-xs text-gray-600 text-center">我同意并遵守服务协议</p>
						</div>
					</div>
				</div>
			</div>
			<div class="flex-1 bg-indigo-100 text-center hidden lg:flex">
				<div class="m-12 xl:m-16 w-full bg-contain bg-center bg-no-repeat login-back-img"></div>
			</div>
		</div>
	</div>
</template>
<script>
	import stylesheet from '../assets/js/tailwind.min.css'

	export default {
		name: "Login",
		data() {
			return {
				form: {
					username: "",
					password: ""
					empName: "",
					empPwd: ""
				}
			};
		},
		methods: {
			onSubmit() {
				this.$router.push({
					name: 'SaleLead'
				})
				
				//const _this = this;

				/* this.axios({
				this.axios({
					url: 'http://localhost:8089/login',
					method: 'post',
					data: this.form
				}).then(res => {
					console.log(res);
					
					if (res.data.success) {
						console.log("登录成功")
						this.$store.commit("updateUserInfo", res.data.data)
						this.$store.commit("updateUserInfo", res.data.record)
						this.$router.push({
							name: 'PurchaseList'
							name: 'SaleLead'
						})
					} else {
						this.$message({
							type: 'error',
							message: "用户名或密码错误"
						})
					}
				}).catch(err => {

				}) */
				})
			}
		}
	};
</script>

<style>
	.dlbox .weixin,
	.dlbox .weibo {
		display: inline-block;
		width: 32px;
		height: 32px;
		background-size: cover;
	}

	.dlbox .weixin {
		background-image: url(../assets/image/weixin.png);
	}

	.dlbox .weibo {
		background-image: url(../assets/image/weibo.png);
	}

	.login-back-img {
		background-image: url(../assets/image/dlbox.svg);
	}

	.bg-indigo-100 {
		background-color: #ebf4ff;
	}

	.border-gray-200 {
		border-color: #edf2f7;
	}

	.bg-gray-100 {
		background-color: #f7fafc;
	}

	.bg-indigo-500 {
		background-color: #667eea;
	}
</style> -->
