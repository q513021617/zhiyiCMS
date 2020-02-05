<template>
  <div class="wrapper">


  <div id="commonnav" th:replace="admin/adminnav :: adminnav"  >

  </div>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="rolemanager">
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
              <li class="breadcrumb-item active">角色管理</li>
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
              <h1 class="card-title" style="font-weight: bold;">角色列表</h1>
            </div>
            <button @click="addRole" class="btn btn-primary" data-toggle="modal"  data-target="#infomodal" >新增角色</button>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="userlist" class="table table-bordered">
                <thead>
                <tr>
                  <th style="width: 10px">#</th>
                  <th>角色名</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>

                <tr v-if="rolelist.length<=0">
                  <td colspan="4">暂时无角色信息</td>
                </tr>

                <tr v-for="item in rolelist" v-bind:key="item.id">
            <td>{{item.id}}</td><td>{{item.name}}</td>
                  <td>

                  <button type="submit" class="btn btn-danger" data-toggle="modal"  data-target="#infomodal" @click="delRole(item.id)">删除</button>
                     <button type="submit" class="btn btn-info" data-toggle="modal"  data-target="#infomodal" @click="queryRole(item.id)">查看详细信息</button>
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
<!-- ./wrapper -->

</template>

<script>
  function Info(tag,name,value) {
    this.tag=tag;
    this.name=name;
    this.value=value;

  }

  function Role() {
    this.id=0;
    this.roleName="";
  }
  import httpmethods from '@/tools/http'
import Infomodal from '@/components/infomodal.vue'

import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'

export default {
  name: 'rolemanager',
  data() {
    return {
      userCount: 52,

        rolelist:[],

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
      queryAllRole:function () {
        var _this=this;
    $.get("/api/admin/role/",function (data) {

      _this.rolelist=data;
      _this.$forceUpdate();

    });
  },
      delRole:function (id) {
    console.log("删除 "+id);
    let role=new Role();
        role.id=id;
        var _this=this;
        this.showinfo("提示:",[],false,"确定","是否删除该角色信息?",function () {


          httpmethods.delDataFuc(role,"/api/admin/role/",function () {
       
            _this.showToastFuc("信息:","","删除角色成功!");
            _this.closeInfoModelP();
            _this.queryAllRole();
          setTimeout(_this.closeInfoModelP,500);
         });

    });



  },
      queryRole: function (id) {

        var _this=this;
    $.get("/api/admin/role/"+id,function (data) {
      console.log(data);
      var infolist=[];


      infolist.push(new Info("权限名","roleName",data.name));


      _this.showinfo("权限信息:",infolist,true,"确定","",function () {

          let tempRole=new Role();
        tempRole.id=id;
          console.log("showInfo----");
        tempRole.roleName=infolist[0].value;

          console.log(tempRole);
        let roledata = new FormData();
        roledata.append('name',tempRole.roleName);
        roledata.append('id',id);
          httpmethods.updateDataFuc(roledata,"/api/admin/role/",function () {
             _this.showToastFuc("提示:","","权限数据更新完毕");
            _this.closeInfoModelP();
            _this.queryAllRole();
          });


      });
    });

  },addRole: function () {

        var infolist=[];

        infolist.push(new Info("权限名","roleName",""));

        var _this=this;
        this.showinfo("权限信息:",infolist,true,"确定","",function () {
          console.log(infolist);

          var tempRole=new Role();
          tempRole.roleName=infolist[0].value;
          console.log(tempRole);
          let roledata = new FormData();
          roledata.append('name',tempRole.roleName);

          httpmethods.addDataFuc(roledata,"/api/admin/role/",function () {
             _this.showToastFuc("信息:","","添加权限成功!");
            _this.queryAllRole();
            _this.closeInfoModelP();
          });


        });
  }},created: function () {
      this.queryAllRole();
  },
  components: {
       Infomodal,
    ToastsContainerTopRight
  }
}
</script>

<style>

</style>