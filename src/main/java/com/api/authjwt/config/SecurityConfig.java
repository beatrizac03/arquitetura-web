package com.api.authjwt.config;

import java.nio.charset.StandardCharsets;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import static org.springframework.security.config.Customizer.withDefaults;

import com.api.authjwt.models.Usuario;
import com.api.authjwt.repositories.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${jwt.secret}")
    private String jwtSecret;

    // PasswordEncoder: Pra codificar senhas de forma segura
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // UserDetailsService: Como o Spring Security vai carregar os detalhes do
    // usuário
    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository userRepository) {
        return username -> userRepository.findByUsername(username)
                .map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRole())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }

    // JwtDecoder: O componente que o Spring Security usa pra decodificar e validar
    // JWTs
    @Bean
    public JwtDecoder jwtDecoder() {
        // A chave secreta é convertida pra um SecretKeySpec para HMAC
        SecretKeySpec secretKey = new SecretKeySpec(jwtSecret.getBytes(StandardCharsets.UTF_8), "HmacSha256");
        // Constrói o NimbusJwtDecoder com a chave secreta. Ele fará a validação da
        // assinatura.
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }

    // SecurityFilterChain: Configura as regras de segurança HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(withDefaults()) // habilita CORS para usar o corsFilter bean abaixo
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/register").permitAll()
                        .requestMatchers("/auth/validate").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/produtos").permitAll()
                        .requestMatchers("/actuator/**").permitAll()
                        .anyRequest().authenticated())
                .headers(headers -> headers.frameOptions(frameOptions -> headers.frameOptions().sameOrigin()))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {
                    // jwt decoder bean já configurado
                }));

        return http.build();
    }

    // CommandLineRunner: Popula o banco de dados H2 com usuários iniciais ao
    // iniciar a aplicação
    @Bean
    public CommandLineRunner initData(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario(null, "admin", passwordEncoder.encode("123456"), "ADMIN");
                userRepository.save(admin);
                System.out.println("✅ Usuário 'admin' criado com senha codificada.");
            }
            if (userRepository.findByUsername("user").isEmpty()) {
                Usuario user = new Usuario(null, "user", passwordEncoder.encode("password"), "USER");
                userRepository.save(user);
                System.out.println("✅ Usuário 'user' criado com senha codificada.");
            }
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*"); // libera todas as origens (melhor que addAllowedOrigin("*") em Spring Boot
                                             // 2.4+)
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
