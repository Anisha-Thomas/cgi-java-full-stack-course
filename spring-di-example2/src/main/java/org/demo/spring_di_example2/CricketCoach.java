package org.demo.spring_di_example2;

public class CricketCoach implements Coach {

	private String email;
	private String team;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

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

	public void initCricketCoach() {
		System.out.println("Intialized");
	}
	public void customDestroyMethod() {
		System.out.println("Destroyed");
	}


}
