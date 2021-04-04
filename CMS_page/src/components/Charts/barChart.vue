<template>
  <div class="col-md-6">
    <h1>{{chartTitle}}</h1>
    <div class="card card-success">
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
        <div class="chart">
          <div class="chartjs-size-monitor">
            <div class="chartjs-size-monitor-expand">
              <div class></div>
            </div>
            <div class="chartjs-size-monitor-shrink">
              <div class></div>
            </div>
          </div>
          <canvas
            ref="barChart"
            id="barChart"
            style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%; display: block; width: 100%;"
            width="100%"
            height="250"
            class="chartjs-render-monitor"
          ></canvas>
        </div>
      </div>
      <!-- /.card-body -->
    </div>
  </div>
</template>

<script>
export default {
  props: {
    chartTitle: String,
    subTitle: String,
    chartlabel: String,
    chartlabels: Array,
    chartDatas: Array
  },
  methods: {
    barChartFuc: function() {
      // 条状图表

      var barChartCanvas = $('#barChart')
        .get(0)
        .getContext('2d')
      console.log(barChartCanvas)
      var barChartData = {
        labels: this.chartlabels,
        datasets: [
          {
            label: this.chartlabel,
            backgroundColor: 'rgba(60,141,188,0.9)',
            borderColor: 'rgba(60,141,188,0.8)',
            pointRadius: false,
            pointColor: '#3b8bba',
            pointStrokeColor: 'rgba(60,141,188,1)',
            pointHighlightFill: '#fff',
            pointHighlightStroke: 'rgba(60,141,188,1)',
            data: this.chartDatas
          }
        ]
      }

      var barChartOptions = {
        responsive: true,
        maintainAspectRatio: false,
        datasetFill: false
      }

      var barChart = new Chart(barChartCanvas, {
        type: 'bar',
        data: barChartData,
        options: barChartOptions
      })
    }
  },
  mounted() {
    this.barChartFuc()
  }
}
</script>

<style>
</style>