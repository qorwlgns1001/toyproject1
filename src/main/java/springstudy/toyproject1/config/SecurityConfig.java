package springstudy.toyproject1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //csrf disable
        httpSecurity
                .csrf(auth -> auth.disable());

        //Form 로그인 방식 disable
        httpSecurity
                .formLogin(auth -> auth.disable());

        //http basic 인증방식 disable
        httpSecurity
                .httpBasic(auth -> auth.disable());

        //경로별 인가 작업
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/", "/join").permitAll() // /login, /, /join 경로로 들어오면 모두 허용
                        .requestMatchers("/admin").hasRole("ADMIN") // /admin 경로 접근시 ADMIN만 접근가능
                        .anyRequest().authenticated()); // 그 외 경로는 로그인 된 사용자만 접근가능

        //세션 설정
        httpSecurity
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }
}
