# Assignment
Major Libraries/Frameworks used:

        Spring Boot:for Creating Rest API
	Hibernate:for carrying out Database Operations
	JUNIT:For performing Unit Tests
	Log4J2: For Logging 
	
Plus Points:

    JUNIT: I have worked on JUNIT for testing weather API is working as Expected or not .I have Added Tests for Checking 
	   data persistance in database in both Patients and Appointments data.
		   
    Log4J2: I have used log4j2 for logging important information that might be useful while running the Application.I have used logging 
	        in Controller classes.
	
    Maven:  I have used maven as build type.Maven is handling all the dependencies in Project such as  springboot,JUNIT and log4j2 as well.
	
How to Run Tests:

            Tests can be executed from IDE by running them as JUNIT tests.Following tests are incorporated:
    
	    1. testPatientUpdation()
	        To check weather updation API is working properly or not.
 	    2. testGetAllPatientsInOrder()
                To check weather all the records are being retrieved properly or not.
            3. persistanceWorksPatient()
		To make sure data is being persisted in database
		   
How to deploy the Project:

    You should be able to test the REST endpoint by opening up your browser and hitting
	http://localhost:8080/patients
	
	rest of the endpoints used are:
 	http://localhost:8080/patients/{id}
        http://localhost:8080/makeappointment
	http://localhost:8080/appointments
