package com.elasticemail.app.functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Date;

import java.util.UUID;

import com.elasticemail.app.API;
import com.elasticemail.app.ApiTypes;
import com.elasticemail.app.ApiTypes.*;
import com.elasticemail.app.FileData;
import com.elasticemail.app.APIResponse.VoidApiResponse;

/**
 * Managing attachments uploaded to your account.
 */
public class Attachment extends API
{
    /**
     * Permanently deletes attachment file from your account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param attachmentID ID number of your attachment.
     * @throws Exception
     */
    public void delete(long attachmentID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("attachmentID", String.valueOf(attachmentID));
       uploadValues(API_URI + "/attachment/delete", values, VoidApiResponse.class);
   }

    /**
     * Gets address of chosen Attachment
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param fileName Name of your file.
     * @param attachmentID ID number of your attachment.
     * @return FileData
     * @throws Exception
     */
    public FileData get(String fileName, long attachmentID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("fileName", fileName);
       values.put("attachmentID", String.valueOf(attachmentID));
       return uploadValues(API_URI + "/attachment/get", values, FileData.class);
   }

    /**
     * Lists your available Attachments in the given email
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param msgID ID number of selected message.
     * @return ApiTypes.AttachmentArray
     * @throws Exception
     */
    public ApiTypes.AttachmentArray list(String msgID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("msgID", msgID);
       return uploadValues(API_URI + "/attachment/list", values, ApiTypes.AttachmentArray.class);
   }

    /**
     * Lists all your available attachments
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.AttachmentArray
     * @throws Exception
     */
    public ApiTypes.AttachmentArray listAll() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/attachment/listall", values, ApiTypes.AttachmentArray.class);
   }

    /**
     * Permanently removes attachment file from your account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param fileName Name of your file.
     * @throws Exception
     */
    public void remove(String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("fileName", fileName);
       uploadValues(API_URI + "/attachment/remove", values, VoidApiResponse.class);
   }

    /**
     * Uploads selected file to the server using http form upload format (MIME multipart/form-data) or PUT method. The attachments expire after 30 days.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param attachmentFile Content of your attachment.
     * @return ApiTypes.Attachment
     * @throws Exception
     */
    public ApiTypes.Attachment upload(FileData attachmentFile) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return httpPostFile(API_URI + "/attachment/upload", Arrays.asList(attachmentFile), values, ApiTypes.Attachment.class);
   }

}

