package main.als.problem.entity;

import jakarta.persistence.*;
import lombok.*;
import main.als.group.entity.Group;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="group_problems")
public class GroupProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem; // 선택된 문제

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group; // 문제와 관련된 그룹

    private LocalDateTime createdAt; // 선택 시간
    private LocalDateTime deadline; // 문제 제출 마감 시간
}
