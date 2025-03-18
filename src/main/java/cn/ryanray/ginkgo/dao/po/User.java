package cn.ryanray.ginkgo.dao.po;

import cn.ryanray.ginkgo.base.pojo.entity.BaseDeletedEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
@Entity
@Table(name = "users") // 指定表名
public class User extends BaseDeletedEntity {

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