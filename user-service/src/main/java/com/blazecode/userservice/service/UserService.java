package com.blazecode.userservice.service;

import com.blazecode.userservice.VO.Department;
import com.blazecode.userservice.VO.ResponseTemplateVO;
import com.blazecode.userservice.entity.User;
import com.blazecode.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        log.info("Inside saveUser of userRepository");
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId){
        log.info("Inside getUserWithDepartment of userRepository");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        //using restTemplate getForObject(URL, EntityType) to call the other microservice and get object
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }

}
