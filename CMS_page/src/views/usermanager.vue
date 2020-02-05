<template>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="usermanager">
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
              <li class="breadcrumb-item active">用户管理</li>
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
              <h1 class="card-title" style="font-weight: bold;">用户列表</h1>
            </div>
            <button @click="addUser" class="btn btn-primary" data-toggle="modal"  data-target="#infomodal" >新增用户</button>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="userlist" class="table table-bordered">
                <thead>
                <tr>
                  <th style="width: 10px">#</th>
                  <th>用户名</th>
                  <th style="width:20%">密码</th>
                  <th >身份</th>
                  <th style="width:30%">操作</th>
                </tr>
                </thead>
                <tbody>

                <tr v-if="userlist.length<=0">
                  <td colspan="5">暂时无用户信息</td>
                </tr>

                <tr v-for="item in userlist" v-bind:key="item.id">
            <td>{{item.id}}</td><td>{{item.username}}</td><td>{{item.password}}</td><td>{{item.role==1?'管理员':'普通用户'}}</td>
                  <td>
                    <button type="submit" class="btn btn-primary" data-toggle="modal"  data-target="#infomodal" >封号</button>
                  <button type="submit" class="btn btn-danger" data-toggle="modal"  data-target="#infomodal" @click="delAccount(item.id)">删除</button>
                     <button type="submit" class="btn btn-info" data-toggle="modal"  data-target="#infomodal" @click="queryUser(item.id)">查看详细信息</button>
                  </td>

                </tr>


                </tbody>
              </table>
            </div>
            <!-- /.card-body -->
               <Pagehelper
                 v-bind:tatolpage="tatolpage"
                 v-bind:curpage="curpage"
                 v-on:queryAllBypagechild="queryAllUserBypage"
                 ref = "pagehp"
                 ></Pagehelper>
          </div>

        </div>

      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->

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

  </div>
  <!-- /.content-wrapper -->

</template>

<script>
function Info(tag,name,value) {
    this.tag=tag;
    this.name=name;
    this.value=value;

  }
  function User() {
    this.id=0;
    this.username="";
    this.password='';
    this.sex=1;
    this.email="";
    this.role=1;
  }
import httpmethods from '@/tools/http'
import Infomodal from '@/components/infomodal.vue'
import Vue from 'vue'
import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'
import Pagehelper from '@/components/pagehelper.vue'
export default {

name: 'usermanager',

 data(){
        return{
            userCount: 52,

        userlist:[],

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

            pagesize:5,
          tatolpage:5,
          curpage:1
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
      queryAllUserBypage:function (page){

        var _this=this;
        
        page = page-1;
         httpmethods.axios.get("/api/admin/webUser/"+page+"/"+this.pagesize,{}).then(

            function (data) {

            data=data.data;
            console.log("data.content");
            console.log(data.totalPages);
            _this.userCount=66;
          _this.userlist = data.content;
          _this.tatolpage= data.totalPages;
           _this.$refs.pagehp.refreshdata( _this.tatolpage);
          _this.$forceUpdate();

        }
        ).catch(function (error) {

          console.log(error);
                    console.log(error.response);
                });
      },
      delAccount:function (id) {

    console.log("删除 "+id);
    let webUser=new User();
    webUser.id=id;
        let userdata = new FormData();
        userdata.append('id',webUser.id);
        var _this=this;

        this.showinfo("提示:",[],false,"确定","是否删除该用户信息?",function () {
    
        $.ajax({
          url: "/api/admin/webUser/",
          type: 'DELETE',
          data:webUser,
          success: function(result) {
            console.log("删除: "+result);
            _this.showToastFuc("信息:","","删除用户成功!");
            _this.closeInfoModelP();
            setTimeout(_this.closeInfoModelP,500);
            _this.queryAllUser();

          }
        });


    });



  },
      queryUser: function (id) {

        var _this=this;
    $.get("/api/admin/webUser/"+id,function (data) {
      console.log(data);
      var infolist=[];


      infolist.push(new Info("用户名","uername",data.username));
      infolist.push(new Info("密码","password",data.password));
      infolist.push(new Info("性别","sex",data.sex));
      infolist.push(new Info("email","email",data.email));
      infolist.push(new Info("角色","role",data.role));

      _this.showinfo("用户信息:",infolist,true,"确定","",function () {

          let tempWebUser=new User();
        tempWebUser.id=id;
          console.log("showInfo----");
        tempWebUser.username=infolist[0].value;
        tempWebUser.password=infolist[1].value;
        tempWebUser.sex=infolist[2].value;
        tempWebUser.email=infolist[3].value;
        tempWebUser.role=infolist[4].value;
        let userdata = new FormData();
        userdata.append('id',tempWebUser.id);
        userdata.append('username',tempWebUser.username);
        userdata.append('password',tempWebUser.password);
        userdata.append('sex',tempWebUser.sex);
        userdata.append('email',tempWebUser.email);
        userdata.append('role',tempWebUser.role);
          console.log(userdata);
          httpmethods.updateDataFuc(userdata,"/api/admin/webUser/",function () {
            _this.showToastFuc("提示:","","用户数据更新完毕");
            _this.closeInfoModelP();
            _this.queryAllUser();
          });


      });
    });

  },addUser: function () {

        var infolist=[];

        infolist.push(new Info("用户名","uername",""));
        infolist.push(new Info("密码","password",""));
        infolist.push(new Info("性别","sex",""));
        infolist.push(new Info("email","email",""));
        infolist.push(new Info("角色","role",""));
        var _this=this;
        this.showinfo("用户信息:",infolist,true,"确定","",function () {
          console.log(infolist);

          var tempWebUser=new User();

          tempWebUser.username=infolist[0].value;
          tempWebUser.password=infolist[1].value;
          tempWebUser.sex=infolist[2].value;
          tempWebUser.email=infolist[3].value;
          tempWebUser.role=infolist[4].value;

          let userdata = new FormData();
          userdata.append('username',tempWebUser.username);
          userdata.append('password',tempWebUser.password);
          userdata.append('sex',tempWebUser.sex);
          userdata.append('email',tempWebUser.email);
          userdata.append('role',tempWebUser.role);
          console.log(tempWebUser);

          httpmethods.addDataFuc(userdata,"/api/admin/webUser/",function () {
            // 
            _this.showToastFuc("信息:","","添加用户成功!");
            _this.queryAllUser();
            
            _this.closeInfoModelP();
          });


        });





    }
    },created: function () {
       this.queryAllUserBypage(1);
  },
  components:{
    Infomodal,
    ToastsContainerTopRight,
    Pagehelper
  }
}
</script>

<style>

</style>