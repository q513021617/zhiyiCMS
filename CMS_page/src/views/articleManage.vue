<template>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
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
              <li class="breadcrumb-item active">文章管理</li>
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
          <NumberCard Count="156" cardName="文章数" classkey="info"></NumberCard>
          <!-- ./col -->
          <NumberCard Count="156" cardName="文章数" classkey="success"></NumberCard>
          <!-- ./col -->

          <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->

        <div class="row"></div>
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
</template>

<script>
import Modal from '@/components/ModalDialog/Modal.vue'
import zTable from '@/components/Table/zTable.vue'
import NumberCard from '@/components/Card/NumberCard.vue'
export default {
  data() {
    return {
      articleProps: [],
      articleUrl: ''
    }
  },
  methods: {},
  components: {
    Modal,
    zTable,
    NumberCard
  }
}
</script>

<style>
</style>
