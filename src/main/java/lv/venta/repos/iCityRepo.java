package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.City;

public interface iCityRepo extends CrudRepository<City, Long> {

}
