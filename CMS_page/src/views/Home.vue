<template>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="index_view">
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
              <li class="breadcrumb-item active">本站数据</li>
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
            <div class="small-box bg-warning">
              <div class="inner">
                <h3>44</h3>

                <p>文章访问量</p>
              </div>
              <div class="icon">
                <i class="ion ion-person-add"></i>
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

        
          <div class="col-md-6">
            <h1>文章访问量</h1>
            <div class="card card-success">
              <div class="card-header">
                <h3 class="card-title">各类型文章访问量对比</h3>
  
                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i></button>
                </div>
              </div>
              <div class="card-body">
                <div class="chart"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                  <canvas ref="barChart" id="barChart" style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%; display: block; width: 100%;" width="100%" height="250" class="chartjs-render-monitor"></canvas>
                </div>
              </div>
              <!-- /.card-body -->
            </div>
          </div>
          
          <div class="col-md-6">
            <h1>浏览器使用占比</h1>
              <div class="card card-danger">
                <div class="card-header">
                  <h3 class="card-title">浏览器使用率</h3>
      
                  <div class="card-tools">
                    <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i>
                    </button>
                    <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i></button>
                  </div>
                </div>
                <div class="card-body"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                  <canvas ref="browerChart" id="browerChartID" style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%; display: block; width: 100%;" width="100%" height="250" class="chartjs-render-monitor"></canvas>
                </div>
                <!-- /.card-body -->
              </div>
  
          </div>


        </div>
        

              <div class="row">
                <div class="card" style="width: 100%;height: auto;">
                  <div class="card-header">
                    <h1 class="card-title" style="font-weight: bold;">最后注册用户</h1>
                  </div>
                  <!-- /.card-header -->
                  <div class="card-body">
                    <table id="userlist" class="table table-bordered">
                      <thead>                  
                        <tr>
                          <th style="width: 10px">#</th>
                          <th>用户名</th>
                         
                          <th style="width:30%">身份</th>
                          <th style="width:30%">操作</th>
                        </tr>
                      </thead>
                      <tbody>

                      <tr v-if="userlist.length<=0">
                        <td colspan="4">暂时无用户信息</td>
                      </tr>

                      <tr v-for="item in userlist" v-bind:key="item.id">
                        <td>{{item.id}}</td><td>{{item.username}}</td><td>{{item.role==1?'管理员':'普通用户'}}</td>
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

import httpmethods from '@/tools/http'
import Vue from 'vue'
import Infomodal from '@/components/infomodal.vue'
import Pagehelper from '@/components/pagehelper.vue'
import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'

  function User() {
    this.id=0;
      this.username="";
      this.password='';
      this.sex=1;
      this.email="";
      this.role=1;
  }

  function Info(tag,name,value) {
    this.tag=tag;
    this.name=name;
    this.value=value;

  }



export default {
  
  name: 'Home',

   data(){

      return {
        
        userCount: 55,

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
      
    }, methods: {

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
      queryAllUserBypage:function (page) {
        
        console.log("queryAllUserBypage");
        var _this=this;
        page = page-1;

      console.log("page: " +page);
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
            _this.queryAllUserBypage(1);

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
            _this.queryAllUserBypage();
          });


      });
        });

      },
      showmoreitem:function () {


      },
      addUser: function () {

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
            _this.queryAllUserBypage(1);
           
            _this.closeInfoModelP();
          });


        });






      },
      getCharts:function(){
        //-------------
    //- DONUT CHART -
    //-------------
    // Get context with jQuery - using jQuery's .get() method.
    // var browerChartCanvas = $('#browerChart').get(0).getContext('2d');
    var browerChartCanvas = document.getElementById('browerChartID');
    console.log("browerChartCanvas ：");
    console.log(browerChartCanvas);
    var browerChartData = {
      labels: [
          'Chrome', 
          'IE',
          'FireFox', 
          'Safari', 
          'Opera', 
          'Navigator'
      ],
      datasets: [
        {
          data: [700,500,400,600,300,100],
          backgroundColor : ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de'],
        }
      ]
    };
    var browerChartOptions = {
      maintainAspectRatio : false,
      responsive : true,
    };

    //Create pie or douhnut chart
    // You can switch between pie and douhnut using the method below.
    // 如果没有这一操作将不会显示图表信息
    var browerChart = new Chart(browerChartCanvas, {
      type: 'doughnut',
      data: browerChartData,
      options: browerChartOptions      
      });

// 条状图表

    var barChartCanvas = $('#barChart').get(0).getContext('2d');
    console.log(barChartCanvas);
    var barChartData = {
      labels  : ['java', 'js', 'css', 'C#', 'unity', 'hadoop', 'hive'],
      datasets: [
        {
          label               : '总数据',
          backgroundColor     : 'rgba(60,141,188,0.9)',
          borderColor         : 'rgba(60,141,188,0.8)',
          pointRadius          : false,
          pointColor          : '#3b8bba',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [28, 48, 40, 19, 86, 27, 90]
        }
        
      ]
    };

    var barChartOptions = {
      responsive              : true,
      maintainAspectRatio     : false,
      datasetFill             : false
    };

    var barChart = new Chart(barChartCanvas, {
      type: 'bar', 
      data: barChartData,
      options: barChartOptions
    });

      }
    },created: function () {
      
          
      
    }, mounted:function(){
      
          this.queryAllUserBypage(1);
          this.getCharts();

    },
  components: {
    Infomodal,
    ToastsContainerTopRight,
    Pagehelper
  }
}
</script>
<style>
  @keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}}
  .chartjs-render-monitor{animation:chartjs-render-animation 1ms}
  .chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{position:absolute;direction:ltr;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1}
  .chartjs-size-monitor-expand > div{position:absolute;width:1000000px;height:1000000px;left:0;top:0}

  .chartjs-size-monitor-shrink > div{position:absolute;width:200%;height:200%;left:0;top:0}
</style>