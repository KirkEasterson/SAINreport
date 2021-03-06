
package model;

import java.util.ArrayList;

public class CourseBag
{
	private ArrayList<Course> courseList;
	private int courseCount;
	
	public CourseBag()
	{
		courseList = new ArrayList<>();
		courseCount = 0;
	}
	
	public void add(Course course)
	{
		courseList.add(course);
		courseCount++;
	}
	
	public ArrayList<Course> getCourseList()
	{
		return courseList;
	}
	
	public Course findByString(String courseName)
	{
		for (Course tempCourse : courseList)
		{
			if (tempCourse.getCourseTitle().equals(courseName))
			{
				return tempCourse;
			}
		}
		return null;
	}
	
}
