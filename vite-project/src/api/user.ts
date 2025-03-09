import request from "@/request";

// 定义登录请求的参数类型
export interface LoginParams {
    acc: string;  // 账号
    pwd: string;  // 密码
    code: string; // 验证码
}

// 定义登录接口的响应类型
export interface LoginRes {
    message: string;  // 返回的消息
    success: boolean; // 登录是否成功
    code: number;     // 返回的状态码
    data: Record<string, unknown>; // 用户数据
}

/**
 * 用户登录的 API 请求
 * @param {object} params 登录请求的参数
 * @param {string} params.acc 账号
 * @param {string} params.pwd 密码
 * @param {string} params.code 验证码
 * @returns 返回一个 Promise，里面是登录请求的响应
 */
export function login(params: LoginParams): Promise<LoginRes> {
    // 使用 POST 请求提交登录数据
    return request.post(`/userEntity/login`, params);
}
