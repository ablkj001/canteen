"use strict";(self["webpackChunkschool_canteen_backstage"]=self["webpackChunkschool_canteen_backstage"]||[]).push([[239],{4239:function(e,s,o){o.r(s),o.d(s,{default:function(){return u}});var r=function(){var e=this,s=e._self._c;return s("div",{staticClass:"login-container"},[s("div",{staticClass:"login-box"},[s("div",{staticClass:"title-box"},[e._v("杏仁食堂后台管理系统")]),s("el-form",{ref:"loginForm",attrs:{model:e.loginForm,rules:e.loginRules}},[s("el-form-item",{attrs:{prop:"username"}},[s("el-input",{attrs:{placeholder:"请输入用户名",maxlength:"10",minlength:"1"},model:{value:e.loginForm.username,callback:function(s){e.$set(e.loginForm,"username",s)},expression:"loginForm.username"}})],1),s("el-form-item",{attrs:{prop:"password"}},[s("el-input",{attrs:{type:"password",placeholder:"请输入密码"},model:{value:e.loginForm.password,callback:function(s){e.$set(e.loginForm,"password",s)},expression:"loginForm.password"}})],1),s("el-form-item",[s("el-button",{staticClass:"btn-login",attrs:{type:"primary"},on:{click:e.loginFn}},[e._v("登录")])],1)],1)],1)])},t=[],a=(o(7658),o(586)),l=o(3822),n={name:"my-login",data(){return{loginForm:{username:"",password:"",flag:"a"},loginRules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"},{pattern:/^[a-zA-Z0-9]{1,10}$/,message:"用户名必须是1-10的字母数字",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{pattern:/^\S{6,15}$/,message:"密码必须是6-15的非空字符",trigger:"blur"}]}}},methods:{...(0,l.OI)(["updateToken"]),loginFn(){console.log(this.loginForm),this.$refs.loginForm.validate((async e=>{if(e){console.log(this.loginForm);const{data:e}=await(0,a.UO)(this.loginForm);if(console.log(this.loginForm),0!==e.code)return this.$message.error(e.message);this.$message.success(e.message),this.updateToken(e.token),this.$router.push("/")}else this.$message.error("登录信息有误，请重新编辑。")}))}}},i=n,g=o(1001),m=(0,g.Z)(i,r,t,!1,null,"a970f9f4",null),u=m.exports}}]);
//# sourceMappingURL=239.f1cb04ed.js.map