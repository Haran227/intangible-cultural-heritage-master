<template>
  <div class="w-100vw h-100vh flex align-center justify-center" style="background-color:#fff;">
    <div class="margin-bottom-xl padding-lr-xs flex flex-direction justify-around w-33vw h-60vh">
      <div class="text-gray text-bold text-xl text-center">登录</div>
      <input class="border padding-xs" type="text" placeholder="账号" v-model="loginParam.acc">
      <input class="border padding-xs" type="password" placeholder="密码" v-model="loginParam.pwd">
      <div class="flex align-center justify-between">
        <input class="border padding-xs w-75" type="text" placeholder="验证码" v-model="loginParam.code">
        <div>
          <img class="cursor" @click="getCode" style="width: 100px;height: 40px;" :src="codeSrc"
               alt="code">
        </div>
      </div>
      <div class="bg-red padding-xs text-center cursor bg-hover-red hover" @click="login">登录</div>
      <div class="bg-red padding-xs text-center cursor bg-hover-red hover" @click="">注册</div>
      <div class="bg-red padding-xs text-center cursor bg-hover-red hover" @click="">忘记密码</div>
    </div>

    <!--    -->
    <div class="fixed-top w-25 h-30px margin-top margin-left text-gray cursor" @click="$router.push('/myself')">返回</div>

    <!--    -->
    <common-notify :notify-type="notifyType" :msg="notifyMsg" :close-notify="closeNotify" v-if="notifyShow"/>
  </div>
</template>

<script setup lang="ts">
import CommonNotify from '@/components/CommonNotify.vue'
import {onMounted, reactive, ref} from "vue";
import api from "@/api";
import {LoginParams} from "@/api/user";
import router from "@/router";

const codeSrc: any = ref("")
onMounted(() => {
  getCode();
})
//获取验证码
const getCode = () => {
  api.common.generateImageCode().then((res: any) => {
    const bufferUrl = btoa(
        new Uint8Array(res).reduce(
            (data, byte) => data + String.fromCharCode(byte),
            ""
        )
    );
    codeSrc.value = "data:image/png;base64," + bufferUrl;
  })
}
//登录
const loginParam: LoginParams = reactive({
  acc: '',
  pwd: '',
  code: '',
});
const notifyMsg = ref('提示信息');
const notifyType = ref(true);
const notifyShow = ref(false);
const login = () => {
  api.user.login(loginParam).then((rs: any) => {
    notifyType.value = rs.success
    notifyMsg.value = rs.message
    //展示通知
    notifyShow.value = true
    if (!rs.success) {
      getCode()
    } else {
      router.push('/myself')
      localStorage.setItem('myself', JSON.stringify(rs.data));
    }
    setTimeout(() => {
      notifyShow.value = false
    }, 1500)
  })
}

//关闭通知
const closeNotify = () => {
  notifyShow.value = false
}
</script>

<style scoped>

</style>