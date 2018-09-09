package com.imooc.aop.util;

import com.alibaba.fastjson.JSON;
import com.imooc.aop.datalog.Datalog;
import com.imooc.aop.domain.ChangeItem;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DiffUtil {

    private static final Logger logger = LoggerFactory.getLogger(DiffUtil.class);

    public static Object getObjectById(Object target,Object id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method findMethod = target.getClass().getDeclaredMethod("findById", Long.class);
        Object oldObj = findMethod.invoke(target,id);
        return oldObj;
    }

    /**
     * 获取新增操作的change item
     * @param obj
     * @return
     */
    public static List<ChangeItem> getInsertChangeItems(Object obj){
        Map<String,String> valueMap = getBeanSimpleFieldValueMap(obj,true/*filter null*/);
        Map<String,String> fieldCnNameMap = getFieldNameMap(obj.getClass());
        List<ChangeItem> items = new ArrayList<>();
        for(Map.Entry<String,String> entry : valueMap.entrySet()){
            String fieldName = entry.getKey();
            String value = entry.getValue();
            ChangeItem changeItem = new ChangeItem();
            //set old value empty
            changeItem.setOldValue("");
            changeItem.setNewValue(value);
            changeItem.setField(fieldName);
            String cnName = fieldCnNameMap.get(fieldName);
            changeItem.setFieldShowName(StringUtils.isEmpty(cnName) ? fieldName : cnName);
            items.add(changeItem);
        }
        return items;
    }

    /**
     * 获取删除操作的change item
     * @param obj
     * @return
     */
    public static ChangeItem getDeleteChangeItem(Object obj){
        ChangeItem changeItem = new ChangeItem();
        changeItem.setOldValue(JSON.toJSONString(obj));
        changeItem.setNewValue("");
        return changeItem;
    }

    /**
     * 获取更新操作的change item
     * @param oldObj
     * @param newObj
     * @return
     */
    public static List<ChangeItem> getChangeItems(Object oldObj, Object newObj) {
        Class cl = oldObj.getClass();
        List<ChangeItem> changeItems = new ArrayList<ChangeItem>();
        //获取字段中文名称
        Map<String,String> fieldCnNameMap = getFieldNameMap(cl);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(cl, Object.class);

            for (PropertyDescriptor propertyDescriptor : beanInfo
                    .getPropertyDescriptors()) {
                String field = propertyDescriptor.getName();
                //获取字段旧值
                String oldProp = getValue(PropertyUtils.getProperty(oldObj,
                        field));
                //获取字段新值
                String newProp = getValue(PropertyUtils.getProperty(newObj,
                        field));

                //对比新旧值
                if (!oldProp.equals(newProp)) {
                    ChangeItem changeItem = new ChangeItem();
                    changeItem.setField(field);
                    String cnName = fieldCnNameMap.get(field);
                    changeItem.setFieldShowName(StringUtils.isEmpty(cnName) ? field : cnName);
                    changeItem.setNewValue(newProp);
                    changeItem.setOldValue(oldProp);
                    changeItems.add(changeItem);
                }
            }
        } catch (Exception e) {
            logger.error("There is error when convert change item", e);
        }
        return changeItems;
    }

    /**
     * 不同类型转字符串的处理
     * @param obj
     * @return
     */
    public static String getValue(Object obj) {
        if (obj != null) {
            if (obj instanceof Date) {
                return formatDateW3C((Date) obj);
            } else {
                return obj.toString();
            }
        } else {
            return "";
        }
    }

    /**
     * 从注解读取中文名
     * @param clz
     * @return
     */
    public static Map<String,String> getFieldNameMap(Class<?> clz){
        Map<String,String> map = new HashMap<>();
        for (Field field : clz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Datalog.class)) {
                Datalog datalog = field.getAnnotation(Datalog.class);
                map.put(field.getName(),datalog.name());
            }
        }
        return map;
    }

    /**
     * 将date类型转为字符串形式
     * @param date
     * @return
     */
    public static String formatDateW3C(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String text = df.format(date);
        String result = text.substring(0, 22) + ":" + text.substring(22);
        return result;
    }

    /**
     * 获取bean的fieldname和value
     * 只获取简单类型，不获取复杂类型，包括集合
     * @param bean
     * @return
     */
    public static Map<String, String> getBeanSimpleFieldValueMap(Object bean, boolean filterNull) {
        Map<String, String> map = new HashMap<String, String>();
        if (bean == null)
            return map;
        Class<?> clazz = bean.getClass();
        try {
            //不获取父类的字段
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Class<?> fieldType = fields[i].getType();
                String name = fields[i].getName();
                Method method = clazz.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
                Object value = method.invoke(bean);
                if (filterNull && value == null)
                    continue;
                if (isBaseDataType(fieldType)) {
                    String strValue = getFieldStringValue(fieldType,value);
                    map.put(name,strValue);
                }

            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return map;
    }

    /**
     * 自定义不同类型的string值
     * @param type
     * @return
     */
    public static String getFieldStringValue(Class type,Object value){
        if(type.equals(Date.class)){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter.format((Date)value);
        }
        return value.toString();
    }

    /**
     * 判断一个类是否为基本数据类型或包装类，或日期。
     * @param clazz 要判断的类。
     * @return true 表示为基本数据类型。
     */
    public static boolean isBaseDataType(Class clazz) throws Exception {
        return
                (
                        clazz.equals(String.class) ||
                                clazz.equals(Integer.class) ||
                                clazz.equals(Byte.class) ||
                                clazz.equals(Long.class) ||
                                clazz.equals(Double.class) ||
                                clazz.equals(Float.class) ||
                                clazz.equals(Character.class) ||
                                clazz.equals(Short.class) ||
                                clazz.equals(BigDecimal.class) ||
                                clazz.equals(BigInteger.class) ||
                                clazz.equals(Boolean.class) ||
                                clazz.equals(Date.class) ||
                                clazz.isPrimitive()
                );
    }
}
