<template>
  <!--  -->
  <div
    class="modal fade"
    :class="visible?'show':'hide'"
    id="modal-default"
    style="display: block; padding-right: 17px;"
    :aria-modal="visible?'true':'false'"
    v-if="visible"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">{{inputtitle}}</h4>
          <button
            type="button"
            class="close"
            data-dismiss="modal"
            aria-label="Close"
            @click="closeInfoModel"
          >
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">
          <p>{{info}}</p>
        </div>
        <div class="modal-footer justify-content-between">
          <button
            type="button"
            class="btn btn-default"
            data-dismiss="modal"
            @click="closeInfoModel"
          >关闭</button>
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
  name: 'infomodal',
  data() {
    return {
      inputtitle: '',
      info: '',
      oktext: '',
      visible: false,
      okFuc: () => {},
      closeFuc: () => {}
    }
  },
  methods: {
    closeInfoModel: function() {
      console.log('infomodal内 ---')
      this.visible = false
      this.$forceUpdate()
      this.closeFuc()
    },
    okmethod: function() {
      this.okFuc()
      console.log('infomodal内 ---okmethod')
    }
  },
  created: function() {},
  mounted: function() {
    console.log('组件创建成功!')
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
  z-index: 98;
}
.show {
  display: inline-block;
}
.hide {
  display: none;
}
</style>