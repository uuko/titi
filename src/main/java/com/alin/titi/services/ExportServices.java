package com.alin.titi.services;

import com.alin.titi.model.*;
import com.alin.titi.model.export.ExportTeacherResponse;
import com.alin.titi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.alin.titi.model.base.TableEnum.*;
import static com.alin.titi.model.base.TableEnum.AWARD;

@Service
@Transactional
public class ExportServices {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private ProRepository proRepository;
    @Autowired
    private AcademicRepository academicRepository;
    @Autowired
    private AwardsRepository awardsRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private DisRepository disRepository;
    @Autowired
    private GovRepository govRepository;
    @Autowired
    private LicenseRepository licenseRepository;
    @Autowired
    private OneDashTwoRepository oneDashTwoRepository;
    @Autowired
    private PaperRepository paperRepository;
    @Autowired
    private PatRepository patRepository;
    @Autowired
    private TechRepository techRepository;

    private final String ADMIN="A";
    public List<ExportTeacherResponse> findTeacherExportList(){
        List<LoginModel> loginModelList=loginRepository.findByGradeNot(ADMIN);
        List<ExportTeacherResponse> responseList=new ArrayList<>();
        for (LoginModel l:loginModelList){
            List<RegisterTeacherModel> teacherModel= teacherRepository.findByLoginModel(new LoginModel(l.getId()));
            if (teacherModel.size()>0){
                ExportTeacherResponse response=new ExportTeacherResponse();
                response.setAccount(l.getAccount());
                response.setLoginId(l.getId());
                response.setTchName(teacherModel.get(0).getTchName());
                responseList.add(response);
            }

        }
       return responseList;

    }

    public List<String> findTableExportList(Integer loginId){
        if (!loginId.equals(-1)){
            return findTableList(loginId);
        }
        else {
            return findTableListAll();
        }
    }

    public List<String> findSemesterAndYearExportList(Integer loginId,String tableName){
        if (!loginId.equals(-1)){
            return findSemesterList(loginId,tableName);
        }
        else {
            return findSemesterListAll(tableName);
        }
    }

    private List<String> findSemesterListAll(String tableName) {
        switch (tableName){
            case PAPER:

                List<PaperModel> list=paperRepository.findAll();
                List<String> stringList=new ArrayList<>();
                for (PaperModel model:list){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!stringList.contains(date)){
                        stringList.add(date);
                    }
                }
                return stringList;

            case PRO:
                List<ProModel> proModels=proRepository.findAll();
                List<String> proStringLst=new ArrayList<>();
                for (ProModel model:proModels){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!proStringLst.contains(date)){
                        proStringLst.add(date);
                    }
                }
                return proStringLst;

            case ACAD:
                List<AcademicModel> academicModelList=academicRepository.findAll();
                List<String> acadLst=new ArrayList<>();
                for (AcademicModel model:academicModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!acadLst.contains(date)){
                        acadLst.add(date);
                    }
                }
                return acadLst;
            case AWARD:
                List<AwardsModel> awardsModels=awardsRepository.findAll();
                List<String> awardLst=new ArrayList<>();
                for (AwardsModel model:awardsModels){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!awardLst.contains(date)){
                        awardLst.add(date);
                    }
                }
                return awardLst;
            case BOOK:
                List<BookModel> bookModelList=bookRepository.findAll();
                List<String> bookLst=new ArrayList<>();
                for (BookModel model:bookModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!bookLst.contains(date)){
                        bookLst.add(date);
                    }
                }
                return bookLst;
            case DIS:
                List<DisModel> disModelList=disRepository.findAll();
                List<String> disLst=new ArrayList<>();
                for (DisModel model:disModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!disLst.contains(date)){
                        disLst.add(date);
                    }
                }
                return disLst;
            case GOV:
                List<GovModel> govModelList=govRepository.findAll();
                List<String> govLst=new ArrayList<>();
                for (GovModel model:govModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!govLst.contains(date)){
                        govLst.add(date);
                    }
                }
                return govLst;
            case LIC:
                Iterable<LicenseModel> licenseModelList=licenseRepository.findAll();
                List<String> licLst=new ArrayList<>();
                for (LicenseModel model:licenseModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!licLst.contains(date)){
                        licLst.add(date);
                    }
                }
                return licLst;
            case EXP:
                List<OneDashTwoModel> oneDashTwoModelList=oneDashTwoRepository.findAll();
                List<String> oneDashTwoLst=new ArrayList<>();
                for (OneDashTwoModel model:oneDashTwoModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!oneDashTwoLst.contains(date)){
                        oneDashTwoLst.add(date);
                    }
                }
                return oneDashTwoLst;
            case TEACHER_DATA:
                List<RegisterTeacherModel> registerTeacherModelList=teacherRepository.findAll();
                List<String> teacherLst=new ArrayList<>();
                for (RegisterTeacherModel model:registerTeacherModelList){
                    String date=  makeDateString(model.getTeacherRelationPK().getTchYear(),model.getTeacherRelationPK().getTchSemester());
                    if (!teacherLst.contains(date)){
                        teacherLst.add(date);
                    }
                }
                return teacherLst;
            case PAT:
                List<PatModel> patModelList=patRepository.findAll();
                List<String> patLst=new ArrayList<>();
                for (PatModel model:patModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!patLst.contains(date)){
                        patLst.add(date);
                    }
                }
                return patLst;
            case TECH:
                List<TechModel> techModelList=techRepository.findAll();
                List<String> techLst=new ArrayList<>();
                for (TechModel model:techModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!techLst.contains(date)){
                        techLst.add(date);
                    }
                }
                return techLst;
            default:
                break;
        }
        return new ArrayList<>();
    }



    private List<String> findSemesterList(Integer loginId, String tableName) {
        switch (tableName){
            case PAPER:
                List<PaperModel> list=paperRepository.findByLoginModel(new LoginModel(loginId));
                List<String> stringList=new ArrayList<>();
                for (PaperModel model:list){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!stringList.contains(date)){
                        stringList.add(date);
                    }
                }
                return stringList;
            case PRO:
                List<ProModel> proModels=proRepository.findByLoginModel(new LoginModel(loginId));
                List<String> proStringLst=new ArrayList<>();
                for (ProModel model:proModels){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!proStringLst.contains(date)){
                        proStringLst.add(date);
                    }
                }
                return proStringLst;
            case ACAD:
                List<AcademicModel> academicModelList=academicRepository.findByLoginModel(new LoginModel(loginId));
                List<String> acadLst=new ArrayList<>();
                for (AcademicModel model:academicModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!acadLst.contains(date)){
                        acadLst.add(date);
                    }
                }
                return acadLst;
            case AWARD:
                List<AwardsModel> awardsModels=awardsRepository.findByLoginModel(new LoginModel(loginId));
                List<String> awardLst=new ArrayList<>();
                for (AwardsModel model:awardsModels){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!awardLst.contains(date)){
                        awardLst.add(date);
                    }
                }
                return awardLst;
            case BOOK:
                List<BookModel> bookModelList=bookRepository.findByLoginModel(new LoginModel(loginId));
                List<String> bookLst=new ArrayList<>();
                for (BookModel model:bookModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!bookLst.contains(date)){
                        bookLst.add(date);
                    }
                }
                return bookLst;
            case DIS:
                List<DisModel> disModelList=disRepository.findByLoginModel(new LoginModel(loginId));
                List<String> disLst=new ArrayList<>();
                for (DisModel model:disModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!disLst.contains(date)){
                        disLst.add(date);
                    }
                }
                return disLst;
            case GOV:
                List<GovModel> govModelList=govRepository.findByLoginModel(new LoginModel(loginId));
                List<String> govLst=new ArrayList<>();
                for (GovModel model:govModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!govLst.contains(date)){
                        govLst.add(date);
                    }
                }
                return govLst;
            case LIC:
                List<LicenseModel> licenseModelList=licenseRepository.findByLoginModel(new LoginModel(loginId));
                List<String> licLst=new ArrayList<>();
                for (LicenseModel model:licenseModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!licLst.contains(date)){
                        licLst.add(date);
                    }
                }
                return licLst;
            case EXP:
                List<OneDashTwoModel> oneDashTwoModelList=oneDashTwoRepository.findByLoginModel(new LoginModel(loginId));
                List<String> oneDashTwoLst=new ArrayList<>();
                for (OneDashTwoModel model:oneDashTwoModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!oneDashTwoLst.contains(date)){
                        oneDashTwoLst.add(date);
                    }
                }
                return oneDashTwoLst;
            case TEACHER_DATA:
                List<RegisterTeacherModel> registerTeacherModelList=teacherRepository.findByLoginModel(new LoginModel(loginId));
                List<String> teacherLst=new ArrayList<>();
                for (RegisterTeacherModel model:registerTeacherModelList){
                    String date=  makeDateString(model.getTeacherRelationPK().getTchYear(),model.getTeacherRelationPK().getTchSemester());
                    if (!teacherLst.contains(date)){
                        teacherLst.add(date);
                    }
                }
                return teacherLst;
            case PAT:
                List<PatModel> patModelList=patRepository.findByLoginModel(new LoginModel(loginId));
                List<String> patLst=new ArrayList<>();
                for (PatModel model:patModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!patLst.contains(date)){
                        patLst.add(date);
                    }
                }
                return patLst;
            case TECH:
                List<TechModel> techModelList=techRepository.findByLoginModel(new LoginModel(loginId));
                List<String> techLst=new ArrayList<>();
                for (TechModel model:techModelList){
                    String date=  makeDateString(model.getTchYear(),model.getTchSemester());
                    if (!techLst.contains(date)){
                        techLst.add(date);
                    }
                }
                return techLst;
            default:
                break;
        }
        return new ArrayList<>();
    }

    private String makeDateString(Integer tchYear, Integer tchSemester) {
        return tchYear+"-"+tchSemester;
    }

    private List<String> findTableListAll() {
        List<String > tableList=new ArrayList<>();

        Iterable<LoginModel> loginModelList=loginRepository.findAll();
        for (LoginModel ll:loginModelList){
            Integer loginId=ll.getId();
            List<PaperModel> paperModels= paperRepository.findByLoginModel(new LoginModel(loginId));
            if (paperModels.size()>0 && !tableList.contains(PAPER))tableList.add(PAPER);
            List<ProModel> proModels= proRepository.findByLoginModel(new LoginModel(loginId));
            if (proModels.size()>0 && !tableList.contains(PRO))tableList.add(PRO);
            List<AcademicModel> academicModels= academicRepository.findByLoginModel(new LoginModel(loginId));
            if (academicModels.size()>0 && !tableList.contains(ACAD))tableList.add(ACAD);
            List<AwardsModel> awardsModels= awardsRepository.findByLoginModel(new LoginModel(loginId));
            if (awardsModels.size()>0 && !tableList.contains(AWARD))tableList.add(AWARD);
            List<BookModel> bookModels= bookRepository.findByLoginModel(new LoginModel(loginId));
            if (bookModels.size()>0 && !tableList.contains(BOOK))tableList.add(BOOK);
            List<DisModel> disModels= disRepository.findByLoginModel(new LoginModel(loginId));
            if (disModels.size()>0 && !tableList.contains(DIS))tableList.add(DIS);
            List<GovModel> govModels= govRepository.findByLoginModel(new LoginModel(loginId));
            if (govModels.size()>0 && !tableList.contains(GOV))tableList.add(GOV);
            List<LicenseModel> licenseModels= licenseRepository.findByLoginModel(new LoginModel(loginId));
            if (licenseModels.size()>0 && !tableList.contains(EXP))tableList.add(LIC);

            List<OneDashTwoModel> oneDashTwoModels= oneDashTwoRepository.findByLoginModel(new LoginModel(loginId));
            if (oneDashTwoModels.size()>0 && !tableList.contains(EXP))tableList.add(EXP);

            List<RegisterTeacherModel> teacherModels= teacherRepository.findByLoginModel(new LoginModel(loginId));
            if (teacherModels.size()>0 && !tableList.contains(TEACHER_DATA))tableList.add(TEACHER_DATA);
            List<PatModel> patModels= patRepository.findByLoginModel(new LoginModel(loginId));
            if (patModels.size()>0 && !tableList.contains(PAT))tableList.add(PAT);
            List<TechModel> techModels= techRepository.findByLoginModel(new LoginModel(loginId));
            if (techModels.size()>0 && !tableList.contains(TECH))tableList.add(TECH);
        }
        return tableList;
    }

    private  List<String > findTableList(Integer loginId) {
        List<String > tableList=new ArrayList<>();
        List<PaperModel> paperModels= paperRepository.findByLoginModel(new LoginModel(loginId));
        if (paperModels.size()>0)tableList.add(PAPER);
        List<ProModel> proModels= proRepository.findByLoginModel(new LoginModel(loginId));
        if (proModels.size()>0)tableList.add(PRO);
        List<AcademicModel> academicModels= academicRepository.findByLoginModel(new LoginModel(loginId));
        if (academicModels.size()>0)tableList.add(ACAD);
        List<AwardsModel> awardsModels= awardsRepository.findByLoginModel(new LoginModel(loginId));
        if (awardsModels.size()>0)tableList.add(AWARD);
        List<BookModel> bookModels= bookRepository.findByLoginModel(new LoginModel(loginId));
        if (bookModels.size()>0)tableList.add(BOOK);
        List<DisModel> disModels= disRepository.findByLoginModel(new LoginModel(loginId));
        if (disModels.size()>0)tableList.add(DIS);
        List<GovModel> govModels= govRepository.findByLoginModel(new LoginModel(loginId));
        if (govModels.size()>0)tableList.add(GOV);
        List<LicenseModel> licenseModels= licenseRepository.findByLoginModel(new LoginModel(loginId));
        if (licenseModels.size()>0)tableList.add(LIC);
        List<OneDashTwoModel> oneDashTwoModels= oneDashTwoRepository.findByLoginModel(new LoginModel(loginId));
        if (oneDashTwoModels.size()>0)tableList.add(EXP);
        List<RegisterTeacherModel> teacherModels= teacherRepository.findByLoginModel(new LoginModel(loginId));
        if (teacherModels.size()>0)tableList.add(TEACHER_DATA);
        List<PatModel> patModels= patRepository.findByLoginModel(new LoginModel(loginId));
        if (patModels.size()>0)tableList.add(PAT);
        List<TechModel> techModels= techRepository.findByLoginModel(new LoginModel(loginId));
        if (techModels.size()>0)tableList.add(TECH);
        return tableList;
    }
}
