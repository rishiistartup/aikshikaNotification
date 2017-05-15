package com.aikshika.notification.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentMarks {

	@JsonProperty("_id")
	private String id;
	@JsonProperty("student_id")
	private Integer studentId;
	@JsonProperty("class_id")
	private Integer classId;
	@JsonProperty("exam_type")
	private String examType;
	@JsonProperty("exam_date")
	private Date examDate;
	@JsonProperty("marks")
	private List<Marks> marks;
	@JsonProperty("section_id")
	private String sectionId;


	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}


	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

}
