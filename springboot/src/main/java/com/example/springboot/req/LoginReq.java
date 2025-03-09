package com.example.springboot.req;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "登录参数")
public class LoginReq {

    @NotBlank(message = "账号不能为空")
    @Schema(description = "账号")
    @TableField("acc")
    private String acc;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    @TableField("pwd")
    private String pwd;

    @NotBlank(message = "验证码不能为空")
    @Schema(description = "验证码")
    @TableField("code")
    private String code;

}
