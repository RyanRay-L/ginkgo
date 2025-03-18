package cn.ryanray.ginkgo.base.pojo.entity;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.Comment;

/**
 * 带标记删除的实体
 *
 * @Author: 雷磊
 * @Date: 2025/3/18 17:53
 */
@Data
public class BaseDeletedEntity extends BaseEntity {

    @Comment("是否删除：false-未删除；true-已删除。")
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isDeleted;
}
