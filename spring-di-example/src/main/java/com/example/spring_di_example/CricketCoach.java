package com.example.spring_di_example;

public class CricketCoach implements Coach {

	private FortuneService forturnService;
	
	public FortuneService getFortuneService() {
		return forturnService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.forturnService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practicing the daily workout";
	}

	@Override
	public String getDailyForturn() {
		// TODO Auto-generated method stub
		return forturnService.getDailyForturn();
	}

}
