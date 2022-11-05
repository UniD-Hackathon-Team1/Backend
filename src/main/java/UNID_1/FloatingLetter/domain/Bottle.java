package UNID_1.FloatingLetter.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bottle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time;
    private boolean closed;

    @OneToMany(mappedBy = "bottle")
    private List<Letter> letterList = new ArrayList<>();

    public Bottle(LocalDateTime time, boolean closed) {
        this.time = time;
        this.closed = closed;
    }

    public void updateClosed() {
        this.closed = true;
    }

}