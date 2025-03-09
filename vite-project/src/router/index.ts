import { createRouter, createWebHistory } from "vue-router";

// 定义路由表，每个路由对应一个页面组件
const routes = [
  {
    path: "/login", // 登录页面路径
    name: "登录", // 路由名称
    component: () => import("../views/LoginView.vue"), // 动态加载组件
  },
  {
    path: "/", // 根路径
    name: "layout", // 主布局名称
    redirect: "/home", // 默认跳转到首页
    component: () => import("../views/LayoutView.vue"), // 主布局组件
    children: [
      // 嵌套路由：主布局下的子页面
      {
        path: "/home", // 首页路径
        name: "首页", // 路由名称
        component: () => import("../views/pages/HomeView.vue"), // 首页组件
      },
      {
        path: "/policy",
        name: "政策",
        component: () => import("../views/pages/PolicyView.vue"),
      },
      {
        path: "/message",
        name: "资讯",
        component: () => import("../views/pages/MessageView.vue"),
      },
      {
        path: "/detailed",
        name: "清单",
        component: () => import("../views/pages/DetailedView.vue"),
      },
      {
        path: "/show",
        name: "展示",
        component: () => import("../views/pages/ShowView.vue"),
      },
      {
        path: "/science",
        name: "学术",
        component: () => import("../views/pages/ScienceView.vue"),
      },
      {
        path: "/3Dshow",
        name: "3D展示",
        component: () => import("../views/pages/3DshowView.vue"),
      },
      {
        path: "/myself",
        name: "我的",
        component: () => import("../views/pages/MyselfView.vue"),
      },
    ],
  },
];

// 创建路由实例
const router = createRouter({
  // 使用 HTML5 的 history 模式（路径不带 #）
  history: createWebHistory(import.meta.env.BASE_URL),
  routes, // 路由表
});

export default router; // 导出路由实例
