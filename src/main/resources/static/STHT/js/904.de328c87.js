"use strict";(self["webpackChunkschool_canteen_backstage"]=self["webpackChunkschool_canteen_backstage"]||[]).push([[904],{1904:function(t,e,s){s.r(e),s.d(e,{default:function(){return u}});var i=function(){var t=this,e=t._self._c;return e("el-container",{staticClass:"main-container"},[e("el-header",[e("h1",[t._v("这里是LOGO")]),e("el-menu",{staticClass:"el-menu-top",attrs:{mode:"horizontal","background-color":"#23262E","text-color":"#fff","active-text-color":"#409EFF"}},[e("el-menu-item",{attrs:{index:"2"},on:{click:t.logoutFn}},[e("i",{staticClass:"el-icon-switch-button"}),t._v("退出")])],1)],1),e("el-container",[e("el-aside",{attrs:{width:"200px"}},[e("div",{staticClass:"user-box"},[t.user_pic?e("img",{attrs:{src:t.user_pic,alt:""}}):e("img",{attrs:{src:s(634)}}),e("span",[t._v("欢迎 "+t._s(t.username))])]),e("el-menu",{staticClass:"el-menu-vertical-demo",attrs:{"default-active":t.$route.path,"background-color":"#23262E","text-color":"#fff","active-text-color":"#409EFF","unique-opened":"",router:""}},[e("el-menu-item",{attrs:{index:"/swiperCMD"}},[e("i",{staticClass:"el-icon-picture"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("轮播图管理")])]),e("el-menu-item",{attrs:{index:"/suggesstionCMD"}},[e("i",{staticClass:"el-icon-position"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("菜品推荐管理")])]),e("el-menu-item",{attrs:{index:"/noticeCMD"}},[e("i",{staticClass:"el-icon-s-order"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("公告管理")])]),e("el-menu-item",{attrs:{index:"/roomCMD"}},[e("i",{staticClass:"el-icon-map-location"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("食堂管理")])]),e("el-menu-item",{attrs:{index:"/shopCMD"}},[e("i",{staticClass:"el-icon-food"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("店铺管理")])]),e("el-menu-item",{attrs:{index:"/userCMD"}},[e("i",{staticClass:"el-icon-user"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("用户管理")])])],1)],1),e("el-container",[e("el-main",[e("router-view")],1),e("el-footer",[t._v("© www.4399.com - 带给你快乐的网站")])],1)],1)],1)},o=[],a=(s(7658),s(3822)),l={name:"my-layout",methods:{logoutFn(){this.$confirm("是否确认退出？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.$store.commit("updateToken",""),this.$store.commit("updateUserInfo",{}),this.$router.push("/login")})).catch((t=>t))}},computed:{...(0,a.Se)(["username","user_pic"])}},n=l,r=s(1001),c=(0,r.Z)(n,i,o,!1,null,"39773316",null),u=c.exports},634:function(t,e,s){t.exports=s.p+"img/defaultLOGO.2c22235d.jpg"}}]);
//# sourceMappingURL=904.de328c87.js.map