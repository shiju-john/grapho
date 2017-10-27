package com.flytxt.grapho.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConnectorMetaData is a Querydsl query type for ConnectorMetaData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConnectorMetaData extends EntityPathBase<ConnectorMetaData> {

    private static final long serialVersionUID = 1135593978L;

    public static final QConnectorMetaData connectorMetaData = new QConnectorMetaData("connectorMetaData");

    public final StringPath config = createString("config");

    public final StringPath configTemplate = createString("configTemplate");

    public final NumberPath<Long> connectorMetaId = createNumber("connectorMetaId", Long.class);

    public final StringPath connectorName = createString("connectorName");

    public final StringPath scriptType = createString("scriptType");

    public final StringPath validationRegEx = createString("validationRegEx");

    public QConnectorMetaData(String variable) {
        super(ConnectorMetaData.class, forVariable(variable));
    }

    public QConnectorMetaData(Path<? extends ConnectorMetaData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConnectorMetaData(PathMetadata metadata) {
        super(ConnectorMetaData.class, metadata);
    }

}

