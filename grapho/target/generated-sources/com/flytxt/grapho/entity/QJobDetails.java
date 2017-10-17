package com.flytxt.grapho.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobDetails is a Querydsl query type for JobDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobDetails extends EntityPathBase<JobDetails> {

    private static final long serialVersionUID = -1926489529L;

    public static final QJobDetails jobDetails = new QJobDetails("jobDetails");

    public final ArrayPath<byte[], Byte> chartData = createArray("chartData", byte[].class);

    public final StringPath connectionUrl = createString("connectionUrl");

    public final StringPath dbPassword = createString("dbPassword");

    public final StringPath dbType = createString("dbType");

    public final StringPath dbUserName = createString("dbUserName");

    public final NumberPath<Long> jobId = createNumber("jobId", Long.class);

    public final StringPath jobName = createString("jobName");

    public final StringPath sqlQuery = createString("sqlQuery");

    public QJobDetails(String variable) {
        super(JobDetails.class, forVariable(variable));
    }

    public QJobDetails(Path<? extends JobDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobDetails(PathMetadata metadata) {
        super(JobDetails.class, metadata);
    }

}

