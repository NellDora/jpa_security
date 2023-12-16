package NellDora.jpa_and_security.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUrl is a Querydsl query type for Url
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUrl extends EntityPathBase<Url> {

    private static final long serialVersionUID = 1003762638L;

    public static final QUrl url1 = new QUrl("url1");

    public final ListPath<Authority, QAuthority> authorities = this.<Authority, QAuthority>createList("authorities", Authority.class, QAuthority.class, PathInits.DIRECT2);

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final StringPath url = createString("url");

    public QUrl(String variable) {
        super(Url.class, forVariable(variable));
    }

    public QUrl(Path<? extends Url> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUrl(PathMetadata metadata) {
        super(Url.class, metadata);
    }

}

