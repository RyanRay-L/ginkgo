package cn.ryanray.ginkgo.dao.po;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // 指定表名
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;

    @Column(nullable = false) // 非空字段
    private String name;

    @Column(unique = true, nullable = false) // 唯一且非空
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}