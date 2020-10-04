package com.wellsfargo.fsd.jw2.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import com.wellsfargo.fsd.jw2.model.VisitorModel;

//write business logic here
public class VisitorService {

	public void computeAge(VisitorModel visitorModel) {
		Period p= Period.between(visitorModel.getDateOfBirth(), LocalDate.now());
		visitorModel.setAge(p.getYears());
	}
	
	public String getGreeting() {
		String greetings="";
		int h=LocalTime.now().getHour();
		if(h>=4 &&h<12) {
			greetings="Good Morning";
		}else if(h>=12 && h<=16) {greetings="Good Afternoon";
		}else greetings="Good Night";
		
		
		return greetings;
		
	}
}
