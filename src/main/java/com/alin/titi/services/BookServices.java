package com.alin.titi.services;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.BookModel;
import com.alin.titi.model.api.request.BookRequest;
import com.alin.titi.model.api.request.BookUpdateRequest;
import com.alin.titi.model.api.response.BookResponse;
import com.alin.titi.repository.BookRepository;
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
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
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
        paperModel.setInfWhemainTher(postRequest.getInfWhemainTher());
        paperModel.setInfAudit(postRequest.getInfAudit());
        paperModel.setInfName(postRequest.getInfName());
        paperModel.setinfCorreAuthor(postRequest.getinfCorreAuthor());
        paperModel.setInfLanguage(postRequest.getInfLanguage());
        paperModel.setInfCoop(postRequest.getInfCoop());
        paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
        paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
        paperModel.setInfPubmainLicMonth(postRequest.getInfPubmainLicMonth());
        paperModel.setInfPubmainLicYear(postRequest.getInfPubmainLicYear());
        paperModel.setInfISBN(postRequest.getInfISBN());
        paperModel.setInfPlan(postRequest.getInfPlan());
        paperModel.setOpen(postRequest.ispublic());
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
        paperModel.setinfCorreAuthor(postRequest.getinfCorreAuthor());
        paperModel.setInfWhemainTher(postRequest.getInfWhemainTher());
        paperModel.setInfAudit(postRequest.getInfAudit());
        paperModel.setInfName(postRequest.getInfName());
        paperModel.setInfLanguage(postRequest.getInfLanguage());
        paperModel.setInfCoop(postRequest.getInfCoop());
        paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
        paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
        paperModel.setInfPubmainLicMonth(postRequest.getInfPubmainLicMonth());
        paperModel.setInfPubmainLicYear(postRequest.getInfPubmainLicYear());
        paperModel.setInfISBN(postRequest.getInfISBN());
        paperModel.setInfPlan(postRequest.getInfPlan());
        paperModel.setpublic(postRequest.isOpen());
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
            paperModel.setinfCorreAuthor(postRequest.getinfCorreAuthor());
            paperModel.setInfWhemainTher(postRequest.getInfWhemainTher());
            paperModel.setInfAudit(postRequest.getInfAudit());
            paperModel.setInfName(postRequest.getInfName());
            paperModel.setInfLanguage(postRequest.getInfLanguage());
            paperModel.setInfCoop(postRequest.getInfCoop());
            paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
            paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
            paperModel.setInfPubmainLicMonth(postRequest.getInfPubmainLicMonth());
            paperModel.setInfPubmainLicYear(postRequest.getInfPubmainLicYear());
            paperModel.setInfISBN(postRequest.getInfISBN());
            paperModel.setInfPlan(postRequest.getInfPlan());
            paperModel.setpublic(postRequest.isOpen());
            responseList.add(paperModel);
        }


        return responseList;
    }
    public void updateBookData(BookUpdateRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
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
            paperModel.setinfCorreAuthor(postRequest.getinfCorreAuthor());
            paperModel.setInfYear(postRequest.getInfYear());
            paperModel.setInfCategory(postRequest.getInfCategory());
            paperModel.setInfWhemainTher(postRequest.getInfWhemainTher());
            paperModel.setInfAudit(postRequest.getInfAudit());
            paperModel.setInfName(postRequest.getInfName());
            paperModel.setInfLanguage(postRequest.getInfLanguage());
            paperModel.setInfCoop(postRequest.getInfCoop());
            paperModel.setInfPublishHouse(postRequest.getInfPublishHouse());
            paperModel.setInfAuthorOrder(postRequest.getInfAuthorOrder());
            paperModel.setInfPubmainLicMonth(postRequest.getInfPubmainLicMonth());
            paperModel.setInfPubmainLicYear(postRequest.getInfPubmainLicYear());
            paperModel.setInfISBN(postRequest.getInfISBN());
            paperModel.setInfPlan(postRequest.getInfPlan());
            paperModel.setOpen(postRequest.ispublic());

            paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
            repo.save(paperModel);
        }




    }
}
