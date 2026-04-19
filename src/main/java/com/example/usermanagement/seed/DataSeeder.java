package com.example.usermanagement.seed;

import com.example.usermanagement.model.Role;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            log.info("Seeding initial user data...");

            List<User> users = List.of(
                    User.builder()
                            .username("admin")
                            .email("admin@example.com")
                            .firstName("Alice")
                            .lastName("Admin")
                            .password("admin@123")
                            .role(Role.ADMIN)
                            .active(true)
                            .build(),

                    User.builder()
                            .username("manager_bob")
                            .email("bob@example.com")
                            .firstName("Bob")
                            .lastName("Manager")
                            .password("bob@123")
                            .role(Role.MANAGER)
                            .active(true)
                            .build(),

                    User.builder()
                            .username("john_doe")
                            .email("john@example.com")
                            .firstName("John")
                            .lastName("Doe")
                            .password("john@123")
                            .role(Role.USER)
                            .active(true)
                            .build(),

                    User.builder()
                            .username("jane_smith")
                            .email("jane@example.com")
                            .firstName("Jane")
                            .lastName("Smith")
                            .password("jane@123")
                            .role(Role.USER)
                            .active(true)
                            .build(),

                    User.builder()
                            .username("charlie_g")
                            .email("charlie@example.com")
                            .firstName("Charlie")
                            .lastName("Green")
                            .password("charlie@123")
                            .role(Role.USER)
                            .active(false)
                            .build(),

                    User.builder()
                            .username("diana_p")
                            .email("diana@example.com")
                            .firstName("Diana")
                            .lastName("Prince")
                            .password("diana@123")
                            .role(Role.MANAGER)
                            .active(true)
                            .build(),

                    User.builder()
                            .username("guest_user")
                            .email("guest@example.com")
                            .firstName("Guest")
                            .lastName("User")
                            .password("guest@123")
                            .role(Role.GUEST)
                            .active(true)
                            .build(),

                    User.builder()
                            .username("sam_wilson")
                            .email("sam@example.com")
                            .firstName("Sam")
                            .lastName("Wilson")
                            .password("sam@123")
                            .role(Role.USER)
                            .active(true)
                            .build()
            );

            userRepository.saveAll(users);
            log.info("✅ Seeded {} users successfully.", users.size());
        } else {
            log.info("Seed data already present, skipping.");
        }
    }
}
