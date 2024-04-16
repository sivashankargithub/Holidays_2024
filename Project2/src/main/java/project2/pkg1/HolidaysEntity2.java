package project2.pkg1;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="holidays")
public class HolidaysEntity2 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String holiday;
	private LocalDate date;
	private String day;
	public HolidaysEntity2(String holiday, LocalDate date, String day) {
		super();
		this.holiday = holiday;
		this.date = date;
		this.day = day;
	}
	public HolidaysEntity2() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
}
