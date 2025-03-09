<template>
  <div class="">
    <common-header/>
    <common-tabs/>
    <RouterView/>
    <div class="h-10vh bg-eee"></div>
  </div>
</template>

<script setup lang="ts">
import {RouterView} from "vue-router";
import CommonHeader from "@/components/CommonHeader.vue";
import CommonTabs from "@/components/CommonTabs.vue";

</script>

<style scoped></style>
