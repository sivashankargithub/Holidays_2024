package project3.pkg1;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidaysController2 {
	@Autowired
	HolidaysRepo2 hr;
	
	@PostMapping("/holidays/loadData/{fname}")
	public String loadData(@PathVariable String fname) throws IOException{
		File f1=new File(fname);
		Scanner sc1=new Scanner(f1);
		while(sc1.hasNext()) {
			String[] arr1=sc1.nextLine().split(",");
			LocalDate date1=LocalDate.parse(arr1[2]);
			hr.save(new HolidaysEntity2(arr1[1],date1,arr1[3]));
		}
		return "Inserted Successfully";
	}
	
	@GetMapping("/holidays/2024")
	public List<HolidaysEntity2> findAllHolidays(){
		return hr.findAll();
	}
	@GetMapping("/holidays/2024/{month}")
	public List<HolidaysEntity2> findHolidaysByMonth(@PathVariable int month){
		return hr.findByMonth(month);
	}
	
}
