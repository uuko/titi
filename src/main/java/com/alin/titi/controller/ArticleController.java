package com.alin.titi.controller;

import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.model.announce.ArticleAllResponse;
import com.alin.titi.model.announce.ArticleDeleteRequest;
import com.alin.titi.model.announce.ArticleRequest;
import com.alin.titi.model.announce.ArticleResponse;
import com.alin.titi.model.articalpic.ArticlePicResponse;
import com.alin.titi.model.articalpic.BannerAllResponse;
import com.alin.titi.model.base.BaseResponse;
import com.alin.titi.services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleServices articleServices;
    /**
     *  picture
     * */
    @PostMapping("/article/uploadFile")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "exist") Boolean exist,
            @RequestParam(value = "isBanner",required = false) Boolean isBanner,
            @RequestParam(value = "articleId", required=false) Integer articleId
    ) throws Exception {
        if (isBanner==null) isBanner=false;
        ArticlePicResponse response=articleServices.storeNewFile(file,exist,articleId,isBanner);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/article/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws Exception {

        Resource resource = articleServices.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            throw new Exception(""+ex);
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    /**
    * banner
    * */
    // get banner
    @GetMapping("/article/banner")
    public ResponseEntity<?> loadBannerLst() throws Exception {
        BannerAllResponse response=articleServices.loadAllBanner();
        return ResponseEntity.ok(response);
    }
    // delete banner
    @PostMapping("/article/banner/{bannerId}")
    public ResponseEntity<?> deleteBanner(@PathVariable Integer bannerId) throws Exception {
        String response=articleServices.deleteBanner(bannerId);
        if (response.equals("ok")){
            return ResponseEntity.ok(new BaseResponse(response));
        }
        else {
            return ResponseEntity.badRequest().body(new BaseResponse(response));
        }
    }

    /**
     * article
     * */
    @PostMapping("/article")
    public ResponseEntity<?> postArticle(@RequestBody ArticleRequest articleRequest) throws Exception {
       String response= articleServices.saveArticle(articleRequest);
        if (response.contains("Error")){
            return ResponseEntity.badRequest().body(new BaseResponse(response));
        }
        else {
            return ResponseEntity.ok(new BaseResponse(response));

        }
    }

    @GetMapping("/article/latest")
    public ResponseEntity<?> getLatestArticleList(
            @RequestParam(defaultValue = "0") Integer pageNo)
    {
        ArticleAllResponse list = articleServices.getLatestArticleList(pageNo);
        if ( !(list.getResponses().size()>0)){
            return  ResponseEntity.ok(new BaseResponse(""));
        }
        else {
            return  ResponseEntity.ok(list);
        }
    }

    @GetMapping("/article/important")
    public ResponseEntity<?> getImportantArticleList(
            @RequestParam(defaultValue = "0") Integer pageNo)
    {
        ArticleAllResponse list = articleServices.getImportantArticleList(pageNo);
        if ( !(list.getResponses().size()>0)){
            return  ResponseEntity.ok(new BaseResponse(""));
        }
        else {
            return  ResponseEntity.ok(list);
        }
    }


    @GetMapping("/article/tag")
    public ResponseEntity<?> getImportantArticleList(
            @RequestParam(value = "tag") String tag,
            @RequestParam(defaultValue = "0") Integer pageNo)
    {
        ArticleAllResponse list = articleServices.getTagArticleList(pageNo,tag);
        if ( !(list.getResponses().size()>0)){
            return  ResponseEntity.ok(new BaseResponse(""));
        }
        else {
            return  ResponseEntity.ok(list);
        }
    }

    @GetMapping("/article/id/{id}")
    public ResponseEntity<?> getArticleById(
            @PathVariable(value = "id") Integer id)
    {
        ArticleResponse response = articleServices.getArticleById(id);
        if ( response.getArticleId()==null ){
            return  ResponseEntity.badRequest().body(new BaseResponse("error"));
        }
        else {
            return  ResponseEntity.ok(response);
        }
    }

    @PostMapping("/article/update")
    public ResponseEntity<?> editArticleById(
           @RequestBody ArticleRequest request)
    {
        String  response = articleServices.editArticle(request);
        if (! response.equals("ok") ){
            return  ResponseEntity.badRequest().body(new BaseResponse("error:   "+response));
        }
        else {
            return  ResponseEntity.ok(response);
        }
    }

    @PostMapping("/article/delete")
    public ResponseEntity<?> deleteArticleById(
            @RequestBody List<ArticleDeleteRequest> request)
    {
        String  response = articleServices.deleteArticle(request);
        if (! response.equals("ok") ){
            return  ResponseEntity.badRequest().body(new BaseResponse("error:   "+response));
        }
        else {
            return  ResponseEntity.ok(response);
        }
    }
}
