"use strict";(self["webpackChunkschool_canteen_shop_backstage"]=self["webpackChunkschool_canteen_shop_backstage"]||[]).push([[459],{8459:function(t,e,s){s.r(e),s.d(e,{default:function(){return u}});var i=function(){var t=this,e=t._self._c;return e("el-container",{staticClass:"main-container"},[e("el-header",[e("h1",[t._v("这里是LOGO")]),e("el-menu",{staticClass:"el-menu-top",attrs:{mode:"horizontal","background-color":"#23262E","text-color":"#fff","active-text-color":"#409EFF"}},[e("el-menu-item",{attrs:{index:"2"},on:{click:t.logoutFn}},[e("i",{staticClass:"el-icon-switch-button"}),t._v("退出")])],1)],1),e("el-container",[e("el-aside",{attrs:{width:"200px"}},[e("div",{staticClass:"user-box"},[t.user_pic?e("img",{attrs:{src:t.user_pic,alt:""}}):e("img",{attrs:{src:s(634)}}),e("span",[t._v("欢迎 "+t._s(t.username))])]),e("el-menu",{staticClass:"el-menu-vertical-demo",attrs:{"default-active":t.$route.path,"background-color":"#23262E","text-color":"#fff","active-text-color":"#409EFF","unique-opened":"",router:""}},[e("el-menu-item",{attrs:{index:"/serve_or_not"}},[e("i",{staticClass:"el-icon-sort"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("菜品上下架")])]),e("el-menu-item",{attrs:{index:"/food_info_CMD"}},[e("i",{staticClass:"el-icon-food"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("菜品信息管理")])]),e("el-menu-item",{attrs:{index:"/shop_order_CMD"}},[e("i",{staticClass:"el-icon-dish"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("商家订单管理")])]),e("el-menu-item",{attrs:{index:"/shop_comments_CMD"}},[e("i",{staticClass:"el-icon-chat-dot-square"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("商家评论管理")])]),e("el-menu-item",{attrs:{index:"/shopInfo"}},[e("i",{staticClass:"el-icon-s-shop"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("店铺信息")])]),e("el-submenu",{attrs:{index:"user"}},[e("template",{slot:"title"},[e("i",{staticClass:"el-icon-user"}),e("span",[t._v("用户中心")])]),e("el-menu-item-group",[e("el-menu-item",{attrs:{index:"/user-info"}},[e("i",{staticClass:"el-icon-edit"}),e("span",[t._v("基本资料")])]),e("el-menu-item",{attrs:{index:"/user-avatar"}},[e("i",{staticClass:"el-icon-picture-outline-round"}),e("span",[t._v("更换头像")])]),e("el-menu-item",{attrs:{index:"/user-pwd"}},[e("i",{staticClass:"el-icon-key"}),e("span",[t._v("重置密码")])])],1)],2)],1)],1),e("el-container",[e("el-main",[e("router-view")],1),e("el-footer",[t._v("© www.4399.com - 带给你快乐的网站")])],1)],1)],1)},o=[],a=(s(7658),s(3822)),n={name:"my-layout",methods:{logoutFn(){this.$confirm("是否确认退出？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.$store.commit("updateToken",""),this.$store.commit("updateUserInfo",{}),this.$router.push("/login")})).catch((t=>t))}},computed:{...(0,a.Se)(["username","user_pic"])}},l=n,r=s(1001),c=(0,r.Z)(l,i,o,!1,null,"1feb1467",null),u=c.exports},634:function(t,e,s){t.exports=s.p+"img/defaultLOGO.2c22235d.jpg"}}]);
//# sourceMappingURL=459.c235c743.js.map