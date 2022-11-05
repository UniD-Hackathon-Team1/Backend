package UNID_1.FloatingLetter.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
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

    private Date time;
    private boolean closed;

    @OneToMany(mappedBy = "bottle")
    private List<Letter> letterList = new ArrayList<>();

    public Bottle(Date time, boolean closed) {
        this.time = time;
        this.closed = closed;
    }

    public void updateClosed() {
        this.closed = true;
    }

}