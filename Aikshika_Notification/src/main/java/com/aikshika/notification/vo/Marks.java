package com.aikshika.notification.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Marks {

	@JsonProperty("Subject_name")
	private String  subjectName;
	@JsonProperty("Max_marks")
	private String  maxMarks;
	@JsonProperty("Passing_marks")
	private String  passingMarks;
	@JsonProperty("Obtained_marks")
	private String  ObtainedMarks;
	
}
