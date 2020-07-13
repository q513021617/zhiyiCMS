<template>
  <div class="wrapper">
    <div id="commonnav" th:replace="admin/adminnav :: adminnav"></div>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" id="menumanager">
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
                <li class="breadcrumb-item active">菜单管理</li>
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
          <!-- Small boxes (Stat box) -->
          <div class="row">
            <NumberCard Count="56" cardName="注册人数" classkey="info"></NumberCard>
            <!-- ./col -->
            <NumberCard Count="53" cardName="登录人数" classkey="success"></NumberCard>
            <!-- ./col -->
            <NumberCard Count="65" cardName="访问人数" classkey="danger"></NumberCard>
            <!-- ./col -->
          </div>
          <!-- /.row -->
          <!-- Main row -->
          <div class="row">
            <button type="submit" class="btn btn-info" @click="addMenuShow" style="width:100%;">增加菜单</button>
            <zTable
              tableTitle="菜单列表"
              :propList="menuProps"
              :url="menuUrl"
              pageAbled
              ref="menuTable"
            >
              <template slot-scope="opt" slot="opt">
                <div>
                  <button type="submit" class="btn btn-info" @click="queryMenu(opt.item.id)">查看详细信息</button>
                  <button type="submit" class="btn btn-danger" @click="delAccount(opt.item.id)">删除菜单</button>
                </div>
              </template>
            </zTable>
          </div>
        </div>
        <!-- /.container-fluid -->
      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <Modal
      inputtitle="提示："
      oktext="确认"
      closeText="关闭"
      ref="Menuinfo"
      @ok="okMethod()"
      @close="showMenuinfo=!showMenuinfo"
      v-if="showMenuinfo"
    >
      <div class="userinfo">
        <div class="userinfoitem">
          <span class="inputLable">菜单英文名</span>
          <input class="userinput" v-model="Menu.enname" />
        </div>
        <div class="userinfoitem">
          <span class="inputLable">菜单名</span>
          <input class="userinput" v-model="Menu.name" />
        </div>

        <div class="userinfoitem">
          <span class="inputLable">url</span>
          <input class="userinput" v-model="Menu.url" />
        </div>
      </div>
    </Modal>
  </div>
</template>

<script>
import { addMenu, delMenu, updateMenu, getMenu } from '@/api/menu'
import httpmethods from '@/tools/http'
import zTable from '@/components/Table/zTable.vue'
import Modal from '@/components/ModalDialog/Modal.vue'
import Infomodal from '@/components/infomodal.vue'
import NumberCard from '@/components/Card/NumberCard.vue'
import Vue from 'vue'

export default {
  data() {
    return {
      menulist: [],

      buttonstatus: 'display: none;',

      // 模态框数据
      menuUrl: '/api/admin/permission/',
      menuProps: [
        { name: 'id', label: '#' },
        { name: 'name', label: '菜单名' },
        { name: 'enname', label: '菜单英文名' },
        { name: 'url', label: '菜单路由' },
        { name: 'opt', label: '操作' }
      ],
      Menu: {},
      showMenuinfo: false,
      isAdd: false
    }
  },
  methods: {
    okMethod: function() {
      if (this.isAdd) {
        addMenu(this.Menu).then(() => {
          this.$refs.menuTable.refresh()
        })
        this.showMenuinfo = false
        return
      }
      this.updateMenuData()
      this.showMenuinfo = false
    },
    updateMenuData() {
      updateMenu(this.Menu).then(() => {
        this.$message({
          ToastTitle: '提示:',
          Toasttext: '用户数据更新完毕'
        })
        this.showMenuinfo = false
        this.$refs.menuTable.refresh()
      })
    },
    queryMenu: function(id) {
      var _this = this
      this.showMenuinfo = true

      getMenu(id).then(res => {
        console.log(res.data)
        _this.Menu = res.data
        _this.showMenuinfo = true
      })
    },

    delAccount: function(id) {
      console.log('删除 ' + id)

      let Menudata = new FormData()
      Menudata.append('id', id)
      var _this = this

      let messageModal = this.$messageModal({
        inputtitle: '提示:',
        info: '是否删除该用户信息?',
        oktext: '确定',
        okFuc: () => {
          delMenu(id).then(result => {
            console.log('信息: ' + result)

            _this.$message({ ToastTitle: '提示:', Toasttext: '删除用户成功!' })
            messageModal.visible = false
            _this.$refs.menuTable.refresh()
          })
        }
      })
    },
    addMenuShow: function() {
      this.isAdd = true
      this.Menu = {}
      this.showMenuinfo = true
    }
  },
  created: function() {},
  components: {
    NumberCard,
    zTable,
    Modal
  }
}
</script>

<style scoped>
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
</style>
