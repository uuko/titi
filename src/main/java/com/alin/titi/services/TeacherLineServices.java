package com.alin.titi.services;

import com.alin.titi.model.*;
import com.alin.titi.model.api.request.ProPostRequest;
import com.alin.titi.model.api.request.ProUpdateRequest;
import com.alin.titi.model.api.response.*;
import com.alin.titi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.*;

@Service
@Transactional
public class TeacherLineServices {
    //實現方法
    @Autowired
    private ProRepository pro_repo;
    @Autowired
    private AcademicRepository aca_repo;
    @Autowired
    private AwardsRepository award_repo;
    @Autowired
    private BookRepository book_repo;
    @Autowired
    private DisRepository dis_repo;
    @Autowired
    private GovRepository gov_repo;
    @Autowired
    private LicenseRepository lic_repo;
    @Autowired
    private OneDashTwoRepository one_repo;
    @Autowired
    private PaperRepository paper_repo;
    @Autowired
    private TeacherRepository techer_repo;
    @Autowired
    private LoginRepository lgoin_repo;







    //取得所有老師
    public List<RegisterTeacherModel> listAll() {
        return techer_repo.findAll();
    }

    //取得那個老師
    public List<RegisterTeacherModel> listOne(Integer id) {
        return techer_repo.findAllByTeacherRelationPKTchNumber(id);
    }






    //找到所有資料,指定response
    public TeacherLineOneResponse findAllawardsData(Integer id){
        //回給我所有
        TeacherRelationPK tPk =new TeacherRelationPK();
        tPk.setTchNumber(id);
        List<RegisterTeacherModel> registerTeacherModellist= techer_repo.findAllByTeacherRelationPKTchNumber(id); //要改
        Comparator<RegisterTeacherModel> m_studentComparator = (lhs, rhs) -> {
            return rhs.getTeacherRelationPK().getTchYear().compareTo(lhs.getTeacherRelationPK().getTchYear());  // Descending order
        };

        registerTeacherModellist.sort(m_studentComparator);
        Comparator<RegisterTeacherModel> monthComparator = (lhs, rhs) -> {
            return rhs.getTeacherRelationPK().getTchSemester().compareTo(lhs.getTeacherRelationPK().getTchSemester());  // Descending order
        };
        registerTeacherModellist.sort(monthComparator);
        System.out.println("jdkfjsdl"+registerTeacherModellist);
//        tPk.setTchSemester(2);
//        tPk.setTchYear(110);
        List<ProModel> proModellist= pro_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<AcademicModel> academicModellist= aca_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<AwardsModel> awardsModellist= award_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<BookModel> bookModellist= book_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<DisModel> disModellist= dis_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<GovModel> govModellist= gov_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<LicenseModel> licenseModellist= lic_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<OneDashTwoModel> oneDashTwoModellist= one_repo.findByLoginModelAndOpen(new LoginModel(id),true);
        List<PaperModel> paperModellist= paper_repo.findByLoginModelAndOpen(new LoginModel(id),true);



        //teacher
        TeacherLineOneResponse teacherLineOneResponse  =new TeacherLineOneResponse();
        for (RegisterTeacherModel model:registerTeacherModellist){
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
            break;
        }



        //存進去response
        List<LineProOneResponse> proResponseList=new ArrayList<>();
        for (ProModel postRequest:proModellist) {
            LineProOneResponse proResponseModel=new LineProOneResponse();
            //迴圈丟

            proResponseModel.setProVendor(postRequest.getProVendor());
            proResponseModel.setProNature(postRequest.getProNature());
            proResponseModel.setProCaseName(postRequest.getProCaseName());
            proResponseList.add(proResponseModel);
        }
        teacherLineOneResponse.setProList(proResponseList);

        //存進去response
        List<LineLicOneResponse> LicResponseList=new ArrayList<>();
        for (LicenseModel postRequest:licenseModellist) {
            LineLicOneResponse licResponseModel=new LineLicOneResponse();
            //迴圈丟
            licResponseModel.setLicName(postRequest.getLicName());
            licResponseModel.setLicService(postRequest.getLicService());
            licResponseModel.setLicType(postRequest.getLicType());
            LicResponseList.add(licResponseModel);
        }
        teacherLineOneResponse.setLicList(LicResponseList);

        //存進去response
        List<LineTheOneResponse> TheResponseList=new ArrayList<>();
        for (PaperModel postRequest:paperModellist) {
            LineTheOneResponse paperModel=new LineTheOneResponse();
            //迴圈丟

            paperModel.setTheAuthor(postRequest.getTheAuthor());
            paperModel.setTheCollCategory(postRequest.getTheCollCategory());
            paperModel.setTheCoupons(postRequest.getTheCoupons());

            paperModel.setThemainThesisName(postRequest.getThemain_thesisName());
            paperModel.setThePublishMonth(postRequest.getThePublishType());
            paperModel.setThePubmainLicationName(postRequest.getThePubmain_licationName());
            paperModel.setThePublishYear(postRequest.getThePublishYear());
            paperModel.setThePubmainLicatinNumber(postRequest.getThePubmain_licatinNumber());


            TheResponseList.add(paperModel);
        }
        teacherLineOneResponse.setTheList(TheResponseList);

        //存進去response
        List<LineTchinfOneResponse> TchinfResponseList=new ArrayList<>();
        for (BookModel postRequest:bookModellist) {
            LineTchinfOneResponse bookModel=new LineTchinfOneResponse();
            //迴圈丟

            bookModel.setInfCategory(postRequest.getInfCategory());
            bookModel.setInfISBN(postRequest.getInfISBN());
            bookModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
            bookModel.setInfName(postRequest.getInfName());
            bookModel.setInfPublishHouse(postRequest.getInfPublishHouse());
            bookModel.setInfPubmainLicYear(postRequest.getInfPubmain_licYear());

            TchinfResponseList.add(bookModel);
        }
        teacherLineOneResponse.setTchinfList(TchinfResponseList);

        //存進去response
        List<LineAwardsOneResponse> AwardsResponseList=new ArrayList<>();
        for (AwardsModel postRequest:awardsModellist) {
            LineAwardsOneResponse awardsModel=new LineAwardsOneResponse();
            //迴圈丟

            awardsModel.setAwaDate(postRequest.getAwaDate());
            awardsModel.setAwaName(postRequest.getAwaName());
            awardsModel.setAwaMechanismName(postRequest.getAwaMechanismName());
            AwardsResponseList.add(awardsModel);
        }
        teacherLineOneResponse.setAwardsList(AwardsResponseList);

        //存進去response
        List<LineGovOneResponse> GovResponseList=new ArrayList<>();
        for (GovModel postRequest:govModellist) {
            LineGovOneResponse govModel=new LineGovOneResponse();
            //迴圈丟

            govModel.setGovJobType(postRequest.getGovJobType());
            govModel.setGovProbjectType(postRequest.getGovProbjectType());
            govModel.setGovProjectName(postRequest.getGovProjectName());
            GovResponseList.add(govModel);
        }
        teacherLineOneResponse.setGovList(GovResponseList);

        //存進去response
        List<LineOneDashTwoOneResponse> OneDashTwoResponseList=new ArrayList<>();
        for (OneDashTwoModel postRequest:oneDashTwoModellist) {
            LineOneDashTwoOneResponse oneDashTwoModel=new LineOneDashTwoOneResponse();
            //迴圈丟

            oneDashTwoModel.setExpJobtitle(postRequest.getExpJobtitle());
            oneDashTwoModel.setExpMechanismName(postRequest.getExpMechanismName());
            oneDashTwoModel.setExpStartDate(postRequest.getExpStartDate());
            oneDashTwoModel.setExpStopDate(postRequest.getExpStopDate());
            OneDashTwoResponseList.add(oneDashTwoModel);
        }
        teacherLineOneResponse.setOneDashTwoList(OneDashTwoResponseList);

        //存進去response
        List<LineDisOneResponse> DisResponseList=new ArrayList<>();
        for (DisModel postRequest:disModellist) {
            LineDisOneResponse disModel=new LineDisOneResponse();
            //迴圈丟

            disModel.setDismainThesisName(postRequest.getDismainThesisName());
            disModel.setDisAuthor(postRequest.getDisAuthor());
            disModel.setDisCollection(postRequest.getDisCollection());
            disModel.setDisHostCountry(postRequest.getDisHostCountry());
            disModel.setDisPublishY(postRequest.getDisPublishY());
            disModel.setDisHostCountry(postRequest.getDisHostCountry());
            disModel.setDisSeminarName(postRequest.getDisSeminarName());

            DisResponseList.add(disModel);
        }
        teacherLineOneResponse.setDisList(DisResponseList);

        //存進去response
        List<LineEventOneResponse> eventResponseList=new ArrayList<>();
        for (AcademicModel postRequest:academicModellist) {
            LineEventOneResponse eventModel=new LineEventOneResponse();
            //迴圈丟

            eventModel.setEveName(postRequest.getEveName());
            eventModel.setEveCategory(postRequest.getEveCategory());
            eventModel.setEveSort(postRequest.getEveSort());
            eventResponseList.add(eventModel);
        }
        teacherLineOneResponse.setEventList(eventResponseList);




        return teacherLineOneResponse;
    }







}
