<template>
  <div class="main">
    <!--  1  -->
    <div class="padding-lr-xxsl">
      <el-row :gutter="200">
        <el-col :span="8">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub"
               :class="activeIndex===1?' bg-red':'bg-white'" @click="activeIndex=1">
            国内法规文件
          </div>
        </el-col>
        <el-col :span="8">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub"
               :class="activeIndex===2?' bg-red':'bg-white'" @click="activeIndex=2">
            联合国教科文组织文件
          </div>
        </el-col>
        <el-col :span="8">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub"
               :class="activeIndex===3?' bg-red':'bg-white'" @click="activeIndex=3">
            主要论述
          </div>
        </el-col>
      </el-row>
    </div>
    <!--  2  -->
    <div class="margin-top-lg padding-bottom-xl">
      <!--      Domestic regulatory document    -->
      <div
          class="w-100 h-60px text-xxs bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in Domestic" v-if="activeIndex===1">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center" v-if="activeIndex===1&&Domestic.length===0">暂无数据</div>

      <!--      UNESCO document       -->
      <div
          class="w-100 h-60px text-xxs bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in UNESCO" v-if="activeIndex===2">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center" v-if="activeIndex===2&&UNESCO.length===0">暂无数据</div>
      <!--      Main exposition       -->
      <div
          class="w-100 h-60px text-xxs bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in Main" v-if="activeIndex===3">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center" v-if="activeIndex===3&&Main.length===0">暂无数据</div>

    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";

const activeIndex = ref(1);
const Domestic = ref([{
  label: '中共中央办公厅国务院动公厅印发《"十四五”文化发展规划》',
  date: '2022'
},
{
  label: '国务院办公厅关于同意调整完善非物质文化遗产保护工作部际联席会议制度的函（国办函〔2022）13号)',
  date: '2022'
},
{
  label: '中华人民共和国黄河保护法(2022)',
  date: '2022'
},
{
  label: '中共中央国务院印发《黄河流域生态保护和高质量发展规划纲要》',
  date: '2021'
},
{
  label: '中共中央办公厅国务院动公厅印发《关于进一步加强非物质文化遗产保护工作的意见》(2021)',
  date: '2021'
}]);
const UNESCO = ref([{
  label: '实施《保护非物质文化遗产公约》的业务指南(2022年修订版)',
  date: '2022'
},
{
  label: '保护非物质文化遗产的伦理原则(2016)',
  date: '2016'
},
{
  label: 'Convention for the Safeguarding of the Intangible Cultural Heritage (2003)',
  date: '2003'
}]);
const Main = ref([{
  label: '习近平在中共中央政治局第十七次集体学习时强调锚定建成文化强国战略目标不断发展新时代中国特色社会主义文化',
  date: '2024'
},
{
  label: '加强文化遗产保护传承弘扬中华优秀传统文化',
  date: '2024'
},
{
  label: '习近平出席文化传承发展座谈会并发表重要讲话',
  date: '2024'
}]);

</script>

<style scoped>
.bg-red {
  background-color: darkred;
}

.bg-white {
  cursor: pointer;
  transition: all .2s linear;
}

.bg-white:hover {
  background-color: darkred;
  color: white;
}
</style>
