<template>
  <div class="index-9 flex text-sm fixed-top-right padding-tb-xs border margin-top-sm margin-lr-lg"
       :class="notifyType?'bg-white':'bg-red'">
    <!-- 显示通知消息 -->
    <div class="padding-lr-xl">{{ msg }}</div>
    <!-- 关闭按钮 -->
    <div class="padding-lr-sm cursor hover" @click="closeNotify">×</div>
  </div>
</template>

<script setup lang="ts">
import {defineProps} from 'vue';

// 定义组件的 props，msg 表示通知消息，notifyType 表示通知的类型
interface Props {
  msg?: string;
  notifyType?: boolean;
  closeNotify?: Function;
}

defineProps<Props>();
</script>

<style scoped>
/* 样式空白，等待具体的需求 */
</style>
