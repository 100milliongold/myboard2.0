package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.Point;

import org.springframework.data.repository.CrudRepository;

public interface PointRedisRepository extends CrudRepository<Point, String> {

}