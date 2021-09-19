package com.alin.titi.services;

import com.alin.titi.Config;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.model.announce.*;
import com.alin.titi.model.articalpic.ArticlePicModel;
import com.alin.titi.model.articalpic.ArticlePicResponse;
import com.alin.titi.model.articalpic.BannerAllResponse;
import com.alin.titi.model.articalpic.BannerResponse;
import com.alin.titi.repository.ArticlePicRepository;
import com.alin.titi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.SystemException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.chrono.Chronology;
import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class ArticleServices {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticlePicRepository picRepository;

    private final Integer bannerUpperLimit=5;
    private final Integer pageContentSize=15;
    //upload file
    public ArticlePicResponse storeNewFile(MultipartFile multipartFile,boolean isExist,Integer articleId,boolean banner) throws Exception {
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

            ArticleModel endModel;
            //1. 若公告不存在則新增公告
            if (!isExist){
               ArticleModel articleModel=new ArticleModel();
               endModel =articleRepository.saveAndFlush(articleModel);
               System.out.println("Article ID :" + endModel.getArticleId());
            }
            else {
                endModel=articleRepository.findByArticleId(articleId);
            }
            String line0=command;
            String fileExtension="";
            String fileOrgName="";
            fileExtension=orgFileName.substring(orgFileName.lastIndexOf("."));
            fileOrgName=orgFileName.substring(0,orgFileName.lastIndexOf("."));
            newFileName=endModel.getArticleId()+"_"+fileOrgName+"_"+getRandomName()+fileExtension;

            Path targetLocation = fileStoreLocation.resolve(newFileName);
            Files.copy(multipartFile.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);


            if (banner){
                List<ArticlePicModel> list=picRepository.findByBanner(true);
                if (list.size()>=bannerUpperLimit){banner=false;}

            }

            ArticlePicModel checkIfRepeat=picRepository.findByPicUrl(newFileName);
            String fileDownLoadUrL;
            if (checkIfRepeat!=null){
//                System.out.println("newFileName1111111111"+newFileName);
                fileDownLoadUrL = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/article/downloadFile/")
                        .path(newFileName)
                        .toUriString();
                checkIfRepeat.setPicUrl(fileDownLoadUrL);
                checkIfRepeat.setArticleModel(endModel);
                checkIfRepeat.setBanner(banner);
                picRepository.save(checkIfRepeat);
            }else {
//                System.out.println("newFileName22222222222"+newFileName);
                ArticlePicModel picModel=new ArticlePicModel();
                fileDownLoadUrL = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/article/downloadFile/")
                        .path(newFileName)
                        .toUriString();
                picModel.setPicUrl(fileDownLoadUrL);
                picModel.setArticleModel(endModel);
                picModel.setBanner(banner);
                picRepository.save(picModel);
            }
            System.out.println("ArticlePicResponse newFileName"+newFileName);
            ArticlePicResponse response=new ArticlePicResponse();
            response.setArticleId(endModel.getArticleId());
            response.setPicUrl(fileDownLoadUrL);
            response.setBanner(banner);
            return response;

        }
        catch (Exception e){
            throw new Exception("Could not store file " + newFileName + ". Please try again!", e);
        }
    }

    //download file
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

    /**
    *  banner
    * */
    public BannerAllResponse loadAllBanner(){
        List<ArticlePicModel> list=picRepository.findByBanner(true);
        BannerAllResponse allResponse=new BannerAllResponse();
        List<BannerResponse> bannerResponseList=new ArrayList<>();
        for (ArticlePicModel model:list){
            BannerResponse response=new BannerResponse();
            response.setArticleId(model.getArticleModel().getArticleId());
            response.setPicId(model.getPicId());
            response.setPicUrl(model.getPicUrl());
            bannerResponseList.add(response);
        }
        allResponse.setTotalCount(list.size());
        allResponse.setBannerResponseList(bannerResponseList);
        return allResponse;
    }

    public String deleteBanner(Integer bannerId){
       ArticlePicModel picModel=picRepository.findByPicId(bannerId);
       if (picModel==null){
           return "can't find banner";
       }
       picModel.setBanner(false);
       picRepository.save(picModel);
       return "ok";
    }

    /**
     *  article
     * */

    public String  saveArticle(ArticleRequest request){
        try {
            if (request.getBannerUrl().length()>0){
                List<ArticlePicModel> bannerList=picRepository.findByBanner(true);
                if (! (bannerList.size()>=bannerUpperLimit)){
                    ArticlePicModel picModel=
                            picRepository.findByPicUrl(request.getBannerUrl());
                    if (picModel==null){
                        return "picUrl can't find";
                    }
                    else {
                        picModel.setBanner(true);
                        picRepository.save(picModel);
                    }
                }
                else {
                    return "banner size > limit size :   "+bannerUpperLimit;
                }
            }

            ArticleModel articleModel=new ArticleModel();
            if (request.getArticleId()!=null){
                articleModel.setArticleId(request.getArticleId());
            }
            articleModel.setArticleContent(request.getArticleContent());
            articleModel.setArticleImportant(request.getArticleImportant());
            articleModel.setArticleTitle(request.getArticleTitle());
            articleModel.setArticleTag(request.getArticleTag());
            Date date = new Date();
            articleModel.setModifyDate(date);
            ArticleModel endModel=articleRepository.saveAndFlush(articleModel);
            return endModel.getArticleId().toString();
        }
        catch (Exception e){
            return "Error:  "+e;
        }

    }

    public ArticleAllResponse getLatestArticleList(Integer pageNo){


        Pageable paging = PageRequest.of(pageNo, pageContentSize, Sort.by("modifyDate").descending());
        Page<ArticleModel> pagedResult = articleRepository.findAll(paging);
        List<ArticleModel> pageList = new ArrayList<>(pagedResult.getContent());


        List<ArticleResponse> list=new ArrayList<>();
        for (ArticleModel articleModelPage:pageList){
            ArticleResponse lsr=new ArticleResponse();
            lsr.setModifyDate(articleModelPage.getModifyDate());
            lsr.setArticleTag(articleModelPage.getArticleTag());
            lsr.setArticleTitle(articleModelPage.getArticleTitle());
            lsr.setArticleImportant(articleModelPage.getArticleImportant());
            lsr.setArticleContent(articleModelPage.getArticleContent());
            lsr.setArticleId(articleModelPage.getArticleId());
            list.add(lsr);
        }


        ArticleAllResponse articleAllResponse=new ArticleAllResponse();
        articleAllResponse.setPageTotalCount(pagedResult.getTotalPages());
        articleAllResponse.setTotalCount(pagedResult.getTotalElements());
        articleAllResponse.setResponses(list);
        return articleAllResponse;

    }

    public ArticleAllResponse getImportantArticleList(Integer pageNo){

        Pageable paging = PageRequest.of(pageNo, pageContentSize, Sort.by("modifyDate").descending());
        Page<ArticleModel> pagedResult = articleRepository.findByArticleImportant("U",paging);
        List<ArticleModel> pageList = new ArrayList<>(pagedResult.getContent());


        List<ArticleResponse> list=new ArrayList<>();
        for (ArticleModel articleModelPage:pageList){
            ArticleResponse lsr=new ArticleResponse();
            lsr.setModifyDate(articleModelPage.getModifyDate());
            lsr.setArticleTag(articleModelPage.getArticleTag());
            lsr.setArticleTitle(articleModelPage.getArticleTitle());
            lsr.setArticleImportant(articleModelPage.getArticleImportant());
            lsr.setArticleContent(articleModelPage.getArticleContent());
            lsr.setArticleId(articleModelPage.getArticleId());
            list.add(lsr);
        }


        ArticleAllResponse articleAllResponse=new ArticleAllResponse();
        articleAllResponse.setPageTotalCount(pagedResult.getTotalPages());
        articleAllResponse.setTotalCount(pagedResult.getTotalElements());
        articleAllResponse.setResponses(list);
        return articleAllResponse;

    }

    public ArticleAllResponse getTagArticleList(Integer pageNo,String tag){

        Pageable paging = PageRequest.of(pageNo, pageContentSize, Sort.by("modifyDate").descending());
        Page<ArticleModel> pagedResult = articleRepository.findByArticleTag(tag,paging);
        List<ArticleModel> pageList = new ArrayList<>(pagedResult.getContent());


        List<ArticleResponse> list=new ArrayList<>();
        for (ArticleModel articleModelPage:pageList){
            ArticleResponse lsr=new ArticleResponse();
            lsr.setModifyDate(articleModelPage.getModifyDate());
            lsr.setArticleTag(articleModelPage.getArticleTag());
            lsr.setArticleTitle(articleModelPage.getArticleTitle());
            lsr.setArticleImportant(articleModelPage.getArticleImportant());
            lsr.setArticleContent(articleModelPage.getArticleContent());
            lsr.setArticleId(articleModelPage.getArticleId());
            list.add(lsr);
        }


        ArticleAllResponse articleAllResponse=new ArticleAllResponse();
        articleAllResponse.setPageTotalCount(pagedResult.getTotalPages());
        articleAllResponse.setTotalCount(pagedResult.getTotalElements());
        articleAllResponse.setResponses(list);
        return articleAllResponse;

    }

    public ArticleResponse getArticleById(Integer id){
       ArticleModel model= articleRepository.findByArticleId(id);
       ArticleResponse response=new ArticleResponse();
       if (model!=null){
           response.setModifyDate(model.getModifyDate());
           response.setArticleTag(model.getArticleTag());
           response.setArticleTitle(model.getArticleTitle());
           response.setArticleImportant(model.getArticleImportant());
           response.setArticleContent(model.getArticleContent());
           response.setArticleId(model.getArticleId());
       }

        return response;

    }

    public String editArticle(ArticleRequest request){
        ArticleModel model=articleRepository.findByArticleId(request.getArticleId());
        if (model==null){
            return " can't find article";
        }
        else {
            model.setArticleContent(request.getArticleContent());
            model.setArticleImportant(request.getArticleImportant());
            model.setArticleTitle(request.getArticleTitle());
            model.setArticleTag(request.getArticleTag());
            Date date = new Date();
            model.setModifyDate(date);
            articleRepository.save(model);
            return "ok";
        }


    }

    public String deleteArticle(List<ArticleDeleteRequest>  requestList){
        for (int i=0;i<requestList.size();i++){
            ArticleModel model=articleRepository.findByArticleId(requestList.get(i).getArticleId());
            if (model==null){
                return "can't find article";
            }
            else {
                picRepository.deleteByArticleModel(new ArticleModel(requestList.get(i).getArticleId()));
                articleRepository.delete(model);
                if (i==requestList.size()-1){
                    return "ok";
                }

            }
        }
        return "null";

    }
    // get random name
    private String getRandomName() {
        int z;
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < 8; i++) {
            z = (int) ((Math.random() * 7) % 3);

            if (z == 1) { // 放數字
                sb.append((int) ((Math.random() * 10) + 48));
            } else if (z == 2) { // 放大寫英文
                sb.append((char) (((Math.random() * 26) + 65)));
            } else {// 放小寫英文
                sb.append(((char) ((Math.random() * 26) + 97)));
            }
        }
        return sb.toString();
    }
}
