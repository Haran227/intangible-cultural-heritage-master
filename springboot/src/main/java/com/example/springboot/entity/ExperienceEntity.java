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
 * 体验表
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("experience")
@Schema(name = "ExperienceEntity", description = "$!{table.comment}")
public class ExperienceEntity extends Model<ExperienceEntity> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "图片")
    @TableField("pic")
    private String pic;

    @Schema(description = "标题")
    @TableField("title")
    private String title;

    @Schema(description = "介绍")
    @TableField("intro")
    private String intro;

    @Schema(description = "详情")
    @TableField("detail")
    private String detail;

    @Schema(description = "地址")
    @TableField("address")
    private String address;

    @Schema(description = "时间")
    @TableField("date")
    private String date;

    @Schema(description = "联系电话")
    @TableField("phone")
    private String phone;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
