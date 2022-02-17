package demo.sbsolutionsnepal.yoapp.base.baseDomain;

import demo.sbsolutionsnepal.yoapp.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */


@Data
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Type(type = "timestamp")
    @Column(insertable = false, updatable = false)
    private Date createdAt;
    private Status status = Status.ACTIVE;
}
