<template>
  <div class="">
    <div class="flex flex-direction padding-lr-xl index-1 absolute-top"
         :tran="state.selectedKeys==='/home'?'four':''"
         :class="state.selectedKeys==='/home'?'bg-gray text-white ':'bg-white text-black'">
      <!--   1   -->
      <el-row :gutter="80" class="padding-tb-xs"
              :class="state.selectedKeys==='/home'?'border-bottom-three':'border-bottom-da'">
        <el-col :span="12">
          <div class="flex align-center justify-center">
            <div class="avatar-sm text-darkred iconfont icon-sj9 text-center text-xxxl"></div>
            <span class="margin-left ff text-overflow-sub text-bold">中国文化遗产数字化保护系统</span>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="flex align-center justify-center">
            <!-- 右侧的功能按钮：搜索、聊天、个人信息等 -->
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor"><i class="iconfont icon-search_sousuo"></i>
            </div>
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor"><i class="iconfont icon-session_huihua"></i>
            </div>
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor"><i class="iconfont icon-mine_wode"></i></div>
            <!-- 显示当前日期和农历日期 -->
            <div class="margin-top-sm margin-left-sm ff text-overflow-sub text-bold">
              {{ new Date().getFullYear() }}-{{ new Date().getMonth() + 1 }}-{{ new Date().getDate() }}
              {{ "星期" + "日一二三四五六".charAt(new Date().getDay()) }}
              农历{{ lunardate }}
            </div>
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor margin-left-sm"><i
                class="iconfont icon-knot"></i></div>
          </div>
        </el-col>
      </el-row>
      <!--   2   -->
      <div class="w-fill h-60px flex align-center justify-center">
        <!-- 菜单项：通过动态类名控制选中的菜单项的样式 -->
        <div class="ff text-sm text-bold padding-lr-sm margin-lr-xs cursor text-overflow-sub"
             :class="router.currentRoute.value.fullPath===item.path?'border-bottom':'no-border bg-hover'"
             v-for="(item,index) in menu" @click="handleSelect(item.path)"
             @mouseenter="mouseenter(item,index)" @mouseleave="mouseleave(item,index)">
          {{ item.label }}
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {computed, onMounted, reactive, ref} from 'vue'
import router from "@/router";
import {index} from "@/stores";
// 引入农历日期计算工具
//@ts-ignore
import lunardate from "@/utils/solarlunar.js";

// 定义菜单项，包含路径和标签
const menu = ref([
  {label: '首页', path: '/home'},
  {label: '政策', path: '/policy'},
  {label: '资讯', path: '/message'},
  {label: '清单', path: '/detailed'},
  {label: '展示', path: '/show'},
  {label: '学术', path: '/science', children: [{label: "论坛", path: ""}, {label: "调研", path: ""}]},
  {label: '3D展示', path: '/3Dshow', children: [{label: "申报指南", path: ""}, {label: "百叶窗", path: ""}]},
  {label: '我的', path: '/myself', children: [{label: "我的预约", path: ""}, {label: "我的收藏", path: ""}]},
]);

// 过滤没有子菜单的项
const noChildren = computed(() => menu.value.filter((item) => !item.children))
// 过滤有子菜单的项
const hasChildren = computed(() => menu.value.filter((item) => item.children))

// state用于保存选中的菜单项
const state = reactive({
  selectedKeys: computed(/* @ts-ignore */() => index().selectedKeys),
});

// 页面加载时，设置当前选中的菜单项
onMounted(() => {
  activeIndex.value = router.currentRoute.value.fullPath;
  index().changeSelectedKeys(activeIndex.value);
})
const activeIndex = ref("/home");

// 处理菜单项的点击事件
const handleSelect = (key: string) => {
  router.push(key);
  index().changeSelectedKeys(key);
}

const mouse = ref("")
const transform = ref(0)

// 鼠标悬停时，设置鼠标悬停项的样式
const mouseenter = (item, index) => {
  mouse.value = item.label
  transform.value = 650 + (100 * (index + 1))
}

// 鼠标离开时，清空悬停项
const mouseleave = (item, index) => {
  setTimeout(mouse.value = "", 20000);
}
</script>

<style scoped>
/* 菜单项选中时的底部边框样式 */
.border-bottom {
  border-bottom: var(--border-h) solid darkred;
  line-height: var(--line-h);
}

/* 未选中时的边框样式 */
.no-border {
  border-bottom: var(--border-h) solid transparent;
  line-height: var(--line-h);
}

/* 鼠标悬停时添加底部边框 */
.no-border:hover {
  border-bottom: var(--border-h) solid darkred;
}
</style>
