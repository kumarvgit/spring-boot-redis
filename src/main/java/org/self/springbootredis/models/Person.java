package org.self.springbootredis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@MappedSuperclass
public class Person  implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID") // set generator
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") // define generator
    @Type(type = "org.hibernate.type.UUIDCharType") // set generated type as character
    private UUID id;

    @Column(columnDefinition = "VARCHAR(20)", length = 20)
    @Size(max = 20)
    private String firstName;

    @Column(columnDefinition = "VARCHAR(20)", length = 20)
    @Size(max = 20)
    private String lastName;
}
