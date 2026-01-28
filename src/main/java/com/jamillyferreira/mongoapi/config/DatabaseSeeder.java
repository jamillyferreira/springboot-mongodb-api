package com.jamillyferreira.mongoapi.config;

import com.jamillyferreira.mongoapi.dto.AuthorDTO;
import com.jamillyferreira.mongoapi.model.Post;
import com.jamillyferreira.mongoapi.model.User;
import com.jamillyferreira.mongoapi.repository.PostRepository;
import com.jamillyferreira.mongoapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PostRepository postRepository) {
        return args -> {
            userRepository.deleteAll();
            postRepository.deleteAll();

            User user1 = new User("Maria Silva", "maria@email.com");
            User user2 = new User("João Santos", "joao@email.com");
            User user3 = new User("Ana Costa", "ana@email.com");

            userRepository.saveAll(List.of(user1, user2, user3));

            Post post1 = new Post(new Date(), "Introdução ao MongoDB",
                    "MongoDB é um banco de dados NoSQL orientado a documentos...",
                    new AuthorDTO(user1));

            Post post2 = new Post(new Date(), "Spring Boot e MongoDB",
                    "A integração entre Spring Boot e MongoDB é simples e poderosa...",
                    new AuthorDTO(user2));

            Post post3 = new Post(new Date(), "Boas Práticas",
                    "Ao trabalhar com MongoDB, algumas práticas são essenciais...",
                    new AuthorDTO(user3));


            postRepository.saveAll(List.of(post1, post2, post3));

            System.out.println("Dados iniciais carregados com sucesso!");
        };
    }
}
