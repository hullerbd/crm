package com.busyqa.crm.repo;

import com.busyqa.crm.pojo.student.StudentProfile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentProfileRep extends PagingAndSortingRepository<StudentProfile, Long> {

}

