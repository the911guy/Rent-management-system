package com.houserental.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<Houses, Integer> {

}
