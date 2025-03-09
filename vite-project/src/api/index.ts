// 导入前面定义的 API 模块
import * as home from "@/api/home";
import * as common from "@/api/common";
import * as user from "@/api/user";

// 定义一个接口，用于组织各个模块
interface api {
    common: typeof common;
    home: typeof home;
    user: typeof user;
}

// 默认导出一个包含所有 API 模块的对象，方便在其他地方统一引用
export default {
    common,
    home,
    user
} as api;
