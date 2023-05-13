"use strict";(self["webpackChunkschool_canteen_backstage"]=self["webpackChunkschool_canteen_backstage"]||[]).push([[551],{8551:function(t,e,a){a.r(e),a.d(e,{default:function(){return c}});var s=function(){var t=this,e=t._self._c;return e("div",[e("div",{staticClass:"header"},[t._v("用户管理")]),e("div",{staticClass:"container"},[e("div",{staticClass:"searchBox"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.search.keyword,expression:"search.keyword"}],staticClass:"searchInput",attrs:{type:"text",placeholder:"请输入用户ID或用户名"},domProps:{value:t.search.keyword},on:{input:function(e){e.target.composing||t.$set(t.search,"keyword",e.target.value)}}}),e("button",{staticClass:"searchBtn",attrs:{type:"button"},on:{click:t.searchUser}},[t._v(" 搜索 ")])]),e("div",{staticClass:"listBox"},[e("div",{staticClass:"list"},[[e("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,border:"",stripe:""}},[e("el-table-column",{attrs:{prop:"uid",label:"用户ID",width:"120",align:"center"}}),e("el-table-column",{attrs:{prop:"uname",label:"用户名",width:"150",align:"center"}}),e("el-table-column",{attrs:{prop:"tel",label:"用户电话",width:"150",align:"center"}}),e("el-table-column",{attrs:{label:"用户类型",width:"120",align:"center"},scopedSlots:t._u([{key:"default",fn:function({row:a}){return["c"==a.flag?e("el-button",{attrs:{type:"primary",size:"mini",disabled:""}},[t._v("普通用户")]):e("el-button",{attrs:{type:"success",size:"mini",disabled:""}},[t._v("店铺用户")])]}}])}),e("el-table-column",{attrs:{label:"用户状态",width:"120",align:"center"},scopedSlots:t._u([{key:"default",fn:function({row:a}){return[0==a.status?e("el-button",{attrs:{type:"primary",size:"mini",disabled:""}},[t._v("正常")]):e("el-button",{attrs:{type:"info",size:"mini",disabled:""}},[t._v("冻结")])]}}])}),e("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function({row:a}){return[e("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){return t.userDeatil(a)}}},[t._v("查看")]),0==a.status?e("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.changeStatus(a.uid,1,a.flag)}}},[t._v("冻结")]):e("el-button",{attrs:{size:"mini",type:"info"},on:{click:function(e){return t.changeStatus(a.uid,0,a.flag)}}},[t._v("解冻")])]}}])})],1)]],2),e("div",{staticClass:"pager"},[e("el-pagination",{attrs:{"current-page":t.search.pagenum,"page-size":t.search.pagesize,layout:"total, prev, pager, next, jumper",total:t.total},on:{"current-change":t.handleCurrentChangeFn,"update:currentPage":function(e){return t.$set(t.search,"pagenum",e)},"update:current-page":function(e){return t.$set(t.search,"pagenum",e)},"update:pageSize":function(e){return t.$set(t.search,"pagesize",e)},"update:page-size":function(e){return t.$set(t.search,"pagesize",e)}}})],1)])]),e("el-dialog",{attrs:{title:"用户详情",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[e("el-form",{attrs:{model:t.form}},[e("el-form-item",{attrs:{label:"用户头像","label-width":t.formLabelWidth}},[t.form.uavatar?e("img",{staticStyle:{width:"100px",height:"100px"},attrs:{src:t.form.uavatar}}):e("img",{staticStyle:{width:"100px",height:"100px"},attrs:{src:a(634)}})]),e("el-form-item",{attrs:{label:"用户ID","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.uid,callback:function(e){t.$set(t.form,"uid",e)},expression:"form.uid"}})],1),e("el-form-item",{attrs:{label:"用户名","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.uname,callback:function(e){t.$set(t.form,"uname",e)},expression:"form.uname"}})],1),e("el-form-item",{attrs:{label:"用户密码","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.pwd,callback:function(e){t.$set(t.form,"pwd",e)},expression:"form.pwd"}})],1),e("el-form-item",{attrs:{label:"用户电话","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.tel,callback:function(e){t.$set(t.form,"tel",e)},expression:"form.tel"}})],1),e("el-form-item",{attrs:{label:"用户类型","label-width":t.formLabelWidth}},["c"==t.form.flag?e("el-button",{attrs:{type:"primary",disabled:""}},[t._v("普通用户")]):e("el-button",{attrs:{type:"success",size:"mini",disabled:""}},[t._v("店铺用户")])],1),e("el-form-item",{attrs:{label:"用户状态","label-width":t.formLabelWidth}},[0==t.form.status?e("el-button",{attrs:{type:"primary",disabled:""}},[t._v("正常")]):e("el-button",{attrs:{type:"success",disabled:""}},[t._v("冻结")])],1)],1)],1)],1)},i=[],r=a(586),l={name:"userCMD",data(){return{search:{pagenum:1,pagesize:6,keyword:""},total:0,dialogFormVisible:!1,formLabelWidth:"120px",form:{uid:"",uname:"",tel:"",flag:"",status:"",uavatar:"",pwd:""},tableData:[{uid:"20200001",uname:"第一号用户",tel:"19184562524",flag:"c",status:0,uavatar:"",pwd:"123456789"}]}},methods:{async initUserListFn(){const{data:t}=await(0,r.gl)(this.search);if(0!=t.code)return this.$message.error("获取用户列表失败！");this.tableData=t.data,this.total=t.count},handleCurrentChangeFn(t){this.search.pagenum=t,""!=this.search.keyword&&this.searchUserAction(),this.initUserListFn()},searchUser(){if(""==this.search.keyword)return this.$message("请输入关键词"),this.initUserListFn();this.search.pagenum=1,this.searchUserFn()},async searchUserFn(){const{data:t}=await(0,r.K6)(this.search);if(0!=t.code)return this.$message.error("搜索失败！");this.tableData=t.data,this.total=t.count},userDeatil(t){this.dialogFormVisible=!0,this.form={...t},console.log(t),console.log(this.form)},async changeShopStatus(t){const{data:e}=await(0,r.lv)(t);if(0!=e.code)return this.$message.error("店铺信息修改失败！")},async changeStatus(t,e,a){const{data:s}=await(0,r.PQ)({uid:t,status:e});if(0!=s.code)return this.$message.error("用户状态切换失败！");if("b"==a){let t=s.info;t={...t,status:e},this.changeShopStatus(t)}this.search.pagenum=1,this.initUserListFn()}},mounted(){this.initUserListFn()}},n=l,o=a(1001),u=(0,o.Z)(n,s,i,!1,null,"2ec154ae",null),c=u.exports},634:function(t,e,a){t.exports=a.p+"img/defaultLOGO.2c22235d.jpg"}}]);
//# sourceMappingURL=551.b8e707a6.js.map