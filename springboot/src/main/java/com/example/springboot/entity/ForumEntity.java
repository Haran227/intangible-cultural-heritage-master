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
 * 论坛表
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("forum")
@Schema(name = "ForumEntity", description = "$!{table.comment}")
public class ForumEntity extends Model<ForumEntity> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "主键")
    @TableField("pic")
    private String pic;

    @Schema(description = "标题")
    @TableField("title")
    private String title;

    @Schema(description = "详情")
    @TableField("datail")
    private String datail;

    @Schema(description = "时间")
    @TableField("date")
    private String date;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
