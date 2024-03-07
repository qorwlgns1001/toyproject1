package springstudy.toyproject1.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post_table")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String content;
}
