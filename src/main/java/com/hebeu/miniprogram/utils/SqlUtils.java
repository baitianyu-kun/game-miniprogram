package com.hebeu.miniprogram.utils;

import java.lang.reflect.Field;

public class SqlUtils {

    public static void generateMybatisInsertSql(String className,String tableName) {
        String sql_front="insert into "+tableName+" values (";
        try {
            String vars="";
            Class clazz =Class.forName(className);
            Field[] fields=clazz.getDeclaredFields();
            for (int i=0;i<fields.length;i++) {
                String var="";
                if (i!=fields.length-1){
                    var="#{"+fields[i].getName()+"},";
                }else {
                    var="#{"+fields[i].getName()+"}";
                }
                vars=vars+var;
            }
            String sql_end=")";
            String sql_final=sql_front+vars+sql_end;
            System.out.println(sql_final);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


}
