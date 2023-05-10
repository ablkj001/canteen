"use strict";(self["webpackChunkschool_canteen_backstage"]=self["webpackChunkschool_canteen_backstage"]||[]).push([[953],{5953:function(t,e,a){a.r(e),a.d(e,{default:function(){return m}});var s=function(){var t=this,e=t._self._c;return e("div",[e("div",{staticClass:"header"},[t._v("食堂管理")]),e("div",{staticClass:"container"},[e("div",{staticClass:"searchBox"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.searchKey,expression:"searchKey"}],staticClass:"searchInput",attrs:{type:"text",placeholder:"请输入查找内容"},domProps:{value:t.searchKey},on:{input:function(e){e.target.composing||(t.searchKey=e.target.value)}}}),e("button",{staticClass:"searchBtn",attrs:{type:"button"},on:{click:t.searchRoomListFn}},[t._v(" 搜索 ")]),e("button",{staticClass:"addBtn",attrs:{type:"button"},on:{click:t.addRoom}},[t._v("添加")])]),e("div",{staticClass:"listBox"},[e("div",{staticClass:"list"},[[e("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,border:"",stripe:""}},[e("el-table-column",{attrs:{prop:"rid",label:"食堂ID",width:"150",align:"center"}}),e("el-table-column",{attrs:{prop:"rname",label:"食堂名称",width:"150",align:"center"}}),e("el-table-column",{attrs:{prop:"tel",label:"联系电话",width:"150",align:"center"}}),e("el-table-column",{attrs:{prop:"date",label:"开设时间",width:"150",align:"center"}}),e("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function({row:a}){return[e("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){return t.updateRoom(a)}}},[t._v("编辑")]),e("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.deleteRoom(a)}}},[t._v("解散")])]}}])})],1)]],2),e("div",{staticClass:"pager"},[e("el-pagination",{attrs:{"current-page":t.search.pagenum,"page-size":t.search.pagesize,layout:"total, prev, pager, next, jumper",total:t.total},on:{"current-change":t.handleCurrentChangeFn,"update:currentPage":function(e){return t.$set(t.search,"pagenum",e)},"update:current-page":function(e){return t.$set(t.search,"pagenum",e)},"update:pageSize":function(e){return t.$set(t.search,"pagesize",e)},"update:page-size":function(e){return t.$set(t.search,"pagesize",e)}}})],1)])]),e("el-dialog",{attrs:{title:t.isEdit?"编辑食堂":"添加食堂",visible:t.dialogFormVisible,"before-close":t.handleClose},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[e("el-form",{ref:"roomREF",attrs:{model:t.form,rules:t.roomRuls}},[e("el-form-item",{directives:[{name:"show",rawName:"v-show",value:t.form.rid,expression:"form.rid"}],attrs:{label:"食堂ID","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.rid,callback:function(e){t.$set(t.form,"rid",e)},expression:"form.rid"}})],1),e("el-form-item",{attrs:{label:"食堂名称",prop:"rname","label-width":t.formLabelWidth}},[e("el-input",{attrs:{autocomplete:"off"},model:{value:t.form.rname,callback:function(e){t.$set(t.form,"rname",e)},expression:"form.rname"}})],1),e("el-form-item",{attrs:{label:"联系电话",prop:"tel","label-width":t.formLabelWidth}},[e("el-input",{attrs:{autocomplete:"off"},model:{value:t.form.tel,callback:function(e){t.$set(t.form,"tel",e)},expression:"form.tel"}})],1),e("el-form-item",{directives:[{name:"show",rawName:"v-show",value:t.form.date,expression:"form.date"}],attrs:{label:"开设时间","label-width":t.formLabelWidth}},[e("el-input",{attrs:{autocomplete:"off",disabled:""},model:{value:t.form.date,callback:function(e){t.$set(t.form,"date",e)},expression:"form.date"}})],1)],1),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")]),e("el-button",{attrs:{type:"primary"},on:{click:t.addOrUpdate}},[t._v("确 定")])],1)],1)],1)},i=[],r=a(586),o={name:"shopCMD",data(){return{search:{pagenum:1,pagesize:6},total:0,searchKey:"",isEdit:!1,dialogFormVisible:!1,formLabelWidth:"120px",form:{rid:"",rname:"",tel:"",date:""},tableData:[],roomRuls:{rname:[{required:!0,message:"请输入食堂名称",trigger:"blur"},{min:3,max:5,message:"菜品名的长度应在 3 到 5 个字符",trigger:"blur"}],tel:[{required:!0,message:"请输入联系方式",trigger:"blur"},{pattern:/^[0-9]{11}$/,message:"请输入正确格式的联系方式！",trigger:"blur"}]}}},methods:{async handleClose(t){const e=await this.$confirm("此操作将导致填写信息丢失, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).catch((t=>t));if("cancel"===e)return this.$message("已取消!");this.cleanForm(),t()},async initRoomListFn(){const{data:t}=await(0,r.Du)(this.search);if(0!=t.code)return this.$message.error("获取食堂列表失败！");this.tableData=t.data,this.total=t.count},async searchRoomListFn(){if(""==this.searchKey)return this.$message("请输入搜索内容！"),this.initRoomListFn();const{data:t}=await(0,r.BV)({pagenum:1,keyword:this.searchKey});console.log(t),0!=t.code?(this.$message.error("搜索失败！"),this.initRoomListFn()):(this.tableData=t.data,this.total=this.count)},async deleteRoom(t){const e=await this.$confirm("若确定解散，则将遍历删除该食堂下的所有店铺，是否确认解散？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).catch((t=>t));if("cancel"===e)return;const{data:a}=await(0,r.Yp)({rid:t.rid,status:1});if(0!=a.code)return this.$message.error("删除食堂失败");this.$message.success("食堂删除成功！"),this.initRoomListFn()},addRoom(){this.cleanForm(),this.dialogFormVisible=!0,this.isEdit=!1},updateRoom(t){this.dialogFormVisible=!0,this.isEdit=!0,this.form={...t}},async addRoomFn(){const{data:t}=await(0,r.gX)(this.form);if(console.log(t),0!=t.code)return this.$message.error("添加食堂失败！");this.$message.success("添加成功！"),this.initRoomListFn(),this.dialogFormVisible=!1},async updateRoomFn(){const{data:t}=await(0,r.Uu)(this.form);if(console.log(t),0!=t.code)return this.$message.error("食堂信息修改失败！");this.$message.success("食堂信息修改成功！"),this.initRoomListFn(),this.dialogFormVisible=!1},addOrUpdate(){this.$refs.roomREF.validate((async t=>t?this.isEdit?this.updateRoomFn():this.addRoomFn():this.$message.error("表单数据有误，请重新编辑。")))},cleanForm(){this.form.rid="",this.form.rname="",this.form.tel="",this.form.date=""},handleCurrentChangeFn(t){this.search.pagenum=t,this.initRoomListFn()}},mounted(){this.initRoomListFn()}},n=o,l=a(1001),c=(0,l.Z)(n,s,i,!1,null,"77061655",null),m=c.exports}}]);
//# sourceMappingURL=953.9b491d1f.js.map