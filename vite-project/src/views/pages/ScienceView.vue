<template>
  <div class="main">
    <!--    1     -->
    <div class="flex align-center justify-center margin-top-xl text-df">
      <div class="iconfont icon-knot cursor"></div>
      <div class="text-center text-black ff text-bold padding-lr-xs cursor">论坛</div>
      <div class="iconfont icon-knot cursor"></div>
    </div>
    <!--    2     -->
    <div class="h-300px bg-white padding-tb-lg margin-top-xl flex" v-for="item in forum">
      <div class="w-fill h-fill margin-lr-xl flex-sub">
        <img :src="item.pic" :alt="item.pic" class="w-fill h-fill">
      </div>
      <div class="w-fill h-fill bg-white padding-right-xl flex-sub-twice">
        <div class="hover cursor">
          <div class="padding-top-xs">{{ item.title }}</div>
          <div class="margin-tb-xs padding-tb-xs text-xxs border-bottom-da">{{ item.date }}</div>
        </div>
        <div class="text-xxs line-h-20 text-overflow-treble">{{ item.detail }}</div>
        <div class="fl w-fill flex align-center justify-start margin-top text-xxs hover">
          <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
          <div class="text-center ff text-bold padding-lr-xs cursor ">查看更多</div>
          <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
        </div>
      </div>
    </div>
    <!--    3     -->
    <div class="flex align-center justify-center margin-top-xl text-df">
      <div class="iconfont icon-knot cursor"></div>
      <div class="text-center text-black ff text-bold padding-lr-xs cursor">调研</div>
      <div class="iconfont icon-knot cursor"></div>
    </div>

    <!--    4     -->
    <div class="w-fill bg-white padding-lg margin-top-xl h-300px" v-for="item in survey">
      <div class="hover cursor">
        <div class="padding-top-xs">{{ item.title }}</div>
        <div class="padding-top-xs">{{ item.intro }}</div>
        <div class="margin-tb-xs padding-tb-xs text-xxs border-bottom-da">{{ item.date }}</div>
      </div>
      <div class="text-xxs line-h-20 text-overflow-twice">{{ item.detail }}</div>
      <div class="fl w-fill flex align-center justify-start margin-top text-xxs hover">
        <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
        <div class="text-center ff text-bold padding-lr-xs cursor ">查看更多</div>
        <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue'

const forum = ref([{
  pic: 'https://www.ihchina.cn/Uploads/Picture/2023/11/26/s6562ee94387ed.jpg',
  title: '林岩：“两创”视域下北京雕漆创新设计的文化生态探究',
  detail: '随着非遗保护工作的深度开展，北京雕漆技艺当前取得了一些成果，尤其是在“两创”视域下，生态融合的格局得以凸显，呈现出差异化与多元化的生态，但在保留原样还是创新发展上仍存有诸多争议。基于实践考察发现，北京雕漆技艺创新发展存在局限与问题。从创新设计的视角对其进行重新...',
  date: '2023.11.26'
}])
const survey = ref([{
  title: '谱系观念与妈祖信俗的非遗保护',
  intro: '——以湄洲妈祖祖庙为中心的考察',
  detail: '谱系观念是把握非遗互动性、整体性规律的合理视角，对于信俗类非遗资源来说，朝圣与谱系之间有密切关联，谱系是朝圣的依据和基础，朝圣则是一种交流互鉴方式，可以勾连出非遗的空间谱系、凝聚信仰族群谱系，建构文化认同性，体现了非遗资源的互动性、整体性、认同性、实践性等特征...',
  date: '2019.11.25',
}])

</script>

<style scoped>
.hover:hover {
  color: darkred;
}

</style>
