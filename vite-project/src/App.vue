<template>
  <!-- <RouterView /> 是 Vue Router 的占位符，显示当前匹配的路由组件 -->
  <RouterView/>
</template>

<script setup lang="ts">
  // 引入 Vue Router 中的 RouterView 组件，它是动态加载当前页面的占位符
  import { RouterView } from "vue-router";
</script>

<style>
/* 定义一些根级别的 CSS 变量，方便在后续样式中使用 */
:root {
  --line-h: 56px; /* 行高 */
  --border-h: 4px; /* 边框高度 */
}

/* 设置整个 HTML 和 body 的样式，使其充满整个页面 */
.html, .body {
  width: 100vw; /* 视口宽度 */
  height: 100vh; /* 视口高度 */
  font-family: "Droid Sans Mono Slashed", serif; /* 设置字体 */
}

/* 定义主容器的样式，设置背景颜色和内部边距 */
.main {
  width: calc(100vw - 0px); /* 使用视口宽度计算 */
  height: auto; /* 高度自动适应内容 */
  min-height: calc(100vh - 460px); /* 最小高度适应 */
  padding: 0 5vw; /* 给主容器添加内边距 */
  background-color: #eee; /* 背景色 */
  overflow: hidden; /* 防止内容溢出 */
}

/* 重置所有元素的外边距和内边距，并统一使用 box-sizing */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif; /* 设置统一的字体 */
}

/* 设置图片的宽高填充模式 */
img {
  width: 100%;
  height: 100%;
}

/* 去除链接的下划线 */
a {
  text-decoration: none;
}
</style>
