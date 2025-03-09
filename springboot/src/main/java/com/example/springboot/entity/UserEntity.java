package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user")
@Schema(name = "UserEntity", description = "$!{table.comment}")
public class UserEntity extends Model<UserEntity> {

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "账号")
    @TableField("acc")
    private String acc;

    @Schema(description = "密码")
    @TableField("pwd")
    private String pwd;

    @Schema(description = "头像")
    @TableField("pic")
    private String pic;

    @Schema(description = "真实姓名")
    @TableField("realname")
    private String realname;

    @Schema(description = "性别")
    @TableField("sex")
    private Integer sex;

    @Schema(description = "年龄")
    @TableField("age")
    private Integer age;

    @Schema(description = "收获地址")
    @TableField("address")
    private String address;

    @Schema(description = "邮政编码")
    @TableField("postalcode")
    private String postalcode;

    @Schema(description = "创建时间")
    @TableField("CreateTime")
    private String createTime;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
