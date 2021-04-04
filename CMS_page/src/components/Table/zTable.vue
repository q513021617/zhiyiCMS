<template>
  <div class="card" style="width: 100%;height: auto;">
    <div class="card-header">
      <h1 class="card-title" style="font-weight: bold;">{{tableTitle}}</h1>
    </div>
    <!-- /.card-header -->
    <div class="card-body">
      <table id="userlist" class="table table-bordered">
        <thead>
          <tr>
            <th
              :style="{width:pro.width}"
              v-for="pro,index in propList"
              :key="index+'label'"
            >{{pro.label}}</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="pageData.length<=0">
            <td colspan="4">暂时无数据信息</td>
          </tr>
          <tr v-for="item in pageData" v-bind:key="item.id">
            <td v-for="pro,index in propList" :key="index+'j'">
              <slot :name="pro.name" :item="item">{{item[pro.name]}}</slot>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <Pagehelper
      :tatolpage="tatolpage"
      :curpage="curpage"
      @select="getAllBypage"
      ref="pagehp"
      v-if="pageAbled"
    ></Pagehelper>
  </div>
</template>

<script>
import httpmethods from '@/tools/http'
import Pagehelper from '@/components/pagehelper.vue'
export default {
  props: {
    tableTitle: {
      type: String,
      default: ''
    },
    datalist: Array,
    propList: Array,
    url: {
      type: String,
      default: ''
    },
    pagesize: {
      type: Number,
      default: 20
    },
    pageAbled: {
      type: Boolean,
      default: false
    }
  },
  components: {
    Pagehelper
  },
  data() {
    return {
      tatolpage: 0,
      curpage: 1,
      pageData: []
    }
  },
  created() {
    console.log('created')
    if (this.url === '') {
      this.pageData = this.datalist.splice(0, this.pagesize)
      return
    }
    this.getAllBypage(1)
  },
  methods: {
    refresh: function() {
      this.getAllBypage(this.curpage)
    },
    getAllBypage: function(page) {
      console.log('queryAllBypage')
      var _this = this
      page = page - 1
      httpmethods.axios
        .get(this.url + page + '/' + this.pagesize, {})
        .then(function(data) {
          data = data.data
          console.log('data.content')
          console.log(data.totalPages)
          _this.pageData = data.content
          _this.tatolpage = data.totalPages
          _this.$refs.pagehp.refreshdata(_this.tatolpage)
          _this.$forceUpdate()
        })
        .catch(function(error) {
          console.log(error)
        })
    }
  }
}
</script>

<style>
</style>