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
 * Methods used to manage your Contacts.
 */
public class Contact extends API
{
    /**
     * Activate contacts that are currently blocked.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param activateAllBlocked Activate all your blocked contacts.  Passing True will override email list and activate all your blocked contacts.
     * @param emails Comma delimited list of contact emails
     * @throws Exception
     */
    public void activateBlocked(Boolean activateAllBlocked, StringList emails) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("activateAllBlocked", String.valueOf(activateAllBlocked));
       if (emails != null) values.put("emails", joinList(emails));
       uploadValues(API_URI + "/contact/activateblocked", values, VoidApiResponse.class);
   }

    /**
     * Add a new contact and optionally to one of your lists.  Note that your API KEY is not required for this call.
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @param email Proper email address.
     * @param publicListID ID code of list
     * @param listName Name of your list.
     * @param title Title
     * @param firstName First name.
     * @param lastName Last name.
     * @param phone Phone number
     * @param mobileNumber Mobile phone number
     * @param notes Free form field of notes
     * @param gender Your gender
     * @param birthDate Date of birth in YYYY-MM-DD format
     * @param city City.
     * @param state State or province.
     * @param postalCode Zip/postal code.
     * @param country Name of country.
     * @param organizationName Name of organization
     * @param website HTTP address of your website.
     * @param annualRevenue Annual revenue of contact
     * @param industry Industry contact works in
     * @param numberOfEmployees Number of employees
     * @param source Specifies the way of uploading the contact
     * @param returnUrl URL to navigate to after account creation
     * @param sourceUrl URL from which request was sent.
     * @param activationReturnUrl The url to return the contact to after activation.
     * @param activationTemplate 
     * @param sendActivation True, if you want to send activation email to this account. Otherwise, false
     * @param consentDate Date of consent to send this contact(s) your email. If not provided current date is used for consent.
     * @param consentIP IP address of consent to send this contact(s) your email. If not provided your current public IP address is used for consent.
     * @param field Custom contact field like firstname, lastname, city etc. Request parameters prefixed by field_ like field_firstname, field_lastname 
     * @param notifyEmail Emails, separated by semicolon, to which the notification about contact subscribing should be sent to
     * @return String
     * @throws Exception
     */
    public String add(String publicAccountID, String email, String[] publicListID, String[] listName, String title, String firstName, String lastName, String phone, String mobileNumber, String notes, String gender, Date birthDate, String city, String state, String postalCode, String country, String organizationName, String website, int annualRevenue, String industry, int numberOfEmployees, ApiTypes.ContactSource source, String returnUrl, String sourceUrl, String activationReturnUrl, String activationTemplate, Boolean sendActivation, Date consentDate, String consentIP, HashMap<String, String> field, String notifyEmail) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("publicAccountID", publicAccountID);
       values.put("email", email);
       values.put("publicListID", String.valueOf(publicListID));
       values.put("listName", String.valueOf(listName));
       values.put("title", title);
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("phone", phone);
       values.put("mobileNumber", mobileNumber);
       values.put("notes", notes);
       values.put("gender", gender);
       if (birthDate != null) values.put("birthDate", String.valueOf(birthDate));
       values.put("city", city);
       values.put("state", state);
       values.put("postalCode", postalCode);
       values.put("country", country);
       values.put("organizationName", organizationName);
       values.put("website", website);
       values.put("annualRevenue", String.valueOf(annualRevenue));
       values.put("industry", industry);
       values.put("numberOfEmployees", String.valueOf(numberOfEmployees));
       values.put("source", String.valueOf(source));
       values.put("returnUrl", returnUrl);
       values.put("sourceUrl", sourceUrl);
       values.put("activationReturnUrl", activationReturnUrl);
       values.put("activationTemplate", activationTemplate);
       values.put("sendActivation", String.valueOf(sendActivation));
       if (consentDate != null) values.put("consentDate", String.valueOf(consentDate));
       values.put("consentIP", consentIP);
       if (field != null) values.put("field", String.valueOf(field));
       values.put("notifyEmail", notifyEmail);
       return uploadValues(API_URI + "/contact/add", values, String.class);
   }

    /**
     * Manually add or update a contacts status to Abuse, Bounced or Unsubscribed status (blocked).
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @throws Exception
     */
    public void addBlocked(String email, ApiTypes.ContactStatus status) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("status", String.valueOf(status));
       uploadValues(API_URI + "/contact/addblocked", values, VoidApiResponse.class);
   }

    /**
     * Change any property on the contact record.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @param name Name of the contact property you want to change.
     * @param value Value you would like to change the contact property to.
     * @throws Exception
     */
    public void changeProperty(String email, String name, String value) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("name", name);
       values.put("value", value);
       uploadValues(API_URI + "/contact/changeproperty", values, VoidApiResponse.class);
   }

    /**
     * Changes status of selected Contacts. You may provide RULE for selection or specify list of Contact IDs.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @throws Exception
     */
    public void changeStatus(ApiTypes.ContactStatus status, String rule, StringList emails, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("status", String.valueOf(status));
       values.put("rule", rule);
       if (emails != null) values.put("emails", joinList(emails));
       values.put("allContacts", String.valueOf(allContacts));
       uploadValues(API_URI + "/contact/changestatus", values, VoidApiResponse.class);
   }

    /**
     * Returns number of Contacts, RULE specifies contact Status.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param rule Query used for filtering.
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @return ApiTypes.ContactStatusCounts
     * @throws Exception
     */
    public ApiTypes.ContactStatusCounts countByStatus(String rule, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("rule", rule);
       values.put("allContacts", String.valueOf(allContacts));
       return uploadValues(API_URI + "/contact/countbystatus", values, ApiTypes.ContactStatusCounts.class);
   }

    /**
     * Permanantly deletes the contacts provided.  You can provide either a qualified rule or a list of emails (comma separated string).
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @throws Exception
     */
    public void delete(String rule, StringList emails, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("rule", rule);
       if (emails != null) values.put("emails", joinList(emails));
       values.put("allContacts", String.valueOf(allContacts));
       uploadValues(API_URI + "/contact/delete", values, VoidApiResponse.class);
   }

    /**
     * Export selected Contacts to JSON.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param fileFormat 
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file.
     * @return ApiTypes.ExportLink
     * @throws Exception
     */
    public ApiTypes.ExportLink export(ApiTypes.ExportFileFormats fileFormat, String rule, StringList emails, Boolean allContacts, ApiTypes.CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("rule", rule);
       if (emails != null) values.put("emails", joinList(emails));
       values.put("allContacts", String.valueOf(allContacts));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/contact/export", values, ApiTypes.ExportLink.class);
   }

    /**
     * Finds all Lists and Segments this email belongs to.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @return ApiTypes.ContactCollection
     * @throws Exception
     */
    public ApiTypes.ContactCollection findContact(String email) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       return uploadValues(API_URI + "/contact/findcontact", values, ApiTypes.ContactCollection.class);
   }

    /**
     * List of Contacts for provided List
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param listName Name of your list.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ContactList
     * @throws Exception
     */
    public ApiTypes.ContactList getContactsByList(String listName, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/contact/getcontactsbylist", values, ApiTypes.ContactList.class);
   }

    /**
     * List of Contacts for provided Segment
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param segmentName Name of your segment.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ContactList
     * @throws Exception
     */
    public ApiTypes.ContactList getContactsBySegment(String segmentName, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/contact/getcontactsbysegment", values, ApiTypes.ContactList.class);
   }

    /**
     * List of all contacts. If you have not specified RULE, all Contacts will be listed.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param rule Query used for filtering.
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ContactList
     * @throws Exception
     */
    public ApiTypes.ContactList list(String rule, Boolean allContacts, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("rule", rule);
       values.put("allContacts", String.valueOf(allContacts));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/contact/list", values, ApiTypes.ContactList.class);
   }

    /**
     * Load blocked contacts
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param statuses List of comma separated message statuses: 0 or all, 1 for ReadyToSend, 2 for InProgress, 4 for Bounced, 5 for Sent, 6 for Opened, 7 for Clicked, 8 for Unsubscribed, 9 for Abuse Report
     * @param search List of blocked statuses: Abuse, Bounced or Unsubscribed
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.BlockedContactList
     * @throws Exception
     */
    public ApiTypes.BlockedContactList loadBlocked(ApiTypes.ContactStatusList statuses, String search, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (statuses != null) values.put("statuses", joinList(statuses));
       values.put("search", search);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/contact/loadblocked", values, ApiTypes.BlockedContactList.class);
   }

    /**
     * Load detailed contact information
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @return ApiTypes.Contact
     * @throws Exception
     */
    public ApiTypes.Contact loadContact(String email) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       return uploadValues(API_URI + "/contact/loadcontact", values, ApiTypes.Contact.class);
   }

    /**
     * Shows detailed history of chosen Contact.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ContactHistoryList
     * @throws Exception
     */
    public ApiTypes.ContactHistoryList loadHistory(String email, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/contact/loadhistory", values, ApiTypes.ContactHistoryList.class);
   }

    /**
     * Add new Contact to one of your Lists.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param emails Comma delimited list of contact emails
     * @param firstName First name.
     * @param lastName Last name.
     * @param title Title
     * @param organization Name of organization
     * @param industry Industry contact works in
     * @param city City.
     * @param country Name of country.
     * @param state State or province.
     * @param zip Zip/postal code.
     * @param publicListID ID code of list
     * @param listName Name of your list.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @param notes Free form field of notes
     * @param consentDate Date of consent to send this contact(s) your email. If not provided current date is used for consent.
     * @param consentIP IP address of consent to send this contact(s) your email. If not provided your current public IP address is used for consent.
     * @param notifyEmail Emails, separated by semicolon, to which the notification about contact subscribing should be sent to
     * @throws Exception
     */
    public void quickAdd(StringList emails, String firstName, String lastName, String title, String organization, String industry, String city, String country, String state, String zip, String publicListID, String listName, ApiTypes.ContactStatus status, String notes, Date consentDate, String consentIP, String notifyEmail) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (emails != null) values.put("emails", joinList(emails));
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("title", title);
       values.put("organization", organization);
       values.put("industry", industry);
       values.put("city", city);
       values.put("country", country);
       values.put("state", state);
       values.put("zip", zip);
       values.put("publicListID", publicListID);
       values.put("listName", listName);
       values.put("status", String.valueOf(status));
       values.put("notes", notes);
       if (consentDate != null) values.put("consentDate", String.valueOf(consentDate));
       values.put("consentIP", consentIP);
       values.put("notifyEmail", notifyEmail);
       uploadValues(API_URI + "/contact/quickadd", values, VoidApiResponse.class);
   }

    /**
     * Update selected contact. Omitted contact's fields will be reset by default (see the clearRestOfFields parameter)
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @param firstName First name.
     * @param lastName Last name.
     * @param organizationName Name of organization
     * @param title Title
     * @param city City.
     * @param state State or province.
     * @param country Name of country.
     * @param zip Zip/postal code.
     * @param birthDate Date of birth in YYYY-MM-DD format
     * @param gender Your gender
     * @param phone Phone number
     * @param activate True, if Contact should be activated. Otherwise, false
     * @param industry Industry contact works in
     * @param numberOfEmployees Number of employees
     * @param annualRevenue Annual revenue of contact
     * @param purchaseCount Number of purchases contact has made
     * @param firstPurchase Date of first purchase in YYYY-MM-DD format
     * @param lastPurchase Date of last purchase in YYYY-MM-DD format
     * @param notes Free form field of notes
     * @param websiteUrl Website of contact
     * @param mobileNumber Mobile phone number
     * @param faxNumber Fax number
     * @param linkedInBio Biography for Linked-In
     * @param linkedInConnections Number of Linked-In connections
     * @param twitterBio Biography for Twitter
     * @param twitterUsername User name for Twitter
     * @param twitterProfilePhoto URL for Twitter photo
     * @param twitterFollowerCount Number of Twitter followers
     * @param pageViews Number of page views
     * @param visits Number of website visits
     * @param clearRestOfFields States if the fields that were omitted in this request are to be reset or should they be left with their current value
     * @param field Custom contact field like firstname, lastname, city etc. Request parameters prefixed by field_ like field_firstname, field_lastname 
     * @return ApiTypes.Contact
     * @throws Exception
     */
    public ApiTypes.Contact update(String email, String firstName, String lastName, String organizationName, String title, String city, String state, String country, String zip, String birthDate, String gender, String phone, Boolean activate, String industry, int numberOfEmployees, String annualRevenue, int purchaseCount, String firstPurchase, String lastPurchase, String notes, String websiteUrl, String mobileNumber, String faxNumber, String linkedInBio, int linkedInConnections, String twitterBio, String twitterUsername, String twitterProfilePhoto, int twitterFollowerCount, int pageViews, int visits, Boolean clearRestOfFields, HashMap<String, String> field) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("organizationName", organizationName);
       values.put("title", title);
       values.put("city", city);
       values.put("state", state);
       values.put("country", country);
       values.put("zip", zip);
       values.put("birthDate", birthDate);
       values.put("gender", gender);
       values.put("phone", phone);
       values.put("activate", String.valueOf(activate));
       values.put("industry", industry);
       values.put("numberOfEmployees", String.valueOf(numberOfEmployees));
       values.put("annualRevenue", annualRevenue);
       values.put("purchaseCount", String.valueOf(purchaseCount));
       values.put("firstPurchase", firstPurchase);
       values.put("lastPurchase", lastPurchase);
       values.put("notes", notes);
       values.put("websiteUrl", websiteUrl);
       values.put("mobileNumber", mobileNumber);
       values.put("faxNumber", faxNumber);
       values.put("linkedInBio", linkedInBio);
       values.put("linkedInConnections", String.valueOf(linkedInConnections));
       values.put("twitterBio", twitterBio);
       values.put("twitterUsername", twitterUsername);
       values.put("twitterProfilePhoto", twitterProfilePhoto);
       values.put("twitterFollowerCount", String.valueOf(twitterFollowerCount));
       values.put("pageViews", String.valueOf(pageViews));
       values.put("visits", String.valueOf(visits));
       values.put("clearRestOfFields", String.valueOf(clearRestOfFields));
       if (field != null) values.put("field", String.valueOf(field));
       return uploadValues(API_URI + "/contact/update", values, ApiTypes.Contact.class);
   }

    /**
     * Upload contacts in CSV file.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param contactFile Name of CSV file with Contacts.
     * @param allowUnsubscribe True: Allow unsubscribing from this (optional) newly created list. Otherwise, false
     * @param listID ID number of selected list.
     * @param listName Name of your list to upload contacts to, or how the new, automatically created list should be named
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @param consentDate Date of consent to send this contact(s) your email. If not provided current date is used for consent.
     * @param consentIP IP address of consent to send this contact(s) your email. If not provided your current public IP address is used for consent.
     * @return int
     * @throws Exception
     */
    public int upload(FileData contactFile, Boolean allowUnsubscribe, int listID, String listName, ApiTypes.ContactStatus status, Date consentDate, String consentIP) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("allowUnsubscribe", String.valueOf(allowUnsubscribe));
       values.put("listID", String.valueOf(listID));
       values.put("listName", listName);
       values.put("status", String.valueOf(status));
       if (consentDate != null) values.put("consentDate", String.valueOf(consentDate));
       values.put("consentIP", consentIP);
       return httpPostFile(API_URI + "/contact/upload", Arrays.asList(contactFile), values, int.class);
   }

}

