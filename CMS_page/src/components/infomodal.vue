<template>
<!--  -->
      <div class="modal fade show"  id="modal-default" style="display: block; padding-right: 17px;" aria-modal="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">{{inputtitle}}</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="closeInfoModel">
                <span aria-hidden="true" >×</span>
              </button>
            </div>
            <div class="modal-body">
                <div v-if="!isinputlist && !isimglist">
                  <img :src="info" width='80%' height='80%' v-if="isimg"/>
                    <p>{{info}}</p>
                </div>
              <div v-if="isinputlist">

                <div v-for="item in infolist" v-bind:key="item.id">
                      {{item.tag}} <input :name="item.name" v-model="item.value"/>     


                </div>                  

                </div>

              <div v-if="isimglist">

                  <div class="row">


                          <div class="col-md-4" style="margin-top: 10px;" v-for="(item,index) in infolist" v-bind:key="item.id">
                            <!--background-image: url({{item.}})-->
                            <div class="position-relative p-3 bg-gray"  :style="'height: 180px;background-size: 100% 100%;backgroundImage:url(' + item.srcUrl + ')' ">
                                  <div class="ribbon-wrapper ribbon-xl">
                                        <div class="ribbon bg-secondary">     {{item.photoName}}    </div>
                                  </div>
                              <!--<i class="fas fa-trash-alt" style="display: none;"></i>-->
                                <button  @click="selectimg(item.srcUrl)"   class="blockstyle btn btn-danger show"  ><i class="fas fa-search-plus" ></i>选择</button>
                  
                            </div>  
                  
                            </div>
                    </div>
                </div>

            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-default" data-dismiss="modal" @click="closeInfoModel">Close</button>
              <button type="button" class="btn btn-primary" @click="okmethod">{{oktext}}</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
</template>

<script>



    export default {
        
        name:"infomodal",
   
        props:{
            inputtitle:String,
                isinputlist:Boolean,
                isimglist:Boolean,
                isimg:Boolean,
                info:String,
    
                infolist:Array,
                oktext:String,
           
        }
        ,methods:{
          parseDom:function(arg) {

　　  var objE = document.createElement("div");

　　  objE.innerHTML = arg;

　　 return objE.childNodes;

  },
            closeInfoModel:function () {
                console.log("infomodal内 ---");
                this.$emit('closeInfoModel',false);
            },
            okmethod:function() {
                console.log("infomodal内 ---okmethod");
                this.$emit('okmethod');
            },
            selectimg:function(url) {
                console.log("infomodal内 ---selectimg  "+url);
                // 
                this.$emit('geturlC',url);
            },
        },created:function(){
        
          this.infostring=this.parseDom(this.info);

        },mounted:function () {
            console.log("组件创建成功!");
        }
        
}
</script>

<style>
 .blockstyle{
    width: 75px;height: 65px;
    display: inline-block;position: absolute;top:30%;left: 25%;
    text-align: center;z-index:98;
  }
  .show{
    display: inline-block;
  }
  .hide{
    display: none;
  }
</style>