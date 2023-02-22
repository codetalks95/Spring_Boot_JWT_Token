package com.bhushan.service;

import com.bhushan.Response.StudentResponse;
import com.bhushan.entity.StudentEntity;
import com.bhushan.entity.UserInformation;
import com.bhushan.repository.StudentRepository;
import com.bhushan.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponse addUserInformationData(UserInformation userInfo) {
        StudentResponse studentResponse = new StudentResponse();
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInformation userInformation = repository.save(userInfo);
        studentResponse.setMessage("Record has been Saved Successfully");
        studentResponse.setStatus("200");
        studentResponse.setUserInformation(userInformation);
        return studentResponse;
    }

    public StudentResponse addStudentData(StudentEntity studentEntity) {
        StudentResponse studentResponse = new StudentResponse();
        StudentEntity studentResp = studentRepository.save(studentEntity);
        studentResponse.setMessage("Record has been Saved Successfully");
        studentResponse.setStatus("200");
        studentResponse.setStudentEntity(studentResp);
        return studentResponse;
    }
}
