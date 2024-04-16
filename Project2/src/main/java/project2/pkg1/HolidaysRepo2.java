package project2.pkg1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HolidaysRepo2 extends JpaRepository<HolidaysEntity2, Integer> {
	@Query(value="select * from holidays where month(date)=:date",nativeQuery=true)
	public List<HolidaysEntity2> findByMonth(@Param(value = "date") int date );
}
