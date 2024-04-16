package project1.pkg1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidaysController1 {
	@GetMapping("/holidays/2024")
	public String holidays()throws IOException{
		String temp1 = "";
		File f1=new File("holidays1.csv");
		Scanner sc1=new Scanner(f1);
		while(sc1.hasNext()) {
			String s1=sc1.nextLine();
			temp1=temp1+s1+"\n";
		}
		System.out.println(temp1);
		return temp1;
	}
}
