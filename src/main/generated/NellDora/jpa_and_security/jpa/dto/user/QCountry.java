package NellDora.jpa_and_security.jpa.dto.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCountry is a Querydsl query type for Country
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCountry extends EntityPathBase<Country> {

    private static final long serialVersionUID = -191738406L;

    public static final QCountry country = new QCountry("country");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final ListPath<User, QUser> userList = this.<User, QUser>createList("userList", User.class, QUser.class, PathInits.DIRECT2);

    public QCountry(String variable) {
        super(Country.class, forVariable(variable));
    }

    public QCountry(Path<? extends Country> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCountry(PathMetadata metadata) {
        super(Country.class, metadata);
    }

}

