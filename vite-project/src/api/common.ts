// 引入自定义的请求模块，负责向服务器发送请求
import request from "@/request";

// 定义生成验证码接口的响应类型
export interface GenerateImageCodeRes {
    // 此处可以根据实际返回的数据格式来定义字段
}

/**
 * 生成验证码的 API 请求
 * @returns 返回一个 Promise 对象，里面是生成验证码的响应数据
 */
export function generateImageCode(): Promise<GenerateImageCodeRes> {
    // 使用 GET 请求方式调用后端接口获取验证码
    return request.get(`/basic/generateImageCode`, { responseType: "arraybuffer" });
}
