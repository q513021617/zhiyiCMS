<template>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="usermanager">
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
              <li class="breadcrumb-item active">用户管理</li>
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
        </div>
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
          <button type="submit" class="btn btn-info" @click="addUserShow" style="width:100%;">增加用户</button>
          <zTable tableTitle="用户列表" :propList="userProps" :url="userUrl" pageAbled ref="userTable">
            <template slot-scope="opt" slot="opt">
              <div>
                <button type="submit" class="btn btn-info" @click="queryUser(opt.item.id)">查看详细信息</button>
                <button type="submit" class="btn btn-danger" @click="delAccount(opt.item.id)">删除用户</button>
              </div>
            </template>
            <template slot-scope="role" slot="role">{{role.item.role==1?'管理员':'用户'}}</template>
          </zTable>
        </div>
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
      @close="showUserinfo=!showUserinfo"
      v-if="showUserinfo"
    >
      <div class="userinfo">
        <div class="userinfoitem">
          <span class="inputLable">用户名</span>
          <input class="userinput" v-model="User.username" />
        </div>
        <div class="userinfoitem">
          <span class="inputLable">密码</span>
          <input class="userinput" v-model="User.password" />
        </div>
        <div class="userinfoitem">
          <span class="inputLable">性别</span>

          <select v-model="User.sex" class="sex">
            <option value="0">男</option>
            <option value="1">女</option>
          </select>
        </div>
        <div class="userinfoitem">
          <span class="inputLable">邮箱</span>
          <input class="userinput" v-model="User.email" />
        </div>
        <div class="userinfoitem">
          <span class="inputLable">电话</span>
          <input class="userinput" v-model="User.phone" />
        </div>
        <div class="userinfoitem">
          <span class="inputLable">角色</span>
          <select v-model="User.role" class="userinput">
            <option :value="role.id" v-for="role in rolelist" :key="role.id">{{role.name}}</option>
          </select>
        </div>
      </div>
    </Modal>
  </div>
  <!-- /.content-wrapper -->
</template>

<script>
import { updateUser, delUser, addUser, getUser } from '@/api/user'
import { getRoleBypPage } from '@/api/role'

import httpmethods from '@/tools/http'
import Modal from '@/components/ModalDialog/Modal.vue'
import zTable from '@/components/Table/zTable.vue'
import NumberCard from '@/components/Card/NumberCard.vue'
import Vue from 'vue'
// import ToastsContainerTopRight from '@/components/toastsContainerTopRight.vue'
import Pagehelper from '@/components/pagehelper.vue'
export default {
  name: 'usermanager',
  data() {
    return {
      userCount: 52,
      rolelist: [],
      userProps: [
        { name: 'id', label: '#' },
        { name: 'username', label: '用户名' },
        { name: 'role', label: '身份' },
        { name: 'phone', label: '电话' },
        { name: 'email', label: '电子邮件' },
        { name: 'opt', label: '操作' }
      ],
      userUrl: '/api/admin/webUser/',
      buttonstatus: 'display: none;',

      User: {},
      showUserinfo: false,

      isAdd: false,

      pagesize: 5,
      tatolpage: 5,
      curpage: 1
    }
  },
  methods: {
    okMethod: function() {
      if (this.isAdd) {
        addUser(this.User).then(() => {
          this.$refs.userTable.refresh()
        })
        this.showUserinfo = false
        return
      }
      this.updateUserData()
      this.showUserinfo = false
    },
    updateUserData() {
      updateUser(this.User).then(() => {
        this.$message({
          ToastTitle: '提示:',
          Toasttext: '用户数据更新完毕'
        })
        this.showUserinfo = false
        this.$refs.userTable.refresh()
      })
    },
    queryUser: function(id) {
      var _this = this
      this.showUserinfo = true

      getUser(id).then(res => {
        console.log(res.data)
        _this.User = res.data
        _this.showUserinfo = true
      })
    },

    delAccount: function(id) {
      console.log('删除 ' + id)

      let userdata = new FormData()
      userdata.append('id', id)
      var _this = this

      let messageModal = this.$messageModal({
        inputtitle: '提示:',
        info: '是否删除该用户信息?',
        oktext: '确定',
        okFuc: () => {
          delUser(id).then(result => {
            console.log('信息: ' + result)

            _this.$message({ ToastTitle: '提示:', Toasttext: '删除用户成功!' })
            messageModal.visible = false
            _this.$refs.userTable.refresh()
          })
        }
      })
    },

    addUserShow: function() {
      this.isAdd = true
      this.showUserinfo = true
    }
  },
  created: function() {
    getRoleBypPage().then(res => {
      this.rolelist = res.data.content
    })
  },
  components: {
    Modal,
    zTable,
    Pagehelper,
    NumberCard
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