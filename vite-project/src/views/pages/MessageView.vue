<template>
  <div class="main">
    <div class="w-fill h-50vh flex align-center margin-top-xl">
      <div class="w-50 h-fill bg-white">
        <img :src="message_photo" alt="" class="w-fill h-fill">
      </div>
      <div class="w-50 h-fill bg-brown" :style="{ backgroundImage: `url(${message_backgroung})`, backgroundRepeat: 'no-repeat', backgroundPosition: 'center', backgroundSize: '100% 100%' }">
        <div class="margin-xl padding-bottom-xs line-h-40 border-bottom-da">
          <div class="text-overflow-twice cursor">习近平：加强文化遗产保护传承 弘扬中华优秀传统文化</div>
          <div class="text-overflow-twice cursor">文化中国行｜烟火里的“非遗中国年”，热气腾腾蒸蒸日上</div>
          <div class="text-overflow-twice cursor">推动滇缅公路进入中国世界文化遗产预备名单</div>
          <div class="text-overflow-twice cursor">大运河文化遗产保护面临的挑战与应对策略</div>
          <div class="text-overflow-twice cursor">专家：文化遗产保护要以人民为中心</div>
          <div class="text-overflow-twice cursor">看中国加入《保护非物质文化遗产公约》20年</div>
          <div class="text-overflow-twice cursor">中国—东盟文化遗产主题对话在南宁举行</div>
        </div>
      </div>
    </div>
  </div>
</template>


<script setup lang="ts">
import message_photo from '@/assets/images/message_photo.jpg';
import message_backgroung from '@/assets/images/message_backgroung.jpg';

</script>

<style scoped>
.border-bottom-da {
  border-bottom: #9f8881 1px dashed;
}

</style>
