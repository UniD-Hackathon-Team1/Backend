package UNID_1.FloatingLetter.domain;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bottle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time = LocalDateTime.now();
    private boolean closed = false;

    @OneToMany(mappedBy = "bottle")
    private List<Letter> letterList = new ArrayList<>();

    public void updateClosed() {
        this.closed = true;
    }

}