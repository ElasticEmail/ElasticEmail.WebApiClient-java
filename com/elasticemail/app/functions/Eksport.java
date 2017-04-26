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
 * 
 */
public class Eksport extends API
{
    /**
     * Check the current status of the export.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param publicExportID 
     * @return ApiTypes.ExportStatus
     * @throws Exception
     */
    public ApiTypes.ExportStatus checkStatus(UUID publicExportID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicExportID", String.valueOf(publicExportID));
       return uploadValues(API_URI + "/eksport/checkstatus", values, ApiTypes.ExportStatus.class);
   }

    /**
     * Summary of export type counts.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.ExportTypeCounts
     * @throws Exception
     */
    public ApiTypes.ExportTypeCounts countByType() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/eksport/countbytype", values, ApiTypes.ExportTypeCounts.class);
   }

    /**
     * Delete the specified export.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param publicExportID 
     * @throws Exception
     */
    public void delete(UUID publicExportID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicExportID", String.valueOf(publicExportID));
       uploadValues(API_URI + "/eksport/delete", values, VoidApiResponse.class);
   }

    /**
     * Returns a list of all exported data.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ExportList
     * @throws Exception
     */
    public ApiTypes.ExportList list(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/eksport/list", values, ApiTypes.ExportList.class);
   }

}

