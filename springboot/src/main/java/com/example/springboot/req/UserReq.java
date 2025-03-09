package com.example.springboot.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "用户参数")
public class UserReq {
    @NotBlank(message = "账号不能为空")
    @Schema(description = "账号")
    @TableField("acc")
    private String acc;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    @TableField("pwd")
    private String pwd;

    @NotBlank(message = "头像不能为空")
    @Schema(description = "头像")
    @TableField("pic")
    private String pic;

    @NotBlank(message = "真实姓名不能为空")
    @Schema(description = "真实姓名")
    @TableField("realname")
    private String realname;

    @NotNull(message = "性别不能为空")
    @Schema(description = "性别")
    @TableField("sex")
    private Integer sex;

    @NotNull(message = "年龄不能为空")
    @Schema(description = "年龄")
    @TableField("age")
    private Integer age;

    @NotBlank(message = "收获地址不能为空")
    @Schema(description = "收获地址")
    @TableField("address")
    private String address;

    @NotBlank(message = "邮政编码不能为空")
    @Schema(description = "邮政编码")
    @TableField("postalcode")
    private String postalcode;

    @NotBlank(message = "创建时间不能为空")
    @Schema(description = "创建时间")
    @TableField("CreateTime")
    private String createTime;

}
