package com.vaibhav.location.repos;

import com.vaibhav.location.entities.Location;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	@Query(value = "SELECT type, COUNT(type) AS count " +
            "FROM location " +
            "GROUP BY type", nativeQuery = true)
	 public List<Object[]> findTypeAndTypeCount();

}