package com.imooc.aop.datalog;

import com.imooc.aop.domain.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionDao extends MongoRepository<Action,String> {
}
