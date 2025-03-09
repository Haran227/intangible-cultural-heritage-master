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
 * 收藏表
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("collection")
@Schema(name = "CollectionEntity", description = "$!{table.comment}")
public class CollectionEntity extends Model<CollectionEntity> {

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "体验")
    @TableField("experience_id")
    private Integer experienceId;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
