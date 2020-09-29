import com.cirta.software.model.ColumnField;
import com.cirta.software.model.MetaModel;
import com.cirta.software.model.Person;
import com.cirta.software.model.PrimaryKeyField;

import java.util.List;

public class PlayWithMetaModel {
    public static void main(String[] args) {
        MetaModel metaModel = MetaModel.of(Person.class);
        PrimaryKeyField primaryKeyField = metaModel.getPrimaryKey();
        List<ColumnField> columnsFields = metaModel.getColumns();

        System.out.println("primary kay name = " + primaryKeyField.getName() + ", type = " + primaryKeyField.getType().getSimpleName());
        for (ColumnField columnField: columnsFields) {
            System.out.println("column name = " + columnField.getName() + ", type = " + columnField.getType().getSimpleName());
        }
    }
}
