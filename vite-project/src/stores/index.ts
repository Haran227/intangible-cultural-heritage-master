import { defineStore } from "pinia";

// 定义名为 "index" 的 store，用于管理全局状态
export const index = defineStore("index", {
  state: () => ({
    selectedKeys: "/home", // 当前选中的菜单项路径，默认值为 "/home"
    myself: '', // 当前用户信息，初始为空
  }),
  persist: {
    enabled: true, // 启用数据持久化
  },
  actions: {
    // 更新选中菜单项
    changeSelectedKeys(key: any) {
      //@ts-ignore
      this.selectedKeys = key; // 设置新的菜单项路径
    },
    // 更新用户信息
    changeMysef(param: any) {
      //@ts-ignore
      this.myself = param; // 设置新的用户信息
    },
  },
  getters: {
    // 可根据需求添加计算属性（暂未使用）
  },
});
