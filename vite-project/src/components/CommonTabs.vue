<template>
  <div class="main" style="margin-top: 141px">
    <!-- 显示路径 -->
    <div class="flex bg-eee padding">
      <div class="padding-xxs text-60 cursor text-red-hover">首页</div>
      <div class="padding-xxs text-60 cursor text-red-hover">></div>
      <div class="padding-xxs text-60 cursor text-red-hover">{{ router.currentRoute.value.name }}</div>
    </div>

    <!-- 显示当前页面标题 -->
    <div class="flex align-center justify-center margin-top-xl text-lg">
      <div class="iconfont icon-tesexiaozhen text-lg"></div>
      <div class="ff text-bold text-black padding-lr-xs">{{ router.currentRoute.value.name }}</div>
      <div class="iconfont icon-tesexiaozhen  text-lg"></div>
    </div>

    <!-- 分隔线 -->
    <div class="iconfont icon--bright reflect-right w-50 border-bottom-c text-c1" style="height: 12px"></div>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import router from "@/router";
import {index} from "@/stores";

// 在页面加载时，更新选中的菜单项
const activeLabel = ref("");
onMounted(() => {
  index().changeSelectedKeys(router.currentRoute.value.fullPath)
})

// 菜单项
const menu = ref([
  {label: '首页', path: '/home'},
  {label: '机构', path: '/institution'},
  {label: '政策', path: '/policy'},
  {label: '资讯', path: '/message'},
  {label: '清单', path: '/detailed'},
  {label: '资源', path: '/assets'},
  {label: '3D展示', path: '/3Dshow', children: [{label: "论坛", path: ""}, {label: "调研", path: ""}]},
  {label: '百科', path: '/encyclopedia', children: [{label: "申报指南", path: ""}, {label: "百叶窗", path: ""}]},
])
</script>

<style scoped>
/* 样式空白，等待具体的需求 */
</style>
