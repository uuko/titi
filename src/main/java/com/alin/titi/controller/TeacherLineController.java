package com.alin.titi.controller;

import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.response.TeacherLineAllResponse;
import com.alin.titi.model.api.response.TeacherLineOneResponse;
import com.alin.titi.services.TeacherLineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class TeacherLineController {
    //api宣告
    @Autowired
    private TeacherLineServices teacherLineServices;


    //get所有老師 要最新的年度與學期
    @GetMapping("/teacher/teacherLine/list")
    public ResponseEntity<?> getTeacherPaper() {

        List<RegisterTeacherModel> putuserList = teacherLineServices.listAll();
        List<Integer> apple = new ArrayList<>();
        for (RegisterTeacherModel putuser : putuserList) {
            if (!apple.contains(putuser.getTeacherRelationPK().getTchNumber())) {
                apple.add(putuser.getTeacherRelationPK().getTchNumber());
            }
        }

        List<TeacherLineAllResponse> teacherLineAllResponse = new ArrayList<>();
        for (Integer id : apple) {
            List<RegisterTeacherModel> registerTeacherModellist = teacherLineServices.listOne(id);
            Comparator<RegisterTeacherModel> m_studentComparator = (lhs, rhs) -> {
                return rhs.getTeacherRelationPK().getTchYear().compareTo(lhs.getTeacherRelationPK().getTchYear());  // Descending order
            };

            registerTeacherModellist.sort(m_studentComparator);
            Comparator<RegisterTeacherModel> monthComparator = (lhs, rhs) -> {
                return rhs.getTeacherRelationPK().getTchSemester().compareTo(lhs.getTeacherRelationPK().getTchSemester());  // Descending order
            };
            registerTeacherModellist.sort(monthComparator);

            for (RegisterTeacherModel model : registerTeacherModellist) {
                TeacherLineAllResponse teacherLineOneResponse = new TeacherLineAllResponse();
                teacherLineOneResponse.setTchNumber(model.getTeacherRelationPK().getTchNumber());
                teacherLineOneResponse.setTchName(model.getTchName());
                teacherLineOneResponse.setTchNameEN(model.getTchNameEN());
                teacherLineOneResponse.setTchPicUrl(model.getTchPicUrl());
                teacherLineOneResponse.setTchMainDepartment(model.getTchMainDepartment());
                teacherLineOneResponse.setTchRireRank(model.getTchRireRank());
                teacherLineOneResponse.setTchSchool(model.getTchSchool());
                teacherLineOneResponse.setTchDiploma(model.getTchDiploma());
                teacherLineOneResponse.setTchDepartment(model.getTchDepartment());
                teacherLineOneResponse.setIntroduce(model.getIntroduce());
                teacherLineOneResponse.setTchCoeDepartment(model.getTchCoeDepartment());
                teacherLineOneResponse.seteMail(model.geteMail());
                teacherLineAllResponse.add(teacherLineOneResponse);
                break;
            }

        }


        return ResponseEntity.ok(teacherLineAllResponse);
    }

    //get
    @GetMapping("/teacher/teacherLine/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        TeacherLineOneResponse licenseData = teacherLineServices.findAllawardsData(loginId);
//        if (licenseData!==null){
//            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
//        }
//        else {
        return ResponseEntity.ok(licenseData);
//        }
    }
}
