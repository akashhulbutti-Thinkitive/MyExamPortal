package com.akash.examschedular;

import java.util.TimerTask;

public class ExamTimer extends TimerTask {
	public static int counter = 0;

	@Override
	public void run() {
		counter++;
		System.out.print("Counter : " + counter);
	}
}
