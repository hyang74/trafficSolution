package SEG2106.core;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3369 modeling language!*/



// line 1 "model.ump"
public class TrafficLight implements EventHandler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
 
  int trafficStatus =0;
  enum Status0 { northAndSouthGreen, northAndSouthYellow, northAndSouthRed, westAndEastYellow }
  private Status0 status0;
  
//TrafficLight State Machines
  public enum StatusModerate { northGreenAndArrow, northYellow, southGreenAndArrow, southYellow, westAndEastGreen, westAndEastYellow }
  private StatusModerate statusModerate;
  
  public enum LowTrafficMode { northAndSouthArrow, northAndSouthGreen, northAndSouthYellow, westAndEastGreen, westAndEastYellow }
  private LowTrafficMode lowTrafficMode;

  public enum HighTraffic { northGreenArrow, northIsYellow, southGreenArrow, southIsYellow, westGreenArrow, eastWestGreen, eastWestYellow }
  private HighTraffic highTraffic;
  //------------------------
  // CONSTRUCTOR
  //------------------------
  private TrafficLightManager trafficLightManager; 

  public TrafficLight(TrafficLightManager trafficLightManager)
  {
		this.trafficLightManager = trafficLightManager;
		  
		setStatus0(Status0.northAndSouthGreen);
	    
	    trafficLightManager.addEventHandler(this);
  }

//------------------------
  // INTERFACE
  //------------------------

  public String getStatus0FullName()
  {
    String answer = status0.toString();
    return answer;
  }

  public Status0 getStatus0()
  {
    return status0;
  }
  
  public String getStatusModerateFullName()
  {
    String answer = statusModerate.toString();
    return answer;
  }

  public StatusModerate getStatusModerate()
  {
    return statusModerate;
  }
  

  public String getLowTrafficModeFullName()
  {
    String answer = lowTrafficMode.toString();
    return answer;
  }

  public LowTrafficMode getLowTrafficMode()
  {
    return lowTrafficMode;
  }

  public String getHighTrafficFullName()
  {
    String answer = highTraffic.toString();
    return answer;
  }

  public HighTraffic getHighTraffic()
  {
    return highTraffic;
  }
  
  
  public boolean timerGreen()
  {
	 if(trafficStatus== 0){
    boolean wasEventProcessed = false;
    
    Status0 aStatus = status0;
    switch (aStatus)
    {
      case northAndSouthGreen:
        setStatus0(Status0.northAndSouthYellow);
        wasEventProcessed = true;
        break;
      case northAndSouthRed:
        setStatus0(Status0.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;}
	 else if(trafficStatus== 1){
		 boolean wasEventProcessed = false;
		    
		    LowTrafficMode aLowTrafficMode = lowTrafficMode;
		    switch (aLowTrafficMode)
		    {
		      case northAndSouthArrow:
		        setLowTrafficMode(LowTrafficMode.northAndSouthGreen);
		        wasEventProcessed = true;
		        break;
		      case northAndSouthGreen:
		        setLowTrafficMode(LowTrafficMode.northAndSouthYellow);
		        wasEventProcessed = true;
		        break;
		      case westAndEastGreen:
		        setLowTrafficMode(LowTrafficMode.westAndEastYellow);
		        wasEventProcessed = true;
		        break;
		      default:
		        // Other states do respond to this event
		    }

		    return wasEventProcessed;
	 }
	 else if(trafficStatus==2){
		 boolean wasEventProcessed = false;
	    
	    StatusModerate aStatusModerate = statusModerate;
	    switch (aStatusModerate)
	    {
	      case northGreenAndArrow:
	        setStatusModerate(StatusModerate.northYellow);
	        wasEventProcessed = true;
	        break;
	      case southGreenAndArrow:
	        setStatusModerate(StatusModerate.southYellow);
	        wasEventProcessed = true;
	        break;
	      case westAndEastGreen:
	        setStatusModerate(StatusModerate.westAndEastYellow);
	        wasEventProcessed = true;
	        break;
	      default:
	        // Other states do respond to this event
	    }

	    return wasEventProcessed;
		 
	 }
	 else if(trafficStatus==3){
		 boolean wasEventProcessed = false;
		    
		    HighTraffic aHighTraffic = highTraffic;
		    switch (aHighTraffic)
		    {
		      case northGreenArrow:
		        setHighTraffic(HighTraffic.northIsYellow);
		        wasEventProcessed = true;
		        break;
		      case southGreenArrow:
		        setHighTraffic(HighTraffic.southIsYellow);
		        wasEventProcessed = true;
		        break;
		      case westGreenArrow:
		        setHighTraffic(HighTraffic.eastWestGreen);
		        wasEventProcessed = true;
		        break;
		      case eastWestYellow:
		        setHighTraffic(HighTraffic.northGreenArrow);
		        wasEventProcessed = true;
		        break;
		      default:
		        // Other states do respond to this event
		    }

		    return wasEventProcessed;
	 }
	 return false;
  }

  public boolean timerYellow()
  {
	  if(trafficStatus==0){
    boolean wasEventProcessed = false;
    
    Status0 aStatus = status0;
    switch (aStatus)
    {
      case northAndSouthYellow:
        setStatus0(Status0.northAndSouthRed);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        setStatus0(Status0.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }
	  else  if(trafficStatus==1){
		  boolean wasEventProcessed = false;
		    
		    LowTrafficMode aLowTrafficMode = lowTrafficMode;
		    switch (aLowTrafficMode)
		    {
		      case northAndSouthYellow:
		        setLowTrafficMode(LowTrafficMode.westAndEastGreen);
		        wasEventProcessed = true;
		        break;
		      case westAndEastYellow:
		        setLowTrafficMode(LowTrafficMode.northAndSouthArrow);
		        wasEventProcessed = true;
		        break;
		      default:
		        // Other states do respond to this event
		    }

		    return wasEventProcessed;
	  }
	  else if (trafficStatus ==2){
		  boolean wasEventProcessed = false;
		    
		    StatusModerate aStatusModerate = statusModerate;
		    switch (aStatusModerate)
		    {
		      case northYellow:
		        setStatusModerate(StatusModerate.southGreenAndArrow);
		        wasEventProcessed = true;
		        break;
		      case southYellow:
		        setStatusModerate(StatusModerate.westAndEastGreen);
		        wasEventProcessed = true;
		        break;
		      case westAndEastYellow:
		        setStatusModerate(StatusModerate.northGreenAndArrow);
		        wasEventProcessed = true;
		        break;
		      default:
		        // Other states do respond to this event
		    }

		    return wasEventProcessed;
	  
	  
	  }
	  else  if(trafficStatus==3){
		  boolean wasEventProcessed = false;
		    
		    HighTraffic aHighTraffic = highTraffic;
		    switch (aHighTraffic)
		    {
		      case northIsYellow:
		        setHighTraffic(HighTraffic.southGreenArrow);
		        wasEventProcessed = true;
		        break;
		      case southIsYellow:
		        setHighTraffic(HighTraffic.westGreenArrow);
		        wasEventProcessed = true;
		        break;
		      case eastWestGreen:
		        setHighTraffic(HighTraffic.eastWestYellow);
		        wasEventProcessed = true;
		        break;
		      default:
		        // Other states do respond to this event
		    }

		    return wasEventProcessed;
	  }
	  return false;
	  }

  private void setStatus0(Status0 aStatus)
  {
    status0 = aStatus;

    // entry actions and do activities
    switch(status0)
    {
      case northAndSouthGreen:
        // line 8 "model.ump"
        trafficLightManager.northGreen();
        // line 9 "model.ump"
        trafficLightManager.southGreen();
        // line 10 "model.ump"
        trafficLightManager.westRed();
        // line 11 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        // line 16 "model.ump"
        trafficLightManager.northYellow();
        // line 17 "model.ump"
        trafficLightManager.southYellow();
        // line 18 "model.ump"
        trafficLightManager.westRed();
        // line 19 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRed:
        // line 24 "model.ump"
        trafficLightManager.northRed();
        // line 25 "model.ump"
        trafficLightManager.southRed();
        // line 26 "model.ump"
        trafficLightManager.westGreen();
        // line 27 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 32 "model.ump"
        trafficLightManager.northRed();
        // line 33 "model.ump"
        trafficLightManager.southRed();
        // line 34 "model.ump"
        trafficLightManager.westYellow();
        // line 35 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  private void setHighTraffic(HighTraffic aHighTraffic)
  {
    highTraffic = aHighTraffic;

    // entry actions and do activities
    switch(highTraffic)
    {
      case northGreenArrow:
        // line 6 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 7 "model.ump"
        trafficLightManager.westRed();
        // line 8 "model.ump"
        trafficLightManager.eastRed();
        // line 9 "model.ump"
        trafficLightManager.southRed();
        break;
      case northIsYellow:
        // line 13 "model.ump"
        trafficLightManager.northYellow();
        // line 14 "model.ump"
        trafficLightManager.westRed();
        // line 15 "model.ump"
        trafficLightManager.eastRed();
        // line 16 "model.ump"
        trafficLightManager.southRed();
        break;
      case southGreenArrow:
        // line 20 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 21 "model.ump"
        trafficLightManager.westRed();
        // line 22 "model.ump"
        trafficLightManager.eastRed();
        // line 23 "model.ump"
        trafficLightManager.northRed();
        break;
      case southIsYellow:
        // line 27 "model.ump"
        trafficLightManager.southYellow();
        // line 28 "model.ump"
        trafficLightManager.westRed();
        // line 29 "model.ump"
        trafficLightManager.eastRed();
        // line 30 "model.ump"
        trafficLightManager.northRed();
        break;
      case westGreenArrow:
        // line 34 "model.ump"
        trafficLightManager.westGreenAndArrow();
        // line 35 "model.ump"
        trafficLightManager.southRed();
        // line 36 "model.ump"
        trafficLightManager.eastRed();
        // line 37 "model.ump"
        trafficLightManager.northRed();
        break;
      case eastWestGreen:
    	  System.out.println("east and west green");
        // line 41 "model.ump"
        trafficLightManager.westGreen();
        // line 42 "model.ump"
        trafficLightManager.eastGreen();
        // line 43 "model.ump"
        trafficLightManager.northRed();
        // line 44 "model.ump"
        trafficLightManager.southRed();
        break;
      case eastWestYellow:
        // line 48 "model.ump"
    	  System.out.println("east and west yellow");
        trafficLightManager.westYellow();
        // line 49 "model.ump"
        trafficLightManager.eastYellow();
        // line 50 "model.ump"
        trafficLightManager.northRed();
        // line 51 "model.ump"
        trafficLightManager.southRed();
        break;
    }
  }

  private void setStatusModerate(StatusModerate aStatusModerate)
  {
    statusModerate = aStatusModerate;

    // entry actions and do activities
    switch(statusModerate)
    {
      case northGreenAndArrow:
        // line 5 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 6 "model.ump"
        trafficLightManager.southRed();
        // line 7 "model.ump"
        trafficLightManager.westRed();
        // line 8 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellow:
        // line 12 "model.ump"
        trafficLightManager.northYellow();
        // line 13 "model.ump"
        trafficLightManager.southRed();
        // line 14 "model.ump"
        trafficLightManager.westRed();
        // line 15 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenAndArrow:
        // line 19 "model.ump"
        trafficLightManager.northRed();
        // line 20 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 21 "model.ump"
        trafficLightManager.westRed();
        // line 22 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellow:
        // line 26 "model.ump"
        trafficLightManager.southYellow();
        // line 27 "model.ump"
        trafficLightManager.northRed();
        // line 28 "model.ump"
        trafficLightManager.westRed();
        // line 29 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreen:
        // line 33 "model.ump"
        trafficLightManager.southRed();
        // line 34 "model.ump"
        trafficLightManager.northRed();
        // line 35 "model.ump"
        trafficLightManager.westGreen();
        // line 36 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 40 "model.ump"
        trafficLightManager.southRed();
        // line 41 "model.ump"
        trafficLightManager.northRed();
        // line 42 "model.ump"
        trafficLightManager.westYellow();
        // line 43 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }
 
  
  private void setLowTrafficMode(LowTrafficMode aLowTrafficMode)
  {
	  lowTrafficMode = aLowTrafficMode;

	    // entry actions and do activities
	    switch(lowTrafficMode)
	    {
	      case northAndSouthArrow:
	        // line 6 "model.ump"
	        trafficLightManager.northArrow();
	        // line 7 "model.ump"
	        trafficLightManager.southArrow();
	        // line 8 "model.ump"
	        trafficLightManager.westRed();
	        // line 9 "model.ump"
	        trafficLightManager.eastRed();
	        break;
	      case northAndSouthGreen:
	        // line 14 "model.ump"
	        trafficLightManager.northGreen();
	        // line 15 "model.ump"
	        trafficLightManager.southGreen();
	        // line 16 "model.ump"
	        trafficLightManager.westRed();
	        // line 17 "model.ump"
	        trafficLightManager.eastRed();
	        break;
	      case northAndSouthYellow:
	        // line 22 "model.ump"
	        trafficLightManager.northYellow();
	        // line 23 "model.ump"
	        trafficLightManager.southYellow();
	        // line 24 "model.ump"
	        trafficLightManager.westRed();
	        // line 25 "model.ump"
	        trafficLightManager.eastRed();
	        break;
	      case westAndEastGreen:
	        // line 30 "model.ump"
	        trafficLightManager.northRed();
	        // line 31 "model.ump"
	        trafficLightManager.southRed();
	        // line 32 "model.ump"
	        trafficLightManager.westGreen();
	        // line 33 "model.ump"
	        trafficLightManager.eastGreen();
	        break;
	      case westAndEastYellow:
	        // line 37 "model.ump"
	        trafficLightManager.westYellow();
	        // line 38 "model.ump"
	        trafficLightManager.eastYellow();
	        // line 39 "model.ump"
	        trafficLightManager.northRed();
	        // line 40 "model.ump"
	        trafficLightManager.southRed();
	        break;
    }
  }
  
  public void delete()
  {}

@Override
public boolean moderateTraffic() {
	// TODO Auto-generated method stub
	trafficStatus=2;
	System.out.println("modertate mode");
	setStatusModerate(statusModerate.northGreenAndArrow);
    trafficLightManager.addEventHandler(this);

	
	return false;
}

@Override
public boolean lowTraffic() {
	trafficStatus=1;
	setLowTrafficMode(lowTrafficMode.northAndSouthArrow);
	trafficLightManager.addEventHandler(this);
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean highTraffic() {
	trafficStatus=3;
	setHighTraffic(highTraffic.northGreenArrow);
	trafficLightManager.addEventHandler(this);
	// TODO Auto-generated method stub
	return false;
	// TODO Auto-generated method stub

}

}