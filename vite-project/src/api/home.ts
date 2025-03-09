import request from "@/request";

// 定义获取地图数据接口的响应类型
export interface MapCultureRes {
    message: string;  // 返回消息
    success: boolean; // 请求是否成功
    code: number;     // 返回的状态码
    data: {
        id: number;
        city: string;
        code: string;
        serial: string;
        name: string;
        category: number;
        announce: string;
        type: string;
        reporting: string;
        protection: string;
    }[]; // 返回的文化遗产数据
}

/**
 * 获取指定城市的文化遗产数据
 * @param {string} city 城市名称
 * @returns 返回一个 Promise，里面是地图文化遗产数据的响应
 */
export function mapCulture(city: string): Promise<MapCultureRes> {
    // 使用 GET 请求获取指定城市的文化遗产信息
    return request.get(`/cultureEntity/map?city=${city}`);
}
