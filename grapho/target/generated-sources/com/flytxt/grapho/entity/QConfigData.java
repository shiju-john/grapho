package com.flytxt.grapho.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConfigData is a Querydsl query type for ConfigData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConfigData extends EntityPathBase<ConfigData> {

    private static final long serialVersionUID = -900013938L;

    public static final QConfigData configData = new QConfigData("configData");

    public final StringPath key = createString("key");

    public final StringPath remarks = createString("remarks");

    public final StringPath type = createString("type");

    public final StringPath value = createString("value");

    public QConfigData(String variable) {
        super(ConfigData.class, forVariable(variable));
    }

    public QConfigData(Path<? extends ConfigData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConfigData(PathMetadata metadata) {
        super(ConfigData.class, metadata);
    }

}

