package com.myimooc.mydatalog.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @title 操作实体类
 * @describe 记录操作信息
 * @author zc
 * @version 1.0 2017-09-13
 */
public class Action {
    private Long id;
    /** 操作对象ID */
    private Long objectId;
    /** 操作对象Class类 */
    private String objectClass;
    /** 操作人员 */
    private String operator;
    /** 操作时间 */
    private Date operateTime;
    /** 操作类型 */
    private ActionType actionType;
    /** 变化字段值集合 */
    private List<ChangeItem> changes = new ArrayList<>();
    
    @Override
	public String toString() {
		return "Action [id=" + id + ", objectId=" + objectId + ", objectClass=" + objectClass + ", operator=" + operator
				+ ", operateTime=" + operateTime + ", actionType=" + actionType + ", changes=" + changes + "]";
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public List<ChangeItem> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeItem> changes) {
        this.changes = changes;
    }
}
