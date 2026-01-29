package com.jamillyferreira.mongoapi.config;

import com.jamillyferreira.mongoapi.dto.AuthorDTO;
import com.jamillyferreira.mongoapi.dto.CommentDTO;
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
            User user2 = new User("Ana Costa", "ana@email.com");
            User user3 = new User("Pedro Alves", "pedroalves@email.com");

            userRepository.saveAll(List.of(user1, user2, user3));

            Post post1 = new Post(new Date(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(user1));
            Post post2 = new Post(new Date(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));

            CommentDTO comment1 = new CommentDTO("Boa viagem mano!", new Date(), new AuthorDTO(user2));
            CommentDTO comment2 = new CommentDTO("Aproveite", new Date(), new AuthorDTO(user3));
            CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia", new Date(), new AuthorDTO(user2));

            post1.getComments().addAll(List.of(comment1, comment2));
            post2.getComments().add(comment3);


            postRepository.saveAll(List.of(post1, post2));

            user1.getPosts().addAll(List.of(post1, post2));
            userRepository.save(user1);

            System.out.println("Dados iniciais carregados com sucesso!");
        };
    }
}
