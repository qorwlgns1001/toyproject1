package springstudy.toyproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springstudy.toyproject1.member.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitle(String title);
}
