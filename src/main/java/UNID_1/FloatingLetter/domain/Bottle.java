package UNID_1.FloatingLetter.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bottle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp time;
    private boolean closed;

    @OneToMany(mappedBy = "bottle")
    private List<Letter> letterList = new ArrayList<>();

    public void updateClosed() {
        this.closed = true;
    }

}