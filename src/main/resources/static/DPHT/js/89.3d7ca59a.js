"use strict";(self["webpackChunkschool_canteen_shop_backstage"]=self["webpackChunkschool_canteen_shop_backstage"]||[]).push([[89],{5089:function(t,e,o){o.r(e),o.d(e,{default:function(){return f}});var a=function(){var t=this,e=t._self._c;return e("el-card",{staticClass:"box-card"},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",[t._v("店铺信息")])]),e("el-form",{attrs:{model:t.form}},[e("el-form-item",{attrs:{label:"店铺ID","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.sid,callback:function(e){t.$set(t.form,"sid",e)},expression:"form.sid"}})],1),e("el-form-item",{attrs:{label:"店铺名称",prop:"sname","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.sname,callback:function(e){t.$set(t.form,"sname",e)},expression:"form.sname"}})],1),e("el-form-item",{attrs:{label:"所属食堂","label-width":t.formLabelWidth}},[e("el-button",{attrs:{type:"primary",disabled:""}},[t._v(t._s(t.form.roomName))])],1),e("el-form-item",{attrs:{label:"店铺位置",prop:"location","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.location,callback:function(e){t.$set(t.form,"location",e)},expression:"form.location"}})],1),e("el-form-item",{attrs:{label:"管理员账号","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.manager,callback:function(e){t.$set(t.form,"manager",e)},expression:"form.manager"}})],1),e("el-form-item",{attrs:{label:"店铺电话",prop:"tel","label-width":t.formLabelWidth}},[e("el-input",{attrs:{disabled:"",autocomplete:"off"},model:{value:t.form.tel,callback:function(e){t.$set(t.form,"tel",e)},expression:"form.tel"}})],1),e("el-form-item",{attrs:{label:"店铺状态","label-width":t.formLabelWidth}},[0==t.form.status?e("el-button",{attrs:{type:"success",title:"点击停业整顿"},on:{click:function(e){return t.updateShopFn(1)}}},[t._v("正在营业")]):e("el-button",{attrs:{type:"info",title:"点击开始营业"},on:{click:function(e){return t.updateShopFn(0)}}},[t._v("停业整顿")])],1)],1)],1)},r=[],s=(o(7658),o(586)),l={name:"ShopInfo",data(){return{form:{},roomList:[{rid:1,rname:"一食堂"},{rid:2,rname:"二食堂"},{rid:3,rname:"三食堂"}],formLabelWidth:"120px"}},methods:{async getRoomList(){const{data:t}=await(0,s.d2)();if(0!==t.code)return this.$message.error("获取食堂列表失败！");this.roomList=t.data,this.form=this.$store.state.shopInfo,this.roomList.forEach((t=>{t.rid==this.form.rid&&(this.form.roomName=t.rname)}))},async updateShopFn(t){const{data:e}=await(0,s.lv)({...this.form,status:t});if(0!=e.code)return this.$message.error("店铺状态修改失败！");this.$message.success("店铺状态修改成功！"),this.$store.dispatch("initShopInfo"),this.getRoomList(),this.$router.push("/serve_or_not")}},mounted(){this.getRoomList()}},i=l,m=o(1001),n=(0,m.Z)(i,a,r,!1,null,"832bf198",null),f=n.exports}}]);
//# sourceMappingURL=89.3d7ca59a.js.map