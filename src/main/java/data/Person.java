package data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@AllArgsConstructor
@Setter
@Getter
@Table("people")
public class Person {
    @PrimaryKey("id")
    private int id;
    private @NonNull String fullname;
    private @NonNull int age;
}
