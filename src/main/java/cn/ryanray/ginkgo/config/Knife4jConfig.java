package cn.ryanray.ginkgo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Knife4j配置类
 * </p>
 *
 * @author Patrick
 * @since 2025-1-1
 */
@Configuration
public class Knife4jConfig {

    /**
     * 创建权限分组api
     *
     */
//    @Bean
//    public GroupedOpenApi securityApi() {
//        return createRestApi("安全管理", "");
//    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot 3.4.3 API 文档")
                        .version("1.0")
                        .description("Spring Boot 3.4.3 集成 Knife4j 4.5.0"));
    }

    /**
     * 创建系统分组api
     *
     */
//    @Bean
//    public GroupedOpenApi systemApi() {
//        return createRestApi("系統管理", "com.ryanray.ginkgo.controller");
//    }

    /**
     * 创建api
     *
     * @param groupName   分组名称
     * @param basePackage 包路径
     * @return GroupedOpenApi
     */
    public GroupedOpenApi createRestApi(String groupName, String basePackage) {
        return GroupedOpenApi.builder()
                .group(groupName) // 分组名称
                .packagesToScan(basePackage) // 扫描的包路径
                .pathsToMatch("/**") // 匹配所有路径
                .addOpenApiCustomizer(openApi -> openApi.info(apiInfo())) // 设置api信息
                .build();
    }

    /**
     * api简介信息
     *
     * @return ApiInfo
     */
    private Info apiInfo() {
        return new Info()
                .title("Patrick后台管理系统服务接口") // 标题
                .description("Patrick后台管理系统服务接口文档...") // 描述
                .version("1.0.0") // 版本号
                .termsOfService("http://doc.xiaominfo.com") // 服务条款
                .contact(new Contact().name("Patrick").url("https://github.com/Patrick-Luo-THR").email("patrick.luo@163.com")) // 联系人信息
                .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")); // 许可证信息
    }

}

