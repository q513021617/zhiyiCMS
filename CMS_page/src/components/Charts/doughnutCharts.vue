<template>
  <div class="col-md-6">
    <h1>{{chartTitle}}</h1>
    <div class="card card-danger">
      <div class="card-header">
        <h3 class="card-title">{{subTitle}}</h3>

        <div class="card-tools">
          <button type="button" class="btn btn-tool" data-card-widget="collapse">
            <i class="fas fa-minus"></i>
          </button>
          <button type="button" class="btn btn-tool" data-card-widget="remove">
            <i class="fas fa-times"></i>
          </button>
        </div>
      </div>
      <div class="card-body">
        <div class="chartjs-size-monitor">
          <div class="chartjs-size-monitor-expand">
            <div class></div>
          </div>
          <div class="chartjs-size-monitor-shrink">
            <div class></div>
          </div>
        </div>
        <canvas
          ref="browerChart"
          id="browerChartID"
          style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%; display: block; width: 100%;"
          width="100%"
          height="250"
          class="chartjs-render-monitor"
        ></canvas>
      </div>
      <!-- /.card-body -->
    </div>
  </div>
</template>

<script>
import { doughnutCharts } from '@/api/cavas'
export default {
  props: {
    chartTitle: String,
    subTitle: String,
    chartlabel: String,
    chartlabels: Array,
    chartDatas: Array
  },
  mounted() {
    this.doughnutCharts()
  },
  methods: {
    doughnutCharts: function() {
      var browerChartCanvas = document.getElementById('browerChartID')

      var browerChartData = {
        labels: this.chartlabels,
        datasets: this.chartDatas
      }
      var browerChartOptions = {
        maintainAspectRatio: false,
        responsive: true
      }

      //Create pie or douhnut chart
      // You can switch between pie and douhnut using the method below.
      // 如果没有这一操作将不会显示图表信息
      var browerChart = new Chart(browerChartCanvas, {
        type: 'doughnut',
        data: browerChartData,
        options: browerChartOptions
      })
    }
  }
}
</script>

<style>
</style>