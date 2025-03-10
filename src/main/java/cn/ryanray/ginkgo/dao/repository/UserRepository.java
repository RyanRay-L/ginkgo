package cn.ryanray.ginkgo.dao.repository;

import cn.ryanray.ginkgo.dao.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 可以根据需要定义自定义查询方法
    User findByEmail(String email);
}
