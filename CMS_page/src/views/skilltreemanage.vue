<template>
  <div class="wrapper">

  <div id="commonnav" th:replace="admin/adminnav :: adminnav"  >

  </div>
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
              <li class="breadcrumb-item"><a href="#">技能树管理</a></li>
              <li class="breadcrumb-item active">技能树</li>
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

              <p>技术点数</p>
            </div>
            <div class="icon">
              <i class="ion ion-bag"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
          </div>
          
        </div>
       </div>
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
          <h1>技能树</h1>
    
         
          </div>
     
          <div class="row">
            <div class="card" style="width: 100%;height: auto;">
              <div class="card-header">
                <h1 class="card-title" style="font-weight: bold;">技能列表</h1>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table class="table table-bordered">
                  <thead>                  
                    <tr>
                      <th style="width: 10px">#</th>
                      <th>技能名</th>
                      <th style="width:30%">父节点</th>
                      <th style="width:30%">操作</th>
                    </tr>
                  </thead>
                  <tbody>

                    <tr>
                      <td>1.</td>
                      <td>php</td>
                      <td>
                        编程语言
                      </td>
                      <td>
                        <button type="submit" class="btn btn-primary">修改</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                        <button type="submit" class="btn btn-info">查看</button>
                      </td>
                    </tr>
                  <tr>
                      <td>2.</td>
                      <td>Java</td>
                      <td>
                        编程语言
                      </td>
                      <td>
                        <button type="submit" class="btn btn-primary">修改</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                        <button type="submit" class="btn btn-info">查看</button>
                      </td>
                    </tr>
                    <tr>
                      <td>3.</td>
                      <td>JavaScript</td>
                      <td>
                        编程语言
                      </td>
                      <td>
                        <button type="submit" class="btn btn-primary">修改</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                        <button type="submit" class="btn btn-info">查看</button>
                      </td>
                    </tr>
                    <tr>
                      <td>4.</td>
                      <td>python</td>
                      <td>
                        编程语言
                      </td>
                      <td>
                        <button type="submit" class="btn btn-primary">修改</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                        <button type="submit" class="btn btn-info">查看</button>
                      </td>
                    </tr>
                    <tr>
                      <td>5.</td>
                      <td>go</td>
                      <td>
                        编程语言
                      </td>
                      <td>
                        <button type="submit" class="btn btn-primary">修改</button>
                        <button type="submit" class="btn btn-danger">删除</button>
                        <button type="submit" class="btn btn-info">查看</button>
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
  <!-- /.content-wrapper -->
  <div th:replace="admin/adminfooter :: myfooter"  ></div>

  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

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
