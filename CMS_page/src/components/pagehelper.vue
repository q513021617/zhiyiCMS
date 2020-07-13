
<template>
  <div class="card-footer clearfix">
    <ul class="pagination pagination-sm m-0 float-right">
      <li class="page-item">
        <a class="page-link" href="#" @click="prepage">«</a>
      </li>

      <li
        class="page-item"
        v-if="tatolpagedata<=5 "
        v-for="(index,pageitem) in tatolpagedata"
        v-bind:Key="index"
        :class="index==curpagedata?'active':''"
      >
        <a class="page-link" href="#" @click="querybypage(index)">{{index}}</a>
      </li>

      <li
        class="page-item"
        v-if=" index <= 2 && tatolpagedata>5 "
        v-for="(index,pageitem) in tatolpagedata"
        v-bind:Key="index"
        :class="index==curpagedata?'active':''"
      >
        <a class="page-link" href="#" @click="querybypage(index)">{{index}}</a>
      </li>

      <li
        class="page-item"
        v-if=" (index> 2 && index < tatolpagedata - 1) && tatolpage > 5 "
        v-for="(index,pageitem) in tatolpagedata"
        v-bind:Key="index"
        :class="index==curpagedata?'active':''"
      >
        <a
          href="#"
          :class="pageitem==curpagedata?'page-link':''"
          @click="querybypage(index)"
        >{{index==curpagedata?index:'.'}}</a>
      </li>

      <li
        class="page-item"
        v-if="index >= tatolpagedata -1  && tatolpagedata > 5 "
        v-for="(index,pageitem) in tatolpagedata"
        v-bind:Key="index"
        :class="index==curpagedata?'active':''"
      >
        <a class="page-link" href="#" @click="querybypage(index)">{{index}}</a>
      </li>

      <li class="page-item">
        <a class="page-link" href="#" @click="nextpage">»</a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'pagehelper',
  data() {
    return {
      tatolpagedata: 0,
      curpagedata: 0
    }
  },
  props: {
    tatolpage: Number,
    curpage: Number
  },
  methods: {
    prepage: function() {
      if (this.curpagedata <= 1) {
        return
      }
      this.curpagedata = this.curpagedata - 1
      this.querybypage(this.curpagedata)
    },
    nextpage: function() {
      if (this.curpagedata >= this.tatolpagedata) {
        this.curpagedata = this.tatolpagedata
        return
      }

      this.querybypage(this.curpagedata + 1)
    },
    refreshdata: function(data) {
      this.tatolpagedata = data
    },
    querybypage: function(num) {
      this.curpagedata = num

      // queryAllBypage();
      this.$emit('select', this.curpagedata)
      console.log(num)
    }
  },
  created: function() {
    this.tatolpagedata = this.tatolpage
    this.curpagedata = this.curpage
  },
  mounted: function() {
    console.log('pagehelper---组件创建成功!')
  }
}
</script>

<style>
</style>