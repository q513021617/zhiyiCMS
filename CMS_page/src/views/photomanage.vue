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
            </div>
            <!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item">
                  <a href="#">首页</a>
                </li>
                <li class="breadcrumb-item active">图片管理</li>
              </ol>
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
      </div>
      <!-- /.content-header -->

      <!-- Main content -->
      <section class="content">
        <div class="container-fluid">
          <div class="row">
            <NumberCard :Count="photoCount+''" cardName="图片数" classkey="info"></NumberCard>

            <!-- ./col -->
          </div>
          <!-- /.row -->
          <!-- Main row -->

          <section class="content">
            <div class="container-fluid">
              <div class="row" style="position: relative;top: 20px;">
                <div class="col-12">
                  <div id="phtotlist" class="card card-primary">
                    <!--    style="position: relative;left: 20px;"      \width: 150px;-->
                    <button
                      class="btn btn-danger"
                      data-toggle="modal"
                      data-target="#infomodal"
                      @click="addImg()"
                    >增加图片</button>
                    <div class="card-body">
                      <div class="row">
                        <div
                          class="col-md-4"
                          style="margin-top: 10px;"
                          v-for="(item,index) in photodatalist"
                          v-bind:key="item.id"
                        >
                          <!--background-image: url({{item.}})-->
                          <div
                            class="position-relative p-3 bg-gray"
                            @mouseover="mousehoverdiv(index)"
                            @mouseout="mouseoutdiv(index)"
                            v-bind:key="item.id+datakey"
                            :style="'height: 180px;background-size: 100% 100%;backgroundImage:url(' + item.srcUrl + ')' "
                          >
                            <div class="ribbon-wrapper ribbon-xl">
                              <div class="ribbon bg-secondary">{{item.photoName}}</div>
                            </div>
                            <!--<i class="fas fa-trash-alt" style="display: none;"></i>-->
                            <button
                              @click="queryimg(item.id)"
                              class="blockstyle btn btn-danger"
                              :class="[ind==index? 'show':'hide']"
                            >
                              <i class="fas fa-search-plus"></i>查看
                            </button>
                            <button
                              @click="delimg(item.id)"
                              style="left: 55%;z-index: 999;"
                              :class="[ind==index? 'show':'hide']"
                              class="blockstyle btn btn-danger"
                              data-toggle="modal"
                              data-target="#infomodal"
                            >删除</button>
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
        </div>
        <!-- /.container-fluid -->
      </section>
      <!-- /.content -->
      <Modal
        inputtitle="提示："
        oktext="确认"
        closeText="关闭"
        ref="userinfo"
        @ok="okMethod()"
        @close="showmodel=!showmodel"
        v-if="showmodel"
      >
        <div class="userinfo">
          <div class="userinfoitem">
            <span class="inputLable">图片地址</span>
            <input class="userinput" v-model="Image.srcUrl" />
          </div>
          <div class="userinfoitem">
            <span class="inputLable">图片名</span>
            <input class="userinput" v-model="Image.photoName" />
          </div>
          <div class="userinfoitem">
            <span class="inputLable">上传图片</span>
            <input class="userinput" type="file" multiple="multiplt" @change="getFile($event)" />
          </div>
        </div>
      </Modal>

      <Modal
        inputtitle="提示："
        oktext="确认"
        closeText="关闭"
        @ok="showImagemodel=!showImagemodel"
        @close="showImagemodel=!showImagemodel"
        v-if="showImagemodel"
      >
        <div class="userinfo">
          <div class="userinfoitem">
            <img :src="currentImage.srcUrl" alt srcset width="100%" height="300px" />
          </div>
          <div class="userinfoitem">
            <span class="inputLable">图片名</span>
            {{currentImage.photoName}}
          </div>
        </div>
      </Modal>
      <!-- /.content-wrapper -->
    </div>
  </div>
</template>

<script>
import {
  updatePhoto,
  delPhoto,
  addPhoto,
  getPhoto,
  uploadfile
} from '@/api/photo'
import httpmethods from '@/tools/http'
import Pagehelper from '@/components/pagehelper.vue'
import Modal from '@/components/ModalDialog/Modal.vue'
import zTable from '@/components/Table/zTable.vue'
import NumberCard from '@/components/Card/NumberCard.vue'
import Vue from 'vue'
// import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'

export default {
  data() {
    return {
      photoCount: 52,
      photodatalist: [],
      showimgurl: '',
      buttonstatus: 'display: none;',
      ind: '',
      datakey: 99,
      // 模态框数据
      Image: {},
      currentImage: {},
      showImagemodel: false,
      isAdd: false,
      showmodel: false
    }
  },

  methods: {
    queryAllPhoto: function() {
      var _this = this

      $.get('/api/admin/photo/', function(data) {
        console.log(data)

        if (data.length > 0) {
          _this.photodatalist = data
        }
        _this.$forceUpdate()
      })
    },
    getFile: function(event) {
      var file = event.target.files

      uploadfile(file[0]).then(res => {
        console.log(res.data.filepath)
        this.Image.srcUrl = res.data.filepath
        this.$forceUpdate()
      })
    },
    mousehoverdiv: function(index) {
      console.log('---mousehoverdiv----   ' + index)
      this.ind = index
    },
    mouseoutdiv: function() {
      this.ind = ''
    },
    queryimg: function(id) {
      this.currentImage = this.photodatalist.filter(item => {
        return item.id == id
      })
      this.currentImage = this.currentImage[0]
      this.showImagemodel = true
    },

    okMethod: function() {
      if (this.addImg) {
        addPhoto(this.Image).then(res => {
          console.log(res.data)
          this.$message({ ToastTitle: '提示:', Toasttext: '图片添加完毕' })
          this.showmodel = false
          this.addImg = false
          this.$router.go(0)
          this.$forceUpdate()
        })
        return
      }
      updatePhoto(this.Image).then(res => {
        console.log(res.data)
        this.$message({ ToastTitle: '提示:', Toasttext: '图片更新完毕' })
        this.$forceUpdate()
      })
    },
    addImg: function() {
      this.showmodel = true
      this.addImg = true
      this.Image = {}
    },
    delimg: function(id) {
      console.log('删除 ' + id)
      delPhoto(id).then(res => {
        this.$message({ ToastTitle: '提示:', Toasttext: '图片删除完毕' })
        this.$router.go(0)
        this.$forceUpdate()
      })
    }
  },
  created: function() {
    console.log('加载所有图片')
    this.queryAllPhoto()
  },
  components: {
    Modal,
    zTable,
    Pagehelper,
    NumberCard
  }
}
</script>

<style>
.blockstyle {
  width: 75px;
  height: 65px;
  display: inline-block;
  position: absolute;
  top: 30%;
  left: 25%;
  text-align: center;
}
.show {
  display: inline-block;
}
.hide {
  display: none;
}
.content-wrapper {
  overflow: auto;
  height: 600px;
}
.userinfo {
  display: flex;
  width: 100%;
  flex-direction: column;
  align-items: center;
}
.userinfoitem {
  display: flex;
  width: 80%;
  flex-direction: row;
  margin-top: 1rem;
}
.sex {
  width: 6rem;
  display: flex;
  justify-content: center;
  text-align: center;
}
.inputLable {
  width: 20%;
}
.userinput {
  width: 60%;
}

/deep/ .modal-content {
  width: 42rem;
}
</style>
