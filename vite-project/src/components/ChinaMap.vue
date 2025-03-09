<template>
  <!-- 背景部分 -->
  <div class="w-100vw h-100vh" :style="backgroundStyle">
    <!-- 顶部标题栏 -->
    <div class="h-10vh">
      <div class="flex align-center justify-center line-h-10vh">
        <div class="iconfont icon-knot text-bold text-white padding-lr-xs"></div>
        <div class="ff text-bold text-white text-center text-df text-overflow-sub">中国文化遗产分布地图</div>
        <div class="iconfont icon-knot text-bold text-white padding-lr-xs"></div>
      </div>
    </div>

    <!-- 地图展示和信息展示区 -->
    <div class="h-90vh flex align-center justify-center">
      <!-- 地图区域 -->
      <div ref="chartContainer" class="w-50vw h-90vh"></div>
      
      <!-- 右侧文化信息展示 -->
      <div class="padding-sm w-25vw h-65vh text-white bg-black text-center">
        <div class="text-xs margin-top-xxxs text-overflow-sub">【 {{city}} 】</div>
        <div class="flex align-center justify-center border-bottom-da padding-xs margin-top-xs text-xxxs cursor">
        </div>

        <!-- 统计信息展示区 -->
        <div class="margin-top-xxs">
          <!-- 各类非物质文化遗产统计 -->
          <div class="statistic-container">
    <div class="square-container">
      <div class="square-item" v-for="(item, index) in list.slice(0, 6)" :key="index">
        <div class="square-content">
          <div class="text-lg text-bold ff-impact">{{ item.count }}</div>
          <div class="text-xxxxs margin-top-xxxs text-overflow-twice">{{ item.label }}</div>
        </div>
      </div>
    </div>
    
  </div>
          <!-- 数据说明 -->
          <div class="text-xxxs margin-top-sm fl line-h-20 text-overflow-twice">
            说明：数据来自国家文化和旅游行政主管部门公开信息。
          </div>

          <!-- 总计数据展示 -->
          <div class="fl w-fill flex align-center justify-center margin-top-xs">
            <div class="iconfont icon-clound text-xl"></div>
            <div class="text-xxs padding-lr-xs">总计: <span class="text-sm ff-impact text-bold-2">3964</span> 项</div>
            <div class="iconfont icon-clound text-xl"></div>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onBeforeUnmount, onMounted, ref } from "vue";
import * as echarts from "echarts";
import china from "@/assets/china.json";  // 引入地图数据
import map_background from "@/assets/images/map_background.jpg";
const backgroundStyle = ref({
  background: `url(${map_background}) no-repeat center/100% 100%`
});

// 城市和遗产数据的响应式变量
const city = ref("中国");
const list = ref([
  { label: '世界文化遗产', count: 32 },
  { label: '世界文化景观遗产', count: 5 },
  { label: '世界文化与自然双重遗产', count: 4 },
  { label: '世界自然遗产', count: 14 },
  { label: '全国重点文物保护单位', count: 2352 },
  { label: '国家级非物质文化遗产', count: 1557 },
]);

// 江西省地图数据
const mapData: any = china;

// 散点图数据：展示地标或特殊位置
const points = ref([
]);

const linesData = ref([]);  // 线路数据，后续可以添加
const planePath = "path://M1705.06,1318.313v-89.254..."; // 飞机路径SVG

// 用于初始化ECharts实例
const chartContainer = ref<HTMLElement | null>(null);
let chart: echarts.ECharts | null = null;

// 页面加载时初始化ECharts
onMounted(() => {
  chart = echarts.init(chartContainer.value!);
  initChart();  // 初始化图表
  addHoverEventListener();  // 添加鼠标悬停事件
});

// 页面卸载时销毁图表实例
onBeforeUnmount(() => {
  if (chart) {
    chart.dispose();
    chart = null;
  }
});

// 初始化图表，设置地图及散点图
function initChart() {
  echarts.registerMap("china", mapData);  // 注册地图
  const option = {
    backgroundColor: "transparent",  // 设置背景透明
    geo: {
      map: "china",  // 设置地图类型为中国
      zoom: 1.2, // 调整缩放比例，大于 1 表示放大，小于 1 表示缩小
      label: {
        normal: { show: true, textStyle: { color: "#000" } },
        emphasis: { textStyle: { color: "#000" } },
      },
      itemStyle: {
        normal: { borderColor: "#fff", borderWidth: 1, areaColor: { type: "radial", x: 0.5, y: 0.5, r: 0.8, colorStops: [{ offset: 0, color: "rgba(255,255,255,0.5)" }, { offset: 1, color: "rgba(255,255,255,0.5)" }] } },
        emphasis: { areaColor: "rgba(255,255,255,0.6)", borderWidth: 1 },
      },
    },
    tooltip: { trigger: "item", formatter: (params) => `地区名称: ${params.name}<br/>ID: ${params.dataIndex}` },
    series: [
      {
        type: "effectScatter",  // 散点图
        coordinateSystem: "geo",
        effectType: "ripple",
        showEffectOn: "render",
        rippleEffect: { period: 2, scale: 8, brushType: "stroke" },
        zlevel: 0.5,
        data: points.value,
      },
      {
        type: "lines",  // 线路图
        zlevel: 2,
        symbol: ["none", "arrow"],
        effect: { show: true, period: 6, trailLength: 0, symbol: planePath, symbolSize: 15 },
        lineStyle: { color: "#fff", width: 2.5, opacity: 0.6, curveness: 0.2 },
        data: linesData.value,
      },
    ],
  };

  if (chart) {
    chart.setOption(option);  // 设置图表配置项
  }
}

// 添加鼠标点击事件，展示具体文化遗产信息
import api from "@/api";
function addHoverEventListener() {
  if (chart) {
    chart.on("click", (params) => {
      if (params.name) {
        city.value = params.name;  // 更新城市
        api.home.mapCulture(params.name).then((res: any) => {
          list.value = res.data;  // 更新文化遗产统计数据
        });
      }
    });
  }
}
</script>

<style scoped>
/* 样式部分：设置各种颜色、布局等 */
.bg-brown { background-color: #b3a087; }
.bg-black { background-color: #9e8c73; }
.text-brown { color: #ffedcf; }
.h-fill { min-height: 84px; }
.h-fill-t { min-height: 32px!important; }
.text-overflow-sub {
  display: -webkit-box;
  -webkit-box-orient: vertical!important;
  -webkit-line-clamp: 1!important;
  overflow: hidden;
}
.statistic-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

.square-container {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 10px;
  width: 100%;
  margin-bottom: 10px;
}

.square-item {
  background-color: #b3a087;
  padding: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
}

.square-content {
  text-align: center;
}

.rectangle-item {
  background-color: #b3a087;
  padding: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  width: 100%;
}

.rectangle-content {
  text-align: center;
}


</style>