<template>
  <div
    class="modal fade show"
    id="modal-default"
    style="display: block; padding-right: 17px;"
    aria-modal="true"
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
          <div>
            <slot></slot>
          </div>
        </div>

        <div class="modal-footer justify-content-between">
          <button
            type="button"
            class="btn btn-default"
            data-dismiss="modal"
            @click="closeInfoModel"
          >{{closeText}}</button>

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
  name: 'Modal',
  props: {
    inputtitle: String,
    oktext: String,
    closeText: String
  },
  data: () => {
    return {
      visible: false
    }
  },
  methods: {
    closeInfoModel: function() {
      console.log('infomodal内 ---')

      this.$emit('close')
    },
    okmethod: function() {
      console.log('infomodal内 ---okmethod')

      this.$emit('ok')
    }
  },
  created: function() {
    console.log('组件创建成功!')
  },
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