import axios from "axios";
import { baseURL, timeout, headers } from "@/config";

// 创建 Axios 实例，统一配置请求属性
const request = axios.create({
  baseURL, // API 基础路径
  timeout, // 请求超时时间
  headers, // 自定义请求头
});

// 添加请求拦截器
request.interceptors.request.use(
  function (config) {
    // 请求发送前的处理逻辑，例如添加认证 Token
    return config; // 返回修改后的配置
  },
  function (error) {
    // 请求错误时的处理逻辑
    return Promise.reject(error); // 返回错误信息
  }
);

// 添加响应拦截器
request.interceptors.response.use(
  function (response) {
    // 响应成功时的处理逻辑，例如提取数据部分
    return response.data; // 返回响应数据
  },
  function (error) {
    // 响应失败时的处理逻辑
    return Promise.reject(error); // 返回错误信息
  }
);

export default request; // 导出 Axios 实例
