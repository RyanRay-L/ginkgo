package cn.ryanray.ginkgo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
//@EntityScan({"cn.ryanray.ginkgo.dao.po", "cn.ryanray.ginkgo.dao.po.entities"}) // 多个实体类包路径
//@EnableJpaRepositories({"cn.ryanray.ginkgo.dao.repository", "cn.ryanray.ginkgo.dao.repository"}) // 多个 Repository 包路径
@EntityScan("cn.ryanray.ginkgo.dao.po") // 指定实体类所在的包路径
@EnableJpaRepositories("cn.ryanray.ginkgo.dao.repository") // 指定 Repository 接口所在的包路径
public class GinkgoApplication {

    private static final Logger logger = LoggerFactory.getLogger(GinkgoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GinkgoApplication.class, args);

        System.out.println("ginkgo启动成功！");
        logger.info("ginkgo启动成功");
    }
}
