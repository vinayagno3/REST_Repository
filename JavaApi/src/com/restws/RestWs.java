package com.restws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.components.Student;

@Path("/message")

public class RestWs 
{

	@GET
	@Path("/sayhello")
	@Produces(MediaType.TEXT_HTML)
	public String sayHello()
	{
		String resource="<h1>WELCOME TO REST WEB SERVICES IN JAVA-Jersey</h1>";
		//resource+="<br> Hello " + name+ " You r From "+city;
		return resource;
		
	}
	
	@GET
	@Path("{ename}")
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloWithPath(@javax.ws.rs.PathParam("ename")String ename)
	{
		String resource="<h1>WELCOME TO REST WEB SERVICES IN JAVA-Jersey</h1>";
		resource+="<br> Hello " + ename;
		return resource;
		
	}
	
	
	@GET()
	@Path("/sayhellowithname")
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloWithNameAndSalary(@QueryParam("name") String name,@QueryParam("income") double annualincome)
	{
		String resource="<h1>WELCOME TO REST WEB SERVICES IN JAVA-Jersey</h1><br/><div style='color:red;'>";
		
		if(annualincome>=500000)
			resource=resource+" Hello " + name + ", Your Income is Taxable ....!";
		else
			resource=resource+" Hello " + name + ", No need for Tax Assessment ....!";
		
		resource+="</div>";
		return resource;
		
	}
	
	@GET()
	@Path("/sayhelloxml")
	@Produces(MediaType.TEXT_XML)
	public String sayHelloxml(@PathParam("roll") int roll)
	{
		
			String resource="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<student>\r\n" + 
				"	<roll>101</roll>\r\n" + 
				"	<name>Vijay Anekar</name>\r\n" + 
				"	<marks>90</marks>\r\n" + 
				"\r\n" + 
				"</student>\r\n" + 
				"";
		return resource;
		
	}
	
	@GET()
	@Path("/sayhellojson")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJson()
	{
		String resource="student\r\n" + 
				"{\r\n" + 
				"\"roll\":101,\r\n" + 
				"\"name\":\"Vijay Anekar\",\r\n" + 
				"\"marks\":90\r\n" + 
				"}";
		return resource;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getstudentdatainjsonformat/{roll}")
	public Student getStudent(@PathParam("roll") int roll) 
	{
		Student st=null;
		
		if(roll==1)
			 st=new Student(1, "Ajay", 90);
		else if(roll==2)
			st=new Student(2, "Vijay", 90);
		
		return st;
	}
	
	//Getting Error For this method calling with URL: http://localhost:8080/JavaApi/rest/message/getstudentdatainxmlformat
	//Error : HTTP Status 500 - Internal Server Error

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getstudentdatainxmlformat")
	public List<Student> getStudentData() 
	{
		List<Student> st= new ArrayList<Student>();
		
		st.add(new Student(1, "Ajay", 90));
		st.add(new Student(2, "Vijay", 90));
		System.out.print(st.toString());
		return st;
	}

}
