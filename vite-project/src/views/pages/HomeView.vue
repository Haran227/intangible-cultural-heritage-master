<template>
  <div class="absolute-top">
    <!-- 使用 el-carousel 组件，设置高度为 100vh -->
    <el-carousel height="100vh">
      <!-- 使用 v-for 循环遍历 carousel 数组，为每个元素创建一个 el-carousel-item 组件 -->
      <el-carousel-item v-for="item in carousel" :key="item">
        <!-- 显示图片，使用 :src 绑定 src 属性，:alt 绑定 alt 属性 -->
        <img :src="item.src" :alt="item.src">
      </el-carousel-item>
    </el-carousel>
    <!-- 使用自定义的 ChinaMap 组件 -->
    <China-map />
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import ChinaMap from "@/components/ChinaMap.vue";
import imperial_Palace from "@/assets/images/imperial_palace.jpg";
import Yungang_Grottoes from "@/assets/images/Yungang_Grottoes.jpg";
import The_Great_Wall from "@/assets/images/The_Great_Wall.jpg";
import Temple_of_Heaven from "@/assets/images/Temple_of_Heaven.jpg";

// 创建一个响应式的 carousel 数组，包含多个图片对象，每个对象包含 src 属性
const carousel = ref([
  {
    src: imperial_Palace
  }, {
    src: The_Great_Wall
  }, {
    src: Yungang_Grottoes
  }, {
    src: Temple_of_Heaven
  },
])

</script>

<style scoped>
  /* 这里可以添加 scoped 样式，仅应用于该组件内部元素 */
</style>