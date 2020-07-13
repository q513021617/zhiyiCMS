<template>
  <router-view></router-view>
</template>

<script>
export default {
  created() {},
  mounted() {
    let el = document.getElementsByClassName('page')
    // console.log(el)
    let height = window.screen.height
    for (const key in el) {
      const element = el[key]
      if (element.style === undefined) {
        return
      }
      console.log(element)
      element.style.height = '100vh'
    }
  }
}
</script>

<style>
.page {
  position: fixed;
  width: 100%;
  height: auto;
  overflow: auto;
}
</style>