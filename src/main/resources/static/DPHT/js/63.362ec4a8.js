"use strict";(self["webpackChunkschool_canteen_shop_backstage"]=self["webpackChunkschool_canteen_shop_backstage"]||[]).push([[63],{6063:function(e,t,i){i.r(t),i.d(t,{default:function(){return c}});var a=function(){var e=this,t=e._self._c;return t("div",[t("el-card",{staticClass:"box-card"},[t("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[t("span",[e._v("菜品信息管理")])]),t("div",{staticClass:"search-box"},[t("el-form",{attrs:{inline:!0,model:e.search}},[t("el-form-item",[t("el-input",{staticStyle:{width:"300px"},attrs:{maxlength:"100",placeholder:"请输入内容"},model:{value:e.search.keyWord,callback:function(t){e.$set(e.search,"keyWord",t)},expression:"search.keyWord"}})],1),t("el-form-item",[t("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.searchFood}},[e._v("搜索")])],1),t("el-form-item",[t("el-select",{attrs:{placeholder:"请选择"},on:{change:e.foodTypeChange},model:{value:e.search.foodType,callback:function(t){e.$set(e.search,"foodType",t)},expression:"search.foodType"}},[t("el-option",{attrs:{value:"全部"}}),t("el-option",{attrs:{value:"在售"}}),t("el-option",{attrs:{value:"待售"}})],1)],1)],1),t("el-button",{staticClass:"btn-pub",attrs:{type:"primary",size:"small"},on:{click:e.addFood}},[e._v("菜品上新")])],1),t("el-dialog",{attrs:{title:e.isEdit?"菜品编辑":"菜品上新",visible:e.dialogFormVisible,"before-close":e.handleClose},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[t("el-form",{ref:"FormRef",attrs:{model:e.form,rules:e.foodRuls}},[t("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.form.did,expression:"form.did"}],attrs:{label:"菜品ID","label-width":e.formLabelWidth}},[t("el-input",{attrs:{autocomplete:"off",disabled:""},model:{value:e.form.did,callback:function(t){e.$set(e.form,"did",t)},expression:"form.did"}})],1),t("el-form-item",{attrs:{label:"菜品名称","label-width":e.formLabelWidth,prop:"dname"}},[t("el-input",{attrs:{autocomplete:"off"},model:{value:e.form.dname,callback:function(t){e.$set(e.form,"dname",t)},expression:"form.dname"}})],1),t("el-form-item",{attrs:{label:"菜品价格","label-width":e.formLabelWidth,prop:"dprice"}},[t("el-input",{attrs:{autocomplete:"off"},model:{value:e.form.dprice,callback:function(t){e.$set(e.form,"dprice",t)},expression:"form.dprice"}})],1),t("el-form-item",{directives:[{name:"show",rawName:"v-show",value:""!==e.form.status,expression:"form.status !== ''"}],attrs:{label:"菜品状态","label-width":e.formLabelWidth}},[0==e.form.status?t("el-button",{attrs:{disabled:"",type:"success"}},[e._v(" 在售 ")]):t("el-button",{attrs:{type:"info",disabled:""}},[e._v(" 待售 ")])],1),t("el-form-item",{directives:[{name:"show",rawName:"v-show",value:""!==e.form.dishelevel,expression:"form.dishelevel !== ''"}],attrs:{label:"菜品推荐状态","label-width":e.formLabelWidth}},[0==e.form.dishelevel?t("el-button",{attrs:{type:"primary",title:"点击推荐"},on:{click:e.foodSug}},[e._v(" 待推荐 ")]):1==e.form.dishelevel?t("el-button",{attrs:{type:"info",disabled:""}},[e._v(" 已推荐 ")]):2==e.form.dishelevel?t("el-button",{attrs:{type:"info",disabled:""}},[e._v(" 已上架 ")]):e._e()],1),t("el-form-item",{directives:[{name:"show",rawName:"v-show",value:""!==e.form.swiperlevel,expression:"form.swiperlevel !== ''"}],attrs:{label:"轮播图推荐状态","label-width":e.formLabelWidth}},[0==e.form.swiperlevel?t("el-button",{attrs:{type:"primary",title:"点击推荐"},on:{click:e.swiperSug}},[e._v(" 待推荐 ")]):1==e.form.swiperlevel?t("el-button",{attrs:{type:"info",disabled:""}},[e._v(" 已推荐 ")]):2==e.form.swiperlevel?t("el-button",{attrs:{type:"info",disabled:""}},[e._v(" 已上架 ")]):e._e()],1),t("el-form-item",{attrs:{label:"菜品图片","label-width":e.formLabelWidth,prop:"dimage"}},[this.form.dimage?t("img",{staticClass:"the_img",staticStyle:{height:"100px",width:"100px"},attrs:{src:this.form.dimage,alt:"",title:"点击切换图片"},on:{click:e.chooseImg}}):t("img",{staticStyle:{height:"100px",width:"100px"},attrs:{src:i(634),alt:"",title:"点击切换图片"},on:{click:e.chooseImg}}),t("input",{ref:"iptRef",staticStyle:{display:"none"},attrs:{type:"file",accept:"image/*"},on:{change:e.onFileChange}})]),t("el-form-item",{attrs:{label:"轮播图图片","label-width":e.formLabelWidth}},[this.form.swiper?t("img",{staticClass:"the_img",staticStyle:{height:"140px",width:"320px"},attrs:{src:this.form.swiper,alt:"",title:"点击切换图片"},on:{click:e.chooseSwiperImg}}):t("img",{staticStyle:{height:"140px",width:"320px"},attrs:{src:i(634),alt:"",title:"点击切换图片"},on:{click:e.chooseSwiperImg}}),t("input",{ref:"swiperRef",staticStyle:{display:"none"},attrs:{type:"file",accept:"image/*"},on:{change:e.onSwiperFileChange}})]),t("el-form-item",{attrs:{label:"菜品详情",prop:"detail","label-width":e.formLabelWidth}},[t("el-input",{attrs:{type:"textarea",rows:2,placeholder:"请输入内容"},model:{value:e.form.detail,callback:function(t){e.$set(e.form,"detail",t)},expression:"form.detail"}})],1)],1),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{type:"primary"},on:{click:e.addOrUpdate}},[e._v(" 确 定 ")])],1)],1),t("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:"",stripe:""}},[t("el-table-column",{attrs:{label:"菜品ID",align:"center",prop:"did"}}),t("el-table-column",{attrs:{label:"菜品图片",prop:"foodImg",align:"center"},scopedSlots:e._u([{key:"default",fn:function({row:e}){return[t("img",{staticStyle:{width:"50px",height:"50px"},attrs:{src:e.dimage}})]}}])}),t("el-table-column",{attrs:{label:"菜品名称",prop:"dname",align:"center"}}),t("el-table-column",{attrs:{label:"菜品价格",prop:"dprice",align:"center"}}),t("el-table-column",{attrs:{label:"菜品状态",align:"center"},scopedSlots:e._u([{key:"default",fn:function({row:i}){return[0==i.status?t("el-button",{attrs:{disabled:"",type:"success",size:"mini"}},[e._v(" 在售 ")]):t("el-button",{attrs:{type:"info",size:"mini",disabled:""}},[e._v(" 待售 ")])]}}])}),t("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:e._u([{key:"default",fn:function({row:i}){return[t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.updateFood(i)}}},[e._v("编辑")]),t("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(t){return e.removeFn(i.id)}}},[e._v("删除")])]}}])})],1),t("el-pagination",{attrs:{"current-page":e.search.pagenum,"page-size":e.search.pagesize,layout:"total, prev, pager, next, jumper",total:e.total},on:{"current-change":e.handleCurrentChangeFn,"update:currentPage":function(t){return e.$set(e.search,"pagenum",t)},"update:current-page":function(t){return e.$set(e.search,"pagenum",t)},"update:pageSize":function(t){return e.$set(e.search,"pagesize",t)},"update:page-size":function(t){return e.$set(e.search,"pagesize",t)}}})],1)],1)},s=[],r=i(586),o={name:"food_info_CMD",data(){return{search:{pagenum:1,pagesize:4,foodType:"全部",keyWord:""},foodRuls:{dname:[{required:!0,message:"请输入菜品名称",trigger:"blur"},{min:1,max:10,message:"菜品名的长度应在 3 到 5 个字符",trigger:"blur"}],dprice:[{required:!0,message:"请输入菜品价格",trigger:"blur"},{pattern:/^[0-9]{1,11}$/,message:"请输入合理的菜品价格！",trigger:"blur"}],dimage:[{required:!0,message:"请选菜品图片！",trigger:"change"}],detail:[{min:0,max:100,message:"菜品详情最多100字符",trigger:"blur"}]},isEdit:!1,dialogFormVisible:!1,formLabelWidth:"120px",form:{did:"",dimage:"",dname:"",dprice:"",status:"",swiper:"",detail:"",dishelevel:"",swiperlevel:""},total:0,tableData:[]}},methods:{async handleClose(e){const t=await this.$confirm("此操作将导致填写信息丢失, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).catch((e=>e));if("cancel"===t)return this.$message("已取消!");this.cleanForm(),e()},addFood(){this.cleanForm(),this.dialogFormVisible=!0,this.isEdit=!1},updateFood(e){this.dialogFormVisible=!0,this.isEdit=!0,this.form={...e}},addOrUpdate(){this.$refs.FormRef.validate((async e=>e?this.isEdit?this.updateFoodFn():this.addFoodFn():this.$message.error("表单数据有误，请重新编辑。")))},async addFoodFn(){const{data:e}=await(0,r.eJ)(this.form);if(0!==e.code)return this.$message.error(e.message);this.$message.success("菜品上新成功！"),this.initFoodListFn(),this.dialogFormVisible=!1},async updateFoodFn(){const{data:e}=await(0,r.rb)(this.form);if(0!==e.code)return this.$message.error(e.message);this.$message.success("菜品修改成功！"),this.initFoodListFn(),this.dialogFormVisible=!1},cleanForm(){this.form.did="",this.form.dimage="",this.form.dname="",this.form.dprice="",this.form.status="",this.form.swiper="",this.form.detail="",this.form.dishelevel="",this.form.swiperlevel=""},async initFoodListFn(){const{data:e}=await(0,r.Ps)(this.search);if(0!==e.code)return this.$error("获取菜品列表是失败！");this.total=e.count,this.tableData=e.data},searchFood(){if(""==this.search.keyWord)return this.$message("请输入搜索内容！");this.search.pagenum=1,this.searchFoodFn()},async searchFoodFn(){const{data:e}=await(0,r.qe)(this.search);if(0!=e.code)return this.$message.error("搜索失败！");this.total=e.count,this.tableData=e.data},handleCurrentChangeFn(e){if(this.search.pagenum=e,""!=this.search.keyWord)return this.searchFoodFn;this.initFoodListFn()},foodTypeChange(){if(this.search.pagenum=1,""!=this.search.keyWord)return this.searchFoodFn;this.initFoodListFn()},swiperSug(){if(null==this.form.swiper||""==this.form.swiper)return this.$message.error("当前菜品的轮播图为空，请先添加轮播图后在进行轮播推荐！");this.form.swiperlevel=1},foodSug(){if(1==this.form.status)return this.$message.error("当前菜品已下架，请先上架菜品");this.form.dishelevel=1},async removeFn(e){const t=await this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).catch((e=>e));if("cancel"===t)return;const{data:i}=await deleteArticleAPI(e);if(0!==i.code)return this.$message.error("删除失败!");this.$message.success("删除成功!"),this.resetListFn()},chooseImg(){this.$refs.iptRef.click()},onFileChange(e){const t=e.target.files;if(0===t.length)this.form.dimage="";else{const e=new FileReader;e.readAsDataURL(t[0]),e.onload=e=>{this.form.dimage=e.target.result}}},chooseSwiperImg(){this.$refs.swiperRef.click()},onSwiperFileChange(e){console.log(e);const t=e.target.files;if(0===t.length)this.form.swiper="";else{const e=new FileReader;e.readAsDataURL(t[0]),e.onload=e=>{this.form.swiper=e.target.result}}}},mounted(){this.initFoodListFn()}},l=o,n=i(1001),d=(0,n.Z)(l,a,s,!1,null,"62f8dffa",null),c=d.exports},634:function(e,t,i){e.exports=i.p+"img/defaultLOGO.2c22235d.jpg"}}]);
//# sourceMappingURL=63.362ec4a8.js.map