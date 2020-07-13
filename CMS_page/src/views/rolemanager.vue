<template>
  <div class="wrapper">
    <div id="commonnav" th:replace="admin/adminnav :: adminnav"></div>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" id="rolemanager">
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
                <li class="breadcrumb-item active">角色管理</li>
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
            <button type="submit" class="btn btn-info" @click="addRoleShow" style="width:100%;">增加角色</button>
            <zTable
              tableTitle="角色列表"
              :propList="roleProps"
              :url="roleUrl"
              pageAbled
              ref="menuTable"
            >
              <template slot-scope="opt" slot="opt">
                <div>
                  <button type="submit" class="btn btn-info" @click="queryRole(opt.item.id)">查看详细信息</button>
                  <button type="submit" class="btn btn-danger" @click="delRole(opt.item.id)">删除角色</button>
                </div>
              </template>
            </zTable>
          </div>
        </div>
        <!-- /.container-fluid -->
      </section>
      <!-- /.content -->
    </div>
    <Modal
      inputtitle="提示："
      oktext="确认"
      closeText="关闭"
      ref="Menuinfo"
      @ok="okMethod()"
      @close="showRolemodel=!showRolemodel"
      v-if="showRolemodel"
    >
      <div class="userinfo">
        <div class="userinfoitem">
          <span class="inputLable">角色英文名</span>
          <input class="userinput" v-model="Role.enname" />
        </div>
        <div class="userinfoitem">
          <span class="inputLable">角色名</span>
          <input class="userinput" v-model="Role.name" />
        </div>
      </div>
    </Modal>
  </div>
  <!-- ./wrapper -->
</template>

<script>
import { addRole, delRole, updateRole, getRole } from '@/api/role'
import httpmethods from '@/tools/http'
import zTable from '@/components/Table/zTable.vue'
import Modal from '@/components/ModalDialog/Modal.vue'
import Infomodal from '@/components/infomodal.vue'
import NumberCard from '@/components/Card/NumberCard.vue'
import Vue from 'vue'

export default {
  name: 'rolemanager',
  data() {
    return {
      userCount: 52,
      rolelist: [],
      roleProps: [
        { name: 'id', label: '#' },
        { name: 'name', label: '角色名' },
        { name: 'enname', label: '英文角色名' },
        { name: 'opt', label: '操作' }
      ],
      Role: {},
      roleUrl: '/api/admin/role/',
      isAdd: false,
      buttonstatus: 'display: none;',
      ind: '',
      // 模态框数据

      showRolemodel: false
    }
  },
  methods: {
    queryRole(id) {
      getRole(id).then(res => {
        this.Role = res.data
        this.showRolemodel = true
      })
    },
    delRole(id) {
      delRole(id).then(() => {
        this.$message({ ToastTitle: '信息', Toasttext: '删除角色成功' })
      })
    },
    okMethod() {
      if (this.isAdd) {
        addRole(this.Role).then(res => {
          console.log(res)
          this.showRolemodel = false
        })
        return
      }
      updateRole(this.Role).then(res => {
        console.log(res)
        this.showRolemodel = false
      })
    },
    addRoleShow: function() {
      this.isAdd = true
      this.Role = {}
      this.showRolemodel = true
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

<style>
</style>