package springstudy.toyproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springstudy.toyproject1.member.Post;
import springstudy.toyproject1.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    PostRepository postRepository;
    Post post;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //ID로 리스트 찾기
    @GetMapping("/posts/{id}")
    public Optional<Post> findPostById(@PathVariable("id") Long id) {
        Optional<Post> findPost = postRepository.findById(id);
        return findPost;
    }

    //모든 리스트 찾기
    @GetMapping("/posts/all")
    public List findAllPosts() {
        return postRepository.findAll();
    }


    //제목으로 리스트 찾기
    @GetMapping("/posts/{title}")
    public Optional<Post> findPostByTitle(@PathVariable("title") String title) {
        Optional<Post> findPost = postRepository.findByTitle(title);
        return findPost;
    }

    //리스트 저장
    @GetMapping("/posts")
    public void savePost(@RequestParam("title") String title, @RequestParam("content") String content) {
        post = new Post(title, content);
        postRepository.save(post);
    }
}
