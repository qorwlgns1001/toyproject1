package springstudy.toyproject1.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_table")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Member {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String password;

    @NonNull
    @Column(unique = true, nullable = false)
    private String nickname;
}
