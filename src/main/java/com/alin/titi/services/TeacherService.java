package com.alin.titi.services;

import com.alin.titi.Config;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.RegisterBaseModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.model.api.response.ListTeacherResponse;
import com.alin.titi.model.api.response.TeacherLineAllResponse;
import com.alin.titi.repository.LoginRepository;
import com.alin.titi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
@Transactional
public class TeacherService {
    @Autowired
    private TeacherRepository repo;
    @Autowired
    private LoginRepository loginRepository;


    public List<RegisterTeacherModel> listAll() {
        return repo.findAll();
    }
    public void registerAllTeacher(RegisterTeacherModel teacherModel) {
        TeacherRelationPK teacherRelationPK=new TeacherRelationPK();
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        repo.save(teacherModel);

    }
    public void registerTeacher(RegisterTeacherModel teacherModel,RegisterBaseModel baseModel) {



        LoginModel loginModel=new LoginModel();
        loginModel.setAccount(baseModel.getAccount());
        loginModel.setPassword(baseModel.getPassword());
        loginModel.setGrade("B");
        loginRepository.save(loginModel);
        LoginModel response=loginRepository.findByAccountAndPassword(baseModel.getAccount(),baseModel.getPassword());
        teacherModel.setLoginModel(loginModel);
        teacherModel.getTeacherRelationPK().setTchNumber(response.getId());

        repo.save(teacherModel);
    }

    public String storeNewFile(MultipartFile multipartFile, Integer teacherRelationPK) throws Exception {
        Path fileStoreLocation= Paths.get(Config.path).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStoreLocation);
        } catch (IOException e) {
            try {
                throw new Exception("Could not create the directory where the uploaded files will be stored",e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        String orgFileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String newFileName = "";
        try {
            if (orgFileName.contains("..")){
                throw new Exception("Sorry! Filename contains invalid path sequence " + orgFileName);
            }
            // String command = "powershell -c \"$(ipconfig | where {$_ -match 'IPv4.+\\s(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})' } | out-null; $Matches[1]) > C:\\Users\\uuko\\Desktop\\web\\web-socket-project\\src\\main\\resources\\ip.txt";
            String command="localhost";
//            Process process = Runtime.getRuntime().exec(command);
//            process.getOutputStream();
//            String line0 = Files.readAllLines(Paths.get("C:\\Users\\uuko\\Desktop\\web\\web-socket-project\\src\\main\\resources\\ip.txt"), StandardCharsets.UTF_16LE).get(0);
            String line0=command;
            String fileExtension="";
            String fileOrgName="";
            fileExtension=orgFileName.substring(orgFileName.lastIndexOf("."));
            fileOrgName=orgFileName.substring(0,orgFileName.lastIndexOf("."));
            newFileName=teacherRelationPK+"_"+fileOrgName+fileExtension;

            Path targetLocation = fileStoreLocation.resolve(newFileName);
            Files.copy(multipartFile.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("newFileName000000000000"+newFileName);

            List<RegisterTeacherModel> registerTeacherModellist = repo.findAllByTeacherRelationPKTchNumber(teacherRelationPK);
            Comparator<RegisterTeacherModel> m_studentComparator = (lhs, rhs) -> {
                return rhs.getTeacherRelationPK().getTchYear().compareTo(lhs.getTeacherRelationPK().getTchYear());  // Descending order
            };

            registerTeacherModellist.sort(m_studentComparator);
            Comparator<RegisterTeacherModel> monthComparator = (lhs, rhs) -> {
                return rhs.getTeacherRelationPK().getTchSemester().compareTo(lhs.getTeacherRelationPK().getTchSemester());  // Descending order
            };
            registerTeacherModellist.sort(monthComparator);
            RegisterTeacherModel listTeacherResponse = new RegisterTeacherModel();
            for (RegisterTeacherModel putuser : registerTeacherModellist) {
                listTeacherResponse=putuser;
                break;
            }

            String fileDownLoadUrL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(newFileName)
                    .toUriString();
            listTeacherResponse.setTchPicUrl(fileDownLoadUrL);
            repo.save(listTeacherResponse);

            System.out.println("newFileName"+newFileName);
            return newFileName;

        }
        catch (Exception e){
            throw new Exception("Could not store file " + newFileName + ". Please try again!", e);
        }
    }

    public Resource loadFileAsResource(String fileName) throws Exception {
        Path fileStoreLocation= Paths.get(Config.path).toAbsolutePath().normalize();
        Path filePath =fileStoreLocation.resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        if(resource.exists()) {
            return resource;
        } else {
            throw new Exception("File not found " + fileName);
        }

    }
    public void updateTeacher(RegisterTeacherModel teacherModel) throws Exception {
        repo.save(teacherModel);
    }
    public RegisterTeacherModel findByTeacherRelationPK(TeacherRelationPK teacherRelationPK) {
        return repo.findByTeacherRelationPK(teacherRelationPK);
    }

    public ListTeacherResponse getTeacherByLoginId(Integer id){
        List<RegisterTeacherModel> registerTeacherModellist = repo.findAllByTeacherRelationPKTchNumber(id);
        Comparator<RegisterTeacherModel> m_studentComparator = (lhs, rhs) -> {
            return rhs.getTeacherRelationPK().getTchYear().compareTo(lhs.getTeacherRelationPK().getTchYear());  // Descending order
        };

        registerTeacherModellist.sort(m_studentComparator);
        Comparator<RegisterTeacherModel> monthComparator = (lhs, rhs) -> {
            return rhs.getTeacherRelationPK().getTchSemester().compareTo(lhs.getTeacherRelationPK().getTchSemester());  // Descending order
        };
        registerTeacherModellist.sort(monthComparator);
        ListTeacherResponse listTeacherResponse = new ListTeacherResponse();
        for (RegisterTeacherModel putuser : registerTeacherModellist) {
            listTeacherResponse.setTchNumber(putuser.getTeacherRelationPK().getTchNumber());
            listTeacherResponse.setTchSemester(putuser.getTeacherRelationPK().getTchSemester());
            listTeacherResponse.setTchYear(putuser.getTeacherRelationPK().getTchYear());
            listTeacherResponse.setTchDepartment(putuser.getTchDepartment());
            listTeacherResponse.setTchPicUrl(putuser.getTchPicUrl());
            listTeacherResponse.setTchIdType(putuser.getTchIdType());
            listTeacherResponse.setTchIdNumberI(putuser.getTchIdNumberI());
            listTeacherResponse.setTchIdNumberR(putuser.getTchIdNumberR());
            listTeacherResponse.setTchIdNumberP(putuser.getTchIdNumberP());
            listTeacherResponse.setTchCountry(putuser.getTchCountry());
            listTeacherResponse.setTchName(putuser.getTchName());
            listTeacherResponse.setTchNameEN(putuser.getTchNameEN());
            listTeacherResponse.setSex(putuser.getSex());
            listTeacherResponse.setTchIsAboriginal(putuser.getTchIsAboriginal());
            listTeacherResponse.setTchAboriginal(putuser.getTchAboriginal());
            listTeacherResponse.setTchBirthday(putuser.getTchBirthday());
            listTeacherResponse.setTchCoeDepartment(putuser.getTchCoeDepartment());
            listTeacherResponse.seteMail(putuser.geteMail());
            listTeacherResponse.setTchState(putuser.getTchState());
            listTeacherResponse.setTchHureDate(putuser.getTchHureDate());
            listTeacherResponse.setTchSchDate(putuser.getTchSchDate());
            listTeacherResponse.setTchOriginalUnit(putuser.getTchOriginalUnit());
            listTeacherResponse.setTchReinstateDate(putuser.getTchReinstateDate());
            listTeacherResponse.setTchAppointDate(putuser.getTchAppointDate());
            listTeacherResponse.setTchStopDate(putuser.getTchStopDate());
            listTeacherResponse.setTchEstablishment(putuser.getTchEstablishment());
            listTeacherResponse.setTchKind(putuser.getTchKind());
            listTeacherResponse.setTchKindIndustry(putuser.getTchKindIndustry());
            listTeacherResponse.setTchKindDepartment(putuser.getTchKindDepartment());
            listTeacherResponse.setTchSceWhemain_ther(putuser.getTchSceWhemain_ther());
            //
            listTeacherResponse.setTchScePurpose(putuser.getTchScePurpose());
            listTeacherResponse.setTchSecUnit(putuser.getTchSecUnit());
            listTeacherResponse.setTchPartAdmini(putuser.getTchPartAdmini());
            listTeacherResponse.setTchAdminiJob(putuser.getTchAdminiJob());
            listTeacherResponse.setTchSchoolType(putuser.getTchSchoolType());
            listTeacherResponse.setTchSchool(putuser.getTchSchool());
            //
            listTeacherResponse.setTchDepartment(putuser.getTchDepartment());
            listTeacherResponse.setTchDiploma(putuser.getTchDiploma());
            listTeacherResponse.setTchExpertise(putuser.getTchExpertise());
            listTeacherResponse.setTchType(putuser.getTchType());
            listTeacherResponse.setTchRireRank(putuser.getTchRireRank());
            //
            listTeacherResponse.setTchRireYear(putuser.getTchRireYear());
            listTeacherResponse.setTchCertificateRank(putuser.getTchCertificateRank());
            listTeacherResponse.setTchCertificateNumber(putuser.getTchCertificateNumber());
            listTeacherResponse.setTchHireNumber(putuser.getTchHireNumber());
            listTeacherResponse.setTchCertificateNumber(putuser.getTchCertificateNumber());
            listTeacherResponse.setTchmain_licenseNumber(putuser.getTchmain_licenseNumber());
            ;       //
            listTeacherResponse.setTchEvaNumber(putuser.getTchEvaNumber());
            listTeacherResponse.setTch106PaySalary(putuser.getTch106PaySalary());
            listTeacherResponse.setTch107PaySalary(putuser.getTch107PaySalary());
            listTeacherResponse.setTchFiestAssistant(putuser.getTchFiestAssistant());
            listTeacherResponse.setTchFullTime(putuser.getTchFullTime());
            listTeacherResponse.setTchSixtyFive(putuser.getTchSixtyFive());
            //
            listTeacherResponse.setTchMainDepartment(putuser.getTchMainDepartment());
            listTeacherResponse.setTchTwoFour(putuser.getTchTwoFour());
            listTeacherResponse.setTchComplyLaw(putuser.getTchComplyLaw());
            listTeacherResponse.setTchFullPartPosition(putuser.getTchFullPartPosition());
            listTeacherResponse.setTchTow(putuser.getTchTow());
            listTeacherResponse.setTchValidationStatus(putuser.getTchValidationStatus());
            listTeacherResponse.setIntroduce(putuser.getIntroduce());
            break;
        }
        return listTeacherResponse;
    }

}