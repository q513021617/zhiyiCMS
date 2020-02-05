<template>
  <div class="wrapper">

  <div id="commonnav" th:replace="admin/adminnav :: adminnav"  >

  </div>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
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
              <li class="breadcrumb-item active">SEO管理</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div id="site_content-main" class="container-fluid">
        <!-- Small boxes (Stat box) -->
        <div class="row">
         
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-success">
              <div class="inner">
                <h3>53</h3>

                <p>站点访问量</p>
              </div>
              <div class="icon">
                <i class="ion ion-stats-bars"></i>
              </div>
              <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
       

        
          <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
          <h1>站点标题</h1>
          
        </div>

        <input  type="text" v-model="title" class="form-control" style="width: 30%;border-style: solid;border-width: medium;border-color: #007bff;"/>

        <div class="row">
          <h1>站点描述</h1>
          
        </div>
        <div class="row">
          <textarea type="text" v-model="description" class="form-control" style="width: 30%;height:auto; border-style:solid;border-width: medium;border-color: #007bff;" ></textarea>
        </div>
      <br>
          <div class="row">
            <button class="btn btn-block btn-primary btn-lg" @click="updateContent" style="width: 30%;">更新</button>
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

function SeoInfo(id,title,description) {
    this.id=id;
    this.siteName=title;
    this.siteDescription=description;

  }

  import httpmethods from '@/tools/http'
import Infomodal from '@/components/infomodal.vue'
import Vue from 'vue'
import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'

export default {
  data() {
    return {
     title: 'zhiyi分享',
      description:"一款博客系统",
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
  queryContent:function () {
          var _this=this;
        $.get("/api/admin/seoInfo/1",function (data) {
            _this.title=data.siteName;
          _this.description=data.siteDescription;
          console.log(" 查询"+_this.title+" "+_this.description);
        });
      },

      updateContent:function () {
        var _this=this;
        console.log(_this);
        var seoInfo=new SeoInfo(1,_this.title,_this.description);
        console.log(" 查询"+_this.title+" "+_this.description);
        $.ajax({
          url: "/api/admin/seoInfo/",
          type: 'PUT',
          data:seoInfo,
          success: function(result) {
            console.log("更新: "+result);
        
        _this.showToastFuc("信息:","","更新信息成功!");
       
            _this.queryContent();
          }
        });

      }
  },created: function () {
    this.queryContent();
  },
  components: {
    Infomodal,
    ToastsContainerTopRight
  }
}
</script>

<style>

</style>