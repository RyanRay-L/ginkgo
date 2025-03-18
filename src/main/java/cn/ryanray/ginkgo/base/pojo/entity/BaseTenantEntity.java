package cn.ryanray.ginkgo.base.pojo.entity;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.Comment;

/**
 * 带租户的实体
 *
 * @Author: 雷磊
 * @Date: 2025/3/18 17:54
 */
@Data
public class BaseTenantEntity extends BaseDeletedEntity {

    @Comment("租户ID")
    @Column(nullable = false)
    private Integer tenantId;
}
