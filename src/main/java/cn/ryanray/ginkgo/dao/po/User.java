package cn.ryanray.ginkgo.dao.po;

import cn.ryanray.ginkgo.base.pojo.entity.BaseDeletedEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users") // 指定表名
public class User extends BaseDeletedEntity {

    /**
     * JPA规范要求，使用@Entity注解时，id不能通过继承实体类的父类获取。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;

    @Comment("名称")
    @Column(nullable = false) // 非空字段
    private String name;

    @Comment("昵称")
    @Column(columnDefinition = "VARCHAR(20) NULL DEFAULT NULL")
    private String nickname;

    @Column(columnDefinition = "INT NULL DEFAULT NULL")
    private Integer age;

    @Comment("邮箱")
    @Column(unique = true, nullable = false) // 唯一且非空
    private String email;

    @Comment("手机号")
    @Column(columnDefinition = "VARCHAR(20) NULL DEFAULT NULL")
    private String phoneNumber;

    @Comment("性别")
    @Column(nullable = false, columnDefinition = "INT NULL DEFAULT NULL")
    private Integer gender;
}