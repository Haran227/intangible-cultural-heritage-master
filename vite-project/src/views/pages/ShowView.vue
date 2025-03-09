<template>
  <div class="main">
    <!--    1     -->
    <el-row>
      <el-col :span="6">
        <div class="w-fill text-center">
          <input class="w-fill padding-lr-sm margin-left-xl h-40px line-h-40" type="text"
                 id="input" placeholder="关键词"></div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill padding-lr-xxl">
          <div class="bg-red h-40px text-xxs line-h-40 text-center text-overflow-sub">搜索</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill padding-lr-xxl">
          <div class="bg-red h-40px text-xxs line-h-40 text-center text-overflow-sub">我的点赞</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill padding-lr-xxl">
          <div class="bg-red h-40px text-xxs line-h-40 text-center text-overflow-sub">我的收藏</div>
        </div>
      </el-col>
    </el-row>
    <!--    2     -->
    <div class="flex align-center justify-center margin-top-xl text-df">
      <div class="iconfont icon-knot cursor"></div>
      <div class="text-center text-black ff text-bold padding-lr-xs cursor">为你推荐</div>
      <div class="iconfont icon-knot cursor"></div>
    </div>
    <!--    Recommend for you     -->
    <div class="margin-top-xl">
      <div class="fl w-33 padding-xxs" v-for="item in recommend">
        <div class="w-fill h-400px hidden">
          <div class="h-225px hidden cursor">
            <div class="w-fill h-fill bg-img bg-red">
              <img class="w-fill h-fill" :src="item.pic" :alt="item.pic">
            </div>
          </div>
          <div class="w-fill h-200px bg-white">
            <div class="ff text-bold line-h-40 margin-top-xxxs text-xs text-center w-fill text-overflow-sub">
              {{ item.title }}
            </div>
            <div class="text-xxs padding-lr line-h-20 text-overflow-twice">{{ item.intro }}</div>
            <div class="text-xxxs padding-lr line-h-25 text-overflow-twice margin-top-xxs">地理位置：{{ item.address }}</div>
            <div class="text-xxxs padding-lr line-h-25 text-overflow-twice">所处时代：{{ item.era }}</div>
            <div class="text-xxxs padding-lr line-h-25 text-overflow-twice">保护级别：{{ item.level }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue"
import imperial_palace_2 from "@/assets/images/imperial_palace_2.jpg";
import Temple_of_Heaven_2 from "@/assets/images/Temple_of_Heaven_2.jpg";
import The_Great_Wall_2 from "@/assets/images/The_Great_Wall_2.jpg";


const recommend = ref([{
  id: '',
  pic: imperial_palace_2,
  title: '北京故宫',
  intro: '中国明清两代的皇家宫殿，旧称紫禁城，位于北京中轴线的中心。故宫以三大殿为中心，占地面积约72万平方米，建筑面积约15万平方米，有大小宫殿七十多座，相传故宫一共有9999.5间，实际据1973年专家现场测量故宫有房间8707间',
  detail: '',
  address: '北京市东城区景山前街4号',
  era: '明清',
  level: '世界文化遗产；第一批全国重点文物保护单位'
},
{
  id: '',
  pic: Temple_of_Heaven_2,
  title: '天坛',
  intro: '天坛，原名“天地坛”，位于北京市东城区永定门大街东侧。为明、清两代皇帝祭天、祈谷和祈雨的场所。是中国现存最大的古代祭祀性建筑群。',
  detail: '',
  address: '北京市东城区永定门大街东侧',
  era: '明清',
  level: '第一批全国重点文物保护单位'
},
{
  id: '',
  pic: The_Great_Wall_2,
  title: '长城',
  intro: '长城，又称万里长城，是中国古代的军事防御工事，是一道高大、坚固而且连绵不断的长垣，用以限隔敌骑的行动。长城不是一道单纯孤立的城墙，而是以城墙为主体，同大量的城、障、亭、标相结合的防御体系。依据长城形成了长城文化。是弘扬中华优秀传统文化的重要力量。',
  detail: '',
  address: '中国北方',
  era: '春秋至明',
  level: '世界文化遗产；第五批全国重点文物保护单位'
}]);
</script>

<style scoped>
.bg-red {
  cursor: pointer;
  background-color: darkred;
}

#input {
  border: none;
}

input[type=text]:focus {
  outline: none;
}

.bg-img {
  transition: all .4s ease-in-out;
}

.bg-img:hover {
  transform: scale(1.1);
}

.h-100px:hover {
  cursor: pointer;
  color: darkred !important;
}
</style>
