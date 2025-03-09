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
 * 文化遗产表
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("culture")
@Schema(name = "CultureEntity", description = "$!{table.comment}")
public class CultureEntity extends Model<CultureEntity> {

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "地点")
    @TableField("city")
    private String city;

    @Schema(description = "编号")
    @TableField("code")
    private String code;

    @Schema(description = "序号")
    @TableField("serial")
    private String serial;

    @Schema(description = "名称")
    @TableField("name")
    private String name;

    @Schema(description = "类别")
    @TableField("category")
    private Integer category;

    @Schema(description = "公布时间")
    @TableField("announce")
    private String announce;

    @Schema(description = "类型")
    @TableField("type")
    private String type;

    @Schema(description = "申报地区或单位")
    @TableField("reporting")
    private String reporting;

    @Schema(description = "保护单位")
    @TableField("protection")
    private String protection;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
