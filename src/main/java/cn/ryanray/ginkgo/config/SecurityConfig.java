package cn.ryanray.ginkgo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new ChannelInterceptor() {
//            @Override
//            public Message<?> preSend(Message<?> message, MessageChannel channel) {
//                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
//                    // 验证用户
//
//                }
//                return message;
//            }
//        });
//    }

    /**
     * 禁用组件。
     * @param http
     * @return
     * @throws Exception
     */
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .anyRequest().permitAll() // 允许所有请求
//                )
//                .csrf().disable();
//                 // 禁用 CSRF
//
//        return http.build();
//    }


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http.authorizeHttpRequests((requests) -> requests
//                            .requestMatchers("/doc.html", "/webjars/**", "/v3/api-docs/**", "/swagger-resources/**", "/druid/**", // 允许访问 Knife4j 相关端点
//                                    "/actuator/**", // 安全检查的路径。
//                                    "/ws/**"    // websocket测试接口的检查
//                            ).permitAll()
//                            .anyRequest().authenticated()
//                    )
//                    .csrf().disable();
//            return http.build();

            http.authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/**"    // 全放开，不检查。
                            ).permitAll()
                            .anyRequest().authenticated()
                    )
                    .csrf().disable();
            return http.build();
        }

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/public/**").permitAll() // 允许公共访问
                        .anyRequest().authenticated() // 其他请求需要认证
                )
                .formLogin((form) -> form
                        .loginPage("/login") // 自定义登录页面
                        .permitAll()
                )
                .logout((logout) -> logout
                        .permitAll() // 允许注销
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 创建用户
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password")) // 加密密码
                .roles("USER") // 用户角色
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123")) // 加密密码
                .roles("ADMIN") // 管理员角色
                .build();

        // 返回 InMemoryUserDetailsManager，管理用户
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用 BCrypt 加密
        return new BCryptPasswordEncoder();
    }*/
}