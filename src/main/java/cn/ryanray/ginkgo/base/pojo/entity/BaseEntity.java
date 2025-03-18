package cn.ryanray.ginkgo.base.pojo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.sql.Timestamp;

/**
 * 基本实体类
 *
 * @Author: 雷磊
 * @Date: 2025/3/18 17:30
 */
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;

    @Comment("创建人ID")
    @Column(nullable = false)
    private Long createUserId;

    @Comment("修改人ID")
    @Column(nullable = false)
    private Long updateUserId;

    @Comment("创建时间")
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createTime;

    @Comment("创建时间")
    @Column(name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updateTime;
}
