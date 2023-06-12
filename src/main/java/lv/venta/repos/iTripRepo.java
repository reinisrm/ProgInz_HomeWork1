package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Trip;

public interface iTripRepo extends CrudRepository<Trip, Long> {

}
