package com.cirta.software.model;

import com.cirta.software.annotation.Column;
import com.cirta.software.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetaModel<T> {
    private Class<T> aClass;

    public MetaModel(Class<T> clazz) {
        this.aClass = clazz;
    }

    public static <T> MetaModel of(Class<T> clazz) {
        return new MetaModel(clazz);
    }

    public PrimaryKeyField  getPrimaryKey() {
        final Field[] declaredFields = this.aClass.getDeclaredFields();
        for (Field field: declaredFields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if(primaryKey != null){
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }
        throw new IllegalArgumentException("No Primary key Found in class " + aClass.getSimpleName());
    }

    public List<ColumnField> getColumns() {
        final Field[] declaredFields = this.aClass.getDeclaredFields();
        List<ColumnField> columnFields = new ArrayList<>();
        for (Field field: declaredFields) {
            Column column = field.getAnnotation(Column.class);
            if(column != null){
                ColumnField columnField = new ColumnField(field);
                columnFields.add(columnField);
            }
        }
        return columnFields;
    }
}
