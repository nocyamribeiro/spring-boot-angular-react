package com.iqvia.clinicals.util;

import org.springframework.stereotype.Component;

import com.iqvia.clinicals.api.model.ClinicalData;
import com.iqvia.clinicals.api.model.Patient;

public class BMICalculator {

	public static void calculateBMI(Patient patient, ClinicalData eachEntry) {
		if (eachEntry.getComponentName().equals("hw")) {
			String[] heightAndWeight = eachEntry.getComponentValue().split("/");
			if (heightAndWeight != null && heightAndWeight.length > 1) {
				float feetToMetres = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
				float BMI = Float.parseFloat(heightAndWeight[1]) / (feetToMetres * feetToMetres);
				ClinicalData bmiEntry = new ClinicalData();
				bmiEntry.setComponentName("BMI");
				bmiEntry.setComponentValue(Float.toString(BMI));
				patient.getClinicalData().add(bmiEntry);
			}
		}
	}
}
