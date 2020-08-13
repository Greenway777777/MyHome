webpackJsonp([1],{"/6x2":function(t,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l={name:"Editor",components:{ImgUpload:o("1vuj").default},data:function(){return{blog:{},dialogVisible:!1}},mounted:function(){this.$route.params.blog&&(this.blog=this.$route.params.blog)},methods:{saveBlogs:function(t,e){var o=this;this.$confirm("是否保存并发布文章?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){o.$axios.post("/admin/content/blog",{id:o.blog.id,blogTitle:o.blog.blogTitle,blogContentMd:t,blogContentHtml:e,blogAbstract:o.blog.blogAbstract,blogCover:o.blog.blogCover,blogDate:o.blog.blogDate}).then(function(t){t&&200===t.data.code&&o.$message({type:"info",message:"已保存成功"})})}).catch(function(){o.$message({type:"info",message:"已取消发布"})})},uploadImg:function(){this.blog.blogCover=this.$refs.imgUpload.url}}},n={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("el-row",{staticStyle:{margin:"18px 0px 0px 18px"}},[o("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[o("el-breadcrumb-item",{attrs:{to:{path:"/admin/dashboard"}}},[t._v("管理中心")]),t._v(" "),o("el-breadcrumb-item",{attrs:{to:{path:"/admin/content/bank"}}},[t._v("内容管理")]),t._v(" "),o("el-breadcrumb-item",{attrs:{to:{path:"/admin/content/blog"}}},[t._v("文章管理")]),t._v(" "),o("el-breadcrumb-item",[t._v("编辑器")])],1)],1),t._v(" "),o("el-row",[o("el-input",{staticStyle:{margin:"10px 0px","font-size":"18px"},attrs:{placeholder:"请输入标题"},model:{value:t.blog.blogTitle,callback:function(e){t.$set(t.blog,"blogTitle",e)},expression:"blog.blogTitle"}})],1),t._v(" "),o("el-row",{staticStyle:{height:"calc(100vh - 140px)"}},[o("mavon-editor",{ref:"md",staticStyle:{height:"100%"},attrs:{fontSize:"16px"},on:{save:t.saveBlogs},model:{value:t.blog.blogContentMd,callback:function(e){t.$set(t.blog,"blogContentMd",e)},expression:"blog.blogContentMd"}},[o("button",{staticClass:"op-icon el-icon-document",attrs:{slot:"left-toolbar-after",type:"button",title:"摘要/封面"},on:{click:function(e){t.dialogVisible=!0}},slot:"left-toolbar-after"})]),t._v(" "),o("el-dialog",{attrs:{visible:t.dialogVisible,width:"30%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[o("el-divider",{attrs:{"content-position":"left"}},[t._v("摘要")]),t._v(" "),o("el-input",{attrs:{type:"textarea",rows:"6",maxlength:"255","show-word-limit":""},model:{value:t.blog.blogAbstract,callback:function(e){t.$set(t.blog,"blogAbstract",e)},expression:"blog.blogAbstract"}}),t._v(" "),o("el-divider",{attrs:{"content-position":"left"}},[t._v("封面")]),t._v(" "),o("div",{staticStyle:{"margin-top":"20px"}},[o("el-input",{attrs:{autocomplete:"off",placeholder:"图片 URL"},model:{value:t.blog.blogCover,callback:function(e){t.$set(t.blog,"blogCover",e)},expression:"blog.blogCover"}}),t._v(" "),o("img-upload",{ref:"imgUpload",staticStyle:{"margin-top":"5px"},on:{onUpload:t.uploadImg}})],1),t._v(" "),o("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),o("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("确 定")])],1)],1)],1)],1)},staticRenderFns:[]},a=o("VU/8")(l,n,!1,null,null,null);e.default=a.exports},"1vuj":function(t,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l={name:"ImgUpload",data:function(){return{fileList:[],url:""}},methods:{handleRemove:function(t,e){console.log(t,e)},handlePreview:function(t){console.log(t)},handleExceed:function(t,e){this.$message.warning("当前限制选择 1 个文件，本次选择了 "+t.length+" 个文件，共选择了 "+(t.length+e.length)+" 个文件")},beforeRemove:function(t,e){return this.$confirm("确定移除 "+t.name+"？")},handleSuccess:function(t){this.url=t,this.$emit("onUpload"),this.$message.warning("上传成功")},clear:function(){this.$refs.upload.clearFiles()}}},n={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("el-upload",{ref:"upload",staticClass:"img-upload",attrs:{action:"http://localhost:8443/api/admin/content/banks/covers","with-credentials":"","on-preview":t.handlePreview,"on-remove":t.handleRemove,"before-remove":t.beforeRemove,"on-success":t.handleSuccess,multiple:"",limit:1,"on-exceed":t.handleExceed,"file-list":t.fileList}},[o("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")]),t._v(" "),o("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg/png文件，且不超过500kb")])],1)},staticRenderFns:[]};var a=o("VU/8")(l,n,!1,function(t){o("SCtr")},"data-v-cf1f2a88",null);e.default=a.exports},SCtr:function(t,e){}});
//# sourceMappingURL=1.f21ba07dbaff81e3f1cf.js.map