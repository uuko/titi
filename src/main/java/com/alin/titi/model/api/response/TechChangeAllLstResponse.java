package com.alin.titi.model.api.response;

public class TechChangeAllLstResponse {
   private String  tecTransferName="";
   private String tecNumber="";
   private String tecTransfer="";
   private Integer tecId=0;


   public String getTecTransferName() {
      return tecTransferName;
   }

   public void setTecTransferName(String tecTransferName) {
      this.tecTransferName = tecTransferName;
   }

   public String getTecNumber() {
      return tecNumber;
   }

   public void setTecNumber(String tecNumber) {
      this.tecNumber = tecNumber;
   }

   public String getTecTransfer() {
      return tecTransfer;
   }

   public void setTecTransfer(String tecTransfer) {
      this.tecTransfer = tecTransfer;
   }

   public Integer getTecId() {
      return tecId;
   }

   public void setTecId(Integer tecId) {
      this.tecId = tecId;
   }


}
