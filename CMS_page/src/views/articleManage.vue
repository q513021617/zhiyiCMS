<template>
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">本站数据</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">首页</a></li>
              <li class="breadcrumb-item active">文章管理</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
        <div class="row">
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3>150</h3>

                <p>文章数</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag"></i>
              </div>
              <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>.
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-success">
              <div class="inner">
                <h3>53</h3>

                <p>文章访问量</p>
              </div>
              <div class="icon">
                <i class="ion ion-stats-bars"></i>
              </div>
              <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
       

        
          <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->

          <div class="row">
            <div class="card" style="width: 100%;height: auto;">
              <div class="card-header">
                <h1 class="card-title" style="font-weight: bold;">文章列表</h1>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table class="table table-bordered">
                  <thead>                  
                    <tr>
                      <th style="width: 10px">#</th>
                      <th>文章名</th>
                      <th style="width:10%">类别</th>
                      <th style="width:50%">操作</th>
                    </tr>
                  </thead>
                  <tbody>

                    <tr>
                      <td>1.</td>
                      <td>css技术分享第一篇</td>
                      <td>
                       css
                      </td>
                      <td>
              
                        
                        <button type="submit" class="btn btn-info">查看</button>
                        <button type="submit" class="btn btn-info">编辑</button>
                        <button type="submit" class="btn btn-info">分享</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                      </td>
                    </tr>
                  <tr>
                      <td>2.</td>
                      <td>css技术分享第一篇</td>
                      <td>
                        java
                      </td>
                      <td>
              
                        <button type="submit" class="btn btn-info">查看</button>
                        <button type="submit" class="btn btn-info">编辑</button>
                        <button type="submit" class="btn btn-info">分享</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                      </td>
                    </tr>
                    <tr>
                      <td>3.</td>
                     <td>css技术分享第一篇</td>
                      <td>
                        go
                      </td>
                      <td>
              
                        <button type="submit" class="btn btn-info">查看</button>
                        <button type="submit" class="btn btn-info">编辑</button>
                        <button type="submit" class="btn btn-info">分享</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                      </td>
                    </tr>
        
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                  <li class="page-item"><a class="page-link" href="#">«</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">»</a></li>
                </ul>
              </div>
            </div>
  
            </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>


</template>

<script>
export default {
  data() {
    return {

    }
  },
  methods: {

  },
  components: {

  }
}
</script>

<style>

</style>
