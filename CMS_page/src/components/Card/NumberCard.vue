<template>
  <div class="col-lg-3 col-6">
    <!-- small box -->
    <div class="small-box" :class="classArr[classkey]">
      <div class="inner">
        <h3>{{Count}}</h3>

        <p>{{cardName}}</p>
      </div>
      <div class="icon">
        <i class="ion ion-bag"></i>
      </div>
      <a href="#" class="small-box-footer">
        More info
        <i class="fas fa-arrow-circle-right"></i>
      </a>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    Count: String,
    cardName: String,
    classkey: String
  },
  data: function() {
    return {
      classArr: {
        info: 'bg-info',
        success: 'bg-success',
        warning: 'bg-warning',
        danger: 'bg-danger'
      }
    }
  }
}
</script>

<style>
</style>