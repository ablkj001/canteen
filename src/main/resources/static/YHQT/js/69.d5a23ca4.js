"use strict";(self["webpackChunkschool_canteen"]=self["webpackChunkschool_canteen"]||[]).push([[69],{6069:function(t,e,i){i.r(e),i.d(e,{default:function(){return l}});var s=function(){var t=this,e=t._self._c;return e("div",{staticClass:"homeContainer"},[e("div",{directives:[{name:"show",rawName:"v-show",value:0==t.swiperList.length,expression:"swiperList.length == 0"}],staticClass:"pic"},[t._v("广告招商中")]),e("div",{directives:[{name:"show",rawName:"v-show",value:0!=t.swiperList.length,expression:"swiperList.length != 0"}],staticClass:"Carousel"},[e("el-carousel",{attrs:{interval:3e3,arrow:"always",autoplay:"",height:"350px"}},t._l(t.swiperList,(function(t){return e("a",{key:t.did,attrs:{href:"https://www.bilibili.com/"}},[e("el-carousel-item",[e("img",{staticClass:"swiperPic",attrs:{src:t.swiper}})])],1)})),0)],1),e("div",{staticClass:"notice"},[e("el-card",{staticClass:"box-card"},[e("div",{staticClass:"ggtitle",attrs:{slot:"header"},slot:"header"},[e("span",{},[t._v("公告")])]),t._l(t.noticeList,(function(i){return e("div",{key:i.nid,staticClass:"text item",on:{click:function(e){return t.showNotice(i)}}},[t._v(" "+t._s(i.title)+" ")])}))],2)],1),e("el-drawer",{attrs:{title:"我是标题",visible:t.drawer,"with-header":!1},on:{"update:visible":function(e){t.drawer=e}}},[e("div",{staticClass:"notTitle"},[t._v(t._s(t.noticeDetail.title))]),e("div",{staticClass:"notDate"},[t._v(t._s(t.noticeDetail.noticeDate))]),e("div",{staticClass:"notContent"},[t._v(t._s(t.noticeDetail.content))])]),e("div",{staticClass:"today"},[e("div",{staticClass:"TJtitle"},[t._v("今日推荐")]),e("div",t._l(t.todayFoodList,(function(i){return e("div",{key:i.did,staticClass:"TJfood",on:{click:function(e){return t.goFoodDetail(i.did)}}},[e("div",{staticClass:"foodPic"},[e("img",{staticStyle:{width:"100%"},attrs:{src:i.dimage}})]),e("div",{staticClass:"foodInfo"},[e("div",{staticClass:"foodTitle"},[t._v(t._s(i.dname))]),e("div",[e("span",{staticClass:"money"},[t._v("￥")]),t._v(":"+t._s(i.dprice)+".00")])])])})),0)])],1)},a=[],o=(i(7658),i(586)),r={name:"home",data(){return{swiperList:[],noticeList:[],todayFoodList:[],noticeDetail:{nid:"",noticeDate:"",content:"",title:""},drawer:!1}},methods:{async getSwiperList(){const{data:t}=await(0,o.Zc)({page:1,dname:"",pagesize:7});if(0!=t.code&&1!=t.code)return this.$message.error("获取轮播图列表失败！");1==t.code?this.swiperList=[]:this.swiperList=t.data},async getNoticeList(){const{data:t}=await(0,o.pv)({page:1,title:""});if(0!=t.code)return this.$message.error("获取公告列表失败！");this.noticeList=t.data,this.noticeList.forEach((t=>{t.noticeDate=this.myDateFormat(t.noticeDate)}))},async getTodayFoodListRandom(){const{data:t}=await(0,o.wo)();if(0!==t.code)return this.$message.error("后去推荐菜品列表失败！");this.todayFoodList=t.data},async getTodayFoodList(){const{data:t}=await(0,o.EQ)({page:1,dname:"",pagesize:7});if(0!==t.code&&1!=t.code)return this.$message.error("后去推荐菜品列表失败！");console.log(t),this.todayFoodList=t.data},showNotice(t){this.drawer=!0,this.noticeDetail=t},goFoodDetail(t){this.$router.push({name:"Food",query:{foodID:t}})}},created(){this.getTodayFoodList(),this.getNoticeList(),this.getSwiperList()}},n=r,c=i(1001),d=(0,c.Z)(n,s,a,!1,null,"322d2c3d",null),l=d.exports}}]);
//# sourceMappingURL=69.d5a23ca4.js.map