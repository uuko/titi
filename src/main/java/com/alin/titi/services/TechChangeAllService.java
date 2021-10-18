package com.alin.titi.services;

import com.alin.titi.model.*;
import com.alin.titi.model.api.request.TechChgDeleteRequest;
import com.alin.titi.model.api.request.TechChgRequest;
import com.alin.titi.model.api.request.TechgAllPostRequest;
import com.alin.titi.model.api.request.TechgAllResponse;
import com.alin.titi.model.api.response.TechChangeAllLstResponse;
import com.alin.titi.repository.TechChangeRepository;
import com.alin.titi.repository.TechChgeCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class TechChangeAllService {
    @Autowired
    private TechChgeCompanyRepo repo;

    @Autowired
    private TechChangeRepository changeRepository;
    private TechChgeCompanyRepo childRepository;
    public void  changeVisible(ChangeVisibleRequest request){
        Optional<TechChangeModel> model=changeRepository.findById(request.getId());
        model.ifPresent(bookModel -> bookModel.setOpen(request.isVisible()));
    }
    public List<TechChgRequest> getInnerList(Integer id){
        List<TechChgRequest> list=new ArrayList<>();
        List<TechChgeCompanyModel> modelList=repo.findByTechChangeModel(new TechChangeModel(id));
        for (TechChgeCompanyModel techChgRequest:modelList
             ) {
            TechChgRequest model=new TechChgRequest();
            model.setTecEndDate(techChgRequest.getTecEndDate());
            model.setTecStratDate(techChgRequest.getTecStratDate());
            model.setTecTransferAmount(techChgRequest.getTecTransferAmount());
            model.setTecTransferNumber(techChgRequest.getTecTransferNumber());
            model.setTecTransferVendor(techChgRequest.getTecTransferVendor());
            model.setTecCompanyId(techChgRequest.getTecCompanyId());
            list.add(model);
        }
        return list;
    }

    public List<TechChangeAllLstResponse> getList(Integer loginId){
        List<TechChangeModel> list=  changeRepository.findByLoginModel(new LoginModel(loginId));
        List<TechChangeAllLstResponse> responseList=new ArrayList<>();

        for (TechChangeModel model:list){
            TechChangeAllLstResponse response=new TechChangeAllLstResponse();
            response.setTecNumber(model.getTecNumber());
            response.setTecId(model.getTecId());
            response.setTecTransfer(model.getTecTransfer());
            response.setTecTransferName(model.getTecTransferName());

            responseList.add(response);
        }
        return responseList;
    }

    public TechgAllResponse getOne(Integer id){
        TechChangeModel model= changeRepository.findByTecId(id);
        TechgAllResponse response=new TechgAllResponse();
        response.setTecId(model.getTecId());
        response.setTecContentPatent(model.getTecContentPatent());
        response.setTecTransfer(model.getTecTransfer());
        response.setTecTransferName(model.getTecTransferName());
        response.setTecNumber(model.getTecNumber());

        List<TechChgRequest> list = new ArrayList<>(getInnerList(id));
        response.setTechChgeCompanyModelList(list);

        return response;
    }

    public TechChgDeleteRequest  saveOne(TechgAllPostRequest request){
        TechChangeModel model=new TechChangeModel();

        model.setTecId(request.getTecId());
        model.setTecContentPatent(request.getTecContentPatent());
        model.setTecTransfer(request.getTecTransfer());
        model.setTecTransferName(request.getTecTransferName());
        Set<TechChgeCompanyModel> list = new HashSet<>();
        model.setTechChgeCompanyModels(list);
        model.setTecNumber(request.getTecNumber());
        model.setLoginModel(new LoginModel(request.getLoginId()));

        TechChangeModel ol=changeRepository.save(model);
        TechChgDeleteRequest request1=new TechChgDeleteRequest();
        request1.setId(ol.getTecId());
        return request1;

    }

    public void updateOne(TechgAllPostRequest request){
        TechChangeModel model=changeRepository.findByTecId(request.getTecId());
        model.setTecContentPatent(request.getTecContentPatent());
        model.setTecTransfer(request.getTecTransfer());
        model.setTecTransferName(request.getTecTransferName());
        model.setTecNumber(request.getTecNumber());


        changeRepository.save(model);
    }
    public void deleteOne(TechChgDeleteRequest request){
        TechChangeModel model=changeRepository.findByTecId(request.getId());
        List<TechChgeCompanyModel> childmModel = childRepository.findByTechChangeModel(model);
        childRepository.deleteAll(childmModel);
        changeRepository.delete(model);
    }

}
