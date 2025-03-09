// 引入项目的全局样式文件
import "@/assets/index.css";
// 引入图标字体样式
import "@/assets/iconfont.css";

// 引入 Vue 创建应用的方法
import { createApp } from "vue";
// 引入 Pinia（Vue 3 推荐的状态管理库）
import { createPinia } from "pinia";

// 引入根组件 App.vue
import App from "./App.vue";
// 引入 Vue Router 配置
import router from "./router";

// 引入 ElementPlus 组件库
import ElementPlus from "element-plus";
// 引入 ElementPlus 样式
import "element-plus/dist/index.css";
// 引入 ElementPlus 的所有图标组件
import * as ElementPlusIconsVue from "@element-plus/icons-vue";

// 创建 Vue 应用实例
const app = createApp(App);

// 注册 ElementPlus 图标组件
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component);
}

// 使用 ElementPlus 组件库
app.use(ElementPlus);
// 使用 Pinia 进行状态管理
app.use(createPinia());
// 使用 Vue Router 进行路由管理
app.use(router);

// 将 Vue 实例挂载到页面上的 #app 元素
app.mount("#app");
