<template>
  <div class="main">
    <!--    1    -->
    <div class="w-fill text-center text-df text-black ff text-bold">中国世界遗产及国家级非物质文化遗产代表性项目名录</div>

    <!--    2     -->
    <el-row class="margin-top-xxl">
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">5</div>
          <div class="text-black margin-top-xs">批次</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">14</div>
          <div class="text-black margin-top-xs">类别</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">143</div>
          <div class="text-black margin-top-xs">项目</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">3610</div>
          <div class="text-black margin-top-xs">子项</div>
        </div>
      </el-col>
    </el-row>

    <!--    3     -->
    <table class="w-fill margin-top-xxl" align="center" cellpadding="10" cellspacing="0">
      <tr class="bg-red h-60px">
        <th>序号</th>
        <th>项目序号</th>
        <th>编号</th>
        <th>名称</th>
        <th>类别</th>
        <th>入选/公布时间</th>
        <th>类型</th>
        <th>申报国家/地区/单位</th>
        <th>保护单位</th>
      </tr>
      <tr class="text-center h-80px text-black text-xs" v-for="(item, index) in tableData" :key="index">
        <td>{{ item.index }}</td>
        <td>{{ item.itemIndex }}</td>
        <td>{{ item.number }}</td>
        <td>{{ item.name }}</td>
        <td>{{ item.category }}</td>
        <td>{{ item.publishTime }}</td>
        <td>{{ item.type }}</td>
        <td>{{ item.region }}</td>
        <td>{{ item.protectionUnit }}</td>
      </tr>
    </table>


    <!--    4      -->
    <div class="w-fill h-125px flex align-center justify-center text-center text-xxs line-h-30 text-black border-bottom-da">
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover bg-red">1</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">2</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">3</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">4</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">5</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">...</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">382</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover iconfont icon-wenlvlogo text-sm"></div>
      <div class="cursor margin-lr-xxs text-xxs">跳转至</div>
      <div class="cursor margin-lr-xxs bg-hover">
        <input class="padding-lr-xs h-30px line-h-30" type="text"
               id="input" placeholder="">
      </div>
      <div class="cursor margin-lr-xxs text-xxs">页</div>
      <div class="cursor margin-lr-xs text-xxs bg-hover-red bg-hover padding-lr-xs radius-xs">确定</div>
    </div>

    <!--    5     -->

  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";

const tableData = ref([
  { index: 1, itemIndex: '1', number: '--', name: '北京故宫', category: '世界文化遗产', publishTime: '1987', type: '--', region: '中国', protectionUnit: '故宫博物院' },
  { index: 2, itemIndex: '2', number: '--', name: '长城', category: '世界文化遗产', publishTime: '1987', type: '--', region: '中国', protectionUnit: '国家文物局' },
  { index: 3, itemIndex: '3', number: '--', name: '九寨沟风景名胜区', category: '世界自然遗产', publishTime: '1992', type: '--', region: '中国', protectionUnit: '九寨沟管理局' },
  { index: 4, itemIndex: '4', number: '--', name: '泰山', category: '世界文化与自然双重遗产', publishTime: '1987', type: '--', region: '中国', protectionUnit: '泰安市泰山管理行政执法局' },
  { index: 5, itemIndex: '5', number: 'I-1', name: '苗族古歌', category: '民间文学', publishTime: '2006', type: '新增项目', region: '贵州省台江县', protectionUnit: '台江县非物质文化遗产保护中心' }
]);

</script>


<style scoped>
.text-xxl {
  font-size: 100px !important;
}

.bg-red{
  background-color: #962a2b;
}

#input {
  border: none;
}

input[type=text]:focus {
  outline: none;
}
</style>
