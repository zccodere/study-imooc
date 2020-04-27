module com.myimooc.java.sms.file {
    requires com.myimooc.java.sms.model;
    requires com.myimooc.java.sms.persistence;
    provides com.myimooc.java.sms.persistence.PersistenceService with com.myimooc.java.sms.file.PersistenceServiceImpl;
}
