<template>
  <div class="main">
    <!--  1  -->
    <div class="padding-lr-xxsl">
      <el-row :gutter="200">
        <el-col :span="6">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub bg-red-hover"
               :class="activeIndex===1?' bg-red':'bg-white'" @click="activeIndex=1">
            基本信息
          </div>
        </el-col>
        <el-col :span="6">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub bg-red-hover"
               :class="activeIndex===2?' bg-red':'bg-white'" @click="activeIndex=2">
            我的点赞
          </div>
        </el-col>
        <el-col :span="6">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub bg-red-hover"
               :class="activeIndex===3?' bg-red':'bg-white'" @click="activeIndex=3">
            我的收藏
          </div>
        </el-col>
        <el-col :span="6">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub bg-red-hover"
               :class="activeIndex===4?' bg-red':'bg-white'" @click="activeIndex=4">
            我的消息
          </div>
        </el-col>
      </el-row>
    </div>
    <!--  2  -->
    <div class="margin-top-lg padding-bottom-xl">
      <!--      Basic information    -->
      <div
          class="bg-white margin-top-xs" v-if="activeIndex===1">
        <!--        basic empty     -->
        <el-row :gutter="0" class="h-300px bg-white padding-lg margin-top-xl">
          <el-col :span="5">
            <div class="w-fill h-fill border" style="background:url('') no-repeat center/100% 100%;"></div>
          </el-col>
          <el-col :span="19">
            <div class="w-fill h-fill bg-white padding-lr-xl">
              <div class="line-h-30 margin-bottom text-black">
                <div class="text-red-hover cursor">账号： {{ myself().acc }}</div>
                <div class="text-red-hover cursor">密码： {{ myself().pwd }}</div>
                <div class="text-red-hover cursor">真实姓名： {{ myself().realname }}</div>
                <div class="text-red-hover cursor">收件地址： {{ myself().address }}</div>
                <div class="text-red-hover cursor">邮政编码： {{ myself().postalcode }}</div>
              </div>
              <div class="fl w-fill flex align-center justify-start text-xxs ">
                <div class="text-center margin-right bg-brown ff text-bold padding-xs cursor bg-red-hover"
                     @click="$router.push('/login')" v-if="myself().acc===''">前往登录
                </div>
                <div class="text-center margin-right bg-brown ff text-bold padding-xs cursor bg-red-hover">修改信息</div>
                <div class="text-center margin-right bg-brown ff text-bold padding-xs cursor bg-red-hover"
                     @click="authentication">实名认证
                </div>
                <div class="text-center margin-right bg-brown ff text-bold padding-xs cursor bg-red-hover"
                     @click="loginOut" v-if="myself().acc!==''">退出登录
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>

      <!--      My appointment       -->
      <div
          class="w-100  text-xxs bg-white"
          v-for="item in appointment" v-if="activeIndex===2">
        <el-row :gutter="0" class="h-300px bg-white padding-tb-lg margin-top-xl">
          <el-col :span="9">
            <div class="w-fill h-fill bg-red margin-lr-xl"
                 style="background:url(https://www.ihchina.cn/Uploads/Picture/2023/11/26/s6562ee94387ed.jpg) no-repeat center/100% 100%;;"></div>
          </el-col>
          <el-col :span="15">
            <div class="w-fill h-fill bg-white padding-lr-xl">
              <div class="text-red-hover cursor">
                <div class="padding-top-xs">林岩：“两创”视域下北京雕漆创新设计的文化生态探究</div>
                <div class="margin-tb-xs padding-tb-xs text-xxs border-bottom-da">2023.11.26</div>
              </div>
              <div class="text-xxs line-h-20 text-overflow-treble">
                随着非遗保护工作的深度开展，北京雕漆技艺当前取得了一些成果，尤其是在“两创”视域下，生态融合的格局得以凸显，呈现出差异化与多元化的生态，但在保留原样还是创新发展上仍存有诸多争议。基于实践考察发现，北京雕漆技艺创新发展存在局限与问题。从创新设计的视角对其进行重新...
              </div>
              <div class="fl w-fill flex align-center justify-start margin-top text-xxs text-red-hover">
                <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
                <div class="text-center ff text-bold padding-lr-xs cursor ">查看更多</div>
                <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>
      <div class="text-center text-black" v-if="activeIndex===2&&appointment.length===0">暂无数据</div>
      <!--      My collection       -->
      <div
          class="w-100 h-60px text-xxs bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in collection" v-if="activeIndex===3">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center text-black" v-if="activeIndex===3&&collection.length===0">暂无数据</div>
      <!--      My news       -->
      <div
          class="w-100 h-60px text-xxs text-red-hover cursor bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in news" v-if="activeIndex===4">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center text-black" v-if="activeIndex===4&&news.length===0">暂无数据</div>
    </div>

    <common-notify :notify-type="notifyType" :msg="notifyMsg" :close-notify="closeNotify" v-if="notifyShow"/>

  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import router from "@/router";
import CommonNotify from '@/components/CommonNotify.vue'

const activeIndex = ref(1);

function myself() {
  return JSON.parse(localStorage.getItem('myself')) !== null ? JSON.parse(localStorage.getItem('myself')) : {
    acc: "",
    pwd: "",
    pic: "",
    realname: "",
    sex: 0,
    age: 0,
    address: "",
    postalcode: "",
    createTime: ""
  }
}

const appointment = ref([{}]);
const collection = ref([]);
const news = ref([{
  label: '中华人民共和国非物质文化遗产法（中华人民共和国主席令第四十二号）',
  date: '2011'
}]);

// 退出登录
const loginOut = () => {
  localStorage.clear();
  router.push('/login');
}

// 实名认证
const notifyMsg = ref('提示信息');
const notifyType = ref(true);
const notifyShow = ref(false);

function authentication() {
  notifyMsg.value = '该功能暂未开通'
  notifyShow.value = true
  setTimeout(() => {
    notifyShow.value = false
  }, 1500)
}

//关闭通知
const closeNotify = () => {
  notifyShow.value = false
}

</script>

<style scoped>
.bg-red {
  background-color: darkred;
}

.bg-red-hover {
  cursor: pointer;
  transition: all .2s linear;
}

.bg-red-hover:hover {
  background-color: darkred;
  color: white;
}

.text-red-hover:hover {
  color: darkred;
}
</style>
