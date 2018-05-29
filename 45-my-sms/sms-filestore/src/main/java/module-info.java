module com.myimooc.sms.filestore {
    requires com.myimooc.sms.model;
    requires com.myimooc.sms.persistence;
    provides com.myimooc.sms.persistence.PersistenceService with com.myimooc.sms.filestore.PersistenceServiceImpl;
}
