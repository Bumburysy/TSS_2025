package com.tss.repositories;

import org.springframework.data.repository.CrudRepository;
import com.tss.entities.City;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends CrudRepository<City, Long> {
    
    List<City> findAllByOrderByNameAsc();
    
    @Query("SELECT new com.tss.repositories.CityReport('Małe', COUNT(c.id)) " + "FROM City AS c WHERE c.population<100000 ")
    List<CityReport> countCitiesPopulation();
    
    @Query(value="SELECT 'Małe' AS citySize, COUNT(c.id) AS cityCount " 
    + "FROM City AS c WHERE c.population<100000 "
    + "UNION ALL "
    + "SELECT 'Średnie', COUNT(c.id)"
    + "FROM City AS c WHERE c.population>=100000 AND c.population<200000 "
    + "UNION ALL "
    + "SELECT 'Duże', COUNT(c.id)"
    + "FROM City AS c WHERE c.population>=200000",nativeQuery=true)
    List<ICityReport> countCitiesPopulationNativeQuery();
}
