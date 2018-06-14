package com.busyqa.crm;

import com.busyqa.crm.pojo.course.Course;
import com.busyqa.crm.pojo.student.LearningProfile;
import com.busyqa.crm.pojo.student.LearningStatus;
import com.busyqa.crm.pojo.student.StudentProfile;
import com.busyqa.crm.repo.PaymentPlanWeekRepo;
import com.busyqa.crm.repo.PaymentRecordRepo;
import com.busyqa.crm.repo.StudentCourseProfileRepo;
import com.busyqa.crm.repo.StudentProfileRep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CRMService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentProfileRep studentProfileRep;
    @Autowired
    private StudentCourseProfileRepo studentCourseProfileRepo;

    @Autowired
    private PaymentRecordRepo paymentRecordRepo;
    @Autowired
    private PaymentPlanWeekRepo paymentPlanWeekRepo;


    public CRMService(PaymentPlanWeekRepo paymentPlanWeekRepo, PaymentRecordRepo paymentRecordRepo, StudentCourseProfileRepo studentCourseProfileRepo, StudentProfileRep studentProfileRep) {
        this.studentProfileRep = studentProfileRep;
        this.studentCourseProfileRepo = studentCourseProfileRepo;

        this.paymentRecordRepo = paymentRecordRepo;
        this.paymentPlanWeekRepo = paymentPlanWeekRepo;

        //Mock-Course
        Course course1 = new Course("FSJ-2018S", "Full Stak Java", "2018 Summer");
        Course course2 = new Course("AT-2018S", "Auto Testing", "2018 Summer");
        Course course3 = new Course("SM-2018S", "Scrum Master", "2018 Summer");



        //Mock-LearningProfile
        LearningProfile scp11 = new LearningProfile(course1, LearningStatus.LEAD, "Contact on Monday");
        LearningProfile scp12 = new LearningProfile(course2, LearningStatus.LEAD, "Contact on Monday");
        LearningProfile scp13 = new LearningProfile(course3, LearningStatus.LEAD, "Contact on Monday");

        LearningProfile scp21 = new LearningProfile(course1, LearningStatus.LEAD, "Contact on Monday");
        LearningProfile scp22 = new LearningProfile(course2, LearningStatus.LEAD, "Contact on Monday");
        LearningProfile scp23 = new LearningProfile(course3, LearningStatus.LEAD, "Contact on Monday");

        LearningProfile scp31 = new LearningProfile(course2, LearningStatus.LEAD, "Contact on Monday");
        LearningProfile scp32 = new LearningProfile(course3, LearningStatus.LEAD, "Contact on Monday");



        //Mock-StudentProfile
        this.studentProfileRep.saveAll(new ArrayList<StudentProfile>() {
            {
                add(new StudentProfile("James", "Hunt", new ArrayList<LearningProfile>() {{
                    add(scp11);
                    add(scp12);
                    add(scp13);
                }}));
                add(new StudentProfile("Bill", "Rich", new ArrayList<LearningProfile>() {{
                    add(scp21);
                    add(scp22);
                    add(scp23);
                }}));
                add(new StudentProfile("Robin", "Cash", new ArrayList<LearningProfile>() {{
                    add(scp31);
                    add(scp32);
                }}));
            }
        });

//        this.studentProfileRep.saveAll(new ArrayList<StudentProfile>() {
//            {
//                add(new StudentProfile("James", "Hunt"));
//                add(new StudentProfile("Bill", "Rich"));
//                add(new StudentProfile("Robin", "Cash"));
//            }
//        });
    }


    //    //create
//    public Job createJob(Job job) {
//        JobCompany jobCompany = job.getJobCompany();
//        JobType jobType = job.getJobType();
//
//        if (jobCompany != null && jobCompany.getId() == 0) {
//            job.setJobCompany(jbCompanyRepository.save(jobCompany));
//        }
////        if (jobType != null && jobType.getId() == 0) {
////            job.setJobType(jobTypeRepository.save(jobType));
////        }
//
////        System.out.println(jobCompany.getCompanyName());
////        System.out.println(jobType.getJobTypeName());
//
//        this.jobRepository.save(job);
//        return job;
//    }
//
//    //Read
    public List<StudentProfile> getStudentProfileList() {
        List<StudentProfile> list = new ArrayList<>();
        studentProfileRep.findAll().forEach(list::add);

        return list;
    }
//
//
//    public List<JobCompany> getCompanyList() {
//        List<JobCompany> list = new ArrayList<>();
//        jbCompanyRepository.findAll().forEach(list::add);
//
//        return list;
//    }
//
//    public List<JobType> getJobTypeList() {
//        List<JobType> list = new ArrayList<>();
//        jobTypeRepository.findAll().forEach(list::add);
//
//        return list;
//    }
//
////    @Autowired
////    private JobLoginStatus jobLoginStatus;
//
//
//    public JobLoginStatus login(JobPostUser jobPostUser, HttpSession session) {
//
//         JobLoginStatus jobLoginStatus =  new JobLoginStatus();
//
//
//        if (jobPostUserRepository.findByUserNameAndPassword(jobPostUser.getUserName(), jobPostUser.getPassword()) != null) {
//            System.out.println("\n LOGIN \n");
//            jobLoginStatus.setLogin(true);
//            session.setAttribute("login", true);
//
////            this.jobLoginStatus.setLogin(true);
//        } else {
//            System.out.println("\n NOT LOGIN \n");
//            jobLoginStatus.setLogin(false);
//            session.setAttribute("login", false);
//
////            this.jobLoginStatus.setLogin(false);
//
//        }
////        System.out.println("\n " + this.jobLoginStatus.isLogin() + " \n");
//
//        return jobLoginStatus;
//    }

//    public JobLoginStatus checkLogin(HttpSession session) {
////        JobLoginStatus loginStatus = new JobLoginStatus();
////        loginStatus.setLogin(loginStatus.isLogin());
////        System.out.println("\n " + this.jobLoginStatus.isLogin() + " \n");
//
//        return jobLoginStatus;
//
//    }
}
