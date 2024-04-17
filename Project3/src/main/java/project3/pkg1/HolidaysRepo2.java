package project3.pkg1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HolidaysRepo2 extends JpaRepository<HolidaysEntity2, Integer> {
	@Query(value="select * from holidays2024 where extract(month from date)=:mon",nativeQuery=true)
	public List<HolidaysEntity2> findByMonth(@Param(value = "mon") int month );
}
