package com.example.student.module.admission;
import com.example.student.module.department.major.course.Course;
import com.example.student.module.department.major.course.CourseAdmissionProxy;
import com.example.student.module.studnet.Student;
import com.example.student.module.studnet.StudentAdmissionProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class AdmissionListener {


    private final StudentAdmissionProxy studentAdmissionProxy;
    private final CourseAdmissionProxy courseAdmissionProxy;


    @RabbitListener(queues = "droppedCourse")
        public void dropRequest(String enroll){
            JSONObject jsonObject = new JSONObject(enroll);

            Long studentId = jsonObject.getLong("studentId");
            Long courseId = jsonObject.getLong("courseId");

        Student student = studentAdmissionProxy.findStudent(studentId);
        Course course = courseAdmissionProxy.findCourse(courseId);

        log.info("Student "+student.getName()+" ID: "+student.getId()+" requested to drop course " +
                course.getName());

    }
}
