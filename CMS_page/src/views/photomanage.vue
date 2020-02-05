<template>
 <div class="wrapper">


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="content-main">
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
              <li class="breadcrumb-item active">图片管理</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">




        <div class="row">
          <div class="col-lg-12 col-12">
            <!-- small box -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3>{{photoCount}}</h3>

                <p>图片数</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag"></i>
              </div>
              <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>

          <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->
     
     
          <section class="content">
            <div class="container-fluid">
              <div class="row col-12" style="height: 500px;border:10px solid #17a2b8;padding: 0;border-radius: 15px;">



                    <h2 style="text-align:center;width: 100%;background-color: #17a2b8;color: white;align-content: center;height: 80px;margin:0 auto;">banner设置</h2>

<!--  -->  <button class="btn btn-danger" style="width:100%;margin-top:1px;" data-toggle="modal"  data-target="#infomodal" @click="addBanner()">增加banner</button>
                  <div v-for="(item,index) in bannerUrls" v-bind:key="index" class="row col-12" style="position: relative;top: 20px;height: 50px;"> 
                    <h3 class="card-title col-4" style="text-align:center;">{{item.bannerName}}</h3>
                    <input type="text" class="col-4" :value="item.bannerUrl"/>
                    <button  @click="updateBanner(index)" style="position: relative;left: 20px;" class="btn btn-primary">修改</button>
                    <button @click="selectimg(index)" style="position: relative;left: 20px;" class="btn btn-primary">选择</button>
                    <button @click="deleteBanner(item.id)" style="position: relative;left: 20px;" class="btn btn-primary">删除</button>
                    </div>
     
                </div>



              <div class="row" style="position: relative;top: 20px;">
                <div class="col-12">
                  <div id="phtotlist" class="card card-primary">
                    <div class="card-header">
                      <h3 class="card-title">图片列表</h3>

                    </div>
<!--    style="position: relative;left: 20px;"      \width: 150px;-->
                    <button class="btn btn-danger"  data-toggle="modal"  data-target="#infomodal" @click="addImg()">增加图片</button>
                    <div class="card-body">
                      <div class="row">


                          <div class="col-md-4" style="margin-top: 10px;" v-for="(item,index) in photodatalist" v-bind:key="item.id">
                            <!--background-image: url({{item.}})-->
                            <div class="position-relative p-3 bg-gray"  @mouseover="mousehoverdiv(index)"   @mouseout="mouseoutdiv(index)" :style="'height: 180px;background-size: 100% 100%;backgroundImage:url(' + item.srcUrl + ')' ">
                            <div class="ribbon-wrapper ribbon-xl">
                              <div class="ribbon bg-secondary">     {{item.photoName}}    </div>
                            </div>
                              <!--<i class="fas fa-trash-alt" style="display: none;"></i>-->
                            <button  @click="queryimg(item.srcUrl)"   class="blockstyle btn btn-danger"  :class="[ind==index? 'show':'hide']"><i class="fas fa-search-plus" ></i>查看</button>
                              <button @click="delimg(item.id)" style="left: 55%;z-index: 999;" :class="[ind==index? 'show':'hide']" class="blockstyle btn btn-danger" data-toggle="modal"  data-target="#infomodal">删除</button>
                            </div>  
                  
                        </div>


                    </div>


                    </div>
                    <!-- /.card-body -->
                  </div>
                  <!-- /.card -->
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
          </section>




      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
 

  <!-- /.content-wrapper -->
   <Infomodal
     v-bind:inputtitle="inputtitle"
     v-bind:isinputlist="isinputlist"
     v-bind:info="info"
     v-bind:oktext="oktext"
     v-bind:isimg="isimg"
     v-on:closeInfoModel="closeInfoModelP"
     v-on:okmethod="okmethodP"
     v-on:geturlC="geturl"
     v-bind:infolist="infolist"
     v-bind:isimglist="isimglist"
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
</div>
</template>

<script>
var timestring = (new Date()).valueOf();
timestring=timestring+""
timestring=timestring.substring(0,10);
timestring=parseInt(timestring)
  function Info(tag,name,value) {
    this.tag=tag;
    this.name=name;
    this.value=value;

  }
  function Photo() {
    this.id=0;
    this.photoName="";
    this.srcUrl='';
    this.uploadTime=getLocalTime(timestring,'YYYY-MM-DD hh:mm:ss');

  }
  function getLocalTime(nS, f) {
    let format = 'YYYY-MM-DD hh:mm:ss' // 日期格式，yyyy: 年，m：月，d：天，hh：时，mm：分，ss：秒
    if (f) {
      format = f
    }

    let time
    if (nS) {
      time = new Date(nS * 1000)
    } else {
      time = new Date()
    }
    let y = time.getFullYear()
    let m = time.getMonth() + 1
    let d = time.getDate()
    let h = time.getHours()
    let mm = time.getMinutes()
    let s = time.getSeconds()

    m = m < 10 ? '0' + m : m
    d = d < 10 ? '0' + d : d
    h = h < 10 ? '0' + h : h
    mm = mm < 10 ? '0' + mm : mm
    s = s < 10 ? '0' + s : s

    let fullTime = format.replace('YYYY', y).replace('MM', m).replace('DD', d).replace('hh', h).replace('mm', mm).replace('ss', s)

    return fullTime
  }

  import httpmethods from '@/tools/http'
import Infomodal from '@/components/infomodal.vue'
import Vue from 'vue'
import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'

export default {
  data() {

    return {

    photoCount: 52,
      photodatalist:[],
      showimgurl:"",
     buttonstatus:"display: none;",
      ind:"",
          // 模态框数据
         inputtitle:"",
          isinputlist:true,
          isimglist:false,
          info:"",
          infolist:[],
          bannerUrls:[],
          bannerselect:"",

          bannerselectURL:"",
          isimg:false,
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
      updateBanner:function(index){

        let bannerdata = new FormData();
        bannerdata.append('id',this.bannerUrls[index].id);
        bannerdata.append('bannerName',this.bannerUrls[index].bannerName);
        bannerdata.append('bannerUrl',this.bannerUrls[index].bannerUrl);
        var _this=this;
          httpmethods.updateDataFuc(bannerdata,"/api/admin/banner/",function () {
            _this.showToastFuc("提示:","","banner数据更新完毕");
        
            _this.queryAllBanner();
          });

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
      queryAllBanner:function(){
        var _this=this;
           $.get("/api/admin/banner/",function (data) {
             console.log(data);
             if(data.length>0){
                _this.bannerUrls=data;
             }
        
         _this.$forceUpdate();
        
        });
      },
      queryAllPhoto: function () {
        var _this=this;


        $.get("/api/admin/photo/",function (data) {
          console.log(data);

          if(data.length>0){
            _this.photodatalist=data;

          }
          _this.$forceUpdate();
          console.log(_this.photodatalist);


        });

      },

      mousehoverdiv:function (index) {
        console.log("---mousehoverdiv----   "+index);
        this.ind=index;

      },
      mouseoutdiv:function () {
        this.ind="";

      },
      queryimg:function (url){

        var _this=this;
        this.isimg=true;
    this.showinfo("图片显示:",[],false,"确定",url,function(){
      
          _this.closeInfoModelP()
    });

  },
  geturl:function(url){
      
      this.bannerselectURL=url;
      
  },
  selectimg:function(index){
    var _this=this;
    this.isimglist=true;
    this.bannerselect =index;
    this.showinfo("图片列表:",this.photodatalist,false,"确定","",function(){
       _this.bannerUrls[_this.bannerselect].bannerUrl=_this.bannerselectURL;
          _this.closeInfoModelP()
    });

  },addBanner:function () {


   var infolist=[];

   infolist.push(new Info("banner名:","photoname",""));
    infolist.push(new Info("banner图片地址:","srcUrl",""));
  var oktext="增加";
  var info="";
  var _this=this;
   this.showinfo("添加banner:",infolist,true,oktext,info,function () {

      let photo=new Photo();

      var photoname=infolist[0].value;
      var srcUrl=infolist[1].value;
      photo.photoName=photoname;
      photo.srcUrl=srcUrl;
      console.log("------new Date()--------");
      console.log(timestring);
      photo.uploadTime=getLocalTime(timestring,'YYYY-MM-DD hh:mm:ss');
      console.log("------uploadTime--------");
      console.log(photo.uploadTime);
      console.log(photo);

      let photodata = new FormData();
      photodata.append('bannerName',photo.photoName);
      photodata.append('bannerUrl',photo.srcUrl);

      
      httpmethods.addDataFuc(photodata,"/api/admin/banner/",function () {
        // 
        _this.showToastFuc("信息:","","添加banner成功!");
        _this.queryAllBanner();
        _this.closeInfoModelP();
      });


    });
    



  }
  ,addImg:function () {


   var infolist=[];

   infolist.push(new Info("图片名:","photoname",""));
    infolist.push(new Info("图片地址:","srcUrl",""));
  var oktext="增加";
  var info="";
  var _this=this;
   this.showinfo("添加图片:",infolist,true,oktext,info,function () {

      let photo=new Photo();

      var photoname=infolist[0].value;
      var srcUrl=infolist[1].value;
      photo.photoName=photoname;
      photo.srcUrl=srcUrl;
      console.log("------new Date()--------");
      console.log(timestring);
      photo.uploadTime=getLocalTime(timestring,'YYYY-MM-DD hh:mm:ss');
      console.log("------uploadTime--------");
      console.log(photo.uploadTime);
      console.log(photo);

      let photodata = new FormData();
      photodata.append('photoName',photo.photoName);
      photodata.append('srcUrl',photo.srcUrl);
      photodata.append('uploadTime',photo.uploadTime);
      
      httpmethods.addDataFuc(photodata,"/api/admin/photo/",function () {
        // 
        _this.showToastFuc("信息:","","添加图片成功!");
        _this.queryAllPhoto();
        _this.closeInfoModelP();
      });


    });
    


  },delimg:function (id){

    console.log("删除 "+id);
    let photo=new Photo();
    photo.id=id;
    var _this=this;
        _this.showinfo("删除图片:",[],false,"删除","是否删除该图片?",function () {

          httpmethods.delDataFuc(photo,"/api/admin/photo/",function () {
            _this.showToastFuc("信息:","","删除图片成功!");
            _this.queryAllPhoto();
            _this.closeInfoModelP();
          });

    });
  },deleteBanner:function (id){

 console.log("删除 "+id);
    let bannerdata = new FormData();
    bannerdata.id=id;
    var _this=this;
        _this.showinfo("删除banner:",[],false,"删除","是否删除该banner图片?",function () {

          httpmethods.delDataFuc(bannerdata,"/api/admin/banner/",function () {
            _this.showToastFuc("信息:","","删除banner图片成功!");
            _this.queryAllBanner();
            _this.closeInfoModelP();
          });

    });


  }
  },
  created: function () {
    

    console.log("加载所有图片");
      this.queryAllPhoto();
      this.queryAllBanner();
    },
  components: {
      Infomodal,
      ToastsContainerTopRight,

  }
}
</script>

<style>
 .blockstyle{
    width: 75px;height: 65px;
    display: inline-block;position: absolute;top:30%;left: 25%;
    text-align: center;
  }
  .show{
    display: inline-block;
  }
  .hide{
    display: none;
  }
</style>
