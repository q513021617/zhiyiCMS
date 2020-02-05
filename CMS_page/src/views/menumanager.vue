<template>
  <div class="wrapper">


    <div id="commonnav" th:replace="admin/adminnav :: adminnav"  >

    </div>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" id="menumanager">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">本站数据</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">菜单管理</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- Small boxes (Stat box) -->
                <div class="row">
                    <div class="col-lg-3 col-6">
                        <!-- small box -->
                        <div class="small-box bg-info">
                            <div class="inner">
                                <h3>{{userCount}}</h3>

                                <p>注册人数</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>
                            <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-6">
                        <!-- small box -->
                        <div class="small-box bg-success">
                            <div class="inner">
                                <h3>53</h3>

                                <p>登录人数</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-stats-bars"></i>
                            </div>
                            <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->


                    <div class="col-lg-3 col-6">
                        <!-- small box -->
                        <div class="small-box bg-danger">
                            <div class="inner">
                                <h3>65</h3>

                                <p>访问人数</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-pie-graph"></i>
                            </div>
                            <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                </div>
                <!-- /.row -->
                <!-- Main row -->
                <div class="row">
                    <div class="card" style="width: 100%;height: auto;">
                        <div class="card-header">
                            <h1 class="card-title" style="font-weight: bold;">菜单列表</h1>
                        </div>
                        <button @click="addMenu" class="btn btn-primary" data-toggle="modal"  data-target="#infomodal" >新增菜单</button>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="menulist" class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style="width: 10px">#</th>
                                    <th>菜单名</th>
                                    <th>菜单链接</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                <tr v-if="menulist.length<=0">
                                    <td colspan="4">暂时无角色信息</td>
                                </tr>

                                <tr v-for="item in menulist" v-bind:key="item.id">
                                    <td>{{item.id}}</td><td>{{item.name}}</td>
                                    <td>{{item.url}}</td>
                                    <td>

                                        <button type="submit" class="btn btn-danger" data-toggle="modal"  data-target="#infomodal" @click="delMenu(item.id)">删除</button>
                                        <button type="submit" class="btn btn-info" data-toggle="modal"  data-target="#infomodal" @click="queryMenu(item.id)">查看详细信息</button>
                                    </td>

                                </tr>


                                </tbody>
                            </table>
                        </div>
                        <!-- /.card-body -->
                        <div class="card-footer clearfix">
                            <ul class="pagination pagination-sm m-0 float-right">
                                <li class="page-item"><a class="page-link" href="#">«</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">»</a></li>
                            </ul>
                        </div>
                    </div>

                </div>

            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

  <Infomodal
     v-bind:inputtitle="inputtitle"
     v-bind:isinputlist="isinputlist"
     v-bind:info="info"
     v-bind:oktext="oktext"
     v-on:closeInfoModel="closeInfoModelP"
     v-on:okmethod="okmethodP"
     v-bind:infolist="infolist"
     v-if="showmodel"
     ></Infomodal>

  <ToastsContainerTopRight
     v-bind:ToastTitle="ToastTitle"
     v-bind:ToastSubtitle="ToastSubtitle"
     v-bind:Toasttext="Toasttext"
     v-if="showtoast"
     v-on:closeInfoToast="closeInfoToastP"
     ></ToastsContainerTopRight>
    <!-- /.control-sidebar -->
</div>

</template>

<script>
 function Info(tag,name,value) {
        this.tag=tag;
        this.name=name;
        this.value=value;

    }

    function Menu() {
        this.id=0;
        this.menuName="";
        this.menuUrl="";
    }

import httpmethods from '@/tools/http'
import Infomodal from '@/components/infomodal.vue'
import Vue from 'vue'
import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'

export default {
  data() {
    return {
        userCount: 52,

            menulist:[],

            buttonstatus:"display: none;",
            ind:"",
              // 模态框数据
         inputtitle:"",
          isinputlist:true,
          info:"",
          infolist:[],
          oktext:"",
          okmethodP:Function,
          showmodel:false,

           // 提示框数据
           ToastTitle:"",
            ToastSubtitle:"",
            Toasttext:"",
          showtoast:false,
    }
  },
  methods: {
      closeInfoModelP:function (showmodel) {
        this.showmodel=showmodel;
      },
      closeInfoToastP:function () {
        this.showtoast=false;
      },
        showinfo:function(inputtitle,infolist,isinputlist,oktext,info,okmethod) {
        console.log("showinfo");
        this.inputtitle=inputtitle;
          this.isinputlist=isinputlist;
          this.info=info;
          this.infolist=infolist;
          this.oktext=oktext;
          this.okmethodP=okmethod;
          this.showmodel=true;
   
          // this.$forceUpdate();
       
      },showToastFuc:function(ToastTitle,ToastSubtitle,Toasttext) {
        console.log("showToast");
        
        this.ToastTitle=ToastTitle;
            this.ToastSubtitle=ToastSubtitle;
            this.Toasttext=Toasttext;
          this.showtoast=true;
        var _this=this;
          // this.$forceUpdate();
       window.setTimeout(_this.closeInfoToastP,1000);

      },
      closeInfoModelP:function (showmodel) {
        this.showmodel=showmodel;
      },
             queryAllMenu:function () {
                var _this=this;
                $.get("/api/admin/permission/",function (data) {

                    _this.menulist=data;
                    _this.$forceUpdate();

                });
            },
            delMenu:function (id) {
                console.log("删除 "+id);
                let menu=new Menu();
                menu.id=id;
                var _this=this;
                this.showinfo("提示:",[],false,"确定","是否删除该菜单信息?",function () {


                    httpmethods.delDataFuc(menu,"/api/admin/permission/",function () {
                        _this.showToastFuc("信息:","","删除菜单成功!");
                        _this.closeInfoModelP();
                        setTimeout(_this.closeInfoModelP,500);
                        _this.queryAllMenu();
                    });

                });



            },
            queryMenu: function (id) {

                var _this=this;
                $.get("/api/admin/permission/"+id,function (data) {
                    console.log(data);
                    var infolist=[];


                    infolist.push(new Info("菜单名","menuName",data.name));
                    infolist.push(new Info("菜单链接","menuUrl",data.url));


                    _this.showinfo("菜单信息:",infolist,true,"确定","",function () {

                        let tempMenu=new Menu();
                        tempMenu.id=id;
                        console.log("showInfo----");
                        tempMenu.menuName=infolist[0].value;
                        tempMenu.menuUrl=infolist[1].value;

                        console.log(tempMenu);
                        let menudata = new FormData();
                        menudata.append('name',tempMenu.menuName);
                        menudata.append('url',tempMenu.menuUrl);

                        menudata.append('id',id);
                        httpmethods.updateDataFuc(menudata,"/api/admin/permission/",function () {
                              _this.showToastFuc("信息:","","菜单数据更新完毕!");
                            _this.queryAllMenu();
                             _this.closeInfoModelP();
                        });


                    });
                });

            },addMenu: function () {

                var infolist=[];

                infolist.push(new Info("菜单名","menuName",""));
                infolist.push(new Info("菜单链接","menuUrl",""));

                var _this=this;
                this.showinfo("菜单信息:",infolist,true,"确定","",function () {
                    console.log(infolist);

                    var tempMenu=new Menu();
                    tempMenu.menuName=infolist[0].value;
                    tempMenu.menuUrl=infolist[1].value;
                    console.log(tempMenu);
                    let menudata = new FormData();
                    menudata.append('name',tempMenu.menuName);
                    menudata.append('url',tempMenu.menuUrl);

                    httpmethods.addDataFuc(menudata,"/api/admin/permission/",function () {
                        _this.showToastFuc("信息:","","添加菜单成功!");
                        _this.queryAllMenu();
                        _this.closeInfoModelP();
                    });


                });





            }
  },created: function () {
            this.queryAllMenu();
        },
  components: {
    Infomodal,
    ToastsContainerTopRight
  }
}
</script>

<style>

</style>
