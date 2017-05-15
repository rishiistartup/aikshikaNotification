package com.aikshika.notification.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.aikshika.notification.service.DreamFactoryService;
import com.aikshika.notification.vo.StudentList;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DreamFactoryServiceImpl implements DreamFactoryService {

	@Override
	public StudentList fecthMarks() {
		StudentList studentList = new StudentList();
		try {
			URL url = new URL(
					// "http://54.89.59.195/api/v2/sms/_schema/bitnami_dreamfactory.app?");
					"http://54.89.59.195/api/v2/msdb/_table/marks");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-DreamFactory-Api-Key",
					"0693afaa87681ec061fd3f438e7aa6fccb82d8c8ba38820f6a53d21f0f33cbd3");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			ObjectMapper mapper = new ObjectMapper();
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				String jsonOutput = output;
				studentList = mapper.readValue(jsonOutput, StudentList.class);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		return studentList;
	}

}
