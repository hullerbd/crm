package com.busyqa.crm;

import com.busyqa.crm.pojo.student.StudentProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CRMController {


    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CRMService crmService;

    //========
    @RequestMapping(method = RequestMethod.GET, value = "/studentprofiles")
    public List<StudentProfile> listAllAndSort() {
        return this.crmService.getStudentProfileList();
    }
//
//    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE,
//            value = "/job")
//    @ResponseStatus(HttpStatus.CREATED)
//    public @ResponseBody
//    List<Job> createJob(@RequestBody Job job) {
//        Job newJob = this.jobbankService.createJob(job);
//        System.out.print(job);
//        return this.jobbankService.getJobList();
//    }
//
//    //========
//    @RequestMapping(method = RequestMethod.GET, value = "/companies")
//    public List<JobCompany> getCompanyList() {
//        return this.jobbankService.getCompanyList();
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/jobtypes")
//    public List<JobType> getJobTypeList() {
//        return this.jobbankService.getJobTypeList();
//    }
//
//    //========
////    @Autowired
////    private JobLoginStatus jobLoginStatus;
//
//    @RequestMapping(method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE, value = "/login")
//    public JobLoginStatus login(@RequestBody JobPostUser jobPostUser, HttpSession session) {
//
//        String sessionId = session.getId();
//        System.out.println("\n " + sessionId + " \n");
//
//        if (session.getAttribute("id") != null) {
//            System.out.println("SUCCESS: " + session.getAttribute("id") + " \n");
//        } else {
//            session.setAttribute("id", sessionId);
//            System.out.println("F");
//
//        }
//
//
//        JobLoginStatus jobLoginStatus = new JobLoginStatus();
//
////        if (jobLoginStatus.isLogin()) {
////            this.jobLoginStatus.setLogin(true);
////        } else {
////            this.jobLoginStatus.setLogin(false);
////        }
////
////        System.out.println("\n " + this.jobLoginStatus.isLogin() + " \n");
//
//
//        return jobLoginStatus;
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET,
//            value = "/checklogin")
//    public JobLoginStatus checkLogin(HttpSession session) {
//        String sessionId = session.getId();
//        System.out.println("\n " + sessionId + " \n");
////        System.out.println("\n SERVICE: checkLogin \n");
//
////        System.out.println("\n " + request.getSession() + " \n");
////        System.out.println("\n " + request.getSession().getAttribute("login") + " \n");
////
////
////        boolean login = Boolean.valueOf(request.getSession().getAttribute("login").toString());
////        System.out.println("\n " + session.getAttribute("login") + " \n");
////        System.out.println("\n " + login + " \n");
//        JobLoginStatus js = new JobLoginStatus();
//
//        return js;
////        return this.jobbankService.checkLogin(session);
//    }
//
//    @GetMapping("/checkCount")
//    // it will handle all request for /welcome
//    public java.util.Map<String, Integer> start(HttpSession session) {
//        String sessionId = session.getId();
//        System.out.println("\n " + sessionId + " \n");
//
//        Integer integer = (Integer) session.getAttribute("hitCounter"); // it will read data from database tables
//        if (integer == null) {
//            integer = new Integer(0);
//            integer++;
//            session.setAttribute("hitCounter", integer);  // it will write data to tables
//        } else {
//            integer++;
//            session.setAttribute("hitCounter", integer);  // it will write data to tables
//        }
//        java.util.Map<String, Integer> hitCounter = new HashMap<>();
//        hitCounter.put("Hit Counter", integer);
//        return hitCounter;
//    }

}

