<template>
  <div id="toastsContainerTopRight" class="toasts-top-right fixed" v-if="visible">
    <!--show-->
    <div class="toast bg-success fade show" role="alert" aria-live="assertive" aria-atomic="true">
      <div class="toast-header">
        <strong class="mr-auto">{{ToastTitle}}</strong>
        <small>{{ToastSubtitle}}</small>
        <button
          data-dismiss="toast"
          type="button"
          class="ml-2 mb-1 close"
          aria-label="Close"
          @click="visible=!visible"
        >
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="toast-body">{{Toasttext}}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'toastsContainerTopRight',
  data() {
    return {
      ToastTitle: '',
      ToastSubtitle: '',
      Toasttext: '',
      visible: false,
      duration: 1000
    }
  },
  methods: {
    closeInfoModel: function() {
      console.log('infomodal内 ---')
      this.$emit('closeInfoToast')
    }
  }
}
</script>

<style>
</style>