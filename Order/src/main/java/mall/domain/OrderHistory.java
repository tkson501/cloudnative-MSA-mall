package mall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderHistory_table")
@Data
public class OrderHistory {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
