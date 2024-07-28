package org.lab.dao.mapper.ds1;



import org.apache.ibatis.annotations.Param;
import org.lab.dao.model.Car;

import java.util.Collection;
import java.util.List;

public interface CarMapper {

  List<Car> pageQuery(@Param("limit") Integer limit, @Param("offset") Integer offset);

  void insert(@Param("cars") Collection<Car> cars);

  void deleteByCarNos(@Param("carNos") Collection<String> carNos);
}