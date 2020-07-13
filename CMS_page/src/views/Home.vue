<template>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="index_view">
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
                <a href="#/index/home">首页</a>
              </li>
              <li class="breadcrumb-item active">本站数据</li>
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
          <NumberCard Count="44" cardName="文章访问量" classkey="warning"></NumberCard>
          <!-- ./col -->
          <NumberCard Count="65" cardName="访问人数" classkey="danger"></NumberCard>
          <!-- ./col -->

          <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
          <barChart
            chartTitle="文章访问量"
            subTitle="各类型文章访问量对比"
            chartlabel="总数据"
            :chartlabels="barChartlabels"
            :chartDatas="barChartDatas"
          ></barChart>
          <doughnutCharts
            chartTitle="浏览器使用占比"
            subTitle="浏览器使用率"
            chartlabel="总数据"
            :chartlabels="doughnutChartlabels"
            :chartDatas="doughnutChartdatas"
          ></doughnutCharts>
        </div>

        <div class="row">
          <zTable
            tableTitle="最后登录的用户"
            :datalist="userlist"
            :propList="userProps"
            :url="userUrl"
            pageAbled
            ref="userTable"
          >
            <template slot-scope="opt" slot="opt">
              <div>
                <button type="submit" class="btn btn-info" @click="queryUser(opt.item.id)">查看详细信息</button>
              </div>
            </template>
            <template slot-scope="role" slot="role">{{role.item.role==1?'管理员':'用户'}}</template>
          </zTable>

          <Modal
            inputtitle="提示："
            oktext="确认"
            closeText="关闭"
            ref="userinfo"
            @ok="updateUserData()"
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
                <span class="inputLable">角色</span>

                <select v-model="User.role" class="userinput">
                  <option value="0">管理员</option>
                  <option value="1">用户</option>
                </select>
              </div>
            </div>
          </Modal>
        </div>
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>

  <!-- /.content-wrapper -->
</template>

<script>
import httpmethods from '@/tools/http'

import Vue from 'vue'
import { updateUser, delUser, queryAllUserBypage, getUser } from '@/api/user'
import Modal from '@/components/ModalDialog/Modal.vue'

import doughnutCharts from '@/components/Charts/doughnutCharts.vue'
import barChart from '@/components/Charts/barChart.vue'
import NumberCard from '@/components/Card/NumberCard.vue'
import zTable from '@/components/Table/zTable.vue'
export default {
  name: 'Home',

  data() {
    return {
      userlist: [],
      showUserinfo: false,
      doughnutChartlabels: [
        'Chrome',
        'IE',
        'FireFox',
        'Safari',
        'Opera',
        'Navigator'
      ],
      doughnutChartdatas: [
        {
          data: [700, 500, 400, 600, 300, 100],
          backgroundColor: [
            '#f56954',
            '#00a65a',
            '#f39c12',
            '#00c0ef',
            '#3c8dbc',
            '#d2d6de'
          ]
        }
      ],
      barChartlabels: ['java', 'js', 'css', 'C#', 'unity', 'hadoop', 'hive'],
      barChartDatas: [28, 48, 40, 19, 86, 27, 90],
      userProps: [
        { name: 'id', label: '#' },
        { name: 'username', label: '用户名' },
        { name: 'role', label: '身份' },
        { name: 'opt', label: '操作' }
      ],
      // 模态框数据
      User: {},
      userUrl: '/api/admin/webUser/'
    }
  },
  methods: {
    queryUser: function(id) {
      var _this = this
      this.showUserinfo = true
      getUser(id).then(res => {
        console.log(res.data)
        _this.User = res.data
        _this.showUserinfo = true
      })
    },
    updateUserData() {
      updateUser(this.User, () => {
        this.$message({
          ToastTitle: '提示:',
          Toasttext: '用户数据更新完毕'
        })
        this.showUserinfo = false
        this.$refs.userTable.queryAllBypage(1)
      })
    }
  },
  created: function() {},
  mounted: function() {},
  components: {
    Modal,
    doughnutCharts,
    zTable,
    barChart,
    NumberCard
  }
}
</script>
<style scoped>
.content-wrapper {
  overflow: auto;
  height: 600px;
}
@keyframes chartjs-render-animation {
  from {
    opacity: 0.99;
  }
  to {
    opacity: 1;
  }
}
.chartjs-render-monitor {
  animation: chartjs-render-animation 1ms;
}
.chartjs-size-monitor,
.chartjs-size-monitor-expand,
.chartjs-size-monitor-shrink {
  position: absolute;
  direction: ltr;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  overflow: hidden;
  pointer-events: none;
  visibility: hidden;
  z-index: -1;
}
.chartjs-size-monitor-expand > div {
  position: absolute;
  width: 1000000px;
  height: 1000000px;
  left: 0;
  top: 0;
}

.chartjs-size-monitor-shrink > div {
  position: absolute;
  width: 200%;
  height: 200%;
  left: 0;
  top: 0;
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