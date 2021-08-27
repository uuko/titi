package com.alin.titi.services;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PaperModel;
import com.alin.titi.model.api.BookModel;
import com.alin.titi.model.api.request.BookRequest;
import com.alin.titi.model.api.request.BookUpdateRequest;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.response.BookResponse;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.repository.BookRepository;
import com.alin.titi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class BookServices {

    @Autowired
    private BookRepository repo;

    public void addBookData(BookRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        BookModel paperModel=new BookModel();
        paperModel.setTchSemester(semester);
        paperModel.setTchYear(year);

        paperModel.setInfYear(postRequest.getInfYear());
        paperModel.setInfCategory(postRequest.getInfCategory());
        paperModel.setInfAudit(postRequest.getInfAudit());
        paperModel.setInfWhemain_ther(postRequest.getInfWhemain_ther());
        paperModel.setInfAudit(postRequest.getInfAudit());
        paperModel.setInfName(postRequest.getInfName());
        paperModel.setInfLanguage(postRequest.getInfLanguage());
        paperModel.setInfCoop(postRequest.getInfCoop());
        paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
        paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
        paperModel.setInfPubmain_licMonth(postRequest.getInfPubmain_licMonth());
        paperModel.setInfPubmain_licYear(postRequest.getInfPubmain_licYear());
        paperModel.setInfISBN(postRequest.getInfISBN());
        paperModel.setInfPlan(postRequest.getInfPlan());
        paperModel.setPublic(postRequest.isPublic());
        paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(paperModel);

    }

    public void deleteBookData(BookUpdateRequest licenseRequest){
        repo.deleteById(licenseRequest.getInfNumber());
    }
    public BookResponse findBookData(Integer id){
        BookModel postRequest=repo.findByInfNumber(id);

        BookResponse paperModel=new BookResponse();
        paperModel.setTchSemester(postRequest.getTchSemester());
        paperModel.setTchYear(postRequest.getTchYear());
        paperModel.setLoginId(postRequest.getLoginModel().getId());
        paperModel.setInfNumber(postRequest.getInfNumber());

        paperModel.setInfYear(postRequest.getInfYear());
        paperModel.setInfCategory(postRequest.getInfCategory());
        paperModel.setInfWhemain_ther(postRequest.getInfWhemain_ther());
        paperModel.setInfAudit(postRequest.getInfAudit());
        paperModel.setInfName(postRequest.getInfName());
        paperModel.setInfLanguage(postRequest.getInfLanguage());
        paperModel.setInfCoop(postRequest.getInfCoop());
        paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
        paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
        paperModel.setInfPubmain_licMonth(postRequest.getInfPubmain_licMonth());
        paperModel.setInfPubmain_licYear(postRequest.getInfPubmain_licYear());
        paperModel.setInfISBN(postRequest.getInfISBN());
        paperModel.setInfPlan(postRequest.getInfPlan());
        paperModel.setPublic(postRequest.isPublic());
        return paperModel;
    }

    public List<BookResponse> findAllBookData(Integer id){
        List<BookModel> list= repo.findByLoginModel(new LoginModel(id));

        List<BookResponse> responseList=new ArrayList<>();
        for (BookModel postRequest:list) {
            BookResponse paperModel=new BookResponse();
            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());
            paperModel.setLoginId(postRequest.getLoginModel().getId());
            paperModel.setInfNumber(postRequest.getInfNumber());

            paperModel.setInfYear(postRequest.getInfYear());
            paperModel.setInfCategory(postRequest.getInfCategory());
            paperModel.setInfWhemain_ther(postRequest.getInfWhemain_ther());
            paperModel.setInfAudit(postRequest.getInfAudit());
            paperModel.setInfName(postRequest.getInfName());
            paperModel.setInfLanguage(postRequest.getInfLanguage());
            paperModel.setInfCoop(postRequest.getInfCoop());
            paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
            paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
            paperModel.setInfPubmain_licMonth(postRequest.getInfPubmain_licMonth());
            paperModel.setInfPubmain_licYear(postRequest.getInfPubmain_licYear());
            paperModel.setInfISBN(postRequest.getInfISBN());
            paperModel.setInfPlan(postRequest.getInfPlan());
            paperModel.setPublic(postRequest.isPublic());
            responseList.add(paperModel);
        }


        return responseList;
    }
    public void updateBookData(BookUpdateRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        BookModel paperModel=repo.findByInfNumber(postRequest.getInfNumber());
        if (paperModel==null) {
            System.out.println("Name is null.");
        } else {

            paperModel.setTchSemester(semester);
            paperModel.setTchYear(year);
            paperModel.setLoginModel(paperModel.getLoginModel());
            paperModel.setInfNumber(postRequest.getInfNumber());

            paperModel.setInfYear(postRequest.getInfYear());
            paperModel.setInfCategory(postRequest.getInfCategory());
            paperModel.setInfWhemain_ther(postRequest.getInfWhemain_ther());
            paperModel.setInfAudit(postRequest.getInfAudit());
            paperModel.setInfName(postRequest.getInfName());
            paperModel.setInfLanguage(postRequest.getInfLanguage());
            paperModel.setInfCoop(postRequest.getInfCoop());
            paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
            paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
            paperModel.setInfPubmain_licMonth(postRequest.getInfPubmain_licMonth());
            paperModel.setInfPubmain_licYear(postRequest.getInfPubmain_licYear());
            paperModel.setInfISBN(postRequest.getInfISBN());
            paperModel.setInfPlan(postRequest.getInfPlan());
            paperModel.setPublic(postRequest.isPublic());

            paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
            repo.save(paperModel);
        }




    }
}
