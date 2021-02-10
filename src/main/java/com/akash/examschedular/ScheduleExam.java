package com.akash.examschedular;

import java.util.Timer;

public class ScheduleExam {
   
    
    public void simpleCounter() throws InterruptedException {
        Timer time = new Timer(); 
        ExamTimer et =new ExamTimer();
        time.schedule(et, 0, 1000); 

        //for demo only.
        for (int i = 0; i <= 5; i++) {
            System.out.println("Execution in Main Thread...." + i);
            Thread.sleep(3000);
            if (i == 5) {
                System.out.println("Application Terminates");
                
            }
        }
    }

}
