package io.jopen.core.function;

import com.planet.biz.config.ServiceException;

import java.util.Map;

/**
 * @author maxuefeng
 */
@FunctionalInterface
public interface PredicateCondition<T> {

    T test(Map<String, Object> args) throws ServiceException;
}
