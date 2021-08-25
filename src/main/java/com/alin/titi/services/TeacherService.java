package com.alin.titi.services;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.RegisterBaseModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
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
        int year = Calendar.getInstance().get(Calendar.YEAR);
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
        loginModel.setAccount(baseModel.getEmail());
        loginModel.setPassword(baseModel.getPassword());
        loginModel.setGrade("B");
        loginRepository.save(loginModel);
        LoginModel response=loginRepository.findByAccountAndPassword(baseModel.getEmail(),baseModel.getPassword());
        teacherModel.setLoginModel(loginModel);
        teacherModel.getTeacherRelationPK().setTchNumber(response.getId());

        repo.save(teacherModel);
    }
    public String storeNewFile(MultipartFile multipartFile, TeacherRelationPK teacherRelationPK) throws Exception {
        Path fileStoreLocation= Paths.get("C:\\Users\\uuko\\Desktop\\mssweb\\titi\\src\\main\\resources\\static\\").toAbsolutePath().normalize();
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
            newFileName=teacherRelationPK.getTchNumber()+"_"+fileOrgName+fileExtension;

            Path targetLocation = fileStoreLocation.resolve(newFileName);
            Files.copy(multipartFile.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("newFileName000000000000"+newFileName);
            RegisterTeacherModel checkIfRepeat=repo.findByTchPicUrl(newFileName);
            if (checkIfRepeat!=null){
                System.out.println("newFileName1111111111"+newFileName);
                String fileDownLoadUrL = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/downloadFile/")
                        .path(newFileName)
                        .toUriString();
                checkIfRepeat.setTchPicUrl(fileDownLoadUrL);
                repo.save(checkIfRepeat);
            }else {
                System.out.println("newFileName22222222222"+newFileName);
                RegisterTeacherModel t1=repo.findByTeacherRelationPK(teacherRelationPK);
                String fileDownLoadUrL = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/downloadFile/")
                        .path(newFileName)
                        .toUriString();
                t1.setTchPicUrl(fileDownLoadUrL);
                repo.save(t1);
            }
            System.out.println("newFileName"+newFileName);
            return newFileName;

        }
        catch (Exception e){
            throw new Exception("Could not store file " + newFileName + ". Please try again!", e);
        }
    }


    public Resource loadFileAsResource(String fileName) throws Exception {
        Path fileStoreLocation= Paths.get("C:/Users/uuko/Desktop/mssweb/titi/src/main/resources/static/").toAbsolutePath().normalize();
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
}
